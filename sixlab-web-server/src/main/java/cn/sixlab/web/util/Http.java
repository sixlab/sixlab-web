package cn.sixlab.web.util;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class Http {
    
    private static OkHttpClient defaultClient = null;
    private static OkHttpClient customClient = null;
    
    static {
        defaultClient = new OkHttpClient();
    
        OkHttpClient.Builder mBuilder  = new OkHttpClient.Builder();
        mBuilder.sslSocketFactory(createSSLSocketFactory());
        mBuilder.hostnameVerifier(new TrustAllHostnameVerifier());
        customClient = mBuilder.build();
        
        //client = client.newBuilder().sslSocketFactory(sslSocketFactory)
        //        .hostnameVerifier(new HostnameVerifier()...).build();
    }
    
    public static OkHttpClient client() {
        return defaultClient;
    }
    
    public static OkHttpClient client(boolean ignoreSSL) {
        if(ignoreSSL){
            return customClient;
        }else{
            return defaultClient;
        }
    }
    
    public static int requestCode(String url, boolean ignoreSSL) {
        int result = 0;
        try {
            Request request = new Request.Builder().url(url).build();
            Response response = Http.client(ignoreSSL).newCall(request).execute();
            result = response.code();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return result;
    }
    
    public static int requestCode(String url) {
        return requestCode(url, false);
    }
    
    public static String requestGetBody(String url) {
        String result = "";
        try {
            Request request = new Request.Builder().url(url).build();
            Response response = Http.client().newCall(request).execute();
            result = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return result;
    }
    
    public static Response requestGet(String url) {
        try {
            Request request = new Request.Builder().url(url).build();
            return Http.client().newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static Response requestPost(String url, String json) {
        try {
            RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
            Request request = new Request.Builder().url(url).post(requestBody).build();
            return Http.client().newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    private static SSLSocketFactory createSSLSocketFactory() {
        
        SSLSocketFactory sSLSocketFactory = null;
        
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, new TrustManager[]{new TrustAllManager()},
                    new SecureRandom());
            sSLSocketFactory = sc.getSocketFactory();
        } catch (Exception e) {
        }
        
        return sSLSocketFactory;
    }
    
    private static class TrustAllManager implements X509TrustManager {
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
        }
        
        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType)
                
                throws CertificateException {
        }
    
        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }
    
    private static class TrustAllHostnameVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }
}