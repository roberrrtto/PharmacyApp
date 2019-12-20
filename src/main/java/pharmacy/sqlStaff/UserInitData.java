package pharmacy.sqlStaff;

public class UserInitData {

    private int userId;
    private String login;
    private String password;
    private String role;
    private int pharmacyId;
    private String firstName;
    private String lastName;
    private boolean correct;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getPharmacyId() {
        return pharmacyId;
    }

    public void setPharmacyId(int pharmacyId) {
        this.pharmacyId = pharmacyId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    @Override
    public String toString() {
        return "UserInitData{" +
                "userId=" + userId +
                ", panelSwitchOver='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", pharmacyId=" + pharmacyId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
