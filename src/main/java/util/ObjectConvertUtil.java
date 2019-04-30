package util;

import com.alibaba.fastjson.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.internal.http.HttpMethod;

import java.util.Map;

public class ObjectConvertUtil {
    // 对象转化为查询字符串
    public static String toQS(Object object){

        // 对象转化为map
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map =
                objectMapper.convertValue(
                        object, Map.class);

        // 遍历map，将其转化为query string格式的
        StringBuilder qs = new StringBuilder();
        for (String key : map.keySet()){
            // 如果字段为空，则跳过
            if (map.get(key) == null){
                continue;
            }
            // key=value&
            qs.append(key);
            qs.append("=");
            qs.append(map.get(key));
            qs.append("&");
        }

        // 删除最后面的一个字符
        if (qs.length() != 0) {
            qs.deleteCharAt(qs.length() - 1);
        }
        return qs.toString();
    }
}
