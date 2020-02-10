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
     * 获取红包信息,不加锁
     * @param id
     * @return
     */
    RedPacket selectByPrimaryKey(@Param(value = "id") Integer id);

    /**
     * 获取红包信息,悲观锁实现方式
     * @param id
     * @return
     */
    RedPacket getRedPacketForUpdate(@Param(value = "id") Integer id);

    /**
     * 扣减红包数
     * @param id
     * @return
     */
    int decrementRedPacket(@Param(value = "id") Integer id);

    /**
     * CAS乐观锁扣减红包数
     * @param id
     * @param version
     * @return
     */
    int decrementRedPacketByVerison(@Param(value = "id") Integer id, @Param(value = "version") Integer version);



    int deleteByPrimaryKey(Integer id);

    int insert(RedPacket record);

    int insertSelective(RedPacket record);

    int updateByPrimaryKeySelective(RedPacket record);

    int updateByPrimaryKey(RedPacket record);
}