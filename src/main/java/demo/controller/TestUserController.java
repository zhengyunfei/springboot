package demo.controller;

/**
 * Created by Administrator on 2016/10/11.
 */

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import demo.domain.MyJsonData;
import demo.domain.User;
import demo.service.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by wangwei on 2016/9/2.
 */
@RestController
@Api(value = "集成mybatis获取用户基本信息", description = "用户相关", produces = "application/json")
@RequestMapping({"/api/test"})
public class TestUserController {
    @Autowired
    UserMapper userMapper;

    @ApiOperation(httpMethod = "GET", value = "集成mybatis获取用户基本信息-HTTP200(<font color='blue'>release</font>)", notes = "使用用户username和enabled进行查看，如果用户不存在，也返回200。返回用户类实体")
    @RequestMapping(value = "/find/id/{name}", method = RequestMethod.GET)
    @ResponseBody
    public Object user(@PathVariable String name){
        User user = userMapper.findUserByName(name,"1");
        MyJsonData myJsonData=new MyJsonData();
        myJsonData.setData(user);
        myJsonData.setCode("0");
        myJsonData.setMsg("查询成功");
        return myJsonData;
    }

}
