package SwipeApp;

import SwipeApp.models.SwipeApp;
import mvc.AppFactory;
import mvc.Model;
import mvc.Service;

public class SwipeAppFactory implements AppFactory {

    private static SwipeApp model;

    public SwipeAppFactory() {
        model = new SwipeApp();
    }

    @Override
    public Model getModel() {
        return model;
    }

    @Override
    public String[] getEditService() {
        return new String[0];
    }

    @Override
    public Service makeEditService(Model model, String type) {
        return null;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public String[] getHelp() {
        return new String[0];
    }

    @Override
    public String getAbout() {
        return null;
    }
}
