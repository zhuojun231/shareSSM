package com.manager.book;

import java.util.Scanner;

/**
 * @ClassName BookManager
 * @Description TODO
 * @Author yuzhuojun
 * Date 2020/10/10 14:36
 */
public class BookManager {
    private Book[] books;
    //菜单
    public void menu(){
        Scanner scanner = new Scanner(System.in);

        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                addBook();
                break;
            case 2:
                deleteBook();
                break;
            case 3:
                borrowBook();
                break;
            case 4:
                returnBook();
                break;
            case 5:
                bookRank();
                break;
            default:
                System.out.println("无请求指令");
        }
    }
    private void addBook(){
        System.out.println("新增图书");
    }
    private void deleteBook(){
        System.out.println("删除");
    }
    private void borrowBook(){
        System.out.println("借阅");
    }
    private void returnBook(){
        System.out.println("归还");
    }
    //根据被借次数降序
    private void bookRank(){
        System.out.println("排行");
    }
}
