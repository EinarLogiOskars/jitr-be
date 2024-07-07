package is.jitr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import is.jitr.model.Property;

public interface PropertyRepository extends JpaRepository<Property, Long> {

    @Query("SELECT p FROM Property p WHERE p.businessDetails.user.id = :userId")
    List<Property> findByUserId(@Param("userId") Long userId);

    List<Property> findByBusinessDetailsId(Long businessId);

    @Query("SELECT COUNT(b) > 0 FROM Property p JOIN p.businessDetails b WHERE p.id = :propertyId AND b.user.username = :username")
    boolean isOwnedBy(Long propertyId, String username);
}
