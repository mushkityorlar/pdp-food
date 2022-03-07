package uz.pdp.pdpfood.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.pdp.pdpfood.entity.complaint.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintRepository extends JpaRepository<Complaint, Long>, AbstractRepository {
    @Query(value = "update Complaint set deleted = true where id =:complainId")
    void delete(@Param("complainId") Long id);
}
