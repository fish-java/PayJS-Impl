package response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CheckResponse {
    // 1:请求成功，0:请求失败
    private Integer return_code;

    private String mchid;

    // 用户发送的订单id
    private String out_trade_no;

    /**
     * payjs端订单号
     */
    private String payjs_order_id;

    private String transaction_id;

    // 0：未支付，1：支付成功
    private Integer status;

    private Integer total_fee;

    // 订单支付时间
    private String paid_time;

    /**
     * 数据签名
     */
    private String sign;
}
