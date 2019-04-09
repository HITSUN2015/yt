package com.yt.intelligence.baidu;/**
 * Created by SUN on 19/4/9.
 */

import org.testng.annotations.Test;

/**
 * @author SUN
 * @create 2019-04-09 下午10:29
 * @desc
 */
@Test
public class BaiuAIIntroduceTest {

    private static String USER_ID = "user_id_for_test";
    private static String GROUP_ID = "group_id_for_test";

    private static String PUJING_IMG1 = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1554829478005&di=174ebfee928d428b73c09cedb773b049&imgtype=0&src=http%3A%2F%2Fpic.people.com.cn%2FNMediaFile%2F2014%2F0305%2FMAIN201403050733000050810905189.jpg";
    private static String PUJING_IMG2 = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1554832411561&di=cb329dbf432035bd15cf73093f03baf1&imgtype=0&src=http%3A%2F%2Fimages.china.cn%2Fattachement%2Fjpg%2Fsite1000%2F20160912%2F001fd04cfc48194051420e.jpg";;

    private BaiuAIIntroduce baiuAIIntroduce = new BaiuAIIntroduce();

    @Test
    public void detect() {
        String src = PUJING_IMG1;
        String imgType = "URL";
        baiuAIIntroduce.detect(src, imgType);
    }

    @Test
    public void addUserToGroup() {
        String src = PUJING_IMG1;
        String imgType = "URL";
        baiuAIIntroduce.addUser(src, imgType, GROUP_ID, USER_ID);
    }

    /**
     {
        "result": {
            "score": 94.26856232,
            "face_list": [
                 {"face_token": "7cc140cd7561b9adec5d9a88cf90b91d"},
                 {"face_token": "f1c56c9647f3563f5b81313d7c856178"}
            ]
         },
        "log_id": 1368654448229125141,
         "error_msg": "SUCCESS",
         "cached": 0,
         "error_code": 0,
         "timestamp": 1554822912
     }
     */
    @Test
    public void match() {

        String srcFaceToken = "7cc140cd7561b9adec5d9a88cf90b91d";
        String srcType = "FACE_TOKEN";

        String target = PUJING_IMG2;
        String targetType = "URL";
        baiuAIIntroduce.match(srcFaceToken, srcType, target, targetType);
    }
}
