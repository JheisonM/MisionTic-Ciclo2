
package controller;

import view.ReportesView;

public class ReportesController {


    public static void main(String[] args) {
        ReportesView reportesView = new ReportesView();
        String banco = "Conavi";
        reportesView.proyectosFinanciadosPorBanco(banco);
        
        double limiteInferior = 50_000d;
        reportesView.totalAdeudadoPorProyectosSuperioresALimite(limiteInferior);
        
        reportesView.lideresQueMasGastan();
    }
    
}
