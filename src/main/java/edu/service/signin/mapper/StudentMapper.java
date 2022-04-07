package edu.service.signin.mapper;

import edu.service.signin.bean.StudentBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface StudentMapper {


    @Insert("insert into table_student (scode, sname, spwd, sclass) " +
            "values (#{scode},#{sname},#{spwd},#{sclass});")
    int addUser(String scode, String sname, String spwd, String sclass);


    @Select("select * " +
            "from table_student " +
            "where scode = #{scode};")
    StudentBean findByScode(String scode);


    @Select("select * " +
            "from table_student " +
            "where id = #{id};")
    StudentBean findById(int id);

    @Select("select * " +
            "from table_student;")
    List<StudentBean> findAll();

}
