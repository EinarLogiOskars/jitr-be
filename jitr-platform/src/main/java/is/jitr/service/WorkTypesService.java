package is.jitr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import is.jitr.model.WorkTypes;
import is.jitr.repository.WorkTypesRepository;

@Service
public class WorkTypesService {

    @Autowired
    private WorkTypesRepository repo;

    public List<WorkTypes> getAllWorkTypes() {
        return repo.findAll();
    }

}
