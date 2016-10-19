package demo.controller;

/**
 * Created by Administrator on 2016/10/11.
 */

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import demo.service.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by wangwei on 2016/9/2.
 */
@RestController
@Api(value = "4:获取token API接口", description = "根据token获取用户信息",position = 2,produces = "application/json")
public class TokenController {
    @Autowired
    UserMapper userMapper;

    @ApiOperation(httpMethod = "POST", value = "根据token获取用户信息(<font color='blue'>release</font>)",position = 1,nickname = "获取token接口", notes = "<h2>传递参数</h2>:<br>" +
            "<ur><li>token: 必填字段</li><br>" +
            "<h2>返回字段</h2>:<br>" +
            "token无效是：{\"message\":\"token无效\",\"data\":\"[]\",\"code\":1005}")
    @RequestMapping(value = "/api/tokens/get", method = RequestMethod.POST)
    @ResponseBody
    public Object getToken(@RequestParam String token){
        String myJsonData="";
        return myJsonData;
    }


}
