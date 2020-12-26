package com.boot.bootdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boot.bootdemo.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/4/11   20:01
 */
@Component
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

/*    @Select("select name,age from student where id =#{id}")
    Student query(int id);*/

    @Select("select * from student where id=#{id} for update")
    Student getStu(int id);


    //in 一个list查询 使用$符号用作变量
/*    @Results
    @Select("SELECT * FROM order_table WHERE driver_id=#{driverId} and order_status = #{orderStatus} AND type IN (${type}) AND state = 1 ")
    List<Student> queryOrderListByStatus(@Param("driverId") Long driverId, @Param("orderStatus") Integer orderStatus, @Param("type") String type);*/
}
