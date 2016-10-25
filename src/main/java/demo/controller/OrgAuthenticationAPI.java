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

    @ApiOperation(httpMethod = "POST", value = "(<font color='blue'>机构用户认证第一步</font>)",position = 1,nickname = "机构用户认证第一步", notes = "<h2>传递参数</h2>:<br>" +
            "<table border=\"1\"><tr><th>字段</th><th>是否为空</th><th>\t备注</th></tr>" +
            "<tr><td>orgName</td><td>否</td><td>机构名称</td></tr>" +
            "<tr><td>orgDutypersonName</td><td>否</td><td>机构负责人名称</td></tr>" +
            "<tr><td>orgDutypersonPosition</td><td>否</td><td>机构负责人职位</td></tr>" +
            "<tr><td>orgDutypepsonEmaile</td><td>否</td><td>机构负责人邮箱</td></tr>" +
            "<tr><td>token</td><td>否</td><td>token</td></tr></table>" +
            "<div>返回结果分析：</div>"+
            "1:{\"code\":1029,\"message\":\"机构名称填写错误,请填写1-50数字、字母、中文\",\"data\":null}"+
            "2:{\"code\":1030,\"message\":\"机构负责人名称填写错误,请填写1-50数字、字母、中文\",\"data\":null}"+
            "3:{\"code\":1032,\"message\":\"机构负责人邮箱填写错误\",\"data\":null}"+
            "4:{\"code\":1005,\"message\":\"token无效\",\"data\":null}"+
            "5:{\"code\":0,\"message\":\"成功\",\"data\":null}"
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

    @ApiOperation(httpMethod = "POST", value = "(<font color='blue'>机构用户认证第二步</font>)",position = 2,nickname = "机构用户认证第二步", notes = "<h2>传递参数</h2>:<br>" +
            "<table border=\"1\"><tr><th>字段</th><th>是否为空</th><th>\t备注</th></tr>" +
            "<tr><td>orgAssets</td><td>否</td><td>机构净资产</td></tr>" +
            "<tr><td>token</td><td>否</td><td>token</td></tr></table>" +
            "<div>返回结果：</div>" +
            "<div>1：{\"code\":1024,\"message\":\"机构净资产错误，只能为数字\",\"data\":null}</div>" +
            "<div>2：{\"code\":1005,\"message\":\"token无效\",\"data\":null}</div>" +
            "<div>3：{\"code\":0,\"message\":\"成功\",\"data\":null}</div>"
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


    @ApiOperation(httpMethod = "POST", value = "(<font color='blue'>机构用户认证第三步</font>)",position = 3,nickname = "机构用户认证第三步", notes = "<h2>传递参数</h2>:<br>" +
            "<table border=\"1\"><tr><th>字段</th><th>是否为空</th><th>\t备注</th></tr>" +
            "<tr><td>ORG_PERSON_CARD_URL</td><td>否</td><td>机构负责人照片：需要将form-data; name=ORG_PERSON_CARD_URL</td></tr>" +
            "<tr><td>ORG_LICENSE_URL</td><td>否</td><td>机构营业执照：需要将form-data; name=ORG_LICENSE_URL</td></tr>" +
            "<tr><td>token</td><td>否</td><td>token</td></tr></table>" +
            "<div><h1><font color='red'>返回结果：</font></h1></div>" +
            "<div>1:{\"code\":1028,\"message\":\"图片没有上传\",\"data\":null}</div>" +
            "<div>2:{\"code\":0,\"message\":\"成功\",\"data\":null}</div>"
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


    @ApiOperation(httpMethod = "POST", value = "(<font color='blue'>批量更新机构用户信息</font>)",position = 3,nickname = "批量更新机构用户信息", notes = "<h2>传递参数</h2>:<br>" +
            "<table border=\"1\"><tr><th>字段</th><th>是否为空</th><th>\t备注</th></tr>" +
            "<tr><td>orgName</td><td>否</td><td>机构名称</td></tr>" +
            "<tr><td>orgDutypersonName</td><td>否</td><td>机构负责人名称</td></tr>" +
            "<tr><td>orgDutypersonPosition</td><td>否</td><td>机构负责人职位</td></tr>" +
            "<tr><td>orgDutypepsonEmaile</td><td>否</td><td>机构负责人邮箱</td></tr>" +
            "<tr><td>orgAssets</td><td>否</td><td>机构净资产</td></tr>" +
            "<tr><td>ORG_PERSON_CARD_URL</td><td>否</td><td>机构负责人照片：需要将form-data; name=ORG_PERSON_CARD_URL</td></tr>" +
            "<tr><td>ORG_LICENSE_URL</td><td>否</td><td>机构营业执照：需要将form-data; name=ORG_LICENSE_URL</td></tr>" +
            "<tr><td>token</td><td>否</td><td>token</td></tr></table>" )
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
