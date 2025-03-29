package com.ample.crmmk0.service;

import com.ample.crmmk0.entity.Purchase;
import java.util.List;

public interface PurchaseService {
    Purchase createPurchase(Long customerId, Purchase purchase);
    List<Purchase> getPurchasesByCustomerId(Long customerId);
    void deletePurchase(Long purchaseId);
}