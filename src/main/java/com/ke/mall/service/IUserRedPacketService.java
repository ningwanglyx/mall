package com.ke.mall.service;

/**
 * @Summary:
 * @Author: YangxingLiu
 * @Since: 2020/2/1 16:23
 */
public interface IUserRedPacketService {
    /**
     * 保存抢红包信息
     * @param redPacketId
     * @param userId
     * @return
     */
    int grapRedPacket(Integer redPacketId, Integer userId);
}
