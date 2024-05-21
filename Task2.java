import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
        public class Task2 extends JFrame{
            JButton zap,viv;
            JTextField t2,name,tham,otch,date,group;
            JLabel b1,b2,name1,tham1,otch1,date1,group1;
            String text,put;
            eWork kn = new eWork();
            public Task2 (String s) {
                super(s);
                setLayout(new FlowLayout());
                name1 = new JLabel("Введите имя");
                otch1 = new JLabel("Введите отчество");
                tham1 = new JLabel("Введите фамилию");
                date1 = new JLabel("Введите дату рождения");
                group1 = new JLabel("Укажите учебную группу");
                b2 = new JLabel("Введите адрес файла ");
                t2 = new JTextField(25);
                name = new JTextField(31);
                tham = new JTextField(27);
                otch = new JTextField(28);
                date = new JTextField(25);
                group = new JTextField(25);
                b1 = new JLabel("                      ");
                viv = new JButton("Вывод");
                zap = new JButton("Запись");

                add(b2);add(t2);
                add(tham1);add(tham);
                add(name1);add(name);
                add(otch1);add(otch);
                add(date1);add(date);
                add(group1);add(group);

                add(zap);
                add(viv);
                add(b1);

                zap.addActionListener(kn);
                viv.addActionListener(kn);
            }
            public static void main(String[] args){
                Task2 g = new Task2("Студентик");
        g.setVisible(true);
        g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        g.setSize(450, 300);
        g.setResizable(false);
        g.setLocationRelativeTo(null);

    }
    public class eWork implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                if (e.getSource()==zap) {
                    text = tham.getText()+"\s"+name.getText()+"\s"+otch.getText()+"\s"+date.getText()+"\s"+group.getText();
                    put = t2.getText();
                    File file=new File(put);
                    try {
                        FileWriter fwrite = new FileWriter(file);
                        fwrite.write(text);
                        fwrite.close();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }

                    b1.setText("Запись произошла успешно");
                } else if (e.getSource() == viv) {
                    put = t2.getText();
                    File file=new File(put);
                    BufferedReader fread = new BufferedReader(new FileReader(file));
                    text = fread.readLine();
                    b1.setText("Вывод записи:\s"+text);

                }

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Aдрес или текст введен(ы) неправильно"); }

        }
    }
}
