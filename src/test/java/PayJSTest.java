import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import response.NativeResponse;

import static org.junit.Assert.*;

public class PayJSTest {
    private String mchid = "1528140051";

    // 你的商户密钥
    private String key = "xxxxxx";

    @Test
    public void apiNative() {
        PayJS payJS = new PayJS(mchid, key);
        NativeResponse response = payJS.apiNative("123124", 21);
        System.out.println(JSONObject.toJSONString(response));
    }
}