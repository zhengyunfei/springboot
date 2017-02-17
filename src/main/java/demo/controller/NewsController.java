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
 * 新闻资讯详情api接口
 */
@RestController
@Api(value = "d:财富资讯API接口", description = "财富资讯API接口" +
        "<img src=\"http://www.51xuediannao.com/uploads/allimg/140104/1-140104201953.gif\">" +
        "<img src=\"http://www.51xuediannao.com/uploads/allimg/140104/1-140104201953.gif\">" +
        "<img src=\"http://www.51xuediannao.com/uploads/allimg/140104/1-140104201953.gif\">", produces = "application/json")
public class NewsController {
    @Autowired
    UserMapper userMapper;

    @ApiOperation(httpMethod = "GET", value = "资讯详情",position = 1,nickname = "资讯详情h5", notes = "" +
            "<h4>新闻资讯详情h5，直接调url就行</h4>" )
    @RequestMapping(value = "/api/news/detail", method = RequestMethod.GET)
    @ResponseBody
    public Object investor(@RequestParam String id){
        String myJsonData="";
        return myJsonData;
    }

    @ApiOperation(httpMethod = "POST", value = "资讯列表" +
            "<img src=\"http://www.51xuediannao.com/uploads/allimg/140104/1-140104201934.gif\">",position = 1,nickname = "资讯列表h5", notes = "" +
            "<h4>财富资讯url地址：/api/news/list</h4>" +
            "<h4>传递参数</h4>"+
            "<div>" +
            "pageNow:当前页码 选填<br>" +
            "pageSize:每页显示条数 选填<br>" +
            "type:资讯类型 必填<br></div>" +
            "<h4>type传递参数明细</h4>"+
            "<div>type=hyzx 行业资讯<br>" +
            "type=cfdt 财富动态<br>" +
            "type=cfgs 财富故事<br>" +
            "type=mtbd 媒体报道<br>" +
            "3:pageSize pageSize 每页显示条数 选填<br>" +
            "<h4>数据集返回结果-为空时:</h4>" +
            "<div class=\"block response_body json\"><pre class=\"json\"><code>"+
            "{\n" +
            "    \"data\": null, \n" +
            "    \"code\": 1059, \n" +
            "    \"message\": \"没有更多数据了\"\n" +
            "}"+
            "<h4>数据集返回结果:</h4>" +
            "<div class=\"block response_body json\"><pre class=\"json\"><code>"+
            "{\n" +
            "    \"data\": {\n" +
            "        \"news\": [\n" +
            "            {\n" +
            "                \"articleId\": \"2016000000068174\", \n" +
            "                \"articleTitle\": \"精准诊断的4大热点投资领域：生育健康、新药研发……\", \n" +
            "                \"mobileThumbnail\": \"http://www.pestreet.cn/c/freemarker//upload//img//20161117//2016111714015820161116112935713571.jpg\", \n" +
            "                \"sendTime\": \"2016-11-17\"\n" +
            "            }, \n" +
            "            {\n" +
            "                \"articleId\": \"2016000000068172\", \n" +
            "                \"articleTitle\": \"云适配完成1亿元B＋轮融资，HTML5行业的颠覆者来了！\", \n" +
            "                \"mobileThumbnail\": \"http://www.pestreet.cn/c/freemarker//upload//img//20161117//2016111710131420161117074148014801.jpg\", \n" +
            "                \"sendTime\": \"2016-11-17\"\n" +
            "            }, \n" +
            "            {\n" +
            "                \"articleId\": \"2016000000068170\", \n" +
            "                \"articleTitle\": \"财富街合伙伙伴启明创投邝子平：10年 27亿美元的背后\", \n" +
            "                \"mobileThumbnail\": \"http://www.pestreet.cn/c/freemarker//upload//img//20161117//2016111710042820161117094579267926.jpg\", \n" +
            "                \"sendTime\": \"2016-11-17\"\n" +
            "            }, \n" +
            "            {\n" +
            "                \"articleId\": \"2016000000068032\", \n" +
            "                \"articleTitle\": \" 财富街合作伙伴华盖资本许小林曝光真实的医疗投资\", \n" +
            "                \"mobileThumbnail\": \"http://www.pestreet.cn/c/freemarker//upload//img//20161110//20161110155233QQ图片20161110153651.png\", \n" +
            "                \"sendTime\": \"2016-11-10\"\n" +
            "            }, \n" +
            "            {\n" +
            "                \"articleId\": \"2016000000068030\", \n" +
            "                \"articleTitle\": \"金融风暴中 “不缩水”的兆亿产业 让投资有方向!\", \n" +
            "                \"mobileThumbnail\": \"http://www.pestreet.cn/c/freemarker//upload//img//20161110//2016111014110190Z58PIC9yu_1024.jpg\", \n" +
            "                \"sendTime\": \"2016-11-10\"\n" +
            "            }, \n" +
            "            {\n" +
            "                \"articleId\": \"2016000000068033\", \n" +
            "                \"articleTitle\": \"2016中国股权投资：投资TMT仍最赚钱！\", \n" +
            "                \"mobileThumbnail\": \"http://www.pestreet.cn/c/freemarker//upload//img//20161110//20161110171744QQ图片20161110171427.png\", \n" +
            "                \"sendTime\": \"2016-11-10\"\n" +
            "            }\n" +
            "        ]\n" +
            "    }, \n" +
            "    \"code\": 0, \n" +
            "    \"message\": \"成功\"\n" +
            "}\n" +
            "</div>"
    )
    @RequestMapping(value = "/api/news/list", method = RequestMethod.POST)
    @ResponseBody
    public Object findList(){
        String myJsonData="";
        return myJsonData;
    }

}
