package is.jitr.repository;

import java.util.List;
import is.jitr.model.BusinessDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessDetailsRepository extends JpaRepository<BusinessDetails, Long> {

    List<BusinessDetails> findByUserId(Long userId);

}
