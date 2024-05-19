package is.jitr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import is.jitr.model.Shift;

public interface ShiftRepository extends JpaRepository<Shift, Long> {

}
