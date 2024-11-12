/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo3a.tp_diseno.Modelos;

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
}
