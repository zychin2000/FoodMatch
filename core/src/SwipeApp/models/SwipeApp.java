package SwipeApp.models;

import SwipeApp.exceptions.UserNotFoundException;
import mvc.Model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SwipeApp extends Model {
    private Set<SwipeSession> swipeSessions;
    private Map<ApplicationUser,SwipeSession> userSessionMap;

    public SwipeApp(){
        swipeSessions = new HashSet<>();
        userSessionMap = new HashMap<>();
    }

    public void addNewSession(ApplicationUser initiator, ApplicationUser receiver){
        SwipeSession swipeSession = new SwipeSession(initiator,receiver);
        swipeSessions.add(swipeSession);
        userSessionMap.put(initiator,swipeSession);
        userSessionMap.put(receiver,swipeSession);
    }

    public SwipeSession getSession(ApplicationUser user){
        if(!userSessionMap.containsKey(user))
            throw new UserNotFoundException("Tried to get session for user: "+ user.name + ", but no user was found");
        return userSessionMap.get(user);
    }

    public void removeSession(SwipeSession swipeSession) {

        swipeSessions.remove(swipeSession);
        userSessionMap.remove(swipeSession.initiator);
        userSessionMap.remove(swipeSession.receiver);


    }
}
