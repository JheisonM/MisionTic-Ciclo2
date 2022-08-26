
package model.dao;

import java.sql.*;
import util.JDBCUtilities;


public class DeudasPorProyectoDao {

    public static ResultSet consulta(Double limiteInferior) throws SQLException {
        
        Connection conn = JDBCUtilities.getConnection();

        String query_sql = "SELECT p.ID_Proyecto, sum(c.Cantidad * mc.Precio_Unidad) AS VALOR "
                + "FROM Proyecto p "
                + "LEFT JOIN  Compra c ON p.ID_Proyecto = c.ID_Proyecto "
                + "LEFT JOIN MaterialConstruccion mc ON mc.ID_MaterialConstruccion = c.ID_MaterialConstruccion "
                + "WHERE c.Pagado == 'No' "
                + "GROUP BY p.ID_Proyecto "
                + "HAVING VALOR > " + limiteInferior
                + " ORDER BY VALOR DESC;";

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query_sql);

        while (rs.next()) {

            int id = rs.getInt("ID_Proyecto");
            double valor = rs.getInt("VALOR");

            System.out.println(String.format("%3d %,15.1f", id, valor));

        }
        
        return rs;
    }

}
