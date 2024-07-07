package is.jitr.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import is.jitr.dto.PropertyDTO;
import is.jitr.mapper.PropertyMapper;
import is.jitr.model.BusinessDetails;
import is.jitr.model.Property;
import is.jitr.model.User;
import is.jitr.repository.BusinessDetailsRepository;
import is.jitr.repository.PropertyRepository;
import net.bytebuddy.implementation.bytecode.Throw;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository repository;

    @Autowired
    private BusinessDetailsRepository businessDetailsRepository;

    @Transactional
    public Property createProperty(PropertyDTO propertyDTO, User user) {
        Property property = new Property();

        BusinessDetails businessDetails = businessDetailsRepository.findById(propertyDTO.getBusinessId())
                .orElseThrow(() -> new EntityNotFoundException("No business with id: " + propertyDTO.getBusinessId()));

        if (!businessDetails.getUser().equals(user)) {
            throw new AccessDeniedException("You do not have permission to add properties to this business");
        }

        property.setBusinessDetails(businessDetails);
        property.setPropertyName(propertyDTO.getPropertyName());
        property.setPropertyAddress(propertyDTO.getPropertyAddress());
        property.setPropertyPhone(propertyDTO.getPropertyPhone());
        return repository.save(property);
    }

    public Property findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No property found with id: " + id));
    }

    public List<PropertyDTO> findAllPropertiesByUser(User user) {
        List<Property> properties = repository.findByUserId(user.getId());
        List<PropertyDTO> propertyDTOs = PropertyMapper.toDTOs(properties);

        return propertyDTOs;
    }

    public List<PropertyDTO> findAllPropertiesByBusiness(Long businessId, User user) {
        BusinessDetails businessDetails = businessDetailsRepository.findById(businessId)
                .orElseThrow(() -> new EntityNotFoundException("Business not found with id: " + businessId));
        if (!businessDetails.getUser().equals(user)) {
            throw new AccessDeniedException("You do not have permission to view properties of this business");
        }

        List<Property> properties = repository.findByBusinessDetailsId(businessId);
        List<PropertyDTO> propertyDTOs = PropertyMapper.toDTOs(properties);

        return propertyDTOs;

    }

    public boolean isOwner(Long propertyId, String username) {
        return repository.isOwnedBy(propertyId, username);
    }
}
