package andorcastle.services;

public class eAndorCastleEnumerations {
    public static eAndorCastleEnumerations instance = null;

    private eAndorCastleEnumerations (){
        setActiveComponent(components.Main);
    }

    public static eAndorCastleEnumerations getInstance(){
        if (instance == null)
            instance = new eAndorCastleEnumerations();
        return instance;
    }

    public enum components{
        Main,
        Trello,
        Wunderlist
    }

    private components activeComponent;

    public components getActiveComponent() {
        return activeComponent;
    }

    public void setActiveComponent(components activeComponent) {
        this.activeComponent = activeComponent;
    }
}
