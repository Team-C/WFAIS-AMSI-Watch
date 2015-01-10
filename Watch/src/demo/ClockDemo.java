package demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class ClockDemo {

    static private final JLabel time = new JLabel();
    private static JPanel pnlButton = new JPanel();
    private static JPanel pnlButton2 = new JPanel();
    private static JPanel pnlButton3 = new JPanel();
    private static JButton button = new JButton("TG");
    private static JButton button2 = new JButton("STOP");
    private static JButton button3 = new JButton("START");
    static private final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm ss");
    static private final SimpleDateFormat sdf12 = new SimpleDateFormat("hh:mm ss a");
    static private Calendar calendar;
    private static boolean timerModeIs24h = true;
    private static boolean stop = false;

    public static void main(String[] args) {
        JFrame frame = new JFrame();

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timerModeIs24h = !timerModeIs24h;
            }
        });
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stop();
            }
        });
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                start();
            }
        });
        button.setBounds(0, 0, 50, 50);
        button2.setBounds(50, 50, 50, 50);
        button3.setBounds(100, 100, 50, 50);
        pnlButton.setBounds(0, 0, 50, 50);
        pnlButton2.setBounds(50, 50, 50, 50);
        pnlButton3.setBounds(100, 100, 50, 50);
        pnlButton.add(button);
        pnlButton2.add(button2);
        pnlButton3.add(button3);
        frame.add(pnlButton);
        frame.add(pnlButton2);
        frame.add(pnlButton3);
        ClockDemo clock = new ClockDemo();
        frame.add(clock.time);
        //frame.add(button);
        frame.pack();
        frame.setSize(300, 300);
        frame.setVisible(true);
        clock.start();
    }

    private static void reset() {
        stop = false;
        calendar = Calendar.getInstance();
    }

    static public void stop() {
        stop = true;
    }

    static private void increment() {
        calendar.add(Calendar.SECOND, 1);
    }

    public static void start() {
        reset();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                increment();
                if (stop) {
                    cancel();
                }
                if (timerModeIs24h) {
                    time.setText(sdf.format(calendar.getTime()));
                } else {
                    time.setText(sdf12.format(calendar.getTime()));
                }
            }
        }, 0, 1000);
    }
}
