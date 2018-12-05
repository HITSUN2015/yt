import java.io.Serializable;
import java.util.Date;

/**
 * Created by yantong on 2018/12/4.
 */
public class FailDetail implements Serializable{

    private Date time;
    private String reason;

    public FailDetail() {
        this.time = new Date();
    }

    public Date getTime() {
        return time;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {

    }
}
