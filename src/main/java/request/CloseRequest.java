package request;

import lombok.Getter;
import lombok.Setter;

// https://help.payjs.cn/api-lie-biao/ding-dan-cha-xun.html
// 查询订单时需要的参数
@Getter
@Setter
public class CloseRequest {
    private String payjs_order_id;
    private String sign;

    public CloseRequest(String payjs_order_id) {
        this.payjs_order_id = payjs_order_id;
    }
}
