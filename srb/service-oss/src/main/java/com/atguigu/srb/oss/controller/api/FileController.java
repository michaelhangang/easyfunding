package com.atguigu.srb.oss.controller.api;

import com.atguigu.common.exception.BusinessException;
import com.atguigu.common.result.R;
import com.atguigu.common.result.ResponseEnum;
import com.atguigu.srb.oss.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;

@Api(tags = "阿里云文件管理")
@CrossOrigin //跨域
@RestController
@RequestMapping("/api/oss/file")
public class FileController {

    @Resource
    private FileService fileService;

    /**
     * 文件上传
     */
    @ApiOperation("File upload")
    @PostMapping("/upload")
    public R upload(
            @ApiParam(value = "File", required = true)
            @RequestParam("file") MultipartFile file,

            @ApiParam(value = "Module", required = true)
            @RequestParam("module") String module)  {

        try {
            InputStream inputStream = file.getInputStream();
            String originalFilename = file.getOriginalFilename();
            String uploadUrl = fileService.upload(inputStream, module, originalFilename);

            return R.ok().message("File upload success").data("url", uploadUrl);
        } catch (IOException e) {
            throw new BusinessException(ResponseEnum.UPLOAD_ERROR, e);
        }
    }

    @ApiOperation("Delete OSS file")
    @DeleteMapping("/remove")
    public R remove(
            @ApiParam(value = "File path", required = true)
            @RequestParam("url") String url) {
        fileService.removeFile(url);
        return R.ok().message("Delete success");
    }
}
