package com.yoona.entity;

import java.io.Serializable;

public class QueryVo implements Serializable {
    private String starName;
    private String movie;

    public QueryVo() {
    }

    public QueryVo(String name, String movie) {
        this.starName = name;
        this.movie = movie;
    }

    public String getName() {
        return starName;
    }

    public void setName(String name) {
        this.starName = name;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "{" +
                "starName='" + starName + '\'' +
                ", movie='" + movie + '\'' +
                '}';
    }
}
