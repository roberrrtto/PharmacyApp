package pharmacy.service;

import pharmacy.domain.PharmacyStorageData;

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

    @Override
    default void setPharmacyStorageDataForUpdate(int quantity) {
        // not implemented
    }

    @Override
    default void updateMedicinesInStorageList() {
        // not implemented
    }
}
