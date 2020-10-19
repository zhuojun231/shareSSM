package com.yu.controller;

import com.yu.model.NoteResult;
import com.yu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;

/**
 *  用户的登陆和登出
 * @ClassName CheckLogin
 * @Description TODO
 * @Author yuzhuojun
 * Date 2020/9/16 17:21
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private IUserService userService;
    /**
     *  用户登录
     * @param username
     * @param password
     * @param request
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin(String username,String password,HttpServletRequest request) throws NoSuchAlgorithmException {
        System.out.println("---/toLogin---");
        NoteResult result = userService.checkLogin(username,password);
        System.out.println(result);
        if (result.getStatus() == 1){
            System.out.println("登录成功");
            request.getSession().setAttribute("username",username);
            //session过期时间，单位s
            request.getSession().setMaxInactiveInterval(10*60);
            return "redirect:/admin/index";
        }
        return "redirect:/login.jsp";
    }
//    public String toLogin(String username, String password, HttpServletRequest request, RedirectAttributes attr){
//        if("zhangsan".equals(username) && "123".equals(password)){
//            System.out.println("登录成功");
//            request.getSession().setAttribute("username",username);
//            //session过期时间，单位s
//            request.getSession().setMaxInactiveInterval(10*60);
//            //带参数跳转
//            attr.addAttribute("uname",username);
//            return "redirect:/admin/index";
//        }else {
//            System.out.println("登录失败");
//            return "redirect:/login.jsp";
//        }
//    }

    /**
     *  用户登出
     * @param username
     * @param request
     * @return
     */
    @RequestMapping("/toLogout")
    public String toLogout(String username,HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/login.jsp";
    }


    /**
     *  注册
     * @param username
     * @param password
     * @param email
     * @return
     * @throws Exception
     */
    @RequestMapping("/register")
    @ResponseBody
    public NoteResult registerExecute(String username,String password ,String email) throws Exception{
        System.out.println("---/register---");
        NoteResult result= userService.regist(username, password, email);

        return result;
    }


}
