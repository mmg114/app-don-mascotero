package com.mangoprograming.app.service.aws;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

@Service
public class AwsS3Service {

    @Autowired
    private AmazonS3 amazonS3;

    public void uploadImage(String bucketName, String key, byte[] imageData) throws RuntimeException {

            InputStream inputStream = new ByteArrayInputStream(imageData);
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(imageData.length);
            amazonS3.putObject(new PutObjectRequest(bucketName, key, inputStream, metadata));

        }
    }

