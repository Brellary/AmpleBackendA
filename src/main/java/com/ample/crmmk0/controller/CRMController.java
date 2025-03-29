package com.ample.crmmk0.controller;

import com.ample.crmmk0.dto.ApiResponse;
import com.ample.crmmk0.entity.Customer;
import com.ample.crmmk0.entity.Purchase;
import com.ample.crmmk0.service.CustomerService;
import com.ample.crmmk0.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/crm")
@CrossOrigin(origins = "http://localhost:8123")
public class CRMController {

    private final CustomerService customerService;
    private final PurchaseService purchaseService;

    @Autowired
    public CRMController(CustomerService customerService, PurchaseService purchaseService) {
        this.customerService = customerService;
        this.purchaseService = purchaseService;
    }

    // 客户操作
    @PostMapping("/customers")
    public ResponseEntity<ApiResponse<Customer>> createCustomer(@RequestBody Customer customer) {
        System.out.println("Received customer data: " + customer);
        customer.setId(null);
        Customer createdCustomer = customerService.createCustomer(customer);
        return ResponseEntity.status(201)
                .body(new ApiResponse<>("createCustomer", createdCustomer));
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<ApiResponse<String>> deleteCustomer(@PathVariable Long id) {
        System.out.println("Deleting customer with id: " + id);
        boolean deleted = customerService.deleteCustomer(id);
        if (deleted) {
            return ResponseEntity.ok(new ApiResponse<>("deleteCustomer", "Customer deleted"));
        } else {
            return ResponseEntity.status(404)
                    .body(new ApiResponse<>("deleteCustomer", "Customer not found"));
        }
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<ApiResponse<Customer>> getCustomer(@PathVariable Long id) {
        System.out.println("Fetching customer with id: " + id);
        Customer customer = customerService.getCustomerById(id);
        if (customer != null) {
            System.out.println("Replied id: " + id);
            return ResponseEntity.ok(new ApiResponse<>("getCustomer", customer));
        } else {
            System.out.println("Customer not found: " + id);
            return ResponseEntity.status(404)
                    .body(new ApiResponse<>("getCustomer", null));
        }
    }

    @GetMapping("/customers")
    public ResponseEntity<ApiResponse<List<Customer>>> getAllCustomers() {
        System.out.println("Fetching all customers");
        List<Customer> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(new ApiResponse<>("getAllCustomers", customers));
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<ApiResponse<Customer>> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        System.out.println("Updating customer with id: " + id + ", data: " + customer);
        customer.setId(id);
        Customer updatedCustomer = customerService.updateCustomer(customer);
        if (updatedCustomer != null) {
            return ResponseEntity.ok(new ApiResponse<>("updateCustomer", updatedCustomer));
        } else {
            return ResponseEntity.status(404)
                    .body(new ApiResponse<>("updateCustomer", null));
        }
    }

    // 购买操作
    @PostMapping("/customers/{customerId}/purchases")
    public ResponseEntity<ApiResponse<Purchase>> createPurchase(
            @PathVariable Long customerId, @RequestBody Purchase purchase) {
        try {
            Purchase createdPurchase = purchaseService.createPurchase(customerId, purchase);
            return ResponseEntity.status(201)
                    .body(new ApiResponse<>("createPurchase", createdPurchase));
        } catch (Exception e) {
            System.out.println("Failed to create purchase for customer " + customerId + ": " + e.getMessage());
            return ResponseEntity.status(500)
                    .body(new ApiResponse<>("createPurchase", null));
        }
    }

    @GetMapping("/customers/{customerId}/purchases")
    public ResponseEntity<ApiResponse<List<Purchase>>> getPurchases(
            @PathVariable Long customerId) {
        try {
            List<Purchase> purchases = purchaseService.getPurchasesByCustomerId(customerId);
            return ResponseEntity.ok(new ApiResponse<>("getPurchases", purchases));
        } catch (Exception e) {
            System.out.println("Failed to fetch purchases for customer " + customerId + ": " + e.getMessage());
            return ResponseEntity.status(500)
                    .body(new ApiResponse<>("getPurchases", null));
        }
    }

    @DeleteMapping("/customers/{customerId}/purchases/{purchaseId}")
    public ResponseEntity<ApiResponse<String>> deletePurchase(
            @PathVariable Long customerId, @PathVariable Long purchaseId) {
        try {
            purchaseService.deletePurchase(purchaseId); // 假设 PurchaseService 有此方法
            return ResponseEntity.ok(new ApiResponse<>("deletePurchase", "Purchase deleted"));
        } catch (Exception e) {
            System.out.println("Failed to delete purchase " + purchaseId + " for customer " + customerId + ": " + e.getMessage());
            return ResponseEntity.status(500)
                    .body(new ApiResponse<>("deletePurchase", "Failed to delete purchase"));
        }
    }
}