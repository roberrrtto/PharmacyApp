package pharmacy.service;

import pharmacy.utils.DataBaseInit;
import pharmacy.domain.StorageData;
import pharmacy.domain.UserInfoDataManger;
import pharmacy.domain.UserProfile;

import java.util.List;

public class ManagerService {

    private int size;
    private String[] names;
    private String[] userDetails;
    private String[] storageDetails;

    private UserProfile userProfile;
    private DataBaseInit dataBaseInit;
    private List<UserInfoDataManger> userInfoDataMangerList;
    private List<StorageData> storageDataList;

    public ManagerService(UserProfile userProfile, DataBaseInit dataBaseInit) {
        this.userProfile = userProfile;
        this.dataBaseInit = dataBaseInit;
        setUserInfoDataMangerList();
        setStorageDataList();
        setSize();
        setNames();
        setStorageDetails();
    }

    public void storageUpdateForJPanel(int quantity, int medicineId) {
        getDataBaseInit().updateStorageQuantity(quantity,medicineId, userProfile.getPharmacyId());
        setStorageDataList();
        setStorageDetails();
    }

    public void setUserDetails(int index) {
        this.userDetails = new String[7];
        userDetails[0] = "first name: " + getUserInfoDataMangerList().get(index).getFirstName();
        userDetails[1] = "last name: " + getUserInfoDataMangerList().get(index).getLastName();
        userDetails[2] = "job title: " + getUserInfoDataMangerList().get(index).getJobTitle();
        userDetails[3] = "salary: " + getUserInfoDataMangerList().get(index).getSalary() + "$";
        userDetails[4] = "email: " + getUserInfoDataMangerList().get(index).getEmail();
        userDetails[5] = "tel. no.: " + getUserInfoDataMangerList().get(index).getPhoneNumber();
        userDetails[6] = "home address: " + getUserInfoDataMangerList().get(index).getAddress();
    }

    public void setStorageDetails() {
        this.storageDetails = new String[getStorageDataList().size()];
        int i = 0;
        for (StorageData sd : getStorageDataList()) {
            storageDetails[i] = sd.toString();
            i++;
        }
    }

    public void setNames() {
        this.names = new String[size];
        int i = 0;
        for (UserInfoDataManger uidm : getUserInfoDataMangerList()) {
            names[i] = uidm.getName() + ", tel. no. " + uidm.getPhoneNumber();
            i++;
        }
    }

    public void setSize() {
        this.size = getUserInfoDataMangerList().size();
    }

    public void setUserInfoDataMangerList() {
        this.userInfoDataMangerList = getDataBaseInit().getUnitUsersData(getUserProfile().getPharmacyId());
    }

    public void setStorageDataList() {
        this.storageDataList = getDataBaseInit().getStorageData(getUserProfile().getPharmacyId());
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public DataBaseInit getDataBaseInit() {
        return dataBaseInit;
    }

    public void setDataBaseInit(DataBaseInit dataBaseInit) {
        this.dataBaseInit = dataBaseInit;
    }

    public List<UserInfoDataManger> getUserInfoDataMangerList() {
        return userInfoDataMangerList;
    }

    public List<StorageData> getStorageDataList() {
        return storageDataList;
    }

    public int getSize() {
        return size;
    }

    public String[] getUserDetails() {
        return userDetails;
    }

    public String[] getStorageDetails() {
        return storageDetails;
    }

    public String[] getNames() {
        return names;
    }
}