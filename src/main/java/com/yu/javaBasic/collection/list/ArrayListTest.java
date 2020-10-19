package com.yu.javaBasic.collection.list;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @ClassName ArrayListTest
 * @Description TODO
 * @Author yuzhuojun
 * Date 2020/9/30 11:52
 */
public class ArrayListTest {
    public static void main(String[] args) {
        Collection<Object> coll = new ArrayList<>();
        //add向集合中新增一个元素
        coll.add("a");
        coll.add("b");
        coll.add("c");
        System.out.println(coll);
        //clean 清空集合中所有元素
//        lists.clear();
        System.out.println(coll);
        //addAll()  将a集合中的全部元素增加到 b集合中,b集合中会有全部元素

        //contains("x"):判断元素是否在该集合内，返回Boolean类型

        //cotainsAll(list2):判断集合是否包含另一个集合

        //isEmpty():判断集合是否为空

        //iterator():迭代器
        Iterator<Object> iterator = coll.iterator();
        //iterator.hasNext():判断是否还有下个元素
        while (iterator.hasNext()){
            String result = (String) iterator.next();//元素迭代出来
            System.out.println("iterator:"+result);
        }

        //remove():移除集合中的指定对象

        //removeAll():从一个集合中删除另一个集合

        //retainAll():该集合中，只保留另一个集合

        //toArray():将集合转化为数组

        //List
        //indexOf:获取到某个指定对象（元素）在集合中的位置。（从前往后）
        //lastIndexOf()：(从后往前)
        //remove(2):在List中也可以删除指定索引位置的元素
        //set(3,"xxx"):将指定位置的元素，修改为新的对象。
        //subList(1,3):类似subString(),截取List集合，左闭右开[1,3)（左边参数可以取得到，右边不可以）


        //Collection:存储数据不唯一、无序的对象
        //List:不唯一，有序（输入顺序和输出顺序一致）
        //Set: 唯一，无序（输入顺序和输出顺序不一致）

        /*
            HashXxx:底层借助了“哈希表”的数据结构
            TreeXxx:底层借助的“红黑树”的数据结构（默认支持排序）
         */

        /*
            重定向：response.sendRedirect("xx.jsp")
                    数据丢失，地址栏改变
            请求转发：request.getRequestDispatcher("xxx.jsp").forward(req,resp)
                    可以获取数据，地址栏不改变（仍然保留转发前的页面）
         */


    }
}
