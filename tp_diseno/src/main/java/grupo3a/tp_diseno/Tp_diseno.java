package grupo3a.tp_diseno;

import grupo3a.tp_diseno.Vista.Interfaz;
import grupo3a.tp_diseno.Vista.Alerta;
import grupo3a.tp_diseno.Vista.Bedel.RegistrarReserva.EsporadicaDias;
import grupo3a.tp_diseno.Vista.Bedel.RegistrarReserva.ResultadosAulas;
import grupo3a.tp_diseno.Vista.Bedel.RegistrarReserva.RegistrarReservaDatos;
import grupo3a.tp_diseno.Vista.Bedel.RegistrarReserva.TipoPeriodicaHorarios;
import grupo3a.tp_diseno.Vista.Bedel.RegistrarReserva.TipoPeriodicaDias;
import grupo3a.tp_diseno.Vista.Bedel.RegistrarReserva.SeleccionTipoReserva;
import grupo3a.tp_diseno.Gestores.GestorReserva;
import grupo3a.tp_diseno.Enumerations.DiaSemana;
import grupo3a.tp_diseno.Enumerations.TipoAula;
import grupo3a.tp_diseno.Modelos.AulaGeneral;
import grupo3a.tp_diseno.Modelos.AulaLaboratorio;
import grupo3a.tp_diseno.Modelos.DetalleReserva;

import java.awt.CardLayout;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tp_diseno {

    /*
        bedel_prueba1 contraseña: Bedel_prueba1$
        bedel_prueba2 contraseña: Bedel_prueba2$
        Admin contraseña: Admin_general$1
    */
    private static Interfaz interfaz;

    public static void main(String[] args) {
        interfaz = Interfaz.getInstance();

    }
}
