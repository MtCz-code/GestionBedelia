
package grupo3a.tp_diseno.Modelos;
import grupo3a.tp_diseno.Enumerations.TipoAula;
import grupo3a.tp_diseno.Enumerations.TipoPizarron;

public class AulaLaboratorio extends AulaGeneral{
    private int cantidadDePCs;

    public AulaLaboratorio(){}
    public AulaLaboratorio(TipoAula tipo,String ubicacion,boolean estado,int capacidad,int piso,
                    TipoPizarron tipoDePizarron, boolean ventiladores, boolean aireAcondicionado,boolean habilitado,int cantidadDePCs){
        super(tipo,ubicacion,estado,capacidad,piso,tipoDePizarron,ventiladores,aireAcondicionado,habilitado);
        this.cantidadDePCs=cantidadDePCs;
    }
    
    public int getCantidadDePCs() {
        return cantidadDePCs;
    }

    public void setCantidadDePCs(int cantidadDePCs) {
        this.cantidadDePCs = cantidadDePCs;
    }
    
    
}
