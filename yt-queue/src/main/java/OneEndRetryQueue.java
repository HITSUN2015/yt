import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

/**
 * Created by yantong on 2018/12/4.
 */
public abstract class OneEndRetryQueue {

    private static Logger LOG = LoggerFactory.getLogger(OneEndRetryQueue.class);

    abstract RetryData deQueue();

    abstract boolean doBusiness(RetryData retryData);

    abstract void enQueue(RetryData retryData);

    public void excute() {
        while(true){// TODO: 2018/12/5 这个 循环 机制 有待 商榷
            RetryData retryData = deQueue();
            if (LOG.isDebugEnabled()) {
                LOG.debug("BEGIN TO HANDLE DATA {}", retryData);
            }
            if (null == retryData) {
                LOG.warn("retryData 为 NULL");
                continue;
            }
            if (null == retryData.getId()) {
                String id = generateId();
                retryData.setId(id);
            }
            retryData.initOneMoreTime();
            boolean result = false;
            try {
                result = doBusiness(retryData);
            } catch (Exception e) {
                LOG.error("DO BUSINESS FAILURE,DATA {}", retryData);
            }
            if (!result) {
                boolean isToRetry = isToRetry(retryData);
                if (LOG.isDebugEnabled()) {
                    LOG.debug("HANDLE DATA FAIL{},isToRetry {}", retryData, isToRetry);
                }
                if (isToRetry) {
                    enQueue(retryData);
                }
            } else {
                if (LOG.isDebugEnabled()) {
                    LOG.debug("HANDLE DATA SUCCESS {}", retryData);
                }
            }
        }
    }

    protected String generateId() {
        return String.valueOf(new Date().getTime());
    }

    private int runCount(RetryData retryData) {
        List<FailDetail> fails = retryData.getFailDetails();
        int result = 0;
        if (null == fails) {
            result = 1;
        } else {
            result = fails.size() + 1;
        }
        return result;
    }

    protected boolean isToRetry(RetryData retryData) {
        boolean result = true;
        List<FailDetail> failDetails = retryData.getFailDetails();
        if (null != failDetails && failDetails.size() >= 3) {
            LOG.warn("RETRY {} times, decide to give up. data {}", failDetails.size(), retryData);
            result = false;
        }
        return result;
    }

}
