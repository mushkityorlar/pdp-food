package uz.pdp.pdpfood.entity.department;

import uz.pdp.pdpfood.entity.Auditable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "department", schema = "food")
public class Department extends Auditable {
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String code;
    private Long userId;
    private Long chatId;
}
