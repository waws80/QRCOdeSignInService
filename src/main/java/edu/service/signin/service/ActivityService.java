package edu.service.signin.service;

import edu.service.signin.bean.ActivityBean;
import edu.service.signin.mapper.ActivityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {

    @Autowired
    private ActivityMapper activityMapper;

    public boolean add(ActivityBean bean){
        return activityMapper.addData(bean.getName(), bean.getDate(),
                bean.getLocation(), bean.getCreateTime()) > 0;
    }


    public ActivityBean findById(int id){
        return activityMapper.findById(id);
    }


    public List<ActivityBean> findAll(){
        return activityMapper.findAll();
    }

}
