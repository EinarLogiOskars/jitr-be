package is.jitr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import is.jitr.model.Shift;

public interface ShiftRepository extends JpaRepository<Shift, Long> {

    @Query("SELECT s FROM Shift s JOIN s.property p WHERE p.businessDetails.id = :businessId")
    List<Shift> findAllByBusinessId(Long businessId);

    @Query("SELECT COUNT(b) > 0 FROM Shift s JOIN s.property p JOIN p.businessDetails b WHERE s.id = :shiftId AND b.user.username = :username")
    boolean isOwnedBy(Long shiftId, String username);

}
