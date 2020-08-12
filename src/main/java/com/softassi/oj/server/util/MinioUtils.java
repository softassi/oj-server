package com.softassi.oj.server.util;


import io.minio.*;
import io.minio.errors.*;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class MinioUtils {

    private static String url;
    private static String accessKey;
    private static String secretKey;


    @Value("${minio.url}")
    public void setUrl(String url) {
        this.url = url;
    }

    @Value("${minio.accessKey}")
    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    @Value("${minio.secretKey}")
    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    private static MinioClient minioClient;

    static {
        System.out.println(url);
        minioClient = MinioClient.builder().
                endpoint("http://47.102.216.163:9000").
                credentials("AKIAIOSFODNN7EXAMPLE", "wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY").
                build();
    }

    /**
     * 判断 bucket是否存在
     *
     * @param bucketName
     * @return
     */
    public static boolean bucketExists(String bucketName) {
        try {
            return minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    /**
     * 创建 bucket
     *
     * @param bucketName
     */

    public static void makeBucket(String bucketName) {
        try {

            minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 文件上传
     *
     * @param bucketName
     * @param objectName
     * @param filename
     */
    public static boolean putObject(String bucketName, String objectName, String filename) {
        try {
            minioClient.putObject(bucketName, objectName, filename, null);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 文件上传
     *
     * @param bucketName
     * @param objectName
     * @param stream
     */

    public static boolean putObject(String bucketName, String objectName, InputStream stream, long size) {
        try {
            minioClient.putObject(PutObjectArgs.builder().bucket(bucketName).object(objectName)
                    .stream(stream, size, -1).build());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * 删除文件
     *
     * @param bucketName
     * @param objectName
     */

    public static boolean removeObject(String bucketName, String objectName) {
        try {
            minioClient.removeObject(RemoveObjectArgs.builder().bucket(bucketName).object(objectName).build());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static InputStream getObject(String bucketName, String objectName) {
        try {
            return minioClient.getObject(GetObjectArgs.builder().bucket(bucketName).object(objectName).build());
        } catch (ErrorResponseException e) {
            e.printStackTrace();
        } catch (InsufficientDataException e) {
            e.printStackTrace();
        } catch (InternalException e) {
            e.printStackTrace();
        } catch (InvalidBucketNameException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (InvalidResponseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (XmlParserException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 删除文件路径*
     */

    public static String getObjectUrl(String bucketName, String objectName) {
        try {
            return minioClient.getObjectUrl(bucketName, objectName);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}