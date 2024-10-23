/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo3a.tp_diseno.Modelos;

/**
 *
 * @author gabic
 */
public class AulaMultimedios extends AulaGeneral{
    private boolean televisor;
    private boolean cañon;
    private boolean computadora;

    public boolean isTelevisor() {
        return televisor;
    }

    public void setTelevisor(boolean televisor) {
        this.televisor = televisor;
    }

    public boolean isCañon() {
        return cañon;
    }

    public void setCañon(boolean cañon) {
        this.cañon = cañon;
    }

    public boolean isComputadora() {
        return computadora;
    }

    public void setComputadora(boolean computadora) {
        this.computadora = computadora;
    }
}
