package com.example.spring_vue_api.models;

import javax.persistence.*;
 
@Entity
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     
    @Column(name = "overview", nullable = false, length = 200)
    private String overview;
     
    @Column(name = "detail", nullable = false, length = 1000)
    private String detail;
     
    @Column(name = "time", nullable = false, length = 100)
    private String time;

    @Column(name = "category", nullable = false, length = 100)
    private String category;

    @Column(name = "imageURL", nullable = false, length = 1000000)
    private String imageURL;

    public News() {

    }

    public News(String overview, String detail, String time, String category, String imageURL) {
        this.overview = overview;
        this.detail = detail;
        this.time = time;
        this.category = category;
        this.imageURL = imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getCategory() {
        return category;
    }

    public String getDetail() {
        return detail;
    }

    public Long getId() {
        return id;
    }

    public String getOverview() {
        return overview;
    }

    public String getTime() {
        return time;
    }
    
}
