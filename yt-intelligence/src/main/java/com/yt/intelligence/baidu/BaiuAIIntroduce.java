package com.yt.intelligence.baidu;/**
 * Created by SUN on 19/4/9.
 */

import com.baidu.aip.face.AipFace;
import com.baidu.aip.face.MatchRequest;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author SUN
 * @create 2019-04-09 下午9:40
 * @desc 源自一次与头条的三面,我的项目经验里,写了关于人脸识别的项目经验
 *       然后就被一顿问,实际是我的项目很偏上层(跨越好几个服务才能到人脸识别的具体实现。。。),
 *       而且平时处理的是小需求和显示问题,历史一两个月
 *
 *       很不爽,所以自己来接下这套API
 *
 *       http://ai.baidu.com/docs#/Face-Java-SDK/top
 */
public class BaiuAIIntroduce {



    public void detect(String imgSource, String imgType) {
        // 初始化一个AipFace
        AipFace client = BaiduClientFactory.intance();

        JSONObject res = client.detect(imgSource, imgType, new HashMap<String, String>());
        System.out.println(res.toString(2));

    }

    /**
     * 组织结构是:
     * appId:人脸库 = 1:1
     *       人脸库:用户组(group) = 1:n
     *       用户组:用户(user)    = 1:n
     *       用户:img            = 1:n
     *
     *
     */
    public void addUser(String imgSource, String imgType, String groupId, String userId) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("user_info", "user's info");
        options.put("quality_control", "NORMAL");
        options.put("liveness_control", "LOW");

        AipFace client = BaiduClientFactory.intance();

        // 人脸注册
        JSONObject res = client.addUser(imgSource, imgType, groupId, userId, options);
        System.out.println(res.toString(2));
    }

    public void match(String imgSource, String imgSourceType, String imgCompare, String imgCompareType) {

        // image1/image2也可以为url或facetoken, 相应的imageType参数需要与之对应。
        MatchRequest req1 = new MatchRequest(imgSource, imgSourceType);
        MatchRequest req2 = new MatchRequest(imgCompare, imgCompareType);
        ArrayList<MatchRequest> requests = new ArrayList<MatchRequest>();
        requests.add(req1);
        requests.add(req2);

        AipFace client = BaiduClientFactory.intance();

        JSONObject res = client.match(requests);
        System.out.println(res.toString(2));
    }
}
