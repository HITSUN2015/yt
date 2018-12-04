import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by yantong on 2018/11/24.
 */
public class RandomUtil {

    public static int getRanomInt(){
        return ThreadLocalRandom.current().nextInt(99999);
    }
}
