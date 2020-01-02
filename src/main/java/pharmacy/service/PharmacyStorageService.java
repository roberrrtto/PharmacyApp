package pharmacy.service;

import pharmacy.domain.PharmacyStorageData;

import java.util.List;

public interface PharmacyStorageService {

    void updatePharmacyStorageQuantityData(int quantity);

    void readMedicineDetails(int index);

    void updateMedicinesWithQtyDisplayList();

    String[] getMedicinesWithQtyDisplayList();

    void setPharmacyStorageDataList();

    List<PharmacyStorageData> getPharmacyStorageDataList();

    void setMedicinesWithQtyDisplayList();
}
