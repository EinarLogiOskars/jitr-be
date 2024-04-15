package is.jitr.service;

import is.jitr.model.BusinessDetails;
import is.jitr.repository.BusinessDetailsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BusinessDetailsService {

    @Autowired
    private BusinessDetailsRepository repository;

    @Transactional
    public BusinessDetails createBusinessDetails(BusinessDetails businessDetails) {
        return repository.save(businessDetails);
    }
}
