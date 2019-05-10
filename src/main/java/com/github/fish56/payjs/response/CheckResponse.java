package com.github.fish56.payjs.response;

import lombok.Getter;
import lombok.Setter;

/**
 * 订单查询接口的返回信息的POJO格式
 * https://help.payjs.cn/api-lie-biao/ding-dan-cha-xun.html
 */
@Getter
@Setter
public class CheckResponse {
    /**
     * 1:请求成功，0:请求失败
     */
    private Integer return_code;

    private String mchid;

    /**
     * 用户发送的订单id
     */
    private String out_trade_no;

    /**
     * payjs端订单号
     */
    private String payjs_order_id;

    /**
     * 微信显示订单号
     */
    private String transaction_id;

    private Integer total_fee;

    /**
     * 0：未支付，1：支付成功
     */
    private Integer status;

    /**
     * 订单支付时间
     */
    private String paid_time;

    /**
     * 数据签名
     */
    private String sign;
}
