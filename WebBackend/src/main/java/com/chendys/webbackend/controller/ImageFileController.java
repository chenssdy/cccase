package com.chendys.webbackend.controller;

import com.chendys.webbackend.util.FileUtil;
import com.chendys.webbackend.util.exception.Asserts;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.Set;

/**
 * 图片上传服务接口
 * @author chenssdy
 * @createDate 2023-1-6 16:18
 */
@RestController
@RequestMapping("/up")
public class ImageFileController {


    @PostMapping("/upImage")
    public String upImage(@RequestParam("image") MultipartFile image){
        if (image.getSize() == 0) {
            return "";
        }

        // 源文件名称
        final String originalFileName = image.getOriginalFilename();
        if (StringUtils.isBlank(originalFileName)) {
            Asserts.args("请选择图片文件");
        }

        // 文件后缀[.jpg]
        final String suffix = originalFileName.substring(originalFileName.lastIndexOf(".")).toLowerCase();
        if (!FileUtil.IMAGE_EXTENSIONS.contains(suffix)) {
            Asserts.args("图片格式不支持");
        }

        String lastFilePath;
        String newFileName = FileUtil.getUUID() + suffix;
//        String folderName = File.separator + "static" + File.separator;
//        String relativePath = DateUtil.getYYYYMMDD() + File.separator + DateUtil.getHH();
//        String filePath = "G:\\CCCASE\\img\\accessories";
        String filePath = "/opt/tomcat/webapps/static/img/accessories";
        String fileUrl = null;
        File targetFile = new File(filePath);

        FileOutputStream out = null;
        try {
            if (!targetFile.exists()) {
                boolean created = targetFile.createNewFile();
            }
            lastFilePath = filePath + File.separator + newFileName;
            out = new FileOutputStream(lastFilePath);
            out.write(image.getBytes());
            // 设置文件权限
            Set<PosixFilePermission> permissions = new HashSet<>();
            permissions.add(PosixFilePermission.OWNER_READ);
            permissions.add(PosixFilePermission.GROUP_READ);
            permissions.add(PosixFilePermission.OTHERS_READ);
            permissions.add(PosixFilePermission.OWNER_WRITE);
            Files.setPosixFilePermissions(Paths.get(lastFilePath), permissions);
            fileUrl = "http://121.37.130.225:8080/static/img/accessories" + File.separator + newFileName;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        if (fileUrl == null) {
            Asserts.Abnormal("文件上传失败，请稍后再试");
        }

        return fileUrl;
    }
}
