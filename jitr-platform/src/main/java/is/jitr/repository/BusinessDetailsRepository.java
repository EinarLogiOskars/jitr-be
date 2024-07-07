package is.jitr.repository;

import java.util.List;
import is.jitr.model.BusinessDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BusinessDetailsRepository extends JpaRepository<BusinessDetails, Long> {

    List<BusinessDetails> findByUserId(Long userId);

    @Query("SELECT COUNT(b) > 0 FROM BusinessDetails b WHERE b.id = :businessId AND b.user.username = :username")
    boolean isOwnedBy(Long businessId, String username);

}
