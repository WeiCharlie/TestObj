package com.doing.ace;

/**
 * Created by : Charlie Wei
 * Created date : 2018/7/28
 * Description : ....
 */
public class ConstantUrl {

    /*参数：
    name 用户名(默认为手机号)
    password 密码
    Response
    成功
    {
    "user":{
        "avatar":null,
        "email":"",
        "name":"王小明",
        "password":"123",
        "phoneNumber":"13512897386",
        "points":0,
        "sex":false,
        "type":0,
        "userId":9}
    }
    帐号不存在
    {"user":"账号不存在"}
    密码错误
    {"user":"密码错误"}*/
    public static final String LOGIN_IN = "http://47.94.0.163:8080/fitness/LoginServlet";

    /*
    获取验证码
    参数：
    phoneNumber 手机号
    Response
    手机号已存在
    {"status":"手机号已存在"}
    发送成功
    {"status":"发送成功","sessionid":"94CF98F517852368A8016AA9DB451A53"}
    发送失败(状态码解释见https://www.yunpian.com/doc/zh_CN/returnValue/common.html)
    {"status":"状态码"}*/
    public static final String GET_AUTH_CODE = "http://47.94.0.163:8080/fitness/GetAuthCodeServlet";
    /*
    * 注册普通用户
    URL:http://47.94.0.163:8080/fitness/RegisterServlet
    参数：
    phoneNumber 手机号
    password 密码
    sessionid 在"获取验证码"API中得到的sessionid
    Response
    手机号已存在
    {"status":"手机号已存在"}
    发送成功
    {"status":"发送成功","sessionid":"94CF98F517852368A8016AA9DB451A53"}
    发送失败（状态码解释见https://www.yunpian.com/doc/zh_CN/returnValue/common.html）
    {"status":"状态码"}
    *
    * */
    public static final String REGISTER_SERVLET = "http://47.94.0.163:8080/fitness/RegisterServlet";
    /*
    * 由id获取某个用户的信息
    参数：
    userid 用户id
    Response
    用户姓名，电话，积分，类别（0-普通用户，1—教练，2-健身馆），id等
    {"info":{
    "avatar":null,
    "name":"王小明",
    "password":"",
    "phoneNumber":"13512897386",
    "points":0,
    "type":0,
    "userId":9}}
     *
    * */
    public static final String GET_USER_INFO = "http://47.94.0.163:8080/fitness/GetRegularUserInfoServlet";
    /*
    * 获得某个用户的头像
    *参数：
    userid 用户id
    * */
    public static final String GET_USER_AVATAR = "http://47.94.0.163:8080/fitness/GetRegularUserAvatarServlet";
    /*
    * 修改密码---所有用户的密码均可这么操作
    *参数：
    userid 用户id
    oldPassword 旧密码
    newPassword 新密码
    Response
    密码错误：-1
    成功：1
    其他错误：0
    * */
    public static final String CHANGE_PWD = "http://47.94.0.163:8080/fitness/ChangePasswordServlet";
    /*
    *更换普通用户头像
    * 参数：
    userid 用户id
    Response
    成功：1
    其他错误：0
    * */
    public static final String CHANGE_USER_AVATAR = "http://47.94.0.163:8080/fitness/ChangeRegularUserAvatarServlet";
    /*
    * 关注某个人
    * 参数：
    userid 用户id（可以是普通用户，教练或者健身馆)
    beFollowedUserId：被关注者的id
    Response
    成功：1
    其他错误：0
    * */
    public static final String FOLLOW_SOMEONE = "http://47.94.0.163:8080/fitness/FollowServlet";
    /*
    * 获取附近的健身馆
    *
    * name 健身馆名字
phoneNumber 健身馆电话
introduce 健身馆的介绍
userid 健身馆id
[{
    "avatar":null,
    "distance":1356.2664034390418,
    "gymPhotos":[],
    "introduce":"跃美国际健身引进高端设备和国际化同步的健身项目,以高水平、高素质的管理团队,为......................",
    "isrecommend":false,
    "location":"天津市河西区平山道水映兰庭底商3楼",
    "locationX":117.18884,
    "locationY":39.103065,
    "name":"跃美国际健身",
    "password":"",
    "phoneNumber":"18522061080",
    "tags":[],
    "type":0,
    "userId":12},
{
    "avatar":null,
    "distance":1457.8110077380463,
    "gymPhotos":[],
    "introduce":"纽派力健身装潢可能受氛围,影有点街头风，歌曲也很街舞，这些都挺好的....................",
    "isrecommend":false,
    "location":"天津市南开区天塔道上谷商业街1号楼地下一层A6-A10",
    "locationX":117.182984,
    "locationY":39.097738,
    "name":"纽派力健身",
    "password":"",
    "phoneNumber":"2223238288",
    "tags":[],
    "type":0,
    "userId":11},
{
    "avatar":null,
    "distance":2993.3154300475244,
    "gymPhotos":[1,2],
    "introduce":"鹏宇健身会馆是一家百年老店....................",
    "isrecommend":false,
    "location":"天津市南开区奥城商业街c4楼318室",
    "locationX":117.176447,
    "locationY":39.08259,
    "name":"鹏宇健身",
    "password":"",
    "phoneNumber":"2258950856",
    "tags":["器材好","待人热情"],
    "type":0,
    "userId":10}]
    * */
    public static final String GET_NEAR_GYM = "http://47.94.0.163:8080/fitness/GetNear300DetailGymServlet";

    /*
    * 通过健身馆id获取健身馆详细信息
    *参数：
    userid 健身房id
    Response
    一个detailgym类的list
    avatar 头像
    distance 离传入地点的距离
    gymPhotos 包含健身馆图片id的列表，可通过“获得健身馆的介绍性图片”API来获取
    isrecommend 是否首页推荐
    location 具体位置
    tags 健身馆的标签列表
    locationX 健身馆的经度
    locationY 健身馆的纬度
    name 健身馆名字
    phoneNumber 健身馆电话
    introduce 健身馆的介绍
    userid 健身馆id
    {"info":{
    "avatar":null,
    "distance":0,
    "email":"",
    "gymPhotos":[],
    "introduce":"鹏宇健身会馆是一家百年老店....................",
    "isrecommend":true,
    "location":"天津市南开区奥城商业街c4楼318室",
    "locationX":117.176447,
    "locationY":39.08259,
    "name":"鹏宇健身",
    "password":"",
    "phoneNumber":"2258950856",
    "sex":false,
    "tags":[],
    "type":0,
    "userId":10}}
    * */
    public static final String GET_GYM_INFO_BY_ID="http://47.94.0.163:8080/fitness/GetGYMInfoServlet";
    /*
    * 获取推荐场馆
    *参数：
    userx 经度(六位小数)
    usery 纬度(六位小数)
    Response
    不存在推荐场馆（即推荐场馆列表为空）
    {"status":"100"}
    存在推荐场馆
    {"status":"200",
    "gymdetails":[
    {"commentnum":3,
    "distance":2654457.0384257264,
    "gymid":10,
    "gymname":"鹏宇健身",
    "location":"天津市南开区奥城商业街c4楼318室",
    "score":7.6667},
    {"commentnum":1,
    "distance":2654842.4361561425,
    "gymid":11,
    "gymname":"纽派力健身",
    "location":"天津市南开区天塔道上谷商业街1号楼地下一层A6-A10",
    "score":7}]
}
备注
此处并不会返回头像，如果想获取头像，可使用“获取健身馆的头像”api
    * */
    public static final String GET_RECOMMEND_GYM="http://47.94.0.163:8080/fitness/GetGYMRecommendServlet";
    /*
    * 获取健身场馆
    * 参数：
    type 排序方式
    1：不排序(即为按gymid排序)
    2：按照评分降序排序
    Response
    不存在场馆（即场馆列表为空）
    {"status":"100"}
    存在场馆
    {"status":"200",
    "gymdetails":[
    {"gymid":11,
    "introduce":"纽派力健身装潢可能受氛围,影有点街头风，歌曲也很街舞，这些都挺好的....................",
    "name":"纽派力健身",
    "score":10,
    "tags":["待人热情"]},
    {"gymid":10,
    "introduce":"鹏宇健身会馆是一家百年老店....................",
    "name":"鹏宇健身",
    "score":7.6667,
    "tags":["器材好","待人热情"]},
    {"gymid":12,
    "introduce":"跃美国际健身引进高端设备和国际化同步的健身项目,以高水平、高素质的管理团队,为......................",
    "name":"跃美国际健身",
    "score":0,
    "tags":[]},
    {"gymid":14,
    "introduce":"介绍介绍",
    "name":"某健身房",
    "score":0,
    "tags":[]}]
}
备注
此处并不会返回头像，如果想获取头像，可使用“获取健身馆的头像”api
    * */
    public static final String GET_ALL_GYM="http://47.94.0.163:8080/fitness/GetAllGYMServlet";
    /*
    * 设置某个健身房为推荐
    *参数：
    gymid 健身房id
    Response
    健身房不存在
    {"status":"404"}
    健身房已经是不推荐
    {"status":"201"}
    设置成功
    {"status":"200}
    其他错误
    {"status":"500"}
    * */
    public static final String SET_GYM_RECOMMEND="http://47.94.0.163:8080/fitness/CancelGymRecommendServlet";
    /*
    *取消设置某个健身房为推荐 todo 有点问题这个接口
    *   参数：
    gymid 健身房id
    Response
    健身房不存在
    {"status":"404"}
    健身房已经是推荐
    {"status":"201"}
    设置成功
    {"status":"200}
    其他错误
    {"status":"500"}
    * */
    public static final String dd="http://47.94.0.163:8080/fitness/GetGymAvatarServlet";
    /*
    * 获取健身馆的头像
    * URL:http://47.94.0.163:8080/fitness/GetGymAvatarServlet
    参数：
    gymid 健身房id
    Response
    一张图片，直接从流中读取即可
    * */
    public static final String GET_GYM_AVATAR="http://47.94.0.163:8080/fitness/GetGymAvatarServlet";
    /*
    * 获得健身馆的介绍性图片
    * 参数：
    gymphotosid 图片id
    Response
    一张图片，直接从流中读取即可
    * */
    public static final String GET_GYM_PHOTO="http://47.94.0.163:8080/fitness/GetGymPhotoServlet";
    /*
    * 向健身馆插入介绍性图片
    * 参数：
    gymid 健身房id
    上传的图片，参考post.java中SubmitPost()方法
    * */
    public static final String INSERT_GYM_PHOTO="http://47.94.0.163:8080/fitness/InsertGYMPhotosServlet";
    /*
    * 获取某个健身馆评论里的图片
    * 参数：
    gymcommentphotoid 图片id
    * */
    public static final String GET_GYM_COMMENT_PHOTO="http://47.94.0.163:8080/fitness/GetGymCommentPhotoServlet";
    /*
    * 获取某个健身馆的评论
    *
    * 参数：
gymid 健身房id
Response
一个list，commentPhotoList也是一个list，包含了该条评论所附加的图片的id，其他属性为评论创建时间，评论的点赞数，评论创建者的userid，评论内容，健身馆Id等
[{
    "comment":"教练很有耐心",
    "commentPhotoList":[],
    "createTime":{
        "date":10,
        "day":1,
        "hours":17,
        "minutes":9,
        "month":6,
        "nanos":0,
        "seconds":0,
        "time":1499677740000,
        "timezoneOffset":-480,
        "year":117},
    "gymCommentId":2,
    "gymId":10,
    "likeCount":0,
    "userid":8},
{
    "comment":"人多，器材不错",
    "commentPhotoList":[1],
    "createTime":{
        "date":10,
        "day":1,
        "hours":16,
        "minutes":9,
        "month":6,
        "nanos":0,
        "seconds":0,
        "time":1499674140000,
        "timezoneOffset":-480,
        "year":117},
    "gymCommentId":1,
    "gymId":10,
    "likeCount":0,
    "userid":9}]
    * */
    public static final String GET_GYM_COMMENT="http://47.94.0.163:8080/fitness/GetGymCommentServlet";
    /*
    * 发布对健身馆的评论
    * 参数：
    gymid 健身馆Id
    userid 发起评论的用户id
    comment 评论内容
    createTime 类型是时间戳的long，然后转成字符串传入
    以及多个或一个文件流----评论附带的照片
    Response
    无异常则成功
    * */
    public static final String PUBLISH_GYM_COMMENT="http://47.94.0.163:8080/fitness/WriteGymCommentServlet";
    /*
    * 注册健身馆
    *
    * 参数：
    introduce 健身馆自我介绍
    location 健身馆位置
    locationx 经度
    locationy 纬度
    name 名字
    phoneNumber 电话，不能重复
    password 密码
    avatar 头像文件流
    sex 性别，1:男，0：女
    email 邮箱，不能重复
    Response
    邮箱已存在：-3
    电话号码已存在：-2
    正常注册：注册用户的userid
    用户名已存在 -1
    其他错误 -4
    * */
    public static final String REGISTER_GYM="http://47.94.0.163:8080/fitness/RegisterGymServlet";
    /*
    * 更改健身馆头像
    * 参数：
    userid 健身馆id
    图片流
    Response
    成功：1
    其他错误：0
    * */
    public static final String CHANGE_GYM_AVATAR="http://47.94.0.163:8080/fitness/ChangeGYMAvatarServlet";
    /*
    * 发表健身馆评论 todo 接口有点问题
    *
    * URL:http://47.94.0.163:8080/fitness/GetGYMInfoServlet
    参数：
    userid 用户id
    Response
    json数据
    * */
    public static final String GET_GYM_INFO="http://47.94.0.163:8080/fitness/GetGYMInfoServlet";
    /*
    * 获得某个gym的所有教练
    * 参数：
    gymid 健身馆id
    Response
    一个教练对象的json list
    * */
    public static final String GET_GYM_ALL_COACH="http://47.94.0.163:8080/fitness/GetCoachsOfGYMServlet";
    /*
    * 获取场馆的所有课程
    *
    * 参数：
gymid 场馆id（例：12）
Response
该场馆的所有课程，是ArrayList<ArrayList>类型的
[[{
    "alreadyPeople":0,
    "beginTime":{
        "date":1,
        "day":0,
        "hours":10,
        "minutes":0,
        "month":1,
        "nanos":0,
        "seconds":0,
        "time":1422756000000,
        "timezoneOffset":-480,
        "year":115},
    "classId":1,
    "coachId":17,
    "coachLocationX":0,
    "coachLocationY":0,
    "coachName":"张三",
    "coachPhoneNumber":"154",
    "day":1,
    "distance":0,
    "endTime":{
        "date":3,
        "day":5,
        "hours":12,
        "minutes":0,
        "month":3,
        "nanos":0,
        "seconds":0,
        "time":1428033600000,
        "timezoneOffset":-480,
        "year":115},
    "introduce":"塑身课程介绍",
    "likecount":1,
    "maxPeople":100,
    "name":"塑身课程",
    "orderCreateTime":null,
    "photos":[1,2],
    "recommend":false,
    "types":["课程深入浅出","课程给力","课时长"]},
{
    "alreadyPeople":0,
    "beginTime":{
        "date":1,
        "day":0,
        "hours":10,
        "minutes":0,
        "month":1,
        "nanos":0,
        "seconds":0,
        "time":1422756000000,
        "timezoneOffset":-480,
        "year":115},
    "classId":2,
    "coachId":17,
    "coachLocationX":0,
    "coachLocationY":0,
    "coachName":"张三",
    "coachPhoneNumber":"154",
    "day":1,
    "distance":0,
    "endTime":{
        "date":3,
        "day":5,
        "hours":12,
        "minutes":0,
        "month":3,
        "nanos":0,
        "seconds":0,
        "time":1428033600000,
        "timezoneOffset":-480,
        "year":115},
    "introduce":"塑身课程介绍2",
    "likecount":0,
    "maxPeople":100,
    "name":"塑身2",
    "orderCreateTime":null,
    "photos":[3,4],
    "recommend":false,
    "types":["课程深入浅出"]}]]
    * */
    public static final String GET_GYM_ALL_CLASS="http://47.94.0.163:8080/fitness/GetClassesOfGymServlet";
    /*
    * 注册教练
    * introduce 自我介绍
    location 教练位置
    locationx 经度
    locationy 纬度
    name 名字
    phoneNumber 电话，不能重复
    password 密码
    avatar 头像文件流
    qualities 专业素质
    characteristic 课程特色
    sex 性别，1:男，0：女
    email 邮箱，不能重复
    Response
    邮箱已存在：-3
    电话号码已存在：-2
    正常注册：注册用户的userid
    用户名已存在 -1
    其他错误 -4
    备注
    注册成功后还应该调用“教练上传认证材料”API上传认证材料
    * */
    public static final String REGISTER_COACH="http://47.94.0.163:8080/fitness/RegisterCoachServlet";
    /*
    *教练上传认证材料
    * 参数：
    coachid 教练id
    一个文件流
    Response
    正常返回：1
    其他：错误
    * */
    public static final String UPLOAD_COACH_CM="http://47.94.0.163:8080/fitness/UploadCertificateMaterialServlet";
    /*
    * 管理员检查教练认证材料后给予认证
    * 参数：
    coachid 教练id
    Response
    正常返回：1
    其他：错误
    * */
    public static final String SET_CER="http://47.94.0.163:8080/fitness/SetCertificateServlet";
    /*
    * 获取附近教练
    * 参数：
locationx:自身所在位置的经度
location:自身所在位置的纬度
Response
根据点赞数和距离来综合排序，tags表示教练的标签，
[{
    "avatar":null,
    "certificated":true,
    "certification":null,
    "characteristic":"课程特色",
    "distance":1606.1821040784455,
    "introduce":"介绍介绍",
    "likecount":0,
    "location":"南门外大街",
    "locationX":117.186478,
    "locationY":39.138969,
    "name":"张三",
    "password":"",
    "phoneNumber":"154",
    "qualities":"专业素质",
    "tags":["耐心好"],
    "type":0,
    "userId":17},
{
    "avatar":null,
    "certificated":true,
    "certification":null,
    "characteristic":"课程特色2",
    "distance":68414.5785675595,
    "introduce":"介绍介绍2",
    "likecount":0,
    "location":"天津南开区",
    "locationX":117.386478,
    "locationY":39.738969,
    "name":"李四",
    "password":"",
    "phoneNumber":"156",
    "qualities":"专业素质2",
    "tags":[],
    "type":0,
    "userId":18}]
    * */
    public static final String GET_NEAR_COACH="http://47.94.0.163:8080/fitness/GetNearCoachsServlet";
    /*
    * 获取对某个教练的评论
    * 参数：
coachid 教练id（例：17）
Response
根据点赞数和评论发表日期综合排序，commentPhotoList表示该条评论所附带的图片的id
[{
    "coachCommentId":3,
    "coachId":17,
    "comment":"对教练的评论22222",
    "commentPhotoList":[5,6],
    "createTime":{
        "date":14,
        "day":5,
        "hours":16,
        "minutes":4,
        "month":6,
        "nanos":0,
        "seconds":44,
        "time":1500019484000,
        "timezoneOffset":-480,
        "year":117},
    "likeCount":0,
    "userId":9},
{
    "coachCommentId":1,
    "coachId":17,
    "comment":"对教练的评论",
    "commentPhotoList":[1,2],
    "createTime":{
        "date":14,
        "day":5,
        "hours":15,
        "minutes":58,
        "month":6,
        "nanos":0,
        "seconds":39,
        "time":1500019119000,
        "timezoneOffset":-480,
        "year":117},
    "likeCount":0,
    "userId":9}]
    * */
    public static final String GET_COACH_COMMENT="http://47.94.0.163:8080/fitness/GetCoachCommentServlet";
    /*
    * 获得某条对教练评论的图片
    * 参数：
    coachcommentphotoid（例：1）
    获得教练头像
    Request
    URL:http://47.94.0.163:8080/fitness/GetCoachAvatarServlet
    参数：
    coachid（例：17）
    * */
    public static final String GET_COACH_COMMENT_PHOTO="http://47.94.0.163:8080/fitness/GetCoachCommentPhotoServlet";

    /*
    *查看教练的认证资料
    * 参数：
    coachid（例：17）
    * */
    public static final String GET_CER_OF_COACH="http://47.94.0.163:8080/fitness/GetCertificateMaterialServlet";
    /*
    * 发布对教练的评论
    * 参数：
    coachid 待评论的教练的id
    userid 发起评论的用户id
    comment 评论内容
    createTime 类型是时间戳的long，然后转成字符串传入
    以及多个或一个文件流----评论附带的照片
    Response
    无异常则成功
    * */
    public static final String WRITE_COACH_COMMENT="http://47.94.0.163:8080/fitness/WriteCoachCommentServlet";
    /*
    * 更换教练头像
    * 参数：
    userid 健身馆id
    图片流
    Response
    成功：1
    其他错误：0
    * */
    public static final String CHANGE_COACH_AVATAR="http://47.94.0.163:8080/fitness/ChangeCoachAvatarServlet";
    /*
    * 教练创建一个课程
    * 参数：
    coachid 教练id
    maxPeople 课程限制人数
    day 课程的开课时间（0-7代表周一到周日）
    beginTime 课程开始时间，应传入时间戳，有效部分为hour到minutes，即传入2015-7-3:10:00:00（时间戳转化之后），有效部分只有10:00:00，前面的年月日没用
    endTime 同上，结束时间
    introduce 课程介绍
    name 课程名称
    以及多个或者一个照片流，用于介绍该课程，可以没有
    Response
    成功：1
    其他错误：-1
    * */
    public static final String CREATE_CLASS="http://47.94.0.163:8080/fitness/CreateClassServlet";
    /*
    * 获得某个教练的所有课程
    * 参数：
coachid 教练id（例：17）
Response
photos为该课程的介绍性图片的id，types为该课程的标签
[{
    "alreadyPeople":0,
    "beginTime":{
        "date":1,
        "day":0,
        "hours":10,
        "minutes":0,
        "month":1,
        "nanos":0,
        "seconds":0,
        "time":1422756000000,
        "timezoneOffset":-480,
        "year":115},
    "classId":1,
    "coachId":17,
    "coachLocationX":0,
    "coachLocationY":0,
    "coachName":"张三",
    "coachPhoneNumber":"154",
    "day":1,
    "distance":0,
    "endTime":{
        "date":3,
        "day":5,
        "hours":12,
        "minutes":0,
        "month":3,
        "nanos":0,
        "seconds":0,
        "time":1428033600000,
        "timezoneOffset":-480,
        "year":115},
    "introduce":"塑身课程介绍",
    "likecount":1,
    "maxPeople":100,
    "name":"塑身课程",
    "orderCreateTime":null,
    "photos":[1,2],
    "recommend":false,
    "types":["课程深入浅出",
    "课程给力",
    "课时长"]},
{
    "alreadyPeople":0,
    "beginTime":{
        "date":1,
        "day":0,
        "hours":10,
        "minutes":0,
        "month":1,
        "nanos":0,
        "seconds":0,
        "time":1422756000000,
        "timezoneOffset":-480,
        "year":115},
    "classId":2,
    "coachId":17,
    "coachLocationX":0,
    "coachLocationY":0,
    "coachName":"张三",
    "coachPhoneNumber":"154",
    "day":1,
    "distance":0,
    "endTime":{
        "date":3,
        "day":5,
        "hours":12,
        "minutes":0,
        "month":3,
        "nanos":0,
        "seconds":0,
        "time":1428033600000,
        "timezoneOffset":-480,
        "year":115},
    "introduce":"塑身课程介绍2",
    "likecount":0,
    "maxPeople":100,
    "name":"塑身2",
    "orderCreateTime":null,
    "photos":[3,4],
    "recommend":false,
    "types":["课程深入浅出"]}]
    * */
    public static final String GET_ALL_CLASS_OF_COACH="http://47.94.0.163:8080/fitness/Get500ClassesServlet";
    /*
    * 由课程id获取课程
    * 参数：
classid 课程id
Response
课程不存在
{"status":"100"}
课程存在
{
"status":"200",
"class":{
    "alreadyPeople":0,
    "beginTime":{
        "date":1,
        "day":0,
        "hours":10,
        "minutes":0,
        "month":1,
        "nanos":0,
        "seconds":0,
        "time":1422756000000,
        "timezoneOffset":-480,
        "year":115},
    "classId":1,
    "coachId":17,
    "coachLocationX":117.186478,
    "coachLocationY":39.138969,
    "coachName":"张三",
    "coachPhoneNumber":"154",
    "day":1,
    "distance":0,
    "endTime":{
        "date":3,
        "day":5,
        "hours":12,
        "minutes":0,
        "month":3,
        "nanos":0,
        "seconds":0,
        "time":1428033600000,
        "timezoneOffset":-480,
        "year":115},
    "introduce":"塑身课程介绍",
    "likecount":1,
    "maxPeople":100,
    "name":"塑身课程",
    "orderCreateTime":null,
    "photos":[1,2],
    "recommend":false,
    "types":["课程深入浅出","课程给力","课时长"]
    }
}
    * */
    public static final String GET_CLASS_BY_ID="http://47.94.0.163:8080/fitness/GetClassByIDServlet";
    /*
    * 获取课程的介绍性图片
    * URL:http://47.94.0.163:8080/fitness/GetClassIntroducePhotoServlet
    参数：
    classPhotosId 图片的id
    Response
    图片
    * */
    public static final String GET_CLASS_INTRO_IMG="http://47.94.0.163:8080/fitness/GetClassIntroducePhotoServlet";
    /*
    * 获取课程评论的图片
    * 参数：
    classCommentPhotosId 评论图片的id
    Response
    图片
    * */
    public static final String GET_CLASS_COMMENT_PHOTO="http://47.94.0.163:8080/fitness/GetClassCommentPhotoServlet";
    /*
    * 获取课程的评论
    * URL:http://47.94.0.163:8080/fitness/GetClassCommentServlet
    参数：
    classid 课程id
    Response
    photos为课程评论里面的图片id
    [{
    "classCommentId":1,
    "classId":0,
    "comment":"塑身课程评论",
    "createTime":{
        "date":17,
        "day":1,
        "hours":20,
        "minutes":23,
        "month":6,
        "nanos":0,
        "seconds":40,
        "time":1500294220000,
        "timezoneOffset":-480,
        "year":117},
    "likeCount":0,
    "orderId":1,
    "photos":[1,2],
    "userId":9}]
    * */
    public static final String GET_CLASS_COMMENT="http://47.94.0.163:8080/fitness/GetClassCommentServlet";
    /*
    * 获取某个用户已选的课程
    * 参数：
userid 用户id
Response
[{
    "alreadyPeople":0,
    "beginTime":{
        "date":1,
        "day":0,
        "hours":10,
        "minutes":0,
        "month":1,
        "nanos":0,
        "seconds":0,
        "time":1422756000000,
        "timezoneOffset":-480,
        "year":115},
    "classId":3,
    "coachId":18,
    "coachLocationX":0,
    "coachLocationY":0,
    "coachName":"李四",
    "coachPhoneNumber":"156",
    "day":1,
    "distance":0,
    "endTime":{
        "date":3,
        "day":5,
        "hours":12,
        "minutes":0,
        "month":3,
        "nanos":0,
        "seconds":0,
        "time":1428033600000,
        "timezoneOffset":-480,
        "year":115},
    "introduce":"塑身课程介绍2",
    "likecount":300,
    "maxPeople":100,
    "name":"塑身3",
    "orderCreateTime":{
        "date":1,
        "day":3,
        "hours":10,
        "minutes":0,
        "month":1,
        "nanos":0,
        "seconds":0,
        "time":1485914400000,
        "timezoneOffset":-480,
        "year":117},
    "photos":[5,6],
    "recommend":false,
    "types":["课程深入浅出","课程给力","课时长"]
},
{
    "alreadyPeople":0,
    "beginTime":{
        "date":1,
        "day":0,
        "hours":10,
        "minutes":0,
        "month":1,
        "nanos":0,
        "seconds":0,
        "time":1422756000000,
        "timezoneOffset":-480,
        "year":115},
    "classId":1,
    "coachId":17,
    "coachLocationX":0,
    "coachLocationY":0,
    "coachName":"张三",
    "coachPhoneNumber":"154",
    "day":1,
    "distance":0,
    "endTime":{
        "date":3,
        "day":5,
        "hours":12,
        "minutes":0,
        "month":3,
        "nanos":0,
        "seconds":0,
        "time":1428033600000,
        "timezoneOffset":-480,
        "year":115},
    "introduce":"塑身课程介绍",
    "likecount":1,
    "maxPeople":100,
    "name":"塑身课程",
    "orderCreateTime":{
        "date":1,
        "day":0,
        "hours":10,
        "minutes":0,
        "month":1,
        "nanos":0,
        "seconds":0,
        "time":1422756000000,
        "timezoneOffset":-480,
        "year":115},
    "photos":[1,2],
    "recommend":false,
    "types":["课程深入浅出","课程给力","课时长"]
}]
    * */
    public static final String GET_USER_SELECTED_CLASS="http://47.94.0.163:8080/fitness/GetUserSelectedClassServlet";
    /*
    * 对某个课程点赞
    * 参数：
    classid 课程的id
    Response
    成功：1
    错误：0
    * */
    public static final String LIKE_CLASS="http://47.94.0.163:8080/fitness/LikeClassServlet";
    /*
    * 设置某条订单为已付款（用户付款后使用）
    * 参数：
    orderid 订单的id
    trackingNo 交易的单号
    Response
    成功：1
    错误：0
    * */
    public static final String SET_PAY_OVER="http://47.94.0.163:8080/fitness/PayOrderServlet";
    /*
    * 搜索课程
    * 参数：
type 课程的标签，如“课时长”
locationx：用户的经度
locationy:用户的纬度
Response
手机号已存在
[{
    "alreadyPeople":0,
    "beginTime":{
        "date":1,
        "day":0,
        "hours":10,
        "minutes":0,
        "month":1,
        "nanos":0,
        "seconds":0,
        "time":1422756000000,
        "timezoneOffset":-480,
        "year":115},
    "classId":3,
    "coachId":18,
    "coachLocationX":117.386478,
    "coachLocationY":39.738969,
    "coachName":"李四",
    "coachPhoneNumber":"156",
    "day":1,
    "distance":58251.402682534754,
    "endTime":{
        "date":3,
        "day":5,
        "hours":12,
        "minutes":0,
        "month":3,
        "nanos":0,
        "seconds":0,
        "time":1428033600000,
        "timezoneOffset":-480,
        "year":115},
    "introduce":"塑身课程介绍2",
    "likecount":300,
    "maxPeople":100,
    "name":"塑身3",
    "orderCreateTime":null,
    "photos":[5,6],
    "recommend":false,
    "types":["课程深入浅出","课程给力","课时长"]},
{
    "alreadyPeople":0,
    "beginTime":{
        "date":1,
        "day":0,
        "hours":10,
        "minutes":0,
        "month":1,
        "nanos":0,
        "seconds":0,
        "time":1422756000000,
        "timezoneOffset":-480,
        "year":115},
    "classId":1,
    "coachId":17,
    "coachLocationX":117.186478,
    "coachLocationY":39.138969,
    "coachName":"张三",
    "coachPhoneNumber":"154",
    "day":1,
    "distance":11131.949079326663,
    "endTime":{
        "date":3,
        "day":5,
        "hours":12,
        "minutes":0,
        "month":3,
        "nanos":0,
        "seconds":0,
        "time":1428033600000,
        "timezoneOffset":-480,
        "year":115},
    "introduce":"塑身课程介绍",
    "likecount":1,
    "maxPeople":100,
    "name":"塑身课程",
    "orderCreateTime":null,
    "photos":[1,2],
    "recommend":false,
    "types":["课程深入浅出","课程给力","课时长"]}]
    * */
    public static final String SEARCH_CLASS="http://47.94.0.163:8080/fitness/SearchClassServlet";
    /*
    * 用户选择要购买的课程
    * 参数：
    classid 课程的id
    userid 用户的id
    coachid 该课程教练的id
    payNumber 应付款数，单位元
    createTime 创建时间的时间戳，单位毫秒
    Response
    成功：1
    错误：0/-1
    * */
    public static final String SELECT_CLASS="http://47.94.0.163:8080/fitness/SelectClassServlet";
    /*
    * 用户对某课程进行评价（必须是购买之后才能评价）
    * 参数：
    classid 课程的id
    userid 用户的id
    orderid 该用户购买该课程的订单id
    comment 评价
    createTime 创建时间的时间戳，单位毫秒
    一张或者多张图片
    Response
    成功：评论id
    失败：0/-1
    * */
    public static final String WRITE_CLASS_COMMENT="http://47.94.0.163:8080/fitness/WriteClassCommentServlet";
    /*
    * 获取教练详细信息
    * 参数：
    userid 用户id
    Response
    json数据
    * */
    public static final String GET_COACH_INFO="http://47.94.0.163:8080/fitness/GetCoachInfoServlet";
    /*
    * 获得某条订单
    * 参数：
    orderid 订单的id
    Response
    一个订单对象的json
    * */
    public static final String GET_ORDER="http://47.94.0.163:8080/fitness/GetOrderServlet";
    /*
    *获得某人的所有健身卡
    * 参数：
    userid 此人的id
    Response
    健身卡（gymcard）对象的json list
    * */
    public static final String GET_SOMEONE_ALL_CARD_OF_GYM="http://47.94.0.163:8080/fitness/GetAllCardServlet";
    /*
    * 购买某健身房的健身卡
    * URL:http://47.94.0.163:8080/fitness/BuyGymCardServlet
    参数：
    userid：此人的id
    gymid: 健身房id
    type: 0:单次健身卡，1，周卡，2月卡 3年卡 4其他种类的卡
    payNumber:应付金额
    beginTime：健身卡的有效时间的起点
    endTime:健身卡的有效时间的终点
    createTime：购买此卡的时间
    cardName:此健身卡的名字，如“健身周卡”，“健身月卡”
    Response
    成功 此次健身卡的id
    失败 -1
    * */
    public static final String BUY_GYM_CARD="http://47.94.0.163:8080/fitness/BuyGymCardServlet";
    /*
    * 获得某人的所有订单
    * 参数：
userid 此人的id
Response
所有订单的json list
{
"orders":[{
    "classId":1,
    "coachId":17,
    "createTime":{
        "date":1,
        "day":0,
        "hours":10,
        "minutes":0,
        "month":1,
        "nanos":0,
        "seconds":0,
        "time":1422756000000,
        "timezoneOffset":-480,
        "year":115},
    "gymcardid":0,
    "gymid":0,
    "orderId":1,
    "payNumber":300,
    "payed":true,
    "trackingNo":"",
    "used":false,
    "userId":9},
{
    "classId":3,
    "coachId":18,
    "createTime":{
        "date":1,
        "day":3,
        "hours":10,
        "minutes":0,
        "month":1,
        "nanos":0,
        "seconds":0,
        "time":1485914400000,
        "timezoneOffset":-480,
        "year":117},
    "gymcardid":0,
    "gymid":0,
    "orderId":2,
    "payNumber":100,
    "payed":true,
    "trackingNo":"",
    "used":false,
    "userId":9}]}
    * */
    public static final String GET_ALL_ORDER="http://47.94.0.163:8080/fitness/GetAllOrdersServlet";

    /*
    * 获得某健身房的所有健身卡
    * 参数：
gymid 该健身房的id
Response
json list（注意：返回的GymCardType类和API49中的gymcard不同，具体字段含义参照数据库说明文档）
[{
    "cardName":"纽派力健身月卡",
    "gymCardTypeId":3,
    "gymId":12,
    "optionalBeginTime":null,
    "optionalEndTime":null,
    "type":2},
{
    "cardName":"纽派力健身国庆纪念卡",
    "gymCardTypeId":4,
    "gymId":12,
    "optionalBeginTime":{
        "date":1,
        "day":0,
        "hours":0,
        "minutes":0,
        "month":9,
        "nanos":0,
        "seconds":0,
        "time":1506787200000,
        "timezoneOffset":-480,
        "year":117},
    "optionalEndTime":{
        "date":10,
        "day":2,
        "hours":0,
        "minutes":0,
        "month":9,
        "nanos":0,
        "seconds":0,
        "time":1507564800000,
        "timezoneOffset":-480,
        "year":117},
    "type":4}]
    * */
    public static final String GET_ALL_CARD_OF_GYM="http://47.94.0.163:8080/fitness/GetAllCardOfGYMServlet";
    /*
    * 添加或修改私教价格
    * 参数：
    coachid 教练的id
    pricePerDay 价格
    Response
    成功：1
    失败：0
    * */
    public static final String UPDATE_COACH_PRICE="http://47.94.0.163:8080/fitness/SetCoachPriceServlet";
    /*
    * 获取私教价格（每天的单价，最后预约私教总价格应该重新计算）
    * 参数：
    coachid 教练的id
    Response
    该教练每日价格
    * */
    public static final String GET_COACH_PRICE="http://47.94.0.163:8080/fitness/GetCoachPriceServlet";
    /*
    * 预约私教
    * 参数：
    coachid 教练的id
    userid 用户id
    beginTime 私教指导用户的开始时间（预约开始时间戳）
    endTime 结束的时间，同上
    createTime 创建此次预约的时间（即可以预约从下个月开始，让某私教来指导健身）
    price 总价格；应该计算之间有多少天。
    arriveTime 客人的到达时间
    contactPhone 客人的联系电话
    Response
    成功：预约的orderid
    失败：-1
    * */
    public static final String RESERVE_COACH="http://47.94.0.163:8080/fitness/ReserveCoachServlet";
    /*
    * 某用户发表帖子（朋友圈）
    * URL:http://47.94.0.163:8080/fitness/CreatePostServlet
    参数：
    content 帖子内容
    userid 用户的id
    title 标题
    createTime 创建时间的时间戳，单位毫秒
    一张或者多张图片
    Response
    成功：帖子id
    失败：0/-1
    * */
    public static final String CREATE_FRIEND_CIRCLE="http://47.94.0.163:8080/fitness/CreatePostServlet";
    /*
    * 获得朋友圈帖子及其评论
    * 参数：
userid：用户的id
cursor:游标，必须为10的整数倍，从0开始，如果有朋友圈的话，则按照时间排序返回第0到第9条，如果没有的话，返回“没有帖子啦”，如果cursor为10，则返回第10到19条（例：0）
Response
[{
"comments":[{
    "comment":"到底怎么高兴啦？",
    "createTime":null,
    "likeCount":1,
    "photos":[1],
    "postCommentId":1,
    "postId":8,
    "userId":8,
    "userName":"哈哈哈哈"},
    {
    "comment":"捡到钱啦？",
    "createTime":null,
    "likeCount":0,
    "photos":[2],
    "postCommentId":2,
    "postId":8,
    "userId":15,
    "userName":"test"}],
    "post":{
        "content":"今个儿真呀真高兴",
        "createTime":{
            "date":18,
            "day":2,
            "hours":19,
            "minutes":37,
            "month":6,
            "nanos":0,
            "seconds":25,
            "time":1500377845000,
            "timezoneOffset":-480,
            "year":117},
        "likeCount":0,
        "photos":[1,2],
        "postId":8,
        "title":"标题是什么，能吃吗",
        "userId":9,
        "userName":"王小明"}},
{
    "comments":[],
    "post":{
        "content":"内容3",
        "createTime":{
            "date":16,
            "day":0,
            "hours":22,
            "minutes":9,
            "month":6,
            "nanos":0,
            "seconds":0,
            "time":1500214140000,
            "timezoneOffset":-480,
            "year":117},
        "likeCount":0,
        "photos":[],
        "postId":3,
        "title":"标题3",
        "userId":10,
        "userName":"鹏宇健身"}},
{
"comments":[{
    "comment":"你发的啥玩意？",
    "createTime":null,
    "likeCount":0,
    "photos":[3],
    "postCommentId":3,
    "postId":2,
    "userId":9,
    "userName":"王小明"}],
    "post":{
        "content":"内容2",
        "createTime":{
            "date":16,
            "day":0,
            "hours":21,
            "minutes":9,
            "month":6,
            "nanos":0,
            "seconds":0,
            "time":1500210540000,
            "timezoneOffset":-480,
            "year":117},
        "likeCount":0,
        "photos":[],
        "postId":2,
        "title":"标题2",
        "userId":8,
        "userName":"哈哈哈哈"}},
{
"comments":[],
    "post":{
        "content":"内容4",
        "createTime":{
            "date":16,
            "day":0,
            "hours":21,
            "minutes":9,
            "month":6,
            "nanos":0,
            "seconds":0,
            "time":1500210540000,
            "timezoneOffset":-480,
            "year":117},
        "likeCount":0,
        "photos":[],
        "postId":4,
        "title":"标题4",
        "userId":10,
        "userName":"鹏宇健身"}},
{
"comments":[],
    "post":{
        "content":"内容",
        "createTime":{
            "date":16,
            "day":0,
            "hours":21,
            "minutes":8,
            "month":6,
            "nanos":0,
            "seconds":0,
            "time":1500210480000,
            "timezoneOffset":-480,
            "year":117},
        "likeCount":1,
        "photos":[],
        "postId":1,
        "title":"标题",
        "userId":8,
        "userName":"哈哈哈哈"}}]
    * */
    public static final String GET_CIRCLE="http://47.94.0.163:8080/fitness/RegisterServlet";
    /*
    * 获得帖子评论里面的图片
    * 参数：
    postCommentPhotoId
    Response
    图片
    * */
    public static final String GET_POST_COMMENT="http://47.94.0.163:8080/fitness/GetPostCommentPhotoServlet";
    /*
    * 获得帖子里面的图片
    * 参数：
    postPhotosId
    Response
    图片
    * */
    public static final String GET_POST_PHOTO="http://47.94.0.163:8080/fitness/GetPostPhotoServlet";
    /*
    * 对某个帖子评论点赞
    * 参数：
    postCommentId 帖子评论id
    Response
    正确：1
    错误：0
    * */
    public static final String LIKE_POST_COMMENT="http://47.94.0.163:8080/fitness/LikePostCommentServlet";
    /*
    *对某个帖子点赞
    * 参数：
    postid 帖子id
    Response
    正确：1
    错误：0
    * */
    public static final String LIKE_POST="http://47.94.0.163:8080/fitness/LikePostServlet";
    /*
    * 发表帖子评论
    * URL:http://47.94.0.163:8080/fitness/WritePostCommentServlet
    参数：
    postid 帖子id
    userid 用户id
    comment 评论内容
    createTime 创建的时间，应该为时间戳
    一张或者多张图片
    Response
    成功：插入的帖子评论的id
    错误：0/-1
    * */
    public static final String WRITE_POST_COMMENT="http://47.94.0.163:8080/fitness/WritePostCommentServlet";
//    /*备用*/
//    public static final String dd="";
//    /**/
//    public static final String dd="";
//    /**/
//    public static final String dd="";
//    /**/
//    public static final String dd="";
//    /**/
//    public static final String dd="";
//    /**/
//    public static final String dd="";
//    /**/
//    public static final String dd="";
//    /**/
//    public static final String dd="";
//    /**/
//    public static final String dd="";
//    /**/
//    public static final String dd="";
}
