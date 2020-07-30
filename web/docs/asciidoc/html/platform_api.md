# 整体接口模块


<a name="overview"></a>
## 概览

### 版本信息
*版本* : V4.1


### 联系方式
*名字* : Powered By JeeSite V4.1.5


### URI scheme
*域名* : 127.0.0.1:8888  
*基础路径* : /platform


### 标签

* common-accessory-category-controller : Common Accessory Category Controller
* common-accessory-controller : Common Accessory Controller
* common-assessment-controller : Common Assessment Controller
* common-assessment-scheme-controller : Common Assessment Scheme Controller
* common-assessment-stu-controller : Common Assessment Stu Controller
* common-basic-scheme-controller : Common Basic Scheme Controller
* common-log-controller : Common Log Controller
* common-school-controller : Common School Controller
* common-software-controller : Common Software Controller
* common-user-controller : Common User Controller
* common-vehicle-image-controller : Common Vehicle Image Controller
* maintenance-controller : Maintenance Controller
* maintenance-type-controller : Maintenance Type Controller
* vehicle-brand-controller : Vehicle Brand Controller
* vehicle-danger-controller : Vehicle Danger Controller
* vehicle-danger-detail-controller : Vehicle Danger Detail Controller
* vehicle-danger-total-controller : Vehicle Danger Total Controller
* vehicle-info-controller : Vehicle Info Controller
* vehicle-series-controller : Vehicle Series Controller




<a name="paths"></a>
## 资源

<a name="common-accessory-category-controller_resource"></a>
### Common-accessory-category-controller
Common Accessory Category Controller


<a name="deletecommonaccessoryandcategoryusingpost"></a>
#### 删除配件分类信息
```
POST /common/commonAccessoryCategory/deleteCommonAccessoryAndCategory
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**json**  <br>*必填*|删除用的json数据|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonAccessoryCategory/deleteCommonAccessoryAndCategory
```


###### 请求 query
```
json :
{
  "json" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="downtemplateusingpost"></a>
#### 下载配件信息表
```
POST /common/commonAccessoryCategory/downTemplate
```


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|无内容|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `application/octet-stream`


##### HTTP请求示例

###### 请求 path
```
/common/commonAccessoryCategory/downTemplate
```


<a name="findnamebypartscodeusingpost"></a>
#### findNameByPartsCode
```
POST /common/commonAccessoryCategory/findNameByPartsCode
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**code**  <br>*可选*|code|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonAccessoryCategory/findNameByPartsCode
```


###### 请求 query
```
json :
{
  "code" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="findpartsforvehiclepartsusingpost"></a>
#### findPartsForVehicleParts
```
POST /common/commonAccessoryCategory/findPartsForVehicleParts
```


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonAccessoryCategory/findPartsForVehicleParts
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="listcommonaccessorycategoryusingpost"></a>
#### 加载分页配件分类数据
```
POST /common/commonAccessoryCategory/listCommonAccessoryCategory
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**categoryName**  <br>*可选*|string|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonAccessoryCategory/listCommonAccessoryCategory
```


###### 请求 query
```
json :
{
  "categoryName" : "string",
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "remarks" : "string",
  "status" : "string",
  "status_in" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="savecommonaccessoryandcategoryusingpost"></a>
#### 更新配件分类信息
```
POST /common/commonAccessoryCategory/saveCommonAccessoryAndCategory
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**categoryName**  <br>*可选*|string|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonAccessoryCategory/saveCommonAccessoryAndCategory
```


###### 请求 query
```
json :
{
  "categoryName" : "string",
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "remarks" : "string",
  "status" : "string",
  "status_in" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="uploadcommonaccessoryandcategoryusingpost"></a>
#### 保存配件分类并上传对应的配件数据
```
POST /common/commonAccessoryCategory/uploadCommonAccessoryAndCategory
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**categoryName**  <br>*可选*||string|
|**Query**|**createBy**  <br>*可选*||string|
|**Query**|**createByName**  <br>*可选*||string|
|**Query**|**createDate**  <br>*可选*||string (date-time)|
|**Query**|**createDate_between**  <br>*可选*||string|
|**Query**|**createDate_gte**  <br>*可选*||string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*||string (date-time)|
|**Query**|**id**  <br>*可选*||string|
|**Query**|**id_in**  <br>*可选*||< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*||boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*||integer (int64)|
|**Query**|**orderBy**  <br>*可选*||string|
|**Query**|**pageNo**  <br>*可选*||integer (int32)|
|**Query**|**pageSize**  <br>*可选*||integer (int32)|
|**Query**|**remarks**  <br>*可选*||string|
|**Query**|**status**  <br>*可选*||string|
|**Query**|**status_in**  <br>*可选*||< string > array(multi)|
|**Query**|**updateBy**  <br>*可选*||string|
|**Query**|**updateByName**  <br>*可选*||string|
|**Query**|**updateDate**  <br>*可选*||string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*||string|
|**Query**|**updateDate_gte**  <br>*可选*||string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*||string (date-time)|
|**FormData**|**file**  <br>*必填*|查询的数据对象|ref|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `multipart/form-data`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonAccessoryCategory/uploadCommonAccessoryAndCategory
```


###### 请求 query
```
json :
{
  "categoryName" : "string",
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "remarks" : "string",
  "status" : "string",
  "status_in" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string"
}
```


###### 请求 formData
```
json :
"ref"
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="common-accessory-controller_resource"></a>
### Common-accessory-controller
Common Accessory Controller


<a name="deletecommonaccessoryusingpost"></a>
#### 删除配件信息
```
POST /common/commonAccessory/deleteCommonAccessory
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**json**  <br>*必填*|删除的json信息|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonAccessory/deleteCommonAccessory
```


###### 请求 query
```
json :
{
  "json" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="listcommonaccessoryusingpost"></a>
#### 加载配件分页数据
```
POST /common/commonAccessory/listCommonAccessory
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**accessoryBrand**  <br>*可选*|string|
|**Query**|**accessoryImport**  <br>*可选*|string|
|**Query**|**accessoryIndex**  <br>*可选*|string|
|**Query**|**accessoryLevel**  <br>*可选*|string|
|**Query**|**accessoryName**  <br>*可选*|string|
|**Query**|**accessoryPlaceOfOrigin**  <br>*可选*|string|
|**Query**|**accessoryPrice**  <br>*可选*|string|
|**Query**|**accessorySpecifications**  <br>*可选*|string|
|**Query**|**accessoryUnit**  <br>*可选*|string|
|**Query**|**categoryId**  <br>*可选*|string|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonAccessory/listCommonAccessory
```


###### 请求 query
```
json :
{
  "accessoryBrand" : "string",
  "accessoryImport" : "string",
  "accessoryIndex" : "string",
  "accessoryLevel" : "string",
  "accessoryName" : "string",
  "accessoryPlaceOfOrigin" : "string",
  "accessoryPrice" : "string",
  "accessorySpecifications" : "string",
  "accessoryUnit" : "string",
  "categoryId" : "string",
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "remarks" : "string",
  "status" : "string",
  "status_in" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="uploadcommonaccessorybycategoryidusingpost"></a>
#### 上传配件信息
```
POST /common/commonAccessory/uploadCommonAccessoryByCategoryId
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**categoryId**  <br>*必填*|车型分类的id|string|
|**FormData**|**file**  <br>*必填*|上传的数据文件|ref|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `multipart/form-data`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonAccessory/uploadCommonAccessoryByCategoryId
```


###### 请求 query
```
json :
{
  "categoryId" : "string"
}
```


###### 请求 formData
```
json :
"ref"
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="common-assessment-controller_resource"></a>
### Common-assessment-controller
Common Assessment Controller


<a name="deletecommonassessmentusingpost"></a>
#### 删除考核
```
POST /common/commonAssessment/deleteCommonAssessment
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**json**  <br>*必填*|要删除的考核的json数据|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonAssessment/deleteCommonAssessment
```


###### 请求 query
```
json :
{
  "json" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="downloadstandardscoremodeusingpost"></a>
#### 下载带有学生新的评分表
```
POST /common/commonAssessment/downloadStandardScoreMode
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**id**  <br>*必填*|考核的id|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|无内容|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonAssessment/downloadStandardScoreMode
```


###### 请求 query
```
json :
{
  "id" : "string"
}
```


<a name="exportuploadmodeusingpost"></a>
#### 导出上传考生基本信息模板
```
POST /common/commonAssessment/exportUploadMode
```


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|无内容|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonAssessment/exportUploadMode
```


<a name="listassessmentusingpost"></a>
#### 加载考核的分页数据
```
POST /common/commonAssessment/listAssessment
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**assessmentName**  <br>*可选*|string|
|**Query**|**assessmentSchemeId**  <br>*可选*|string|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**dataStatus**  <br>*可选*|string|
|**Query**|**endDate**  <br>*可选*|string|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**schoolId**  <br>*可选*|string|
|**Query**|**schoolName**  <br>*可选*|string|
|**Query**|**startDate**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonAssessment/listAssessment
```


###### 请求 query
```
json :
{
  "assessmentName" : "string",
  "assessmentSchemeId" : "string",
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "dataStatus" : "string",
  "endDate" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "remarks" : "string",
  "schoolId" : "string",
  "schoolName" : "string",
  "startDate" : "string",
  "status" : "string",
  "status_in" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="loadassessmentnamelistusingpost_1"></a>
#### 根据登录人加载考核名称
```
POST /common/commonAssessment/loadAssessmentNameList
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**commonUserId**  <br>*必填*|用户id|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonAssessment/loadAssessmentNameList
```


###### 请求 query
```
json :
{
  "commonUserId" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="loadassessmentnamelistbysoftwareidusingpost"></a>
#### 根据登录人加载考核名称
```
POST /common/commonAssessment/loadAssessmentNameListBySoftwareId
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**commonUserId**  <br>*必填*|用户id|string|
|**Query**|**softwareId**  <br>*必填*|软件id|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonAssessment/loadAssessmentNameListBySoftwareId
```


###### 请求 query
```
json :
{
  "commonUserId" : "string",
  "softwareId" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="loadassessmentnamelistusingpost"></a>
#### 加载考核名称
```
POST /common/commonAssessment/loadAssessmentNameListWithCalc
```


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonAssessment/loadAssessmentNameListWithCalc
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="loadcommonassessmentusingpost"></a>
#### 根据id加载考核
```
POST /common/commonAssessment/loadCommonAssessment
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**id**  <br>*必填*|考核的id|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonAssessment/loadCommonAssessment
```


###### 请求 query
```
json :
{
  "id" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="savecommonassessmentusingpost"></a>
#### 保存、更新考核
```
POST /common/commonAssessment/saveCommonAssessment
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**assessmentName**  <br>*可选*||string|
|**Query**|**assessmentSchemeId**  <br>*可选*||string|
|**Query**|**createBy**  <br>*可选*||string|
|**Query**|**createByName**  <br>*可选*||string|
|**Query**|**createDate**  <br>*可选*||string (date-time)|
|**Query**|**createDate_between**  <br>*可选*||string|
|**Query**|**createDate_gte**  <br>*可选*||string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*||string (date-time)|
|**Query**|**dataStatus**  <br>*可选*||string|
|**Query**|**endDate**  <br>*可选*||string|
|**Query**|**id**  <br>*可选*||string|
|**Query**|**id_in**  <br>*可选*||< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*||boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*||integer (int64)|
|**Query**|**orderBy**  <br>*可选*||string|
|**Query**|**pageNo**  <br>*可选*||integer (int32)|
|**Query**|**pageSize**  <br>*可选*||integer (int32)|
|**Query**|**remarks**  <br>*可选*||string|
|**Query**|**schoolId**  <br>*可选*||string|
|**Query**|**schoolName**  <br>*可选*||string|
|**Query**|**startDate**  <br>*可选*||string|
|**Query**|**status**  <br>*可选*||string|
|**Query**|**status_in**  <br>*可选*||< string > array(multi)|
|**Query**|**updateBy**  <br>*可选*||string|
|**Query**|**updateByName**  <br>*可选*||string|
|**Query**|**updateDate**  <br>*可选*||string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*||string|
|**Query**|**updateDate_gte**  <br>*可选*||string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*||string (date-time)|
|**Query**|**userConfig**  <br>*必填*|前台发来的用户列表json数据|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonAssessment/saveCommonAssessment
```


###### 请求 query
```
json :
{
  "assessmentName" : "string",
  "assessmentSchemeId" : "string",
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "dataStatus" : "string",
  "endDate" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "remarks" : "string",
  "schoolId" : "string",
  "schoolName" : "string",
  "startDate" : "string",
  "status" : "string",
  "status_in" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string",
  "userConfig" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="updatecommonassessmentstatususingpost"></a>
#### 更新考核状态
```
POST /common/commonAssessment/updateCommonAssessmentStatus
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**assessmentName**  <br>*可选*||string|
|**Query**|**assessmentSchemeId**  <br>*可选*||string|
|**Query**|**createBy**  <br>*可选*||string|
|**Query**|**createByName**  <br>*可选*||string|
|**Query**|**createDate**  <br>*可选*||string (date-time)|
|**Query**|**createDate_between**  <br>*可选*||string|
|**Query**|**createDate_gte**  <br>*可选*||string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*||string (date-time)|
|**Query**|**dataStatus**  <br>*可选*||string|
|**Query**|**endDate**  <br>*可选*||string|
|**Query**|**id**  <br>*可选*||string|
|**Query**|**id_in**  <br>*可选*||< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*||boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*||integer (int64)|
|**Query**|**orderBy**  <br>*可选*||string|
|**Query**|**pageNo**  <br>*可选*||integer (int32)|
|**Query**|**pageSize**  <br>*可选*||integer (int32)|
|**Query**|**remarks**  <br>*可选*||string|
|**Query**|**schoolId**  <br>*可选*||string|
|**Query**|**schoolName**  <br>*可选*||string|
|**Query**|**startDate**  <br>*可选*||string|
|**Query**|**status**  <br>*可选*||string|
|**Query**|**status_in**  <br>*可选*||< string > array(multi)|
|**Query**|**updateBy**  <br>*可选*||string|
|**Query**|**updateByName**  <br>*可选*||string|
|**Query**|**updateDate**  <br>*可选*||string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*||string|
|**Query**|**updateDate_gte**  <br>*可选*||string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*||string (date-time)|
|**FormData**|**file**  <br>*可选*|上传的评分结果文件|ref|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `multipart/form-data`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonAssessment/updateCommonAssessmentStatus
```


###### 请求 query
```
json :
{
  "assessmentName" : "string",
  "assessmentSchemeId" : "string",
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "dataStatus" : "string",
  "endDate" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "remarks" : "string",
  "schoolId" : "string",
  "schoolName" : "string",
  "startDate" : "string",
  "status" : "string",
  "status_in" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string"
}
```


###### 请求 formData
```
json :
"ref"
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="uploadscoresusingpost"></a>
#### 上传客观评分
```
POST /common/commonAssessment/uploadScores
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**scoreInfo**  <br>*必填*|教师端上传来的分数json数据|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonAssessment/uploadScores
```


###### 请求 query
```
json :
{
  "scoreInfo" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="uploadscoresallusingpost"></a>
#### H5上传所有分数
```
POST /common/commonAssessment/uploadScoresAll
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**scoreInfo**  <br>*必填*|教师端上传来的分数json数据|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonAssessment/uploadScoresAll
```


###### 请求 query
```
json :
{
  "scoreInfo" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="common-assessment-scheme-controller_resource"></a>
### Common-assessment-scheme-controller
Common Assessment Scheme Controller


<a name="deletecommonassessmentusingpost_1"></a>
#### 删除考核方案
```
POST /common/commonAssessmentScheme/deleteCommonAssessmentScheme
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**json**  <br>*必填*|删除方案的json数据|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonAssessmentScheme/deleteCommonAssessmentScheme
```


###### 请求 query
```
json :
{
  "json" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="downloadschemetableusingpost"></a>
#### 下载评分表样例
```
POST /common/commonAssessmentScheme/downloadSchemeTable
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**id**  <br>*必填*|方案的id|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|无内容|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonAssessmentScheme/downloadSchemeTable
```


###### 请求 query
```
json :
{
  "id" : "string"
}
```


<a name="listcommonassessmentschemeusingpost"></a>
#### 加载分页考核方案数据
```
POST /common/commonAssessmentScheme/listCommonAssessmentScheme
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**basicSchemeId**  <br>*可选*|string|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**dataStatus**  <br>*可选*|string|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**needSinglePass**  <br>*可选*|string|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**passScore**  <br>*可选*|string|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**schemeDetails**  <br>*可选*|string|
|**Query**|**schemeName**  <br>*可选*|string|
|**Query**|**schemeTable**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonAssessmentScheme/listCommonAssessmentScheme
```


###### 请求 query
```
json :
{
  "basicSchemeId" : "string",
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "dataStatus" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "needSinglePass" : "string",
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "passScore" : "string",
  "remarks" : "string",
  "schemeDetails" : "string",
  "schemeName" : "string",
  "schemeTable" : "string",
  "status" : "string",
  "status_in" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="listcommonassessmentschemeonlyusingpost"></a>
#### 加载列表考核方案数据
```
POST /common/commonAssessmentScheme/listCommonAssessmentSchemeOnly
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**basicSchemeId**  <br>*可选*|string|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**dataStatus**  <br>*可选*|string|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**needSinglePass**  <br>*可选*|string|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**passScore**  <br>*可选*|string|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**schemeDetails**  <br>*可选*|string|
|**Query**|**schemeName**  <br>*可选*|string|
|**Query**|**schemeTable**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonAssessmentScheme/listCommonAssessmentSchemeOnly
```


###### 请求 query
```
json :
{
  "basicSchemeId" : "string",
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "dataStatus" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "needSinglePass" : "string",
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "passScore" : "string",
  "remarks" : "string",
  "schemeDetails" : "string",
  "schemeName" : "string",
  "schemeTable" : "string",
  "status" : "string",
  "status_in" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="loadcommonassessmentschemeusingpost"></a>
#### 根据id加载考核方案
```
POST /common/commonAssessmentScheme/loadCommonAssessmentScheme
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**id**  <br>*必填*|方案的id|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonAssessmentScheme/loadCommonAssessmentScheme
```


###### 请求 query
```
json :
{
  "id" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="savecommonassessmentusingpost_1"></a>
#### 保存、更新考核方案
```
POST /common/commonAssessmentScheme/saveCommonAssessmentScheme
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**basicSchemeId**  <br>*可选*|string|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**dataStatus**  <br>*可选*|string|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**needSinglePass**  <br>*可选*|string|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**passScore**  <br>*可选*|string|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**schemeDetails**  <br>*可选*|string|
|**Query**|**schemeName**  <br>*可选*|string|
|**Query**|**schemeTable**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonAssessmentScheme/saveCommonAssessmentScheme
```


###### 请求 query
```
json :
{
  "basicSchemeId" : "string",
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "dataStatus" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "needSinglePass" : "string",
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "passScore" : "string",
  "remarks" : "string",
  "schemeDetails" : "string",
  "schemeName" : "string",
  "schemeTable" : "string",
  "status" : "string",
  "status_in" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="updatecommonassessmentschemestatususingpost"></a>
#### 更新考核方案状态
```
POST /common/commonAssessmentScheme/updateCommonAssessmentSchemeStatus
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**basicSchemeId**  <br>*可选*|string|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**dataStatus**  <br>*可选*|string|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**needSinglePass**  <br>*可选*|string|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**passScore**  <br>*可选*|string|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**schemeDetails**  <br>*可选*|string|
|**Query**|**schemeName**  <br>*可选*|string|
|**Query**|**schemeTable**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonAssessmentScheme/updateCommonAssessmentSchemeStatus
```


###### 请求 query
```
json :
{
  "basicSchemeId" : "string",
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "dataStatus" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "needSinglePass" : "string",
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "passScore" : "string",
  "remarks" : "string",
  "schemeDetails" : "string",
  "schemeName" : "string",
  "schemeTable" : "string",
  "status" : "string",
  "status_in" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="uploadschemetableusingpost"></a>
#### 上传评分表样例
```
POST /common/commonAssessmentScheme/uploadSchemeTable
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**FormData**|**file**  <br>*必填*|评分样例文件|ref|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `multipart/form-data`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonAssessmentScheme/uploadSchemeTable
```


###### 请求 formData
```
json :
"ref"
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="common-assessment-stu-controller_resource"></a>
### Common-assessment-stu-controller
Common Assessment Stu Controller


<a name="exportstuscoreusingpost"></a>
#### 导出成绩excel
```
POST /common/commonAssessmentStu/exportStuScore
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**assessmentDate**  <br>*可选*|string|
|**Query**|**assessmentId**  <br>*可选*|string|
|**Query**|**assessmentName**  <br>*可选*|string|
|**Query**|**assessmentTime**  <br>*可选*|string|
|**Query**|**className**  <br>*可选*|string|
|**Query**|**commonUserId**  <br>*可选*|string|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**dataStatus**  <br>*可选*|string|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**loginName**  <br>*可选*|string|
|**Query**|**majorName**  <br>*可选*|string|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**schoolId**  <br>*可选*|string|
|**Query**|**schoolName**  <br>*可选*|string|
|**Query**|**scoreDetails**  <br>*可选*|string|
|**Query**|**searchDate**  <br>*可选*|string|
|**Query**|**softUploadedMarks**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**totalScore**  <br>*可选*|string|
|**Query**|**trueName**  <br>*可选*|string|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|无内容|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonAssessmentStu/exportStuScore
```


###### 请求 query
```
json :
{
  "assessmentDate" : "string",
  "assessmentId" : "string",
  "assessmentName" : "string",
  "assessmentTime" : "string",
  "className" : "string",
  "commonUserId" : "string",
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "dataStatus" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "loginName" : "string",
  "majorName" : "string",
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "remarks" : "string",
  "schoolId" : "string",
  "schoolName" : "string",
  "scoreDetails" : "string",
  "searchDate" : "string",
  "softUploadedMarks" : "string",
  "status" : "string",
  "status_in" : "string",
  "totalScore" : "string",
  "trueName" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string"
}
```


<a name="loadassessmentdatelistusingpost"></a>
#### 根据登录人加载考核名称下的考核日期
```
POST /common/commonAssessmentStu/loadAssessmentDateList
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**assessmentName**  <br>*必填*|考核名称|string|
|**Query**|**commonUserId**  <br>*必填*|用户id|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonAssessmentStu/loadAssessmentDateList
```


###### 请求 query
```
json :
{
  "assessmentName" : "string",
  "commonUserId" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="loadassessmenttimelistusingpost"></a>
#### 根据登录人加载考核名称下的考核日期下的考核时间
```
POST /common/commonAssessmentStu/loadAssessmentTimeList
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**assessmentDate**  <br>*必填*|考核日期|string|
|**Query**|**assessmentName**  <br>*必填*|考核名称|string|
|**Query**|**commonUserId**  <br>*必填*|用户id|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonAssessmentStu/loadAssessmentTimeList
```


###### 请求 query
```
json :
{
  "assessmentDate" : "string",
  "assessmentName" : "string",
  "commonUserId" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="loadoneexamstuusingpost"></a>
#### 根据id返回一个考生对象
```
POST /common/commonAssessmentStu/loadOneExamStu
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**serverExamStuId**  <br>*必填*|一个考生的id|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonAssessmentStu/loadOneExamStu
```


###### 请求 query
```
json :
{
  "serverExamStuId" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="searchstuscoreusingpost"></a>
#### 加载分页考生数据
```
POST /common/commonAssessmentStu/searchStuScore
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**assessmentDate**  <br>*可选*|string|
|**Query**|**assessmentId**  <br>*可选*|string|
|**Query**|**assessmentName**  <br>*可选*|string|
|**Query**|**assessmentTime**  <br>*可选*|string|
|**Query**|**className**  <br>*可选*|string|
|**Query**|**commonUserId**  <br>*可选*|string|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**dataStatus**  <br>*可选*|string|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**loginName**  <br>*可选*|string|
|**Query**|**majorName**  <br>*可选*|string|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**schoolId**  <br>*可选*|string|
|**Query**|**schoolName**  <br>*可选*|string|
|**Query**|**scoreDetails**  <br>*可选*|string|
|**Query**|**searchDate**  <br>*可选*|string|
|**Query**|**softUploadedMarks**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**totalScore**  <br>*可选*|string|
|**Query**|**trueName**  <br>*可选*|string|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonAssessmentStu/searchStuScore
```


###### 请求 query
```
json :
{
  "assessmentDate" : "string",
  "assessmentId" : "string",
  "assessmentName" : "string",
  "assessmentTime" : "string",
  "className" : "string",
  "commonUserId" : "string",
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "dataStatus" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "loginName" : "string",
  "majorName" : "string",
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "remarks" : "string",
  "schoolId" : "string",
  "schoolName" : "string",
  "scoreDetails" : "string",
  "searchDate" : "string",
  "softUploadedMarks" : "string",
  "status" : "string",
  "status_in" : "string",
  "totalScore" : "string",
  "trueName" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="common-basic-scheme-controller_resource"></a>
### Common-basic-scheme-controller
Common Basic Scheme Controller


<a name="deletecommonbasicschemeusingpost"></a>
#### 删除基本方案
```
POST /common/commonBasicScheme/deleteCommonBasicScheme
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**basicDetail**  <br>*可选*|string|
|**Query**|**basicName**  <br>*可选*|string|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonBasicScheme/deleteCommonBasicScheme
```


###### 请求 query
```
json :
{
  "basicDetail" : "string",
  "basicName" : "string",
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "remarks" : "string",
  "status" : "string",
  "status_in" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="deletecommonbasicschemebyidusingpost"></a>
#### 根据id删除基本方案
```
POST /common/commonBasicScheme/deleteCommonBasicSchemeById
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**id**  <br>*必填*|要被删除的基本发囊的id|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonBasicScheme/deleteCommonBasicSchemeById
```


###### 请求 query
```
json :
{
  "id" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="deletecommonbasicschemebyjsonusingpost"></a>
#### 根据json信息删除
```
POST /common/commonBasicScheme/deleteCommonBasicSchemeByJson
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**json**  <br>*必填*|要删除基本方案的json数据|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonBasicScheme/deleteCommonBasicSchemeByJson
```


###### 请求 query
```
json :
{
  "json" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="listcommonbasicschemeusingpost"></a>
#### 加载分页基本方案
```
POST /common/commonBasicScheme/listCommonBasicScheme
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**basicDetail**  <br>*可选*|string|
|**Query**|**basicName**  <br>*可选*|string|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonBasicScheme/listCommonBasicScheme
```


###### 请求 query
```
json :
{
  "basicDetail" : "string",
  "basicName" : "string",
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "remarks" : "string",
  "status" : "string",
  "status_in" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="listcommonbasicschemeonlyusingpost"></a>
#### 加载列表基本方案
```
POST /common/commonBasicScheme/listCommonBasicSchemeOnly
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**basicDetail**  <br>*可选*|string|
|**Query**|**basicName**  <br>*可选*|string|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonBasicScheme/listCommonBasicSchemeOnly
```


###### 请求 query
```
json :
{
  "basicDetail" : "string",
  "basicName" : "string",
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "remarks" : "string",
  "status" : "string",
  "status_in" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="loadcommonbasicschemeusingpost"></a>
#### 根据id加载基本方案
```
POST /common/commonBasicScheme/loadCommonBasicScheme
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**id**  <br>*必填*|基本方案的id|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonBasicScheme/loadCommonBasicScheme
```


###### 请求 query
```
json :
{
  "id" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="savecommonbasicschemeusingpost"></a>
#### 保存、更新基本方案
```
POST /common/commonBasicScheme/saveCommonBasicScheme
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**basicDetail**  <br>*可选*|string|
|**Query**|**basicName**  <br>*可选*|string|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonBasicScheme/saveCommonBasicScheme
```


###### 请求 query
```
json :
{
  "basicDetail" : "string",
  "basicName" : "string",
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "remarks" : "string",
  "status" : "string",
  "status_in" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="updatestatususingpost"></a>
#### 更新基本方案状态
```
POST /common/commonBasicScheme/updateStatus
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**basicDetail**  <br>*可选*|string|
|**Query**|**basicName**  <br>*可选*|string|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonBasicScheme/updateStatus
```


###### 请求 query
```
json :
{
  "basicDetail" : "string",
  "basicName" : "string",
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "remarks" : "string",
  "status" : "string",
  "status_in" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="common-log-controller_resource"></a>
### Common-log-controller
Common Log Controller


<a name="listlogusingpost"></a>
#### 查询日志
```
POST /common/commonLog/listLog
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**description**  <br>*可选*|string|
|**Query**|**exceptionCode**  <br>*可选*|string|
|**Query**|**exceptionDetail**  <br>*可选*|string|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**method**  <br>*可选*|string|
|**Query**|**operationType**  <br>*可选*|string|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**params**  <br>*可选*|string|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**requestIp**  <br>*可选*|string|
|**Query**|**schoolName**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**trueName**  <br>*可选*|string|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**updateTime**  <br>*可选*|string (date-time)|
|**Query**|**userName**  <br>*可选*|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonLog/listLog
```


###### 请求 query
```
json :
{
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "description" : "string",
  "exceptionCode" : "string",
  "exceptionDetail" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "method" : "string",
  "operationType" : "string",
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "params" : "string",
  "remarks" : "string",
  "requestIp" : "string",
  "schoolName" : "string",
  "status" : "string",
  "status_in" : "string",
  "trueName" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string",
  "updateTime" : "string",
  "userName" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="common-school-controller_resource"></a>
### Common-school-controller
Common School Controller


<a name="deletecommonassessmentusingpost_2"></a>
#### 删除学校
```
POST /common/commonSchool/deleteCommonSchool
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**schoolName**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonSchool/deleteCommonSchool
```


###### 请求 query
```
json :
{
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "remarks" : "string",
  "schoolName" : "string",
  "status" : "string",
  "status_in" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="listschoolusingpost"></a>
#### 加载分页学校数据
```
POST /common/commonSchool/listSchool
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**schoolName**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonSchool/listSchool
```


###### 请求 query
```
json :
{
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "remarks" : "string",
  "schoolName" : "string",
  "status" : "string",
  "status_in" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="listschoolonlyusingpost"></a>
#### 加载列表学校数据
```
POST /common/commonSchool/listSchoolOnly
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**schoolName**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonSchool/listSchoolOnly
```


###### 请求 query
```
json :
{
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "remarks" : "string",
  "schoolName" : "string",
  "status" : "string",
  "status_in" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="loadcommonschoolusingpost"></a>
#### 根据id加载学校
```
POST /common/commonSchool/loadCommonSchool
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**id**  <br>*必填*|学校的id|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonSchool/loadCommonSchool
```


###### 请求 query
```
json :
{
  "id" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="savecommonschoolusingpost"></a>
#### 保存、更新学校
```
POST /common/commonSchool/saveCommonSchool
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**schoolName**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonSchool/saveCommonSchool
```


###### 请求 query
```
json :
{
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "remarks" : "string",
  "schoolName" : "string",
  "status" : "string",
  "status_in" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="common-software-controller_resource"></a>
### Common-software-controller
Common Software Controller


<a name="listcommonsoftwareonlyusingpost"></a>
#### 加载软件列表数据
```
POST /common/commonSoftware/listCommonSoftwareOnly
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**softwareDesc**  <br>*可选*|string|
|**Query**|**softwareName**  <br>*可选*|string|
|**Query**|**softwareTypeId**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonSoftware/listCommonSoftwareOnly
```


###### 请求 query
```
json :
{
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "remarks" : "string",
  "softwareDesc" : "string",
  "softwareName" : "string",
  "softwareTypeId" : "string",
  "status" : "string",
  "status_in" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="common-user-controller_resource"></a>
### Common-user-controller
Common User Controller


<a name="adduserusingpost"></a>
#### 保存用户信息
```
POST /common/commonUser/addUser
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**className**  <br>*可选*|string|
|**Query**|**commonAssessmentStuId**  <br>*可选*|string|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**gender**  <br>*可选*|string|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isExamRight**  <br>*可选*|string|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**majorName**  <br>*可选*|string|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**password**  <br>*可选*|string|
|**Query**|**phoneNum**  <br>*可选*|string|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**roleArray**  <br>*可选*|string|
|**Query**|**roleId**  <br>*可选*|string|
|**Query**|**schoolId**  <br>*可选*|string|
|**Query**|**schoolName**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**token**  <br>*可选*|string|
|**Query**|**trueName**  <br>*可选*|string|
|**Query**|**type**  <br>*可选*|string|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**userName**  <br>*可选*|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonUser/addUser
```


###### 请求 query
```
json :
{
  "className" : "string",
  "commonAssessmentStuId" : "string",
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "gender" : "string",
  "id" : "string",
  "id_in" : "string",
  "isExamRight" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "majorName" : "string",
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "password" : "string",
  "phoneNum" : "string",
  "remarks" : "string",
  "roleArray" : "string",
  "roleId" : "string",
  "schoolId" : "string",
  "schoolName" : "string",
  "status" : "string",
  "status_in" : "string",
  "token" : "string",
  "trueName" : "string",
  "type" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string",
  "userName" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="changepasswordusingpost"></a>
#### 修改密码
```
POST /common/commonUser/changePassword
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**newPassword**  <br>*必填*|新密码|string|
|**Query**|**oldPassword**  <br>*必填*|旧密码|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonUser/changePassword
```


###### 请求 query
```
json :
{
  "newPassword" : "string",
  "oldPassword" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="changerightusingpost"></a>
#### 更改考试权限
```
POST /common/commonUser/changeRight
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**id**  <br>*必填*|用户的id|string|
|**Query**|**isExamRight**  <br>*必填*|考核权限的标志位0是没有1是有|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonUser/changeRight
```


###### 请求 query
```
json :
{
  "id" : "string",
  "isExamRight" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="commonuserdemoexportusingpost"></a>
#### 导出用户模板
```
POST /common/commonUser/commonUserDemoExport
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**roleId**  <br>*可选*|roleId|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|无内容|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonUser/commonUserDemoExport
```


###### 请求 query
```
json :
{
  "roleId" : "string"
}
```


<a name="deleteuserusingpost"></a>
#### 根据json删除用户
```
POST /common/commonUser/deleteUser
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**json**  <br>*必填*|删除信息的json数据|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonUser/deleteUser
```


###### 请求 query
```
json :
{
  "json" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="hellousingpost"></a>
#### 检测方法
```
POST /common/commonUser/hello
```


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonUser/hello
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="importusersusingpost"></a>
#### 导入用户
```
POST /common/commonUser/importUsers
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**roleId**  <br>*必填*|角色标识|string|
|**FormData**|**file**  <br>*必填*|导入用户的excel文件|ref|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `multipart/form-data`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonUser/importUsers
```


###### 请求 query
```
json :
{
  "roleId" : "string"
}
```


###### 请求 formData
```
json :
"ref"
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="listcommonuserusingpost"></a>
#### 加载分页用户信息
```
POST /common/commonUser/listCommonUser
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**className**  <br>*可选*|string|
|**Query**|**commonAssessmentStuId**  <br>*可选*|string|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**gender**  <br>*可选*|string|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isExamRight**  <br>*可选*|string|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**majorName**  <br>*可选*|string|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**password**  <br>*可选*|string|
|**Query**|**phoneNum**  <br>*可选*|string|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**roleArray**  <br>*可选*|string|
|**Query**|**roleId**  <br>*可选*|string|
|**Query**|**schoolId**  <br>*可选*|string|
|**Query**|**schoolName**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**token**  <br>*可选*|string|
|**Query**|**trueName**  <br>*可选*|string|
|**Query**|**type**  <br>*可选*|string|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**userName**  <br>*可选*|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonUser/listCommonUser
```


###### 请求 query
```
json :
{
  "className" : "string",
  "commonAssessmentStuId" : "string",
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "gender" : "string",
  "id" : "string",
  "id_in" : "string",
  "isExamRight" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "majorName" : "string",
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "password" : "string",
  "phoneNum" : "string",
  "remarks" : "string",
  "roleArray" : "string",
  "roleId" : "string",
  "schoolId" : "string",
  "schoolName" : "string",
  "status" : "string",
  "status_in" : "string",
  "token" : "string",
  "trueName" : "string",
  "type" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string",
  "userName" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="listdatausingpost_18"></a>
#### listData
```
POST /common/commonUser/listData
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**className**  <br>*可选*|string|
|**Query**|**commonAssessmentStuId**  <br>*可选*|string|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**gender**  <br>*可选*|string|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isExamRight**  <br>*可选*|string|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**majorName**  <br>*可选*|string|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**password**  <br>*可选*|string|
|**Query**|**phoneNum**  <br>*可选*|string|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**roleArray**  <br>*可选*|string|
|**Query**|**roleId**  <br>*可选*|string|
|**Query**|**schoolId**  <br>*可选*|string|
|**Query**|**schoolName**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**token**  <br>*可选*|string|
|**Query**|**trueName**  <br>*可选*|string|
|**Query**|**type**  <br>*可选*|string|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**userName**  <br>*可选*|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[Page«CommonUser»](#fc683d86e37d0e5c0ebf7ecdbcdfd9e9)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonUser/listData
```


###### 请求 query
```
json :
{
  "className" : "string",
  "commonAssessmentStuId" : "string",
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "gender" : "string",
  "id" : "string",
  "id_in" : "string",
  "isExamRight" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "majorName" : "string",
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "password" : "string",
  "phoneNum" : "string",
  "remarks" : "string",
  "roleArray" : "string",
  "roleId" : "string",
  "schoolId" : "string",
  "schoolName" : "string",
  "status" : "string",
  "status_in" : "string",
  "token" : "string",
  "trueName" : "string",
  "type" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string",
  "userName" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "count" : 0,
  "list" : [ {
    "className" : "string",
    "commonAssessmentStuId" : "string",
    "createBy" : "string",
    "createByName" : "string",
    "createDate" : "string",
    "createDate_between" : "string",
    "createDate_gte" : "string",
    "createDate_lte" : "string",
    "gender" : "string",
    "id" : "string",
    "id_in" : [ "string" ],
    "isExamRight" : "string",
    "isNewRecord" : true,
    "lastUpdateDateTime" : 0,
    "majorName" : "string",
    "orderBy" : "string",
    "pageNo" : 0,
    "pageSize" : 0,
    "password" : "string",
    "phoneNum" : "string",
    "remarks" : "string",
    "roleArray" : "string",
    "roleId" : "string",
    "schoolId" : "string",
    "schoolName" : "string",
    "status" : "string",
    "status_in" : [ "string" ],
    "token" : "string",
    "trueName" : "string",
    "type" : "string",
    "updateBy" : "string",
    "updateByName" : "string",
    "updateDate" : "string",
    "updateDate_between" : "string",
    "updateDate_gte" : "string",
    "updateDate_lte" : "string",
    "userName" : "string"
  } ],
  "otherData" : "object",
  "pageNo" : 0,
  "pageSize" : 0
}
```


<a name="loadclasslistusingpost"></a>
#### 加载班级列表
```
POST /common/commonUser/loadClassList
```


##### 说明
根据登录的id夹杂对应学校的专业列表


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**commonUserId**  <br>*必填*|登录的用户id|string|
|**Query**|**majorName**  <br>*可选*|专业个名称|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult«List«string»»](#88292ec8d20348f5849ceda64b4b1d0b)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonUser/loadClassList
```


###### 请求 query
```
json :
{
  "commonUserId" : "string",
  "majorName" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : [ "string" ],
  "msg" : "string"
}
```


<a name="loadcommonuserusingpost"></a>
#### 根据id加载用户
```
POST /common/commonUser/loadCommonUser
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**id**  <br>*必填*|用户id|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonUser/loadCommonUser
```


###### 请求 query
```
json :
{
  "id" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="loadmajorlistusingpost"></a>
#### 加载专业列表
```
POST /common/commonUser/loadMajorList
```


##### 说明
根据登录的id夹杂对应学校的专业列表


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**commonUserId**  <br>*必填*|登录的用户id|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult«List«string»»](#88292ec8d20348f5849ceda64b4b1d0b)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonUser/loadMajorList
```


###### 请求 query
```
json :
{
  "commonUserId" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : [ "string" ],
  "msg" : "string"
}
```


<a name="loadoneuserusingpost"></a>
#### 根据id返回用户对象
```
POST /common/commonUser/loadOneUser
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**commonUserId**  <br>*必填*|用户id|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult«CommonUser»](#08c674bdd020f091601eefe307bf3944)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonUser/loadOneUser
```


###### 请求 query
```
json :
{
  "commonUserId" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : {
    "className" : "string",
    "commonAssessmentStuId" : "string",
    "createBy" : "string",
    "createByName" : "string",
    "createDate" : "string",
    "createDate_between" : "string",
    "createDate_gte" : "string",
    "createDate_lte" : "string",
    "gender" : "string",
    "id" : "string",
    "id_in" : [ "string" ],
    "isExamRight" : "string",
    "isNewRecord" : true,
    "lastUpdateDateTime" : 0,
    "majorName" : "string",
    "orderBy" : "string",
    "pageNo" : 0,
    "pageSize" : 0,
    "password" : "string",
    "phoneNum" : "string",
    "remarks" : "string",
    "roleArray" : "string",
    "roleId" : "string",
    "schoolId" : "string",
    "schoolName" : "string",
    "status" : "string",
    "status_in" : [ "string" ],
    "token" : "string",
    "trueName" : "string",
    "type" : "string",
    "updateBy" : "string",
    "updateByName" : "string",
    "updateDate" : "string",
    "updateDate_between" : "string",
    "updateDate_gte" : "string",
    "updateDate_lte" : "string",
    "userName" : "string"
  },
  "msg" : "string"
}
```


<a name="loadstulistandotherbyexamuseridsusingpost"></a>
#### 根据服务器考生和其他信息加载学生信息
```
POST /common/commonUser/loadStuListAndOtherByExamUserIds
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**examUserIds**  <br>*必填*|以逗号分隔的多个服务器考生id|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult«ExamUserListAndOtherInfoVO»](#f0636d91bfa680c920a4dac808e45068)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonUser/loadStuListAndOtherByExamUserIds
```


###### 请求 query
```
json :
{
  "examUserIds" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : {
    "assessmentDate" : "string",
    "assessmentDateList" : [ "string" ],
    "assessmentName" : "string",
    "assessmentNameList" : [ "string" ],
    "assessmentTime" : "string",
    "assessmentTimeList" : [ "string" ],
    "clsName" : "string",
    "clsNameList" : [ "string" ],
    "list" : [ {
      "className" : "string",
      "commonAssessmentStuId" : "string",
      "createBy" : "string",
      "createByName" : "string",
      "createDate" : "string",
      "createDate_between" : "string",
      "createDate_gte" : "string",
      "createDate_lte" : "string",
      "gender" : "string",
      "id" : "string",
      "id_in" : [ "string" ],
      "isExamRight" : "string",
      "isNewRecord" : true,
      "lastUpdateDateTime" : 0,
      "majorName" : "string",
      "orderBy" : "string",
      "pageNo" : 0,
      "pageSize" : 0,
      "password" : "string",
      "phoneNum" : "string",
      "remarks" : "string",
      "roleArray" : "string",
      "roleId" : "string",
      "schoolId" : "string",
      "schoolName" : "string",
      "status" : "string",
      "status_in" : [ "string" ],
      "token" : "string",
      "trueName" : "string",
      "type" : "string",
      "updateBy" : "string",
      "updateByName" : "string",
      "updateDate" : "string",
      "updateDate_between" : "string",
      "updateDate_gte" : "string",
      "updateDate_lte" : "string",
      "userName" : "string"
    } ],
    "majorName" : "string",
    "majorNameList" : [ "string" ]
  },
  "msg" : "string"
}
```


<a name="loadstulistandotherbyuseridsusingpost"></a>
#### 根据多个id加载学生信息
```
POST /common/commonUser/loadStuListAndOtherByUserIds
```


##### 说明
ids 的样式是 1,2,3,4


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**ids**  <br>*必填*|用的id的以英文逗号组合字符串|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult«ExamUserListAndOtherInfoVO»](#f0636d91bfa680c920a4dac808e45068)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonUser/loadStuListAndOtherByUserIds
```


###### 请求 query
```
json :
{
  "ids" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : {
    "assessmentDate" : "string",
    "assessmentDateList" : [ "string" ],
    "assessmentName" : "string",
    "assessmentNameList" : [ "string" ],
    "assessmentTime" : "string",
    "assessmentTimeList" : [ "string" ],
    "clsName" : "string",
    "clsNameList" : [ "string" ],
    "list" : [ {
      "className" : "string",
      "commonAssessmentStuId" : "string",
      "createBy" : "string",
      "createByName" : "string",
      "createDate" : "string",
      "createDate_between" : "string",
      "createDate_gte" : "string",
      "createDate_lte" : "string",
      "gender" : "string",
      "id" : "string",
      "id_in" : [ "string" ],
      "isExamRight" : "string",
      "isNewRecord" : true,
      "lastUpdateDateTime" : 0,
      "majorName" : "string",
      "orderBy" : "string",
      "pageNo" : 0,
      "pageSize" : 0,
      "password" : "string",
      "phoneNum" : "string",
      "remarks" : "string",
      "roleArray" : "string",
      "roleId" : "string",
      "schoolId" : "string",
      "schoolName" : "string",
      "status" : "string",
      "status_in" : [ "string" ],
      "token" : "string",
      "trueName" : "string",
      "type" : "string",
      "updateBy" : "string",
      "updateByName" : "string",
      "updateDate" : "string",
      "updateDate_between" : "string",
      "updateDate_gte" : "string",
      "updateDate_lte" : "string",
      "userName" : "string"
    } ],
    "majorName" : "string",
    "majorNameList" : [ "string" ]
  },
  "msg" : "string"
}
```


<a name="loadstulistbyexamuseridsusingpost"></a>
#### 根据服务器考生信息加载学生信息
```
POST /common/commonUser/loadStuListByExamUserIds
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**examUserIds**  <br>*必填*|以逗号分隔的多个服务器考生id|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult«List«CommonUser»»](#72ddcea55610fef5e9c0ed66247d7df2)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonUser/loadStuListByExamUserIds
```


###### 请求 query
```
json :
{
  "examUserIds" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : [ {
    "className" : "string",
    "commonAssessmentStuId" : "string",
    "createBy" : "string",
    "createByName" : "string",
    "createDate" : "string",
    "createDate_between" : "string",
    "createDate_gte" : "string",
    "createDate_lte" : "string",
    "gender" : "string",
    "id" : "string",
    "id_in" : [ "string" ],
    "isExamRight" : "string",
    "isNewRecord" : true,
    "lastUpdateDateTime" : 0,
    "majorName" : "string",
    "orderBy" : "string",
    "pageNo" : 0,
    "pageSize" : 0,
    "password" : "string",
    "phoneNum" : "string",
    "remarks" : "string",
    "roleArray" : "string",
    "roleId" : "string",
    "schoolId" : "string",
    "schoolName" : "string",
    "status" : "string",
    "status_in" : [ "string" ],
    "token" : "string",
    "trueName" : "string",
    "type" : "string",
    "updateBy" : "string",
    "updateByName" : "string",
    "updateDate" : "string",
    "updateDate_between" : "string",
    "updateDate_gte" : "string",
    "updateDate_lte" : "string",
    "userName" : "string"
  } ],
  "msg" : "string"
}
```


<a name="loadstulistbyidstrusingpost"></a>
#### 根据上传的excel中的身份证数据加载学生信息
```
POST /common/commonUser/loadStuListByIDstr
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**FormData**|**file**  <br>*必填*|上传的excel文件|ref|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult«JSONObject»](#7eeb81d7f6a904b10acc8c8c8b8b1d28)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `multipart/form-data`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonUser/loadStuListByIDstr
```


###### 请求 formData
```
json :
"ref"
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : {
    "string" : "object"
  },
  "msg" : "string"
}
```


<a name="loadstulistbyidsusingpost"></a>
#### 根据多个id加载学生信息
```
POST /common/commonUser/loadStuListByIds
```


##### 说明
ids 的样式是 1,2,3,4


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**ids**  <br>*必填*|用的id的以英文逗号组合字符串|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult«List«CommonUser»»](#72ddcea55610fef5e9c0ed66247d7df2)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonUser/loadStuListByIds
```


###### 请求 query
```
json :
{
  "ids" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : [ {
    "className" : "string",
    "commonAssessmentStuId" : "string",
    "createBy" : "string",
    "createByName" : "string",
    "createDate" : "string",
    "createDate_between" : "string",
    "createDate_gte" : "string",
    "createDate_lte" : "string",
    "gender" : "string",
    "id" : "string",
    "id_in" : [ "string" ],
    "isExamRight" : "string",
    "isNewRecord" : true,
    "lastUpdateDateTime" : 0,
    "majorName" : "string",
    "orderBy" : "string",
    "pageNo" : 0,
    "pageSize" : 0,
    "password" : "string",
    "phoneNum" : "string",
    "remarks" : "string",
    "roleArray" : "string",
    "roleId" : "string",
    "schoolId" : "string",
    "schoolName" : "string",
    "status" : "string",
    "status_in" : [ "string" ],
    "token" : "string",
    "trueName" : "string",
    "type" : "string",
    "updateBy" : "string",
    "updateByName" : "string",
    "updateDate" : "string",
    "updateDate_between" : "string",
    "updateDate_gte" : "string",
    "updateDate_lte" : "string",
    "userName" : "string"
  } ],
  "msg" : "string"
}
```


<a name="loadstulistinplatformusingpost"></a>
#### 加载平台中的学生
```
POST /common/commonUser/loadStuListInPlatform
```


##### 说明
根据查询对象里的数据进行加载


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**assessmentDate**  <br>*可选*|string|
|**Query**|**assessmentId**  <br>*可选*|string|
|**Query**|**assessmentName**  <br>*可选*|string|
|**Query**|**assessmentTime**  <br>*可选*|string|
|**Query**|**className**  <br>*可选*|string|
|**Query**|**commonUserId**  <br>*可选*|string|
|**Query**|**examOrPractice**  <br>*可选*|string|
|**Query**|**majorName**  <br>*可选*|string|
|**Query**|**schoolId**  <br>*可选*|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult«List«CommonUser»»](#72ddcea55610fef5e9c0ed66247d7df2)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonUser/loadStuListInPlatform
```


###### 请求 query
```
json :
{
  "assessmentDate" : "string",
  "assessmentId" : "string",
  "assessmentName" : "string",
  "assessmentTime" : "string",
  "className" : "string",
  "commonUserId" : "string",
  "examOrPractice" : "string",
  "majorName" : "string",
  "schoolId" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : [ {
    "className" : "string",
    "commonAssessmentStuId" : "string",
    "createBy" : "string",
    "createByName" : "string",
    "createDate" : "string",
    "createDate_between" : "string",
    "createDate_gte" : "string",
    "createDate_lte" : "string",
    "gender" : "string",
    "id" : "string",
    "id_in" : [ "string" ],
    "isExamRight" : "string",
    "isNewRecord" : true,
    "lastUpdateDateTime" : 0,
    "majorName" : "string",
    "orderBy" : "string",
    "pageNo" : 0,
    "pageSize" : 0,
    "password" : "string",
    "phoneNum" : "string",
    "remarks" : "string",
    "roleArray" : "string",
    "roleId" : "string",
    "schoolId" : "string",
    "schoolName" : "string",
    "status" : "string",
    "status_in" : [ "string" ],
    "token" : "string",
    "trueName" : "string",
    "type" : "string",
    "updateBy" : "string",
    "updateByName" : "string",
    "updateDate" : "string",
    "updateDate_between" : "string",
    "updateDate_gte" : "string",
    "updateDate_lte" : "string",
    "userName" : "string"
  } ],
  "msg" : "string"
}
```


<a name="loaduserbytokenusingpost"></a>
#### 根据token加载用户信息
```
POST /common/commonUser/loadUserByToken
```


##### 说明
在token解析出用户id，再记载数据后返回


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonUser/loadUserByToken
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="loginusingpost"></a>
#### 大后台前端登录
```
POST /common/commonUser/login
```


##### 说明
根据用户名和密码来判断是否登录


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**flag**  <br>*可选*||integer (int32)|
|**Query**|**password**  <br>*必填*|密码|string|
|**Query**|**userName**  <br>*必填*|用户名|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonUser/login
```


###### 请求 query
```
json :
{
  "flag" : 0,
  "password" : "string",
  "userName" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="logoutusingpost"></a>
#### 大后台前端注销
```
POST /common/commonUser/logout
```


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonUser/logout
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="resetpassusingpost"></a>
#### 根据id重置密码
```
POST /common/commonUser/resetPass
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**id**  <br>*必填*|用户的id|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonUser/resetPass
```


###### 请求 query
```
json :
{
  "id" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="saveusingpost_15"></a>
#### 保存用户信息
```
POST /common/commonUser/save
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**className**  <br>*可选*|string|
|**Query**|**commonAssessmentStuId**  <br>*可选*|string|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**gender**  <br>*可选*|string|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isExamRight**  <br>*可选*|string|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**majorName**  <br>*可选*|string|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**password**  <br>*可选*|string|
|**Query**|**phoneNum**  <br>*可选*|string|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**roleArray**  <br>*可选*|string|
|**Query**|**roleId**  <br>*可选*|string|
|**Query**|**schoolId**  <br>*可选*|string|
|**Query**|**schoolName**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**token**  <br>*可选*|string|
|**Query**|**trueName**  <br>*可选*|string|
|**Query**|**type**  <br>*可选*|string|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**userName**  <br>*可选*|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonUser/save
```


###### 请求 query
```
json :
{
  "className" : "string",
  "commonAssessmentStuId" : "string",
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "gender" : "string",
  "id" : "string",
  "id_in" : "string",
  "isExamRight" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "majorName" : "string",
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "password" : "string",
  "phoneNum" : "string",
  "remarks" : "string",
  "roleArray" : "string",
  "roleId" : "string",
  "schoolId" : "string",
  "schoolName" : "string",
  "status" : "string",
  "status_in" : "string",
  "token" : "string",
  "trueName" : "string",
  "type" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string",
  "userName" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="teachersideloginusingpost"></a>
#### 教师端登录
```
POST /common/commonUser/teacherSideLogin
```


##### 说明
根据用户名和密码来判断是否登录


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**flag**  <br>*可选*||integer (int32)|
|**Query**|**password**  <br>*必填*|密码|string|
|**Query**|**userName**  <br>*必填*|用户名|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult«CommonUser»](#08c674bdd020f091601eefe307bf3944)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonUser/teacherSideLogin
```


###### 请求 query
```
json :
{
  "flag" : 0,
  "password" : "string",
  "userName" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : {
    "className" : "string",
    "commonAssessmentStuId" : "string",
    "createBy" : "string",
    "createByName" : "string",
    "createDate" : "string",
    "createDate_between" : "string",
    "createDate_gte" : "string",
    "createDate_lte" : "string",
    "gender" : "string",
    "id" : "string",
    "id_in" : [ "string" ],
    "isExamRight" : "string",
    "isNewRecord" : true,
    "lastUpdateDateTime" : 0,
    "majorName" : "string",
    "orderBy" : "string",
    "pageNo" : 0,
    "pageSize" : 0,
    "password" : "string",
    "phoneNum" : "string",
    "remarks" : "string",
    "roleArray" : "string",
    "roleId" : "string",
    "schoolId" : "string",
    "schoolName" : "string",
    "status" : "string",
    "status_in" : [ "string" ],
    "token" : "string",
    "trueName" : "string",
    "type" : "string",
    "updateBy" : "string",
    "updateByName" : "string",
    "updateDate" : "string",
    "updateDate_between" : "string",
    "updateDate_gte" : "string",
    "updateDate_lte" : "string",
    "userName" : "string"
  },
  "msg" : "string"
}
```


<a name="tokenexpiredusingpost"></a>
#### token过期的跳转接口
```
POST /common/commonUser/tokenExpired
```


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonUser/tokenExpired
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="unloginusingpost"></a>
#### 未登录的跳转接口
```
POST /common/commonUser/unLogin
```


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonUser/unLogin
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="common-vehicle-image-controller_resource"></a>
### Common-vehicle-image-controller
Common Vehicle Image Controller


<a name="deletevehicleimageusingpost"></a>
#### 删除图片
```
POST /common/commonVehicleImage/deleteVehicleImage
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**imageName**  <br>*可选*|string|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**vehicleId**  <br>*可选*|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonVehicleImage/deleteVehicleImage
```


###### 请求 query
```
json :
{
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "id" : "string",
  "id_in" : "string",
  "imageName" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "remarks" : "string",
  "status" : "string",
  "status_in" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string",
  "vehicleId" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="updatevehicleimageusingpost"></a>
#### 替换车的某一个体图片
```
POST /common/commonVehicleImage/updateVehicleImage
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**createBy**  <br>*可选*||string|
|**Query**|**createByName**  <br>*可选*||string|
|**Query**|**createDate**  <br>*可选*||string (date-time)|
|**Query**|**createDate_between**  <br>*可选*||string|
|**Query**|**createDate_gte**  <br>*可选*||string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*||string (date-time)|
|**Query**|**id**  <br>*可选*||string|
|**Query**|**id_in**  <br>*可选*||< string > array(multi)|
|**Query**|**imageName**  <br>*可选*||string|
|**Query**|**isNewRecord**  <br>*可选*||boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*||integer (int64)|
|**Query**|**orderBy**  <br>*可选*||string|
|**Query**|**pageNo**  <br>*可选*||integer (int32)|
|**Query**|**pageSize**  <br>*可选*||integer (int32)|
|**Query**|**remarks**  <br>*可选*||string|
|**Query**|**status**  <br>*可选*||string|
|**Query**|**status_in**  <br>*可选*||< string > array(multi)|
|**Query**|**updateBy**  <br>*可选*||string|
|**Query**|**updateByName**  <br>*可选*||string|
|**Query**|**updateDate**  <br>*可选*||string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*||string|
|**Query**|**updateDate_gte**  <br>*可选*||string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*||string (date-time)|
|**Query**|**vehicleId**  <br>*可选*||string|
|**FormData**|**image**  <br>*必填*|新的车型图片|ref|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `multipart/form-data`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/commonVehicleImage/updateVehicleImage
```


###### 请求 query
```
json :
{
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "id" : "string",
  "id_in" : "string",
  "imageName" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "remarks" : "string",
  "status" : "string",
  "status_in" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string",
  "vehicleId" : "string"
}
```


###### 请求 formData
```
json :
"ref"
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="maintenance-controller_resource"></a>
### Maintenance-controller
Maintenance Controller


<a name="listusingpost_20"></a>
#### list
```
POST /common/maintenance
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**brand**  <br>*可选*|string|
|**Query**|**carComponentRecordsFlag**  <br>*可选*|string|
|**Query**|**carConstructRecordsFlag**  <br>*可选*|string|
|**Query**|**carFireFlag**  <br>*可选*|string|
|**Query**|**carOutsideRecordsFlag**  <br>*可选*|string|
|**Query**|**carWaterFlag**  <br>*可选*|string|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**displacement**  <br>*可选*|string|
|**Query**|**effluentStandard**  <br>*可选*|string|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastMainTainTime**  <br>*可选*|string|
|**Query**|**lastRepairTime**  <br>*可选*|string|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**mainTainTimes**  <br>*可选*|string|
|**Query**|**makeDate**  <br>*可选*|string|
|**Query**|**manufacturer**  <br>*可选*|string|
|**Query**|**mileageEstimate**  <br>*可选*|string|
|**Query**|**mileageEveryYear**  <br>*可选*|string|
|**Query**|**mileageIsNormalFlag**  <br>*可选*|string|
|**Query**|**modelName**  <br>*可选*|string|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**resultCode**  <br>*可选*|string|
|**Query**|**resultMsg**  <br>*可选*|string|
|**Query**|**seriesName**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**transmissionType**  <br>*可选*|string|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**vin**  <br>*可选*|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|string|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/maintenance
```


###### 请求 query
```
json :
{
  "brand" : "string",
  "carComponentRecordsFlag" : "string",
  "carConstructRecordsFlag" : "string",
  "carFireFlag" : "string",
  "carOutsideRecordsFlag" : "string",
  "carWaterFlag" : "string",
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "displacement" : "string",
  "effluentStandard" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastMainTainTime" : "string",
  "lastRepairTime" : "string",
  "lastUpdateDateTime" : 0,
  "mainTainTimes" : "string",
  "makeDate" : "string",
  "manufacturer" : "string",
  "mileageEstimate" : "string",
  "mileageEveryYear" : "string",
  "mileageIsNormalFlag" : "string",
  "modelName" : "string",
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "remarks" : "string",
  "resultCode" : "string",
  "resultMsg" : "string",
  "seriesName" : "string",
  "status" : "string",
  "status_in" : "string",
  "transmissionType" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string",
  "vin" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
"string"
```


<a name="listusingpost_19"></a>
#### list
```
POST /common/maintenance/car
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**aaa**  <br>*可选*|aaa|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|string|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/maintenance/car
```


###### 请求 query
```
json :
{
  "aaa" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
"string"
```


<a name="deleteusingpost_15"></a>
#### delete
```
POST /common/maintenance/delete
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**brand**  <br>*可选*|string|
|**Query**|**carComponentRecordsFlag**  <br>*可选*|string|
|**Query**|**carConstructRecordsFlag**  <br>*可选*|string|
|**Query**|**carFireFlag**  <br>*可选*|string|
|**Query**|**carOutsideRecordsFlag**  <br>*可选*|string|
|**Query**|**carWaterFlag**  <br>*可选*|string|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**displacement**  <br>*可选*|string|
|**Query**|**effluentStandard**  <br>*可选*|string|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastMainTainTime**  <br>*可选*|string|
|**Query**|**lastRepairTime**  <br>*可选*|string|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**mainTainTimes**  <br>*可选*|string|
|**Query**|**makeDate**  <br>*可选*|string|
|**Query**|**manufacturer**  <br>*可选*|string|
|**Query**|**mileageEstimate**  <br>*可选*|string|
|**Query**|**mileageEveryYear**  <br>*可选*|string|
|**Query**|**mileageIsNormalFlag**  <br>*可选*|string|
|**Query**|**modelName**  <br>*可选*|string|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**resultCode**  <br>*可选*|string|
|**Query**|**resultMsg**  <br>*可选*|string|
|**Query**|**seriesName**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**transmissionType**  <br>*可选*|string|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**vin**  <br>*可选*|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|string|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/maintenance/delete
```


###### 请求 query
```
json :
{
  "brand" : "string",
  "carComponentRecordsFlag" : "string",
  "carConstructRecordsFlag" : "string",
  "carFireFlag" : "string",
  "carOutsideRecordsFlag" : "string",
  "carWaterFlag" : "string",
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "displacement" : "string",
  "effluentStandard" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastMainTainTime" : "string",
  "lastRepairTime" : "string",
  "lastUpdateDateTime" : 0,
  "mainTainTimes" : "string",
  "makeDate" : "string",
  "manufacturer" : "string",
  "mileageEstimate" : "string",
  "mileageEveryYear" : "string",
  "mileageIsNormalFlag" : "string",
  "modelName" : "string",
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "remarks" : "string",
  "resultCode" : "string",
  "resultMsg" : "string",
  "seriesName" : "string",
  "status" : "string",
  "status_in" : "string",
  "transmissionType" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string",
  "vin" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
"string"
```


<a name="formusingpost_17"></a>
#### form
```
POST /common/maintenance/form
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**brand**  <br>*可选*|string|
|**Query**|**carComponentRecordsFlag**  <br>*可选*|string|
|**Query**|**carConstructRecordsFlag**  <br>*可选*|string|
|**Query**|**carFireFlag**  <br>*可选*|string|
|**Query**|**carOutsideRecordsFlag**  <br>*可选*|string|
|**Query**|**carWaterFlag**  <br>*可选*|string|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**displacement**  <br>*可选*|string|
|**Query**|**effluentStandard**  <br>*可选*|string|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastMainTainTime**  <br>*可选*|string|
|**Query**|**lastRepairTime**  <br>*可选*|string|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**mainTainTimes**  <br>*可选*|string|
|**Query**|**makeDate**  <br>*可选*|string|
|**Query**|**manufacturer**  <br>*可选*|string|
|**Query**|**mileageEstimate**  <br>*可选*|string|
|**Query**|**mileageEveryYear**  <br>*可选*|string|
|**Query**|**mileageIsNormalFlag**  <br>*可选*|string|
|**Query**|**modelName**  <br>*可选*|string|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**resultCode**  <br>*可选*|string|
|**Query**|**resultMsg**  <br>*可选*|string|
|**Query**|**seriesName**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**transmissionType**  <br>*可选*|string|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**vin**  <br>*可选*|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|string|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/maintenance/form
```


###### 请求 query
```
json :
{
  "brand" : "string",
  "carComponentRecordsFlag" : "string",
  "carConstructRecordsFlag" : "string",
  "carFireFlag" : "string",
  "carOutsideRecordsFlag" : "string",
  "carWaterFlag" : "string",
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "displacement" : "string",
  "effluentStandard" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastMainTainTime" : "string",
  "lastRepairTime" : "string",
  "lastUpdateDateTime" : 0,
  "mainTainTimes" : "string",
  "makeDate" : "string",
  "manufacturer" : "string",
  "mileageEstimate" : "string",
  "mileageEveryYear" : "string",
  "mileageIsNormalFlag" : "string",
  "modelName" : "string",
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "remarks" : "string",
  "resultCode" : "string",
  "resultMsg" : "string",
  "seriesName" : "string",
  "status" : "string",
  "status_in" : "string",
  "transmissionType" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string",
  "vin" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
"string"
```


<a name="listusingpost_21"></a>
#### list
```
POST /common/maintenance/list
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**brand**  <br>*可选*|string|
|**Query**|**carComponentRecordsFlag**  <br>*可选*|string|
|**Query**|**carConstructRecordsFlag**  <br>*可选*|string|
|**Query**|**carFireFlag**  <br>*可选*|string|
|**Query**|**carOutsideRecordsFlag**  <br>*可选*|string|
|**Query**|**carWaterFlag**  <br>*可选*|string|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**displacement**  <br>*可选*|string|
|**Query**|**effluentStandard**  <br>*可选*|string|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastMainTainTime**  <br>*可选*|string|
|**Query**|**lastRepairTime**  <br>*可选*|string|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**mainTainTimes**  <br>*可选*|string|
|**Query**|**makeDate**  <br>*可选*|string|
|**Query**|**manufacturer**  <br>*可选*|string|
|**Query**|**mileageEstimate**  <br>*可选*|string|
|**Query**|**mileageEveryYear**  <br>*可选*|string|
|**Query**|**mileageIsNormalFlag**  <br>*可选*|string|
|**Query**|**modelName**  <br>*可选*|string|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**resultCode**  <br>*可选*|string|
|**Query**|**resultMsg**  <br>*可选*|string|
|**Query**|**seriesName**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**transmissionType**  <br>*可选*|string|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**vin**  <br>*可选*|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|string|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/maintenance/list
```


###### 请求 query
```
json :
{
  "brand" : "string",
  "carComponentRecordsFlag" : "string",
  "carConstructRecordsFlag" : "string",
  "carFireFlag" : "string",
  "carOutsideRecordsFlag" : "string",
  "carWaterFlag" : "string",
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "displacement" : "string",
  "effluentStandard" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastMainTainTime" : "string",
  "lastRepairTime" : "string",
  "lastUpdateDateTime" : 0,
  "mainTainTimes" : "string",
  "makeDate" : "string",
  "manufacturer" : "string",
  "mileageEstimate" : "string",
  "mileageEveryYear" : "string",
  "mileageIsNormalFlag" : "string",
  "modelName" : "string",
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "remarks" : "string",
  "resultCode" : "string",
  "resultMsg" : "string",
  "seriesName" : "string",
  "status" : "string",
  "status_in" : "string",
  "transmissionType" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string",
  "vin" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
"string"
```


<a name="listdatausingpost_19"></a>
#### listData
```
POST /common/maintenance/listData
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**brand**  <br>*可选*|string|
|**Query**|**carComponentRecordsFlag**  <br>*可选*|string|
|**Query**|**carConstructRecordsFlag**  <br>*可选*|string|
|**Query**|**carFireFlag**  <br>*可选*|string|
|**Query**|**carOutsideRecordsFlag**  <br>*可选*|string|
|**Query**|**carWaterFlag**  <br>*可选*|string|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**displacement**  <br>*可选*|string|
|**Query**|**effluentStandard**  <br>*可选*|string|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastMainTainTime**  <br>*可选*|string|
|**Query**|**lastRepairTime**  <br>*可选*|string|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**mainTainTimes**  <br>*可选*|string|
|**Query**|**makeDate**  <br>*可选*|string|
|**Query**|**manufacturer**  <br>*可选*|string|
|**Query**|**mileageEstimate**  <br>*可选*|string|
|**Query**|**mileageEveryYear**  <br>*可选*|string|
|**Query**|**mileageIsNormalFlag**  <br>*可选*|string|
|**Query**|**modelName**  <br>*可选*|string|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**resultCode**  <br>*可选*|string|
|**Query**|**resultMsg**  <br>*可选*|string|
|**Query**|**seriesName**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**transmissionType**  <br>*可选*|string|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**vin**  <br>*可选*|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[Page«Maintenance»](#c3fe2544ac1ed3edc832ec97d68bd67c)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/maintenance/listData
```


###### 请求 query
```
json :
{
  "brand" : "string",
  "carComponentRecordsFlag" : "string",
  "carConstructRecordsFlag" : "string",
  "carFireFlag" : "string",
  "carOutsideRecordsFlag" : "string",
  "carWaterFlag" : "string",
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "displacement" : "string",
  "effluentStandard" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastMainTainTime" : "string",
  "lastRepairTime" : "string",
  "lastUpdateDateTime" : 0,
  "mainTainTimes" : "string",
  "makeDate" : "string",
  "manufacturer" : "string",
  "mileageEstimate" : "string",
  "mileageEveryYear" : "string",
  "mileageIsNormalFlag" : "string",
  "modelName" : "string",
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "remarks" : "string",
  "resultCode" : "string",
  "resultMsg" : "string",
  "seriesName" : "string",
  "status" : "string",
  "status_in" : "string",
  "transmissionType" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string",
  "vin" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "count" : 0,
  "list" : [ {
    "brand" : "string",
    "carComponentRecordsFlag" : "string",
    "carConstructRecordsFlag" : "string",
    "carFireFlag" : "string",
    "carOutsideRecordsFlag" : "string",
    "carWaterFlag" : "string",
    "createBy" : "string",
    "createByName" : "string",
    "createDate" : "string",
    "createDate_between" : "string",
    "createDate_gte" : "string",
    "createDate_lte" : "string",
    "displacement" : "string",
    "effluentStandard" : "string",
    "id" : "string",
    "id_in" : [ "string" ],
    "isNewRecord" : true,
    "lastMainTainTime" : "string",
    "lastRepairTime" : "string",
    "lastUpdateDateTime" : 0,
    "mainTainTimes" : "string",
    "makeDate" : "string",
    "manufacturer" : "string",
    "mileageEstimate" : "string",
    "mileageEveryYear" : "string",
    "mileageIsNormalFlag" : "string",
    "modelName" : "string",
    "orderBy" : "string",
    "pageNo" : 0,
    "pageSize" : 0,
    "remarks" : "string",
    "resultCode" : "string",
    "resultMsg" : "string",
    "seriesName" : "string",
    "status" : "string",
    "status_in" : [ "string" ],
    "transmissionType" : "string",
    "updateBy" : "string",
    "updateByName" : "string",
    "updateDate" : "string",
    "updateDate_between" : "string",
    "updateDate_gte" : "string",
    "updateDate_lte" : "string",
    "vin" : "string"
  } ],
  "otherData" : "object",
  "pageNo" : 0,
  "pageSize" : 0
}
```


<a name="saveusingpost_16"></a>
#### save
```
POST /common/maintenance/save
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**brand**  <br>*可选*|string|
|**Query**|**carComponentRecordsFlag**  <br>*可选*|string|
|**Query**|**carConstructRecordsFlag**  <br>*可选*|string|
|**Query**|**carFireFlag**  <br>*可选*|string|
|**Query**|**carOutsideRecordsFlag**  <br>*可选*|string|
|**Query**|**carWaterFlag**  <br>*可选*|string|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**displacement**  <br>*可选*|string|
|**Query**|**effluentStandard**  <br>*可选*|string|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastMainTainTime**  <br>*可选*|string|
|**Query**|**lastRepairTime**  <br>*可选*|string|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**mainTainTimes**  <br>*可选*|string|
|**Query**|**makeDate**  <br>*可选*|string|
|**Query**|**manufacturer**  <br>*可选*|string|
|**Query**|**mileageEstimate**  <br>*可选*|string|
|**Query**|**mileageEveryYear**  <br>*可选*|string|
|**Query**|**mileageIsNormalFlag**  <br>*可选*|string|
|**Query**|**modelName**  <br>*可选*|string|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**resultCode**  <br>*可选*|string|
|**Query**|**resultMsg**  <br>*可选*|string|
|**Query**|**seriesName**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**transmissionType**  <br>*可选*|string|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**vin**  <br>*可选*|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|string|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/maintenance/save
```


###### 请求 query
```
json :
{
  "brand" : "string",
  "carComponentRecordsFlag" : "string",
  "carConstructRecordsFlag" : "string",
  "carFireFlag" : "string",
  "carOutsideRecordsFlag" : "string",
  "carWaterFlag" : "string",
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "displacement" : "string",
  "effluentStandard" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastMainTainTime" : "string",
  "lastRepairTime" : "string",
  "lastUpdateDateTime" : 0,
  "mainTainTimes" : "string",
  "makeDate" : "string",
  "manufacturer" : "string",
  "mileageEstimate" : "string",
  "mileageEveryYear" : "string",
  "mileageIsNormalFlag" : "string",
  "modelName" : "string",
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "remarks" : "string",
  "resultCode" : "string",
  "resultMsg" : "string",
  "seriesName" : "string",
  "status" : "string",
  "status_in" : "string",
  "transmissionType" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string",
  "vin" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
"string"
```


<a name="maintenance-type-controller_resource"></a>
### Maintenance-type-controller
Maintenance Type Controller


<a name="listusingpost_22"></a>
#### list
```
POST /common/maintenanceType
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**mainTainDate**  <br>*可选*|string|
|**Query**|**maintenanceId**  <br>*可选*|string|
|**Query**|**maintenanceType**  <br>*可选*|string|
|**Query**|**mileage**  <br>*可选*|string|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**repairDate**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**type**  <br>*可选*|string|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|string|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/maintenanceType
```


###### 请求 query
```
json :
{
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "mainTainDate" : "string",
  "maintenanceId" : "string",
  "maintenanceType" : "string",
  "mileage" : "string",
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "remarks" : "string",
  "repairDate" : "string",
  "status" : "string",
  "status_in" : "string",
  "type" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
"string"
```


<a name="deleteusingpost_16"></a>
#### delete
```
POST /common/maintenanceType/delete
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**mainTainDate**  <br>*可选*|string|
|**Query**|**maintenanceId**  <br>*可选*|string|
|**Query**|**maintenanceType**  <br>*可选*|string|
|**Query**|**mileage**  <br>*可选*|string|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**repairDate**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**type**  <br>*可选*|string|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|string|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/maintenanceType/delete
```


###### 请求 query
```
json :
{
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "mainTainDate" : "string",
  "maintenanceId" : "string",
  "maintenanceType" : "string",
  "mileage" : "string",
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "remarks" : "string",
  "repairDate" : "string",
  "status" : "string",
  "status_in" : "string",
  "type" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
"string"
```


<a name="formusingpost_18"></a>
#### form
```
POST /common/maintenanceType/form
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**mainTainDate**  <br>*可选*|string|
|**Query**|**maintenanceId**  <br>*可选*|string|
|**Query**|**maintenanceType**  <br>*可选*|string|
|**Query**|**mileage**  <br>*可选*|string|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**repairDate**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**type**  <br>*可选*|string|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|string|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/maintenanceType/form
```


###### 请求 query
```
json :
{
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "mainTainDate" : "string",
  "maintenanceId" : "string",
  "maintenanceType" : "string",
  "mileage" : "string",
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "remarks" : "string",
  "repairDate" : "string",
  "status" : "string",
  "status_in" : "string",
  "type" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
"string"
```


<a name="listusingpost_23"></a>
#### list
```
POST /common/maintenanceType/list
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**mainTainDate**  <br>*可选*|string|
|**Query**|**maintenanceId**  <br>*可选*|string|
|**Query**|**maintenanceType**  <br>*可选*|string|
|**Query**|**mileage**  <br>*可选*|string|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**repairDate**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**type**  <br>*可选*|string|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|string|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/maintenanceType/list
```


###### 请求 query
```
json :
{
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "mainTainDate" : "string",
  "maintenanceId" : "string",
  "maintenanceType" : "string",
  "mileage" : "string",
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "remarks" : "string",
  "repairDate" : "string",
  "status" : "string",
  "status_in" : "string",
  "type" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
"string"
```


<a name="listdatausingpost_20"></a>
#### listData
```
POST /common/maintenanceType/listData
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**mainTainDate**  <br>*可选*|string|
|**Query**|**maintenanceId**  <br>*可选*|string|
|**Query**|**maintenanceType**  <br>*可选*|string|
|**Query**|**mileage**  <br>*可选*|string|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**repairDate**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**type**  <br>*可选*|string|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[Page«MaintenanceType»](#d8b5416832dcb45206b9879a671f1746)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/maintenanceType/listData
```


###### 请求 query
```
json :
{
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "mainTainDate" : "string",
  "maintenanceId" : "string",
  "maintenanceType" : "string",
  "mileage" : "string",
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "remarks" : "string",
  "repairDate" : "string",
  "status" : "string",
  "status_in" : "string",
  "type" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "count" : 0,
  "list" : [ {
    "createBy" : "string",
    "createByName" : "string",
    "createDate" : "string",
    "createDate_between" : "string",
    "createDate_gte" : "string",
    "createDate_lte" : "string",
    "id" : "string",
    "id_in" : [ "string" ],
    "isNewRecord" : true,
    "lastUpdateDateTime" : 0,
    "mainTainDate" : "string",
    "maintenanceId" : "string",
    "maintenanceType" : "string",
    "mileage" : "string",
    "orderBy" : "string",
    "pageNo" : 0,
    "pageSize" : 0,
    "remarks" : "string",
    "repairDate" : "string",
    "status" : "string",
    "status_in" : [ "string" ],
    "type" : "string",
    "updateBy" : "string",
    "updateByName" : "string",
    "updateDate" : "string",
    "updateDate_between" : "string",
    "updateDate_gte" : "string",
    "updateDate_lte" : "string"
  } ],
  "otherData" : "object",
  "pageNo" : 0,
  "pageSize" : 0
}
```


<a name="saveusingpost_17"></a>
#### save
```
POST /common/maintenanceType/save
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**mainTainDate**  <br>*可选*|string|
|**Query**|**maintenanceId**  <br>*可选*|string|
|**Query**|**maintenanceType**  <br>*可选*|string|
|**Query**|**mileage**  <br>*可选*|string|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**repairDate**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**type**  <br>*可选*|string|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|string|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/maintenanceType/save
```


###### 请求 query
```
json :
{
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "mainTainDate" : "string",
  "maintenanceId" : "string",
  "maintenanceType" : "string",
  "mileage" : "string",
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "remarks" : "string",
  "repairDate" : "string",
  "status" : "string",
  "status_in" : "string",
  "type" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
"string"
```


<a name="vehicle-brand-controller_resource"></a>
### Vehicle-brand-controller
Vehicle Brand Controller


<a name="listusingpost_24"></a>
#### list
```
POST /common/vehicleBrand
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**gengxinshijian**  <br>*可选*|string|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**pinpai**  <br>*可选*|string|
|**Query**|**pinpaiId**  <br>*可选*|string|
|**Query**|**pinpaiLogo**  <br>*可选*|string|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**shouzimu**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|string|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/vehicleBrand
```


###### 请求 query
```
json :
{
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "gengxinshijian" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "pinpai" : "string",
  "pinpaiId" : "string",
  "pinpaiLogo" : "string",
  "remarks" : "string",
  "shouzimu" : "string",
  "status" : "string",
  "status_in" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
"string"
```


<a name="deleteusingpost_17"></a>
#### delete
```
POST /common/vehicleBrand/delete
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**gengxinshijian**  <br>*可选*|string|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**pinpai**  <br>*可选*|string|
|**Query**|**pinpaiId**  <br>*可选*|string|
|**Query**|**pinpaiLogo**  <br>*可选*|string|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**shouzimu**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|string|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/vehicleBrand/delete
```


###### 请求 query
```
json :
{
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "gengxinshijian" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "pinpai" : "string",
  "pinpaiId" : "string",
  "pinpaiLogo" : "string",
  "remarks" : "string",
  "shouzimu" : "string",
  "status" : "string",
  "status_in" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
"string"
```


<a name="findlistusingpost"></a>
#### findList
```
POST /common/vehicleBrand/findList
```


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/vehicleBrand/findList
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="formusingpost_19"></a>
#### form
```
POST /common/vehicleBrand/form
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**gengxinshijian**  <br>*可选*|string|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**pinpai**  <br>*可选*|string|
|**Query**|**pinpaiId**  <br>*可选*|string|
|**Query**|**pinpaiLogo**  <br>*可选*|string|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**shouzimu**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|string|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/vehicleBrand/form
```


###### 请求 query
```
json :
{
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "gengxinshijian" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "pinpai" : "string",
  "pinpaiId" : "string",
  "pinpaiLogo" : "string",
  "remarks" : "string",
  "shouzimu" : "string",
  "status" : "string",
  "status_in" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
"string"
```


<a name="getbyentityusingpost"></a>
#### getByEntity
```
POST /common/vehicleBrand/getByEntity
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**gengxinshijian**  <br>*可选*|string|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**pinpai**  <br>*可选*|string|
|**Query**|**pinpaiId**  <br>*可选*|string|
|**Query**|**pinpaiLogo**  <br>*可选*|string|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**shouzimu**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/vehicleBrand/getByEntity
```


###### 请求 query
```
json :
{
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "gengxinshijian" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "pinpai" : "string",
  "pinpaiId" : "string",
  "pinpaiLogo" : "string",
  "remarks" : "string",
  "shouzimu" : "string",
  "status" : "string",
  "status_in" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="listusingpost_25"></a>
#### list
```
POST /common/vehicleBrand/list
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**gengxinshijian**  <br>*可选*|string|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**pinpai**  <br>*可选*|string|
|**Query**|**pinpaiId**  <br>*可选*|string|
|**Query**|**pinpaiLogo**  <br>*可选*|string|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**shouzimu**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|string|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/vehicleBrand/list
```


###### 请求 query
```
json :
{
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "gengxinshijian" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "pinpai" : "string",
  "pinpaiId" : "string",
  "pinpaiLogo" : "string",
  "remarks" : "string",
  "shouzimu" : "string",
  "status" : "string",
  "status_in" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
"string"
```


<a name="listdatausingpost_21"></a>
#### listData
```
POST /common/vehicleBrand/listData
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**gengxinshijian**  <br>*可选*|string|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**pinpai**  <br>*可选*|string|
|**Query**|**pinpaiId**  <br>*可选*|string|
|**Query**|**pinpaiLogo**  <br>*可选*|string|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**shouzimu**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[Page«VehicleBrand»](#b40a47f38877eafeac556b9800cabe8f)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/vehicleBrand/listData
```


###### 请求 query
```
json :
{
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "gengxinshijian" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "pinpai" : "string",
  "pinpaiId" : "string",
  "pinpaiLogo" : "string",
  "remarks" : "string",
  "shouzimu" : "string",
  "status" : "string",
  "status_in" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "count" : 0,
  "list" : [ {
    "createBy" : "string",
    "createByName" : "string",
    "createDate" : "string",
    "createDate_between" : "string",
    "createDate_gte" : "string",
    "createDate_lte" : "string",
    "gengxinshijian" : "string",
    "id" : "string",
    "id_in" : [ "string" ],
    "isNewRecord" : true,
    "lastUpdateDateTime" : 0,
    "orderBy" : "string",
    "pageNo" : 0,
    "pageSize" : 0,
    "pinpai" : "string",
    "pinpaiId" : "string",
    "pinpaiLogo" : "string",
    "remarks" : "string",
    "shouzimu" : "string",
    "status" : "string",
    "status_in" : [ "string" ],
    "updateBy" : "string",
    "updateByName" : "string",
    "updateDate" : "string",
    "updateDate_between" : "string",
    "updateDate_gte" : "string",
    "updateDate_lte" : "string"
  } ],
  "otherData" : "object",
  "pageNo" : 0,
  "pageSize" : 0
}
```


<a name="saveusingpost_18"></a>
#### save
```
POST /common/vehicleBrand/save
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**gengxinshijian**  <br>*可选*|string|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**pinpai**  <br>*可选*|string|
|**Query**|**pinpaiId**  <br>*可选*|string|
|**Query**|**pinpaiLogo**  <br>*可选*|string|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**shouzimu**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|string|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/vehicleBrand/save
```


###### 请求 query
```
json :
{
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "gengxinshijian" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "pinpai" : "string",
  "pinpaiId" : "string",
  "pinpaiLogo" : "string",
  "remarks" : "string",
  "shouzimu" : "string",
  "status" : "string",
  "status_in" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
"string"
```


<a name="vehicle-danger-controller_resource"></a>
### Vehicle-danger-controller
Vehicle Danger Controller


<a name="listusingpost_26"></a>
#### list
```
POST /common/vehicleDanger
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**commonVehicleDangerTotalId**  <br>*可选*|string|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**dangerDate**  <br>*可选*|string|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**serviceMoney**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|string|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/vehicleDanger
```


###### 请求 query
```
json :
{
  "commonVehicleDangerTotalId" : "string",
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "dangerDate" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "remarks" : "string",
  "serviceMoney" : "string",
  "status" : "string",
  "status_in" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
"string"
```


<a name="deleteusingpost_18"></a>
#### delete
```
POST /common/vehicleDanger/delete
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**commonVehicleDangerTotalId**  <br>*可选*|string|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**dangerDate**  <br>*可选*|string|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**serviceMoney**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|string|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/vehicleDanger/delete
```


###### 请求 query
```
json :
{
  "commonVehicleDangerTotalId" : "string",
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "dangerDate" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "remarks" : "string",
  "serviceMoney" : "string",
  "status" : "string",
  "status_in" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
"string"
```


<a name="formusingpost_20"></a>
#### form
```
POST /common/vehicleDanger/form
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**commonVehicleDangerTotalId**  <br>*可选*|string|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**dangerDate**  <br>*可选*|string|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**serviceMoney**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|string|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/vehicleDanger/form
```


###### 请求 query
```
json :
{
  "commonVehicleDangerTotalId" : "string",
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "dangerDate" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "remarks" : "string",
  "serviceMoney" : "string",
  "status" : "string",
  "status_in" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
"string"
```


<a name="listusingpost_27"></a>
#### list
```
POST /common/vehicleDanger/list
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**commonVehicleDangerTotalId**  <br>*可选*|string|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**dangerDate**  <br>*可选*|string|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**serviceMoney**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|string|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/vehicleDanger/list
```


###### 请求 query
```
json :
{
  "commonVehicleDangerTotalId" : "string",
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "dangerDate" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "remarks" : "string",
  "serviceMoney" : "string",
  "status" : "string",
  "status_in" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
"string"
```


<a name="listdatausingpost_22"></a>
#### listData
```
POST /common/vehicleDanger/listData
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**commonVehicleDangerTotalId**  <br>*可选*|string|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**dangerDate**  <br>*可选*|string|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**serviceMoney**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[Page«VehicleDanger»](#d5192de1e8564c3133472ef017b608ec)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/vehicleDanger/listData
```


###### 请求 query
```
json :
{
  "commonVehicleDangerTotalId" : "string",
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "dangerDate" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "remarks" : "string",
  "serviceMoney" : "string",
  "status" : "string",
  "status_in" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "count" : 0,
  "list" : [ {
    "commonVehicleDangerTotalId" : "string",
    "createBy" : "string",
    "createByName" : "string",
    "createDate" : "string",
    "createDate_between" : "string",
    "createDate_gte" : "string",
    "createDate_lte" : "string",
    "dangerDate" : "string",
    "id" : "string",
    "id_in" : [ "string" ],
    "isNewRecord" : true,
    "lastUpdateDateTime" : 0,
    "orderBy" : "string",
    "pageNo" : 0,
    "pageSize" : 0,
    "remarks" : "string",
    "serviceMoney" : "string",
    "status" : "string",
    "status_in" : [ "string" ],
    "updateBy" : "string",
    "updateByName" : "string",
    "updateDate" : "string",
    "updateDate_between" : "string",
    "updateDate_gte" : "string",
    "updateDate_lte" : "string"
  } ],
  "otherData" : "object",
  "pageNo" : 0,
  "pageSize" : 0
}
```


<a name="saveusingpost_19"></a>
#### save
```
POST /common/vehicleDanger/save
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**commonVehicleDangerTotalId**  <br>*可选*|string|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**dangerDate**  <br>*可选*|string|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**serviceMoney**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|string|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/vehicleDanger/save
```


###### 请求 query
```
json :
{
  "commonVehicleDangerTotalId" : "string",
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "dangerDate" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "remarks" : "string",
  "serviceMoney" : "string",
  "status" : "string",
  "status_in" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
"string"
```


<a name="vehicle-danger-detail-controller_resource"></a>
### Vehicle-danger-detail-controller
Vehicle Danger Detail Controller


<a name="listusingpost_28"></a>
#### list
```
POST /common/vehicleDangerDetail
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**commonVehicleDangerId**  <br>*可选*|string|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**dangerSingleMoney**  <br>*可选*|string|
|**Query**|**dangerSingleName**  <br>*可选*|string|
|**Query**|**dangerSingleType**  <br>*可选*|string|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|string|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/vehicleDangerDetail
```


###### 请求 query
```
json :
{
  "commonVehicleDangerId" : "string",
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "dangerSingleMoney" : "string",
  "dangerSingleName" : "string",
  "dangerSingleType" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "remarks" : "string",
  "status" : "string",
  "status_in" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
"string"
```


<a name="deleteusingpost_19"></a>
#### delete
```
POST /common/vehicleDangerDetail/delete
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**commonVehicleDangerId**  <br>*可选*|string|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**dangerSingleMoney**  <br>*可选*|string|
|**Query**|**dangerSingleName**  <br>*可选*|string|
|**Query**|**dangerSingleType**  <br>*可选*|string|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|string|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/vehicleDangerDetail/delete
```


###### 请求 query
```
json :
{
  "commonVehicleDangerId" : "string",
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "dangerSingleMoney" : "string",
  "dangerSingleName" : "string",
  "dangerSingleType" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "remarks" : "string",
  "status" : "string",
  "status_in" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
"string"
```


<a name="formusingpost_21"></a>
#### form
```
POST /common/vehicleDangerDetail/form
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**commonVehicleDangerId**  <br>*可选*|string|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**dangerSingleMoney**  <br>*可选*|string|
|**Query**|**dangerSingleName**  <br>*可选*|string|
|**Query**|**dangerSingleType**  <br>*可选*|string|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|string|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/vehicleDangerDetail/form
```


###### 请求 query
```
json :
{
  "commonVehicleDangerId" : "string",
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "dangerSingleMoney" : "string",
  "dangerSingleName" : "string",
  "dangerSingleType" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "remarks" : "string",
  "status" : "string",
  "status_in" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
"string"
```


<a name="listusingpost_29"></a>
#### list
```
POST /common/vehicleDangerDetail/list
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**commonVehicleDangerId**  <br>*可选*|string|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**dangerSingleMoney**  <br>*可选*|string|
|**Query**|**dangerSingleName**  <br>*可选*|string|
|**Query**|**dangerSingleType**  <br>*可选*|string|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|string|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/vehicleDangerDetail/list
```


###### 请求 query
```
json :
{
  "commonVehicleDangerId" : "string",
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "dangerSingleMoney" : "string",
  "dangerSingleName" : "string",
  "dangerSingleType" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "remarks" : "string",
  "status" : "string",
  "status_in" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
"string"
```


<a name="listdatausingpost_23"></a>
#### listData
```
POST /common/vehicleDangerDetail/listData
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**commonVehicleDangerId**  <br>*可选*|string|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**dangerSingleMoney**  <br>*可选*|string|
|**Query**|**dangerSingleName**  <br>*可选*|string|
|**Query**|**dangerSingleType**  <br>*可选*|string|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[Page«VehicleDangerDetail»](#bb2d86bede5b37065c0318a517a348c8)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/vehicleDangerDetail/listData
```


###### 请求 query
```
json :
{
  "commonVehicleDangerId" : "string",
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "dangerSingleMoney" : "string",
  "dangerSingleName" : "string",
  "dangerSingleType" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "remarks" : "string",
  "status" : "string",
  "status_in" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "count" : 0,
  "list" : [ {
    "commonVehicleDangerId" : "string",
    "createBy" : "string",
    "createByName" : "string",
    "createDate" : "string",
    "createDate_between" : "string",
    "createDate_gte" : "string",
    "createDate_lte" : "string",
    "dangerSingleMoney" : "string",
    "dangerSingleName" : "string",
    "dangerSingleType" : "string",
    "id" : "string",
    "id_in" : [ "string" ],
    "isNewRecord" : true,
    "lastUpdateDateTime" : 0,
    "orderBy" : "string",
    "pageNo" : 0,
    "pageSize" : 0,
    "remarks" : "string",
    "status" : "string",
    "status_in" : [ "string" ],
    "updateBy" : "string",
    "updateByName" : "string",
    "updateDate" : "string",
    "updateDate_between" : "string",
    "updateDate_gte" : "string",
    "updateDate_lte" : "string"
  } ],
  "otherData" : "object",
  "pageNo" : 0,
  "pageSize" : 0
}
```


<a name="saveusingpost_20"></a>
#### save
```
POST /common/vehicleDangerDetail/save
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**commonVehicleDangerId**  <br>*可选*|string|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**dangerSingleMoney**  <br>*可选*|string|
|**Query**|**dangerSingleName**  <br>*可选*|string|
|**Query**|**dangerSingleType**  <br>*可选*|string|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|string|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/vehicleDangerDetail/save
```


###### 请求 query
```
json :
{
  "commonVehicleDangerId" : "string",
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "dangerSingleMoney" : "string",
  "dangerSingleName" : "string",
  "dangerSingleType" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "remarks" : "string",
  "status" : "string",
  "status_in" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
"string"
```


<a name="vehicle-danger-total-controller_resource"></a>
### Vehicle-danger-total-controller
Vehicle Danger Total Controller


<a name="listusingpost_30"></a>
#### list
```
POST /common/vehicleDangerTotal
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**serviceSumCount**  <br>*可选*|integer (int64)|
|**Query**|**serviceSumMoney**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**vehicleType**  <br>*可选*|string|
|**Query**|**vinCode**  <br>*可选*|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|string|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/vehicleDangerTotal
```


###### 请求 query
```
json :
{
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "remarks" : "string",
  "serviceSumCount" : 0,
  "serviceSumMoney" : "string",
  "status" : "string",
  "status_in" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string",
  "vehicleType" : "string",
  "vinCode" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
"string"
```


<a name="deleteusingpost_20"></a>
#### delete
```
POST /common/vehicleDangerTotal/delete
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**serviceSumCount**  <br>*可选*|integer (int64)|
|**Query**|**serviceSumMoney**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**vehicleType**  <br>*可选*|string|
|**Query**|**vinCode**  <br>*可选*|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|string|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/vehicleDangerTotal/delete
```


###### 请求 query
```
json :
{
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "remarks" : "string",
  "serviceSumCount" : 0,
  "serviceSumMoney" : "string",
  "status" : "string",
  "status_in" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string",
  "vehicleType" : "string",
  "vinCode" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
"string"
```


<a name="formusingpost_22"></a>
#### form
```
POST /common/vehicleDangerTotal/form
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**serviceSumCount**  <br>*可选*|integer (int64)|
|**Query**|**serviceSumMoney**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**vehicleType**  <br>*可选*|string|
|**Query**|**vinCode**  <br>*可选*|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|string|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/vehicleDangerTotal/form
```


###### 请求 query
```
json :
{
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "remarks" : "string",
  "serviceSumCount" : 0,
  "serviceSumMoney" : "string",
  "status" : "string",
  "status_in" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string",
  "vehicleType" : "string",
  "vinCode" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
"string"
```


<a name="listusingpost_31"></a>
#### list
```
POST /common/vehicleDangerTotal/list
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**serviceSumCount**  <br>*可选*|integer (int64)|
|**Query**|**serviceSumMoney**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**vehicleType**  <br>*可选*|string|
|**Query**|**vinCode**  <br>*可选*|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|string|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/vehicleDangerTotal/list
```


###### 请求 query
```
json :
{
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "remarks" : "string",
  "serviceSumCount" : 0,
  "serviceSumMoney" : "string",
  "status" : "string",
  "status_in" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string",
  "vehicleType" : "string",
  "vinCode" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
"string"
```


<a name="listdatausingpost_24"></a>
#### listData
```
POST /common/vehicleDangerTotal/listData
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**serviceSumCount**  <br>*可选*|integer (int64)|
|**Query**|**serviceSumMoney**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**vehicleType**  <br>*可选*|string|
|**Query**|**vinCode**  <br>*可选*|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[Page«VehicleDangerTotal»](#4b586a30cc14099d837873bf1397601f)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/vehicleDangerTotal/listData
```


###### 请求 query
```
json :
{
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "remarks" : "string",
  "serviceSumCount" : 0,
  "serviceSumMoney" : "string",
  "status" : "string",
  "status_in" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string",
  "vehicleType" : "string",
  "vinCode" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "count" : 0,
  "list" : [ {
    "createBy" : "string",
    "createByName" : "string",
    "createDate" : "string",
    "createDate_between" : "string",
    "createDate_gte" : "string",
    "createDate_lte" : "string",
    "id" : "string",
    "id_in" : [ "string" ],
    "isNewRecord" : true,
    "lastUpdateDateTime" : 0,
    "orderBy" : "string",
    "pageNo" : 0,
    "pageSize" : 0,
    "remarks" : "string",
    "serviceSumCount" : 0,
    "serviceSumMoney" : "string",
    "status" : "string",
    "status_in" : [ "string" ],
    "updateBy" : "string",
    "updateByName" : "string",
    "updateDate" : "string",
    "updateDate_between" : "string",
    "updateDate_gte" : "string",
    "updateDate_lte" : "string",
    "vehicleType" : "string",
    "vinCode" : "string"
  } ],
  "otherData" : "object",
  "pageNo" : 0,
  "pageSize" : 0
}
```


<a name="saveusingpost_21"></a>
#### save
```
POST /common/vehicleDangerTotal/save
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**serviceSumCount**  <br>*可选*|integer (int64)|
|**Query**|**serviceSumMoney**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**vehicleType**  <br>*可选*|string|
|**Query**|**vinCode**  <br>*可选*|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|string|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/vehicleDangerTotal/save
```


###### 请求 query
```
json :
{
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "remarks" : "string",
  "serviceSumCount" : 0,
  "serviceSumMoney" : "string",
  "status" : "string",
  "status_in" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string",
  "vehicleType" : "string",
  "vinCode" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
"string"
```


<a name="totalusingpost"></a>
#### total
```
POST /common/vehicleDangerTotal/total
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**aaa**  <br>*可选*|aaa|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|string|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/vehicleDangerTotal/total
```


###### 请求 query
```
json :
{
  "aaa" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
"string"
```


<a name="vehicle-info-controller_resource"></a>
### Vehicle-info-controller
Vehicle Info Controller


<a name="deletevehicleusingpost"></a>
#### 根据json删除车的信息
```
POST /common/vehicleInfo/deleteVehicle
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**json**  <br>*必填*|要删除的车的json数据|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/vehicleInfo/deleteVehicle
```


###### 请求 query
```
json :
{
  "json" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="downtemplateusingpost_1"></a>
#### 下载车型配置表模板
```
POST /common/vehicleInfo/downTemplate
```


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|无内容|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `application/octet-stream`


##### HTTP请求示例

###### 请求 path
```
/common/vehicleInfo/downTemplate
```


<a name="findlistusingpost_1"></a>
#### 根据车系id加载区分年款的车辆信息
```
POST /common/vehicleInfo/findList
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**chexiId**  <br>*必填*|车系id|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/vehicleInfo/findList
```


###### 请求 query
```
json :
{
  "chexiId" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="getbyentityusingpost_1"></a>
#### 根据车型id查部分常用属性
```
POST /common/vehicleInfo/getByEntity
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**absfangbaosi**  <br>*可选*|string|
|**Query**|**anquandaiweixitixing**  <br>*可选*|string|
|**Query**|**baigonglihaodianliangKwh100km**  <br>*可选*|string|
|**Query**|**beidongxingrenbaohu**  <br>*可选*|string|
|**Query**|**beitaiguige**  <br>*可选*|string|
|**Query**|**biansuxiang**  <br>*可选*|string|
|**Query**|**biansuxiangleixing**  <br>*可选*|string|
|**Query**|**bingxianfuzhu**  <br>*可选*|string|
|**Query**|**cehuamenxingshi**  <br>*可选*|string|
|**Query**|**changduMm**  <br>*可选*|string|
|**Query**|**changkuangaoMm**  <br>*可选*|string|
|**Query**|**changshang**  <br>*可选*|string|
|**Query**|**changshangId**  <br>*可选*|string|
|**Query**|**changshangzhidaojia**  <br>*可选*|string|
|**Query**|**changshangzhidaojiaYuan**  <br>*可选*|string|
|**Query**|**checejiaotaban**  <br>*可选*|string|
|**Query**|**chechuangfangjiashougongneng**  <br>*可选*|string|
|**Query**|**chechuangyijianshengjianggongneng**  <br>*可选*|string|
|**Query**|**chedaobaochifuzhuxitong**  <br>*可选*|string|
|**Query**|**chedaopianliyujingxitong**  <br>*可选*|string|
|**Query**|**chedingxinglijia**  <br>*可选*|string|
|**Query**|**chelianwang**  <br>*可选*|string|
|**Query**|**chemenshuGe**  <br>*可选*|string|
|**Query**|**cheneihuanjingfenweideng**  <br>*可选*|string|
|**Query**|**cheneihuazhuangjing**  <br>*可选*|string|
|**Query**|**cheneipm25guolvzhuangzhi**  <br>*可选*|string|
|**Query**|**cheneixiangfenzhuangzhi**  <br>*可选*|string|
|**Query**|**cheneizhongkongsuo**  <br>*可选*|string|
|**Query**|**cheqianwudeng**  <br>*可选*|string|
|**Query**|**cheshenjiegou**  <br>*可选*|string|
|**Query**|**cheshenwendingkongzhiEscEspDscdeng**  <br>*可选*|string|
|**Query**|**chetijiegou**  <br>*可选*|string|
|**Query**|**chexi**  <br>*可选*|string|
|**Query**|**chexiId**  <br>*可选*|string|
|**Query**|**chexingId**  <br>*可选*|string|
|**Query**|**chexingmingcheng**  <br>*可选*|string|
|**Query**|**chexizhanshitu**  <br>*可选*|string|
|**Query**|**chezaibingxiang**  <br>*可选*|string|
|**Query**|**chezaicdDvd**  <br>*可选*|string|
|**Query**|**chezaidianshi**  <br>*可选*|string|
|**Query**|**chezaikongqijinghuaqi**  <br>*可选*|string|
|**Query**|**chumoshiyuedudeng**  <br>*可选*|string|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**dadenggaoduketiao**  <br>*可选*|string|
|**Query**|**dadengqingxizhuangzhi**  <br>*可选*|string|
|**Query**|**dadengyanshiguanbi**  <br>*可选*|string|
|**Query**|**dangweigeshu**  <br>*可选*|string|
|**Query**|**daochecheceyujingxitong**  <br>*可选*|string|
|**Query**|**daohanglukuangxinxixianshi**  <br>*可选*|string|
|**Query**|**daolujiaotongbiaozhishibie**  <br>*可选*|string|
|**Query**|**daolujiuyuanhujiao**  <br>*可选*|string|
|**Query**|**dengguangtesegongneng**  <br>*可选*|string|
|**Query**|**dianchileixing**  <br>*可选*|string|
|**Query**|**dianchirongliangKwh**  <br>*可选*|string|
|**Query**|**dianchizuzhibao**  <br>*可选*|string|
|**Query**|**dianciganyingxuanjia**  <br>*可选*|string|
|**Query**|**diandonghoubeixiang**  <br>*可选*|string|
|**Query**|**diandonghoubeixiangweizhijiyi**  <br>*可选*|string|
|**Query**|**diandongjizonggonglvKw**  <br>*可选*|string|
|**Query**|**diandongjizongniujuNM**  <br>*可选*|string|
|**Query**|**diandongketiaotaban**  <br>*可选*|string|
|**Query**|**diandongxihechemen**  <br>*可选*|string|
|**Query**|**diandongzuoyijiyigongneng**  <br>*可选*|string|
|**Query**|**dianjibuju**  <br>*可选*|string|
|**Query**|**dianjileixing**  <br>*可选*|string|
|**Query**|**dianyuan220v230v**  <br>*可选*|string|
|**Query**|**dierpaidulizuoyi**  <br>*可选*|string|
|**Query**|**dierpaizuoyitiaojie**  <br>*可选*|string|
|**Query**|**doupohuanjiang**  <br>*可选*|string|
|**Query**|**duocenggeyinboli**  <br>*可选*|string|
|**Query**|**duogongnengfangxiangpan**  <br>*可选*|string|
|**Query**|**fadongji**  <br>*可选*|string|
|**Query**|**fadongjidianzifangdao**  <br>*可选*|string|
|**Query**|**fadongjiqitingjishu**  <br>*可选*|string|
|**Query**|**fadongjiteyoujishu**  <br>*可选*|string|
|**Query**|**fadongjixinghao**  <br>*可选*|string|
|**Query**|**fangxiangpancaizhi**  <br>*可选*|string|
|**Query**|**fangxiangpanhuandang**  <br>*可选*|string|
|**Query**|**fangxiangpanjiare**  <br>*可选*|string|
|**Query**|**fangxiangpanjiyi**  <br>*可选*|string|
|**Query**|**fangxiangpanweizhitiaojie**  <br>*可选*|string|
|**Query**|**fangziwaixianboli**  <br>*可选*|string|
|**Query**|**fujiashiweihoupaiketiaojieanniu**  <br>*可选*|string|
|**Query**|**fulizifashengqi**  <br>*可选*|string|
|**Query**|**fuzuoyitiaojiefangshi**  <br>*可选*|string|
|**Query**|**ganggaicailiao**  <br>*可选*|string|
|**Query**|**gangjingMm**  <br>*可选*|string|
|**Query**|**gangticailiao**  <br>*可选*|string|
|**Query**|**ganyinghoubeixiang**  <br>*可选*|string|
|**Query**|**ganyingyushuagongneng**  <br>*可选*|string|
|**Query**|**gaoduMm**  <br>*可选*|string|
|**Query**|**gengxinshijian**  <br>*可选*|string|
|**Query**|**gongxinbuchundianxuhanglichengKm**  <br>*可选*|string|
|**Query**|**gongxinbuzongheyouhaoL100km**  <br>*可选*|string|
|**Query**|**gongyoufangshi**  <br>*可选*|string|
|**Query**|**gpsdaohangxitong**  <br>*可选*|string|
|**Query**|**guanfang0100kmHJiasuS**  <br>*可选*|string|
|**Query**|**houdiandongjizuidagonglvKw**  <br>*可选*|string|
|**Query**|**houdiandongjizuidaniujuNM**  <br>*可选*|string|
|**Query**|**houfengdangzheyanglian**  <br>*可选*|string|
|**Query**|**houlunjuMm**  <br>*可选*|string|
|**Query**|**houluntaiguige**  <br>*可选*|string|
|**Query**|**houpaianquandaishiqinang**  <br>*可选*|string|
|**Query**|**houpaibeijia**  <br>*可选*|string|
|**Query**|**houpaicechuangzheyanglian**  <br>*可选*|string|
|**Query**|**houpaiceyinsiboli**  <br>*可选*|string|
|**Query**|**houpaidulikongtiao**  <br>*可选*|string|
|**Query**|**houpaikongzhiduomeiti**  <br>*可选*|string|
|**Query**|**houpaixiaozhuoban**  <br>*可选*|string|
|**Query**|**houpaiyejingpingmu**  <br>*可选*|string|
|**Query**|**houpaizhongyanganquanqinang**  <br>*可选*|string|
|**Query**|**houpaizuoyidiandongfangdao**  <br>*可选*|string|
|**Query**|**houpaizuoyidiandongtiaojie**  <br>*可选*|string|
|**Query**|**houpaizuoyifangdaoxingshi**  <br>*可选*|string|
|**Query**|**houpaizuoyigongneng**  <br>*可选*|string|
|**Query**|**houxuanjialeixing**  <br>*可选*|string|
|**Query**|**houyushua**  <br>*可选*|string|
|**Query**|**houzhidongqileixing**  <br>*可选*|string|
|**Query**|**houzuochufengkou**  <br>*可选*|string|
|**Query**|**huanbaobiaozhun**  <br>*可选*|string|
|**Query**|**hudtaitoushuzixianshi**  <br>*可选*|string|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**isofixertongzuoyijiekou**  <br>*可选*|string|
|**Query**|**jiancheng**  <br>*可选*|string|
|**Query**|**jiareZhilengbeijia**  <br>*可选*|string|
|**Query**|**jiashifuzhuyingxiang**  <br>*可选*|string|
|**Query**|**jiashimoshiqiehuan**  <br>*可选*|string|
|**Query**|**jibie**  <br>*可选*|string|
|**Query**|**jinguangdengguangyuan**  <br>*可选*|string|
|**Query**|**jinqixingshi**  <br>*可选*|string|
|**Query**|**kebianxuanjiagongneng**  <br>*可选*|string|
|**Query**|**kebianzhuanxiangbi**  <br>*可选*|string|
|**Query**|**kejiarepenshuizui**  <br>*可选*|string|
|**Query**|**kongqixuanjia**  <br>*可选*|string|
|**Query**|**kongtiaowendukongzhifangshi**  <br>*可选*|string|
|**Query**|**kuaichongdianliang**  <br>*可选*|string|
|**Query**|**kuaichongdianliangbaifenbi**  <br>*可选*|string|
|**Query**|**kuaichongshijianXiaoshi**  <br>*可选*|string|
|**Query**|**kuanduMm**  <br>*可选*|string|
|**Query**|**lanyaChezaidianhua**  <br>*可选*|string|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**ledrijianxingchedeng**  <br>*可选*|string|
|**Query**|**lingtaiyajixuxingshi**  <br>*可选*|string|
|**Query**|**lunquancaizhi**  <br>*可选*|string|
|**Query**|**manchongshijianXiaoshi**  <br>*可选*|string|
|**Query**|**meigangqimenshuGe**  <br>*可选*|string|
|**Query**|**neihoushijinggongneng**  <br>*可选*|string|
|**Query**|**neishiyanse**  <br>*可选*|string|
|**Query**|**neizhixingchejiluyi**  <br>*可选*|string|
|**Query**|**nengyuanleixing**  <br>*可选*|string|
|**Query**|**niankuan**  <br>*可选*|string|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**pailiangL**  <br>*可选*|string|
|**Query**|**pailiangMl**  <br>*可选*|string|
|**Query**|**peiqijigou**  <br>*可选*|string|
|**Query**|**pilaojiashitishi**  <br>*可选*|string|
|**Query**|**pinpai**  <br>*可选*|string|
|**Query**|**pinpaiId**  <br>*可选*|string|
|**Query**|**pinpaiLogo**  <br>*可选*|string|
|**Query**|**qianHoudiandongchechuang**  <br>*可选*|string|
|**Query**|**qianHoupaiceqinang**  <br>*可选*|string|
|**Query**|**qianHoupaitoubuqinangQilian**  <br>*可选*|string|
|**Query**|**qianHouzhongyangfushou**  <br>*可选*|string|
|**Query**|**qianHouzhucheleida**  <br>*可选*|string|
|**Query**|**qiandadengyuwumoshi**  <br>*可选*|string|
|**Query**|**qiandiandongjizuidagonglvKw**  <br>*可选*|string|
|**Query**|**qiandiandongjizuidaniujuNM**  <br>*可选*|string|
|**Query**|**qianlunjuMm**  <br>*可选*|string|
|**Query**|**qianluntaiguige**  <br>*可选*|string|
|**Query**|**qianpaizuoyigongneng**  <br>*可选*|string|
|**Query**|**qianxuanjialeixing**  <br>*可选*|string|
|**Query**|**qianyinlikongzhiAsrTcsTrcdeng**  <br>*可选*|string|
|**Query**|**qianzhidongqileixing**  <br>*可选*|string|
|**Query**|**qigangpailiexingshi**  <br>*可选*|string|
|**Query**|**qigangshuGe**  <br>*可选*|string|
|**Query**|**quanyejingyibiaopan**  <br>*可选*|string|
|**Query**|**qudongdianjishu**  <br>*可选*|string|
|**Query**|**qudongfangshi**  <br>*可选*|string|
|**Query**|**ranliaoxingshi**  <br>*可选*|string|
|**Query**|**ranyoubiaohao**  <br>*可选*|string|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**shachefuzhuEbaBasBadeng**  <br>*可选*|string|
|**Query**|**shangpofuzhu**  <br>*可选*|string|
|**Query**|**shangshishijian**  <br>*可选*|string|
|**Query**|**sheshuiganyingxitong**  <br>*可选*|string|
|**Query**|**shice0100kmHJiasuS**  <br>*可选*|string|
|**Query**|**shice1000kmHZhidongM**  <br>*可选*|string|
|**Query**|**shicexuhanglichengKm**  <br>*可选*|string|
|**Query**|**shiceyouhaoL100km**  <br>*可选*|string|
|**Query**|**shoujihulianYingshe**  <br>*可选*|string|
|**Query**|**shoujiwuxianchongdiangongneng**  <br>*可选*|string|
|**Query**|**shoushikongzhi**  <br>*可选*|string|
|**Query**|**shouzimu**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**taiyajiancegongneng**  <br>*可选*|string|
|**Query**|**tianchuangleixing**  <br>*可选*|string|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**uploadDate**  <br>*可选*|string|
|**Query**|**usbTypeCjiekoushuliang**  <br>*可选*|string|
|**Query**|**waiguanyanse**  <br>*可选*|string|
|**Query**|**waihoushijinggongneng**  <br>*可选*|string|
|**Query**|**waijieyinyuanjiekouleixing**  <br>*可选*|string|
|**Query**|**weimenbolidulikaiqi**  <br>*可选*|string|
|**Query**|**wendufenqukongzhi**  <br>*可选*|string|
|**Query**|**wuyaoshijinrugongneng**  <br>*可选*|string|
|**Query**|**wuyaoshiqidongxitong**  <br>*可选*|string|
|**Query**|**xianhuachasuqiChasusuo**  <br>*可选*|string|
|**Query**|**xiaoshouzhuangtai**  <br>*可选*|string|
|**Query**|**xibuqinang**  <br>*可选*|string|
|**Query**|**xingchediannaoxianshipingmu**  <br>*可选*|string|
|**Query**|**xingchengMm**  <br>*可选*|string|
|**Query**|**xinglixiang12vdianyuanjiekou**  <br>*可选*|string|
|**Query**|**xinglixiangrongjiL**  <br>*可选*|string|
|**Query**|**xitongzonghegonglvKw**  <br>*可选*|string|
|**Query**|**xitongzongheniujuNM**  <br>*可选*|string|
|**Query**|**xuanzhuangbao**  <br>*可选*|string|
|**Query**|**xunhangxitong**  <br>*可选*|string|
|**Query**|**yangshengqipinpaimingcheng**  <br>*可选*|string|
|**Query**|**yangshengqishuliang**  <br>*可选*|string|
|**Query**|**yaoshileixing**  <br>*可选*|string|
|**Query**|**yasuobi**  <br>*可选*|string|
|**Query**|**yejingyibiaochicun**  <br>*可选*|string|
|**Query**|**yeshixitong**  <br>*可选*|string|
|**Query**|**youxiangrongjiL**  <br>*可选*|string|
|**Query**|**yuanchengqidonggongneng**  <br>*可选*|string|
|**Query**|**yuanguangdengguangyuan**  <br>*可选*|string|
|**Query**|**yundongfenggezuoyi**  <br>*可选*|string|
|**Query**|**yundongwaiguantaojian**  <br>*可选*|string|
|**Query**|**yuyinshibiekongzhixitong**  <br>*可选*|string|
|**Query**|**zhengbeizhiliangKg**  <br>*可选*|string|
|**Query**|**zhengchezhibao**  <br>*可选*|string|
|**Query**|**zhengtizhudongzhuanxiangxitong**  <br>*可选*|string|
|**Query**|**zhidonglifenpeiEbdCbcdeng**  <br>*可选*|string|
|**Query**|**zhongkongcaiseyejingpingmu**  <br>*可选*|string|
|**Query**|**zhongkongyejingpingchicun**  <br>*可选*|string|
|**Query**|**zhongkongyejingpingfenpingxianshi**  <br>*可选*|string|
|**Query**|**zhongyangchasuqisuozhigongneng**  <br>*可选*|string|
|**Query**|**zhoujuMm**  <br>*可选*|string|
|**Query**|**zhuFujiashizuoanquanqinang**  <br>*可选*|string|
|**Query**|**zhuFujiashizuodiandongtiaojie**  <br>*可选*|string|
|**Query**|**zhuanxiangfuzhudeng**  <br>*可选*|string|
|**Query**|**zhuanxiangtoudeng**  <br>*可选*|string|
|**Query**|**zhuchezhidongleixing**  <br>*可选*|string|
|**Query**|**zhudongbiheshijinqigezha**  <br>*可选*|string|
|**Query**|**zhudongjiangzao**  <br>*可选*|string|
|**Query**|**zhudongshacheZhudonganquanxitong**  <br>*可选*|string|
|**Query**|**zhulileixing**  <br>*可选*|string|
|**Query**|**zhuzuoyitiaojiefangshi**  <br>*可选*|string|
|**Query**|**zidongbocheruwei**  <br>*可选*|string|
|**Query**|**zidongtoudeng**  <br>*可选*|string|
|**Query**|**zidongzhuche**  <br>*可选*|string|
|**Query**|**zishiyingyuanjinguang**  <br>*可选*|string|
|**Query**|**zuidagonglvKw**  <br>*可选*|string|
|**Query**|**zuidagonglvzhuansuRpm**  <br>*可选*|string|
|**Query**|**zuidamaliPs**  <br>*可选*|string|
|**Query**|**zuidaniujuNM**  <br>*可选*|string|
|**Query**|**zuidaniujuzhuansuRpm**  <br>*可选*|string|
|**Query**|**zuigaochesuKmH**  <br>*可选*|string|
|**Query**|**zuixiaolidijianxiMm**  <br>*可选*|string|
|**Query**|**zuoweishuGe**  <br>*可选*|string|
|**Query**|**zuoyibuju**  <br>*可选*|string|
|**Query**|**zuoyicaizhi**  <br>*可选*|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/vehicleInfo/getByEntity
```


###### 请求 query
```
json :
{
  "absfangbaosi" : "string",
  "anquandaiweixitixing" : "string",
  "baigonglihaodianliangKwh100km" : "string",
  "beidongxingrenbaohu" : "string",
  "beitaiguige" : "string",
  "biansuxiang" : "string",
  "biansuxiangleixing" : "string",
  "bingxianfuzhu" : "string",
  "cehuamenxingshi" : "string",
  "changduMm" : "string",
  "changkuangaoMm" : "string",
  "changshang" : "string",
  "changshangId" : "string",
  "changshangzhidaojia" : "string",
  "changshangzhidaojiaYuan" : "string",
  "checejiaotaban" : "string",
  "chechuangfangjiashougongneng" : "string",
  "chechuangyijianshengjianggongneng" : "string",
  "chedaobaochifuzhuxitong" : "string",
  "chedaopianliyujingxitong" : "string",
  "chedingxinglijia" : "string",
  "chelianwang" : "string",
  "chemenshuGe" : "string",
  "cheneihuanjingfenweideng" : "string",
  "cheneihuazhuangjing" : "string",
  "cheneipm25guolvzhuangzhi" : "string",
  "cheneixiangfenzhuangzhi" : "string",
  "cheneizhongkongsuo" : "string",
  "cheqianwudeng" : "string",
  "cheshenjiegou" : "string",
  "cheshenwendingkongzhiEscEspDscdeng" : "string",
  "chetijiegou" : "string",
  "chexi" : "string",
  "chexiId" : "string",
  "chexingId" : "string",
  "chexingmingcheng" : "string",
  "chexizhanshitu" : "string",
  "chezaibingxiang" : "string",
  "chezaicdDvd" : "string",
  "chezaidianshi" : "string",
  "chezaikongqijinghuaqi" : "string",
  "chumoshiyuedudeng" : "string",
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "dadenggaoduketiao" : "string",
  "dadengqingxizhuangzhi" : "string",
  "dadengyanshiguanbi" : "string",
  "dangweigeshu" : "string",
  "daochecheceyujingxitong" : "string",
  "daohanglukuangxinxixianshi" : "string",
  "daolujiaotongbiaozhishibie" : "string",
  "daolujiuyuanhujiao" : "string",
  "dengguangtesegongneng" : "string",
  "dianchileixing" : "string",
  "dianchirongliangKwh" : "string",
  "dianchizuzhibao" : "string",
  "dianciganyingxuanjia" : "string",
  "diandonghoubeixiang" : "string",
  "diandonghoubeixiangweizhijiyi" : "string",
  "diandongjizonggonglvKw" : "string",
  "diandongjizongniujuNM" : "string",
  "diandongketiaotaban" : "string",
  "diandongxihechemen" : "string",
  "diandongzuoyijiyigongneng" : "string",
  "dianjibuju" : "string",
  "dianjileixing" : "string",
  "dianyuan220v230v" : "string",
  "dierpaidulizuoyi" : "string",
  "dierpaizuoyitiaojie" : "string",
  "doupohuanjiang" : "string",
  "duocenggeyinboli" : "string",
  "duogongnengfangxiangpan" : "string",
  "fadongji" : "string",
  "fadongjidianzifangdao" : "string",
  "fadongjiqitingjishu" : "string",
  "fadongjiteyoujishu" : "string",
  "fadongjixinghao" : "string",
  "fangxiangpancaizhi" : "string",
  "fangxiangpanhuandang" : "string",
  "fangxiangpanjiare" : "string",
  "fangxiangpanjiyi" : "string",
  "fangxiangpanweizhitiaojie" : "string",
  "fangziwaixianboli" : "string",
  "fujiashiweihoupaiketiaojieanniu" : "string",
  "fulizifashengqi" : "string",
  "fuzuoyitiaojiefangshi" : "string",
  "ganggaicailiao" : "string",
  "gangjingMm" : "string",
  "gangticailiao" : "string",
  "ganyinghoubeixiang" : "string",
  "ganyingyushuagongneng" : "string",
  "gaoduMm" : "string",
  "gengxinshijian" : "string",
  "gongxinbuchundianxuhanglichengKm" : "string",
  "gongxinbuzongheyouhaoL100km" : "string",
  "gongyoufangshi" : "string",
  "gpsdaohangxitong" : "string",
  "guanfang0100kmHJiasuS" : "string",
  "houdiandongjizuidagonglvKw" : "string",
  "houdiandongjizuidaniujuNM" : "string",
  "houfengdangzheyanglian" : "string",
  "houlunjuMm" : "string",
  "houluntaiguige" : "string",
  "houpaianquandaishiqinang" : "string",
  "houpaibeijia" : "string",
  "houpaicechuangzheyanglian" : "string",
  "houpaiceyinsiboli" : "string",
  "houpaidulikongtiao" : "string",
  "houpaikongzhiduomeiti" : "string",
  "houpaixiaozhuoban" : "string",
  "houpaiyejingpingmu" : "string",
  "houpaizhongyanganquanqinang" : "string",
  "houpaizuoyidiandongfangdao" : "string",
  "houpaizuoyidiandongtiaojie" : "string",
  "houpaizuoyifangdaoxingshi" : "string",
  "houpaizuoyigongneng" : "string",
  "houxuanjialeixing" : "string",
  "houyushua" : "string",
  "houzhidongqileixing" : "string",
  "houzuochufengkou" : "string",
  "huanbaobiaozhun" : "string",
  "hudtaitoushuzixianshi" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "isofixertongzuoyijiekou" : "string",
  "jiancheng" : "string",
  "jiareZhilengbeijia" : "string",
  "jiashifuzhuyingxiang" : "string",
  "jiashimoshiqiehuan" : "string",
  "jibie" : "string",
  "jinguangdengguangyuan" : "string",
  "jinqixingshi" : "string",
  "kebianxuanjiagongneng" : "string",
  "kebianzhuanxiangbi" : "string",
  "kejiarepenshuizui" : "string",
  "kongqixuanjia" : "string",
  "kongtiaowendukongzhifangshi" : "string",
  "kuaichongdianliang" : "string",
  "kuaichongdianliangbaifenbi" : "string",
  "kuaichongshijianXiaoshi" : "string",
  "kuanduMm" : "string",
  "lanyaChezaidianhua" : "string",
  "lastUpdateDateTime" : 0,
  "ledrijianxingchedeng" : "string",
  "lingtaiyajixuxingshi" : "string",
  "lunquancaizhi" : "string",
  "manchongshijianXiaoshi" : "string",
  "meigangqimenshuGe" : "string",
  "neihoushijinggongneng" : "string",
  "neishiyanse" : "string",
  "neizhixingchejiluyi" : "string",
  "nengyuanleixing" : "string",
  "niankuan" : "string",
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "pailiangL" : "string",
  "pailiangMl" : "string",
  "peiqijigou" : "string",
  "pilaojiashitishi" : "string",
  "pinpai" : "string",
  "pinpaiId" : "string",
  "pinpaiLogo" : "string",
  "qianHoudiandongchechuang" : "string",
  "qianHoupaiceqinang" : "string",
  "qianHoupaitoubuqinangQilian" : "string",
  "qianHouzhongyangfushou" : "string",
  "qianHouzhucheleida" : "string",
  "qiandadengyuwumoshi" : "string",
  "qiandiandongjizuidagonglvKw" : "string",
  "qiandiandongjizuidaniujuNM" : "string",
  "qianlunjuMm" : "string",
  "qianluntaiguige" : "string",
  "qianpaizuoyigongneng" : "string",
  "qianxuanjialeixing" : "string",
  "qianyinlikongzhiAsrTcsTrcdeng" : "string",
  "qianzhidongqileixing" : "string",
  "qigangpailiexingshi" : "string",
  "qigangshuGe" : "string",
  "quanyejingyibiaopan" : "string",
  "qudongdianjishu" : "string",
  "qudongfangshi" : "string",
  "ranliaoxingshi" : "string",
  "ranyoubiaohao" : "string",
  "remarks" : "string",
  "shachefuzhuEbaBasBadeng" : "string",
  "shangpofuzhu" : "string",
  "shangshishijian" : "string",
  "sheshuiganyingxitong" : "string",
  "shice0100kmHJiasuS" : "string",
  "shice1000kmHZhidongM" : "string",
  "shicexuhanglichengKm" : "string",
  "shiceyouhaoL100km" : "string",
  "shoujihulianYingshe" : "string",
  "shoujiwuxianchongdiangongneng" : "string",
  "shoushikongzhi" : "string",
  "shouzimu" : "string",
  "status" : "string",
  "status_in" : "string",
  "taiyajiancegongneng" : "string",
  "tianchuangleixing" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string",
  "uploadDate" : "string",
  "usbTypeCjiekoushuliang" : "string",
  "waiguanyanse" : "string",
  "waihoushijinggongneng" : "string",
  "waijieyinyuanjiekouleixing" : "string",
  "weimenbolidulikaiqi" : "string",
  "wendufenqukongzhi" : "string",
  "wuyaoshijinrugongneng" : "string",
  "wuyaoshiqidongxitong" : "string",
  "xianhuachasuqiChasusuo" : "string",
  "xiaoshouzhuangtai" : "string",
  "xibuqinang" : "string",
  "xingchediannaoxianshipingmu" : "string",
  "xingchengMm" : "string",
  "xinglixiang12vdianyuanjiekou" : "string",
  "xinglixiangrongjiL" : "string",
  "xitongzonghegonglvKw" : "string",
  "xitongzongheniujuNM" : "string",
  "xuanzhuangbao" : "string",
  "xunhangxitong" : "string",
  "yangshengqipinpaimingcheng" : "string",
  "yangshengqishuliang" : "string",
  "yaoshileixing" : "string",
  "yasuobi" : "string",
  "yejingyibiaochicun" : "string",
  "yeshixitong" : "string",
  "youxiangrongjiL" : "string",
  "yuanchengqidonggongneng" : "string",
  "yuanguangdengguangyuan" : "string",
  "yundongfenggezuoyi" : "string",
  "yundongwaiguantaojian" : "string",
  "yuyinshibiekongzhixitong" : "string",
  "zhengbeizhiliangKg" : "string",
  "zhengchezhibao" : "string",
  "zhengtizhudongzhuanxiangxitong" : "string",
  "zhidonglifenpeiEbdCbcdeng" : "string",
  "zhongkongcaiseyejingpingmu" : "string",
  "zhongkongyejingpingchicun" : "string",
  "zhongkongyejingpingfenpingxianshi" : "string",
  "zhongyangchasuqisuozhigongneng" : "string",
  "zhoujuMm" : "string",
  "zhuFujiashizuoanquanqinang" : "string",
  "zhuFujiashizuodiandongtiaojie" : "string",
  "zhuanxiangfuzhudeng" : "string",
  "zhuanxiangtoudeng" : "string",
  "zhuchezhidongleixing" : "string",
  "zhudongbiheshijinqigezha" : "string",
  "zhudongjiangzao" : "string",
  "zhudongshacheZhudonganquanxitong" : "string",
  "zhulileixing" : "string",
  "zhuzuoyitiaojiefangshi" : "string",
  "zidongbocheruwei" : "string",
  "zidongtoudeng" : "string",
  "zidongzhuche" : "string",
  "zishiyingyuanjinguang" : "string",
  "zuidagonglvKw" : "string",
  "zuidagonglvzhuansuRpm" : "string",
  "zuidamaliPs" : "string",
  "zuidaniujuNM" : "string",
  "zuidaniujuzhuansuRpm" : "string",
  "zuigaochesuKmH" : "string",
  "zuixiaolidijianxiMm" : "string",
  "zuoweishuGe" : "string",
  "zuoyibuju" : "string",
  "zuoyicaizhi" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="getcarmodelusingpost"></a>
#### 根据车型id查部分常用属性
```
POST /common/vehicleInfo/getCarModel
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**chexingId**  <br>*必填*|车型id|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/vehicleInfo/getCarModel
```


###### 请求 query
```
json :
{
  "chexingId" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="importvehicleimageusingpost"></a>
#### 上传车的图片
```
POST /common/vehicleInfo/importVehicleImage
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**vehicleInfoId**  <br>*必填*|车的id|string|
|**FormData**|**image**  <br>*必填*|要上传的图片文件|ref|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `multipart/form-data`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/vehicleInfo/importVehicleImage
```


###### 请求 query
```
json :
{
  "vehicleInfoId" : "string"
}
```


###### 请求 formData
```
json :
"ref"
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="importvehicleimagesusingpost"></a>
#### 上传车的多个图片
```
POST /common/vehicleInfo/importVehicleImages
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**vehicleInfoId**  <br>*必填*|车的id|string|
|**FormData**|**image**  <br>*必填*|要上传的图片文件数组|ref|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/vehicleInfo/importVehicleImages
```


###### 请求 query
```
json :
{
  "vehicleInfoId" : "string"
}
```


###### 请求 formData
```
json :
"ref"
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="importvehicleinfosusingpost"></a>
#### 导入车的信息
```
POST /common/vehicleInfo/importVehicleInfos
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**FormData**|**file**  <br>*必填*|车型的excel文件|ref|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `multipart/form-data`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/vehicleInfo/importVehicleInfos
```


###### 请求 formData
```
json :
"ref"
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="listvehicleinfousingpost"></a>
#### 加载车的分页数据
```
POST /common/vehicleInfo/listVehicleInfo
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**absfangbaosi**  <br>*可选*|string|
|**Query**|**anquandaiweixitixing**  <br>*可选*|string|
|**Query**|**baigonglihaodianliangKwh100km**  <br>*可选*|string|
|**Query**|**beidongxingrenbaohu**  <br>*可选*|string|
|**Query**|**beitaiguige**  <br>*可选*|string|
|**Query**|**biansuxiang**  <br>*可选*|string|
|**Query**|**biansuxiangleixing**  <br>*可选*|string|
|**Query**|**bingxianfuzhu**  <br>*可选*|string|
|**Query**|**cehuamenxingshi**  <br>*可选*|string|
|**Query**|**changduMm**  <br>*可选*|string|
|**Query**|**changkuangaoMm**  <br>*可选*|string|
|**Query**|**changshang**  <br>*可选*|string|
|**Query**|**changshangId**  <br>*可选*|string|
|**Query**|**changshangzhidaojia**  <br>*可选*|string|
|**Query**|**changshangzhidaojiaYuan**  <br>*可选*|string|
|**Query**|**checejiaotaban**  <br>*可选*|string|
|**Query**|**chechuangfangjiashougongneng**  <br>*可选*|string|
|**Query**|**chechuangyijianshengjianggongneng**  <br>*可选*|string|
|**Query**|**chedaobaochifuzhuxitong**  <br>*可选*|string|
|**Query**|**chedaopianliyujingxitong**  <br>*可选*|string|
|**Query**|**chedingxinglijia**  <br>*可选*|string|
|**Query**|**chelianwang**  <br>*可选*|string|
|**Query**|**chemenshuGe**  <br>*可选*|string|
|**Query**|**cheneihuanjingfenweideng**  <br>*可选*|string|
|**Query**|**cheneihuazhuangjing**  <br>*可选*|string|
|**Query**|**cheneipm25guolvzhuangzhi**  <br>*可选*|string|
|**Query**|**cheneixiangfenzhuangzhi**  <br>*可选*|string|
|**Query**|**cheneizhongkongsuo**  <br>*可选*|string|
|**Query**|**cheqianwudeng**  <br>*可选*|string|
|**Query**|**cheshenjiegou**  <br>*可选*|string|
|**Query**|**cheshenwendingkongzhiEscEspDscdeng**  <br>*可选*|string|
|**Query**|**chetijiegou**  <br>*可选*|string|
|**Query**|**chexi**  <br>*可选*|string|
|**Query**|**chexiId**  <br>*可选*|string|
|**Query**|**chexingId**  <br>*可选*|string|
|**Query**|**chexingmingcheng**  <br>*可选*|string|
|**Query**|**chexizhanshitu**  <br>*可选*|string|
|**Query**|**chezaibingxiang**  <br>*可选*|string|
|**Query**|**chezaicdDvd**  <br>*可选*|string|
|**Query**|**chezaidianshi**  <br>*可选*|string|
|**Query**|**chezaikongqijinghuaqi**  <br>*可选*|string|
|**Query**|**chumoshiyuedudeng**  <br>*可选*|string|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**dadenggaoduketiao**  <br>*可选*|string|
|**Query**|**dadengqingxizhuangzhi**  <br>*可选*|string|
|**Query**|**dadengyanshiguanbi**  <br>*可选*|string|
|**Query**|**dangweigeshu**  <br>*可选*|string|
|**Query**|**daochecheceyujingxitong**  <br>*可选*|string|
|**Query**|**daohanglukuangxinxixianshi**  <br>*可选*|string|
|**Query**|**daolujiaotongbiaozhishibie**  <br>*可选*|string|
|**Query**|**daolujiuyuanhujiao**  <br>*可选*|string|
|**Query**|**dengguangtesegongneng**  <br>*可选*|string|
|**Query**|**dianchileixing**  <br>*可选*|string|
|**Query**|**dianchirongliangKwh**  <br>*可选*|string|
|**Query**|**dianchizuzhibao**  <br>*可选*|string|
|**Query**|**dianciganyingxuanjia**  <br>*可选*|string|
|**Query**|**diandonghoubeixiang**  <br>*可选*|string|
|**Query**|**diandonghoubeixiangweizhijiyi**  <br>*可选*|string|
|**Query**|**diandongjizonggonglvKw**  <br>*可选*|string|
|**Query**|**diandongjizongniujuNM**  <br>*可选*|string|
|**Query**|**diandongketiaotaban**  <br>*可选*|string|
|**Query**|**diandongxihechemen**  <br>*可选*|string|
|**Query**|**diandongzuoyijiyigongneng**  <br>*可选*|string|
|**Query**|**dianjibuju**  <br>*可选*|string|
|**Query**|**dianjileixing**  <br>*可选*|string|
|**Query**|**dianyuan220v230v**  <br>*可选*|string|
|**Query**|**dierpaidulizuoyi**  <br>*可选*|string|
|**Query**|**dierpaizuoyitiaojie**  <br>*可选*|string|
|**Query**|**doupohuanjiang**  <br>*可选*|string|
|**Query**|**duocenggeyinboli**  <br>*可选*|string|
|**Query**|**duogongnengfangxiangpan**  <br>*可选*|string|
|**Query**|**fadongji**  <br>*可选*|string|
|**Query**|**fadongjidianzifangdao**  <br>*可选*|string|
|**Query**|**fadongjiqitingjishu**  <br>*可选*|string|
|**Query**|**fadongjiteyoujishu**  <br>*可选*|string|
|**Query**|**fadongjixinghao**  <br>*可选*|string|
|**Query**|**fangxiangpancaizhi**  <br>*可选*|string|
|**Query**|**fangxiangpanhuandang**  <br>*可选*|string|
|**Query**|**fangxiangpanjiare**  <br>*可选*|string|
|**Query**|**fangxiangpanjiyi**  <br>*可选*|string|
|**Query**|**fangxiangpanweizhitiaojie**  <br>*可选*|string|
|**Query**|**fangziwaixianboli**  <br>*可选*|string|
|**Query**|**fujiashiweihoupaiketiaojieanniu**  <br>*可选*|string|
|**Query**|**fulizifashengqi**  <br>*可选*|string|
|**Query**|**fuzuoyitiaojiefangshi**  <br>*可选*|string|
|**Query**|**ganggaicailiao**  <br>*可选*|string|
|**Query**|**gangjingMm**  <br>*可选*|string|
|**Query**|**gangticailiao**  <br>*可选*|string|
|**Query**|**ganyinghoubeixiang**  <br>*可选*|string|
|**Query**|**ganyingyushuagongneng**  <br>*可选*|string|
|**Query**|**gaoduMm**  <br>*可选*|string|
|**Query**|**gengxinshijian**  <br>*可选*|string|
|**Query**|**gongxinbuchundianxuhanglichengKm**  <br>*可选*|string|
|**Query**|**gongxinbuzongheyouhaoL100km**  <br>*可选*|string|
|**Query**|**gongyoufangshi**  <br>*可选*|string|
|**Query**|**gpsdaohangxitong**  <br>*可选*|string|
|**Query**|**guanfang0100kmHJiasuS**  <br>*可选*|string|
|**Query**|**houdiandongjizuidagonglvKw**  <br>*可选*|string|
|**Query**|**houdiandongjizuidaniujuNM**  <br>*可选*|string|
|**Query**|**houfengdangzheyanglian**  <br>*可选*|string|
|**Query**|**houlunjuMm**  <br>*可选*|string|
|**Query**|**houluntaiguige**  <br>*可选*|string|
|**Query**|**houpaianquandaishiqinang**  <br>*可选*|string|
|**Query**|**houpaibeijia**  <br>*可选*|string|
|**Query**|**houpaicechuangzheyanglian**  <br>*可选*|string|
|**Query**|**houpaiceyinsiboli**  <br>*可选*|string|
|**Query**|**houpaidulikongtiao**  <br>*可选*|string|
|**Query**|**houpaikongzhiduomeiti**  <br>*可选*|string|
|**Query**|**houpaixiaozhuoban**  <br>*可选*|string|
|**Query**|**houpaiyejingpingmu**  <br>*可选*|string|
|**Query**|**houpaizhongyanganquanqinang**  <br>*可选*|string|
|**Query**|**houpaizuoyidiandongfangdao**  <br>*可选*|string|
|**Query**|**houpaizuoyidiandongtiaojie**  <br>*可选*|string|
|**Query**|**houpaizuoyifangdaoxingshi**  <br>*可选*|string|
|**Query**|**houpaizuoyigongneng**  <br>*可选*|string|
|**Query**|**houxuanjialeixing**  <br>*可选*|string|
|**Query**|**houyushua**  <br>*可选*|string|
|**Query**|**houzhidongqileixing**  <br>*可选*|string|
|**Query**|**houzuochufengkou**  <br>*可选*|string|
|**Query**|**huanbaobiaozhun**  <br>*可选*|string|
|**Query**|**hudtaitoushuzixianshi**  <br>*可选*|string|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**isofixertongzuoyijiekou**  <br>*可选*|string|
|**Query**|**jiancheng**  <br>*可选*|string|
|**Query**|**jiareZhilengbeijia**  <br>*可选*|string|
|**Query**|**jiashifuzhuyingxiang**  <br>*可选*|string|
|**Query**|**jiashimoshiqiehuan**  <br>*可选*|string|
|**Query**|**jibie**  <br>*可选*|string|
|**Query**|**jinguangdengguangyuan**  <br>*可选*|string|
|**Query**|**jinqixingshi**  <br>*可选*|string|
|**Query**|**kebianxuanjiagongneng**  <br>*可选*|string|
|**Query**|**kebianzhuanxiangbi**  <br>*可选*|string|
|**Query**|**kejiarepenshuizui**  <br>*可选*|string|
|**Query**|**kongqixuanjia**  <br>*可选*|string|
|**Query**|**kongtiaowendukongzhifangshi**  <br>*可选*|string|
|**Query**|**kuaichongdianliang**  <br>*可选*|string|
|**Query**|**kuaichongdianliangbaifenbi**  <br>*可选*|string|
|**Query**|**kuaichongshijianXiaoshi**  <br>*可选*|string|
|**Query**|**kuanduMm**  <br>*可选*|string|
|**Query**|**lanyaChezaidianhua**  <br>*可选*|string|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**ledrijianxingchedeng**  <br>*可选*|string|
|**Query**|**lingtaiyajixuxingshi**  <br>*可选*|string|
|**Query**|**lunquancaizhi**  <br>*可选*|string|
|**Query**|**manchongshijianXiaoshi**  <br>*可选*|string|
|**Query**|**meigangqimenshuGe**  <br>*可选*|string|
|**Query**|**neihoushijinggongneng**  <br>*可选*|string|
|**Query**|**neishiyanse**  <br>*可选*|string|
|**Query**|**neizhixingchejiluyi**  <br>*可选*|string|
|**Query**|**nengyuanleixing**  <br>*可选*|string|
|**Query**|**niankuan**  <br>*可选*|string|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**pailiangL**  <br>*可选*|string|
|**Query**|**pailiangMl**  <br>*可选*|string|
|**Query**|**peiqijigou**  <br>*可选*|string|
|**Query**|**pilaojiashitishi**  <br>*可选*|string|
|**Query**|**pinpai**  <br>*可选*|string|
|**Query**|**pinpaiId**  <br>*可选*|string|
|**Query**|**pinpaiLogo**  <br>*可选*|string|
|**Query**|**qianHoudiandongchechuang**  <br>*可选*|string|
|**Query**|**qianHoupaiceqinang**  <br>*可选*|string|
|**Query**|**qianHoupaitoubuqinangQilian**  <br>*可选*|string|
|**Query**|**qianHouzhongyangfushou**  <br>*可选*|string|
|**Query**|**qianHouzhucheleida**  <br>*可选*|string|
|**Query**|**qiandadengyuwumoshi**  <br>*可选*|string|
|**Query**|**qiandiandongjizuidagonglvKw**  <br>*可选*|string|
|**Query**|**qiandiandongjizuidaniujuNM**  <br>*可选*|string|
|**Query**|**qianlunjuMm**  <br>*可选*|string|
|**Query**|**qianluntaiguige**  <br>*可选*|string|
|**Query**|**qianpaizuoyigongneng**  <br>*可选*|string|
|**Query**|**qianxuanjialeixing**  <br>*可选*|string|
|**Query**|**qianyinlikongzhiAsrTcsTrcdeng**  <br>*可选*|string|
|**Query**|**qianzhidongqileixing**  <br>*可选*|string|
|**Query**|**qigangpailiexingshi**  <br>*可选*|string|
|**Query**|**qigangshuGe**  <br>*可选*|string|
|**Query**|**quanyejingyibiaopan**  <br>*可选*|string|
|**Query**|**qudongdianjishu**  <br>*可选*|string|
|**Query**|**qudongfangshi**  <br>*可选*|string|
|**Query**|**ranliaoxingshi**  <br>*可选*|string|
|**Query**|**ranyoubiaohao**  <br>*可选*|string|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**shachefuzhuEbaBasBadeng**  <br>*可选*|string|
|**Query**|**shangpofuzhu**  <br>*可选*|string|
|**Query**|**shangshishijian**  <br>*可选*|string|
|**Query**|**sheshuiganyingxitong**  <br>*可选*|string|
|**Query**|**shice0100kmHJiasuS**  <br>*可选*|string|
|**Query**|**shice1000kmHZhidongM**  <br>*可选*|string|
|**Query**|**shicexuhanglichengKm**  <br>*可选*|string|
|**Query**|**shiceyouhaoL100km**  <br>*可选*|string|
|**Query**|**shoujihulianYingshe**  <br>*可选*|string|
|**Query**|**shoujiwuxianchongdiangongneng**  <br>*可选*|string|
|**Query**|**shoushikongzhi**  <br>*可选*|string|
|**Query**|**shouzimu**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**taiyajiancegongneng**  <br>*可选*|string|
|**Query**|**tianchuangleixing**  <br>*可选*|string|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**uploadDate**  <br>*可选*|string|
|**Query**|**usbTypeCjiekoushuliang**  <br>*可选*|string|
|**Query**|**waiguanyanse**  <br>*可选*|string|
|**Query**|**waihoushijinggongneng**  <br>*可选*|string|
|**Query**|**waijieyinyuanjiekouleixing**  <br>*可选*|string|
|**Query**|**weimenbolidulikaiqi**  <br>*可选*|string|
|**Query**|**wendufenqukongzhi**  <br>*可选*|string|
|**Query**|**wuyaoshijinrugongneng**  <br>*可选*|string|
|**Query**|**wuyaoshiqidongxitong**  <br>*可选*|string|
|**Query**|**xianhuachasuqiChasusuo**  <br>*可选*|string|
|**Query**|**xiaoshouzhuangtai**  <br>*可选*|string|
|**Query**|**xibuqinang**  <br>*可选*|string|
|**Query**|**xingchediannaoxianshipingmu**  <br>*可选*|string|
|**Query**|**xingchengMm**  <br>*可选*|string|
|**Query**|**xinglixiang12vdianyuanjiekou**  <br>*可选*|string|
|**Query**|**xinglixiangrongjiL**  <br>*可选*|string|
|**Query**|**xitongzonghegonglvKw**  <br>*可选*|string|
|**Query**|**xitongzongheniujuNM**  <br>*可选*|string|
|**Query**|**xuanzhuangbao**  <br>*可选*|string|
|**Query**|**xunhangxitong**  <br>*可选*|string|
|**Query**|**yangshengqipinpaimingcheng**  <br>*可选*|string|
|**Query**|**yangshengqishuliang**  <br>*可选*|string|
|**Query**|**yaoshileixing**  <br>*可选*|string|
|**Query**|**yasuobi**  <br>*可选*|string|
|**Query**|**yejingyibiaochicun**  <br>*可选*|string|
|**Query**|**yeshixitong**  <br>*可选*|string|
|**Query**|**youxiangrongjiL**  <br>*可选*|string|
|**Query**|**yuanchengqidonggongneng**  <br>*可选*|string|
|**Query**|**yuanguangdengguangyuan**  <br>*可选*|string|
|**Query**|**yundongfenggezuoyi**  <br>*可选*|string|
|**Query**|**yundongwaiguantaojian**  <br>*可选*|string|
|**Query**|**yuyinshibiekongzhixitong**  <br>*可选*|string|
|**Query**|**zhengbeizhiliangKg**  <br>*可选*|string|
|**Query**|**zhengchezhibao**  <br>*可选*|string|
|**Query**|**zhengtizhudongzhuanxiangxitong**  <br>*可选*|string|
|**Query**|**zhidonglifenpeiEbdCbcdeng**  <br>*可选*|string|
|**Query**|**zhongkongcaiseyejingpingmu**  <br>*可选*|string|
|**Query**|**zhongkongyejingpingchicun**  <br>*可选*|string|
|**Query**|**zhongkongyejingpingfenpingxianshi**  <br>*可选*|string|
|**Query**|**zhongyangchasuqisuozhigongneng**  <br>*可选*|string|
|**Query**|**zhoujuMm**  <br>*可选*|string|
|**Query**|**zhuFujiashizuoanquanqinang**  <br>*可选*|string|
|**Query**|**zhuFujiashizuodiandongtiaojie**  <br>*可选*|string|
|**Query**|**zhuanxiangfuzhudeng**  <br>*可选*|string|
|**Query**|**zhuanxiangtoudeng**  <br>*可选*|string|
|**Query**|**zhuchezhidongleixing**  <br>*可选*|string|
|**Query**|**zhudongbiheshijinqigezha**  <br>*可选*|string|
|**Query**|**zhudongjiangzao**  <br>*可选*|string|
|**Query**|**zhudongshacheZhudonganquanxitong**  <br>*可选*|string|
|**Query**|**zhulileixing**  <br>*可选*|string|
|**Query**|**zhuzuoyitiaojiefangshi**  <br>*可选*|string|
|**Query**|**zidongbocheruwei**  <br>*可选*|string|
|**Query**|**zidongtoudeng**  <br>*可选*|string|
|**Query**|**zidongzhuche**  <br>*可选*|string|
|**Query**|**zishiyingyuanjinguang**  <br>*可选*|string|
|**Query**|**zuidagonglvKw**  <br>*可选*|string|
|**Query**|**zuidagonglvzhuansuRpm**  <br>*可选*|string|
|**Query**|**zuidamaliPs**  <br>*可选*|string|
|**Query**|**zuidaniujuNM**  <br>*可选*|string|
|**Query**|**zuidaniujuzhuansuRpm**  <br>*可选*|string|
|**Query**|**zuigaochesuKmH**  <br>*可选*|string|
|**Query**|**zuixiaolidijianxiMm**  <br>*可选*|string|
|**Query**|**zuoweishuGe**  <br>*可选*|string|
|**Query**|**zuoyibuju**  <br>*可选*|string|
|**Query**|**zuoyicaizhi**  <br>*可选*|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/vehicleInfo/listVehicleInfo
```


###### 请求 query
```
json :
{
  "absfangbaosi" : "string",
  "anquandaiweixitixing" : "string",
  "baigonglihaodianliangKwh100km" : "string",
  "beidongxingrenbaohu" : "string",
  "beitaiguige" : "string",
  "biansuxiang" : "string",
  "biansuxiangleixing" : "string",
  "bingxianfuzhu" : "string",
  "cehuamenxingshi" : "string",
  "changduMm" : "string",
  "changkuangaoMm" : "string",
  "changshang" : "string",
  "changshangId" : "string",
  "changshangzhidaojia" : "string",
  "changshangzhidaojiaYuan" : "string",
  "checejiaotaban" : "string",
  "chechuangfangjiashougongneng" : "string",
  "chechuangyijianshengjianggongneng" : "string",
  "chedaobaochifuzhuxitong" : "string",
  "chedaopianliyujingxitong" : "string",
  "chedingxinglijia" : "string",
  "chelianwang" : "string",
  "chemenshuGe" : "string",
  "cheneihuanjingfenweideng" : "string",
  "cheneihuazhuangjing" : "string",
  "cheneipm25guolvzhuangzhi" : "string",
  "cheneixiangfenzhuangzhi" : "string",
  "cheneizhongkongsuo" : "string",
  "cheqianwudeng" : "string",
  "cheshenjiegou" : "string",
  "cheshenwendingkongzhiEscEspDscdeng" : "string",
  "chetijiegou" : "string",
  "chexi" : "string",
  "chexiId" : "string",
  "chexingId" : "string",
  "chexingmingcheng" : "string",
  "chexizhanshitu" : "string",
  "chezaibingxiang" : "string",
  "chezaicdDvd" : "string",
  "chezaidianshi" : "string",
  "chezaikongqijinghuaqi" : "string",
  "chumoshiyuedudeng" : "string",
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "dadenggaoduketiao" : "string",
  "dadengqingxizhuangzhi" : "string",
  "dadengyanshiguanbi" : "string",
  "dangweigeshu" : "string",
  "daochecheceyujingxitong" : "string",
  "daohanglukuangxinxixianshi" : "string",
  "daolujiaotongbiaozhishibie" : "string",
  "daolujiuyuanhujiao" : "string",
  "dengguangtesegongneng" : "string",
  "dianchileixing" : "string",
  "dianchirongliangKwh" : "string",
  "dianchizuzhibao" : "string",
  "dianciganyingxuanjia" : "string",
  "diandonghoubeixiang" : "string",
  "diandonghoubeixiangweizhijiyi" : "string",
  "diandongjizonggonglvKw" : "string",
  "diandongjizongniujuNM" : "string",
  "diandongketiaotaban" : "string",
  "diandongxihechemen" : "string",
  "diandongzuoyijiyigongneng" : "string",
  "dianjibuju" : "string",
  "dianjileixing" : "string",
  "dianyuan220v230v" : "string",
  "dierpaidulizuoyi" : "string",
  "dierpaizuoyitiaojie" : "string",
  "doupohuanjiang" : "string",
  "duocenggeyinboli" : "string",
  "duogongnengfangxiangpan" : "string",
  "fadongji" : "string",
  "fadongjidianzifangdao" : "string",
  "fadongjiqitingjishu" : "string",
  "fadongjiteyoujishu" : "string",
  "fadongjixinghao" : "string",
  "fangxiangpancaizhi" : "string",
  "fangxiangpanhuandang" : "string",
  "fangxiangpanjiare" : "string",
  "fangxiangpanjiyi" : "string",
  "fangxiangpanweizhitiaojie" : "string",
  "fangziwaixianboli" : "string",
  "fujiashiweihoupaiketiaojieanniu" : "string",
  "fulizifashengqi" : "string",
  "fuzuoyitiaojiefangshi" : "string",
  "ganggaicailiao" : "string",
  "gangjingMm" : "string",
  "gangticailiao" : "string",
  "ganyinghoubeixiang" : "string",
  "ganyingyushuagongneng" : "string",
  "gaoduMm" : "string",
  "gengxinshijian" : "string",
  "gongxinbuchundianxuhanglichengKm" : "string",
  "gongxinbuzongheyouhaoL100km" : "string",
  "gongyoufangshi" : "string",
  "gpsdaohangxitong" : "string",
  "guanfang0100kmHJiasuS" : "string",
  "houdiandongjizuidagonglvKw" : "string",
  "houdiandongjizuidaniujuNM" : "string",
  "houfengdangzheyanglian" : "string",
  "houlunjuMm" : "string",
  "houluntaiguige" : "string",
  "houpaianquandaishiqinang" : "string",
  "houpaibeijia" : "string",
  "houpaicechuangzheyanglian" : "string",
  "houpaiceyinsiboli" : "string",
  "houpaidulikongtiao" : "string",
  "houpaikongzhiduomeiti" : "string",
  "houpaixiaozhuoban" : "string",
  "houpaiyejingpingmu" : "string",
  "houpaizhongyanganquanqinang" : "string",
  "houpaizuoyidiandongfangdao" : "string",
  "houpaizuoyidiandongtiaojie" : "string",
  "houpaizuoyifangdaoxingshi" : "string",
  "houpaizuoyigongneng" : "string",
  "houxuanjialeixing" : "string",
  "houyushua" : "string",
  "houzhidongqileixing" : "string",
  "houzuochufengkou" : "string",
  "huanbaobiaozhun" : "string",
  "hudtaitoushuzixianshi" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "isofixertongzuoyijiekou" : "string",
  "jiancheng" : "string",
  "jiareZhilengbeijia" : "string",
  "jiashifuzhuyingxiang" : "string",
  "jiashimoshiqiehuan" : "string",
  "jibie" : "string",
  "jinguangdengguangyuan" : "string",
  "jinqixingshi" : "string",
  "kebianxuanjiagongneng" : "string",
  "kebianzhuanxiangbi" : "string",
  "kejiarepenshuizui" : "string",
  "kongqixuanjia" : "string",
  "kongtiaowendukongzhifangshi" : "string",
  "kuaichongdianliang" : "string",
  "kuaichongdianliangbaifenbi" : "string",
  "kuaichongshijianXiaoshi" : "string",
  "kuanduMm" : "string",
  "lanyaChezaidianhua" : "string",
  "lastUpdateDateTime" : 0,
  "ledrijianxingchedeng" : "string",
  "lingtaiyajixuxingshi" : "string",
  "lunquancaizhi" : "string",
  "manchongshijianXiaoshi" : "string",
  "meigangqimenshuGe" : "string",
  "neihoushijinggongneng" : "string",
  "neishiyanse" : "string",
  "neizhixingchejiluyi" : "string",
  "nengyuanleixing" : "string",
  "niankuan" : "string",
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "pailiangL" : "string",
  "pailiangMl" : "string",
  "peiqijigou" : "string",
  "pilaojiashitishi" : "string",
  "pinpai" : "string",
  "pinpaiId" : "string",
  "pinpaiLogo" : "string",
  "qianHoudiandongchechuang" : "string",
  "qianHoupaiceqinang" : "string",
  "qianHoupaitoubuqinangQilian" : "string",
  "qianHouzhongyangfushou" : "string",
  "qianHouzhucheleida" : "string",
  "qiandadengyuwumoshi" : "string",
  "qiandiandongjizuidagonglvKw" : "string",
  "qiandiandongjizuidaniujuNM" : "string",
  "qianlunjuMm" : "string",
  "qianluntaiguige" : "string",
  "qianpaizuoyigongneng" : "string",
  "qianxuanjialeixing" : "string",
  "qianyinlikongzhiAsrTcsTrcdeng" : "string",
  "qianzhidongqileixing" : "string",
  "qigangpailiexingshi" : "string",
  "qigangshuGe" : "string",
  "quanyejingyibiaopan" : "string",
  "qudongdianjishu" : "string",
  "qudongfangshi" : "string",
  "ranliaoxingshi" : "string",
  "ranyoubiaohao" : "string",
  "remarks" : "string",
  "shachefuzhuEbaBasBadeng" : "string",
  "shangpofuzhu" : "string",
  "shangshishijian" : "string",
  "sheshuiganyingxitong" : "string",
  "shice0100kmHJiasuS" : "string",
  "shice1000kmHZhidongM" : "string",
  "shicexuhanglichengKm" : "string",
  "shiceyouhaoL100km" : "string",
  "shoujihulianYingshe" : "string",
  "shoujiwuxianchongdiangongneng" : "string",
  "shoushikongzhi" : "string",
  "shouzimu" : "string",
  "status" : "string",
  "status_in" : "string",
  "taiyajiancegongneng" : "string",
  "tianchuangleixing" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string",
  "uploadDate" : "string",
  "usbTypeCjiekoushuliang" : "string",
  "waiguanyanse" : "string",
  "waihoushijinggongneng" : "string",
  "waijieyinyuanjiekouleixing" : "string",
  "weimenbolidulikaiqi" : "string",
  "wendufenqukongzhi" : "string",
  "wuyaoshijinrugongneng" : "string",
  "wuyaoshiqidongxitong" : "string",
  "xianhuachasuqiChasusuo" : "string",
  "xiaoshouzhuangtai" : "string",
  "xibuqinang" : "string",
  "xingchediannaoxianshipingmu" : "string",
  "xingchengMm" : "string",
  "xinglixiang12vdianyuanjiekou" : "string",
  "xinglixiangrongjiL" : "string",
  "xitongzonghegonglvKw" : "string",
  "xitongzongheniujuNM" : "string",
  "xuanzhuangbao" : "string",
  "xunhangxitong" : "string",
  "yangshengqipinpaimingcheng" : "string",
  "yangshengqishuliang" : "string",
  "yaoshileixing" : "string",
  "yasuobi" : "string",
  "yejingyibiaochicun" : "string",
  "yeshixitong" : "string",
  "youxiangrongjiL" : "string",
  "yuanchengqidonggongneng" : "string",
  "yuanguangdengguangyuan" : "string",
  "yundongfenggezuoyi" : "string",
  "yundongwaiguantaojian" : "string",
  "yuyinshibiekongzhixitong" : "string",
  "zhengbeizhiliangKg" : "string",
  "zhengchezhibao" : "string",
  "zhengtizhudongzhuanxiangxitong" : "string",
  "zhidonglifenpeiEbdCbcdeng" : "string",
  "zhongkongcaiseyejingpingmu" : "string",
  "zhongkongyejingpingchicun" : "string",
  "zhongkongyejingpingfenpingxianshi" : "string",
  "zhongyangchasuqisuozhigongneng" : "string",
  "zhoujuMm" : "string",
  "zhuFujiashizuoanquanqinang" : "string",
  "zhuFujiashizuodiandongtiaojie" : "string",
  "zhuanxiangfuzhudeng" : "string",
  "zhuanxiangtoudeng" : "string",
  "zhuchezhidongleixing" : "string",
  "zhudongbiheshijinqigezha" : "string",
  "zhudongjiangzao" : "string",
  "zhudongshacheZhudonganquanxitong" : "string",
  "zhulileixing" : "string",
  "zhuzuoyitiaojiefangshi" : "string",
  "zidongbocheruwei" : "string",
  "zidongtoudeng" : "string",
  "zidongzhuche" : "string",
  "zishiyingyuanjinguang" : "string",
  "zuidagonglvKw" : "string",
  "zuidagonglvzhuansuRpm" : "string",
  "zuidamaliPs" : "string",
  "zuidaniujuNM" : "string",
  "zuidaniujuzhuansuRpm" : "string",
  "zuigaochesuKmH" : "string",
  "zuixiaolidijianxiMm" : "string",
  "zuoweishuGe" : "string",
  "zuoyibuju" : "string",
  "zuoyicaizhi" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="loadcardetailusingpost"></a>
#### 根据车型id加载一些相关属性
```
POST /common/vehicleInfo/loadCarDetail
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**chexingId**  <br>*必填*|车型id|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/vehicleInfo/loadCarDetail
```


###### 请求 query
```
json :
{
  "chexingId" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="loadcarlistusingpost"></a>
#### 根据品牌id，车系id，年款，加载一些特定的属性
```
POST /common/vehicleInfo/loadCarList
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**chexiId**  <br>*必填*|车系id|string|
|**Query**|**pinpaiId**  <br>*必填*|品牌id|string|
|**Query**|**year**  <br>*必填*|年款|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/vehicleInfo/loadCarList
```


###### 请求 query
```
json :
{
  "chexiId" : "string",
  "pinpaiId" : "string",
  "year" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="loadcarmodellistusingpost"></a>
#### 根据车系id加载对应的车型id集合
```
POST /common/vehicleInfo/loadCarModelList
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**chexiId**  <br>*必填*|车系id|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/vehicleInfo/loadCarModelList
```


###### 请求 query
```
json :
{
  "chexiId" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="loadvehicleimagesusingpost"></a>
#### 加载车的所有图片信息
```
POST /common/vehicleInfo/loadVehicleImages
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**id**  <br>*必填*|车的id|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/vehicleInfo/loadVehicleImages
```


###### 请求 query
```
json :
{
  "id" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="vehicle-series-controller_resource"></a>
### Vehicle-series-controller
Vehicle Series Controller


<a name="listusingpost_32"></a>
#### list
```
POST /common/vehicleSeries
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**changshang**  <br>*可选*|string|
|**Query**|**changshangId**  <br>*可选*|string|
|**Query**|**chexi**  <br>*可选*|string|
|**Query**|**chexiId**  <br>*可选*|string|
|**Query**|**chexizhanshitu**  <br>*可选*|string|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**gengxinshijian**  <br>*可选*|string|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**pinpaiId**  <br>*可选*|string|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**shouzimu**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**zuidizhidaojiaWan**  <br>*可选*|string|
|**Query**|**zuigaozhidaojiaWan**  <br>*可选*|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|string|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/vehicleSeries
```


###### 请求 query
```
json :
{
  "changshang" : "string",
  "changshangId" : "string",
  "chexi" : "string",
  "chexiId" : "string",
  "chexizhanshitu" : "string",
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "gengxinshijian" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "pinpaiId" : "string",
  "remarks" : "string",
  "shouzimu" : "string",
  "status" : "string",
  "status_in" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string",
  "zuidizhidaojiaWan" : "string",
  "zuigaozhidaojiaWan" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
"string"
```


<a name="deleteusingpost_21"></a>
#### delete
```
POST /common/vehicleSeries/delete
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**changshang**  <br>*可选*|string|
|**Query**|**changshangId**  <br>*可选*|string|
|**Query**|**chexi**  <br>*可选*|string|
|**Query**|**chexiId**  <br>*可选*|string|
|**Query**|**chexizhanshitu**  <br>*可选*|string|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**gengxinshijian**  <br>*可选*|string|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**pinpaiId**  <br>*可选*|string|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**shouzimu**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**zuidizhidaojiaWan**  <br>*可选*|string|
|**Query**|**zuigaozhidaojiaWan**  <br>*可选*|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|string|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/vehicleSeries/delete
```


###### 请求 query
```
json :
{
  "changshang" : "string",
  "changshangId" : "string",
  "chexi" : "string",
  "chexiId" : "string",
  "chexizhanshitu" : "string",
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "gengxinshijian" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "pinpaiId" : "string",
  "remarks" : "string",
  "shouzimu" : "string",
  "status" : "string",
  "status_in" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string",
  "zuidizhidaojiaWan" : "string",
  "zuigaozhidaojiaWan" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
"string"
```


<a name="findlistusingpost_2"></a>
#### findList
```
POST /common/vehicleSeries/findList
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**pinpaiId**  <br>*可选*|pinpaiId|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/vehicleSeries/findList
```


###### 请求 query
```
json :
{
  "pinpaiId" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="formusingpost_23"></a>
#### form
```
POST /common/vehicleSeries/form
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**changshang**  <br>*可选*|string|
|**Query**|**changshangId**  <br>*可选*|string|
|**Query**|**chexi**  <br>*可选*|string|
|**Query**|**chexiId**  <br>*可选*|string|
|**Query**|**chexizhanshitu**  <br>*可选*|string|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**gengxinshijian**  <br>*可选*|string|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**pinpaiId**  <br>*可选*|string|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**shouzimu**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**zuidizhidaojiaWan**  <br>*可选*|string|
|**Query**|**zuigaozhidaojiaWan**  <br>*可选*|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|string|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/vehicleSeries/form
```


###### 请求 query
```
json :
{
  "changshang" : "string",
  "changshangId" : "string",
  "chexi" : "string",
  "chexiId" : "string",
  "chexizhanshitu" : "string",
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "gengxinshijian" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "pinpaiId" : "string",
  "remarks" : "string",
  "shouzimu" : "string",
  "status" : "string",
  "status_in" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string",
  "zuidizhidaojiaWan" : "string",
  "zuigaozhidaojiaWan" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
"string"
```


<a name="getbyentityusingpost_2"></a>
#### getByEntity
```
POST /common/vehicleSeries/getByEntity
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**changshang**  <br>*可选*|string|
|**Query**|**changshangId**  <br>*可选*|string|
|**Query**|**chexi**  <br>*可选*|string|
|**Query**|**chexiId**  <br>*可选*|string|
|**Query**|**chexizhanshitu**  <br>*可选*|string|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**gengxinshijian**  <br>*可选*|string|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**pinpaiId**  <br>*可选*|string|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**shouzimu**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**zuidizhidaojiaWan**  <br>*可选*|string|
|**Query**|**zuigaozhidaojiaWan**  <br>*可选*|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[CommonResult](#commonresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/vehicleSeries/getByEntity
```


###### 请求 query
```
json :
{
  "changshang" : "string",
  "changshangId" : "string",
  "chexi" : "string",
  "chexiId" : "string",
  "chexizhanshitu" : "string",
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "gengxinshijian" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "pinpaiId" : "string",
  "remarks" : "string",
  "shouzimu" : "string",
  "status" : "string",
  "status_in" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string",
  "zuidizhidaojiaWan" : "string",
  "zuigaozhidaojiaWan" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "msg" : "string"
}
```


<a name="listusingpost_33"></a>
#### list
```
POST /common/vehicleSeries/list
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**changshang**  <br>*可选*|string|
|**Query**|**changshangId**  <br>*可选*|string|
|**Query**|**chexi**  <br>*可选*|string|
|**Query**|**chexiId**  <br>*可选*|string|
|**Query**|**chexizhanshitu**  <br>*可选*|string|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**gengxinshijian**  <br>*可选*|string|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**pinpaiId**  <br>*可选*|string|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**shouzimu**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**zuidizhidaojiaWan**  <br>*可选*|string|
|**Query**|**zuigaozhidaojiaWan**  <br>*可选*|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|string|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/vehicleSeries/list
```


###### 请求 query
```
json :
{
  "changshang" : "string",
  "changshangId" : "string",
  "chexi" : "string",
  "chexiId" : "string",
  "chexizhanshitu" : "string",
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "gengxinshijian" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "pinpaiId" : "string",
  "remarks" : "string",
  "shouzimu" : "string",
  "status" : "string",
  "status_in" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string",
  "zuidizhidaojiaWan" : "string",
  "zuigaozhidaojiaWan" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
"string"
```


<a name="listdatausingpost_25"></a>
#### listData
```
POST /common/vehicleSeries/listData
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**changshang**  <br>*可选*|string|
|**Query**|**changshangId**  <br>*可选*|string|
|**Query**|**chexi**  <br>*可选*|string|
|**Query**|**chexiId**  <br>*可选*|string|
|**Query**|**chexizhanshitu**  <br>*可选*|string|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**gengxinshijian**  <br>*可选*|string|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**pinpaiId**  <br>*可选*|string|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**shouzimu**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**zuidizhidaojiaWan**  <br>*可选*|string|
|**Query**|**zuigaozhidaojiaWan**  <br>*可选*|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[Page«VehicleSeries»](#dfcf9f2e2c379bbf68a5d3d83af3e237)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/vehicleSeries/listData
```


###### 请求 query
```
json :
{
  "changshang" : "string",
  "changshangId" : "string",
  "chexi" : "string",
  "chexiId" : "string",
  "chexizhanshitu" : "string",
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "gengxinshijian" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "pinpaiId" : "string",
  "remarks" : "string",
  "shouzimu" : "string",
  "status" : "string",
  "status_in" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string",
  "zuidizhidaojiaWan" : "string",
  "zuigaozhidaojiaWan" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "count" : 0,
  "list" : [ {
    "changshang" : "string",
    "changshangId" : "string",
    "chexi" : "string",
    "chexiId" : "string",
    "chexizhanshitu" : "string",
    "createBy" : "string",
    "createByName" : "string",
    "createDate" : "string",
    "createDate_between" : "string",
    "createDate_gte" : "string",
    "createDate_lte" : "string",
    "gengxinshijian" : "string",
    "id" : "string",
    "id_in" : [ "string" ],
    "isNewRecord" : true,
    "lastUpdateDateTime" : 0,
    "orderBy" : "string",
    "pageNo" : 0,
    "pageSize" : 0,
    "pinpaiId" : "string",
    "remarks" : "string",
    "shouzimu" : "string",
    "status" : "string",
    "status_in" : [ "string" ],
    "updateBy" : "string",
    "updateByName" : "string",
    "updateDate" : "string",
    "updateDate_between" : "string",
    "updateDate_gte" : "string",
    "updateDate_lte" : "string",
    "zuidizhidaojiaWan" : "string",
    "zuigaozhidaojiaWan" : "string"
  } ],
  "otherData" : "object",
  "pageNo" : 0,
  "pageSize" : 0
}
```


<a name="saveusingpost_22"></a>
#### save
```
POST /common/vehicleSeries/save
```


##### 参数

|类型|名称|类型|
|---|---|---|
|**Query**|**changshang**  <br>*可选*|string|
|**Query**|**changshangId**  <br>*可选*|string|
|**Query**|**chexi**  <br>*可选*|string|
|**Query**|**chexiId**  <br>*可选*|string|
|**Query**|**chexizhanshitu**  <br>*可选*|string|
|**Query**|**createBy**  <br>*可选*|string|
|**Query**|**createByName**  <br>*可选*|string|
|**Query**|**createDate**  <br>*可选*|string (date-time)|
|**Query**|**createDate_between**  <br>*可选*|string|
|**Query**|**createDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**createDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**gengxinshijian**  <br>*可选*|string|
|**Query**|**id**  <br>*可选*|string|
|**Query**|**id_in**  <br>*可选*|< string > array(multi)|
|**Query**|**isNewRecord**  <br>*可选*|boolean|
|**Query**|**lastUpdateDateTime**  <br>*可选*|integer (int64)|
|**Query**|**orderBy**  <br>*可选*|string|
|**Query**|**pageNo**  <br>*可选*|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|integer (int32)|
|**Query**|**pinpaiId**  <br>*可选*|string|
|**Query**|**remarks**  <br>*可选*|string|
|**Query**|**shouzimu**  <br>*可选*|string|
|**Query**|**status**  <br>*可选*|string|
|**Query**|**status_in**  <br>*可选*|< string > array(multi)|
|**Query**|**updateBy**  <br>*可选*|string|
|**Query**|**updateByName**  <br>*可选*|string|
|**Query**|**updateDate**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_between**  <br>*可选*|string|
|**Query**|**updateDate_gte**  <br>*可选*|string (date-time)|
|**Query**|**updateDate_lte**  <br>*可选*|string (date-time)|
|**Query**|**zuidizhidaojiaWan**  <br>*可选*|string|
|**Query**|**zuigaozhidaojiaWan**  <br>*可选*|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|string|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/common/vehicleSeries/save
```


###### 请求 query
```
json :
{
  "changshang" : "string",
  "changshangId" : "string",
  "chexi" : "string",
  "chexiId" : "string",
  "chexizhanshitu" : "string",
  "createBy" : "string",
  "createByName" : "string",
  "createDate" : "string",
  "createDate_between" : "string",
  "createDate_gte" : "string",
  "createDate_lte" : "string",
  "gengxinshijian" : "string",
  "id" : "string",
  "id_in" : "string",
  "isNewRecord" : true,
  "lastUpdateDateTime" : 0,
  "orderBy" : "string",
  "pageNo" : 0,
  "pageSize" : 0,
  "pinpaiId" : "string",
  "remarks" : "string",
  "shouzimu" : "string",
  "status" : "string",
  "status_in" : "string",
  "updateBy" : "string",
  "updateByName" : "string",
  "updateDate" : "string",
  "updateDate_between" : "string",
  "updateDate_gte" : "string",
  "updateDate_lte" : "string",
  "zuidizhidaojiaWan" : "string",
  "zuigaozhidaojiaWan" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
"string"
```




<a name="definitions"></a>
## 定义

<a name="commonresult"></a>
### CommonResult

|名称|说明|类型|
|---|---|---|
|**code**  <br>*可选*|**样例** : `"string"`|string|
|**data**  <br>*可选*|**样例** : `"object"`|object|
|**msg**  <br>*可选*|**样例** : `"string"`|string|


<a name="08c674bdd020f091601eefe307bf3944"></a>
### CommonResult«CommonUser»

|名称|说明|类型|
|---|---|---|
|**code**  <br>*可选*|**样例** : `"string"`|string|
|**data**  <br>*可选*|**样例** : `"[commonuser](#commonuser)"`|[CommonUser](#commonuser)|
|**msg**  <br>*可选*|**样例** : `"string"`|string|


<a name="f0636d91bfa680c920a4dac808e45068"></a>
### CommonResult«ExamUserListAndOtherInfoVO»

|名称|说明|类型|
|---|---|---|
|**code**  <br>*可选*|**样例** : `"string"`|string|
|**data**  <br>*可选*|**样例** : `"[examuserlistandotherinfovo](#examuserlistandotherinfovo)"`|[ExamUserListAndOtherInfoVO](#examuserlistandotherinfovo)|
|**msg**  <br>*可选*|**样例** : `"string"`|string|


<a name="7eeb81d7f6a904b10acc8c8c8b8b1d28"></a>
### CommonResult«JSONObject»

|名称|说明|类型|
|---|---|---|
|**code**  <br>*可选*|**样例** : `"string"`|string|
|**data**  <br>*可选*|**样例** : `{<br>  "string" : "object"<br>}`|< string, object > map|
|**msg**  <br>*可选*|**样例** : `"string"`|string|


<a name="72ddcea55610fef5e9c0ed66247d7df2"></a>
### CommonResult«List«CommonUser»»

|名称|说明|类型|
|---|---|---|
|**code**  <br>*可选*|**样例** : `"string"`|string|
|**data**  <br>*可选*|**样例** : `[ "[commonuser](#commonuser)" ]`|< [CommonUser](#commonuser) > array|
|**msg**  <br>*可选*|**样例** : `"string"`|string|


<a name="88292ec8d20348f5849ceda64b4b1d0b"></a>
### CommonResult«List«string»»

|名称|说明|类型|
|---|---|---|
|**code**  <br>*可选*|**样例** : `"string"`|string|
|**data**  <br>*可选*|**样例** : `[ "string" ]`|< string > array|
|**msg**  <br>*可选*|**样例** : `"string"`|string|


<a name="commonuser"></a>
### CommonUser

|名称|说明|类型|
|---|---|---|
|**className**  <br>*可选*|**样例** : `"string"`|string|
|**commonAssessmentStuId**  <br>*可选*|**样例** : `"string"`|string|
|**createBy**  <br>*可选*|**样例** : `"string"`|string|
|**createByName**  <br>*可选*|**样例** : `"string"`|string|
|**createDate**  <br>*可选*|**样例** : `"string"`|string (date-time)|
|**createDate_between**  <br>*可选*|**样例** : `"string"`|string|
|**createDate_gte**  <br>*可选*|**样例** : `"string"`|string (date-time)|
|**createDate_lte**  <br>*可选*|**样例** : `"string"`|string (date-time)|
|**gender**  <br>*可选*|**样例** : `"string"`|string|
|**id**  <br>*可选*|**样例** : `"string"`|string|
|**id_in**  <br>*可选*|**样例** : `[ "string" ]`|< string > array|
|**isExamRight**  <br>*可选*|**样例** : `"string"`|string|
|**isNewRecord**  <br>*可选*|**样例** : `true`|boolean|
|**lastUpdateDateTime**  <br>*可选*|**样例** : `0`|integer (int64)|
|**majorName**  <br>*可选*|**样例** : `"string"`|string|
|**orderBy**  <br>*可选*|**样例** : `"string"`|string|
|**pageNo**  <br>*可选*|**样例** : `0`|integer (int32)|
|**pageSize**  <br>*可选*|**样例** : `0`|integer (int32)|
|**password**  <br>*可选*|**样例** : `"string"`|string|
|**phoneNum**  <br>*可选*|**样例** : `"string"`|string|
|**remarks**  <br>*可选*|**样例** : `"string"`|string|
|**roleArray**  <br>*可选*|**样例** : `"string"`|string|
|**roleId**  <br>*可选*|**样例** : `"string"`|string|
|**schoolId**  <br>*可选*|**样例** : `"string"`|string|
|**schoolName**  <br>*可选*|**样例** : `"string"`|string|
|**status**  <br>*可选*|**样例** : `"string"`|string|
|**status_in**  <br>*可选*|**样例** : `[ "string" ]`|< string > array|
|**token**  <br>*可选*|**样例** : `"string"`|string|
|**trueName**  <br>*可选*|**样例** : `"string"`|string|
|**type**  <br>*可选*|**样例** : `"string"`|string|
|**updateBy**  <br>*可选*|**样例** : `"string"`|string|
|**updateByName**  <br>*可选*|**样例** : `"string"`|string|
|**updateDate**  <br>*可选*|**样例** : `"string"`|string (date-time)|
|**updateDate_between**  <br>*可选*|**样例** : `"string"`|string|
|**updateDate_gte**  <br>*可选*|**样例** : `"string"`|string (date-time)|
|**updateDate_lte**  <br>*可选*|**样例** : `"string"`|string (date-time)|
|**userName**  <br>*可选*|**样例** : `"string"`|string|


<a name="examuserlistandotherinfovo"></a>
### ExamUserListAndOtherInfoVO

|名称|说明|类型|
|---|---|---|
|**assessmentDate**  <br>*可选*|**样例** : `"string"`|string|
|**assessmentDateList**  <br>*可选*|**样例** : `[ "string" ]`|< string > array|
|**assessmentName**  <br>*可选*|**样例** : `"string"`|string|
|**assessmentNameList**  <br>*可选*|**样例** : `[ "string" ]`|< string > array|
|**assessmentTime**  <br>*可选*|**样例** : `"string"`|string|
|**assessmentTimeList**  <br>*可选*|**样例** : `[ "string" ]`|< string > array|
|**clsName**  <br>*可选*|**样例** : `"string"`|string|
|**clsNameList**  <br>*可选*|**样例** : `[ "string" ]`|< string > array|
|**list**  <br>*可选*|**样例** : `[ "[commonuser](#commonuser)" ]`|< [CommonUser](#commonuser) > array|
|**majorName**  <br>*可选*|**样例** : `"string"`|string|
|**majorNameList**  <br>*可选*|**样例** : `[ "string" ]`|< string > array|


<a name="jsonobject"></a>
### JSONObject
*类型* : < string, object > map


<a name="maintenance"></a>
### Maintenance

|名称|说明|类型|
|---|---|---|
|**brand**  <br>*可选*|**样例** : `"string"`|string|
|**carComponentRecordsFlag**  <br>*可选*|**样例** : `"string"`|string|
|**carConstructRecordsFlag**  <br>*可选*|**样例** : `"string"`|string|
|**carFireFlag**  <br>*可选*|**样例** : `"string"`|string|
|**carOutsideRecordsFlag**  <br>*可选*|**样例** : `"string"`|string|
|**carWaterFlag**  <br>*可选*|**样例** : `"string"`|string|
|**createBy**  <br>*可选*|**样例** : `"string"`|string|
|**createByName**  <br>*可选*|**样例** : `"string"`|string|
|**createDate**  <br>*可选*|**样例** : `"string"`|string (date-time)|
|**createDate_between**  <br>*可选*|**样例** : `"string"`|string|
|**createDate_gte**  <br>*可选*|**样例** : `"string"`|string (date-time)|
|**createDate_lte**  <br>*可选*|**样例** : `"string"`|string (date-time)|
|**displacement**  <br>*可选*|**样例** : `"string"`|string|
|**effluentStandard**  <br>*可选*|**样例** : `"string"`|string|
|**id**  <br>*可选*|**样例** : `"string"`|string|
|**id_in**  <br>*可选*|**样例** : `[ "string" ]`|< string > array|
|**isNewRecord**  <br>*可选*|**样例** : `true`|boolean|
|**lastMainTainTime**  <br>*可选*|**样例** : `"string"`|string|
|**lastRepairTime**  <br>*可选*|**样例** : `"string"`|string|
|**lastUpdateDateTime**  <br>*可选*|**样例** : `0`|integer (int64)|
|**mainTainTimes**  <br>*可选*|**样例** : `"string"`|string|
|**makeDate**  <br>*可选*|**样例** : `"string"`|string|
|**manufacturer**  <br>*可选*|**样例** : `"string"`|string|
|**mileageEstimate**  <br>*可选*|**样例** : `"string"`|string|
|**mileageEveryYear**  <br>*可选*|**样例** : `"string"`|string|
|**mileageIsNormalFlag**  <br>*可选*|**样例** : `"string"`|string|
|**modelName**  <br>*可选*|**样例** : `"string"`|string|
|**orderBy**  <br>*可选*|**样例** : `"string"`|string|
|**pageNo**  <br>*可选*|**样例** : `0`|integer (int32)|
|**pageSize**  <br>*可选*|**样例** : `0`|integer (int32)|
|**remarks**  <br>*可选*|**样例** : `"string"`|string|
|**resultCode**  <br>*可选*|**样例** : `"string"`|string|
|**resultMsg**  <br>*可选*|**样例** : `"string"`|string|
|**seriesName**  <br>*可选*|**样例** : `"string"`|string|
|**status**  <br>*可选*|**样例** : `"string"`|string|
|**status_in**  <br>*可选*|**样例** : `[ "string" ]`|< string > array|
|**transmissionType**  <br>*可选*|**样例** : `"string"`|string|
|**updateBy**  <br>*可选*|**样例** : `"string"`|string|
|**updateByName**  <br>*可选*|**样例** : `"string"`|string|
|**updateDate**  <br>*可选*|**样例** : `"string"`|string (date-time)|
|**updateDate_between**  <br>*可选*|**样例** : `"string"`|string|
|**updateDate_gte**  <br>*可选*|**样例** : `"string"`|string (date-time)|
|**updateDate_lte**  <br>*可选*|**样例** : `"string"`|string (date-time)|
|**vin**  <br>*可选*|**样例** : `"string"`|string|


<a name="maintenancetype"></a>
### MaintenanceType

|名称|说明|类型|
|---|---|---|
|**createBy**  <br>*可选*|**样例** : `"string"`|string|
|**createByName**  <br>*可选*|**样例** : `"string"`|string|
|**createDate**  <br>*可选*|**样例** : `"string"`|string (date-time)|
|**createDate_between**  <br>*可选*|**样例** : `"string"`|string|
|**createDate_gte**  <br>*可选*|**样例** : `"string"`|string (date-time)|
|**createDate_lte**  <br>*可选*|**样例** : `"string"`|string (date-time)|
|**id**  <br>*可选*|**样例** : `"string"`|string|
|**id_in**  <br>*可选*|**样例** : `[ "string" ]`|< string > array|
|**isNewRecord**  <br>*可选*|**样例** : `true`|boolean|
|**lastUpdateDateTime**  <br>*可选*|**样例** : `0`|integer (int64)|
|**mainTainDate**  <br>*可选*|**样例** : `"string"`|string|
|**maintenanceId**  <br>*可选*|**样例** : `"string"`|string|
|**maintenanceType**  <br>*可选*|**样例** : `"string"`|string|
|**mileage**  <br>*可选*|**样例** : `"string"`|string|
|**orderBy**  <br>*可选*|**样例** : `"string"`|string|
|**pageNo**  <br>*可选*|**样例** : `0`|integer (int32)|
|**pageSize**  <br>*可选*|**样例** : `0`|integer (int32)|
|**remarks**  <br>*可选*|**样例** : `"string"`|string|
|**repairDate**  <br>*可选*|**样例** : `"string"`|string|
|**status**  <br>*可选*|**样例** : `"string"`|string|
|**status_in**  <br>*可选*|**样例** : `[ "string" ]`|< string > array|
|**type**  <br>*可选*|**样例** : `"string"`|string|
|**updateBy**  <br>*可选*|**样例** : `"string"`|string|
|**updateByName**  <br>*可选*|**样例** : `"string"`|string|
|**updateDate**  <br>*可选*|**样例** : `"string"`|string (date-time)|
|**updateDate_between**  <br>*可选*|**样例** : `"string"`|string|
|**updateDate_gte**  <br>*可选*|**样例** : `"string"`|string (date-time)|
|**updateDate_lte**  <br>*可选*|**样例** : `"string"`|string (date-time)|


<a name="fc683d86e37d0e5c0ebf7ecdbcdfd9e9"></a>
### Page«CommonUser»

|名称|说明|类型|
|---|---|---|
|**count**  <br>*可选*|**样例** : `0`|integer (int64)|
|**list**  <br>*可选*|**样例** : `[ "[commonuser](#commonuser)" ]`|< [CommonUser](#commonuser) > array|
|**otherData**  <br>*可选*|**样例** : `"object"`|object|
|**pageNo**  <br>*可选*|**样例** : `0`|integer (int32)|
|**pageSize**  <br>*可选*|**样例** : `0`|integer (int32)|


<a name="d8b5416832dcb45206b9879a671f1746"></a>
### Page«MaintenanceType»

|名称|说明|类型|
|---|---|---|
|**count**  <br>*可选*|**样例** : `0`|integer (int64)|
|**list**  <br>*可选*|**样例** : `[ "[maintenancetype](#maintenancetype)" ]`|< [MaintenanceType](#maintenancetype) > array|
|**otherData**  <br>*可选*|**样例** : `"object"`|object|
|**pageNo**  <br>*可选*|**样例** : `0`|integer (int32)|
|**pageSize**  <br>*可选*|**样例** : `0`|integer (int32)|


<a name="c3fe2544ac1ed3edc832ec97d68bd67c"></a>
### Page«Maintenance»

|名称|说明|类型|
|---|---|---|
|**count**  <br>*可选*|**样例** : `0`|integer (int64)|
|**list**  <br>*可选*|**样例** : `[ "[maintenance](#maintenance)" ]`|< [Maintenance](#maintenance) > array|
|**otherData**  <br>*可选*|**样例** : `"object"`|object|
|**pageNo**  <br>*可选*|**样例** : `0`|integer (int32)|
|**pageSize**  <br>*可选*|**样例** : `0`|integer (int32)|


<a name="b40a47f38877eafeac556b9800cabe8f"></a>
### Page«VehicleBrand»

|名称|说明|类型|
|---|---|---|
|**count**  <br>*可选*|**样例** : `0`|integer (int64)|
|**list**  <br>*可选*|**样例** : `[ "[vehiclebrand](#vehiclebrand)" ]`|< [VehicleBrand](#vehiclebrand) > array|
|**otherData**  <br>*可选*|**样例** : `"object"`|object|
|**pageNo**  <br>*可选*|**样例** : `0`|integer (int32)|
|**pageSize**  <br>*可选*|**样例** : `0`|integer (int32)|


<a name="bb2d86bede5b37065c0318a517a348c8"></a>
### Page«VehicleDangerDetail»

|名称|说明|类型|
|---|---|---|
|**count**  <br>*可选*|**样例** : `0`|integer (int64)|
|**list**  <br>*可选*|**样例** : `[ "[vehicledangerdetail](#vehicledangerdetail)" ]`|< [VehicleDangerDetail](#vehicledangerdetail) > array|
|**otherData**  <br>*可选*|**样例** : `"object"`|object|
|**pageNo**  <br>*可选*|**样例** : `0`|integer (int32)|
|**pageSize**  <br>*可选*|**样例** : `0`|integer (int32)|


<a name="4b586a30cc14099d837873bf1397601f"></a>
### Page«VehicleDangerTotal»

|名称|说明|类型|
|---|---|---|
|**count**  <br>*可选*|**样例** : `0`|integer (int64)|
|**list**  <br>*可选*|**样例** : `[ "[vehicledangertotal](#vehicledangertotal)" ]`|< [VehicleDangerTotal](#vehicledangertotal) > array|
|**otherData**  <br>*可选*|**样例** : `"object"`|object|
|**pageNo**  <br>*可选*|**样例** : `0`|integer (int32)|
|**pageSize**  <br>*可选*|**样例** : `0`|integer (int32)|


<a name="d5192de1e8564c3133472ef017b608ec"></a>
### Page«VehicleDanger»

|名称|说明|类型|
|---|---|---|
|**count**  <br>*可选*|**样例** : `0`|integer (int64)|
|**list**  <br>*可选*|**样例** : `[ "[vehicledanger](#vehicledanger)" ]`|< [VehicleDanger](#vehicledanger) > array|
|**otherData**  <br>*可选*|**样例** : `"object"`|object|
|**pageNo**  <br>*可选*|**样例** : `0`|integer (int32)|
|**pageSize**  <br>*可选*|**样例** : `0`|integer (int32)|


<a name="dfcf9f2e2c379bbf68a5d3d83af3e237"></a>
### Page«VehicleSeries»

|名称|说明|类型|
|---|---|---|
|**count**  <br>*可选*|**样例** : `0`|integer (int64)|
|**list**  <br>*可选*|**样例** : `[ "[vehicleseries](#vehicleseries)" ]`|< [VehicleSeries](#vehicleseries) > array|
|**otherData**  <br>*可选*|**样例** : `"object"`|object|
|**pageNo**  <br>*可选*|**样例** : `0`|integer (int32)|
|**pageSize**  <br>*可选*|**样例** : `0`|integer (int32)|


<a name="vehiclebrand"></a>
### VehicleBrand

|名称|说明|类型|
|---|---|---|
|**createBy**  <br>*可选*|**样例** : `"string"`|string|
|**createByName**  <br>*可选*|**样例** : `"string"`|string|
|**createDate**  <br>*可选*|**样例** : `"string"`|string (date-time)|
|**createDate_between**  <br>*可选*|**样例** : `"string"`|string|
|**createDate_gte**  <br>*可选*|**样例** : `"string"`|string (date-time)|
|**createDate_lte**  <br>*可选*|**样例** : `"string"`|string (date-time)|
|**gengxinshijian**  <br>*可选*|**样例** : `"string"`|string|
|**id**  <br>*可选*|**样例** : `"string"`|string|
|**id_in**  <br>*可选*|**样例** : `[ "string" ]`|< string > array|
|**isNewRecord**  <br>*可选*|**样例** : `true`|boolean|
|**lastUpdateDateTime**  <br>*可选*|**样例** : `0`|integer (int64)|
|**orderBy**  <br>*可选*|**样例** : `"string"`|string|
|**pageNo**  <br>*可选*|**样例** : `0`|integer (int32)|
|**pageSize**  <br>*可选*|**样例** : `0`|integer (int32)|
|**pinpai**  <br>*可选*|**样例** : `"string"`|string|
|**pinpaiId**  <br>*可选*|**样例** : `"string"`|string|
|**pinpaiLogo**  <br>*可选*|**样例** : `"string"`|string|
|**remarks**  <br>*可选*|**样例** : `"string"`|string|
|**shouzimu**  <br>*可选*|**样例** : `"string"`|string|
|**status**  <br>*可选*|**样例** : `"string"`|string|
|**status_in**  <br>*可选*|**样例** : `[ "string" ]`|< string > array|
|**updateBy**  <br>*可选*|**样例** : `"string"`|string|
|**updateByName**  <br>*可选*|**样例** : `"string"`|string|
|**updateDate**  <br>*可选*|**样例** : `"string"`|string (date-time)|
|**updateDate_between**  <br>*可选*|**样例** : `"string"`|string|
|**updateDate_gte**  <br>*可选*|**样例** : `"string"`|string (date-time)|
|**updateDate_lte**  <br>*可选*|**样例** : `"string"`|string (date-time)|


<a name="vehicledanger"></a>
### VehicleDanger

|名称|说明|类型|
|---|---|---|
|**commonVehicleDangerTotalId**  <br>*可选*|**样例** : `"string"`|string|
|**createBy**  <br>*可选*|**样例** : `"string"`|string|
|**createByName**  <br>*可选*|**样例** : `"string"`|string|
|**createDate**  <br>*可选*|**样例** : `"string"`|string (date-time)|
|**createDate_between**  <br>*可选*|**样例** : `"string"`|string|
|**createDate_gte**  <br>*可选*|**样例** : `"string"`|string (date-time)|
|**createDate_lte**  <br>*可选*|**样例** : `"string"`|string (date-time)|
|**dangerDate**  <br>*可选*|**样例** : `"string"`|string|
|**id**  <br>*可选*|**样例** : `"string"`|string|
|**id_in**  <br>*可选*|**样例** : `[ "string" ]`|< string > array|
|**isNewRecord**  <br>*可选*|**样例** : `true`|boolean|
|**lastUpdateDateTime**  <br>*可选*|**样例** : `0`|integer (int64)|
|**orderBy**  <br>*可选*|**样例** : `"string"`|string|
|**pageNo**  <br>*可选*|**样例** : `0`|integer (int32)|
|**pageSize**  <br>*可选*|**样例** : `0`|integer (int32)|
|**remarks**  <br>*可选*|**样例** : `"string"`|string|
|**serviceMoney**  <br>*可选*|**样例** : `"string"`|string|
|**status**  <br>*可选*|**样例** : `"string"`|string|
|**status_in**  <br>*可选*|**样例** : `[ "string" ]`|< string > array|
|**updateBy**  <br>*可选*|**样例** : `"string"`|string|
|**updateByName**  <br>*可选*|**样例** : `"string"`|string|
|**updateDate**  <br>*可选*|**样例** : `"string"`|string (date-time)|
|**updateDate_between**  <br>*可选*|**样例** : `"string"`|string|
|**updateDate_gte**  <br>*可选*|**样例** : `"string"`|string (date-time)|
|**updateDate_lte**  <br>*可选*|**样例** : `"string"`|string (date-time)|


<a name="vehicledangerdetail"></a>
### VehicleDangerDetail

|名称|说明|类型|
|---|---|---|
|**commonVehicleDangerId**  <br>*可选*|**样例** : `"string"`|string|
|**createBy**  <br>*可选*|**样例** : `"string"`|string|
|**createByName**  <br>*可选*|**样例** : `"string"`|string|
|**createDate**  <br>*可选*|**样例** : `"string"`|string (date-time)|
|**createDate_between**  <br>*可选*|**样例** : `"string"`|string|
|**createDate_gte**  <br>*可选*|**样例** : `"string"`|string (date-time)|
|**createDate_lte**  <br>*可选*|**样例** : `"string"`|string (date-time)|
|**dangerSingleMoney**  <br>*可选*|**样例** : `"string"`|string|
|**dangerSingleName**  <br>*可选*|**样例** : `"string"`|string|
|**dangerSingleType**  <br>*可选*|**样例** : `"string"`|string|
|**id**  <br>*可选*|**样例** : `"string"`|string|
|**id_in**  <br>*可选*|**样例** : `[ "string" ]`|< string > array|
|**isNewRecord**  <br>*可选*|**样例** : `true`|boolean|
|**lastUpdateDateTime**  <br>*可选*|**样例** : `0`|integer (int64)|
|**orderBy**  <br>*可选*|**样例** : `"string"`|string|
|**pageNo**  <br>*可选*|**样例** : `0`|integer (int32)|
|**pageSize**  <br>*可选*|**样例** : `0`|integer (int32)|
|**remarks**  <br>*可选*|**样例** : `"string"`|string|
|**status**  <br>*可选*|**样例** : `"string"`|string|
|**status_in**  <br>*可选*|**样例** : `[ "string" ]`|< string > array|
|**updateBy**  <br>*可选*|**样例** : `"string"`|string|
|**updateByName**  <br>*可选*|**样例** : `"string"`|string|
|**updateDate**  <br>*可选*|**样例** : `"string"`|string (date-time)|
|**updateDate_between**  <br>*可选*|**样例** : `"string"`|string|
|**updateDate_gte**  <br>*可选*|**样例** : `"string"`|string (date-time)|
|**updateDate_lte**  <br>*可选*|**样例** : `"string"`|string (date-time)|


<a name="vehicledangertotal"></a>
### VehicleDangerTotal

|名称|说明|类型|
|---|---|---|
|**createBy**  <br>*可选*|**样例** : `"string"`|string|
|**createByName**  <br>*可选*|**样例** : `"string"`|string|
|**createDate**  <br>*可选*|**样例** : `"string"`|string (date-time)|
|**createDate_between**  <br>*可选*|**样例** : `"string"`|string|
|**createDate_gte**  <br>*可选*|**样例** : `"string"`|string (date-time)|
|**createDate_lte**  <br>*可选*|**样例** : `"string"`|string (date-time)|
|**id**  <br>*可选*|**样例** : `"string"`|string|
|**id_in**  <br>*可选*|**样例** : `[ "string" ]`|< string > array|
|**isNewRecord**  <br>*可选*|**样例** : `true`|boolean|
|**lastUpdateDateTime**  <br>*可选*|**样例** : `0`|integer (int64)|
|**orderBy**  <br>*可选*|**样例** : `"string"`|string|
|**pageNo**  <br>*可选*|**样例** : `0`|integer (int32)|
|**pageSize**  <br>*可选*|**样例** : `0`|integer (int32)|
|**remarks**  <br>*可选*|**样例** : `"string"`|string|
|**serviceSumCount**  <br>*可选*|**样例** : `0`|integer (int64)|
|**serviceSumMoney**  <br>*可选*|**样例** : `"string"`|string|
|**status**  <br>*可选*|**样例** : `"string"`|string|
|**status_in**  <br>*可选*|**样例** : `[ "string" ]`|< string > array|
|**updateBy**  <br>*可选*|**样例** : `"string"`|string|
|**updateByName**  <br>*可选*|**样例** : `"string"`|string|
|**updateDate**  <br>*可选*|**样例** : `"string"`|string (date-time)|
|**updateDate_between**  <br>*可选*|**样例** : `"string"`|string|
|**updateDate_gte**  <br>*可选*|**样例** : `"string"`|string (date-time)|
|**updateDate_lte**  <br>*可选*|**样例** : `"string"`|string (date-time)|
|**vehicleType**  <br>*可选*|**样例** : `"string"`|string|
|**vinCode**  <br>*可选*|**样例** : `"string"`|string|


<a name="vehicleseries"></a>
### VehicleSeries

|名称|说明|类型|
|---|---|---|
|**changshang**  <br>*可选*|**样例** : `"string"`|string|
|**changshangId**  <br>*可选*|**样例** : `"string"`|string|
|**chexi**  <br>*可选*|**样例** : `"string"`|string|
|**chexiId**  <br>*可选*|**样例** : `"string"`|string|
|**chexizhanshitu**  <br>*可选*|**样例** : `"string"`|string|
|**createBy**  <br>*可选*|**样例** : `"string"`|string|
|**createByName**  <br>*可选*|**样例** : `"string"`|string|
|**createDate**  <br>*可选*|**样例** : `"string"`|string (date-time)|
|**createDate_between**  <br>*可选*|**样例** : `"string"`|string|
|**createDate_gte**  <br>*可选*|**样例** : `"string"`|string (date-time)|
|**createDate_lte**  <br>*可选*|**样例** : `"string"`|string (date-time)|
|**gengxinshijian**  <br>*可选*|**样例** : `"string"`|string|
|**id**  <br>*可选*|**样例** : `"string"`|string|
|**id_in**  <br>*可选*|**样例** : `[ "string" ]`|< string > array|
|**isNewRecord**  <br>*可选*|**样例** : `true`|boolean|
|**lastUpdateDateTime**  <br>*可选*|**样例** : `0`|integer (int64)|
|**orderBy**  <br>*可选*|**样例** : `"string"`|string|
|**pageNo**  <br>*可选*|**样例** : `0`|integer (int32)|
|**pageSize**  <br>*可选*|**样例** : `0`|integer (int32)|
|**pinpaiId**  <br>*可选*|**样例** : `"string"`|string|
|**remarks**  <br>*可选*|**样例** : `"string"`|string|
|**shouzimu**  <br>*可选*|**样例** : `"string"`|string|
|**status**  <br>*可选*|**样例** : `"string"`|string|
|**status_in**  <br>*可选*|**样例** : `[ "string" ]`|< string > array|
|**updateBy**  <br>*可选*|**样例** : `"string"`|string|
|**updateByName**  <br>*可选*|**样例** : `"string"`|string|
|**updateDate**  <br>*可选*|**样例** : `"string"`|string (date-time)|
|**updateDate_between**  <br>*可选*|**样例** : `"string"`|string|
|**updateDate_gte**  <br>*可选*|**样例** : `"string"`|string (date-time)|
|**updateDate_lte**  <br>*可选*|**样例** : `"string"`|string (date-time)|
|**zuidizhidaojiaWan**  <br>*可选*|**样例** : `"string"`|string|
|**zuigaozhidaojiaWan**  <br>*可选*|**样例** : `"string"`|string|





