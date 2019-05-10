package com.github.fish56.payjs.request;

import lombok.Getter;
import lombok.Setter;

/**
 * 关闭订单时需要的参数
 * https://help.payjs.cn/api-lie-biao/ding-dan-cha-xun.html
 */
@Getter
@Setter
public class CloseRequest {
    private String payjs_order_id;
    private String sign;

    /**
     *
     * @param payjs_order_id PayJS平台订单号
     */
    public CloseRequest(String payjs_order_id) {
        this.payjs_order_id = payjs_order_id;
    }
}
