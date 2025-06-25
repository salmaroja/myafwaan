package com.zawadig.myafwanii.Service;

import com.zawadig.myafwanii.Model.Bill;

import java.util.List;

public interface BillService {
    Bill createBill(Bill bill);
    List<Bill> getAllBills();
    Bill getBillById(Long id);
    List<Bill> getBillsByCustomerId(Long customerId);
    Bill updateBill(Long id, Bill updatedBill);
    void deleteBill(Long id);
}
