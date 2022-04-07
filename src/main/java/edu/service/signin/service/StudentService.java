package edu.service.signin.service;

import edu.service.signin.bean.StudentBean;
import edu.service.signin.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService {

    @Autowired
    private StudentMapper userMapper;

    public boolean addStudent(String scode, String sname, String spwd, String sclass){
        int result = userMapper.addUser(scode, sname, spwd, sclass);
        return result > 0;
    }

    public StudentBean findByScode(String scode){
        return userMapper.findByScode(scode);
    }

    public StudentBean findById(int userId){
        return userMapper.findById(userId);
    }

    public List<StudentBean> findAll(){
        return userMapper.findAll();
    }
}
