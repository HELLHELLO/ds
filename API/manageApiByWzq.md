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
```JSON
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
没有参数校验，不会错误  


##### 2.查询指定商品的不同配置商品
>也就是查那个iphone 7 Plus 土豪金 64GB 联通版  

接口地址：/stuItem/{id}  
参数：page：起始页面，rows：行数  
请求方法：get  
请求实例  
`http://localhost:8080/stuItem/1?page=1&rows=30`  
请求返回值  
```json
{
  "total": 1,
  "rows": [
    {
      "itemId": 1,
      "itemsId": 1,
      "title": "测试",
      "paramter": "测试",
      "price": 10000,
      "num": 500,
      "barcode": "暂无",
      "image": "暂无",
      "cid": 1,
      "status": 1,
      "created": 1545728119000,
      "updated": 1545728119000,
      "valued": true
    }
  ]
}
```
没有参数校验，不会错误

## 用户查询

##### 3.获取用户列表

接口地址：/users/list

请求参数：page：起始页面，rows：行数

请求方法：get

请求实例：```http://localhost:8080/users/list```

请求返回值：先鸽了

没有参数校验，不会错误

##### 4 根据用户id获取用户信息

接口地址：/user/{id}

请求参数：page：起始页面，rows：行数，id：用户ID

请求方法：get

请求实例：```http://localhost:8080/users/1```

请求返回值：先鸽了

没有参数校验，不会错误。

## 商品分类相关

##### 5 获取商品分类信息

接口地址 /Cats/list

请求参数：无

请求方法：get

请求实例：```http://localhost:8080/Cats/list```

请求返回值：

```json
  {
    "cat": {
      "catId": 1,
      "parentId": 0,
      "name": "水产品",
      "status": 1,
      "sortOrder": null,
      "isParent": true,
      "created": 1546156550000,
      "updated": 1546156550000,
      "valued": true,
      "picId": "1",
      "catDesc": null
    },
    "children": [
      {
        "cat": {
          "catId": 3,
          "parentId": 1,
          "name": "鱼",
          "status": 1,
          "sortOrder": null,
          "isParent": true,
          "created": 1546156550000,
          "updated": 1546156550000,
          "valued": true,
          "picId": "3",
          "catDesc": null
        },
        "children": [
          {
            "cat": {
              "catId": 5,
              "parentId": 3,
              "name": "淡水鱼",
              "status": 1,
              "sortOrder": null,
              "isParent": false,
              "created": 1546156550000,
              "updated": 1546156550000,
              "valued": true,
              "picId": "4",
              "catDesc": null
            },
            "children": null
          }
        ]
      },
      {
        "cat": {
          "catId": 4,
          "parentId": 1,
          "name": "虾",
          "status": 1,
          "sortOrder": null,
          "isParent": true,
          "created": 1546156550000,
          "updated": 1546156550000,
          "valued": true,
          "picId": "3",
          "catDesc": null
        },
        "children": []
      }
    ]
  },
  {
    "cat": {
      "catId": 2,
      "parentId": 0,
      "name": "谷物",
      "status": 1,
      "sortOrder": null,
      "isParent": true,
      "created": 1546156550000,
      "updated": 1546156550000,
      "valued": true,
      "picId": "2",
      "catDesc": null
    },
    "children": []
  }
]
```

没有参数校验，不会错误



##### 6.图片上传接口：

接口地址：/pic/upload

剩下的先鸽了

##### 7.添加商品分类接口：

接口地址：/Cats/new

剩下的鸽了

##### 8.根据用户名查询用户

接口地址：/users/name

同上



