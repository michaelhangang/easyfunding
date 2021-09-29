package com.atguigu.srb.oss.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.CannedAccessControlList;
import com.atguigu.srb.oss.service.FileService;
import com.atguigu.srb.oss.util.OssProperties;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    /**
     * 文件上传至阿里云
     */
    @Override
    public String upload(InputStream inputStream, String module, String fileName) {

        OSS ossClient = new OSSClientBuilder().build(
                OssProperties.ENDPOINT,
                OssProperties.KEY_ID,
                OssProperties.KEY_SECRET);
        if(!ossClient.doesBucketExist(OssProperties.BUCKET_NAME)){
            ossClient.createBucket(OssProperties.BUCKET_NAME);
            ossClient.setBucketAcl(OssProperties.BUCKET_NAME, CannedAccessControlList.PublicRead);
        }

        String folder = new DateTime().toString("yyyy/MM/dd");
        fileName = UUID.randomUUID().toString() + fileName.substring(fileName.lastIndexOf("."));
        String key = module + "/" + folder + "/" + fileName;
        ossClient.putObject(OssProperties.BUCKET_NAME, key, inputStream);
        ossClient.shutdown();

        return "https://" + OssProperties.BUCKET_NAME + "." + OssProperties.ENDPOINT + "/" + key;
    }

    @Override
    public void removeFile(String url) {


        OSS ossClient = new OSSClientBuilder().build(
                OssProperties.ENDPOINT,
                OssProperties.KEY_ID,
                OssProperties.KEY_SECRET);

        String host = "https://" + OssProperties.BUCKET_NAME + "." + OssProperties.ENDPOINT + "/";
        String objectName = url.substring(host.length());
        ossClient.deleteObject(OssProperties.BUCKET_NAME, objectName);

        ossClient.shutdown();
    }
}
