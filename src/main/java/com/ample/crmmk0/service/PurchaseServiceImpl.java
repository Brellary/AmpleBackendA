package com.ample.crmmk0.service;

import com.ample.crmmk0.entity.Customer;
import com.ample.crmmk0.entity.Purchase;
import com.ample.crmmk0.repository.CustomerRepository;
import com.ample.crmmk0.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    private final PurchaseRepository purchaseRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public PurchaseServiceImpl(PurchaseRepository purchaseRepository, CustomerRepository customerRepository) {
        this.purchaseRepository = purchaseRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public Purchase createPurchase(Long customerId, Purchase purchase) {
        Customer customer = customerRepository.findById(customerId).orElseThrow();
        purchase.setCustomer(customer);
        return purchaseRepository.save(purchase);
    }

    @Override
    public List<Purchase> getPurchasesByCustomerId(Long customerId) {
        return purchaseRepository.findByCustomerId(customerId);
    }

    @Override
    public void deletePurchase(Long purchaseId) {
        if (!purchaseRepository.existsById(purchaseId)) {
            throw new IllegalArgumentException("Purchase not found");
        }
        purchaseRepository.deleteById(purchaseId);
    }
}