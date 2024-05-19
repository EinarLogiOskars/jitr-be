package is.jitr.model;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "shifts")
public class Shift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "work_type_id", nullable = false)
    private Integer workTypeId;

    @Column(name = "property_id", nullable = false)
    private Long propertyId;

    @Column(name = "filled_by_user_id")
    private Long filledByUserId;

    @Column(name = "shift_details", nullable = false, length = 255)
    private String shiftDetails;

    @Column(name = "estimated_shift_start", nullable = false)
    private LocalDateTime estimatedShiftStart;

    @Column(name = "shift_start")
    private LocalDateTime shiftStart;

    @Column(name = "estimated_shift_end", nullable = false)
    private LocalDateTime estimatedShiftEnd;

    @Column(name = "shift_end")
    private LocalDateTime shiftEnd;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ShiftStatus status;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Shift() {
    }

    public Shift(Long id, Integer workTypeId, Long propertyId, String shiftDetails, LocalDateTime estimatedShiftStart,
            LocalDateTime estimatedShiftEnd) {
        this.id = id;
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

    public LocalDateTime getShiftStart() {
        return shiftStart;
    }

    public void setShiftStart(LocalDateTime shiftStart) {
        this.shiftStart = shiftStart;
    }

    public LocalDateTime getEstimatedShiftEnd() {
        return estimatedShiftEnd;
    }

    public void setEstimatedShiftEnd(LocalDateTime estimatedShiftEnd) {
        this.estimatedShiftEnd = estimatedShiftEnd;
    }

    public LocalDateTime getShiftEnd() {
        return shiftEnd;
    }

    public void setShiftEnd(LocalDateTime shiftEnd) {
        this.shiftEnd = shiftEnd;
    }

    public ShiftStatus getStatus() {
        return status;
    }

    public void setStatus(ShiftStatus status) {
        this.status = status;
    }

}
