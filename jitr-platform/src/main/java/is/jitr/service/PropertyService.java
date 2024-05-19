package is.jitr.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import is.jitr.dto.PropertyDTO;
import is.jitr.model.Property;
import is.jitr.model.User;
import is.jitr.repository.PropertyRepository;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository repository;

    @Transactional
    public Property createProperty(PropertyDTO propertyDTO) {
        Property property = new Property();
        property.setPropertyName(propertyDTO.getPropertyName());
        property.setPropertyAddress(propertyDTO.getPropertyAddress());
        property.setPropertyPhone(propertyDTO.getPropertyPhone());
        return repository.save(property);
    }

    public Property findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No property found with id: " + id));
    }

    public List<Property> findAllPropertiesByUser(User user) {
        return repository.findByUserId(user.getId());
    }
}
