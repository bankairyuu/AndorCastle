package andorcastle.services;

import andorcastle.enumerations.eSurface;
import andorcastle.services.model.ProfileData;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.scene.image.Image;

import java.io.File;
import java.io.IOException;

public class OnlineData {
// --- / Singleton / ----
    private static ProfileData profileData;
    private static OnlineData instance;
    private OnlineData() {
        activeSurface = eSurface.Main;
        profileData = new ProfileData();

        userData();
    }
    public static OnlineData getInstance() {
        if (instance == null)
            instance = new OnlineData();
        return instance;
    }
// --- / Singleton / ----


    private eSurface activeSurface;
    private Image image;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public eSurface getActiveSurface() {
        return activeSurface;
    }

    public void setActiveSurface(eSurface activeSurface) {
        this.activeSurface = activeSurface;
    }


    private void userData(){
        File userData = new File("user.dat");
        if (userData.exists() && !userData.isDirectory()){
            loadUserDatas();
        }else{
            setDefaults();
        }
    }

    private void setDefaults(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("profile/defprofil.png").getFile());
        setImage(new Image(file.toURI().toString()));

        profileData.setWhoAmI("Who am I?");
        profileData.setKey("key");
        profileData.setProfilePicPath(file.toURI().toString());

        flush();
    }

    private void loadUserDatas(){

    }

    private void flush(){
        File userData = new File("user.dat");
        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writeValue(userData, profileData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
