package controller;

import model.Film;
import model.Genre;
import model.Media;
import runtime.Application;
import views.MainView;
import views.SortBy;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.TreeSet;

//controller classes controls the views of list UI
public class ListController {
    private static SortBy sortBy;
    private static JPanel[] j;
    private static MainView mainView;
    private static Media media;
    private static String[] details;
    private static ArrayList<String[]> videos;
    private static TreeSet<Integer> years;
    private static String genres;

    //main method, takes in sort type (Genre or by Year)
    public ListController(String sort){
        //get json objects from application
        this.media = Application.getAllMedia();
        sortBy = new SortBy();
        sortBy.setLayout(new GridLayout(0, 3));
        sortBy.setTitle("Listed By" + sort);

        //sorts by year
        if(sort.equals("Year")){
            years = new TreeSet<>(); //tree set removes duplication
            for(Film f : media.getFilms()) {
                years.add(f.getYear()); //save all years
            }
            for(int year : years){ //for every year find the videos that match
                JLabel yearLabel = new JLabel("<html><font color='red'>" + year + "</font></html>");
                sortBy.add(yearLabel);
                sortBy.add(new JLabel());
                sortBy.add(new JLabel()); //needed to maintain grid layout
                for (Film f2 : media.getFilms()) {
                    genres = "";
                    for (int genre : f2.getGenre()) {
                        for (Genre g : media.getGenres())
                            if (g.getGid() == genre) {
                                genres += g.getGenre() + ". ";
                            } //converts gid to string of genres
                    }
                    if (f2.getYear() == year) { // if mathches in loop then add string label to panel
                        sortBy.add(new JLabel(f2.getTitle()));
                        Component add = sortBy.add(new JLabel(genres));
                        sortBy.add(new JLabel("More info"));
                        } //sets panel for view
                    }
                }
            }

        //if sort by genre
        if(sort.equals("Genre")){
            for(Genre g : media.getGenres()) {
                sortBy.add(new JLabel("<html><font color='red'>"+g.getGenre()+"</font></html>"));
                sortBy.add(new JLabel());
                sortBy.add(new JLabel());
                for (Film f : media.getFilms()) {
                    for (int genre : f.getGenre()) {
                        if (g.getGid() == genre) {
                            sortBy.add(new JLabel(f.getTitle()));
                            sortBy.add(new JLabel(""+f.getYear()));
                            sortBy.add(new JLabel("More info"));
                        } //iterates movies and finds matching genres
                    }
                }
            }
        }

    }
}
