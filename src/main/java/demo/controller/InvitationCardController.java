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
            "<h4>友情提示，/api/user/getStepAndStatus此接口新增返回结果字段yqmCode:邀请码</h4>" +
            "<h4>字段解析:</h4>" +
            "1:pic 图片<br>" +
            "2:name 名称<br>" +
            "3:title 标题<br>" +
            "4:content 内容<br>" +
            "5:thumbnail 缩略图<br>" +
            "6:type 0 默认 1 其他<br>" +
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

}
