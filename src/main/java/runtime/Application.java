package runtime;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import controller.Controller;
import controller.ListController;
import model.Film;
import model.Media;
import views.MainView;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Application {

    private static Controller controller;
    private static Media allMedia;

    public static Media getAllMedia() {
        return allMedia;
    }

    public static void main (String args[]) {
        try{
        ObjectMapper map = new ObjectMapper();
        ClassLoader classLoader = new Application().getClass().getClassLoader();
        File jsonFile = new File(classLoader.getResource("data.json").getFile());
        String jsonString = new String(Files.readAllBytes(jsonFile.toPath()));
        allMedia = map.readValue(jsonString, Media.class);
        Controller controller = new Controller();
        controller.startView();
        controller.changeProfile(1);

        }catch(JsonParseException e){
            e.printStackTrace();
        }catch (JsonMappingException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void setMedia(Media media) {
       allMedia = media;
    }
}
