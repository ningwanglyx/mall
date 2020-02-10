package com.ke.mall.service.impl;

import com.ke.mall.model.RedPacket;
import com.ke.mall.model.UserRedPacket;
import com.ke.mall.service.IUserRedPacketService;
import com.ke.mall.service.mapper.RedPacketMapper;
import com.ke.mall.service.mapper.UserRedPacketMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @Summary: 用户抢红包
 * @Author: YangxingLiu
 * @Since: 2020/2/1 16:33
 */
@Service
public class UserRedPacketService implements IUserRedPacketService {
    @Autowired
    private RedPacketMapper redPacketMapper;
    @Autowired
    private UserRedPacketMapper userRedPacketMapper;

    private static final int FAILED = 0;

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
    public int grapRedPacket(Integer redPacketId, Integer userId) {
        RedPacket redPacket = redPacketMapper.getRedPacketForUpdate(redPacketId);
        if(redPacket.getStock() > 0){
            //扣减红包数
            redPacketMapper.decrementRedPacket(redPacketId);
            UserRedPacket userRedPacket = new UserRedPacket();
            userRedPacket.setUserId(userId);
            userRedPacket.setRedPacketId(redPacketId);
            userRedPacket.setPerAmount(redPacket.getPerAmount());
            userRedPacket.setNote("抢红包 " + redPacketId);
            userRedPacket.setGrabTime(new Date());
            //插入抢红包信息
            int res = userRedPacketMapper.insert(userRedPacket);
            return res;
        }
        //失败返回
        return 0;
    }

    @Override
    @Transactional
    //加入重试机制，避免红包没有被抢，一起请求可以重试三次
    public int grapRedPacketForVersion(Integer redPacketId, Integer userId) {
        for(int i = 0; i < 3; i++){
            RedPacket redPacket = redPacketMapper.selectByPrimaryKey(redPacketId);
            if(redPacket.getStock() > 0){
                //通过version旧值来进行CAS操作
                int update = redPacketMapper.decrementRedPacketByVerison(redPacketId, redPacket.getVersion());
                //数据未更新，说明其他线程已经修改过数据，抢红包失败
                if(update == 0){
                    continue;
                }
                UserRedPacket userRedPacket = new UserRedPacket();
                userRedPacket.setUserId(userId);
                userRedPacket.setRedPacketId(redPacketId);
                userRedPacket.setPerAmount(redPacket.getPerAmount());
                userRedPacket.setNote("抢红包 " + redPacketId);
                userRedPacket.setGrabTime(new Date());
                //插入抢红包信息
                int res = userRedPacketMapper.insert(userRedPacket);
                return res;
            } else {
                //一旦没有红包，则马上返回
                return FAILED;
            }
        }
        return 0;
    }
}
