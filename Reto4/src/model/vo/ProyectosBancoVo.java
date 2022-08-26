
package model.vo;

import java.sql.*;
import model.dao.ProyectosBancoDao;

public class ProyectosBancoVo {

    public static void obtenerProyectos(String banco) throws SQLException {

        ResultSet rs = ProyectosBancoDao.consulta(banco);

        while (rs.next()) {

            int id = rs.getInt("ID");
            String constructora = rs.getString("Constructora");
            String ciudad = rs.getString("Ciudad");
            String clasificacion = rs.getString("Clasificacion");
            int estrato = rs.getInt("Estrato");
            String lider = rs.getString("LIDER");

            System.out.println(String.format("%3d %-25s %-20s %-15s %7d %-30s", id, constructora, ciudad, clasificacion, estrato, lider));

        }

    }

}
