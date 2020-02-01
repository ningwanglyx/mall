package com.ke.mall.service.mapper;

import com.ke.mall.model.RedPacket;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @author liuyangxing
 */
@Component
public interface RedPacketMapper {
    /**
     * 获取红包信息
     * @param id
     * @return
     */
    RedPacket selectByPrimaryKey(@Param(value = "id") Integer id);

    /**
     * 扣减红包数
     * @param id
     * @return
     */
    int decrementRedPacket(@Param(value = "id") Integer id);



    int deleteByPrimaryKey(Integer id);

    int insert(RedPacket record);

    int insertSelective(RedPacket record);

    int updateByPrimaryKeySelective(RedPacket record);

    int updateByPrimaryKey(RedPacket record);
}