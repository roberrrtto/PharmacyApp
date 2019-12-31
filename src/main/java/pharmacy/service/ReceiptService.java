package pharmacy.service;

import pharmacy.domain.PharmacyStorageData;
import pharmacy.domain.ReceiptData;

import java.sql.Date;
import java.util.List;

public interface ReceiptService extends PharmacyStorageService {

    void addNewReceipt();

    void setPharmacyStorageDataForUpdate();

    @Override
    void setUpdateMedicineInStorageData(int index);

    void setBasketList();

    void updateBasketList(int index);

    @Override
    String[] getMedicinesInStorageList();

    @Override
    void setPharmacyStorageDataList();

    @Override
    List<PharmacyStorageData> getPharmacyStorageDataList();

    @Override
    void setMedicinesInStorageList();

    void setTotal(double total);

    void updateTotal();

    double getTotal();

    void setBasket();

    void updateBasket();

    String[] getBasket();

    void setReceiptData(int receiptId);

    ReceiptData getReceiptData();

    void setReceiptToString();

    String getReceiptToString();

    void setTotalSale(Date date1, Date date2);

    double getTotalSale();

    @Override
    default void setPharmacyStorageDataForUpdate(int quantity) {
        // not implemented
    }

    @Override
    default void updateMedicinesInStorageList() {
        // not implemented
    }
}