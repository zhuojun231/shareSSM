package com.yu.controller;

import com.yu.model.NoteResult;
import com.yu.model.User;
import com.yu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;

/**
 *  用户的登录登出注册
 * @ClassName UserController
 * @Description TODO
 * @Author yuzhuojun
 * Date 2020/9/14 11:26
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping("/select")
    public ModelAndView selectUser() throws Exception{
        ModelAndView mv = new ModelAndView();
        User user = userService.selectUser(1);
        mv.addObject("user",user);
        //jsp文件名
        mv.setViewName("userInfo");
        System.out.println(mv.toString());
        return mv;
    }

    /**
     *  注册
     * @param name
     * @param password
     * @param email
     * @return
     * @throws Exception
     */
    @RequestMapping("/register.do")
    @ResponseBody
    public NoteResult registerExecute(String name,String password ,String email) throws Exception{
        NoteResult result= userService.regist(name, password, email);
        return result;
    }

    /**
     *  登录
     * @param username
     * @param password
     * @return
     * @throws NoSuchAlgorithmException
     */
    @RequestMapping("/login.do")
    public String toLogin(String username,String password,HttpServletRequest request) throws NoSuchAlgorithmException {
        NoteResult result = userService.checkLogin(username,password);
        System.out.println(result);
        if (result.getStatus() == 1){
            System.out.println("登录成功");
            request.getSession().setAttribute("username",username);
            //servletContext
//            request.getServletContext().setAttribute("key","value");
            //session过期时间，单位servlet上下.文全局应用程序共享对象。
            request.getSession().setMaxInactiveInterval(10*60);
            return "redirect:/admin/index";
        }
        return "redirect:/login.jsp";
    }

    /**
     *  用户注销
     * @param request
     * @return
     * @throws NoSuchAlgorithmException
     */
    @RequestMapping("/toLogout")
    public String toLogout(HttpServletRequest request) throws  NoSuchAlgorithmException{
        request.getSession().invalidate();
        return "redirect:/login.jsp";
    }

}
