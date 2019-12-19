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

import static pharmacy.Main.*;

public class PharmacyApp {

    private static final String PHARMACIST = "Pharmacist";
    private static final String UNIT_MANAGER = "Unit Manager";
    private static final String ADMIN = "Admin";

    private UserInitData userInitData;
    private List<UserInfoDataManger> userInfoDataMangerList;
    private DataBaseInit dataBaseInit = new DataBaseInit();
    private ManagerOperations managerOperations;
    private ManagerPanel managerPanel;
    private boolean isFirstManagerLogin = true;
    private boolean isFirstPharmacistLogin = true;
    private PharmacistOperations pharmacistOperations;
    private PharmacistPanel pharmacistPanel;
    private AdminOperations adminOperations;
    private AdminMenuPanel adminMenuPanel;

    public boolean logging(String userLogin, String userPassword) {
        userInitData = dataBaseInit.getUserData(userLogin, userPassword);
        if (userInitData.isCorrect()) {
            if (userInitData.getRole().equals(PHARMACIST)) {
                if (!isFirstPharmacistLogin) {
                    pharmacistFrame.remove(pharmacistPanel);
                    pharmacistFrame.revalidate();
                }
                isFirstManagerLogin = false;
                pharmacistOperations = new PharmacistOperations(userInitData, dataBaseInit);
                pharmacistPanel = new PharmacistPanel(pharmacistOperations);
                pharmacistFrame.add(pharmacistPanel);
                pharmacistFrame.revalidate();
                pharmacistFrame.repaint();
                pharmacistFrame.setVisible(true);
            } else if (userInitData.getRole().equals(UNIT_MANAGER)) {
                if (!isFirstManagerLogin) {
                    managerFrame.remove(managerPanel);
                    managerFrame.revalidate();
                }
                isFirstManagerLogin = false;
                managerOperations = new ManagerOperations(userInitData, dataBaseInit);
                managerPanel = new ManagerPanel(managerOperations);
                managerFrame.add(managerPanel);
                managerFrame.revalidate();
                managerFrame.repaint();
                managerFrame.setVisible(true);
            } else if (userInitData.getRole().equals(ADMIN)) {
//                adminOperations = new AdminOperations(userInitData, dataBaseInit);
                adminMenuPanel = new AdminMenuPanel(userInitData, dataBaseInit);
                adminMenuFrame.add(adminMenuPanel);
                adminMenuFrame.revalidate();
                adminMenuFrame.repaint();
                adminMenuFrame.setVisible(true);
            }
            Main.logFrame.setVisible(false);
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
