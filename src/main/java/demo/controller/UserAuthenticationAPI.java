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

    @ApiOperation(httpMethod = "POST", value = "(<font color='blue'>用户认证第一步</font>)",position = 1,nickname = "用户认证第一步", notes = "<font color='green'>传递参数</font>" +
            "<table border=\"1\"><tr><th>字段</th><th>是否为空</th><th>\t备注</th></tr>" +
            "<tr><td>userName</td><td>否</td><td>用户名</td></tr>" +
            "<tr><td>sex</td><td>否</td><td>性别</td></tr>" +
            "<tr><td>maile</td><td>否</td><td>邮箱</td></tr>" +
            "<tr><td>idCard</td><td>否</td><td>身份证号码</td></tr>" +
            "<tr><td>token</td><td>否</td><td>token</td></tr></table>" +
            "<div><h2>返回结果情况如下：</h2></div>" +
            "1：{\"code\":1013,\"message\":\"用户名错误请输入3-20位字母或数字\",\"data\":null}<br>" +
            "2：{\"code\":1015,\"message\":\"身份证格式错误\",\"data\":null}<br>" +
            "3：{\"code\":1014,\"message\":\"邮箱格式错误\",\"data\":null}<br>" +
            "4：{\"code\":1005,\"message\":\"token无效\",\"data\":null}<br>" +
            "5：{\"code\":0,\"message\":\"成功\",\"data\":null}<br>" )
    /*
	 * 用户认证API接口 第一步
	 */
    @RequestMapping(value = "/api/urz/step1", method = RequestMethod.POST)
    @ResponseBody
    public Object step1(@RequestParam String userName, @RequestParam String sex, @RequestParam String maile,@RequestParam String idCard,@RequestParam String token, HttpServletRequest request) {
        String myJsonData="";
        return myJsonData;
    }

    @ApiOperation(httpMethod = "POST", value = "(<font color='blue'>用户认证第二步</font>)",position = 2,nickname = "用户认证第二步", notes = "<font color='green'>传递参数</font>:<br>" +
            "<table border=\"1\"><tr><th>字段</th><th>是否为空</th><th>\t备注</th></tr>" +
            "<tr><td>company</td><td>否</td><td>公司名称</td></tr>" +
            "<tr><td>position</td><td>否</td><td>职位</td></tr>" +
            "<tr><td>assest</td><td>否</td><td>金融资产量</td></tr>" +
            "<tr><td>arpm</td><td>否</td><td>近三年平均收入</td></tr>" +
            "<tr><td>token</td><td>否</td><td>token</td></tr></table>" +
            "<div><h2>返回结果：</h2></div>"+
            "1:{\"code\":1019,\"message\":\"近三年平均收入错误，只能为数字\",\"data\":null}<br>"+
            "2:{\"code\":1018,\"message\":\"金融资产量错误，只能为数字\",\"data\":null}<br>"+
            "3:{\"code\":1005,\"message\":\"token无效\",\"data\":null}<br>"+
            "4:{\"code\":0,\"message\":\"成功\",\"data\":null}"
    )
    /*
	 * 用户认证API接口 第二步
	 */
    @RequestMapping(value = "/api/urz/step2", method = RequestMethod.POST)
    @ResponseBody
    public Object step2(@RequestParam String company, @RequestParam String position, @RequestParam String assest,@RequestParam String arpm,@RequestParam String token, HttpServletRequest request) {
        String myJsonData="";
        return myJsonData;
    }


    @ApiOperation(httpMethod = "POST", value = "(<font color='blue'>用户认证第三步</font>)",position = 3,nickname = "用户认证第三步", notes = "<font color='green'>传递参数</font>:<br>" +
            "<table border=\"1\"><tr><th>字段</th><th>是否为空</th><th>\t备注</th></tr>" +
            "<tr><td>USERCARD_IMAGE</td><td>否</td><td>名片：需要将form-data; name=USERCARD_IMAGE</td></tr>" +
            "<tr><td>IDCARD_IMAGE</td><td>否</td><td>身份证照片：需要将form-data; name=IDCARD_IMAGE</td></tr>" +
            "<tr><td>token</td><td>否</td><td>token</td></tr></table>" )
    /*
	 * 用户认证API接口 第三步
	 */
    @RequestMapping(value = "/api/urz/step3", method = RequestMethod.POST)
    @ResponseBody
    public Object step3(@RequestParam String USERCARD_IMAGE, @RequestParam String IDCARD_IMAGE,@RequestParam String token, HttpServletRequest request) {
        String myJsonData="";
        return myJsonData;
    }

    /**
     * 批量更新用户信息接口
     * @param sex
     * @param company
     * @param position
     * @param assest
     * @param arpm
     * @param USERCARD_IMAGE
     * @param IDCARD_IMAGE
     * @param token
     * @param request
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "(<font color='blue'>批量更新用户信息接口</font>)",position = 4,nickname = "批量更新用户信息接口", notes = "<font color='green'>传递参数</font>:<br>" +
            "<table border=\"1\"><tr><th>字段</th><th>是否为空</th><th>\t备注</th></tr>" +
            "<tr><td>userName</td><td>否</td><td>用户名</td></tr>" +
            "<tr><td>sex</td><td>否</td><td>性别</td></tr>" +
            "<tr><td>maile</td><td>否</td><td>邮箱</td></tr>" +
            "<tr><td>idCard</td><td>否</td><td>身份证号码</td></tr>" +
            "<tr><td>company</td><td>否</td><td>公司名称</td></tr>" +
            "<tr><td>position</td><td>否</td><td>职位</td></tr>" +
            "<tr><td>assest</td><td>否</td><td>金融资产量</td></tr>" +
            "<tr><td>arpm</td><td>否</td><td>近三年平均收入</td></tr>" +
            "<tr><td>USERCARD_IMAGE</td><td>否</td><td>名片：需要将form-data; name=USERCARD_IMAGE</td></tr>" +
            "<tr><td>IDCARD_IMAGE</td><td>否</td><td>身份证照片：需要将form-data; name=IDCARD_IMAGE</td></tr>" +
            "<tr><td>token</td><td>否</td><td>token</td></tr></table>" )
    /*
	 * 用户认证API接口 第三步
	 */
    @RequestMapping(value = "/api/urz/step4", method = RequestMethod.POST)
    @ResponseBody
    public Object step4(@RequestParam String userName, @RequestParam String sex, @RequestParam String maile,@RequestParam String idCard,@RequestParam String company, @RequestParam String position, @RequestParam String assest,@RequestParam String arpm,@RequestParam String USERCARD_IMAGE, @RequestParam String IDCARD_IMAGE,@RequestParam String token, HttpServletRequest request) {
        String myJsonData="";
        return myJsonData;
    }
}
