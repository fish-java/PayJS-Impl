package com.github.fish56.payjs.util;

import com.github.fish56.payjs.util.ObjectConvertUtil;
import org.junit.Test;
import com.github.fish56.payjs.request.NativeRequest;

public class ObjectConvertUtilTest {

    @Test
    public void toQS() {
        NativeRequest request = new NativeRequest(2, "33");
        String qs = ObjectConvertUtil.toQS(request);
        System.out.println(qs);
    }
}