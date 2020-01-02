package pharmacy.domain;

public class UserProfile extends UserData{

    private boolean correctCredentials;

    public boolean isCorrectCredentials() {
        return correctCredentials;
    }

    public void setCorrectCredentials(boolean correctCredentials) {
        this.correctCredentials = correctCredentials;
    }
}