package is.jitr.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import is.jitr.model.WorkTypes;

public interface WorkTypesRepository extends JpaRepository<WorkTypes, Long> {

}
