//package com.zawadig.myafwanii.Service;
//
//import com.zawadig.myafwanii.Model.Bill;
//import com.zawadig.myafwanii.Repository.BillRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class BillService {
//
//    @Autowired
//    private BillRepository billRepository;
//
//    public List<Bill> getAllBills() {
//        return billRepository.findAll();
//    }
//
//    public List<Bill> getBillsByCustomer(Long customerId) {
//        return billRepository.findByCustomerId(customerId);
//    }
//
//    public Optional<Bill> getBillById(Long id) {
//        return billRepository.findById(id);
//    }
//
//    public Bill saveBill(Bill bill) {
//        return billRepository.save(bill);
//    }
//
//    public Bill updateBill(Bill bill, Long id) {
//        Optional<Bill> existing = billRepository.findById(id);
//        if (existing.isPresent()) {
//            Bill toUpdate = existing.get();
//            toUpdate.setAmount(bill.getAmount());
//            toUpdate.setBillingDate(bill.getBillingDate());
//            toUpdate.setDueDate(bill.getDueDate());
//            toUpdate.setPaid(bill.getPaid());
//            toUpdate.setStatus(bill.getStatus());
//            toUpdate.setCustomer(bill.getCustomer());
//            toUpdate.setMeterNumber(bill.getMeterNumber());
//            return billRepository.save(toUpdate);
//        }
//        return null;
//    }
//
//    public void deleteBill(Long id) {
//        billRepository.deleteById(id);
//    }
//}
package com.zawadig.myafwanii.Service;

import com.zawadig.myafwanii.Model.Bill;
import com.zawadig.myafwanii.Model.Customer;
import com.zawadig.myafwanii.Repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;

    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    public List<Bill> getBillsByCustomer(Long customerId) {
        return billRepository.findByCustomerId(customerId);
    }

    public Optional<Bill> getBillById(Long id) {
        return billRepository.findById(id);
    }

    public Bill saveBill(Bill bill) {
        return billRepository.save(bill);
    }

    public Bill updateBill(Bill bill, Long id) {
        Optional<Bill> existing = billRepository.findById(id);
        if (existing.isPresent()) {
            Bill toUpdate = existing.get();
            toUpdate.setAmount(bill.getAmount());
            toUpdate.setBillingDate(bill.getBillingDate());
            toUpdate.setDueDate(bill.getDueDate());
            toUpdate.setPaid(bill.getPaid());
            toUpdate.setStatus(bill.getStatus());
            toUpdate.setCustomer(bill.getCustomer());
            toUpdate.setMeterNumber(bill.getMeterNumber());
            return billRepository.save(toUpdate);
        }
        return null;
    }

    public void deleteBill(Long id) {
        billRepository.deleteById(id);
    }

    // Method mpya: Ku-create bill moja ya kwanza baada ya customer kujiandikisha
    public void createInitialBillForCustomer(Customer customer) {
        Bill bill = new Bill();
        bill.setCustomer(customer);

        // Mfano wa kiasi cha bill - unaweza kubadilisha kulingana na logic yako halisi
        bill.setAmount(10000.0); // Taarifa hii ni ya mfano tu
        bill.setBillingDate(LocalDate.now());
        bill.setDueDate(LocalDate.now().plusMonths(1)); // Due date mwezi mmoja baadaye
        bill.setStatus("UNPAID");
        bill.setPaid(false);
        bill.setMeterNumber(customer.getMeterNumber());

        billRepository.save(bill);
    }

//    public Map<String, Object> getCustomerUsageData(Long id) {
//
//    }
}

