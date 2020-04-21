package SwipeApp.models;

public class ApplicationUser {
    String name;
    int id;
    SwipeSession currentSession;

    public void setCurrentSession(SwipeSession currentSession) {
        this.currentSession = currentSession;
    }

    public boolean addToSession(SwipeItem item){
        return currentSession.addAcceptedItem(this,item);
    }

    @Override
    public String toString() {
        return name + " " + id;
    }
}
