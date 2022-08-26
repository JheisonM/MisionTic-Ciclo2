
package model.vo;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.dao.DeudasPorProyectoDao;


public class DeudasPorProyectoVo {
    public static void obtenerDeudas(Double limiteInferior) throws SQLException {

        ResultSet rs = DeudasPorProyectoDao.consulta(limiteInferior);

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
