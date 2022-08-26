
package model.dao;

import java.sql.*;
import util.JDBCUtilities;

public class ComprasDeLiderDao {
    public static ResultSet consulta() throws SQLException {

        Connection conn = JDBCUtilities.getConnection();

            String query_sql = "SELECT (ld.Nombre || ' ' || ld.Primer_Apellido || ' ' || ld.Segundo_Apellido) as LIDER, sum(c.Cantidad * mc.Precio_Unidad) as VALOR "
                    + "FROM Lider ld "
                    + "LEFT JOIN Proyecto p ON p.ID_Lider = ld.ID_Lider "
                    + "LEFT JOIN  Compra c ON p.ID_Proyecto = c.ID_Proyecto "
                    + "LEFT JOIN MaterialConstruccion mc ON mc.ID_MaterialConstruccion = c.ID_MaterialConstruccion "
                    + "GROUP BY LIDER "
                    + "ORDER BY VALOR DESC "
                    + "LIMIT 10;";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query_sql);

        return rs;
    }

}
