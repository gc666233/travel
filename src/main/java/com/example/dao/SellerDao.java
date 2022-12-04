package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.pojo.Seller;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SellerDao extends BaseMapper<Seller> {
}
