package com.yt.interview.tou;/**
 * Created by SUN on 19/4/9.
 */

/**
 * @author SUN
 * @create 2019-04-09 下午5:30
 * @desc
 */
public interface FaceCompare {

    /**
     *
     * @param faceToken
     * @param picUrl
     * @param compareParams
     * @return
     */
    FaceCompareResult compare(String alarmId, String faceToken, String picUrl,FaceCompareParams compareParams);



    class FaceCompareParams {

        private int threashold;
        //...
    }

    class FaceCompareResult {

        private String alarmId;

        private int statusCode;

        private String appendMsg;
    }


}
