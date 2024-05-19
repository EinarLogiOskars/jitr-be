package is.jitr.dto;

import java.time.LocalDateTime;

public class ShiftDTO {

    private Integer workTypeId;
    private Long propertyId;
    private String shiftDetails;
    private LocalDateTime estimatedShiftStart;
    private LocalDateTime estimatedShiftEnd;

    public ShiftDTO(Integer workTypeId, Long propertyId, String shiftDetails, LocalDateTime estimatedShiftStart,
            LocalDateTime estimatedShiftEnd) {
        this.workTypeId = workTypeId;
        this.propertyId = propertyId;
        this.shiftDetails = shiftDetails;
        this.estimatedShiftStart = estimatedShiftStart;
        this.estimatedShiftEnd = estimatedShiftEnd;
    }

    public Integer getWorkTypeId() {
        return workTypeId;
    }

    public void setWorkTypeId(Integer workTypeId) {
        this.workTypeId = workTypeId;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public String getShiftDetails() {
        return shiftDetails;
    }

    public void setShiftDetails(String shiftDetails) {
        this.shiftDetails = shiftDetails;
    }

    public LocalDateTime getEstimatedShiftStart() {
        return estimatedShiftStart;
    }

    public void setEstimatedShiftStart(LocalDateTime estimatedShiftStart) {
        this.estimatedShiftStart = estimatedShiftStart;
    }

    public LocalDateTime getEstimatedShiftEnd() {
        return estimatedShiftEnd;
    }

    public void setEstimatedShiftEnd(LocalDateTime estimatedShiftEnd) {
        this.estimatedShiftEnd = estimatedShiftEnd;
    }

}
