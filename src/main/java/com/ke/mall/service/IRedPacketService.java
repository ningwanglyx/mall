package com.ke.mall.service;

import com.ke.mall.model.RedPacket;

/**
 * @Summary: 红包表接口
 * @Author: YangxingLiu
 * @Since: 2020/2/1 16:20
 */
public interface IRedPacketService {
    /**
     * 获取红包信息
     * @param id
     * @return
     */
    RedPacket getRedPacket(Integer id);

    /**
     * 扣减红包数量
     * @param id
     * @return
     */
    int decrementRedPacket(Integer id);

}
