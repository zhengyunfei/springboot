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
@Api(value = "6:个人用户认证API接口", description = "个人用户认证",position = 2,produces = "application/json")
public class UserAuthenticationAPI {
    @Autowired
    UserMapper userMapper;

    @ApiOperation(httpMethod = "POST", value = "(<font color='blue'>用户认证第一步</font>)",position = 1,nickname = "用户认证第一步", notes = "<h2>传递参数</h2>:<br>" +
            "<table border=\"1\"><tr><th>字段</th><th>是否为空</th><th>备注</th></tr>" +
            "<tr><td>name</td><td>否</td><td>用户名</td></tr>" +
            "<tr><td>email</td><td>否</td><td>邮箱</td></tr>" +
            "<tr><td>idCardNo</td><td>否</td><td>身份证号码</td></tr>" +
            "<tr><td>token</td><td>否</td><td>token</td></tr>" )
    /*
	 * 用户认证API接口 第一步
	 */
    @RequestMapping(value = "/api/urz/step1", method = RequestMethod.POST)
    @ResponseBody
    public Object step1(@RequestParam String name, @RequestParam String sex, @RequestParam String email,@RequestParam String idCardNo,@RequestParam String token, HttpServletRequest request) {
        String myJsonData="";
        return myJsonData;
    }

    @ApiOperation(httpMethod = "POST", value = "(<font color='blue'>用户认证第二步</font>)",position = 2,nickname = "用户认证第二步", notes = "<h2>传递参数</h2>:<br>" +
            "<table border=\"1\"><tr><th>字段</th><th>是否为空</th><th>备注</th></tr>" +
            "<tr><td>company</td><td>否</td><td>公司名称</td></tr>" +
            "<tr><td>position</td><td>否</td><td>职位</td></tr>" +
            "<tr><td>assest</td><td>否</td><td>金融资产量</td></tr>" +
            "<tr><td>arpm</td><td>否</td><td>近三年平均收入</td></tr>" +
            "<tr><td>token</td><td>否</td><td>token</td></tr>" )
    /*
	 * 用户认证API接口 第二步
	 */
    @RequestMapping(value = "/api/urz/step2", method = RequestMethod.POST)
    @ResponseBody
    public Object step2(@RequestParam String company, @RequestParam String position, @RequestParam String assest,@RequestParam String arpm,@RequestParam String token, HttpServletRequest request) {
        String myJsonData="";
        return myJsonData;
    }


    @ApiOperation(httpMethod = "POST", value = "(<font color='blue'>用户认证第三步</font>)",position = 3,nickname = "用户认证第三步", notes = "<h2>传递参数</h2>:<br>" +
            "<table border=\"1\"><tr><th>字段</th><th>是否为空</th><th>备注</th></tr>" +
            "<tr><td>USERCARD_IMAGE</td><td>否</td><td>名片：需要将form-data; name=USERCARD_IMAGE</td></tr>" +
            "<tr><td>IDCARD_IMAGE</td><td>否</td><td>身份证照片：需要将form-data; name=IDCARD_IMAGE</td></tr>" +
            "<tr><td>token</td><td>否</td><td>token</td></tr>" )
    /*
	 * 用户认证API接口 第三步
	 */
    @RequestMapping(value = "/api/urz/step3", method = RequestMethod.POST)
    @ResponseBody
    public Object step3(@RequestParam String USERCARD_IMAGE, @RequestParam String IDCARD_IMAGE,@RequestParam String token, HttpServletRequest request) {
        String myJsonData="";
        return myJsonData;
    }
}
