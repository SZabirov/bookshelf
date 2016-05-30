package com.fujitsu.fs.javalab.bookshelf.web.utils;


import org.apache.commons.codec.digest.DigestUtils;

public class HashUtils {
    public static String md5Apache(String st) {
        String md5Hex = DigestUtils.md5Hex(st);

        return md5Hex;
    }
}
