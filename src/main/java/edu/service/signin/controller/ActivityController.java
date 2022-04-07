package edu.service.signin.controller;

import edu.service.signin.bean.ActivityBean;
import edu.service.signin.service.ActivityService;
import edu.service.signin.utils.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("activity")
public class ActivityController  extends BaseController{

    @Autowired
    private ActivityService activityService;



    @PostMapping("add")
    public HttpResponse addData(){
        String name = httpServletRequest.getParameter("name");
        String location = httpServletRequest.getParameter("location");
        long date = Long.parseLong(httpServletRequest.getParameter("date"));


        if (name.isEmpty() || location.isEmpty() || date == 0){
            return HttpResponse.paramsError("参数错误");
        }

        boolean result = activityService.add(new ActivityBean(0, name, date, location, System.currentTimeMillis()));
        if (result){
            return HttpResponse.success("");
        }else {
            return HttpResponse.serviceError();
        }
    }


    @GetMapping("search")
    public HttpResponse search(){

        List<ActivityBean> sportBeans = activityService.findAll();
        sportBeans.sort(new Comparator<ActivityBean>() {
            @Override
            public int compare(ActivityBean o1, ActivityBean o2) {
                return (int) (o2.getCreateTime() - o1.getCreateTime());
            }
        });
        return HttpResponse.success(sportBeans);
    }



}
