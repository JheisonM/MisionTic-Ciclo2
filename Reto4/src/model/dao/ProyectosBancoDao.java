
package model.dao;

import java.sql.*;
import util.JDBCUtilities;

public class ProyectosBancoDao {

    public static ResultSet consulta(String banco) throws SQLException {

        Connection conn = JDBCUtilities.getConnection();

        String query_sql = "SELECT py.ID_Proyecto AS ID, "
                + "py.Constructora, py.Ciudad, py.Clasificacion, tp.Estrato, "
                + "(ld.Nombre || ' ' || ld.Primer_Apellido || ' ' || ld.Segundo_Apellido) AS LIDER "
                + "FROM Proyecto AS py "
                + "LEFT JOIN Tipo AS tp ON py.ID_Tipo = tp.ID_Tipo "
                + "LEFT JOIN Lider AS ld ON py.ID_Lider = ld.ID_Lider "
                + "WHERE py.Banco_Vinculado = '" + banco
                + "' ORDER BY py.Fecha_Inicio DESC, py.Ciudad ASC, py.Constructora ASC;";

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query_sql);

        return rs;
    }

}
