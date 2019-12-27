package pharmacy.repository;

import pharmacy.domain.MedicineData;

import java.util.List;

public interface MedicineRepository {

    void createMedicine(MedicineData medicineData);

    MedicineData readMedicine(int medicineId);

    void updateMedicine(MedicineData medicineData);

    void deleteMedicine(int medicineId);

    List<MedicineData> getAllMedicines();
}
