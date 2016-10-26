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
@Api(value = "十:产品预约API接口文档", description = "未登陆用户预约",position = 10,produces = "application/json")
public class RmFundAPI {
    @Autowired
    UserMapper userMapper;

    @ApiOperation(httpMethod = "POST", value = "(<font color='blue'>未登陆用户产品预约</font>)",position = 1,nickname = "未登陆用户产品预约", notes = "<font color='green'>传递参数</font>" +
            "<table border=\"1\"><tr><th>字段</th><th>是否为空</th><th>\t备注</th></tr>" +
            "<tr><td>userName</td><td>否</td><td>用户名</td></tr>" +
            "<tr><td>mobile</td><td>否</td><td>手机号码</td></tr>" +
            "<tr><td>productId</td><td>否</td><td>产品id</td></tr>" +
            "<tr><td>preDate</td><td>否</td><td>预约日期</td></tr></table>" +
            "<h4>返回结果情况如下：</h4>" +
            "1：<div class=\"block response_body json\"><pre class=\"json\"><code>{\r\"code\":1013,\n\"message\":\"用户名错误请输入3-20位字母或数字\",\n\"data\":null\n}</code></pre></div>" +
            "2：<div class=\"block response_body json\"><pre class=\"json\"><code>{\r\"code\":1004,\n\"message\":\"手机号码格式错误\",\n\"data\":null\n}</code></pre></div>" +
            "3：<div class=\"block response_body json\"><pre class=\"json\"><code>{\r\"code\":1033,\r\"message\":\"日期格式错误\",\r\"data\":null\r}</code></pre></div>" +
            "4：<div class=\"block response_body json\"><pre class=\"json\"><code>{\r\"code\":1034,\r\"message\":\"预约的产品不存在\",\r\"data\":null\r}</code></pre></div>" +
            "5：<div class=\"block response_body json\"><pre class=\"json\"><code>{\n\"code\":0,\n\"message\":\"成功\",\n\"data\":null\n}</code></pre></div>" )
    /*
	 * 用户认证API接口 第一步
	 */
    @RequestMapping(value = "/api/fund/rm1", method = RequestMethod.POST)
    @ResponseBody
    public Object step1(@RequestParam String userName, @RequestParam String mobile,@RequestParam String productId,@RequestParam String preDate, HttpServletRequest request) {
        String myJsonData="";
        return myJsonData;
    }

    @ApiOperation(httpMethod = "POST", value = "(<font color='blue'>已登陆用户产品预约</font>)",position = 2,nickname = "已登陆用户产品预约", notes = "<font color='green'>传递参数</font>:<br>" +
            "<table border=\"1\"><tr><th>字段</th><th>是否为空</th><th>\t备注</th></tr>" +
            "<tr><td>token</td><td>否</td><td>token</td></tr>" +
            "<tr><td>productId</td><td>否</td><td>产品id</td></tr>" +
            "<tr><td>preDate</td><td>否</td><td>预约日期</td></tr></table>" +
            "<div><h4>返回结果：</h4></div>"+
            "1:<div class=\"block response_body json\"><pre class=\"json\"><code>{\r\"code\":1005,\r\"message\":\r\"token无效\",\r\"data\":null\r}</code></pre></div>"+
            "2:<div class=\"block response_body json\"><pre class=\"json\"><code>{\n\"code\":1018,\n\"message\":\"金融资产量错误，只能为数字\",\n\"data\":null\n}</code></pre></div>"+
            "3:<div class=\"block response_body json\"><pre class=\"json\"><code>{\n\"code\":0,\n\"message\":\"成功\",\n\"data\":null\n}</code></pre></div>"
    )
    /*
	 * 用户认证API接口 第二步
	 */
    @RequestMapping(value = "/api/fund/rm2", method = RequestMethod.POST)
    @ResponseBody
    public Object step2(@RequestParam String productId,@RequestParam String preDate,@RequestParam String token, HttpServletRequest request) {
        String myJsonData="";
        return myJsonData;
    }
    @ApiOperation(httpMethod = "POST", value = "(<font color='blue'>我的约谈</font>)",position = 2,nickname = "我的约谈", notes = "<font color='green'>传递参数</font>:<br>" +
            "<table border=\"1\"><tr><th>字段</th><th>是否为空</th><th>\t备注</th></tr>" +
            "<tr><td>token</td><td>否</td><td>token</td></tr>" +
            "<div><h4>返回结果：</h4></div>"+
            "1没有数据的情况返回:<div class=\"block response_body json\"><pre class=\"json\"><code>{\r\"code\":0,\r\"message\":\"成功\",\r\"data\":null\r}</code></pre></div>"+
            "2有数据时返回:<div class=\"block response_body json\"><pre class=\"json\"><code>{\n\"code\":0,\n\"message\":\"成功\",\n\"data\":\n[\r{\r\"rmFundName\":\"晨晖新经济产业并购投资基金\",\n\"preDate\":1477411200000\n}," +
            "\r{\"rmFundName\":\"清科立思辰互联网教育并购基金\",\n\"preDate\":1477324800000\r},\n" +
            "\r{\"rmFundName\":\"清科立思辰互联网教育并购基金\",\n\"preDate\":1477324800000\n}\n]\n}" +
            "</code></pre></div>"
    )
    /*
	 *我的约谈
	 */
    @RequestMapping(value = "/api/my/rmFund", method = RequestMethod.POST)
    @ResponseBody
    public Object step3(@RequestParam String token, HttpServletRequest request) {
        String myJsonData="";
        return myJsonData;
    }


}
