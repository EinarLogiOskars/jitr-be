package is.jitr.service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import is.jitr.dto.ShiftDTO;
import is.jitr.model.Shift;
import is.jitr.repository.ShiftRepository;

@Service
public class ShiftService {

    @Autowired
    private ShiftRepository repository;

    @Transactional
    public Shift createShift(ShiftDTO shiftDTO) {
        Shift shift = new Shift();
        shift.setWorkTypeId(shiftDTO.getWorkTypeId());
        shift.setPropertyId(shiftDTO.getPropertyId());
        shift.setShiftDetails(shiftDTO.getShiftDetails());
        shift.setEstimatedShiftStart(shiftDTO.getEstimatedShiftStart());
        shift.setEstimatedShiftEnd(shiftDTO.getEstimatedShiftEnd());
        return repository.save(shift);
    }

    public Shift findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Shift with id " + id + " not found."));
    }
}
