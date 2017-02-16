package demo.controller;

/**
 * 邀请卡API文档
 */

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import demo.service.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zhengyunfei on 2016/9/2.
 */
@RestController
@Api(value = "k:邀请卡接口文档", description = "<font color='red'>app3.0接口文档</font>", produces = "application/json",position =1 )
public class InvitationCardController {
    @Autowired
    UserMapper userMapper;
    @ApiOperation(httpMethod = "POST", value = "1：获取邀请卡列表(<font color='blue'>release</font>)",position = 3,notes = "接口地址:/api/invitationCard/list<br>" +
            "<h4><font color='red'>友情提示1，<a href='http://172.168.18.63:8080/debug/index.html#!/4:根据token获取个人或者机构基本信息api接口/getUserStepAndStatus'>/api/user/getStepAndStatus</a>此接口新增返回结果字段yqmCode:邀请码</font></h4>" +
            "<h4><font color='red'>友情提示2，<a href='http://172.168.18.63:8080/debug/index.html#!/3:用户注册api接口/getCode'>/api/user/register</a>此接口新增参数传递字段yqmCode:邀请码</font></h4>" +
            "<h4>分享链接为http://172.168.11.8:8090/newPhone/shareInvestors.html?yqmCode=123456?yqmCode=123456,此链接暂时为测试环境地址链接，正式环境链接待定,h5需要根据此链接传递的参数yqmCode传递到注册/api/user/register接口中</h4>" +
            "<h4>字段解析:</h4>" +
            "1:pic 图片<br>" +
            "2:name 名称<br>" +
            "3:title 标题<br>" +
            "4:content 内容<br>" +
            "5:thumbnail 缩略图<br>" +
            "6:type 0 默认 1 其他<br>" +
            "<font color='red'>默认查询出来的第一条数据是默认的邀请卡</font>" +
            "<h4>数据集返回结果:</h4>" +
            "<div class=\"block response_body json\"><pre class=\"json\"><code>"+
            "{\n" +
            "    \"code\": 0, \n" +
            "    \"message\": \"成功\", \n" +
            "    \"data\": {\n" +
            "        \"list\": [\n" +
            "            {\n" +
            "                \"id\": \"7\", \n" +
            "                \"pic\": \"http://172.168.18.63:9999/ImageUploadServer/image/201701/20170120095948_805.png\", \n" +
            "                \"name\": \"名称455555\", \n" +
            "                \"title\": \"标题4555\", \n" +
            "                \"content\": \"内容45555\", \n" +
            "                \"thumbnail\": \"http://172.168.18.63:9999/ImageUploadServer/image/201701/20170120095946_310.png\", \n" +
            "                \"type\": \"0\"\n" +
            "            }, \n" +
            "            {\n" +
            "                \"id\": \"6\", \n" +
            "                \"pic\": \"http://172.168.18.63:9999/ImageUploadServer/image/201701/20170120095418_450.png\", \n" +
            "                \"name\": \"名称36666\", \n" +
            "                \"title\": \"标题36666\", \n" +
            "                \"content\": \"内容46666\", \n" +
            "                \"thumbnail\": \"http://172.168.18.63:9999/ImageUploadServer/image/201701/20170122114248_136.png\", \n" +
            "                \"type\": \"1\"\n" +
            "            }, \n" +
            "            {\n" +
            "                \"id\": \"4\", \n" +
            "                \"pic\": \"http://172.168.18.63:9999/ImageUploadServer/image/201701/20170119174245_459.png\", \n" +
            "                \"name\": \"名称2\", \n" +
            "                \"title\": \"标题2\", \n" +
            "                \"content\": \"内容2\", \n" +
            "                \"thumbnail\": \"http://172.168.18.63:9999/ImageUploadServer/image/201701/20170119174243_70.png\", \n" +
            "                \"type\": \"0\"\n" +
            "            }, \n" +
            "            {\n" +
            "                \"id\": \"3\", \n" +
            "                \"pic\": \"http://172.168.18.63:9999/ImageUploadServer/image/201701/20170119174245_459.png\", \n" +
            "                \"name\": \"名称2\", \n" +
            "                \"title\": \"标题2\", \n" +
            "                \"content\": \"内容2\", \n" +
            "                \"thumbnail\": \"http://172.168.18.63:9999/ImageUploadServer/image/201701/20170119174243_70.png\", \n" +
            "                \"type\": \"0\"\n" +
            "            }, \n" +
            "            {\n" +
            "                \"id\": \"1\", \n" +
            "                \"pic\": \"http://172.168.18.63:9999/ImageUploadServer/image/201701/20170119174045_769.png\", \n" +
            "                \"name\": \"名称1\", \n" +
            "                \"title\": \"标题1\", \n" +
            "                \"content\": \"内容1\", \n" +
            "                \"thumbnail\": \"http://172.168.18.63:9999/ImageUploadServer/image/201701/20170119174043_863.png\", \n" +
            "                \"type\": \"0\"\n" +
            "            }, \n" +
            "            {\n" +
            "                \"id\": \"2\", \n" +
            "                \"pic\": \"http://172.168.18.63:9999/ImageUploadServer/image/201701/20170119174045_769.png\", \n" +
            "                \"name\": \"名称1\", \n" +
            "                \"title\": \"标题1\", \n" +
            "                \"content\": \"内容1\", \n" +
            "                \"thumbnail\": \"http://172.168.18.63:9999/ImageUploadServer/image/201701/20170119174043_863.png\", \n" +
            "                \"type\": \"0\"\n" +
            "            }\n" +
            "        ]\n" +
            "    }\n" +
            "}</code></pre></div>" +
            "")
    @RequestMapping(value = "/api/invitationCard/list", method = RequestMethod.POST)
    @ResponseBody
    public String list() {
      String returnMsg="";
        return returnMsg;
    }
/*******************************注册激光推送registerID*************************************/
@ApiOperation(httpMethod = "POST", value = "2：注册激光推送registerID(<font color='blue'>release</font>)",position = 2,notes = "接口地址:/api/jpush/registerId/register<br>" +
        "<h4>传递参数:</h4>" +
        "1:token<br>" +
        "2:registerID registerID<br>" +
        "<h4>数据集返回结果:</h4>" +
        "<div class=\"block response_body json\"><pre class=\"json\"><code>"+
        "</code></pre></div>" +
        "")
@RequestMapping(value = "/api/jpush/registerId/register", method = RequestMethod.POST)
@ResponseBody
public String register() {
    String returnMsg="";
    return returnMsg;
}
/**********************************移除激光推送RegisterID*********************************************************/
@ApiOperation(httpMethod = "POST", value = "3：移除激光推送registerID(<font color='blue'>release</font>)",position = 3,notes = "接口地址:/api/jpush/registerId/delete<br>" +
        "<h4>传递参数:</h4>" +
        "1:token<br>" +
        "2:registerID registerID<br>" +
        "<h4>数据集返回结果:</h4>" +
        "<div class=\"block response_body json\"><pre class=\"json\"><code>"+
        "</code></pre></div>" +
        "")
@RequestMapping(value = "/api/jpush/registerId/delete", method = RequestMethod.POST)
@ResponseBody
public String delete() {
    String returnMsg="";
    return returnMsg;
}
    /**********************************我的邀请*********************************************************/
    @ApiOperation(httpMethod = "POST", value = "4：我的邀请(<font color='blue'>release</font>)",position = 4,notes = "接口地址:/api/my/invitation/list<br>" +
            "<h4>传递参数:</h4>" +
            "1:token token 必传<br>" +
            "2:pageNow pageNow 当前页码 选填<br>" +
            "3:pageSize pageSize 每页显示条数 选填<br>" +
            "<h4>数据集返回结果:isReturn 0待返 1 已返</h4>" +
            "<div class=\"block response_body json\"><pre class=\"json\"><code>"+
            "{\n" +
            "    \"code\": 0, \n" +
            "    \"message\": \"成功\", \n" +
            "    \"data\": [\n" +
            "       {\n" +
            "            \"registerUser\": \"137****5140\", \n" +
            "            \"jp\": \"50000元投资券\", \n" +
            "            \"isReturn\": 0\n" +
            "        }, \n" +
            "        {\n" +
            "            \"registerUser\": \"王艳林\", \n" +
            "            \"jp\": \"优质投资机会\", \n" +
            "            \"isReturn\": 0\n" +
            "        }, \n" +
            "        {\n" +
            "            \"registerUser\": \"王健林\", \n" +
            "            \"jp\": \"50000元投资券\", \n" +
            "            \"isReturn\": 0\n" +
            "        }, \n" + "        " +

            "        {\n" +
            "            \"registerUser\": \"王思聪\", \n" +
            "            \"jp\": \"20000元投资券\", \n" +
            "            \"isReturn\": 1\n" +
            "        }\n" +
            "    ]\n" +
            "}"+
            "</code></pre></div>" +
            "<h4>测试数据</h4>" +
            "<div>" +
            "账号：13999999994<br>" +
            "密码：111111" +
            "</div>" +
            "")
    @RequestMapping(value = "/api/my/invitation/list", method = RequestMethod.POST)
    @ResponseBody
    public String myInvitationList() {
        String returnMsg="";
        return returnMsg;
    }
    /**********************************我的卡券-》投资券*********************************************************/
    @ApiOperation(httpMethod = "POST", value = "5：我的卡券-》投资券(<font color='blue'>release</font>)",position = 5,notes = "接口地址:/api/my/card/list<br>" +
            "<h4>传递参数:</h4>" +
            "1:token token 必传<br>" +
            "2:pageNow pageNow 当前页码 选填<br>" +
            "3:pageSize pageSize 每页显示条数 选填<br>" +
            "<h4>数据集返回结果-为空时:</h4>" +
            "<div class=\"block response_body json\"><pre class=\"json\"><code>"+
            "{\n" +
            "    \"code\": 0, \n" +
            "    \"message\": \"成功\", \n" +
            "    \"data\": {\n" +
            "        \"tzqCount\": 0, \n" +
            "        \"qioCount\": 0\n" +
            "    }\n" +
            "}"+
            "</code></pre></div>" +
            "<h4>数据集返回结果-有结果:</h4>" +
            "<div class=\"block response_body json\"><pre class=\"json\"><code>"+
            "{\n" +
            "    \"code\": 0, \n" +
            "    \"message\": \"成功\", \n" +
            "    \"data\": {\n" +
            "        \"tzqCount\": 2, \n" +
            "        \"tzqList\": [\n" +
            "            {\n" +
            "                \"title\": \"50000元投资券\", \n" +
            "                \"status\": 0\n" +
            "            }, \n" +
            "            {\n" +
            "                \"title\": \"20000元投资券\", \n" +
            "                \"status\": 1\n" +
            "            }\n" +
            "        ], \n" +
            "        \"qioCount\": 1\n" +
            "    }\n" +
            "}" +
            "}"+
            "</code></pre></div>" +
            "<h4>部分字段解析:</h4>" +
            "<div>" +
            "tzqCount:投资券个数<br>" +
            "qioCount:优质投资机会个数<br>" +
            "status:0 未使用 1 已使用<br>" +
            "</div>" +
            "<h4>测试数据</h4>" +
            "<div>" +
            "账号：13999999994<br>" +
            "密码：111111" +
            "</div>" +
            "")
    @RequestMapping(value = "/api/my/card/list", method = RequestMethod.POST)
    @ResponseBody
    public String myTzqList() {
        String returnMsg="";
        return returnMsg;
    }
    /**********************************我的卡券-》投资券*********************************************************/
    @ApiOperation(httpMethod = "POST", value = "6：我的卡券-》优质投资机会(<font color='blue'>release</font>)",position = 5,notes = "接口地址:/api/my/qio/list<br>" +
            "<h4>传递参数:</h4>" +
            "1:token token 必传<br>" +
            "2:pageNow pageNow 当前页码 选填<br>" +
            "3:pageSize pageSize 每页显示条数 选填<br>" +
            "<h4>数据集返回结果:</h4>" +
            "<div class=\"block response_body json\"><pre class=\"json\"><code>"+
            "{\n" +
            "    \"code\": 0, \n" +
            "    \"message\": \"成功\", \n" +
            "    \"data\": {\n" +
            "        \"qioList\": [\n" +
            "            {\n" +
            "                \"title\": \"优质投资机会\", \n" +
            "                \"status\": 0\n" +
            "            }\n" +
            "        ]\n" +
            "    }\n" +
            "}"+
            "</code></pre></div>" +
            "<h4>字段解析：status 0 未使用 1 已使用</h4>"+
            "<h4>测试数据</h4>" +
            "<div>" +
            "账号：13999999994<br>" +
            "密码：111111" +
            "</div>" +
            "")
    @RequestMapping(value = "/api/my/qio/list", method = RequestMethod.POST)
    @ResponseBody
    public String myQioList() {
        String returnMsg="";
        return returnMsg;
    }
}
