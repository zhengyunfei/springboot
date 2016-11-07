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
 * Created by zhengyunfei on 2016/9/2.
 * 用户反馈api接口
 */
@RestController
@Api(value = "g：投资帮助API接口", description = "投资帮助API接口", produces = "application/json",position =15 )
public class HelpController {
    @Autowired
    UserMapper userMapper;

    @ApiOperation(httpMethod = "GET", value = "投资帮助API接口",position = 1,nickname = "上传头像", notes = "" +
            "直接调用url"

    )
    @RequestMapping(value = "/api/html/help", method = RequestMethod.GET)
    @ResponseBody
    public Object uploadHeadUrl(@RequestParam String token){
        String myJsonData="";
        return myJsonData;
    }



}
