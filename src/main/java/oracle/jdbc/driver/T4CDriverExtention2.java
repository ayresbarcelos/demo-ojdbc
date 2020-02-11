package oracle.jdbc.driver;

import oracle.jdbc.logging.annotations.DefaultLevel;
import oracle.jdbc.logging.annotations.Logging;
import org.ietf.jgss.GSSCredential;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class T4CDriverExtention2 extends T4CDriverExtension {

    @DefaultLevel(Logging.FINEST)
    Connection getConnection(String var1, Properties var2) throws SQLException {
        System.out.println("getting conn1");
        return this.getConnection(var1, var2, (GSSCredential)null);
    }

    @DefaultLevel(Logging.FINEST)
    Connection getConnection(String url, Properties props, GSSCredential cred) throws SQLException {
        System.out.println("getting conn2");
        T4CConnection2 conn = new T4CConnection2("ayres", url, props, this);
        conn.connect(cred);
        return conn;
    }

    oracle.jdbc.driver.OracleStatement allocateStatement(PhysicalConnection var1, Properties var2) throws SQLException {
        System.out.println("getting st");
        return new T4CStatement2(var1, var2);
    }

    OraclePreparedStatement allocatePreparedStatement(PhysicalConnection var1, String var2, Properties var3) throws SQLException {
        System.out.println("getting ps");
        return new T4CPreparedStatement(var1, var2, var3);
    }

    OracleCallableStatement allocateCallableStatement(PhysicalConnection var1, String var2, Properties var3) throws SQLException {
        System.out.println("getting cs");
        return new T4CCallableStatement(var1, var2, var3);
    }

    OracleInputStream createInputStream(OracleStatement var1, int var2, Accessor var3) throws SQLException {
        System.out.println("getting is");
        return new T4CInputStream(var1, var2, var3);
    }
}
