package uz.pdp.pdpfood.entity.complaint;

import uz.pdp.pdpfood.entity.Auditable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "complaint", schema = "food")
public class Complaint extends Auditable {
    private String text;
    private boolean deleted;
    private Long userId;
}
