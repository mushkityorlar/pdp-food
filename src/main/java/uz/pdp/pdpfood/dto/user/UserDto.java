package uz.pdp.pdpfood.dto.user;

import uz.pdp.pdpfood.dto.GenericDto;
import uz.pdp.pdpfood.entity.user.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserDto extends GenericDto {
    private String username;
    private String password;
    private String fullName;
    private String phoneNumber;
    private List <Role> roles;
    private String language;
    private String chatId;
    private Long departmentId;
    private boolean active;
    private boolean blocked;
    private boolean deleted;


    @Builder(builderMethodName = "childBuilder")

    public UserDto(Long id, String username, String password, String fullName, String phoneNumber, List<Role> roles, String language, String chatId, Long departmentId, boolean active, boolean blocked, boolean deleted) {
        super(id);
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.roles = roles;
        this.language = language;
        this.chatId = chatId;
        this.departmentId = departmentId;
        this.active = active;
        this.blocked = blocked;
        this.deleted = deleted;
    }
}
