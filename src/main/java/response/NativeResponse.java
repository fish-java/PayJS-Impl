package response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NativeResponse {
    // 1:请求成功，0:请求失败
    private Integer return_code;

    // 发生错误是的响应信息
    private String msg;

    // 返回的消息
    private String return_msg;

    /**
     * payjs端订单号
     */
    private String payjs_order_id;

    // 用户发送的订单id
    private String out_trade_no;

    /**
     * 数据签名
     */
    private String sign;

}
//{"code_url":"weixin://wxpay/bizpayurl?pr=g00FOw5",
// "out_trade_no":"123124",
// "payjs_order_id":"2019042918343500220894343",
// "qrcode":"https://payjs.cn/qrcode/d2VpeGluOi8vd3hwYXkvYml6cGF5dXJsP3ByPWcwMEZPdzU=",
// "return_code":1,
// "return_msg":"SUCCESS",
// "total_fee":"21",
// "sign":"68402564DCF0AA95A9176270EABC8B70"}
