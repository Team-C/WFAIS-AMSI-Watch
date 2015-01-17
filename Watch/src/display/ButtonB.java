package display;

import javax.swing.JButton;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Bartosz Bereza
 */
public class ButtonB extends JButton implements MouseListener {
    
    ClockPanel cPanel;
    private boolean holding = false;
    private Timer t;
    private int pressStatus = 0;
    

    ButtonB(String text, ClockPanel cPanel) {
        this.setText(text);
        this.cPanel = cPanel;
        addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        pressStatus = 0;

        if (t == null) {
            t = new Timer();
        }
        t.schedule(new TimerTask() {
            public void run() {
                pressStatus = 1;

                if (t != null) {
                    t.cancel();
                    t = null;
                }

                // PRESSED LONG
                core.StateProcessor.longPressB();
                cPanel.refresh();
                System.out.println("longPressB");
            }
        }, 1000, 1);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (t != null) {
            t.cancel();
            t = null;
        }

        // PRESSED SHORT LIKE CLICK
        if (pressStatus == 0) {
            core.StateProcessor.shortPressB();
            cPanel.refresh();
            System.out.println("shortPressB");
        }

        pressStatus = 0;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
