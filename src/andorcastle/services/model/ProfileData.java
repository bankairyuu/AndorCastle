package andorcastle.services.model;

public class ProfileData {
    String profilePictureURL;
    String profileName;
    TrelloData trelloData;
    WunderlistData wunderlistData;

    public String getProfilePictureURL() {
        return profilePictureURL;
    }

    public void setProfilePictureURL(String profilePictureURL) {
        this.profilePictureURL = profilePictureURL;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public TrelloData getTrelloData() {
        return trelloData;
    }

    public void setTrelloData(TrelloData trelloData) {
        this.trelloData = trelloData;
    }

    public WunderlistData getWunderlistData() {
        return wunderlistData;
    }

    public void setWunderlistData(WunderlistData wunderlistData) {
        this.wunderlistData = wunderlistData;
    }
}
