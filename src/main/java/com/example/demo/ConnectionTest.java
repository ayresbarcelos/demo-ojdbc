package com.example.demo;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionTest {

    public static void main (String[] args) {
        try
        {
            Class<?> forName = Class.forName("oracle.jdbc.driver.OracleDriver");
            Field[] declaredFields = forName.getDeclaredFields();
            for(Field field: declaredFields)
            {
                String name = field.getName();
                if (name.equals("driverExtensionClassNames")) {
                    Class<?> type = field.getType();
                    field.setAccessible(true);
                    String[] object = (String[])field.get(type);
                    object[0] = "oracle.jdbc.driver.T4CDriverExtention2";
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        try {
            String url = "jdbc:oracle:thin:@localhost:1521:XE";

            // classe T4CConnection2
            Connection conn = DriverManager.getConnection(url,"system","oracle");

            // classe T4CStatement2
            Statement stmt = conn.createStatement();

            ResultSet rs;
            rs = stmt.executeQuery("SELECT 1 FROM dual");
            while ( rs.next() ) {
                String lastName = rs.getString("1");
                System.out.println(lastName);
            }
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }
}

