package andorcastle.services.model;

import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

public class ProfileData {
    private String whoAmI;
    private String key;
    private String profilePicPath;
    private Image profilPic;
    private Map<ProfilType, EmbeddedProfile> embeddedProfileMap;

    public ProfileData() {
        embeddedProfileMap = new HashMap<>();
    }

    public String getProfilePicPath() {
        return profilePicPath;
    }

    public void setProfilePicPath(String profilePicPath) {
        this.profilePicPath = profilePicPath;
    }

    public Image getProfilPic() {
        return profilPic;
    }

    public void setProfilPic(Image profilPic) {
        this.profilPic = profilPic;
    }

    public String getWhoAmI() {
        return whoAmI;
    }

    public void setWhoAmI(String whoAmI) {
        this.whoAmI = whoAmI;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Map<ProfilType, EmbeddedProfile> getEmbeddedProfileMap() {
        return embeddedProfileMap;
    }
}
