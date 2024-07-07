package is.jitr.dto;

import java.time.LocalDateTime;

import is.jitr.model.ShiftStatus;

public class ShiftDTO {

    private Long id;
    private Integer workTypeId;
    private Long propertyId;
    private Long filledByUserId;
    private String shiftDetails;
    private LocalDateTime estimatedShiftStart;
    private LocalDateTime shiftStart;
    private LocalDateTime estimatedShiftEnd;
    private LocalDateTime shiftEnd;
    private ShiftStatus status;

    public ShiftDTO() {
    }

    public ShiftDTO(Integer workTypeId, Long propertyId, String shiftDetails, LocalDateTime estimatedShiftStart,
            LocalDateTime estimatedShiftEnd) {
        this.workTypeId = workTypeId;
        this.propertyId = propertyId;
        this.shiftDetails = shiftDetails;
        this.estimatedShiftStart = estimatedShiftStart;
        this.estimatedShiftEnd = estimatedShiftEnd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ShiftStatus getStatus() {
        return status;
    }

    public void setStatus(ShiftStatus status) {
        this.status = status;
    }

    public LocalDateTime getShiftStart() {
        return shiftStart;
    }

    public void setShiftStart(LocalDateTime shiftStart) {
        this.shiftStart = shiftStart;
    }

    public LocalDateTime getShiftEnd() {
        return shiftEnd;
    }

    public void setShiftEnd(LocalDateTime shiftEnd) {
        this.shiftEnd = shiftEnd;
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

    public Long getFilledByUserId() {
        return filledByUserId;
    }

    public void setFilledByUserId(Long filledByUserId) {
        this.filledByUserId = filledByUserId;
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
