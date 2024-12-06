
package grupo3a.tp_diseno.Modelos;

import grupo3a.tp_diseno.Enumerations.TipoAula;
import grupo3a.tp_diseno.Enumerations.TipoPizarron;


public class AulaGeneral {
    private int idAula;
    private TipoAula tipo; // Enum: GENERAL, MULTIMEDIOS, LABORATORIO
    private String ubicacion;
    private boolean estado;     // ??
    private int capacidad;
    private int piso;
    private TipoPizarron tipoDePizarron; // Enum: TIZA, FIBRÓN
    private boolean ventiladores;
    private boolean aireAcondicionado;
    private boolean habilitado;

    public AulaGeneral(){}
        public AulaGeneral(TipoAula tipo,String ubicacion,boolean estado,int capacidad,int piso,
                    TipoPizarron tipoDePizarron, boolean ventiladores, boolean aireAcondicionado,boolean habilitado){
        this.tipo=tipo;
        this.ubicacion=ubicacion;
        this.estado=estado;
        this.capacidad=capacidad;
        this.piso=piso;
        this.tipoDePizarron=tipoDePizarron;
        this.ventiladores=ventiladores;
        this.aireAcondicionado=aireAcondicionado;
        this.habilitado=habilitado;
    }

    public AulaGeneral(int id, TipoAula tipo_aula, String ubicacion, Boolean estado, Integer capacidadAula, Integer piso, TipoPizarron tipo_pizarron, Boolean ventiladores, Boolean aire_acondicionado, Boolean habilitado) {
        
        this.idAula = id;
        this.tipo=tipo_aula;
        this.ubicacion=ubicacion;
        this.estado=estado;
        this.capacidad=capacidadAula;
        this.piso=piso;
        this.tipoDePizarron=tipo_pizarron;
        this.ventiladores=ventiladores;
        this.aireAcondicionado=aire_acondicionado;
        this.habilitado=habilitado;
    
    
    }
        
        
    public int getIdAula() {
        return idAula;
    }

    public void setIdAula(int idAula) {
        this.idAula = idAula;
    }

    public TipoAula getTipo() {
        return tipo;
    }

    public void setTipo(TipoAula tipo) {
        this.tipo = tipo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public TipoPizarron getTipoDePizarron() {
        return tipoDePizarron;
    }

    public void setTipoDePizarron(TipoPizarron tipoDePizarron) {
        this.tipoDePizarron = tipoDePizarron;
    }

    public boolean isVentiladores() {
        return ventiladores;
    }

    public void setVentiladores(boolean ventiladores) {
        this.ventiladores = ventiladores;
    }

    public boolean isAireAcondicionado() {
        return aireAcondicionado;
    }

    public void setAireAcondicionado(boolean aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }
    
    
}
