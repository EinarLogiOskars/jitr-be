package is.jitr.mapper;

import java.util.List;
import java.util.stream.Collectors;

import is.jitr.dto.ShiftDTO;
import is.jitr.model.Shift;

public class ShiftMapper {

    public static ShiftDTO toDTO(Shift shift) {
        ShiftDTO dto = new ShiftDTO();
        dto.setId(shift.getId());
        dto.setWorkTypeId(shift.getWorkTypeId());
        dto.setPropertyId(shift.getProperty().getId());
        dto.setShiftDetails(shift.getShiftDetails());
        dto.setEstimatedShiftStart(shift.getEstimatedShiftStart());
        dto.setShiftStart(shift.getShiftStart());
        dto.setEstimatedShiftEnd(shift.getEstimatedShiftEnd());
        dto.setShiftEnd(shift.getShiftEnd());
        dto.setStatus(shift.getStatus());
        return dto;
    }

    public static List<ShiftDTO> toDTOs(List<Shift> shifts) {
        return shifts.stream().map(ShiftMapper::toDTO).collect(Collectors.toList());
    }
}
