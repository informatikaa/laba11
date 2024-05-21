import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Task4 extends JFrame {
    private JTextField textField;

    public Task4() {
        setTitle("Random Numbers Generator");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textField = new JTextField(10);
        textField.setEditable(false);

        JButton generateButton = new JButton("Сгенерируйте числа");
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder numbers = new StringBuilder();
                Random random = new Random();
                for (int i = 0; i < 7; i++) {
                    numbers.append(random.nextInt(100)).append("\n");
                }
                textField.setText(numbers.toString());
            }
        });

        JPanel panel = new JPanel();
        panel.add(generateButton);
        panel.add(textField);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Task4();
            }
        });
    }
}
