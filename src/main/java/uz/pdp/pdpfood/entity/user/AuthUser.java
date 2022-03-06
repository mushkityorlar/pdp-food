package uz.pdp.pdpfood.entity.user;

import uz.pdp.pdpfood.entity.Auditable;
import uz.pdp.pdpfood.enums.Language;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "auth_users", schema = "auth")
public class AuthUser extends Auditable {
    private String username;
    private String password;
    private String fullName;
    private String phoneNumber;
    private String language;
    private String chatId;
    private Long departmentId;
    private boolean active;
    private boolean blocked;
    private boolean deleted;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = Collections.emptyList();

    public AuthUser(Long id, LocalDateTime createdAt, Long createdBy, LocalDateTime updatedAt, Long updatedBy, String username, String password, String fullName, String phoneNumber, String language, String chatId, Long departmentId, boolean active, boolean blocked, boolean deleted) {
        super(id, createdAt, createdBy, updatedAt, updatedBy);
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.language = Language.RUSSIAN.getCode();
        this.chatId = chatId;
        this.departmentId = departmentId;
        this.active = active;
        this.blocked = blocked;
        this.deleted = deleted;
    }
}
