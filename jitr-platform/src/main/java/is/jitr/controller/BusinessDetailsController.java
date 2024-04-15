package is.jitr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import is.jitr.model.BusinessDetails;
import is.jitr.model.User;
import is.jitr.repository.UserRepository;
import is.jitr.service.BusinessDetailsService;

@RestController
@RequestMapping("api/business-details")
public class BusinessDetailsController {

    @Autowired
    private BusinessDetailsService service;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_BUSINESS')")
    public ResponseEntity<BusinessDetails> createBusinessDetails(@RequestBody BusinessDetails businessDetails,
            Authentication authentication) {

        String username = authentication.getName();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        businessDetails.setUser(user);
        BusinessDetails createdDetails = service.createBusinessDetails(businessDetails);
        return ResponseEntity.ok(createdDetails);

    }

}
