package pharmacy;

import pharmacy.manager.ManagerOperations;
import pharmacy.manager.ManagerPanel;
import pharmacy.pharmacist.PharmacistOperations;
import pharmacy.pharmacist.PharmacistPanel;
import pharmacy.admin.AdminPanel;
import pharmacy.admin.AdminOperations;
import pharmacy.sqlStaff.DataBaseInit;
import pharmacy.sqlStaff.UserInfoDataManger;
import pharmacy.sqlStaff.UserInitData;

import java.util.List;

import static pharmacy.Main.managerFrame;
import static pharmacy.Main.pharmacistFrame;
import static pharmacy.Main.adminFrame;

public class PharmacyApp {

    private static final String Pharmacist = "Pharmacist";
    private static final String UnitManager = "Unit Manager";
    private static final String Admin = "Admin";

    private UserInitData userInitData;
    private List<UserInfoDataManger> userInfoDataMangerList;
    private DataBaseInit dataBaseInit = new DataBaseInit();
    private ManagerOperations managerOperations;
    private ManagerPanel managerPanel;
    private boolean isFirstManagerLogin = true;
    private PharmacistOperations pharmacistOperations;
    private PharmacistPanel pharmacistPanel;
    private AdminOperations adminOperations;
    private AdminPanel adminPanel;

    public boolean logging(String userLogin, String userPassword) {
        userInitData = dataBaseInit.getUserData(userLogin, userPassword);
        if (userInitData.isCorrect()) {
            if (userInitData.getRole().equals(Pharmacist)) {
                pharmacistOperations = new PharmacistOperations(userInitData, dataBaseInit);
                pharmacistPanel = new PharmacistPanel(pharmacistOperations);
                pharmacistFrame.add(pharmacistPanel);
                pharmacistFrame.revalidate();
                pharmacistFrame.repaint();
                pharmacistFrame.setVisible(true);
            } else if (userInitData.getRole().equals(UnitManager)) {
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
            } else if (userInitData.getRole().equals(Admin)) {
                adminOperations = new AdminOperations(userInitData, dataBaseInit);
                adminPanel = new AdminPanel(adminOperations);
                adminFrame.add(adminPanel);
                adminFrame.revalidate();
                adminFrame.repaint();
                adminFrame.setVisible(true);
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
