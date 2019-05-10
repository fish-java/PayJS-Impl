package com.github.fish56.payjs.request;

import lombok.Getter;
import lombok.Setter;

/**
 * 查询订单时需要的参数
 * https://help.payjs.cn/api-lie-biao/ding-dan-cha-xun.html
 */
@Getter
@Setter
public class CheckRequest {
    private String payjs_order_id;
    private String sign;

    /**
     * @param payjs_order_id PAYJS 平台订单号
     */
    public CheckRequest(String payjs_order_id) {
        this.payjs_order_id = payjs_order_id;
    }
}
