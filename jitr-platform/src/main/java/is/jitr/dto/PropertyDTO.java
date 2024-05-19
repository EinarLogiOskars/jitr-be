package is.jitr.dto;

public class PropertyDTO {

    private Long businessId;
    private String propertyName;
    private String propertyAddress;
    private String propertyPhone;

    public PropertyDTO(Long businessId, String propertyName, String propertyAddress, String propertyPhone) {
        this.businessId = businessId;
        this.propertyName = propertyName;
        this.propertyAddress = propertyAddress;
        this.propertyPhone = propertyPhone;
    }

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyAddress() {
        return propertyAddress;
    }

    public void setPropertyAddress(String propertyAddress) {
        this.propertyAddress = propertyAddress;
    }

    public String getPropertyPhone() {
        return propertyPhone;
    }

    public void setPropertyPhone(String propertyPhone) {
        this.propertyPhone = propertyPhone;
    }

}
