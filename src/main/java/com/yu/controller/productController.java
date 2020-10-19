package com.yu.controller;

import com.yu.model.NoteResult;
import com.yu.model.Product;
import com.yu.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @ClassName productController
 * @Description TODO
 * @Author yuzhuojun
 * Date 2020/9/21 14:24
 */
@Controller
@RequestMapping("/product")
public class productController {

    @Autowired
    private IProductService proService;

    /**
     *  查询所有产品
     * @return
     */
    @RequestMapping("/findProduct")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<Product> products = proService.findProduct();
        for (Product p:products){
            System.out.println(p.getProductNum());
        }
//        mv.addObject("productList",products);
//        mv.setViewName("product-list");
        return null;
    }

    /**
     *  商品的新增
     * @return
     */
    @RequestMapping(value = "/save.do",method = RequestMethod.POST)
    public ModelAndView saveProduct(@ModelAttribute Product product){
        System.out.println(product);
        proService.saveProduct(product);
        return null;
    }

    /**
     *  商品的删除
     */
    @RequestMapping("/delPro")
    @ResponseBody
    public NoteResult delPro(String[] ids){
       NoteResult result =  proService.delPro(ids);
       return result;
    }

    /**
     * 根据id查询产品(可用于修改时的回显)
     * @param proId
     * @return
     */
    @RequestMapping("/findProById")
    @ResponseBody
    public NoteResult findProById(String proId){
        System.out.println("proId==>"+proId);
        NoteResult result = proService.findProById(proId);
        return result;
    }

    /**
     *  根据proId修改产品数据
     * @param proId
     * @return
     */
    @RequestMapping("/updatePro")
    @ResponseBody
    public NoteResult updateProById(String proId){

        return null;
    }
}
