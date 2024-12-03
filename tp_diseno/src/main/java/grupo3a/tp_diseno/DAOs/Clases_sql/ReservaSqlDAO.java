
package grupo3a.tp_diseno.DAOs.Clases_sql;

import grupo3a.tp_diseno.DAOs.ReservaDAO;
import grupo3a.tp_diseno.Modelos.Reserva;



public class ReservaSqlDAO implements ReservaDAO{

    public ReservaSqlDAO() {
    }
   
    //singleton
    private static ReservaSqlDAO instance;
    public static ReservaSqlDAO getInstance(){
        if(ReservaSqlDAO.instance == null)ReservaSqlDAO.instance =  new ReservaSqlDAO();
        return ReservaSqlDAO.instance;
    }

    @Override
    public Integer crear(Reserva reserva) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
