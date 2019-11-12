package com.yoona.entity;

import java.io.Serializable;
import java.util.Date;

public class Star implements Serializable {
    private Integer sid;

    private String starName;

    private Integer starSex;

    private String movie;

    private Date created;

    private Date updated;

    private static final long serialVersionUID = 1L;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getStarName() {
        return starName;
    }

    public void setStarName(String starName) {
        this.starName = starName == null ? null : starName.trim();
    }

    public Integer getStarSex() {
        return starSex;
    }

    public void setStarSex(Integer starSex) {
        this.starSex = starSex;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie == null ? null : movie.trim();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sid=").append(sid);
        sb.append(", starName=").append(starName);
        sb.append(", starSex=").append(starSex);
        sb.append(", movie=").append(movie);
        sb.append(", created=").append(created);
        sb.append(", updated=").append(updated);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}