package demo.controller;

/**
 * Created by Administrator on 2016/10/11.
 */

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import demo.service.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhengyunfei on 2016/9/2.
 * 风险评估api接口
 */
@RestController
@Api(value = "十二:风险评估API接口", description = "风险评估API接口", produces = "application/json")
public class AnswerController {
    @Autowired
    UserMapper userMapper;

    @ApiOperation(httpMethod = "GET", value = "个人风险评估",position = 1,nickname = "个人风险评估h5", notes = "" +
            "<h4>个人风险评估h5，直接调url就行</h4>" )
    @RequestMapping(value = "/api/pscore/index", method = RequestMethod.GET)
    @ResponseBody
    public Object investor(){
        String myJsonData="";
        return myJsonData;
    }
    @ApiOperation(httpMethod = "GET", value = "机构风险评估h5",position = 2,nickname = "机构风险评估h5", notes = "" +
            "<h4>机构风险评估h5，直接调url就行</h4>" )
    @RequestMapping(value = "/api/scoreOrg/index", method = RequestMethod.GET)
    @ResponseBody
    public Object agreement(){
        String myJsonData="";
        return myJsonData;
    }

}
