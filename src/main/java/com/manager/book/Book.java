package com.manager.book;

import java.util.Date;

/**
 * @ClassName Book
 * @Description TODO
 * @Author yuzhuojun
 * Date 2020/10/10 14:32
 */
public class Book {
    private int id;
    private String name;
    private int state;//1 在库，0被借
    private Date borrowDate;//被借日期
    private int borrowCount;//被借数量

    public int getBorrowCount() {
        return borrowCount;
    }

    public void setBorrowCount(int borrowCount) {
        this.borrowCount = borrowCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }
}
