package pharmacy.service;

import pharmacy.domain.MedicineData;
import pharmacy.repository.MedicineRepository;
import pharmacy.repository.MedicineRepositoryImpl;

import java.util.List;

public class MedicineServiceImpl implements MedicineService {

    private MedicineRepository medicineRepository;
    private MedicineData newMedicineData;
    private MedicineData updateMedicineData;
    private List<MedicineData> medicineDataList;
    private String[] medicineList;

    public MedicineServiceImpl() {
        this.medicineRepository = new MedicineRepositoryImpl();
        setMedicineDataList();
        setMedicineList();
    }

    // =================== CRUD for the Medicine ===================
    @Override
    public void addNewMedicine(String medicineName, double price, String medicineDescription) {
        this.newMedicineData = new MedicineData(medicineName, price, medicineDescription);
        medicineRepository.createMedicine(newMedicineData);
    }

    @Override
    public void setMedicineDataForUpdate(String medicineName, double price, String medicineDescription) {
        int mId = updateMedicineData.getMedicineId();
        this.updateMedicineData = new MedicineData(medicineName, price, medicineDescription);
        updateMedicineData.setMedicineId(mId);
        medicineRepository.updateMedicine(updateMedicineData);
    }

    @Override
    public void removeMedicine(int index) {
        int mId = medicineDataList.get(index).getMedicineId();
        medicineRepository.deleteMedicine(mId);
        updateMedicineList();
    }

    @Override
    public MedicineData readMedicineData() {
        return updateMedicineData;
    }

    // =================== Helping methods ===================
    @Override
    public void updateMedicineList() {
        setMedicineDataList();
        setMedicineList();
    }

    // =================== Getters/Setters ===================
    @Override
    public String[] getMedicineList() {
        return medicineList;
    }

    @Override
    public void setMedicineDataList() {
        this.medicineDataList = medicineRepository.getAllMedicines();
    }

    @Override
    public List<MedicineData> getMedicineDataList() {
        return medicineDataList;
    }

    @Override
    public void setUpdateMedicineData(int index) {
        int mId = medicineDataList.get(index).getMedicineId();
        this.updateMedicineData = medicineRepository.readMedicine(mId);
    }

    @Override
    public void setMedicineList() {
        this.medicineList = new String[getMedicineDataList().size()];
        int i = 0;
        for (MedicineData md : getMedicineDataList()) {
            medicineList[i] = md.getMedicineName();
            i++;
        }
    }
}
