import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class main {

    public static void main(String[] args) {

        JFrame passwordGenertor = new JFrame("Passwort Generator");
        passwordGenertor.setSize(300, 300);
        passwordGenertor.setLocation(300,200);
        final JTextArea textArea = new JTextArea(10, 40);
        passwordGenertor.getContentPane().add(BorderLayout.CENTER, textArea);
        final JButton button = new JButton("erzeugen");
        passwordGenertor.getContentPane().add(BorderLayout.SOUTH, button);
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append("Button was clicked\n");

            }
        });

        passwordGenertor.setVisible(true);

    }
}
