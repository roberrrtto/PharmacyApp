package pharmacy.service;

import pharmacy.domain.MedicineData;
import pharmacy.domain.UserData;
import pharmacy.repository.MedicineRepository;
import pharmacy.repository.MedicineRepositoryImpl;

import java.util.List;

public class AdminMedicinesService {

    private MedicineRepository medicineRepository;
    private MedicineData newMedicineData;
    private MedicineData updateMedicineData;
    private List<MedicineData> medicineDataList;
    private String[] medicineList;


    public AdminMedicinesService() {
        this.medicineRepository = new MedicineRepositoryImpl();
        setUserDataList();
        setEmployeeList();
    }

    // =================== CRUD for the User ===================
    public MedicineData readMedicineData() {
        return updateMedicineData;
    }

    public void addNewUser(String firstName, String lastName, String address, String email, String phoneNumber,
                           String login, String password, String jobTitle, int salary, int pharmacyId) {
        this.newMedicineData = new UserData(firstName, lastName, address, email, phoneNumber, login,
                password, jobTitle, salary, pharmacyId);
        userRepository.createUser(newMedicineData);
    }

    public void setUserDataForUpdate(String firstName, String lastName, String address, String email, String phoneNumber,
                                     String login, String password, String jobTitle, int salary, int pharmacyId) {
        int userID = updateMedicineData.getUserId();
        this.updateMedicineData = new UserData(firstName, lastName, address, email, phoneNumber, login,
                password, jobTitle, salary, pharmacyId);
        updateMedicineData.setUserId(userID);
        userRepository.updateUser(updateMedicineData);
    }

    public void removeUser(int index) {
        int uid = medicineDataList.get(index).getUserId();
        userRepository.deleteUser(uid);
        updateEmployeeList();
    }

    // =================== Helping methods ===================
    public void updateEmployeeList() {
        setUserDataList();
        setEmployeeList();
    }

    // =================== Getters/Setters ===================
    public String[] getMedicineList() {
        return medicineList;
    }
    public void setUserDataList() {
        this.medicineDataList = userRepository.getAllUsers();
    }
    public List<UserData> getMedicineDataList() {
        return medicineDataList;
    }

    public void setUpdateMedicineData(int index) {
        int userId = medicineDataList.get(index).getUserId();
        this.updateMedicineData = userRepository.readUser(userId);
    }

    public void setEmployeeList() {
        this.medicineList = new String[getMedicineDataList().size()];
        int i = 0;
        for (UserData ud : getMedicineDataList()) {
            medicineList[i] = ud.getName();
            i++;
        }
    }
}
