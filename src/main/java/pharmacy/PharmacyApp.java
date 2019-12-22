package pharmacy;

import pharmacy.gui.admin.AdminMenuPanel;
import pharmacy.service.AdminOperations;
import pharmacy.service.ManagerOperations;
import pharmacy.gui.manager.ManagerPanel;
import pharmacy.service.PharmacistOperations;
import pharmacy.gui.pharmacist.PharmacistPanel;
import pharmacy.utils.DataBaseInit;
import pharmacy.domain.UserInfoDataManger;
import pharmacy.domain.UserInitData;

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
