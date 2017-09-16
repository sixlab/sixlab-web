/*
 * Copyright (c) 2017 Sixlab. All rights reserved.
 *
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 *
 * For more information, please see
 * https://sixlab.cn/
 */
package cn.sixlab.web.util;

import org.springframework.security.crypto.codec.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha1Utils {
    
    private static MessageDigest getSha1Digest() {
        try {
            return MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException var1) {
            throw new RuntimeException(var1.getMessage());
        }
    }
    
    public static byte[] sha(byte[] data) {
        return getSha1Digest().digest(data);
    }
    
    public static byte[] sha(String data) {
        return sha(data.getBytes());
    }
    
    public static String shaHex(String data) {
        return new String(Hex.encode(sha(data)));
    }
    
}
