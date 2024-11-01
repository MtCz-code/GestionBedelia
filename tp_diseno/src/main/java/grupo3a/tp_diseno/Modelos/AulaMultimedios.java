
package grupo3a.tp_diseno.Modelos;

import grupo3a.tp_diseno.Enumerations.TipoAula;
import grupo3a.tp_diseno.Enumerations.TipoPizarron;

public class AulaMultimedios extends AulaGeneral{
    private boolean televisor;
    private boolean canon;
    private boolean computadora;

    public AulaMultimedios(){}
    public AulaMultimedios(TipoAula tipo,String ubicacion,boolean estado,int capacidad,int piso,
                    TipoPizarron tipoDePizarron, boolean ventiladores,
                    boolean aireAcondicionado,boolean habilitado,boolean televisor,boolean canon,boolean computadora){
        super(tipo,ubicacion,estado,capacidad,piso,tipoDePizarron,ventiladores,aireAcondicionado,habilitado);
        this.televisor=televisor;
        this.canon=canon;
        this.computadora=computadora;
    }
    
    public boolean isTelevisor() {
        return televisor;
    }

    public void setTelevisor(boolean televisor) {
        this.televisor = televisor;
    }

    public boolean isCanon() {
        return canon;
    }

    public void setCanon(boolean canon) {
        this.canon = canon;
    }

    public boolean isComputadora() {
        return computadora;
    }

    public void setComputadora(boolean computadora) {
        this.computadora = computadora;
    }
}
