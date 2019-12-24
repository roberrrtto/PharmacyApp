package pharmacy.service;

import pharmacy.domain.MedicineData;

import java.util.List;

public interface AdminMedicinesService {

    void addNewMedicine(String medicineName, double price, String medicineDescription);

    void setMedicineDataForUpdate(String medicineName, double price, String medicineDescription);

    void removeMedicine(int index);

    MedicineData readMedicineData();

    void updateMedicineList();

    String[] getMedicineList();

    void setMedicineDataList();

    List<MedicineData> getMedicineDataList();

    void setUpdateMedicineData(int index);

    void setMedicineList();
}
