package com.ke.mall.service;

/**
 * @Summary:
 * @Author: YangxingLiu
 * @Since: 2020/2/1 16:23
 */
public interface IUserRedPacketService {
    /**
     * 抢红包
     * @param redPacketId
     * @param userId
     * @return
     */
    int grapRedPacket(Integer redPacketId, Integer userId);

    /**
     *  通过乐观锁和CAS版本号方式抢红包
     * @param redPacketId
     * @param userId
     * @return
     */
    int grapRedPacketForVersion(Integer redPacketId, Integer userId);
}
