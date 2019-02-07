package de.switchdevelop.documentadmin.io.db.connection;

import com.mysql.jdbc.Driver;
import de.switchdevelop.casedocumentadministration.io.db.connection.DatabaseConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

    private Connection connection;

    public Connection getConnection() {
        if (connection == null) {
            // TODO: Property-file with database access
            DatabaseConnection databaseConnection = createDatabaseConnection("127.0.0.1", "documentstore", "root");
            Connection calculatedDatabaseConnection = databaseConnection.getConnection();
            if (calculatedDatabaseConnection == null) {
                // TODO: throw exception
            }
            this.connection = calculatedDatabaseConnection;
        }
        return connection;
    }

    private DatabaseConnection createDatabaseConnection(String ip, String databaseName, String user) {
        return createDatabaseConnection(ip, databaseName, user, null);
    }

    private DatabaseConnection createDatabaseConnection(String ip, String databaseName, String user, String password) {
        Driver myDriver;
        try {
            myDriver = new Driver();
            DriverManager.registerDriver(myDriver);
            StringBuilder urlContent = new StringBuilder();
            urlContent.append("jdbc:mysql://");
            urlContent.append(ip);
            urlContent.append("/");
            urlContent.append(databaseName);
            urlContent.append(
                    "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
            connection = DriverManager.getConnection(urlContent.toString(), "root", password);
            return new DatabaseConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new DatabaseConnection();
    }
}
