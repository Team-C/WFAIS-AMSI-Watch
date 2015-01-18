package sound;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

/**
 *
 * @author Bartosz Bereza
 */
public class ToneGenerator {

    private static boolean stop = false;

    public static void genButtonATone() {
        try {
            generateTone(1000, 100, 128, true);
        } catch (LineUnavailableException lue) {
            System.out.println(lue);
        }
    }

    public static void genButtonBTone() {
        try {
            generateTone(500, 100, 128, true);
        } catch (LineUnavailableException lue) {
            System.out.println(lue);
        }
    }

    public static void genAlarmTone() {
        Timer timer = new Timer();
        stop = false;
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                if (stop) {
                    cancel();
                }
                try {
                    generateTone(1000, 1000, 128, true);
                } catch (LineUnavailableException ex) {
                    Logger.getLogger(ToneGenerator.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }, 0, 1000);
    }

    public static void stopAlarm() {
        stop = true;
    }

    private static void generateTone(int hz, int msecs, int volume, boolean addHarmonic)
            throws LineUnavailableException {

        float frequency = 44100;
        byte[] buf;
        AudioFormat af;
        if (addHarmonic) {
            buf = new byte[2];
            af = new AudioFormat(frequency, 8, 2, true, false);
        } else {
            buf = new byte[1];
            af = new AudioFormat(frequency, 8, 1, true, false);
        }
        SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
        sdl = AudioSystem.getSourceDataLine(af);
        sdl.open(af);
        sdl.start();
        for (int i = 0; i < msecs * frequency / 1000; i++) {
            double angle = i / (frequency / hz) * 2.0 * Math.PI;
            buf[0] = (byte) (Math.sin(angle) * volume);

            if (addHarmonic) {
                double angle2 = (i) / (frequency / hz) * 2.0 * Math.PI;
                buf[1] = (byte) (Math.sin(2 * angle2) * volume * 0.6);
                sdl.write(buf, 0, 2);
            } else {
                sdl.write(buf, 0, 1);
            }
        }
        sdl.drain();
        sdl.stop();
        sdl.close();
    }
}
