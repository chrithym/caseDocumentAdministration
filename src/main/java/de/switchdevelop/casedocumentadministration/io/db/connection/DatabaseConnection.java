package de.switchdevelop.casedocumentadministration.io.db.connection;

import java.sql.Connection;

public class DatabaseConnection {

    private Connection connection;

    public DatabaseConnection() {
    }

    public DatabaseConnection(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return this.connection;
    }
}
