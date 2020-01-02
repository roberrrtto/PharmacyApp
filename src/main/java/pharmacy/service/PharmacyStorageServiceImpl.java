package pharmacy.service;

import pharmacy.domain.PharmacyStorageData;
import pharmacy.repository.PharmacyStorageRepository;
import pharmacy.repository.PharmacyStorageRepositoryImpl;

import java.util.List;

public class PharmacyStorageServiceImpl implements PharmacyStorageService {

    private PharmacyStorageRepository pharmacyStorageRepository;
    private PharmacyStorageData pharmacyStorageData;
    private List<PharmacyStorageData> pharmacyStorageDataList;
    private String[] medicinesWithQtyDisplayList;
    private int pharmacyId;

    public PharmacyStorageServiceImpl(int pharmacyId) {
        this.pharmacyStorageRepository = new PharmacyStorageRepositoryImpl();
        this.pharmacyId = pharmacyId;
        setPharmacyStorageDataList();
        setMedicinesWithQtyDisplayList();
    }

    @Override
    public void updatePharmacyStorageQuantityData(int quantity) {
        this.pharmacyStorageData.setQuantity(quantity);
        pharmacyStorageRepository.updatePharmacyStorageQuantity(pharmacyStorageData);
    }

    @Override
    public void readMedicineDetails(int index) {
        this.pharmacyStorageData = getPharmacyStorageDataList().get(index);
    }

    @Override
    public void updateMedicinesWithQtyDisplayList() {
        setPharmacyStorageDataList();
        setMedicinesWithQtyDisplayList();
    }

    @Override
    public String[] getMedicinesWithQtyDisplayList() {
        return medicinesWithQtyDisplayList;
    }

    /* Pulls data of the particular Pharmacy-Storage */
    @Override
    public void setPharmacyStorageDataList() {
        this.pharmacyStorageDataList = pharmacyStorageRepository.readPharmacyStorageData(pharmacyId);
    }

    @Override
    public List<PharmacyStorageData> getPharmacyStorageDataList() {
        return pharmacyStorageDataList;
    }

    @Override
    public void setMedicinesWithQtyDisplayList() {
        this.medicinesWithQtyDisplayList = new String[getPharmacyStorageDataList().size()];
        int i = 0;
        for (PharmacyStorageData psd : getPharmacyStorageDataList()) {
            getMedicinesWithQtyDisplayList()[i] = psd.getMedicineName() + ", qty: " + psd.getQuantity();
            i++;
        }
    }
}