/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo3a.tp_diseno.Exceptions;

/**
 *
 * @author imsac
 */
public class Exceptions {
    public static class UIException extends Exception {
        public UIException(String msg) {
            super(msg);
        }
    }
    
    public static class ValueException extends Exception {
        public ValueException(String msg) {
            super(msg);
        }
    }
    
    public static class DAOException extends Exception {
        public DAOException(String msg) {
            super(msg);
        }
    }
    
    public static class NoExisteAulaException extends Exception {
        public NoExisteAulaException(String msg) {
            super(msg);
        }
    }
}
