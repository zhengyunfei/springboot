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
@Api(value = "7:机构机构用户认证API接口", description = "机构机构用户认证",position = 2,produces = "application/json")
public class OrgAuthenticationAPI {
    @Autowired
    UserMapper userMapper;

    @ApiOperation(httpMethod = "POST", value = "(<font color='blue'>机构用户认证第一步</font>)",position = 1,nickname = "机构用户认证第一步", notes = "<h4>传递参数</h4>:<br>" +
            "<table border=\"1\"><tr><th>字段</th><th>是否为空</th><th>\t备注</th></tr>" +
            "<tr><td>orgName</td><td>否</td><td>机构名称</td></tr>" +
            "<tr><td>orgDutypersonName</td><td>否</td><td>机构负责人名称</td></tr>" +
            "<tr><td>orgDutypersonPosition</td><td>否</td><td>机构负责人职位</td></tr>" +
            "<tr><td>orgDutypepsonEmaile</td><td>否</td><td>机构负责人邮箱</td></tr>" +
            "<tr><td>token</td><td>否</td><td>token</td></tr></table>" +
            "<h4>返回结果分析：</h4>"+
            "1:<div class=\"block response_body json\"><pre class=\"json\"><code>{\r\"code\":1029,\n\"message\":\"机构名称填写错误,请填写1-50数字、字母、中文\",\n\"data\":null\n}</code></pre></div>"+
            "2:<div class=\"block response_body json\"><pre class=\"json\"><code>{\n\"code\":1030,\n\"message\":\"机构负责人名称填写错误,请填写1-50数字、字母、中文\",\n\"data\":null\n}</code></pre></div>"+
            "3:<div class=\"block response_body json\"><pre class=\"json\"><code>{\n\"code\":1032,\n\"message\":\"机构负责人邮箱填写错误\",\n\"data\":null\n}</code></pre></div>"+
            "4:<div class=\"block response_body json\"><pre class=\"json\"><code>{\n\"code\":1005,\n\"message\":\"token无效\",\n\"data\":null\n}</code></pre></div>"+
            "5:<div class=\"block response_body json\"><pre class=\"json\"><code>{\n\"code\":0,\n\"message\":\"成功\",\n\"data\":null\n}</code></pre></div>"
    )
    /*
	 * 机构用户认证API接口 第一步
	 */
    @RequestMapping(value = "/api/orz/step1", method = RequestMethod.POST)
    @ResponseBody
    public Object step1(@RequestParam String orgName, @RequestParam String orgDutypersonName, @RequestParam String orgDutypersonPosition,@RequestParam String orgDutypepsonEmaile,@RequestParam String token, HttpServletRequest request) {
        String myJsonData="";
        return myJsonData;
    }

    @ApiOperation(httpMethod = "POST", value = "(<font color='blue'>机构用户认证第二步</font>)",position = 2,nickname = "机构用户认证第二步", notes = "<h4>传递参数</h4>:<br>" +
            "<table border=\"1\"><tr><th>字段</th><th>是否为空</th><th>\t备注</th></tr>" +
            "<tr><td>orgAssets</td><td>否</td><td>机构净资产</td></tr>" +
            "<tr><td>token</td><td>否</td><td>token</td></tr></table>" +

            "<h4>orgAessets字段解析</h4>" +
            "<div class=\"block response_body json\"><pre class=\"json\"><code>"+
            "\n" +
            "{\"orgAssets\":{\n" +
            "\"1\":\"一亿以下\",\n" +
            "\"2\":\"1-100亿元\",\n" +
            "\"3\":\"10-100亿元\",\n" +
            "\"4\":\"500亿以上\",\n" +
            "}}"+
            "</code></pre></div>"+
            "<h4>返回结果：</h4>" +
            "2：<div class=\"block response_body json\"><pre class=\"json\"><code>{\n\"code\":1005,\n\"message\":\"token无效\",\n\"data\":null\n}</code></pre></div>" +
            "3：<div class=\"block response_body json\"><pre class=\"json\"><code>{\n\"code\":0,\n\"message\":\"成功\",\n\"data\":null\n}</code></pre></div>"
    )
    /*
	 * 机构用户认证API接口 第二步
	 */
    @RequestMapping(value = "/api/orz/step2", method = RequestMethod.POST)
    @ResponseBody
    public Object step2(@RequestParam String orgAssets,@RequestParam String token, HttpServletRequest request) {
        String myJsonData="";
        return myJsonData;
    }


    @ApiOperation(httpMethod = "POST", value = "(<font color='blue'>机构用户认证第三步</font>)",position = 3,nickname = "机构用户认证第三步", notes = "<h4>传递参数</h4>:<br>" +
            "<table border=\"1\"><tr><th>字段</th><th>是否为空</th><th>\t备注</th></tr>" +
            "<tr><td>ORG_PERSON_CARD_URL</td><td>否</td><td>机构负责人照片：需要将form-data; name=ORG_PERSON_CARD_URL</td></tr>" +
            "<tr><td>ORG_LICENSE_URL</td><td>否</td><td>机构营业执照：需要将form-data; name=ORG_LICENSE_URL</td></tr>" +
            "<tr><td>token</td><td>否</td><td>token</td></tr></table>" +
            "<h4>返回结果：</h4>" +
            "1:<div class=\"block response_body json\"><pre class=\"json\"><code>{\n\"code\":1028,\n\"message\":\"图片没有上传\",\n\"data\":null\n}</code></pre></div>" +
            "2:<div class=\"block response_body json\"><pre class=\"json\"><code>{\n\"code\":0,\n\"message\":\"成功\",\n\"data\":null\n}</code></pre></div>"
    )
    /*
	 * 机构用户认证API接口 第三步
	 */
    @RequestMapping(value = "/api/orz/step3", method = RequestMethod.POST)
    @ResponseBody
    public Object step3(@RequestParam String ORG_PERSON_CARD_URL, @RequestParam String ORG_LICENSE_URL,@RequestParam String token, HttpServletRequest request) {
        String myJsonData="";
        return myJsonData;
    }


    @ApiOperation(httpMethod = "POST", value = "(<font color='blue'>批量更新机构用户信息</font>)",position = 3,nickname = "批量更新机构用户信息", notes = "<h4>传递参数</h4>:<br>" +
            "<table border=\"1\"><tr><th>字段</th><th>是否为空</th><th>\t备注</th></tr>" +
            "<tr><td>orgName</td><td>否</td><td>机构名称</td></tr>" +
            "<tr><td>orgDutypersonName</td><td>否</td><td>机构负责人名称</td></tr>" +
            "<tr><td>orgDutypersonPosition</td><td>否</td><td>机构负责人职位</td></tr>" +
            "<tr><td>orgDutypepsonEmaile</td><td>否</td><td>机构负责人邮箱</td></tr>" +
            "<tr><td>orgAssets</td><td>否</td><td>机构净资产</td></tr>" +
            "<tr><td>ORG_PERSON_CARD_URL</td><td>否</td><td>机构负责人照片：需要将form-data; name=ORG_PERSON_CARD_URL</td></tr>" +
            "<tr><td>ORG_LICENSE_URL</td><td>否</td><td>机构营业执照：需要将form-data; name=ORG_LICENSE_URL</td></tr>" +
            "<tr><td>token</td><td>否</td><td>token</td></tr></table>"+
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
    /*
	 * 批量更新机构用户信息
	 */
    @RequestMapping(value = "/api/orz/step4", method = RequestMethod.POST)
    @ResponseBody
    public Object step4(@RequestParam String orgName, @RequestParam String orgDutypersonName, @RequestParam String orgDutypersonPosition,@RequestParam String orgDutypepsonEmaile,@RequestParam String orgAssets,@RequestParam String ORG_PERSON_CARD_URL, @RequestParam String ORG_LICENSE_URL,@RequestParam String token, HttpServletRequest request) {
        String myJsonData="";
        return myJsonData;
    }

}
