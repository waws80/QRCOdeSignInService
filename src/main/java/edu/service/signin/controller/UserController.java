package edu.service.signin.controller;

import edu.service.signin.bean.StudentBean;
import edu.service.signin.service.StudentService;
import edu.service.signin.utils.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController extends BaseController{


    @Autowired
    private StudentService studentService;

    @PostMapping("register")
    public HttpResponse registerUser(){
        String scode = httpServletRequest.getParameter("scode");
        String sname = httpServletRequest.getParameter("sname");
        String spwd = httpServletRequest.getParameter("spwd");
        String sclass = httpServletRequest.getParameter("sclass");

        if (scode.isEmpty() || sname.isEmpty() || spwd.isEmpty() || sclass.isEmpty()){
            return HttpResponse.paramsError("参数不能为空");
        }

        StudentBean sel = studentService.findByScode(scode);
        if (sel == null){
            boolean success = studentService.addStudent(scode, sname, spwd, sclass);
            if (success){
                StudentBean result = studentService.findByScode(scode);
                result.setSpwd("");
                return HttpResponse.success(result);
            }else {
                return HttpResponse.serviceError();
            }
        }
        return HttpResponse.paramsError("当前学生已存在");
    }



    @PostMapping("login")
    public HttpResponse login(){
        String code = httpServletRequest.getParameter("scode");
        String pwd = httpServletRequest.getParameter("spwd");
        if (code.isEmpty() || pwd.isEmpty()){
            return HttpResponse.paramsError("参数不能为空");
        }
        StudentBean sel = studentService.findByScode(code);
        if (sel == null){
            return HttpResponse.paramsError("当前学生已存在");
        }
        if (!sel.getSpwd().equals(pwd)){
            return HttpResponse.paramsError("密码错误");
        }
        sel.setSpwd("");
        return HttpResponse.success(sel);
    }

}
