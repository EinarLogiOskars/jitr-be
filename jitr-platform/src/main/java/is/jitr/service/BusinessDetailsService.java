package is.jitr.service;

import is.jitr.model.BusinessDetails;
import is.jitr.model.User;
import is.jitr.repository.BusinessDetailsRepository;

import java.util.List;

import javax.persistence.EntityNotFoundException;

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

    public List<BusinessDetails> findAllBusinessDetailsByUser(User user) {
        return repository.findByUserId(user.getId());
    }

    public BusinessDetails findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Business details not found with id: " + id));
    }

    public boolean isOwner(Long businessId, String username) {
        return repository.isOwnedBy(businessId, username);
    }
}
