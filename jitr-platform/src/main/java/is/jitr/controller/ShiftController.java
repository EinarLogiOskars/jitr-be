package is.jitr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAuthority('ROLE_BUSINESS')")
    public ResponseEntity<Shift> createShift(@RequestBody ShiftDTO shiftDTO) {
        Shift shift = service.createShift(shiftDTO);
        return ResponseEntity.ok(shift);
    }

    @GetMapping("/business/{businessId}")
    @PreAuthorize("hasAuthority('ROLE_BUSINESS')")
    public ResponseEntity<Shift> getBusinessShifts(@PathVariable Long businessId) {
        return ResponseEntity.ok(new Shift());
    }
}
