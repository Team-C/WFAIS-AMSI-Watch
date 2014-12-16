package demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Clock {

    private final JLabel time = new JLabel();
    private static JPanel pnlButton = new JPanel();
    private static JButton button = new JButton("TG");
    private final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm ss");
    private final SimpleDateFormat sdf12 = new SimpleDateFormat("hh:mm ss a");
    private Calendar calendar;
    private static boolean timerModeIs24h = true;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timerModeIs24h = !timerModeIs24h;
            }
        });
        button.setBounds(0, 0, 50, 50);
        pnlButton.setBounds(0, 0, 50, 50);
        pnlButton.setLayout(null);
        pnlButton.add(button);
        frame.add(pnlButton);
        Clock clock = new Clock();
        frame.add(clock.time);
        //frame.add(button);
        frame.pack();
        frame.setSize(100, 300);
        frame.setVisible(true);
        clock.start();
    }

    private void reset() {
        calendar = Calendar.getInstance();
    }

    private void increment() {
        calendar.add(Calendar.SECOND, 1);
    }

    public void start() {
        reset();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                increment();
                if (timerModeIs24h) {
                    time.setText(sdf.format(calendar.getTime()));
                } else {
                    time.setText(sdf12.format(calendar.getTime()));
                }
            }
        }, 0, 1000);
    }
}
