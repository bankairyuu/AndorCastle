package andorcastle.services;

import andorcastle.enumerations.eSurface;

public class OnlineData {
    private static OnlineData instance;

    private OnlineData() {
        activeSurface = eSurface.Main;
    }

    public static OnlineData getInstance() {
        if (instance == null)
            instance = new OnlineData();
        return instance;
    }

    private eSurface activeSurface;

    public eSurface getActiveSurface() {
        return activeSurface;
    }

    public void setActiveSurface(eSurface activeSurface) {
        this.activeSurface = activeSurface;
    }
}
