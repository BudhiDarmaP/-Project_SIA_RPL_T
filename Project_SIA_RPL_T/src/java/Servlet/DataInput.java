package Servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataInput {
    Connection connection = null;
    DatabaseConnection database = new DatabaseConnection();
    public ArrayList<Mengambil> list() throws SQLException {
        connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ArrayList<Mengambil> mengambilList = new ArrayList<Mengambil>();
    }
}
