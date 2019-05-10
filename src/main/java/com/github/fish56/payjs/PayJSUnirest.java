package com.github.fish56.payjs;

import com.alibaba.fastjson.JSONObject;
import com.github.fish56.payjs.request.CheckRequest;
import com.github.fish56.payjs.request.CloseRequest;
import com.github.fish56.payjs.request.NativeRequest;
import com.github.fish56.payjs.response.CheckResponse;
import com.github.fish56.payjs.response.CloseResponse;
import com.github.fish56.payjs.response.NativeResponse;
import com.github.fish56.payjs.util.ObjectConvertUtil;
import com.github.fish56.payjs.util.SignUtil;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class PayJSUnirest extends PayJS {
    public PayJSUnirest(String mchid, String key) {
        super(mchid, key);
    }

    @Override
    public NativeResponse apiNative(NativeRequest request) {
        // 填充商户id
        if (request.getMchid() == null) {
            request.setMchid(mchid);
        }
        // 计算签名
        String sign = SignUtil.getSign(request, key);
        request.setSign(sign);

        // 获得url
        String qs = ObjectConvertUtil.toQS(request);
        String url = baseUrl + "/native?" + qs;
        NativeResponse response = new NativeResponse();

        try {
           HttpResponse<String> httpResponse = Unirest.post(url).asString();
           response = JSONObject.parseObject(httpResponse.getBody(), NativeResponse.class);
        } catch (UnirestException e) {
            e.printStackTrace();
            response.setReturn_code(0);
            response.setReturn_msg(e.getMessage());
        }
        return response;
    }

    @Override
    public CheckResponse apiCheck(CheckRequest request) {
        // 计算签名
        String sign = SignUtil.getSign(request, key);
        request.setSign(sign);

        // 获得url
        String qs = ObjectConvertUtil.toQS(request);
        String url = baseUrl + "/check?" + qs;
       CheckResponse response = new CheckResponse();

        try {
            HttpResponse<String> httpResponse = Unirest.post(url).asString();
            response = JSONObject.parseObject(httpResponse.getBody(), CheckResponse.class);
        } catch (UnirestException e) {
            e.printStackTrace();
            response.setReturn_code(0);
        }
        return response;
    }

    @Override
    public CloseResponse apiClose(CloseRequest request) {
        return null;
    }
}
