package views;

import controller.Controller;
import controller.ListController;
import model.Film;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainView extends JFrame {
    private JPanel contentPane;
    private JButton listByGenreButton;
    private JButton listByYearButton;
    private JButton addNewItemButton;
    private JButton switchUserButton;
    private JPanel list;
    private JLabel user;

    public MainView() {
        setTitle("Video Catalogue");
        add(contentPane);
        setVisible(true);
        setSize(1000, 500);

        addNewItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ItemDetails itemDetails = new ItemDetails();
            }
        });
        switchUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwitchUser switchUser = new SwitchUser();

            }
        });
        listByGenreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListController listController = new ListController("Genre");
            }
        });
        listByYearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListController listController = new ListController("Year");
            }
        });
    }

    public void setPreferredGenreList(ArrayList<String[]> prefGenreList) {
        list.removeAll();
        list.setLayout(new GridLayout(prefGenreList.size(), 5));
        JButton[] buttons = new JButton[prefGenreList.size()];
        for (int i=0; i < prefGenreList.size(); i++){
            JLabel[] prefGenreLabels = new JLabel[5];
            for(int detail = 0; detail < 4; detail++) {
                prefGenreLabels[detail] = new JLabel(prefGenreList.get(i)[detail]);
                list.add(prefGenreLabels[detail]);
            }
            JButton b1 = new JButton("More Info");
            b1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ItemDetails itemDetails = new ItemDetails();
                }
            } );
            buttons[i] = b1;
            list.add(buttons[i]);
        }
        validate();
        repaint();
    }
    public void setUser(String user) {
        this.user.setText("User: "+user);
    }

}
