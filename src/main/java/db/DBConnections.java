package db;

import java.sql.*;

public class DBConnections extends DBConfig{

    private Connection connection;

    public void connectDB() throws ClassNotFoundException, SQLException {
        Class.forName(dbConfig);
        connection = DriverManager.getConnection(dbHostUrl,userName,password);
    }

    public ResultSet runQuery(String query) throws SQLException {
        Statement stmt=connection.createStatement();
        return stmt.executeQuery(query);
    }

    public void closeDBConnection() throws SQLException {
        connection.close();
    }
}
