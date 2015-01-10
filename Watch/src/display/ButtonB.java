package display;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

/**
 *
 * @author Bartosz Bereza
 */
public class ButtonB extends JButton implements ActionListener {
    
    ClockPanel cPanel;

    ButtonB(String text, ClockPanel cPanel) {
        this.setText(text);
        this.cPanel = cPanel;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        core.StateProcessor.shortPressB();
        cPanel.refresh();
    }
}
