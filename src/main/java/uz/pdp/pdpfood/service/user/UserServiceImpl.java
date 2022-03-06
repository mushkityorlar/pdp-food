package uz.pdp.pdpfood.service.user;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import uz.pdp.pdpfood.configs.encryption.PasswordEncryption;
import uz.pdp.pdpfood.configs.security.utils.JwtUtils;
import uz.pdp.pdpfood.dto.user.UserCreateDto;
import uz.pdp.pdpfood.dto.user.UserDto;
import uz.pdp.pdpfood.dto.user.UserUpdateDto;
import uz.pdp.pdpfood.entity.user.AuthUser;
import uz.pdp.pdpfood.entity.user.Role;
import uz.pdp.pdpfood.mapper.UserMapper;
import uz.pdp.pdpfood.repository.RoleRepository;
import uz.pdp.pdpfood.repository.UserRepository;
import uz.pdp.pdpfood.service.AbstractService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MimeTypeUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Service
@Slf4j
@Transactional
public class UserServiceImpl extends AbstractService<UserRepository, UserMapper> implements UserService {

    private final PasswordEncryption encryption;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository repository, UserMapper mapper, PasswordEncryption encryption, RoleRepository roleRepository) {
        super(repository, mapper);
        this.encryption = encryption;
        this.roleRepository = roleRepository;
    }

    @Override
    public Long create(UserCreateDto createDto) {
        log.info("saving user {}", createDto.getUsername());
        AuthUser user = mapper.fromCreateDto(createDto);
        repository.save(user);
        return user.getId();
    }

    @Override
    public UserDto update(Long id, UserUpdateDto updateDto) {
        AuthUser user = mapper.fromUpdateDto(updateDto);
        repository.save(user);
        return mapper.toDto(user);
    }

    @Override
    public Void delete(Long id) {
        repository.delete(id);
        return null;
    }

    @Override
    public List<UserDto> getAll() {
        log.info("fetching all users");
        List<AuthUser> users = repository.findAll();
        return mapper.toDto(users);
    }

    @Override
    public UserDto get(Long id) {
        Optional<AuthUser> user = repository.findById(id);
        return mapper.toDto(user.get());
    }

    @Override
    public void activate(Long id) {
        repository.activate(id);
    }

    @Override
    public void block(Long id) {
        repository.block(id);
    }

    @Override
    public void unblock(Long id) {
        repository.unblock(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthUser user = repository.findByUsername(username);
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities(user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getCode())).toList())
                .build();
    }

    @Override
    public Role saveRole(Role role) {
        log.info("saving role {}", role.getCode());
        return roleRepository.save(role);
    }

    @Override
    public void attachRoleToUser(String username, String roleCode) {
        AuthUser user = repository.findByUsername(username);
        Role role = roleRepository.findByCode(roleCode);
        user.getRoles().add(role);
        repository.save(user);
        log.info("Attaching role {} to user {}", roleCode, username);
    }

    @Override
    public UserDto getUserByUsername(String username) {
        log.info("Getting user by username : {}", username);
        return mapper.toDto(repository.findByUsername(username));
    }


    @Override
    public void getRefreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorizationHeader = request.getHeader(AUTHORIZATION);
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            try {
                String refresh_token = authorizationHeader.substring("Bearer ".length());
                Algorithm algorithm = JwtUtils.getAlgorithm();
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(refresh_token);
                String username = decodedJWT.getSubject();
                UserDto user = getUserByUsername(username);

                String access_token = JWT.create()
                        .withSubject(user.getUsername())
                        .withExpiresAt(JwtUtils.getExpiry())
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("roles", user.getRoles().stream().map(Role::getCode).toList())
                        .sign(algorithm);

                Map<String, String> tokens = new HashMap<>();
                tokens.put("access_token", access_token);
                tokens.put("refresh_token", refresh_token);
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), tokens);
            } catch (Exception exception) {
                response.setHeader("error", exception.getMessage());
                response.setStatus(HttpStatus.FORBIDDEN.value());
                //response.sendError(FORBIDDEN.value());
                Map<String, String> error = new HashMap<>();
                error.put("error_message", exception.getMessage());
                response.setContentType(MimeTypeUtils.APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), error);
            }
        } else {
            throw new RuntimeException("Refresh token is missing");
        }
    }

}
