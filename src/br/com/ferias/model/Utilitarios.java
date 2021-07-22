
package br.com.ferias.model;

import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Utilitarios {
    public void limpaTela(JPanel panel){
        Component cp[] = panel.getComponents();
        for (Component component : cp) {
            if (component instanceof JTextField) {
                ((JTextField) component).setText(null);
            }
        }
    }
}
