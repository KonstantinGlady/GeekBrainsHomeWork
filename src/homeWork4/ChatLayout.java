package homeWork4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatLayout extends JFrame {

    private DefaultListModel listModel = new DefaultListModel();
    private JTextField textField = new JTextField(30);


    public ChatLayout(){
        JFrame frame = new JFrame("chat");
        frame.setBounds(200,200,400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = frame.getContentPane();

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,10,10));

        ActionListener textFieldListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listModel.addElement(textField.getText());
                textField.setText("");
            }
        };

        textField.addActionListener(textFieldListener);

        textField.setFont(new Font("Dialog",Font.BOLD,18));
        bottomPanel.add(textField);

        JButton button = new JButton("Кнопка");

        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listModel.addElement(textField.getText());
                textField.setText("");
            }
        };

        button.addActionListener(buttonListener);

        bottomPanel.add(button);

        JPanel centralPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));


        JList<String> list = new JList<>();
        list.setPreferredSize(new Dimension(600,500));
        list.setModel(listModel);

         centralPanel.add(list);


        container.add(centralPanel,BorderLayout.CENTER);
        container.add(bottomPanel,BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }


}
