package com.zawadig.myafwanii.Service;



import com.zawadig.myafwanii.Model.Bill;
import com.zawadig.myafwanii.Repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillRepository billRepository;

    @Override
    public Bill createBill(Bill bill) {
        return billRepository.save(bill);
    }

    @Override
    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    @Override
    public Bill getBillById(Long id) {
        return billRepository.findById(id).orElse(null);
    }

    @Override
    public List<Bill> getBillsByCustomerId(Long customerId) {
        return billRepository.findByCustomerId(customerId);
    }

    @Override
    public Bill updateBill(Long id, Bill updatedBill) {
        Bill existing = billRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setAmount(updatedBill.getAmount());
            existing.setBillingDate(updatedBill.getBillingDate());
            existing.setDueDate(updatedBill.getDueDate());
            existing.setPaid(updatedBill.isPaid());
            existing.setMeterNumber(updatedBill.getMeterNumber());
            return billRepository.save(existing);
        }
        return null;
    }

    @Override
    public void deleteBill(Long id) {
        billRepository.deleteById(id);
    }
}
