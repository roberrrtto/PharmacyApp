package pharmacy;

import pharmacy.domain.UserProfile;
import pharmacy.gui.admin.AdminMenuPanel;
import pharmacy.gui.manager.ManagerPanel;
import pharmacy.gui.pharmacist.PharmacistPanel;
import pharmacy.service.ManagerService;
import pharmacy.service.PharmacistOperations;
import pharmacy.service.UserProfileService;
import pharmacy.utils.DataBaseInit;

import static pharmacy.Main.mainFrame;

public class PharmacyApp {

    private final String PHARMACIST = "Pharmacist";
    private final String UNIT_MANAGER = "Unit Manager";
    private final String ADMIN = "Admin";

    private DataBaseInit dataBaseInit = new DataBaseInit();
    private ManagerService managerService;
    private ManagerPanel managerPanel;
    private PharmacistOperations pharmacistOperations;
    private PharmacistPanel pharmacistPanel;
    private AdminMenuPanel adminMenuPanel;
    private static UserProfile userProfile;

    public boolean logging(String userLogin, String userPassword) {
        UserProfileService.initializeUserProfile(userLogin, userPassword);
        if (UserProfileService.isCorrect()) {
            if (UserProfileService.getJobTitle().equals(PHARMACIST)) {
                pharmacistOperations = new PharmacistOperations(userProfile, dataBaseInit);
                pharmacistPanel = new PharmacistPanel(pharmacistOperations);
                mainFrame.panelSwitchOver(pharmacistPanel);
            } else if (UserProfileService.getJobTitle().equals(UNIT_MANAGER)) {
                managerService = new ManagerService(userProfile, dataBaseInit);
                managerPanel = new ManagerPanel(managerService);
                mainFrame.panelSwitchOver(managerPanel);
            } else if (UserProfileService.getJobTitle().equals(ADMIN)) {
                adminMenuPanel = new AdminMenuPanel();
                mainFrame.panelSwitchOver(adminMenuPanel);
            }
            return true;
        } else {
            return false;
        }
    }
}
