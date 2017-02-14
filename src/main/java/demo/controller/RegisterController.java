package demo.controller;

/**
 * Created by Administrator on 2016/10/11.
 */

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import demo.service.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhengyunfei on 2016/9/2.
 */
@RestController
@Api(value = "3:用户注册API接口", description = "用户注册",position = 2,produces = "application/json")
public class RegisterController {
    @Autowired
    UserMapper userMapper;

    @ApiOperation(httpMethod = "POST", value = "用户注册(<font color='blue'>release</font>)",position = 1,nickname = "获取短信验证码接口", notes = "<h4>传递参数:</h4><br>" +
            "<table border='1' cellspacing='10' cellpadding='10'><tr><th>字段</th><th>备注</th><th>是否为空</th></tr>" +
            "<tr><td>mobile</td><td>手机号码</td> <td>否</td></tr>" +
            "<tr><td>vcode</td><td>验证码</td> <td>否</td></tr>" +
            "<tr><td>password</td><td>密码</td> <td>否</td></tr>" +
            "<tr><td>source</td><td>来源:ios请传递iOS，android请传递Android</td> <td>否</td></tr>" +
            "<tr><td>codeImage</td><td>图形验证码</td> <td>当验证码输入错误三次以后codeImage必填</td></tr>" +
            "<tr><td>yqmCode</td><td>邀请码</td> <td><font color='red'>是。通过邀请卡分享传递过来邀请码yqmCode-->h5专用</font></td></tr>" +
            "</table>" +
            "<h4>返回字段:</h4>" +
            "<h4>1：当手机号码格式错误的时候:</h4>" +
            "<div class=\"block response_body json\"><pre class=\"json\"><code>{\"message\":\"手机号码格式错误\",\"data\":null,\"code\":1004}</code></pre></div>" +
            "<h4>2:当密码格式输入错误的时候返回:</h4>" +
            "<div class=\"block response_body json\"><pre class=\"json\"><code>{\"message\":\"密码格式错误,正确格式6-16位字母或数字\",\"data\":null,\"code\":1007}</code></pre></div>" +
            "<h4>3:当验证码输入错误的时候返回:</h4>" +
            "<div class=\"block response_body json\"><pre class=\"json\"><code>{\"message\":\"验证码错误\",\"data\":{\"count\":1},\"code\":1008}count:表示错误次数 </code></pre></div>" +
            "<h4>3:当source未传递时:</h4>" +
            "<div class=\"block response_body json\"><pre class=\"json\"><code>{\"message\":\"非法操作\",\"data\":null,\"code\":1043} </code></pre></div>" +
            "<h4>4:当信息填写正确的时候返回token:</h4>" +
            "<div class=\"block response_body json\"><pre class=\"json\"><code>{\"message\":\"ok\",\"data\":{\"token\":1234678905618},\"code\":0}</code></pre></div>" )
    @RequestMapping(value = "/api/user/register", method = RequestMethod.POST)
    @ResponseBody
    public Object getCode(@RequestParam String mobile, @RequestParam String vcode,@RequestParam String password,HttpServletRequest request, String codeImage){
        String myJsonData="";
        return myJsonData;
    }


}
