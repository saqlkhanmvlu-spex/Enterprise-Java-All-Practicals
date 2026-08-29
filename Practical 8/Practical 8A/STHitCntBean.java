package EJPracts;
import javax.ejb.Singleton;
@Singleton
public class STHitCntBean {
    private int count = 0;
    public synchronized int incrHitCount() {
        return ++count;
    }
}
