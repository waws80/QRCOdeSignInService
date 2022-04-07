package edu.service.signin.mapper;

import edu.service.signin.bean.SignInBean;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SignInMapper {


    @Insert("insert into table_sign (userId, activityId, createTime)\n" +
            "values (#{userId}, #{activityId}, #{createTime});")
    int add(int userId, int activityId, long createTime);



    @Select("select * " +
            "from table_sign " +
            "where userId = #{userId};")
    List<SignInBean> findByUserId(int userId);

    @Select("select * " +
            "from table_sign " +
            "where activityId = #{activityId};")
    List<SignInBean> findByActivityId(int activityId);


}
