package com.restaurant.app.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ImageRequest {

    private String fileName;
    private String imageData; // Base64 encoded string
    private String contentType;
}