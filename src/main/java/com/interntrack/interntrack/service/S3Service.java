package com.interntrack.interntrack.service;

import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.ListObjectsV2Request;
import software.amazon.awssdk.services.s3.model.ListObjectsV2Response;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Service 
public class S3Service {
    private final String bucketName = "interntrack-resumes-aaditya";
    private final S3Client s3Client;

    public S3Service(S3Client s3Client) {
        this.s3Client = s3Client;
    }

    public void listFiles() {
        ListObjectsV2Request request = ListObjectsV2Request.builder().bucket(bucketName).build();
        ListObjectsV2Response response = s3Client.listObjectsV2(request);

        response.contents().forEach(object -> System.out.println(object.key()));
    }

    public String uploadFile(Long applicationId, MultipartFile file) throws IOException {
        String fileName = UUID.randomUUID() + "-" + file.getOriginalFilename();
        String key = "resumes/application-" + applicationId + "/" + fileName;
        PutObjectRequest request = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .contentType(file.getContentType())
                .build();
        RequestBody body = RequestBody.fromBytes(file.getBytes());
        s3Client.putObject(request, body);
        return key;
    }
    
}
