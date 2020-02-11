package oracle.jdbc.driver;

import java.sql.SQLException;
import java.util.Properties;

public class T4CConnection2 extends T4CConnection {

    private String username;

    T4CConnection2(String username, String s, Properties properties, oracle.jdbc.driver.OracleDriverExtension oracleDriverExtension) throws SQLException {
        super(s, properties, oracleDriverExtension);
        this.username = username;
    }

}
