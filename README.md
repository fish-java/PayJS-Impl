# com.github.fish56.payjs.PayJSOkHttp
使用PayJS来获取支付请求

## 设计思路

### 请求对象 和 响应对象
为了能够享受静态类型检查，我为每个API调用的请求参数和
响应体 创建了一个对象。

对象的字段和PayJS文档中列举的是一致。

每个请求对象有且只有一个构造函数，这个构造函数
的参数是必填的字段，对于选填的字段用户可以通过
Getter Setter方法来设置

### PayJS这个抽象类
提供了通用的API接口，创建时需要传入用户mchid以及key。

使用时：

- apiNative
  
  获得二维码
  
- apiCheck

  查询订单
  
函数名和请求的url是保持一致的

具体用法查考测试用例

### 实现类
推荐使用PayJSUnirest作为实现类