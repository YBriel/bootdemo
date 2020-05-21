package com.boot.bootdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boot.bootdemo.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/4/11   20:01
 */
@Component
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

    @Select("select name,age from student where id =#{id}")
    Student query(int id);
}
