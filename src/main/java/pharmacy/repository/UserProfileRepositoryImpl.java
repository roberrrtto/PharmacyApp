package pharmacy.repository;

import pharmacy.domain.UserProfile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static pharmacy.utils.DataBaseInit.closeDataBaseResources;
import static pharmacy.utils.DataBaseInit.initializeDataBaseConnection;

public class UserProfileRepositoryImpl implements UserProfileRepository {

    @Override
    public UserProfile initializeUserProfile(String userLogin, String userPassword) {

        final String sqlGetData = "SELECT users.user_id, first_name, last_name, address, email,\n" +
                "       phone_number, login, password, job_title, salary, pharmacy_id FROM users\n" +
                "INNER JOIN pharmacy_staff ps\n" +
                "    ON users.user_id = ps.user_id\n" +
                "INNER JOIN user_credentials uc\n" +
                "    ON users.user_id = uc.user_id\n" +
                "WHERE login =? AND password =?;";


        Connection connection = initializeDataBaseConnection();
        PreparedStatement preparedStatement = null;

        UserProfile userProfile = new UserProfile();

        try {
            preparedStatement = connection.prepareStatement(sqlGetData);
            preparedStatement.setString(1,userLogin);
            preparedStatement.setString(2,userPassword);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                userProfile.setUserId(resultSet.getInt("user_id"));
                userProfile.setFirstName(resultSet.getString("first_name"));
                userProfile.setLastName(resultSet.getString("last_name"));
                userProfile.setAddress(resultSet.getString("address"));
                userProfile.setEmail(resultSet.getString("email"));
                userProfile.setPhoneNumber(resultSet.getString("phone_number"));
                userProfile.setLogin(resultSet.getString("login"));
                userProfile.setPassword(resultSet.getString("password"));
                userProfile.setJobTitle(resultSet.getString("job_title"));
                userProfile.setSalary(resultSet.getInt("salary"));
                userProfile.setPharmacyId(resultSet.getInt("pharmacy_id"));
            }
        } catch (SQLException e) {
            System.err.println("Error during invoke SQL query: \n" + e.getMessage());
            throw new RuntimeException("Error during invoke SQL query");
        } finally {
            closeDataBaseResources(connection, preparedStatement);
        }

        try {
            if (userProfile.getLogin().equals(userLogin) && userProfile.getPassword().equals(userPassword)) {
                userProfile.setCorrectCredentials(true);
                return userProfile;
            }
        } catch (NullPointerException ex) {
            System.out.println("Login or password is incorrect");
        }
        userProfile.setCorrectCredentials(false);
        return userProfile;
    }
}