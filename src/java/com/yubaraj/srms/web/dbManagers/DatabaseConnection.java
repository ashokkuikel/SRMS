package com.yubaraj.srms.web.dbManagers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author yubaraj
 */
public class DatabaseConnection {

    private static Properties dbConnectionProperties;
    private static EntityManagerFactory emf;

    static {
        try {
            dbConnectionProperties = new Properties();
            dbConnectionProperties.load(new FileInputStream("DBConnection.properties"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        System.out.println("DB Connection dot Properties "+dbConnectionProperties);
        
        String serverAddress = dbConnectionProperties.getProperty("serverAddress").trim();
        String portNumber = dbConnectionProperties.getProperty("portNumber").trim();
        String databaseName = dbConnectionProperties.getProperty("databaseName").trim();
        String databaseUser = dbConnectionProperties.getProperty("databaseUser").trim();
        String databasePass = dbConnectionProperties.getProperty("databasePass");
        String databaseVender = dbConnectionProperties.getProperty("databaseVender").trim();

        /**
         * set the properties hashmap to create entitymanagerfactory
         */
        Map properties = new HashMap();

        if (databaseVender.trim().equalsIgnoreCase("oracle")) {
            properties.put("hibernate.connection.driver_class", "oracle.jdbc.driver.OracleDriver");
            properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle9Dialect");
            properties.put("hibernate.connection.url", "jdbc:oracle:thin:@" + serverAddress + ":" + portNumber + ":" + databaseName);
        } else if (databaseVender.trim().equalsIgnoreCase("mysql")) {
            properties.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
            properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
            properties.put("hibernate.connection.url", "jdbc:mysql://" + serverAddress + ":" + portNumber + "/" + databaseName);
        } else if (databaseVender.trim().equalsIgnoreCase("mssql")) {
            properties.put("hibernate.connection.driver_class", "com.microsoft.sqlserver.jdbc.SQLServerDriver");
            properties.put("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
            properties.put("hibernate.connection.url", "jdbc:sqlserver://" + serverAddress + ":" + portNumber + ";DatabaseName=" + databaseName);
        }
        properties.put("hibernate.connection.username", databaseUser);
        properties.put("hibernate.connection.password", databasePass);
        /**
         * create entitymanagerfactory using properties hashmap
         */
        System.out.println("properties-----" + properties);
        try {
            emf = Persistence.createEntityManagerFactory("srmsPU", properties);
        } catch (Exception e) {
            emf = null;
            e.printStackTrace();
        }
    }

    public static EntityManagerFactory getConnection() {
        return emf;
    }

    public static void main(String[] args) {
        System.out.println("EMF----" + DatabaseConnection.getConnection());
    }
}
