package ads;

import com.mysql.cj.jdbc.Driver;
import java.sql.*;

/**
 * Created by Moravia on 12/8/16.
 */
public class AdsDAO {

    public Connection connection;

    AdsDAO () throws SQLException {
        DriverManager.registerDriver(new Driver());

        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/adlister_db",
                "root",
                "");
    }
}
