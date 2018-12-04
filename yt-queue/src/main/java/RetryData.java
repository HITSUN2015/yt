import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yantong on 2018/12/4.
 */
public abstract class RetryData {

    protected String id;

    protected int falureCount = 0;

    protected List<FailDetail> failDetails;

    protected Map<String, Object> appendDatas;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<FailDetail> getFailDetails() {
        return failDetails;
    }

    public boolean addFailDetails(String failDetail) {
        if (null == failDetail) {
            return false;
        }
        if (null == failDetails) {
            failDetails = new ArrayList<FailDetail>();
        }

        failDetails.add()failDetails = failDetails;
    }

    public Map<String, Object> getAppendDatas() {
        return appendDatas;
    }

    public boolean addAppendDatas(String key, Object value) {
        if (null == key || null == value) {
            return false;
        }
        if (appendDatas == null) {
            appendDatas = new HashMap<String, Object>();
        }
        if (appendDatas.containsKey(key)) {
            return false;
        }
        appendDatas.put(key, value);
        return true;
    }

    public boolean filAppendDatas(String key, Object value) {
        if (null == key || null == value) {
            return false;
        }
        if (appendDatas == null) {
            appendDatas = new HashMap<String, Object>();
        }
        appendDatas.put(key, value);
        return true;
    }

    @Override
    public String toString() {
        return "RetryData{" +
                "id='" + id + '\'' +
                ", falureCount=" + falureCount +
                ", failDetails=" + failDetails +
                ", appendDatas=" + appendDatas +
                '}';
    }
}
