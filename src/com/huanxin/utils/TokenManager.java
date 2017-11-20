package com.huanxin.utils;


import com.google.gson.Gson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;


public class TokenManager {

    private static String token;

    /**
     * 更新token
     */
    public static void updateToken() {
        Document document = null;
        TokenResponseBody tokenResponseBody = null;
        try {
            document = Jsoup.connect("https://a1.easemob.com/1133171107115421/medicalclient/token")
                    .header("Content-Type", "application/json")
                    .ignoreContentType(true)
                    .requestBody("{\"grant_type\": \"client_credentials\",\"client_id\": \"YXA6L0vBUMhnEeeTs2X1rGMrkA\",\"client_secret\": \"YXA6y2ZWuFaapzFnNGfK90Tzz9eeA6c\"}")
                    .post();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (document != null) {
            tokenResponseBody =  new Gson().fromJson(document.body().html(), TokenResponseBody.class);
            token = tokenResponseBody.access_token;

            //TestUtil.log(tokenResponseBody);
        }
    }

    /**
     * 获取本地保留的token
     */
    public static String getToken() {
        if (token == null) {
            updateToken();
        }
        return token;
    }

    public static void main(String args[]) {
        updateToken();
    }

    /**
     * 返回的token
     */
    private class TokenResponseBody {
        String access_token;
        String expires_in;
        String application;

        @Override
        public String toString() {
            return "TokenResponseBody{" +
                    "access_token='" + access_token + '\'' +
                    ", expires_in='" + expires_in + '\'' +
                    ", application='" + application + '\'' +
                    '}';
        }
    }

}