package mvc;

public interface AppFactory {
    Model getModel();
    String[] getEditService();
    Service makeEditService(Model model, String type);
    String getTitle();
    String[] getHelp();
    String getAbout();
}
