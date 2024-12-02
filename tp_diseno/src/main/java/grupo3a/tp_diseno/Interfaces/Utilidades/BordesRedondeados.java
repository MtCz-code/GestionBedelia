
package grupo3a.tp_diseno.Interfaces.Utilidades;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;

import javax.swing.border.Border;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class BordesRedondeados implements Border {
  private int radio;
  private Color favColor= Color.decode("#111111");

  public BordesRedondeados(int radio) {
    this.radio = radio;
  }

  @Override
  public Insets getBorderInsets(Component c) {
    return new Insets(radio,radio,radio,radio);
  }

  @Override
  public boolean isBorderOpaque() {
    return false;
  }

  @Override
  public void paintBorder(Component c,Graphics g,int x,int y,int width,int height) {
    Graphics2D g2=(Graphics2D)g;
    g2.setColor(favColor);
    g2.setStroke(new BasicStroke(3.0f));
    g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON));
    g2.drawRoundRect(x+1,y+1,width-3,height-3,radio,radio);
  }
}
    

