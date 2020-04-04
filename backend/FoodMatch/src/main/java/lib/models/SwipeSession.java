package lib.models;

import lib.exceptions.SwipeAppException;

import java.util.HashSet;
import java.util.Set;

public class SwipeSession extends Event {

    ApplicationUser initiator;
    ApplicationUser receiver;

    Set<SwipeItem> initiatorAcceptedItems;
    Set<SwipeItem> receiverAcceptedItems;
    Set<SwipeItem> bothAcceptedItems;

    private boolean matchFound;



    private boolean open;

    public SwipeSession(ApplicationUser initiator, ApplicationUser receiver) {
        this.initiator = initiator;
        this.receiver = receiver;
        initiatorAcceptedItems = new HashSet<>();
        receiverAcceptedItems = new HashSet<>();
        matchFound =false;
    }

    /*
    Helper method. Adds an item to a user's accepted item. Returns true if added, false if there's a duplicate
     */
    private boolean addItem(ApplicationUser user, SwipeItem item){
        if(user.equals(initiator))
            return initiatorAcceptedItems.add(item);
        else if(user.equals(receiver))
            return receiverAcceptedItems.add(item);
        else
            throw new SwipeAppException("User not in swipe session! Expected " + initiator +"or " + receiver + ", given " + user);
    }

    /*
    Adds an item to a user's accepted item. If a match is found with the added object, return true, if not return false.
     */

    public boolean addItemAndCheck(ApplicationUser user, SwipeItem item){
        addItem(user,item);

        if(user.equals(initiator))
            if(receiverAcceptedItems.contains(item)){
                bothAcceptedItems.add(item);
                matchFound = true;
                return true;
            }
        else if(user.equals(receiver))
                if(initiatorAcceptedItems.contains(item)){
                    bothAcceptedItems.add(item);
                    matchFound = true;
                    return true;
                }

        return false;
    }

    public boolean matchIsFound() {
        return matchFound;
    }

    public boolean isOpen() {
        return open;
    }
}
