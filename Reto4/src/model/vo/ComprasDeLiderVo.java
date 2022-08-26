package model.vo;

import java.sql.*;
import model.dao.ComprasDeLiderDao;

public class ComprasDeLiderVo {

    public static void obtenerCompras() throws SQLException {

        ResultSet rs = ComprasDeLiderDao.consulta();

        while (rs.next()) {

            String lider = rs.getString("LIDER");
            Double valor = rs.getDouble("VALOR");

            System.out.println(String.format("%-25s %,15.1f", lider, valor));

        }

    }

}
