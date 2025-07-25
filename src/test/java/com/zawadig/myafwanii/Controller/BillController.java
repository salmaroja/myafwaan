package com.zawadig.myafwanii.Controller;

import com.zawadig.myafwanii.Model.Bill;
import com.zawadig.myafwanii.Model.Customer;
import com.zawadig.myafwanii.Service.BillService;
import com.zawadig.myafwanii.Service.CustomerService;
import com.zawadig.myafwanii.dto.BillRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bills")
public class BillController {

    @Autowired
    private BillService billService;

    @Autowired
    private CustomerService customerService;

    // ✅ 1. Get all bills
    @GetMapping
    public ResponseEntity<List<Bill>> getAllBills() {
        List<Bill> bills = billService.getAllBills();
        if (bills.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(bills);
    }

    // ✅ 2. Get bills by customer
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Bill>> getBillsByCustomer(@PathVariable Long customerId) {
        List<Bill> bills = billService.getBillsByCustomer(customerId);
        if (bills.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(bills);
    }

    // ✅ 3. Create new bill
    @PostMapping
    public ResponseEntity<?> createBill(@RequestBody BillRequest request) {
        Customer customer = customerService.getCustomerById(request.getCustomerId()).orElse(null);
        if (customer == null) {
            return ResponseEntity.badRequest().body("Customer not found");
        }

        Bill bill = new Bill();
        bill.setCustomer(customer);
        bill.setAmount(request.getAmount());
        bill.setBillingDate(request.getBillingDate());
        bill.setDueDate(request.getDueDate());
        bill.setPaid(request.getPaid());
        bill.setStatus(request.getStatus());

        // 🔥 Uboreshaji huu hapa: weka meterNumber kutoka kwa customer
        bill.setMeterNumber(customer.getMeterNumber());

        Bill saved = billService.saveBill(bill);
        return ResponseEntity.ok(saved);
    }

    // ✅ 4. Update bill
    @PutMapping("/{id}")
    public ResponseEntity<?> updateBill(@RequestBody BillRequest request, @PathVariable Long id) {
        Customer customer = customerService.getCustomerById(request.getCustomerId()).orElse(null);
        if (customer == null) {
            return ResponseEntity.badRequest().body("Customer not found");
        }

        Bill bill = new Bill();
        bill.setCustomer(customer);
        bill.setAmount(request.getAmount());
        bill.setBillingDate(request.getBillingDate());
        bill.setDueDate(request.getDueDate());
        bill.setPaid(request.getPaid());
        bill.setStatus(request.getStatus());

        // 🔥 Hakikisha update pia inahifadhi meter number upya
        bill.setMeterNumber(customer.getMeterNumber());

        Bill updated = billService.updateBill(bill, id);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }

    // ✅ 5. Delete bill
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBill(@PathVariable Long id) {
        billService.deleteBill(id);
        return ResponseEntity.ok().build();
    }

    // ✅ 6. Get single bill by ID (optional)
    @GetMapping("/{id}")
    public ResponseEntity<Bill> getBillById(@PathVariable Long id) {
        return billService.getBillById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
