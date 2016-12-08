package ads;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;

/**
 * Created by Moravia on 12/8/16.
 */
public class AdsDAO {

    public Connection connection;

    public AdsDAO () throws SQLException {
        DriverManager.registerDriver(new Driver());

        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/adlister_db",
                "root",
                "");
    }

    public Ad add(Ad ad) throws SQLException {
        boolean result;
        // create the prepared statement for the insert
        PreparedStatement statement = connection.prepareStatement(
            "INSERT INTO ads (title, body) VALUES (? , ?);",
            Statement.RETURN_GENERATED_KEYS
        );

        statement.setString(1, ad.getTitle());
        statement.setString(2, ad.getBody());

        statement.executeUpdate();
        ResultSet key = statement.getGeneratedKeys();
        key.next();
        ad.setId(key.getInt(1));

        return ad;
    }
}
