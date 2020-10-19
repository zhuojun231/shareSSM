package com.yu.controller;

import com.yu.model.Product;
import com.yu.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @ClassName AdminController
 * @Description TODO
 * @Author yuzhuojun
 * Date 2020/9/15 15:54
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    IProductService proService;

    /**
     *  整体框架
     * @return
     */
    @RequestMapping("/index")
    public String admin(){
        return "index_iframe";
    }

    /**
     * 欢迎页iframe
     * @return
     */
    @RequestMapping("/welcome")
    public String welcome(){
        return "welcome_iframe";
    }

    /**
     *  商品列表
     * @return
     */
    @RequestMapping("/productList")
    public ModelAndView productList(){
        ModelAndView mv = new ModelAndView();
        List<Product> products = proService.findProduct();
        mv.addObject("productList",products);
        mv.setViewName("UI/product-list");
        return mv;
    }

    /**
     *  用户列表
     * @return
     */
    @RequestMapping("/userList")
    public String userList(){
        return "user/userList";
    }

    @RequestMapping("/addProduct")
    public String addProduct(){
        return "iframe/product-add";
    }
}
