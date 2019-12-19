package pharmacy.sqlStaff;

import pharmacy.manager.SaleChecker;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseInit {

    private static final String POSTGRES_JDBC_URL = "jdbc:postgresql://balarama.db.elephantsql.com:5432/hlqpjaqb";
    private static final String POSTGRES_USER_NAME = "hlqpjaqb";
    private static final String POSTGRES_USER_PASS = "VXJZE-kE4jRKdasnT2MQos4LgcOATz7G";

//    static {
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            System.err.println("Server can't find postgresql Driver class: \n" + e);
//        }
//    }

    public Connection initializeDataBaseConnection() {
        try {
            System.out.println("Establishing database connection");
            return DriverManager.getConnection(POSTGRES_JDBC_URL, POSTGRES_USER_NAME, POSTGRES_USER_PASS);
        } catch (SQLException e) {
            System.err.println("Server can't initialize database connection: \n" + e);
            throw new RuntimeException("Server can't initialize database connection");
        }
    }

    public void closeDataBaseResources(Connection connection, Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.err.println("Error during closing database resources: \n" + e);
            throw new RuntimeException("Error during closing database resources");
        }
    }

    ////////////// ------------------ check credentials and get initial user-data ------------------ \\\\\\\\\\\\\\
    public UserInitData getUserData(String userLogin, String userPassword) {

        final String sqlGetData = "SELECT user_credentials.user_id AS userid, login, password, job_title AS role, " +
                "pharmacy_id AS pharmacyid, first_name AS firstname, last_name AS lastname\n" +
                "FROM user_credentials\n" +
                "         INNER JOIN pharmacy_staff ps\n" +
                "                    ON user_credentials.user_id = ps.user_id\n" +
                "         INNER JOIN users\n" +
                "                    ON user_credentials.user_id = users.user_id\n" +
                "        WHERE login =? AND password =?;";


        Connection connection = initializeDataBaseConnection();
        PreparedStatement preparedStatement = null;

        UserInitData userInitData = new UserInitData();

        try {
            preparedStatement = connection.prepareStatement(sqlGetData);
            preparedStatement.setString(1,userLogin);
            preparedStatement.setString(2,userPassword);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                userInitData.setUserId(resultSet.getInt(1));
                userInitData.setLogin(resultSet.getString(2));
                userInitData.setPassword(resultSet.getString(3));
                userInitData.setRole(resultSet.getString(4));
                userInitData.setPharmacyId(resultSet.getInt(5));
                userInitData.setFirstName(resultSet.getString(6));
                userInitData.setLastName(resultSet.getString(7));
            }
        } catch (SQLException e) {
            System.err.println("Error during invoke SQL query: \n" + e.getMessage());
            throw new RuntimeException("Error during invoke SQL query");
        } finally {
            closeDataBaseResources(connection, preparedStatement);
        }

        try {
            if (userInitData.getLogin().equals(userLogin) && userInitData.getPassword().equals(userPassword)) {
                userInitData.setCorrect(true);
                return userInitData;
            }
        } catch (NullPointerException ex) {
            System.out.println("Login or password is incorrect");
        }
        userInitData.setCorrect(false);
        return userInitData;
    }

    ////////////// ------------------ get all users info ------------------ \\\\\\\\\\\\\\
    public List<UserInfoData> getAllUsers() {

        final String sqlGetAllUsersInfo = "SELECT user_id, concat(first_name,' ', last_name) as name, " +
                "first_name, last_name, address, email, phone_number\n" +
                "FROM public.users;";

        Connection connection = initializeDataBaseConnection();
        PreparedStatement preparedStatement = null;

        List<UserInfoData> userInfoDataList = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement(sqlGetAllUsersInfo);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                UserInfoData userInfoData = new UserInfoData();

                userInfoData.setUserId(resultSet.getInt("user_id"));
                userInfoData.setName(resultSet.getString("name"));
                userInfoData.setFirstName(resultSet.getString("first_name"));
                userInfoData.setLastName(resultSet.getString("last_name"));
                userInfoData.setAddress(resultSet.getString("address"));
                userInfoData.setEmail(resultSet.getString("email"));
                userInfoData.setPhoneNumber(resultSet.getString("phone_number"));

                userInfoDataList.add(userInfoData);
            }
        } catch (SQLException e) {
            System.err.println("Error during invoke SQL query: \n" + e.getMessage());
            throw new RuntimeException("Error during invoke SQL query");
        } finally {
            closeDataBaseResources(connection, preparedStatement);
        }

        return userInfoDataList;
    }

    ////////////// ------------------ get unit users info for a Manager------------------ \\\\\\\\\\\\\\
    public List<UserInfoDataManger> getUnitUsersData(int pharmacyId) {

        final String sqlGetData = "SELECT users.user_id, concat(first_name,' ', last_name) as name, first_name, last_name, " +
                "job_title, salary, email, phone_number, address FROM users\n" +
                "    INNER JOIN pharmacy_staff ps\n" +
                "    ON users.user_id = ps.user_id\n" +
                "WHERE pharmacy_id=? AND job_title = 'Pharmacist';";


        Connection connection = initializeDataBaseConnection();
        PreparedStatement preparedStatement = null;

        List<UserInfoDataManger> userInfoDataMangerList = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement(sqlGetData);
            preparedStatement.setInt(1,pharmacyId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                UserInfoDataManger userInfoDataManger = new UserInfoDataManger();

                userInfoDataManger.setUserId(resultSet.getInt("user_id"));
                userInfoDataManger.setName(resultSet.getString("name"));
                userInfoDataManger.setFirstName(resultSet.getString("first_name"));
                userInfoDataManger.setLastName(resultSet.getString("last_name"));
                userInfoDataManger.setJobTitle(resultSet.getString("job_title"));
                userInfoDataManger.setSalary(resultSet.getInt("salary"));
                userInfoDataManger.setEmail(resultSet.getString("email"));
                userInfoDataManger.setPhoneNumber(resultSet.getString("phone_number"));
                userInfoDataManger.setAddress(resultSet.getString("address"));

                userInfoDataMangerList.add(userInfoDataManger);
            }
        } catch (SQLException e) {
            System.err.println("Error during invoke SQL query: \n" + e.getMessage());
            throw new RuntimeException("Error during invoke SQL query");
        } finally {
            closeDataBaseResources(connection, preparedStatement);
        }

        return userInfoDataMangerList;
    }

    ////////////// ------------------ get unit storage data ------------------ \\\\\\\\\\\\\\
    public List<StorageData> getStorageData(int pharmacyId) {

        final String sqlGetData = "SELECT m.medicine_id, medicine_name, price, quantity FROM pharmacy_storage\n" +
                "    INNER JOIN medicines m\n" +
                "        ON pharmacy_storage.medicine_id = m.medicine_id\n" +
                "WHERE pharmacy_id=?\n" +
                "ORDER BY id ASC;";

        Connection connection = initializeDataBaseConnection();
        PreparedStatement preparedStatement = null;

        List<StorageData> storageDataList = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement(sqlGetData);
            preparedStatement.setInt(1,pharmacyId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                StorageData storageData = new StorageData();

                storageData.setMedicineId(resultSet.getInt("medicine_id"));
                storageData.setMedicineName(resultSet.getString("medicine_name"));
                storageData.setPrice(resultSet.getDouble("price"));
                storageData.setQuantity(resultSet.getInt("quantity"));

                storageDataList.add(storageData);
            }
        } catch (SQLException e) {
            System.err.println("Error during invoke SQL query: \n" + e.getMessage());
            throw new RuntimeException("Error during invoke SQL query");
        } finally {
            closeDataBaseResources(connection, preparedStatement);
        }

        return storageDataList;
    }

    //////////// ------------------ unit storage update ------------------ \\\\\\\\\\\\\\
    public void updateStorageQuantity(int quantity, int medicineId, int pharmacyId) {

        final String sqlUpdateStorageQuantity = "UPDATE pharmacy_storage\n" +
                "    SET quantity=?\n" +
                "    WHERE medicine_id=? AND pharmacy_id=?;";

        Connection connection = initializeDataBaseConnection();
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sqlUpdateStorageQuantity);
            preparedStatement.setInt(1,quantity);
            preparedStatement.setInt(2,medicineId);
            preparedStatement.setInt(3,pharmacyId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error during invoke SQL query: \n" + e.getMessage());
            throw new RuntimeException("Error during invoke SQL query");
        } finally {
            closeDataBaseResources(connection, preparedStatement);
        }
    }

    ////////////// ------------------ get total sale on the date ------------------ \\\\\\\\\\\\\\
    public SaleChecker getTotalSale(String date) {

        final String sqlGetAllUsersInfo = "SELECT sum(total) FROM receipts WHERE date ='" + date + "';";

        Connection connection = initializeDataBaseConnection();
        PreparedStatement preparedStatement = null;

        SaleChecker saleChecker = new SaleChecker();

        try {
            preparedStatement = connection.prepareStatement(sqlGetAllUsersInfo);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                saleChecker.setTotalSale(resultSet.getDouble(1));

            }
        } catch (SQLException e) {
            System.err.println("Error during invoke SQL query: \n" + e.getMessage());
            throw new RuntimeException("Error during invoke SQL query");
        } finally {
            closeDataBaseResources(connection, preparedStatement);
        }

        return saleChecker;
    }

    //////////// ------------------ create new user ------------------ \\\\\\\\\\\\\\
    public void createNewUser(CreateUserForm createUserForm) {

        final String sqlCreateNewUser = "INSERT INTO public.users(\n" +
                "    first_name, last_name, address, email, phone_number)\n" +
                "VALUES (?, ?, ?, ?, ?);";

        final String sqlCreateNewUserI = "INSERT INTO public.user_credentials(\n" +
                "    login, password, user_id)\n" +
                "VALUES (?, ?, (SELECT MAX(users.user_id) FROM public.users));";

        final String sqlCreateNewUserII = "INSERT INTO public.pharmacy_staff(\n" +
                "    user_id, job_title, salary, pharmacy_id)\n" +
                "VALUES ((SELECT MAX(users.user_id) FROM public.users), ?, ?, ?);";

        Connection connection = initializeDataBaseConnection();

        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatementI = null;
        PreparedStatement preparedStatementII = null;

        try {
            preparedStatement = connection.prepareStatement(sqlCreateNewUser);
            preparedStatementI = connection.prepareStatement(sqlCreateNewUserI);
            preparedStatementII = connection.prepareStatement(sqlCreateNewUserII);

            preparedStatement.setString(1,createUserForm.getFirstName());
            preparedStatement.setString(2,createUserForm.getLastName());
            preparedStatement.setString(3,createUserForm.getAddress());
            preparedStatement.setString(4,createUserForm.getEmail());
            preparedStatement.setString(5,createUserForm.getPhoneNumber());

            preparedStatementI.setString(1,createUserForm.getLogin());
            preparedStatementI.setString(2,createUserForm.getPassword());

            preparedStatementII.setString(1,createUserForm.getJobTitle());
            preparedStatementII.setInt(2,createUserForm.getSalary());
            preparedStatementII.setInt(3,createUserForm.getPharmacyId());

            preparedStatement.executeUpdate();
            preparedStatementI.executeUpdate();
            preparedStatementII.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error during invoke SQL query: \n" + e.getMessage());
            throw new RuntimeException("Error during invoke SQL query");
        } finally {
            closeDataBaseResources(connection, preparedStatement);
            closeDataBaseResources(connection, preparedStatementI);
            closeDataBaseResources(connection, preparedStatementII);
        }
    }

    //////////// ------------------ delete the user------------------ \\\\\\\\\\\\\\
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