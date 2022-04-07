package edu.service.signin.controller;

import edu.service.signin.bean.ActivityBean;
import edu.service.signin.bean.SignInBean;
import edu.service.signin.bean.StudentBean;
import edu.service.signin.service.ActivityService;
import edu.service.signin.service.SigninService;
import edu.service.signin.service.StudentService;
import edu.service.signin.utils.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@RestController
@RequestMapping("signin")
public class SignInController extends BaseController{

    @Autowired
    private ActivityService activityService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private SigninService signinService;


    @PostMapping("add")
    public HttpResponse addData(){
        int activityId = Integer.parseInt(httpServletRequest.getParameter("activityId"));
        int userId = Integer.parseInt(httpServletRequest.getParameter("userId"));

        StudentBean studentBean = studentService.findById(userId);

        ActivityBean activityBean = activityService.findById(activityId);

        if (studentBean == null || activityBean == null){
            return HttpResponse.paramsError("参数错误");
        }
        boolean result = signinService.add(userId, activityId, System.currentTimeMillis());
        if (result){
            return HttpResponse.success("");
        }else {
            return HttpResponse.serviceError();
        }
    }


    @GetMapping("search_sign_activity")
    public HttpResponse search(){
        int userId = Integer.parseInt(httpServletRequest.getParameter("userId"));
        List<SignInBean> signInBeans = signinService.findByUserId(userId);

        List<ActivityBean> activityBeans = signInBeans.stream().map(new Function<SignInBean, ActivityBean>() {
            @Override
            public ActivityBean apply(SignInBean signInBean) {
                return activityService.findById(signInBean.getActivityId());
            }
        }).sorted(new Comparator<ActivityBean>() {
            @Override
            public int compare(ActivityBean o1, ActivityBean o2) {
                return (int) (o2.getCreateTime() - o1.getCreateTime());
            }
        }).collect(Collectors.toList());

        return HttpResponse.success(activityBeans);
    }



    @GetMapping("search_sign_user")
    public HttpResponse searchUsers(){
        int activityId = Integer.parseInt(httpServletRequest.getParameter("activityId"));
        List<SignInBean> signInBeans = signinService.findByActivityId(activityId);

        List<StudentBean> studentBeans = signInBeans.stream().map(new Function<SignInBean, StudentBean>() {
            @Override
            public StudentBean apply(SignInBean signInBean) {
                return studentService.findById(signInBean.getUserId());
            }
        }).collect(Collectors.toList());

        return HttpResponse.success(studentBeans);
    }






}
