package views;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwitchUser extends JFrame {
    private JButton mewtwoButton;
    private JButton Decidueye;
    private JButton Charizard;
    private JButton PikachuButton;
    private JPanel contentPane;

    public SwitchUser() {
        setTitle("Video Catalogue");
        add(contentPane);
        setVisible(true);
        setSize(400, 300);


        mewtwoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.changeProfile(0);
                dispose();
            }
        });
        PikachuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.changeProfile(1);
                dispose();
            }
        });
        Charizard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.changeProfile(2);
                dispose();
            }
        });
        Decidueye.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.changeProfile(3);
                dispose();
            }
        });
    }

}