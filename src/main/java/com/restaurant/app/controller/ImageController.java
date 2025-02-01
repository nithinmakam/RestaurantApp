package com.restaurant.app.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.restaurant.app.dao.ImageRequest;

import java.io.*;
import java.util.Base64;

import com.azure.core.http.rest.*;
import com.azure.core.util.BinaryData;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.storage.blob.*;
import com.azure.storage.blob.models.*;
import com.azure.storage.blob.options.BlobUploadFromFileOptions;
import com.azure.storage.blob.specialized.*;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.time.Duration;
import java.util.*;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    private final String uploadDir = "uploads/";

    @Value("${azure.storage.account-name}")
    private String accountName;

    @Value("${azure.storage.account-key}")
    private String accountKey;

    @Value("${azure.storage.container-name}")
    private String containerName;

    private BlobContainerClient containerClient;

    @PostMapping("/uploadBase64")
    public String uploadBase64Image(@RequestBody ImageRequest request) {
        byte[] imageBytes = Base64.getDecoder().decode(request.getImageData());

        getBlobServiceClient();

        BlobClient blobClient = containerClient.getBlobClient(request.getFileName());
        blobClient.upload(new ByteArrayInputStream(imageBytes), imageBytes.length, true);
        blobClient.setHttpHeaders(new BlobHttpHeaders().setContentType(request.getContentType())); 

        return blobClient.getBlobUrl(); // Return image URL
    }

    @PostMapping("/uploadMultipart")
    public String uploadMultipart(@RequestParam("file") MultipartFile file) {
        //byte[] imageBytes = Base64.getDecoder().decode(request.getImageData());

        getBlobServiceClient();

        String fileName = file.getOriginalFilename();
        BlobClient blobClient = containerClient.getBlobClient(fileName);

        try (InputStream inputStream = file.getInputStream()) {
            blobClient.upload(inputStream, file.getSize(), true);
            blobClient.setHttpHeaders(new BlobHttpHeaders().setContentType(file.getContentType())); 
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return blobClient.getBlobUrl(); // Return image URL
    }

    private void getBlobServiceClient() {
        // Create a Blob Service Client
        String connectionString = "DefaultEndpointsProtocol=https;AccountName=" + accountName + 
        ";AccountKey=" + accountKey + ";EndpointSuffix=core.windows.net";

        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder()
        .connectionString(connectionString)
        .buildClient();

        this.containerClient = blobServiceClient.getBlobContainerClient(containerName);
    }
}

