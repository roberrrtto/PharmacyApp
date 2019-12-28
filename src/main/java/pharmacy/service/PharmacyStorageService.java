package pharmacy.service;

import pharmacy.domain.PharmacyStorageData;

import java.util.List;

public interface PharmacyStorageService {

    void setPharmacyStorageDataForUpdate(int quantity);

    void setUpdateMedicineInStorageData(int index);

    void updateMedicinesInStorageList();

    String[] getMedicinesInStorageList();

    void setPharmacyStorageDataList();

    List<PharmacyStorageData> getPharmacyStorageDataList();

    void setMedicinesInStorageList();
}
