package response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CloseResponse {
    // 1:请求成功，0:请求失败
    private Integer return_code;

    private String return_msg;

    /**
     * payjs端订单号
     */
    private String payjs_order_id;



    /**
     * 数据签名
     */
    private String sign;
}
