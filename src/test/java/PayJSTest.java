import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import request.CheckRequest;
import request.CloseRequest;
import request.NativeRequest;
import response.CheckResponse;
import response.CloseResponse;
import response.NativeResponse;

import static org.junit.Assert.*;

public class PayJSTest {
    private String mchid = "1528140051";

    // 你的商户密钥
    private String key = "xxxxxx";
    PayJS payJS = new PayJS(mchid, key);

    @Test
    public void apiNative() {
        // 创建请求对象，将参数写成对象的格式是为了做静态类型检查
        NativeRequest request = new NativeRequest(21, "2332");

        // 调用相关方法并获得结果
        NativeResponse response = payJS.apiNative(request);
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
        NativeResponse response = payJS.apiNative(request);
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
        CheckResponse response = payJS.apiCheck(request);

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
        CloseResponse response = payJS.apiClose(request);

        assertTrue(response.getReturn_code().intValue() == 1);

        System.out.println(JSONObject.toJSONString(response));
    }
}