package pharmacy.service;

import pharmacy.domain.PharmacyStorageData;
import pharmacy.repository.PharmacyStorageRepository;
import pharmacy.repository.PharmacyStorageRepositoryImpl;

import java.util.List;

public class PharmacyStorageServiceImpl implements PharmacyStorageService {

    private PharmacyStorageRepository pharmacyStorageRepository;
    private PharmacyStorageData pharmacyStorageData;
    private List<PharmacyStorageData> pharmacyStorageDataList;
    private String[] medicinesInStorageList;
    private int pharmacyId;

    public PharmacyStorageServiceImpl(int pharmacyId) {
        this.pharmacyStorageRepository = new PharmacyStorageRepositoryImpl();
        this.pharmacyId = pharmacyId;
        setPharmacyStorageDataList();
        setMedicinesInStorageList();
    }

    @Override
    public void setPharmacyStorageDataForUpdate(int quantity) {
        this.pharmacyStorageData.setQuantity(quantity);
        pharmacyStorageRepository.updatePharmacyStorageQuantity(pharmacyStorageData);
    }

    @Override
    public void setUpdateMedicineInStorageData(int index) {
        this.pharmacyStorageData = pharmacyStorageDataList.get(index);
    }

    @Override
    public void updateMedicinesInStorageList() {
        setPharmacyStorageDataList();
        setMedicinesInStorageList();
    }

    @Override
    public String[] getMedicinesInStorageList() {
        return medicinesInStorageList;
    }

    @Override
    public void setPharmacyStorageDataList() {
        this.pharmacyStorageDataList = pharmacyStorageRepository.readPharmacyStorageData(pharmacyId);
    }

    @Override
    public List<PharmacyStorageData> getPharmacyStorageDataList() {
        return pharmacyStorageDataList;
    }

    @Override
    public void setMedicinesInStorageList() {
        this.medicinesInStorageList = new String[getPharmacyStorageDataList().size()];
        int i = 0;
        for (PharmacyStorageData psd : getPharmacyStorageDataList()) {
            getMedicinesInStorageList()[i] = psd.getMedicineName() + ", qty: " + psd.getQuantity();
            i++;
        }
    }
}