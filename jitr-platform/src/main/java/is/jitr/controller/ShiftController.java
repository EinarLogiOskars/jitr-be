package is.jitr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
}
