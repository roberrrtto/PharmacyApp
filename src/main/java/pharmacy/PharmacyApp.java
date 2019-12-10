package pharmacy;

import pharmacy.manager.ManagerOperations;
import pharmacy.manager.ManagerPanel;
import pharmacy.sqlStaff.DataBaseInit;
import pharmacy.sqlStaff.UserInfoDataManger;
import pharmacy.sqlStaff.UserInitData;

import java.util.List;

import static pharmacy.Main.managerFrame;

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

    public boolean logging(String userLogin, String userPassword) {
        userInitData = dataBaseInit.getUserData(userLogin, userPassword);
        if (userInitData.isCorrect()) {
            if (userInitData.getRole().equals(Pharmacist)) {
                Main.pharmacistFrame.setVisible(true);
            } else if (userInitData.getRole().equals(UnitManager)) {
                if (!isFirstManagerLogin) {
                    managerFrame.remove(managerPanel);
                    managerFrame.revalidate();
                }
                isFirstManagerLogin = false;
                managerOperations = new ManagerOperations(userInitData, dataBaseInit);
                System.out.println(managerOperations.getUserInitData().getFirstName()); // test
                managerPanel = new ManagerPanel(managerOperations);
                System.out.println(managerPanel.getLoggedNameLabel()); // test
                managerFrame.add(managerPanel);
                managerFrame.revalidate();
                managerFrame.repaint();
                managerFrame.setVisible(true);
            } else if (userInitData.getRole().equals(Admin)) {
                Main.adminFrame.setVisible(true);
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
