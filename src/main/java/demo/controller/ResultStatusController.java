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
@Api(value = "0:系统返回状态", description = "系统返回状态", produces = "application/json",position =15 )
public class ResultStatusController {
    @Autowired
    UserMapper userMapper;

    @ApiOperation(httpMethod = "POST", value = "系统返回状态",position = 1,nickname = "系统返回状态", notes = "" +
            "<h4>系统返回状态</h4>" +
            "<div class=\"block response_body json\"><pre class=\"json\"><code>"+
            "   SUCCESS(0, \"成功\"),\n" +
            "    USERNAME_OR_PASSWORD_ERROR(1001, \"手机号或密码错误\"),\n" +
            "    USER_NOT_FOUND(1002, \"用户不存在\"),\n" +
            "    USER_NOT_LOGIN(1003, \"用户未登录\"),\n" +
            "    MOBEILE_ERROR(1004, \"手机号码格式错误\"),\n" +
            "    TOKEN_ERROR(1005, \"token无效\"),\n" +
            "    NOT_FOUND(404, \"NOT FOUND\"),\n" +
            "    PARAM_IS_NOT_NULL(1006, \"PARAM IS NOT NULL\"),\n" +
            "    PASSWORD_REG(1007, \"密码格式错误,正确格式6-16位字母或数字\"),\n" +
            "    CODE_ERROR(1008, \"验证码错误\"),\n" +
            "    MOBEILE_SEND_CODE_ERROR(1009, \"该手机号码超过单日发送验证码的最大频次\"),\n" +
            "    MOBEILE_TEST_SEND_CODE_ERROR(1010, \"该手机号码为测试手机号码,不用发送验证码\"),\n" +
            "    IMAGE_CODE_ERROR(1011, \"图形验证码错误\"),\n" +
            "    CODE_COUNT_ERROR(1012, \"验证码输入次数超过3次\"),\n" +
            "    USER_NAME_ERROR(1013, \"用户名错误请输入3-20位字母或数字\"),\n" +
            "    EMAILFMT_ERROR(1014, \"邮箱格式错误\"),\n" +
            "    IDCARD_ERROR(1015, \"身份证格式错误\"),\n" +
            "    COMPANY_ERROR(1016, \"公司格式错误,1-50数字、字母、中文\"),\n" +
            "    POSITION_ERROR(1017, \"职位格式错误,1-50数字、字母、中文\"),\n" +
            "    ASSEST_ERROR(1018, \"金融资产量必填\"),\n" +
            "    ARPM_ERROR(1019, \"近三年平均收入必填\"),\n" +
            "    IDCARD_PHOTO_ERROR(1020, \"身份证照片必传\"),\n" +
            "    USER_CAR_PHOTO_ERROR(1021, \"名片必传\"),\n" +
            "    UPLOAD_IMAGE_TYPE_ERROR(1022, \"该文件类型不能够上传\"),\n" +
            "    UPLOAD_IMAGE_MAX_SIZE_ERROR(1023, \"上传图片的总大小超过了规定的最大值\"),\n" +
            "    ORGASSEST_ERROR(1024, \"机构净资产错误，只能为数字\"),\n" +
            "    NO_USER_ERROR(1025, \"该手机号码未注册\"),\n" +
            "    EXSIT_USER_ERROR(1026, \"该手机号已经注册\"),\n" +
            "    UPDATE_PASSWORD_SUCCCESS(1027, \"密码更新成功\"),\n" +
            "    UPLOAD_IMAGE_ERROR(1028, \"图片没有上传\"),\n" +
            "    ORG_NAME_ERROR(1029, \"机构名称填写错误,请填写1-50数字、字母、中文\"),\n" +
            "    ORG_DUTYPERSON_NAME_ERROR(1030, \"机构负责人名称填写错误,请填写1-50数字、字母、中文\"),\n" +
            "    ORG_DUTYPERSON_POSITION_ERROR(1031, \"机构负责人名称填写错误,请填写1-50数字、字母、中文\"),\n" +
            "    ORG_DUTYPERSON_EMAIL_ERROR(1032, \"机构负责人邮箱填写错误\"),\n" +
            "    DATE_FORMAT_ERROR(1033, \"日期格式错误\"),\n" +
            "    NOT_FIND_FUND_ERROR(1034, \"预约的产品不存在\"),\n" +
            "    ERROR(1035, \"服务器错误\"),\n" +
            "    FEED_BACK_ERROR(1036, \"反馈内容不能为空\"),\n" +
            "    UPLOAD_IMAGE_NAME_ERROR(1037, \"图片上传name参数传递错误\"),\n" +
            "    USER_ACCOUNT_DONG_JIE(1038, \"您的账户已被冻结\");" +


            "</code></pre></div>"
    )
    @RequestMapping(value = "/api/result/status", method = RequestMethod.POST)
    @ResponseBody
    public Object investor(){
        String myJsonData="";
        return myJsonData;
    }


}
