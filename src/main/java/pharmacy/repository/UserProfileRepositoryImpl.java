package pharmacy.repository;

import pharmacy.domain.UserProfileData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static pharmacy.utils.DataBaseInit.closeDataBaseResources;
import static pharmacy.utils.DataBaseInit.initializeDataBaseConnection;

public class UserProfileRepositoryImpl implements UserProfileRepository {

    @Override
    public UserProfileData initializeUserProfile(String userLogin, String userPassword) {

        final String sqlGetData = "SELECT users.user_id, first_name, last_name, address, email,\n" +
                "       phone_number, login, password, job_title, salary, pharmacy_id FROM users\n" +
                "INNER JOIN pharmacy_staff ps\n" +
                "    ON users.user_id = ps.user_id\n" +
                "INNER JOIN user_credentials uc\n" +
                "    ON users.user_id = uc.user_id\n" +
                "WHERE login =? AND password =?;";


        Connection connection = initializeDataBaseConnection();
        PreparedStatement preparedStatement = null;

        UserProfileData userProfileData = new UserProfileData();

        try {
            preparedStatement = connection.prepareStatement(sqlGetData);
            preparedStatement.setString(1,userLogin);
            preparedStatement.setString(2,userPassword);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                userProfileData.setUserId(resultSet.getInt("user_id"));
                userProfileData.setFirstName(resultSet.getString("first_name"));
                userProfileData.setLastName(resultSet.getString("last_name"));
                userProfileData.setAddress(resultSet.getString("address"));
                userProfileData.setEmail(resultSet.getString("email"));
                userProfileData.setPhoneNumber(resultSet.getString("phone_number"));
                userProfileData.setLogin(resultSet.getString("login"));
                userProfileData.setPassword(resultSet.getString("password"));
                userProfileData.setJobTitle(resultSet.getString("job_title"));
                userProfileData.setSalary(resultSet.getInt("salary"));
                userProfileData.setPharmacyId(resultSet.getInt("pharmacy_id"));
            }
        } catch (SQLException e) {
            System.err.println("Error during invoke SQL query: \n" + e.getMessage());
            throw new RuntimeException("Error during invoke SQL query");
        } finally {
            closeDataBaseResources(connection, preparedStatement);
        }

        try {
            if (userProfileData.getLogin().equals(userLogin) && userProfileData.getPassword().equals(userPassword)) {
                userProfileData.setCorrectCredentials(true);
                return userProfileData;
            }
        } catch (NullPointerException ex) {
            System.out.println("Login or password is incorrect");
        }
        userProfileData.setCorrectCredentials(false);
        return userProfileData;
    }
}