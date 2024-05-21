import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class Task1 extends JFrame{
    JButton I1;
    JTextField t1,t2;
    JLabel b1,b2,b3;
    eWork kn = new eWork();
    public Task1 (String s) {
        super(s);
        setLayout(new FlowLayout());
        b1 = new JLabel("Введите текст до 25 символов");
        b2 = new JLabel("Укажите путь к файлу");
        I1 = new JButton("Запись");
        t1 = new JTextField(25);
        t2 = new JTextField(25);
        b3 = new JLabel("                      ");
        t1.addKeyListener(new KeyAdapter(){
                              @Override
                              public void keyTyped(KeyEvent e) {
                                  if (t1.getText().length() >= 25) {
                                      e.consume();
                                  }
                              }
                          }
        );

        add(b1);
        add(t1);
        add(b2);
        add(t2);
        add(I1);
        add(b3);
        I1.addActionListener(kn);
    }
    public static void main(String[] args){
        Task1 g = new Task1("Запись");
        g.setVisible(true);
        g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        g.setSize(500, 125);
        g.setResizable(false);
        g.setLocationRelativeTo(null);

    }
    public class eWork implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                if (e.getSource()==I1) {
                    String text,put;
                    text = t1.getText();
                    put = t2.getText();
                    File file=new File(put);
                    FileWriter fwrite = null;
                    try {
                        fwrite = new FileWriter(file);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    fwrite.write(text);
                    fwrite.close();
                    b3.setText("Запись произошла успешно");
                }

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(Task1.this, "адрес или текст введен(ы) неправильно"); }

        }
    }
}
