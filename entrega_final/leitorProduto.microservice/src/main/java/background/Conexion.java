package background;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public static Connection getConexion() {

        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/storeLeroy?createDatabaseIfNotExist=true&serverTimezone=UTC";
            String usuario ="root";
            String senha = "2812";

            con = DriverManager.getConnection(url, usuario, senha);
        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();
        }

        return con;

    }

}
