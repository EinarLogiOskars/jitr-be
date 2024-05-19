package is.jitr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import is.jitr.dto.PropertyDTO;
import is.jitr.model.BusinessDetails;
import is.jitr.model.Property;
import is.jitr.model.User;
import is.jitr.repository.BusinessDetailsRepository;
import is.jitr.repository.UserRepository;
import is.jitr.service.PropertyService;

@RestController
@RequestMapping("api/properties")
public class PropertyController {

    @Autowired
    private PropertyService service;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BusinessDetailsRepository businessDetailsRepository;

    @GetMapping(produces = "application/json")
    @PreAuthorize("hasAuthority('ROLE_BUSINESS')")
    public ResponseEntity<List<Property>> findAllForUser(Authentication authentication) {
        String username = authentication.getName();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        return ResponseEntity.ok(service.findAllPropertiesByUser(user));
    }

    @PostMapping("/register")
    @PreAuthorize("hasAuthority('ROLE_BUSINESS')")
    public ResponseEntity<Property> createProperty(@RequestBody PropertyDTO propertyDTO) {
        BusinessDetails businessDetails = businessDetailsRepository.getById(propertyDTO.getBusinessId());

        Property property = service.createProperty(propertyDTO);
        property.setBusinessDetails(businessDetails);
        return ResponseEntity.ok(property);
    }
}
