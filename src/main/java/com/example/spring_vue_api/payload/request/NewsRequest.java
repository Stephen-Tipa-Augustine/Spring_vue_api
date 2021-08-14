package com.example.spring_vue_api.payload.request;
import javax.validation.constraints.*;

public class NewsRequest {
    @NotBlank
    @Size(max = 200)
    private String overview;

    @NotBlank
    @Size(max = 1000)
    private String detail;

    @NotBlank
    @Size(min = 3, max = 100)
    private String time;

    @NotBlank
    @Size(min = 3, max = 100)
    private String category;

    @NotBlank
    @Size(min = 3, max = 1000000)
    private String imageURL;

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDetail(String detail) {
        this.detail = detail;
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

    public String getOverview() {
        return overview;
    }

    public String getTime() {
        return time;
    }
    
}
