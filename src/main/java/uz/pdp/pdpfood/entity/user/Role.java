package uz.pdp.pdpfood.entity.user;

import uz.pdp.pdpfood.entity.Auditable;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "auth_role", schema = "auth")
public class Role extends Auditable {

    @Column(name = "role_code")
    private String code;

}
