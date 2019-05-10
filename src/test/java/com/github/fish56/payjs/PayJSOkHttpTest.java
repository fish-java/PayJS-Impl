package com.github.fish56.payjs;

import com.alibaba.fastjson.JSONObject;
import com.github.fish56.payjs.PayJSOkHttp;
import org.junit.Test;
import com.github.fish56.payjs.request.CheckRequest;
import com.github.fish56.payjs.request.CloseRequest;
import com.github.fish56.payjs.request.NativeRequest;
import com.github.fish56.payjs.response.CheckResponse;
import com.github.fish56.payjs.response.CloseResponse;
import com.github.fish56.payjs.response.NativeResponse;

import static org.junit.Assert.*;

public class PayJSOkHttpTest extends PayJSTest {
    private PayJSOkHttp payJSOkHttp = new PayJSOkHttp(mchid, key);

    @Test
    public void apiNative() {
        // 创建请求对象，将参数写成对象的格式是为了做静态类型检查
        NativeRequest request = new NativeRequest(21, "2332");

        // 调用相关方法并获得结果
        NativeResponse response = payJSOkHttp.apiNative(request);
        if (response.getReturn_code() != 1) {
            throw new RuntimeException("出错了: " + response.getReturn_msg());
        }

        System.out.println(JSONObject.toJSONString(response));
    }

    @Test
    public void apiNativeWithError() {
        NativeRequest request = new NativeRequest(21, "2332");

        // 故意传入错误的商户id
        request.setMchid("123");
        NativeResponse response = payJSOkHttp.apiNative(request);
        if (response.getReturn_code() == 0) {
            System.out.println("出错了: " + response.getReturn_msg());
        } else {
            throw new RuntimeException("应该返回错误信息");
        }
        System.out.println(JSONObject.toJSONString(response));
    }

    @Test
    public void check(){
        String payjs_order_id = "2019043012232600733973651";
        CheckRequest request = new CheckRequest(payjs_order_id);
        CheckResponse response = payJSOkHttp.apiCheck(request);

        assertTrue(response.getReturn_code().intValue() == 1);

        // {"mchid":"1528140051","out_trade_no":"2332","paid_time":"0",
        // "payjs_order_id":"2019043012232600733973651","return_code":1,
        // "sign":"A8B28ED47B56FC85AD661C6DA446A651","status":0,
        // "total_fee":21,"transaction_id":"0"}
        System.out.println(JSONObject.toJSONString(response));
    }

    @Test
    public void close(){
        // 关闭一个订单
        String payjs_order_id = "2019043012232600733973651";
        CloseRequest request = new CloseRequest(payjs_order_id);
        CloseResponse response = payJSOkHttp.apiClose(request);

        assertTrue(response.getReturn_code().intValue() == 1);

        System.out.println(JSONObject.toJSONString(response));
    }
}