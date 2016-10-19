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
 * Created by wangwei on 2016/9/2.
 */
@RestController
@Api(value = "3:用户注册API接口", description = "用户注册",position = 2,produces = "application/json")
public class RegisterController {
    @Autowired
    UserMapper userMapper;

    @ApiOperation(httpMethod = "POST", value = "用户注册(<font color='blue'>release</font>)",position = 1,nickname = "获取短信验证码接口", notes = "<h2>传递参数</h2>:<br>" +
            "<ur><li>mobile:手机号码 必填字段</li><br>" +
            "<li>vcode:验证码 必填字段</li><br>" +
            "<li>password:密码 必填字段 格式6-16位字母加数字</li><br>" +
            "<li>codeImage:当验证码输入错误三次以后codeImage必填</li></ul><br>" +
            "<h2>返回字段</h2>:<br>" +
            "1：当手机号码格式错误的时候:<br>" +
            "{\"message\":\"手机号码格式错误\",\"data\":null,\"code\":1004}<br>" +
            "2:当密码格式输入错误的时候返回:<br>" +
            "{\"message\":\"密码格式错误,正确格式6-16位字母或数字\",\"data\":null,\"code\":1007}<br>" +
            "3:当验证码输入错误的时候返回:<br>" +
            "{\"message\":\"验证码错误\",\"data\":{\"count\":1},\"code\":1008}count:表示错误次数 <br>" +
            "4:当信息填写正确的时候返回token:<br>" +
            "{\"message\":\"ok\",\"data\":{\"token\":1234678905618},\"code\":0}" )
    @RequestMapping(value = "/api/user/register", method = RequestMethod.POST)
    @ResponseBody
    public Object getCode(@RequestParam String mobile, @RequestParam String vcode,@RequestParam String password,HttpServletRequest request, String codeImage){
        String myJsonData="";
        return myJsonData;
    }


}
