package com.jdbc;

import java.sql.*;

public class Main {

    public static void main( String args[] ) {
        Connection c = null; // соединение
        Statement stmt = null; // поток работы с БД

        try {
            Class.forName("org.sqlite.JDBC"); // формат работы бд
            c = DriverManager.getConnection("jdbc:sqlite:test.db"); // сама бд, подключение к файлу
            c.setAutoCommit(false); // отключение авто сохронения
            System.out.println("Открыта БД, успех!");

            stmt = c.createStatement(); // бд в поток
            String sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
                    "VALUES (1, 'Paul', 32, 'California', 20000.00 );";
            stmt.executeUpdate(sql); // обновление действий по запросу sql, втавка полей в бд / INSERT(вставка)

            sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
                    "VALUES (2, 'Allen', 25, 'Texas', 15000.00 );";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
                    "VALUES (3, 'Teddy', 23, 'Norway', 20000.00 );";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
                    "VALUES (4, 'Mark', 25, 'Rich-Mond ', 65000.00 );";
            stmt.executeUpdate(sql);

            stmt.close(); // выход
            c.commit();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() ); // ошибка
            System.exit(0);
        }
        System.out.println("Перезапись создана, успех!");
    }

}
