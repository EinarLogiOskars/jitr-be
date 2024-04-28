package is.jitr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping(produces = "application/json")
    @PreAuthorize("hasAuthority('ROLE_BUSINESS')")
    public ResponseEntity<List<BusinessDetails>> findAllForUser(Authentication authentication) {

        String username = authentication.getName();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        return ResponseEntity.ok(service.findAllBusinessDetailsByUser(user));
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    @PreAuthorize("hasAuthority('ROLE_BUSINESS')")
    public ResponseEntity<BusinessDetails> findById(@PathVariable("id") Long id, Authentication authentication) {

        String username = authentication.getName();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        BusinessDetails details = service.findById(id);
        if (details.getUser().getId() == user.getId()) {
            return ResponseEntity.ok(details);
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    @PostMapping("/register")
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
