package com.yt.intelligence.member;

import com.yt.intelligence.CommonStatus;

/**
 * Created by yantong on 2019/1/8.
 * 成员管理器
 */
public interface MemberManager {

    /**
     * 是否 允许 添加成员
     * @param userId        用户ID（必须）
     * @param memberType    成员类型（非必须）
     * @return              {@link CommonStatus}
     */
    int isAllowToAddMember(String userId, String memberType);

}
