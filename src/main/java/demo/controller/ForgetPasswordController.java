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
@Api(value = "9:找回密码接口", description = "找回密码API",position = 2,produces = "application/json")
public class ForgetPasswordController {
    @Autowired
    UserMapper userMapper;
    @ApiOperation(httpMethod = "POST", value = "找回密码API(<font color='blue'>release</font>)",position = 1,nickname = "找回密码API", notes = "当点击下一步的时候，需要传递mobiel和vcode<br>" +
            "当点击确认修改的时候，需要再传递password<br><h4>传递参数:</h4><br>" +
            "<table border='1' cellspacing='10' cellpadding='10'><tr><th>字段</th><th>备注</th><th>是否为空</th></tr>" +
            "<tr><td>mobile</td><td>手机号码</td> <td>否</td></tr>" +
            "<tr><td>vcode</td><td>手机号码</td> <td>否</td></tr>" +
            "<tr><td>password</td><td>密码</td> <td>当手机号码存在，并且验证码正确的情况下，需要输入passwrd进行更新操作</td></tr>" +
            "</table>" +
            "<h4>返回字段:</h4>" +
            "<h4>1：当手机号码格式错误的时候:</h4>" +
            "<div class=\"block response_body json\"><pre class=\"json\"><code>{\"message\":\"手机号码格式错误\",\"data\":null,\"code\":1004}</code></pre></div>" +
            "<h4>手机号码未注册时返回</h4>" +
            "<div class=\"block response_body json\"><pre class=\"json\"><code>{\"code\":1025,\"message\":\"该手机号码未注册\",\"data\":null}</code></pre></div>" +
            "<h4>2:当密码格式输入错误的时候返回:</h4>" +
            "<div class=\"block response_body json\"><pre class=\"json\"><code>{\"message\":\"密码格式错误,正确格式6-16位字母或数字\",\"data\":null,\"code\":1007}</code></pre></div>" +
            "<h4>信息校验成功返回</h4>" +
            "<div class=\"block response_body json\"><pre class=\"json\"><code>{\"code\":1026,\"message\":\"密码更新成功\",\"data\":null}</code></pre></div>"
    )
    @RequestMapping(value = "/api/user/findPassword", method = RequestMethod.POST)
    @ResponseBody
    public Object login1(@RequestParam String mobile, @RequestParam String vcode,@RequestParam String password,HttpServletRequest request){
        String myJsonData="";
        return myJsonData;
    }


}
