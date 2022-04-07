package edu.service.signin.mapper;

import edu.service.signin.bean.ActivityBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ActivityMapper {


    @Insert("insert into table_activity (name, date, location, createTime) " +
            "values (#{name}, #{date}, #{location}, #{createTime});")
    int addData(String name, long date, String location, long createTime);


    @Select("select * " +
            "from table_activity where id = #{id};")
    ActivityBean findById(int id);

    @Select("select * " +
            "from table_activity")
    List<ActivityBean> findAll();

}
