package debug;

import java.util.*;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JLabel;

class Clock {

    private final JLabel time = new JLabel();
    private final SimpleDateFormat sdf = new SimpleDateFormat("hh:mm ss a");
    private int currentSecond;
    private Calendar calendar;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Clock clock = new Clock();
        frame.add(clock.time);
        frame.pack();
        frame.setSize(50, 50);
        frame.setVisible(true);
        clock.start();
    }

    private void reset() {
        calendar = Calendar.getInstance();
        currentSecond = calendar.get(Calendar.SECOND);
    }

    public void start() {
        reset();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                if (currentSecond == 60) {
                    reset();
                }
                time.setText(sdf.format(calendar.getTime()));
                currentSecond++;
            }
        }, 0, 1000);
    }
}
