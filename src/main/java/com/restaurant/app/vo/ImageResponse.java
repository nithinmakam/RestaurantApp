package com.restaurant.app.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ImageResponse{

    private String imageUrlString;

    public ImageResponse(String imageUrlString) {
        this.imageUrlString = imageUrlString;
    }
}