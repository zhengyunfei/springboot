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
 */
@RestController
@Api(value = "4:根据token获取个人或者机构基本信息API接口", description = "根据token获取基本信息",position = 2,produces = "application/json")
public class TokenUserInfoController {
    @Autowired
    UserMapper userMapper;


    @ApiOperation(httpMethod = "POST", value = "根据token获取用户注册步骤以及认证审核状态(<font color='blue'>release</font>)",position = 1,nickname = "获取用户认证审核状态", notes = "<h4>传递参数</h4>" +
            "<table><tr><th>字段</th><th>是否为空</th><th>备注</th></tr>" +
            "<tr><td>token</td><td>否</td><td>token</td></tr></table>" +
            "<h4>返回字段</h4>" +
            "<div class=\"block response_body json\"><pre class=\"json\"><code>{\n\"message\":\"token无效\",\n\"data\":\"[]\",\n\"code\":1005\n}</code></pre></div>"+
            "<h4>成功时返回:</h4>"+
            "<div class=\"block response_body json\"><pre class=\"json\"><code>" +
            "{\r\"code\":0,\n\"message\":\"成功\",\n\"data\":{\n\"userName\":\"令狐冲\",\n\"mobile\":\"13717625140\",\n\"userStatus\":0,\n\"userRegisterStep\":4,\r\"headUrl\":\"\",\r\"idMark\":0}}"+
            "</code></pre></div>"+
            "<h4>用户状态解析:</h4>"+
            "<div class=\"block response_body json\"><pre class=\"html\"><code>userStatus:0信息未完善1审核中2审核通过3审核不通过4冻结</code></pre></div>"+
            "<h4>idMark状态解析:</h4>"+
            "<div class=\"block response_body json\"><pre class=\"html\"><code>idMark:0未知身份1个人用户2机构用户</code></pre></div>"
    )
    @RequestMapping(value = "/api/user/getStepAndStatus", method = RequestMethod.POST)
    @ResponseBody
    public Object getUserStepAndStatus(@RequestParam String token){
        String myJsonData="";
        return myJsonData;
    }

    @ApiOperation(httpMethod = "POST", value = "根据token获取个人基本信息第一步(<font color='blue'>release</font>)",position = 1,nickname = "个人基本信息第一步", notes = "<h4>传递参数</h4>:<br>" +
            "<table><tr><th>字段</th><th>是否为空</th><th>备注</th></tr>" +
            "<tr><td>token</td><td>否</td><td>token</td></tr></table>" +
            "<h4>返回字段</h4>" +
            "<div class=\"block response_body json\"><pre class=\"json\"><code>{\n\"message\":\"token无效\",\n\"data\":\"[]\",\n\"code\":1005\n}</code></pre></div>"+
            "<h4>成功时返回:</h4>"+
            "<div class=\"block response_body json\"><pre class=\"json\"><code>{\n\"code\":0,\n\"message\":\"成功\",\n\"data\":{\n\"userName\":\"zhengyunfei\",\n\"sex\":\"男\",\n\"maile\":\"455@qq.com\",\r\"idCard\":\"411422198809101311\"\n}\n}</code></pre></div>"
    )
    @RequestMapping(value = "/api/user/getTokenUserInfoStep1", method = RequestMethod.POST)
    @ResponseBody
    public Object getToken1(@RequestParam String token){
        String myJsonData="";
        return myJsonData;
    }
    @ApiOperation(httpMethod = "POST", value = "根据token获取个人基本信息第二步(<font color='blue'>release</font>)",position = 2,nickname = "个人基本信息第二步", notes = "<h4>传递参数</h4>:<br>" +
            "<table><tr><th>字段</th><th>是否为空</th><th>备注</th></tr>" +
            "<tr><td>token</td><td>否</td><td>token</td></tr></table>" +
            "<h4>token无效时返回字段</h4>" +
            "<div class=\"block response_body json\"><pre class=\"json\"><code>{\n\"message\":\"token无效\",\n\"data\":\"[]\",\n\"code\":1005\n}</code></pre></div>"+
            "<h4>成功时返回:</h4>"+
            "<div class=\"block response_body json\"><pre class=\"json\"><code>{\n\"code\":0,\n\"message\":\"成功\",\n\"data\":{\n\"company\":\"清科就团22222\",\n\"position\":\"清科集团测试\",\n\"assest\":\"2\",\n\"arpm\":\"1\"\n}\n}</code></pre></div>"+
            "<h4>assest字段解析</h4>" +
            "<div class=\"block response_body json\"><pre class=\"json\"><code>"+
            "\n" +
            "{\"assest\":{\n" +
            "\"1\":\"200万以下\",\n" +
            "\"2\":\"200-500万元\",\n" +
            "\"3\":\"500-1000万元\",\n" +
            "\"4\":\"1000万以上\",\n" +
            "}}"+
            "</code></pre></div>"+
            "<h4>arpm字段解析</h4>" +
            "<div class=\"block response_body json\"><pre class=\"json\"><code>"+
            "\n" +
            "{\"arpm\":{\n" +
            "\"1\":\"20万以下\",\n" +
            "\"2\":\"20-50万元\",\n" +
            "\"3\":\"50-100万元\",\n" +
            "\"4\":\"200万以上\",\n" +
            "}}"+
            "</code></pre></div>"
    )
    @RequestMapping(value = "/api/user/getTokenUserInfoStep2", method = RequestMethod.POST)
    @ResponseBody
    public Object getToken2(@RequestParam String token){
        String myJsonData="";
        return myJsonData;
    }
    @ApiOperation(httpMethod = "POST", value = "根据token获取个人基本信息第三步(<font color='blue'>release</font>)",position = 3,nickname = "个人基本信息第三步", notes = "<h4>传递参数</h4>:<br>" +
            "<table><tr><th>字段</th><th>是否为空</th><th>备注</th></tr>" +
            "<tr><td>token</td><td>否</td><td>token</td></tr></table>" +
            "<h4>token无效时返回字段</h4>" +
            "<div class=\"block response_body json\"><pre class=\"json\"><code>{\n\"message\":\"token无效\",\n\"data\":\"[]\",\n\"code\":1005\n}</code></pre></div>"+
            "<h4>成功时返回:</h4>"+
            "<div class=\"block response_body json\"><pre class=\"json\"><code>{\n\"code\":0,\n\"message\":\"成功\",\n\"data\":{\n\"userCardUrl\":\"/image/20161025/201610236156326.jpg\",\n\"idCardUrl\":\"/image/20161025/201610236156326.jpg\"\n}\n}</code></pre></div>"
    )
    @RequestMapping(value = "/api/user/getTokenUserInfoStep3", method = RequestMethod.POST)
    @ResponseBody
    public Object getToken3(@RequestParam String token){
        String myJsonData="";
        return myJsonData;
    }
    @ApiOperation(httpMethod = "POST", value = "根据token获取个人完整基本信息(<font color='blue'>release</font>)",position = 4,nickname = "个人完整基本信息", notes = "<h4>传递参数</h4>:<br>" +
            "<table><tr><th>字段</th><th>是否为空</th><th>备注</th></tr>" +
            "<tr><td>token</td><td>否</td><td>token</td></tr></table>" +
            "<h4>token无效时返回字段</h4>" +
            "<div class=\"block response_body json\"><pre class=\"json\"><code>{\r\"message\":\"token无效\",\n\"data\":\"[]\",\n\"code\":1005\n}</code></pre></div>"+
            "<h4>成功时返回:</h4>"+
            "<div class=\"block response_body json\"><pre class=\"json\"><code>{" +
            "\n\"code\":0,\r" +
            "\"message\":\"成功\",\n\"data\":{\n\"sex\":\"1\",\n\"maile\":\"455@qq.com\",\n" +
            "\"userName\":\"令狐冲\",\n\"position\":\"清科集团测试\",\n\"company\":\"清科就团22222\",\n\"userCardUrl\":\"/image/20161025/201610236156326.jpg\",\n\"idCardUrl\":\"/image/20161025/201610236156326.jpg\",\n\"idCard\":\"411422198809021214\",\n\"assest\":\"1\",\n\"arpm\":\"2\"\n}\n}</code><pre></div>"+
            "<h4>assest字段解析</h4>" +
            "<div class=\"block response_body json\"><pre class=\"json\"><code>"+
            "\n" +
            "{\"assest\":{\n" +
            "\"1\":\"200万以下\",\n" +
            "\"2\":\"200-500万元\",\n" +
            "\"3\":\"500-1000万元\",\n" +
            "\"4\":\"1000万以上\",\n" +
            "}}"+
            "</code></pre></div>"+
            "<h4>arpm字段解析</h4>" +
            "<div class=\"block response_body json\"><pre class=\"json\"><code>"+
            "\n" +
            "{\"arpm\":{\n" +
            "\"1\":\"20万以下\",\n" +
            "\"2\":\"20-50万元\",\n" +
            "\"3\":\"50-100万元\",\n" +
            "\"4\":\"200万以上\",\n" +
            "}}"+
            "</code></pre></div>"
    )
    @RequestMapping(value = "/api/user/getTokenUserInfo", method = RequestMethod.POST)
    @ResponseBody
    public Object getToken(@RequestParam String token){
        String myJsonData="";
        return myJsonData;
    }

    /**************************************************************机构基本信息************************************************************/

    @ApiOperation(httpMethod = "POST", value = "根据token获取机构基本信息第一步(<font color='blue'>release</font>)",position = 5,nickname = "机构基本信息第一步", notes = "<h4>传递参数</h4>:<br>" +
            "<table><tr><th>字段</th><th>是否为空</th><th>备注</th></tr>" +
            "<tr><td>token</td><td>否</td><td>token</td></tr></table>" +
            "<h4>token无效时返回字段</h4>" +
            "<div class=\"block response_body json\"><pre class=\"json\"><code>{\n\"message\":\"token无效\",\n\"data\":\"[]\",\n\"code\":1005\n}</code></pre></div>"+
            "<h4>成功时返回</h4>" +
            "<div class=\"block response_body json\"><pre class=\"json\"><code>" +
            "{\r\"code\":0,\n\"message\":\"成功\",\n\"data\":{\n\"orgName\":\"A机构\",\n\"orgDutypersonName\":\"A机构负责人\",\n\"orgDutypersonSex\":\"男\",\n\"orgDutypepsonEmaile\":\"100@qq.com\",\n\"orgDutypersonPosition\":\"500\"\n}\n}</code></pre></div>"
    )
    @RequestMapping(value = "/api/user/getTokenOrgUserInfoStep1", method = RequestMethod.POST)
    @ResponseBody
    public Object getTokenOrgUserInfoStep1(@RequestParam String token){
        String myJsonData="";
        return myJsonData;
    }
    @ApiOperation(httpMethod = "POST", value = "根据token获取机构基本信息第二步(<font color='blue'>release</font>)",position = 6,nickname = "机构基本信息第二步", notes = "<h4>传递参数</h4>:<br>" +
            "<table><tr><th>字段</th><th>是否为空</th><th>备注</th></tr>" +
            "<tr><td>token</td><td>否</td><td>token</td></tr></table>" +
            "<h4>token无效时返回字段</h4>" +
            "<div class=\"block response_body json\"><pre class=\"json\"><code>{\n\"message\":\"token无效\",\n\"data\":\"[]\",\n\"code\":1005\n}</code></pre></div>"+
            "<h4>成功时返回</h4>" +
            "<div class=\"block response_body json\"><pre class=\"json\"><code>" +
            "\r{\"code\":0,\r\"message\":\"成功\",\r\"data\":{\r\"orgAssets\":\"1\"\r}\r}"+
            "</code></pre></div>"+
            "<h4>orgAessets字段解析</h4>" +
            "<div class=\"block response_body json\"><pre class=\"json\"><code>"+
            "\n" +
            "{\"orgAssets\":{\n" +
            "\"1\":\"一亿以下\",\n" +
            "\"2\":\"1-100亿元\",\n" +
            "\"3\":\"10-100亿元\",\n" +
            "\"4\":\"500亿以上\",\n" +
            "}}"+
            "</code></pre></div>"
    )
    @RequestMapping(value = "/api/user/getTokenOrgUserInfoStep2", method = RequestMethod.POST)
    @ResponseBody
    public Object getTokenOrgUserInfoStep2(@RequestParam String token){
        String myJsonData="";
        return myJsonData;
    }
    @ApiOperation(httpMethod = "POST", value = "根据token获取机构基本信息第三步(<font color='blue'>release</font>)",position = 7,nickname = "机构基本信息第三步", notes = "<h4>传递参数</h4>:<br>" +
            "<table><tr><th>字段</th><th>是否为空</th><th>备注</th></tr>" +
            "<tr><td>token</td><td>否</td><td>token</td></tr></table>" +
            "<h4>token无效时返回字段</h4>" +
            "<div class=\"block response_body json\"><pre class=\"json\"><code>{\n\"message\":\"token无效\",\n\"data\":\"[]\",\n\"code\":1005\n}</code></pre></div>"+
            "<h4>成功时返回</h4>" +
            "<div class=\"block response_body json\"><pre class=\"json\"><code>" +
            "{\n\"code\":0,\n\"message\":\"成功\",\n\"data\":{\n\"orgDutypersonCardurl\":\"/image/20161025/20161025633216.jpg\",\n\"orgLicenseUrl\":\"/image/20161025/20161025633216.jpg\"\n}\n}"+
            "</code></pre></div>"
    )
    @RequestMapping(value = "/api/user/getTokenOrgUserInfoStep3", method = RequestMethod.POST)
    @ResponseBody
    public Object getTokenOrgUserInfoStep3(@RequestParam String token){
        String myJsonData="";
        return myJsonData;
    }
    @ApiOperation(httpMethod = "POST", value = "根据token获取机构完整基本信息(<font color='blue'>release</font>)",position = 8,nickname = "机构完整基本信息", notes = "<h4>传递参数</h4>:<br>" +
            "<table><tr><th>字段</th><th>是否为空</th><th>备注</th></tr>" +
            "<tr><td>token</td><td>否</td><td>token</td></tr></table>" +
            "<h4>token无效时返回字段</h4>" +
            "<div class=\"block response_body json\"><pre class=\"json\"><code>{\n\"message\":\"token无效\",\n\"data\":\"[]\",\n\"code\":1005\n}</code></pre></div>"+
            "<h4>成功时返回</h4>" +
            "<div class=\"block response_body json\"><pre class=\"json\"><code>" +
            "\r{\"code\":0,\n\"message\":\"成功\",\n\"data\":{\n\"orgName\":\"A机构\",\n\"orgAssets\":\"1\",\n\"orgDutypersonName\":\"A机构负责人\",\n\"orgDutypersonSex\":\"男\",\n\"orgDutypepsonMobile\":null,\n\"orgDutypepsonEmaile\":\"100@qq.com\",\n\"orgDutypersonPosition\":\"500\",\n\"orgDutypersonCardurl\":\"/image/20161025/20161025633216.jpg\",\n\"orgLicenseUrl\":\"/image/20161025/20161025633216.jpg\"\n}\n}"+
            "</code></pre></div>"+
            "<h4>orgAessets字段解析</h4>" +
            "<div class=\"block response_body json\"><pre class=\"json\"><code>"+
            "\n" +
            "{\"orgAssets\":{\n" +
            "\"1\":\"一亿以下\",\n" +
            "\"2\":\"1-100亿元\",\n" +
            "\"3\":\"10-100亿元\",\n" +
            "\"4\":\"500亿以上\",\n" +
            "}}"+
            "</code></pre></div>"
    )
    @RequestMapping(value = "/api/user/getTokenOrgUserInfo", method = RequestMethod.POST)
    @ResponseBody
    public Object getTokenOrgUserInfo(@RequestParam String token){
        String myJsonData="";
        return myJsonData;
    }

}
