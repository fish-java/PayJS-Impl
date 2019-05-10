package com.github.fish56.payjs;

import com.alibaba.fastjson.JSONObject;
import com.github.fish56.payjs.request.CheckRequest;
import com.github.fish56.payjs.request.NativeRequest;
import com.github.fish56.payjs.response.CheckResponse;
import com.github.fish56.payjs.response.NativeResponse;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PayJSUnirestTest extends PayJSTest {
    private PayJS payJS;

    @Before
    public void init(){
        payJS = new PayJSUnirest(mchid, key);
    }

    /**
     * 创建一个扫码支付的订单
     */
    @Test
    public void apiNative() {
        NativeRequest request = new NativeRequest(20, "3252");
        NativeResponse response = payJS.apiNative(request);
        System.out.println(JSONObject.toJSONString(response, true));
        assertNotNull(response.getQrcode());
    }

    /**
     * 测试用的订单号
     */
    private String orderId = "2019051009055400486094093";
    @Test
    public void apiCheck() {
        CheckRequest request = new CheckRequest(orderId);
        CheckResponse response = payJS.apiCheck(request);
        System.out.println(JSONObject.toJSONString(response, true));
    }

    @Test
    public void apiClose() {
    }
}