package com.ke.mall.service.mapper;

import com.ke.mall.model.UserRedPacket;
import org.springframework.stereotype.Component;

@Component
public interface UserRedPacketMapper {
    /**
     * 插入抢红包信息
     * @param record
     * @return
     */
    int insert(UserRedPacket record);



    int deleteByPrimaryKey(Integer id);

    int insertSelective(UserRedPacket record);

    UserRedPacket selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRedPacket record);

    int updateByPrimaryKey(UserRedPacket record);
}