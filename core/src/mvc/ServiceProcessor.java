package mvc;

public class ServiceProcessor {
    static void execute(Service cmmd){
        if(cmmd!=null)
        cmmd.execute();
    }
}
