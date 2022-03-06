package uz.pdp.pdpfood.entity.meal;


import uz.pdp.pdpfood.entity.Auditable;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "meal", schema = "food")
public class Meal extends Auditable {
    @NotNull
    private String name;
    @Column(unique = true, nullable = false)
    private String image;
    private boolean deleted;
    private Long typeId;
}
