package com.IntercorpPruebaTecnica.mscliente.dto;

public class kpideclientesDTO {

    private static final long serialVersionUID = 1L;

    private Double PromedioEdad;
    private Double DesviacionEstandar;

    public Double getPromedioEdad() {
        return PromedioEdad;
    }

    public void setPromedioEdad(Double promedioEdad) {
        PromedioEdad = promedioEdad;
    }

    public Double getDesviacionEstandar() {
        return DesviacionEstandar;
    }

    public void setDesviacionEstandar(Double desviacionEstandar) {
        DesviacionEstandar = desviacionEstandar;
    }
}
