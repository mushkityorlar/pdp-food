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
@Entity
@Table(name = "order", schema = "food")
public class Order extends Auditable {
    private Date date;
    private boolean rejected;
    private boolean received;
    private Long userId;
    private Long mealId;
}
