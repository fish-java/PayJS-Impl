package util;

import org.junit.Test;
import request.NativeRequest;
import response.NativeResponse;

import static org.junit.Assert.*;

public class ObjectConvertUtilTest {

    @Test
    public void toQS() {
        NativeRequest request = new NativeRequest(2, "33");
        String qs = ObjectConvertUtil.toQS(request);
        System.out.println(qs);
    }
}