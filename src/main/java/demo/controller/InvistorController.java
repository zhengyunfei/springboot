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
 * Created by wangwei on 2016/9/2.
 * 合格投资人认定
 */
@RestController
@Api(value = "十一:合格投资人认定API", description = "合格投资人认定，投资风险，用户协议h5", produces = "application/json")
public class InvistorController {
    @Autowired
    UserMapper userMapper;

    @ApiOperation(httpMethod = "GET", value = "合格投资人认定h5",position = 1,nickname = "合格投资人认定h5", notes = "" +
            "<h4>合格投资人认定h5页面，直接调url就行</h4>" )
    @RequestMapping(value = "/api/investor/index", method = RequestMethod.GET)
    @ResponseBody
    public Object investor(){
        String myJsonData="";
        return myJsonData;
    }
    @ApiOperation(httpMethod = "GET", value = "用户协议h5",position = 2,nickname = "用户协议h5", notes = "" +
            "<h4>用户协议h5，直接调url就行</h4>" )
    @RequestMapping(value = "/api/agreement/index", method = RequestMethod.GET)
    @ResponseBody
    public Object agreement(){
        String myJsonData="";
        return myJsonData;
    }
    @ApiOperation(httpMethod = "GET", value = "投资风险h5",position = 2,nickname = "投资风险h5", notes = "<h4>" +
            "投资风险h5，直接调url就行</h4>" )
    @RequestMapping(value = "/api/risk/index", method = RequestMethod.GET)
    @ResponseBody
    public Object risk(){
        String myJsonData="";
        return myJsonData;
    }
}
