package pharmacy.repository;

import pharmacy.domain.UserDataAdminForm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static pharmacy.utils.DataBaseInit.closeDataBaseResources;
import static pharmacy.utils.DataBaseInit.initializeDataBaseConnection;

public class AdminRepository {

    public void createNewUser(UserDataAdminForm userDataAdminForm) {

        final String sqlCreateNewUser1 = "INSERT INTO public.users(\n" +
                "    first_name, last_name, address, email, phone_number)\n" +
                "VALUES (?, ?, ?, ?, ?);";

        final String sqlCreateNewUser2 = "INSERT INTO public.user_credentials(\n" +
                "    login, password, user_id)\n" +
                "VALUES (?, ?, (SELECT MAX(users.user_id) FROM public.users));";

        final String sqlCreateNewUser3 = "INSERT INTO public.pharmacy_staff(\n" +
                "    user_id, job_title, salary, pharmacy_id)\n" +
                "VALUES ((SELECT MAX(users.user_id) FROM public.users), ?, ?, ?);";

        Connection connection = initializeDataBaseConnection();

        PreparedStatement preparedStatement1 = null;
        PreparedStatement preparedStatement2 = null;
        PreparedStatement preparedStatement3 = null;

        try {
            preparedStatement1 = connection.prepareStatement(sqlCreateNewUser1);
            preparedStatement2 = connection.prepareStatement(sqlCreateNewUser2);
            preparedStatement3 = connection.prepareStatement(sqlCreateNewUser3);

            preparedStatement1.setString(1, userDataAdminForm.getFirstName());
            preparedStatement1.setString(2, userDataAdminForm.getLastName());
            preparedStatement1.setString(3, userDataAdminForm.getAddress());
            preparedStatement1.setString(4, userDataAdminForm.getEmail());
            preparedStatement1.setString(5, userDataAdminForm.getPhoneNumber());

            preparedStatement2.setString(1, userDataAdminForm.getLogin());
            preparedStatement2.setString(2, userDataAdminForm.getPassword());

            preparedStatement3.setString(1, userDataAdminForm.getJobTitle());
            preparedStatement3.setInt(2, userDataAdminForm.getSalary());
            preparedStatement3.setInt(3, userDataAdminForm.getPharmacyId());

            preparedStatement1.executeUpdate();
            preparedStatement2.executeUpdate();
            preparedStatement3.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error during invoke SQL query: \n" + e.getMessage());
            throw new RuntimeException("Error during invoke SQL query");
        } finally {
            closeDataBaseResources(connection, preparedStatement1);
            closeDataBaseResources(connection, preparedStatement2);
            closeDataBaseResources(connection, preparedStatement3);
        }
    }

    public UserDataAdminForm getUserDataForAdminForm(int userId) {

        final String sqlGetData = "SELECT users.user_id, first_name, last_name, address, email,\n" +
                "       phone_number, login, password, job_title, salary, pharmacy_id FROM users\n" +
                "INNER JOIN pharmacy_staff ps\n" +
                "    ON users.user_id = ps.user_id\n" +
                "INNER JOIN user_credentials uc\n" +
                "    ON users.user_id = uc.user_id\n" +
                "WHERE users.user_id=?;";


        Connection connection = initializeDataBaseConnection();
        PreparedStatement preparedStatement = null;

        UserDataAdminForm userDataAdminForm = new UserDataAdminForm();

        try {
            preparedStatement = connection.prepareStatement(sqlGetData);
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                userDataAdminForm.setUserId(resultSet.getInt("user_id"));
                userDataAdminForm.setFirstName(resultSet.getString("first_name"));
                userDataAdminForm.setLastName(resultSet.getString("last_name"));
                userDataAdminForm.setAddress(resultSet.getString("address"));
                userDataAdminForm.setEmail(resultSet.getString("email"));
                userDataAdminForm.setPhoneNumber(resultSet.getString("phone_number"));
                userDataAdminForm.setLogin(resultSet.getString("login"));
                userDataAdminForm.setPassword(resultSet.getString("password"));
                userDataAdminForm.setJobTitle(resultSet.getString("job_title"));
                userDataAdminForm.setSalary(resultSet.getInt("salary"));
                userDataAdminForm.setPharmacyId(resultSet.getInt("pharmacy_id"));

            }
        } catch (SQLException e) {
            System.err.println("Error during invoke SQL query: \n" + e.getMessage());
            throw new RuntimeException("Error during invoke SQL query");
        } finally {
            closeDataBaseResources(connection, preparedStatement);
        }

        return userDataAdminForm;
    }

    public void updateUser(UserDataAdminForm userDataAdminForm) {

        final String sqlUserUpdate1 = "UPDATE public.users\n" +
                "    SET first_name=?, last_name=?, address=?, email=?, phone_number=?\n" +
                "WHERE user_id = ?;";

        final String sqlUserUpdate2 = "UPDATE user_credentials\n" +
                "    SET login = ?, password = ?\n" +
                "WHERE user_id = ?;";

        final String sqlUserUpdate3 = "UPDATE pharmacy_staff\n" +
                "    SET job_title = ?, salary = ?, pharmacy_id = ?\n" +
                "WHERE user_id = ?;";

        Connection connection = initializeDataBaseConnection();

        PreparedStatement preparedStatement1 = null;
        PreparedStatement preparedStatement2 = null;
        PreparedStatement preparedStatement3 = null;

        try {
            preparedStatement1 = connection.prepareStatement(sqlUserUpdate1);
            preparedStatement2 = connection.prepareStatement(sqlUserUpdate2);
            preparedStatement3 = connection.prepareStatement(sqlUserUpdate3);

            preparedStatement1.setString(1, userDataAdminForm.getFirstName());
            preparedStatement1.setString(2, userDataAdminForm.getLastName());
            preparedStatement1.setString(3, userDataAdminForm.getAddress());
            preparedStatement1.setString(4, userDataAdminForm.getEmail());
            preparedStatement1.setString(5, userDataAdminForm.getPhoneNumber());
            preparedStatement1.setInt(6, userDataAdminForm.getUserId());

            preparedStatement2.setString(1, userDataAdminForm.getLogin());
            preparedStatement2.setString(2, userDataAdminForm.getPassword());
            preparedStatement2.setInt(3, userDataAdminForm.getUserId());

            preparedStatement3.setString(1, userDataAdminForm.getJobTitle());
            preparedStatement3.setInt(2, userDataAdminForm.getSalary());
            preparedStatement3.setInt(3, userDataAdminForm.getPharmacyId());
            preparedStatement3.setInt(4, userDataAdminForm.getUserId());

            preparedStatement1.executeUpdate();
            preparedStatement2.executeUpdate();
            preparedStatement3.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error during invoke SQL query: \n" + e.getMessage());
            throw new RuntimeException("Error during invoke SQL query");
        } finally {
            closeDataBaseResources(connection, preparedStatement1);
            closeDataBaseResources(connection, preparedStatement2);
            closeDataBaseResources(connection, preparedStatement3);
        }
    }

    public void removeUser(int userId) {

        final String sqlRemoveUserI = "DELETE FROM public.users\n" +
                "WHERE user_id =?;";
        final String sqlRemoveUserII = "DELETE FROM public.user_credentials\n" +
                "WHERE user_id =?;";
        final String sqlRemoveUserIII = "DELETE FROM public.pharmacy_staff\n" +
                "WHERE user_id =?;";

        Connection connection = initializeDataBaseConnection();
        PreparedStatement preparedStatementI = null;
        PreparedStatement preparedStatementII = null;
        PreparedStatement preparedStatementIII = null;

        try {
            preparedStatementI = connection.prepareStatement(sqlRemoveUserI);
            preparedStatementII = connection.prepareStatement(sqlRemoveUserII);
            preparedStatementIII = connection.prepareStatement(sqlRemoveUserIII);

            preparedStatementI.setInt(1,userId);
            preparedStatementII.setInt(1,userId);
            preparedStatementIII.setInt(1,userId);

            preparedStatementI.executeUpdate();
            preparedStatementII.executeUpdate();
            preparedStatementIII.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error during invoke SQL query: \n" + e.getMessage());
            throw new RuntimeException("Error during invoke SQL query");
        } finally {
            closeDataBaseResources(connection, preparedStatementI);
            closeDataBaseResources(connection, preparedStatementII);
            closeDataBaseResources(connection, preparedStatementIII);
        }
    }

}
