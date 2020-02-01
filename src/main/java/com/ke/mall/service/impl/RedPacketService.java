package com.ke.mall.service.impl;

import com.ke.mall.model.RedPacket;
import com.ke.mall.service.IRedPacketService;
import com.ke.mall.service.mapper.RedPacketMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Summary:
 * @Author: YangxingLiu
 * @Since: 2020/2/1 16:25
 */
@Service
public class RedPacketService implements IRedPacketService {
    @Autowired
    private RedPacketMapper redPacketMapper;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public RedPacket getRedPacket(Integer id) {
        return redPacketMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public int decrementRedPacket(Integer id) {
        return redPacketMapper.decrementRedPacket(id);
    }
}
