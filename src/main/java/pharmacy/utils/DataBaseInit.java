package pharmacy.utils;

import java.sql.*;

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

    public static Connection initializeDataBaseConnection() {
        try {
            System.out.println("Establishing database connection");
            return DriverManager.getConnection(POSTGRES_JDBC_URL, POSTGRES_USER_NAME, POSTGRES_USER_PASS);
        } catch (SQLException e) {
            System.err.println("Server can't initialize database connection: \n" + e);
            throw new RuntimeException("Server can't initialize database connection");
        }
    }

    public static void closeDataBaseResources(Connection connection, Statement statement) {
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
}