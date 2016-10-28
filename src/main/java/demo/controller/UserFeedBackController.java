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
@Api(value = "e:用户反馈API接口", description = "用户反馈API接口", produces = "application/json",position =15 )
public class UserFeedBackController {
    @Autowired
    UserMapper userMapper;

    @ApiOperation(httpMethod = "POST", value = "用户反馈",position = 1,nickname = "用户反馈", notes = "" +
            "<table border=\"1\"><tr><th>字段</th><th>是否为空</th><th>\t备注</th></tr>" +
            "<tr><td>token</td><td>否</td><td>token</td></tr>" +
            "<tr><td>content</td><td>否</td><td>反馈内容</td></tr></table>" +
            "<h4>返回结果</h4>" +
            "<h4>token无效</h4>" +
            "<div class=\"block response_body json\"><pre class=\"json\"><code>"+
            "{\"code\":1005,\"message\":\"token无效\",\"data\":null}" +
            "</code></pre></div>"+
            "<h4>content缺少</h4>" +
            "<div class=\"block response_body json\"><pre class=\"json\"><code>"+
            "{\"code\":1036,\"message\":\"反馈内容不能为空\",\"data\":null}"+
            "</code></pre></div>"+
            "<h4>成功</h4>"+
            "<div class=\"block response_body json\"><pre class=\"json\"><code>"+
            "{\"code\":0,\"message\":\"成功\",\"data\":null}"+
            "</code></pre></div>"
    )
    @RequestMapping(value = "/api/user/feekback", method = RequestMethod.POST)
    @ResponseBody
    public Object investor(@RequestParam String token,@RequestParam String content){
        String myJsonData="";
        return myJsonData;
    }


}
