
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

    public AulaLaboratorio(int id, TipoAula tipo_aula, String ubicacion, Boolean estado, Integer capacidadAula, Integer piso, TipoPizarron tipo_pizarron, Boolean ventiladores, Boolean aire_acondicionado, Boolean habilitado, Integer cantidadPcs) {
        super(id,tipo_aula,ubicacion,estado,capacidadAula,piso,tipo_pizarron,ventiladores,aire_acondicionado,habilitado);
        this.cantidadDePCs=cantidadPcs;    
    }
    
    public int getCantidadDePCs() {
        return cantidadDePCs;
    }

    public void setCantidadDePCs(int cantidadDePCs) {
        this.cantidadDePCs = cantidadDePCs;
    }
    
    
}
