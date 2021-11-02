package com.Leroy.microservice.background;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * classe conexion responsavel por vincular a base de dados mysql com a API
 * para enviar um objeto para o schema storeLeroy
 */
public class Conexion {

    /**
     * metodo que realiza a conexao local com mysql
     *
     * @return con
     */
    public static Connection getConexion() {

        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/storeLeroy?createDatabaseIfNotExist=true";
            String usuario ="root";
            String senha = "2812";

            con = DriverManager.getConnection(url, usuario, senha);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return con;

    }

}

