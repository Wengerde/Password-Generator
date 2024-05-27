import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        JFrame passwordGenerator = new JFrame("Passwort Generator");
        passwordGenerator.setSize(400, 300);
        passwordGenerator.setLocation(300, 200);
        passwordGenerator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // JTextArea to display the generated password
        final JTextArea generateArea = new JTextArea();
        generateArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(generateArea);

        // JSlider for selecting password length
        final JSlider lengthSlider = new JSlider(JSlider.HORIZONTAL, 15, 30, 15);
        lengthSlider.setMajorTickSpacing(5);
        lengthSlider.setMinorTickSpacing(1);
        lengthSlider.setPaintTicks(true);
        lengthSlider.setPaintLabels(true);

        // JCheckBox for including special characters
        final JCheckBox specialCharCheckBox = new JCheckBox("Sonderzeichen einbeziehen");

        // JButton to trigger password generation
        final JButton button = new JButton("erzeugen");

        // JPanel to hold the slider and checkbox
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
        controlPanel.add(new JLabel("Passwortlänge:"));
        controlPanel.add(lengthSlider);
        controlPanel.add(specialCharCheckBox);

        passwordGenerator.getContentPane().add(controlPanel, BorderLayout.NORTH);
        passwordGenerator.getContentPane().add(scrollPane, BorderLayout.CENTER);
        passwordGenerator.getContentPane().add(button, BorderLayout.SOUTH);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int length = lengthSlider.getValue();
                boolean includeSpecialChars = specialCharCheckBox.isSelected();
                String generatedPassword = generatePassword(length, includeSpecialChars);
                generateArea.append(generatedPassword + "\n");
            }
        });

        passwordGenerator.setVisible(true);
    }

    // Method to generate a password with specified length and option for special characters
    private static String generatePassword(int length, boolean includeSpecialChars) {
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String specialChars = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/`~";

        String characterSet = upperCase + lowerCase + digits;
        if (includeSpecialChars) {
            characterSet += specialChars;
        }

        Random random = new Random();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characterSet.length());
            password.append(characterSet.charAt(index));
        }
        return password.toString();
    }
}
