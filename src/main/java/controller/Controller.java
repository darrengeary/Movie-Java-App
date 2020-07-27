package controller;

import model.*;
import runtime.Application;
import views.MainView;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Controller {

    private static Media media;
    private static Profile selectedProfile;
    private static MainView mainView;
    private static boolean duplicate;

    public void startView() {
        this.media = Application.getAllMedia();
        this.mainView = new MainView();
    }

    public static void setNewItem(String title, String description, Integer year, String director, String genre, String cast) {
        TreeSet<Integer> intArray = new TreeSet<Integer>();
        List<Film> films = media.getFilms();
        List<Genre> genreList = media.getGenres();
        List<Person> peopleList =  media.getPeople();

        media = Application.getAllMedia();
        Film film = new Film();
        film.setTitle(title);
        film.setDescription(description);
        film.setYear((Integer)year);

        String[] directorText = director.split("\\W+");
        String[] genresText = genre.split("\\W+");
        String[] castText = cast.split("\\W+");

        //genre duplicate
        int genSize = genreList.size();
        int genStrSize = genresText.length;

        for(int i = 0; i < genSize; i++){
            for (int x = 0; x < genStrSize; x++){
                if(genreList.get(i).getGenre().equals(genresText[x])) {
                    intArray.add(genreList.get(i).getGid());
                    }
                else{
                    Genre gen = new Genre();
                    intArray.add(genreList.size() + 1);
                    gen.setGid(genreList.size() + 1);
                    gen.setGenre(genresText[x]);
                    genreList.add(gen);
                }
            }
        }
        duplicate = false;
        List<Integer> inteArray = new ArrayList<>();
        for(int i : intArray)
            inteArray.add(i);
            film.setGenre(inteArray);

            intArray = new TreeSet<Integer>();
            //genre duplicate
            duplicate = false;
            for (String s : castText) {
                System.out.println(s);
                for (Person p : peopleList) {
                    System.out.println(p);
                    if (p.getName().equals(s)) {
                        System.out.println(p.getPid());
                        duplicate = true;
                        intArray.add(p.getPid());
                    }
                }
            }
            //cast not duplicate
            if (duplicate == false) {
                System.out.println("false");
                for (String s : castText) {
                    System.out.println(genresText);
                    Person cast1 = new Person();
                    intArray.add(peopleList.size() + 1);
                    cast1.setPid(peopleList.size() + 1);
                    cast1.setName(s);
                    peopleList.add(cast1);
                }
            }

            film.setCast(inteArray);

            duplicate = false;
            for (String d : directorText) {
                for (Person p : peopleList) {
                    if (p.getName().equals(d))
                        duplicate = true;
                    film.setDirector(p.getPid());
                }
            }
            for (String d : directorText) {
                if (duplicate == false) {
                    Person p = new Person();
                    film.setDirector(peopleList.size() + 1);
                    p.setPid(peopleList.size() + 1);
                    p.setName(d);
                    peopleList.add(p);
                }
            }

            film.setFid(media.getFilms().size() + 1);
            films.add(film);
            media.setPeople(peopleList);
            media.setFilms(films);

            Application.setMedia(media);
            }

    public static void changeProfile(int iD) {
        selectedProfile = media.getProfiles().get(iD);
        setPreferredGenreList();
        mainView.setUser(selectedProfile.getName());
    }

    public String getProfileName(){
        return selectedProfile.getName();
    }

    public static void setPreferredGenreList() {

        ArrayList<String[]> preferredVideos = new ArrayList<>();

        for (Film f : media.getFilms()) {
            String video[] = new String[4];
            String genres = "";
            System.out.println(f.getGenre());
            for (int genre : f.getGenre()) {
                for (Genre g : media.getGenres())
                    if (g.getGid() == genre) {
                        genres += g.getGenre() + ". ";
                    }
            }

            for (int genre : f.getGenre()) {
                String director = null;
                for(Person p : media.getPeople())
                    if(p.getPid() == f.getDirector()) {
                        director = p.getName();
                    }

                if (selectedProfile.getPreferredGenre() == genre) {
                    video[0] = f.getTitle();
                    video[1] = ""+f.getYear();
                    video[2] = genres;
                    video[3] = director;
                    preferredVideos.add(video);
                }

            }
        }
        mainView.setPreferredGenreList(preferredVideos);
    }
    public void setMedia(Media media) {
        this.media = media;
    }

}