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
@Api(value = "5:验证码API接口", description = "短信验证码和图形验证码",position = 1,produces = "application/json")
public class CodeController {
    @Autowired
    UserMapper userMapper;

    @ApiOperation(httpMethod = "POST", value = "获取短信验证码",position = 1,nickname = "获取短信验证码接口", notes = "传递参数:<br>" +
            "mobile:手机号码 必填字段<br>" +
            "codeImage:当验证码输入错误三次以后codeImage必须传递" )
    @RequestMapping(value = "/api/code/getCode", method = RequestMethod.POST)
    @ResponseBody
    public Object getCode(@RequestParam String mobile, HttpServletRequest request, String codeImage){
        String myJsonData="";
        return myJsonData;
    }

    @ApiOperation(httpMethod = "GET", value = "获取图形验证码",position = 2,nickname = "获取图形验证码", notes="当验证码连续输入错误3次以上需要获取图形验证码")
    @RequestMapping(value = "/api/code/imgCode.act", method = RequestMethod.POST)
    @ResponseBody
    public Object getImageCode(){
        String myJsonData="";
        return myJsonData;
    }

}
