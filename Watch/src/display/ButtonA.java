package display;

import javax.swing.JButton;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.util.TimerTask;
import java.util.Timer;

/**
 *
 * @author Bartosz Bereza
 */
public class ButtonA extends JButton implements MouseListener {

    ClockPanel cPanel;
    private boolean holding = false;
    private Timer t;
    private int pressStatus = 0;

    ButtonA(String text, ClockPanel cPanel) {
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
                core.StateProcessor.longPressA();
                cPanel.refresh();
                System.out.println("longPressA");
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
            core.StateProcessor.shortPressA();
            cPanel.refresh();
            System.out.println("shortPressA");
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
