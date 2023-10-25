package com.chendys.webbackend.util;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Component
public class FileUtil {
    public static final List<String> IMAGE_EXTENSIONS = Arrays.asList(".jpg", ".jpeg", ".png");


    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}

