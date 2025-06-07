package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    
    private static final String URL_MYSQL = "jdbc:mysql://localhost:3306/bibliotecavirtual";
    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASSWORD = "12345";

    public static Connection conectar() {
        try {
            Class.forName(DRIVER_CLASS);
            return DriverManager.getConnection(URL_MYSQL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
        }
        return null;
    }

    public static void desconectar(Connection conexao) {
        if (conexao != null) {
            try {
                conexao.close();
            } catch (SQLException e) {
                System.out.println("Erro ao desconectar: " + e.getMessage());
            }
        }
    }
}
