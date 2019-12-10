package pharmacy.manager;

import pharmacy.sqlStaff.DataBaseInit;
import pharmacy.sqlStaff.StorageData;
import pharmacy.sqlStaff.UserInfoDataManger;
import pharmacy.sqlStaff.UserInitData;

import java.util.List;

public class ManagerOperations {

    private int size;
    private String[] names;
    private String[] userDetails;
    private String[] storageDetails;

    private UserInitData userInitData;
    private DataBaseInit dataBaseInit;
    private List<UserInfoDataManger> userInfoDataMangerList;
    private List<StorageData> storageDataList;

    public ManagerOperations(UserInitData userInitData, DataBaseInit dataBaseInit) {
        this.userInitData = userInitData;
        this.dataBaseInit = dataBaseInit;
        setUserInfoDataMangerList();
        setStorageDataList();
        setSize();
        setNames();
        setUserDetails();
        setStorageDetails();
    }


    public UserInitData getUserInitData() {
        return userInitData;
    }

    public void setUserInitData(UserInitData userInitData) {
        this.userInitData = userInitData;
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

    public void setUserInfoDataMangerList() {
        this.userInfoDataMangerList = getDataBaseInit().getUnitUsersData(getUserInitData().getPharmacyId());
    }

    public List<StorageData> getStorageDataList() {
        return storageDataList;
    }

    public void setStorageDataList() {
        this.storageDataList = getDataBaseInit().getStorageData(getUserInitData().getPharmacyId());
    }

    public int getSize() {
        return size;
    }

    public void setSize() {
        this.size = getUserInfoDataMangerList().size();
    }

    public String[] getUserDetails() {
        return userDetails;
    }

    public void setUserDetails() {
        this.userDetails = new String[size];
        int i = 0;
        for (UserInfoDataManger uidm : getUserInfoDataMangerList()) {
            userDetails[i] = uidm.toString();
            i++;
        }
    }

    public String[] getStorageDetails() {
        return storageDetails;
    }

    public void setStorageDetails() {
        this.storageDetails = new String[getStorageDataList().size()];
        int i = 0;
        for (StorageData sd : getStorageDataList()) {
            storageDetails[i] = sd.toString();
            i++;
        }
    }

    public String[] getNames() {
        return names;
    }

    public void setNames() {
        this.names = new String[size];
        int i = 0;
        for (UserInfoDataManger uidm : getUserInfoDataMangerList()) {
            names[i] = uidm.getName() + ", phone no. " + uidm.getPhoneNumber();
            i++;
        }
    }
}