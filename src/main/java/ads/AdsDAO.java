package ads;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public List<Ad> all() throws SQLException {
        boolean result;
        PreparedStatement statement = connection.prepareStatement("SELECT * from ads");

        ResultSet results = statement.executeQuery();
        List<Ad> allAds = new ArrayList<Ad>();

        while(results.next()) {
            allAds.add(new Ad(results.getString(1), results.getString(2)));
        }

        return allAds;
    }

    public Ad add(Ad ad) throws SQLException {
        boolean result;
        // create the prepared statement for the insert
        PreparedStatement statement = connection.prepareStatement(
            "INSERT INTO ads (title, body) VALUES (? , ?);",
            Statement.RETURN_GENERATED_KEYS
        );

        // Bind the parameters in order
        // order of parameters starts with 1 not 0, because it does.
        statement.setString(1, ad.getTitle());
        statement.setString(2, ad.getBody());

        // executeUpdate runs for insert or update.
        statement.executeUpdate();

        // get the
        ResultSet key = statement.getGeneratedKeys();

        // iterate to the next key set of results (similar to .getLastInsertedId())
        key.next();

        // set the first element on this row that's an integer (should be key)
        ad.setId(key.getInt(1));

        // return the ad object.
        return ad;
    }
}
