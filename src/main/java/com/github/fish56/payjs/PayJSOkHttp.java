package com.github.fish56.payjs;

import com.alibaba.fastjson.JSONObject;
import okhttp3.*;
import com.github.fish56.payjs.request.CheckRequest;
import com.github.fish56.payjs.request.CloseRequest;
import com.github.fish56.payjs.request.NativeRequest;
import com.github.fish56.payjs.response.CheckResponse;
import com.github.fish56.payjs.response.CloseResponse;
import com.github.fish56.payjs.response.NativeResponse;
import com.github.fish56.payjs.util.ObjectConvertUtil;
import com.github.fish56.payjs.util.SignUtil;

import java.io.IOException;

public class PayJSOkHttp {
    private String mchid;
    private String key;
    private String baseUrl = "https://payjs.cn/api";

    private OkHttpClient client = new OkHttpClient();

    public PayJSOkHttp(String mchid, String key){
        this.mchid = mchid;
        this.key = key;
    }

    // 统一获得请求查询字符串
    private String getRequestParam(){
        return null;
    }

    // 统一使用它发起http请求, 并将放回的响应体解析成对应对象
    private <T> T doRequest(String url, Class<T> clazz){
        // 对于PayJS get 请求是可以代替Post请求的, OkHTTP 强制post请求携带请求体
        Request httpRequest = new Request.Builder()
                .url(url)
                .build();

        // 准备发起请求
        Call call = client.newCall(httpRequest);

        Response httpResponse = null;

        try {
            // 发起请求并接受响应
            httpResponse = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String responseString = null;

        try {
            // 获得响应体内容
            responseString = httpResponse.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return JSONObject.parseObject(responseString, clazz);
    }

    // https://help.payjs.cn/api-lie-biao/sao-ma-zhi-fu.html
    public NativeResponse apiNative(NativeRequest requestObject) {
        if (requestObject.getMchid() == null) {
            requestObject.setMchid(mchid);
        }
        // 获得sign并设置
        String sign = SignUtil.getSign(requestObject, key);
        requestObject.setSign(sign);

        String qs = ObjectConvertUtil.toQS(requestObject);

        // 创建请求url
        String url = baseUrl + "/native?" + qs;

        return doRequest(url, NativeResponse.class);
    }

    public CheckResponse apiCheck(CheckRequest requestObj){
        String sign = SignUtil.getSign(requestObj, key);
        requestObj.setSign(sign);
        String qs = ObjectConvertUtil.toQS(requestObj);

        String url = baseUrl + "/check?" + qs;

        return doRequest(url, CheckResponse.class);
    }

    public CloseResponse apiClose(CloseRequest requestObj){
        String sign = SignUtil.getSign(requestObj, key);
        requestObj.setSign(sign);
        String qs = ObjectConvertUtil.toQS(requestObj);

        String url = baseUrl + "/close?" + qs;

        return doRequest(url, CloseResponse.class);
    }



    private String out_trade_no;

    private String body;
}
