package uz.pdp.pdpfood.entity.meal;

import uz.pdp.pdpfood.entity.Auditable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "menu", schema = "food")
@Entity
public class Menu extends Auditable {
    private Date date;
    private Long mealId;
}
