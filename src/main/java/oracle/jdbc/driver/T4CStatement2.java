package oracle.jdbc.driver;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class T4CStatement2 extends oracle.jdbc.driver.T4CStatement {

    T4CStatement2(PhysicalConnection physicalConnection, Properties properties) throws SQLException {
        super(physicalConnection, properties);
    }

    @Override
    public ResultSet executeQuery(String s) throws SQLException {
        System.out.println("Executando query " + s);
        ResultSet rs = super.executeQuery(s);
        System.out.println("Obteve result set " + rs.toString());
        return rs;
    }
}
