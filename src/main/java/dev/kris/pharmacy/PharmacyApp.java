package dev.kris.pharmacy;

import dev.kris.pharmacy.log.LogPanel;
import dev.kris.pharmacy.manager.ManagerPanel;
import dev.kris.pharmacy.sqlStaff.DataBaseInit;

public class PharmacyApp {

    private LogPanel logPanel = new LogPanel();
//    private PharmacistFrame pharmacistFrame = new PharmacistFrame();
    private ManagerPanel managerPanel = new ManagerPanel();
//    private AdminFrame adminFrame = new AdminFrame();
    private DataBaseInit dataBaseInit = new DataBaseInit();









    public static void main(String[] args) {
        PharmacyApp pharmacyApp = new PharmacyApp();

    }


    public LogPanel getLogPanel() {
        return logPanel;
    }

    public void setLogPanel(LogPanel logPanel) {
        this.logPanel = logPanel;
    }

    public ManagerPanel getManagerPanel() {
        return managerPanel;
    }

    public void setManagerPanel(ManagerPanel managerPanel) {
        this.managerPanel = managerPanel;
    }

    public DataBaseInit getDataBaseInit() {
        return dataBaseInit;
    }

    public void setDataBaseInit(DataBaseInit dataBaseInit) {
        this.dataBaseInit = dataBaseInit;
    }
}
