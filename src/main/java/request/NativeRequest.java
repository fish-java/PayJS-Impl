package request;

import lombok.Getter;
import lombok.Setter;

//   https://help.payjs.cn/api-lie-biao/sao-ma-zhi-fu.html
// 创建订单时需要的参数
@Getter
@Setter
public class NativeRequest {
    // 必填的、由程序自动生成
    private String mchid;
    private String sign;

    // 必填的，用户创建对象时自行填写
    private Integer total_fee;
    private String out_trade_no;

    // 可选的，自行通过set方法插入
    private String type;
    private String body;
    private String attach;
    private String notify_url;

    // 这两个字段是必须填写的，所以有且只有这一个构造函数
    public NativeRequest(Integer total_fee, String out_trade_no) {
        this.total_fee = total_fee;
        this.out_trade_no = out_trade_no;
    }
}
