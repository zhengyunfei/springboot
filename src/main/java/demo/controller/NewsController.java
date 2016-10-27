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
 * 新闻资讯详情api接口
 */
@RestController
@Api(value = "d:新闻资讯详情API接口", description = "新闻资讯详情API接口", produces = "application/json")
public class NewsController {
    @Autowired
    UserMapper userMapper;

    @ApiOperation(httpMethod = "GET", value = "新闻资讯详情",position = 1,nickname = "新闻资讯详情h5", notes = "" +
            "<h4>新闻资讯详情h5，直接调url就行</h4>" )
    @RequestMapping(value = "/api/news/detail", method = RequestMethod.GET)
    @ResponseBody
    public Object investor(@RequestParam String id){
        String myJsonData="";
        return myJsonData;
    }


}
