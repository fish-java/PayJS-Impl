package com.github.fish56.payjs;

import com.github.fish56.payjs.request.CheckRequest;
import com.github.fish56.payjs.request.CloseRequest;
import com.github.fish56.payjs.request.NativeRequest;
import com.github.fish56.payjs.response.CheckResponse;
import com.github.fish56.payjs.response.CloseResponse;
import com.github.fish56.payjs.response.NativeResponse;

/**
 * 发起请求的客户端的抽象类
 */
public abstract class PayJS {
    protected String mchid;
    protected String key;
    protected String baseUrl = "https://payjs.cn/api";

    /**
     * 构造函数，传入必填项
     * @param mchid 商户id
     * @param key 商户密钥
     */
    public PayJS(String mchid, String key){
        this.mchid = mchid;
        this.key = key;
    }

    /**
     * 创建扫码支付的订单
     * @param request 扫码支付需要的参数对象
     * @return
     */
    public abstract NativeResponse apiNative(NativeRequest request);

    /**
     * 查询订单
     * @param request
     * @return
     */
    public abstract CheckResponse apiCheck(CheckRequest request);

    /**
     * 关闭订单
     * @param request
     * @return
     */
    public abstract CloseResponse apiClose(CloseRequest request);
}
