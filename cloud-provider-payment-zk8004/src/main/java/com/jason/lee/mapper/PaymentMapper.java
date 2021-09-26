package com.jason.lee.mapper;

import com.jason.lee.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
* @author huanli9
* @description
* @date 2021/3/9 23:31
*/

@Mapper
public interface PaymentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Payment record);

    int insertSelective(Payment record);

    Payment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Payment record);

    int updateByPrimaryKey(Payment record);
}