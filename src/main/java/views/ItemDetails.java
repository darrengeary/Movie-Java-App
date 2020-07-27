package views;

import controller.Controller;
import model.Film;
import model.Genre;
import model.Media;
import runtime.Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ItemDetails extends JFrame {
    private JPanel contentPanel;
    private JTextArea description;
    private JSpinner year;
    private JTextField genre;
    private JTextField director;
    private JCheckBox tvseries;
    private JButton saveButton;
    private JTextArea cast;
    private JTextField title;

    private Media allMedia;

    public ItemDetails() {
        allMedia = Application.getAllMedia();
        setTitle("Item Details");
        add(contentPanel);
        setVisible(true);
        setSize(600, 1000);

        saveButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                Controller.setNewItem(title.getText(), description.getText(), (Integer)year.getValue(), director.getText(), genre.getText(), cast.getText());
            }        });
    }

}
