# 后台管理相关接口
## 商品列表查询（items）
>items与itemForItems的区别，以淘宝上卖的iPhone7为例，items为iphone7，itemForItems为购买iphone7时选择的iphone 7 Plus 土豪金 64GB 联通版

##### 1. 查询全部商品
接口地址：/items/list
参数：page：起始页面，rows：行数
请求方法：get
请求实例
`http://localhost:8080/items/list?page=1&rows=30`
请求返回值
```
{
  "total": 1,
  "rows": [
    {
      "itemsId": 1,
      "shopId": 1,
      "brandId": 1,
      "name": "测试",
      "created": 1545640318000,
      "updated": 1545640318000,
      "price": 1000,
      "unit": "件",
      "shopName": "测试",
      "cid": 1,
      "brandName": "测试",
      "image": "暂无",
      "valued": true,
      "itemDesc": null
    }
  ]
}
```
参数校验及错误校验等到时候再说，先鸽了

##### 2.查询指定商品的不同配置商品
>也就是查那个iphone 7 Plus 土豪金 64GB 联通版

接口地址：/stuItem/{id}
参数：page：起始页面，rows：行数
请求方法：get
请求实例
`http://localhost:8080/stuItem/1?page=1&rows=30`
请求返回值
```
{
  "total": 0,
  "rows": []
}
```
具体返回字段等我往数据库里插好数据之后再说，先鸽了
参数校验及错误校验等到时候再说，先鸽了
