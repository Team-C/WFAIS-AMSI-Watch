package demo;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.*;

public class LongPressedButton {

    private JTextField textField = new JTextField(20);
    private JButton button = new JButton("a");
    private String[] aaa = {"a", "ä", "á"};
    private int index = 0;
    private Timer timer = new Timer(1000, new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            index++;
            if (index == aaa.length) {
                index = 0;
            }
            button.setText(aaa[index]);
        }
    });

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                new LongPressedButton().makeUI();
            }
        });
    }

    public void makeUI() {
        button.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                timer.start();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                timer.stop();
            }
        });
        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                textField.setText(textField.getText() + button.getText());
            }
        });

        JFrame frame = new JFrame();
        frame.add(textField, BorderLayout.CENTER);
        frame.add(button, BorderLayout.SOUTH);
        frame.pack();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
