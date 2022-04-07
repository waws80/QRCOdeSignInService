package edu.service.signin.service;

import edu.service.signin.bean.SignInBean;
import edu.service.signin.mapper.SignInMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SigninService {

    @Autowired
    private SignInMapper signInMapper;


    public boolean add(int userId, int activityId, long createTime){
        return this.signInMapper.add(userId, activityId, createTime) > 0;
    }


    public List<SignInBean> findByUserId(int userId){
        return this.signInMapper.findByUserId(userId);
    }


    public List<SignInBean> findByActivityId(int activityId){
        return this.signInMapper.findByActivityId(activityId);
    }


}
