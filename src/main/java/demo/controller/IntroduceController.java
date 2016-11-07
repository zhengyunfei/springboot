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
@Api(value = "h：财富街简介API接口", description = "财富街简介API接口", produces = "application/json",position =15 )
public class IntroduceController {
    @Autowired
    UserMapper userMapper;

    @ApiOperation(httpMethod = "GET", value = "财富街简介API接口",position = 1,nickname = "财富街简介", notes = "" +
            "直接调用url"

    )
    @RequestMapping(value = "/api/html/introduce", method = RequestMethod.GET)
    @ResponseBody
    public Object uploadHeadUrl(@RequestParam String token){
        String myJsonData="";
        return myJsonData;
    }



}
