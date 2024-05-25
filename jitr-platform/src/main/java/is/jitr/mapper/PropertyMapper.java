package is.jitr.mapper;

import java.util.List;
import java.util.stream.Collectors;

import is.jitr.dto.PropertyDTO;
import is.jitr.model.Property;

public class PropertyMapper {

    public static PropertyDTO toDTO(Property property) {
        PropertyDTO dto = new PropertyDTO();
        dto.setId(property.getId());
        dto.setBusinessId(property.getBusinessDetails().getId());
        dto.setPropertyName(property.getPropertyName());
        dto.setPropertyAddress(property.getPropertyAddress());
        dto.setPropertyPhone(property.getPropertyPhone());
        return dto;
    }

    public static List<PropertyDTO> toDTOs(List<Property> properties) {
        return properties.stream().map(PropertyMapper::toDTO).collect(Collectors.toList());
    }
}
