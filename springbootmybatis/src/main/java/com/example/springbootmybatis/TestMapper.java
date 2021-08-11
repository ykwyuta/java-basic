package com.example.springbootmybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TestMapper {

    @Select("SELECT USER_NAME() AS NAME;")
    String getUserName();
}
