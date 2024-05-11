package is.jitr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import is.jitr.model.WorkTypes;
import is.jitr.service.WorkTypesService;

@RestController
@RequestMapping("api/work-types")
public class WorkTypesController {

    @Autowired
    private WorkTypesService service;

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<WorkTypes>> getAllWorkTypes() {
        return ResponseEntity.ok(service.getAllWorkTypes());
    }

}
