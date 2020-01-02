package pharmacy;

import pharmacy.gui.admin.AdminMenuPanel;
import pharmacy.gui.manager.ManagerPanel;
import pharmacy.gui.pharmacist.PharmacistPanel;
import pharmacy.service.UserProfileService;

import static pharmacy.Main.mainFrame;

public class PharmacyApp {

    private final String PHARMACIST = "Pharmacist";
    private final String UNIT_MANAGER = "Unit Manager";
    private final String ADMIN = "Admin";

    private PharmacistPanel pharmacistPanel;
    private AdminMenuPanel adminMenuPanel;
    private ManagerPanel managerPanel;

    public boolean login(String userLogin, String userPassword) {
        UserProfileService.initializeUserProfile(userLogin, userPassword);
        if (UserProfileService.isCorrect()) {
            if (UserProfileService.getJobTitle().equals(PHARMACIST)) {
                pharmacistPanel = new PharmacistPanel();
                mainFrame.panelSwitchOver(pharmacistPanel);
            } else if (UserProfileService.getJobTitle().equals(UNIT_MANAGER)) {
                managerPanel = new ManagerPanel();
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