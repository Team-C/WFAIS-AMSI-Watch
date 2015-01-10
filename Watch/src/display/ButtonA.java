package display;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author Bartosz Bereza
 */
public class ButtonA extends JButton implements ActionListener {

    ClockPanel cPanel;
    
    ButtonA(String text, ClockPanel cPanel) {
        this.setText(text);
        this.cPanel = cPanel;
        addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        core.StateProcessor.shortPressA();
        cPanel.refresh();
    }
}
