package is.jitr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import is.jitr.dto.ShiftDTO;
import is.jitr.model.Shift;
import is.jitr.service.ShiftService;

@RestController
@RequestMapping("api/shifts")
public class ShiftController {

    @Autowired
    private ShiftService service;

    @PostMapping("/register")
    @PreAuthorize("hasAuthority('ROLE_BUSINESS') and @propertyService.isOwner(#shiftDTO.propertyId, authentication.name)")
    public ResponseEntity<Shift> createShift(@RequestBody ShiftDTO shiftDTO) {
        Shift shift = service.createShift(shiftDTO);
        return ResponseEntity.ok(shift);
    }

    @GetMapping(path = "/business/{businessId}", produces = "application/json")
    @PreAuthorize("hasAuthority('ROLE_BUSINESS') and @businessDetailsService.isOwner(#businessId, authentication.name)")
    public ResponseEntity<List<ShiftDTO>> getShiftsByBusiness(@PathVariable Long businessId,
            Authentication authentication) {

        List<ShiftDTO> shiftDTOs = service.findByBusinessId(businessId);

        return ResponseEntity.ok(shiftDTOs);
    }

    @GetMapping(path = "/{shiftId}", produces = "application/json")
    @PreAuthorize("hasAuthority('ROLE_BUSINESS') and @shiftService.isOwner(#shiftId, authentication.name)")
    public ResponseEntity<ShiftDTO> getShiftById(@PathVariable Long shiftId, Authentication authentication) {

        return ResponseEntity.ok(service.findById(shiftId));

    }
}
