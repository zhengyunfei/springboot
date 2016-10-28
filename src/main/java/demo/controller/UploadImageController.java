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
@Api(value = "f:图片上传API接口", description = "图片上传API接口", produces = "application/json",position =15 )
public class UploadImageController {
    @Autowired
    UserMapper userMapper;

    @ApiOperation(httpMethod = "POST", value = "上传头像",position = 1,nickname = "上传头像", notes = "" +
            "<table border=\"1\"><tr><th>字段</th><th>是否为空</th><th>\t备注</th></tr>" +
            "<tr><td>token</td><td>否</td><td>token</td></tr></table>" +
            "<h4>返回结果</h4>" +
            "<h4>token无效</h4>" +
            "<div class=\"block response_body json\"><pre class=\"json\"><code>"+
            "{\"code\":1005,\"message\":\"token无效\",\"data\":null}" +
            "</code></pre></div>"+
            "<h4>成功</h4>"+
            "<div class=\"block response_body json\"><pre class=\"json\"><code>"+
            "{\"code\":0,\"message\":\"成功\",\"data\":null}"+
            "</code></pre></div>"
    )
    @RequestMapping(value = "/api/upload/headPic", method = RequestMethod.POST)
    @ResponseBody
    public Object uploadHeadUrl(@RequestParam String token){
        String myJsonData="";
        return myJsonData;
    }



    @ApiOperation(httpMethod = "POST", value = "上传图片通用接口",position = 1,nickname = "上传图片通用接口", notes = "" +
            "<h4>此接口适用于如下几种类型的图片上传</h4>" +
            "1:个人用户名片上传:需要将成功返回的value赋值与userCardUrl" +
            "2：个人用户身份证上传:需要将成功返回的value赋值与idCardUrl" +
            "3：机构用户名片上传:需要将成功返回的value赋值与orgDutypersonCardurl" +
            "4：机构用户营业执照上传:需要将成功返回的value赋值与orgLicenseUrl" +
            "<h4>成功</h4>"+
            "<div class=\"block response_body json\"><pre class=\"json\"><code>"+
            "{\"code\":0,\"message\":\"成功\",\"data\":{'key':'value'}}"+
            "</code></pre></div>"
    )
    @RequestMapping(value = "/api/upload/image", method = RequestMethod.POST)
    @ResponseBody
    public Object investor(){
        String myJsonData="";
        return myJsonData;
    }

}
