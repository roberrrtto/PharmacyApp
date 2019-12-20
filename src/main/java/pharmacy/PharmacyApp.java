package pharmacy;

import pharmacy.admin.AdminMenuPanel;
import pharmacy.admin.AdminOperations;
import pharmacy.manager.ManagerOperations;
import pharmacy.manager.ManagerPanel;
import pharmacy.pharmacist.PharmacistOperations;
import pharmacy.pharmacist.PharmacistPanel;
import pharmacy.sqlStaff.DataBaseInit;
import pharmacy.sqlStaff.UserInfoDataManger;
import pharmacy.sqlStaff.UserInitData;

import java.util.List;

import static pharmacy.Main.mainFrame;

public class PharmacyApp {

    private final String PHARMACIST = "Pharmacist";
    private final String UNIT_MANAGER = "Unit Manager";
    private final String ADMIN = "Admin";

    private UserInitData userInitData;
    private List<UserInfoDataManger> userInfoDataMangerList;
    private DataBaseInit dataBaseInit = new DataBaseInit();
    private ManagerOperations managerOperations;
    private ManagerPanel managerPanel;
    private PharmacistOperations pharmacistOperations;
    private PharmacistPanel pharmacistPanel;
    private AdminOperations adminOperations;
    private AdminMenuPanel adminMenuPanel;

    public boolean logging(String userLogin, String userPassword) {
        userInitData = dataBaseInit.getUserData(userLogin, userPassword);
        if (userInitData.isCorrect()) {
            if (userInitData.getRole().equals(PHARMACIST)) {
                pharmacistOperations = new PharmacistOperations(userInitData, dataBaseInit);
                pharmacistPanel = new PharmacistPanel(pharmacistOperations);
                mainFrame.panelSwitchOver(pharmacistPanel);
            } else if (userInitData.getRole().equals(UNIT_MANAGER)) {
                managerOperations = new ManagerOperations(userInitData, dataBaseInit);
                managerPanel = new ManagerPanel(managerOperations);
                mainFrame.panelSwitchOver(managerPanel);
            } else if (userInitData.getRole().equals(ADMIN)) {
//                adminOperations = new AdminOperations(userInitData, dataBaseInit);
                adminMenuPanel = new AdminMenuPanel(userInitData, dataBaseInit);
                mainFrame.panelSwitchOver(adminMenuPanel);
            }
            return true;
        } else {
            return false;
        }
    }


    public DataBaseInit getDataBaseInit() {
        return dataBaseInit;
    }

    public void setDataBaseInit(DataBaseInit dataBaseInit) {
        this.dataBaseInit = dataBaseInit;
    }

}
