package com.gezhi.gege.httputil;

import org.json.JSONObject;

import java.awt.font.NumericShaper;

import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class OkHttp {
    public static void post(String url, JSONObject jsonObject, Callback callback) {

        MediaType type = MediaType.parse("application/json;charset=utf-8");
        RequestBody requestBody1 = RequestBody.create(type, "" + jsonObject.toString());

        /*创建一个RequestBody(参数1：数据格式，参数2：传递的json串)*/

        /*创建一个OkHttpClient对象*/
        OkHttpClient client = new OkHttpClient();
        /*创建一个请求对象*/
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody1)
                .build();
        client.newCall(request).enqueue(callback);


    }
}
