package uz.pdp.pdpfood.repository;

import uz.pdp.pdpfood.entity.complaint.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintRepository extends JpaRepository<Complaint,Long>, AbstractRepository {
}
