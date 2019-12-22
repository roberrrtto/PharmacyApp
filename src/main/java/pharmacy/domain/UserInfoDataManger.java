package pharmacy.domain;

public class UserInfoDataManger {

    private int userId;
    private String name;
    private String firstName;
    private String lastName;
    private String jobTitle;
    private int salary;
    private String email;
    private String phoneNumber;
    private String address;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return  "Employee detailed information:\n" +
                "first name: " + firstName + '\n' +
                "last name: " + lastName + '\n' +
                "jobTitle: " + jobTitle + '\n' +
                "salary: " + salary + "$\n" +
                "email: " + email + '\n' +
                "phone number: " + phoneNumber + '\n' +
                "address: " + address + '\n';
    }
}
