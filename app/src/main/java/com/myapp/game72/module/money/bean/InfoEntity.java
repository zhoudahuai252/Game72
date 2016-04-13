package com.myapp.game72.module.money.bean;

import com.lidroid.xutils.db.annotation.Id;
import com.lidroid.xutils.db.annotation.NotNull;
import com.lidroid.xutils.db.annotation.Table;
import com.lidroid.xutils.db.annotation.Unique;

@Table(name = "table_info")//指定表名
public class InfoEntity {
    @Id
    private int _id;
    @NotNull
    @Unique
    private String id;
    private String name;
    private String score;
    private String icon;
    private String size;
    private String dl_back_jifen;
    private String android_dl;
    private String ios_dl;
    private String count_dl;
    private int all_prize;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDl_back_jifen() {
        return dl_back_jifen;
    }

    public void setDl_back_jifen(String dl_back_jifen) {
        this.dl_back_jifen = dl_back_jifen;
    }

    public String getAndroid_dl() {
        return android_dl;
    }

    public void setAndroid_dl(String android_dl) {
        this.android_dl = android_dl;
    }

    public String getIos_dl() {
        return ios_dl;
    }

    public void setIos_dl(String ios_dl) {
        this.ios_dl = ios_dl;
    }

    public String getCount_dl() {
        return count_dl;
    }

    public void setCount_dl(String count_dl) {
        this.count_dl = count_dl;
    }

    public int getAll_prize() {
        return all_prize;
    }

    public void setAll_prize(int all_prize) {
        this.all_prize = all_prize;
    }
}