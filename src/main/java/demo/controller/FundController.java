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
 * Created by wangwei on 2016/9/2.
 */
@RestController
@Api(value = "1:首页API接口", description = "首页接口", produces = "application/json")
public class FundController {
    @Autowired
    UserMapper userMapper;

    @ApiOperation(httpMethod = "GET", value = "首页(<font color='blue'>release</font>)",position = 3, notes = "" +
            "<font color='blue'>data中字段解析:</font><br>news:行业资讯。<br>reports：媒体报道<br>{：mobileThumbnail： 头图<br>articleTitle:标题<br>articleId:主键}<br><font color='green'>news:字段同reports</font><br>" +
            "<font color='red'>RAISE_ING:正在募集中，RAISE_END:募集结束</font><br>" +
            "{: \"desc\": \"简介\",\n" +
            "            \"url\": \"头图\",\n" +
            "            \"capitalContribution\": \"投资门槛\",\n" +
            "            \"recommended\": \"推荐理由\",\n" +
            "            \"fundId\": \"主键\",\n" +
            "            \"fundByname\": \"简称\",\n" +
            "            \"rate\": \"融资进度\"}")
    @RequestMapping(value = "/api/fund/list", method = RequestMethod.GET)
    @ResponseBody
    public Object user(){
        String myJsonData="{\n" +
                "    \"data\": {\n" +
                "        \"reports\": [{\n" +
                "            \"mobileThumbnail\": \"http://www.pestreet.cn/c/freemarker//upload//img//20160719//201607191156342016718747282795.jpg\",\n" +
                "            \"articleTitle\": \"史上最全大数据揭秘不为人知的北京：2015年度全市职工平均年薪85038元\",\n" +
                "            \"articleId\": \"2016000000065467\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"mobileThumbnail\": \"http://www.pestreet.cn/c/freemarker//upload//img//20160719//20160719115001201671813783404.jpg\",\n" +
                "            \"articleTitle\": \"北上广不相信逃离\",\n" +
                "            \"articleId\": \"2016000000065466\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"mobileThumbnail\": \"http://www.pestreet.cn/c/freemarker//upload//img//20160719//20160719114632QQ图片20160719114620.png\",\n" +
                "            \"articleTitle\": \"投资界盛行校友圈子 北上深私募风格差别大\",\n" +
                "            \"articleId\": \"2016000000065465\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"mobileThumbnail\": \"http://www.pestreet.cn/c/freemarker//upload//img//20160719//201607191143292016718152707334.jpg\",\n" +
                "            \"articleTitle\": \"财富街盘点大佬们的第一份工作，李嘉诚是泡茶小弟、马化腾月薪1100元、刘强东是网管……\",\n" +
                "            \"articleId\": \"2016000000065464\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"mobileThumbnail\": \"http://www.pestreet.cn/c/freemarker//upload//img//20160719//2016071911393420160718152856805680.png\",\n" +
                "            \"articleTitle\": \"全世界最赚钱的5家公司 中国竟然占了3家 没有华为、BAT……\",\n" +
                "            \"articleId\": \"2016000000065463\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"mobileThumbnail\": \"http://www.pestreet.cn/c/freemarker//upload//img//20160719//2016071911274620167181721401041.jpg\",\n" +
                "            \"articleTitle\": \"买房遭遇史上最疯狂涨价潮，如何解救一个中产家庭的挣扎与救赎！\",\n" +
                "            \"articleId\": \"2016000000065462\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"mobileThumbnail\": \"http://www.pestreet.cn/c/freemarker//upload//img//20160718//20160718135549QQ图片20160718135536.png\",\n" +
                "            \"articleTitle\": \"80后调查报告：年收入超过30万算佼佼者\",\n" +
                "            \"articleId\": \"2016000000065459\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"mobileThumbnail\": \"http://www.pestreet.cn/c/freemarker//upload//img//20160718//2016071813494920167181057347971.jpg\",\n" +
                "            \"articleTitle\": \"来互相关爱啊！谷歌允许员工互相捐赠休假时间\",\n" +
                "            \"articleId\": \"2016000000065458\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"mobileThumbnail\": \"http://www.pestreet.cn/c/freemarker//upload//img//20160718//2016071813445828.jpg\",\n" +
                "            \"articleTitle\": \"都是脱欧惹的祸？伦敦房价大范围下跌\",\n" +
                "            \"articleId\": \"2016000000065457\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"mobileThumbnail\": \"http://www.pestreet.cn/c/freemarker//upload//img//20160718//2016071813440620160718112383138313.jpg\",\n" +
                "            \"articleTitle\": \"王思聪，首富之子玩创业，感觉自己像上帝，任何事情都能做\",\n" +
                "            \"articleId\": \"2016000000065456\"\n" +
                "        }],\n" +
                "        \"RAISE_ING\": [{\n" +
                "            \"description\": \"上市公司为基石投资人，行业内项目资源丰富，增加项目退出渠道\",\n" +
                "            \"capitalContribution\": \"500\",\n" +
                "            \"recommended\": \"资源整合\",\n" +
                "            \"url\": \"/c/freemarker/upload/img/20160707/20160707102149dffd.jpg\",\n" +
                "            \"fundId\": \"deeb77c9-fff1-4092-9de7-a4b2de04b00a\",\n" +
                "            \"fundByname\": \"TMT+大消费产业基金\",\n" +
                "            \"rate\": \"65\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"description\": \"组合投资优秀的VC/PE基金，降低风险，保障收益\",\n" +
                "            \"capitalContribution\": \"500\",\n" +
                "            \"recommended\": \"收益稳定\",\n" +
                "            \"url\": \"/c/freemarker/upload/img/20150924/2015092414441320150924(2).jpg\",\n" +
                "            \"fundId\": \"28e306c8-b617-4129-829b-4b4e7730f3c8\",\n" +
                "            \"fundByname\": \"人民币专项投资组合基金\",\n" +
                "            \"rate\": \"92\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"description\": \"以大型教育机构VIE架构为投资标的，目标明确，收益稳健\",\n" +
                "            \"capitalContribution\": \"500\",\n" +
                "            \"recommended\": \"绝佳机遇\",\n" +
                "            \"url\": \"/c/freemarker/upload/img/20160324/20160324133928160323.jpg\",\n" +
                "            \"fundId\": \"f7ed87ca-6828-482f-b838-e60e98cb1386\",\n" +
                "            \"fundByname\": \"教育机构VIE回归专项基金\",\n" +
                "            \"rate\": \"100\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"description\": \"汇聚优秀私募股权基金+专业投资团队的二次风控\",\n" +
                "            \"capitalContribution\": \"100\",\n" +
                "            \"recommended\": \"项目丰富\",\n" +
                "            \"url\": \"/c/freemarker/upload/img/20150826/20150826142342人民币联合.jpg\",\n" +
                "            \"fundId\": \"27a914bc-6486-4555-aaa2-50b052ba4f2b\",\n" +
                "            \"fundByname\": \"人民币联合投资基金 \",\n" +
                "            \"rate\": \"100\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"description\": \"充分利用中美资源，投资早期项目，做创业公司的第一轮投资者\",\n" +
                "            \"capitalContribution\": \"3000\",\n" +
                "            \"recommended\": \"经验丰富\",\n" +
                "            \"url\": \"/c/freemarker/upload/img/20151029/2015102918402020151029.jpg\",\n" +
                "            \"fundId\": \"2f64ce7a-c0a4-4358-b2df-9066891f030c\",\n" +
                "            \"fundByname\": \"中国-硅谷双向投资基金\",\n" +
                "            \"rate\": \"100\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"description\": \"对成长期和成熟期的互联网教育或相关行业企业进行股权相关的投资\\r\\n\",\n" +
                "            \"capitalContribution\": \"300\",\n" +
                "            \"recommended\": \"赎出灵活\",\n" +
                "            \"url\": \"/c/freemarker/upload/img/20150715/201507151652032.jpg\",\n" +
                "            \"fundId\": \"06931f69-d7c5-447c-a2c1-9efa76069a79\",\n" +
                "            \"fundByname\": \"互联网教育并购基金\",\n" +
                "            \"rate\": \"100\"\n" +
                "        }],\n" +
                "        \"news\": [{\n" +
                "            \"mobileThumbnail\": \"http://www.pestreet.cn/c/freemarker//upload//img//20160719//201607191156342016718747282795.jpg\",\n" +
                "            \"articleTitle\": \"史上最全大数据揭秘不为人知的北京：2015年度全市职工平均年薪85038元\",\n" +
                "            \"articleId\": \"2016000000065467\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"mobileThumbnail\": \"http://www.pestreet.cn/c/freemarker//upload//img//20160719//20160719115001201671813783404.jpg\",\n" +
                "            \"articleTitle\": \"北上广不相信逃离\",\n" +
                "            \"articleId\": \"2016000000065466\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"mobileThumbnail\": \"http://www.pestreet.cn/c/freemarker//upload//img//20160719//20160719114632QQ图片20160719114620.png\",\n" +
                "            \"articleTitle\": \"投资界盛行校友圈子 北上深私募风格差别大\",\n" +
                "            \"articleId\": \"2016000000065465\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"mobileThumbnail\": \"http://www.pestreet.cn/c/freemarker//upload//img//20160719//201607191143292016718152707334.jpg\",\n" +
                "            \"articleTitle\": \"财富街盘点大佬们的第一份工作，李嘉诚是泡茶小弟、马化腾月薪1100元、刘强东是网管……\",\n" +
                "            \"articleId\": \"2016000000065464\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"mobileThumbnail\": \"http://www.pestreet.cn/c/freemarker//upload//img//20160719//2016071911393420160718152856805680.png\",\n" +
                "            \"articleTitle\": \"全世界最赚钱的5家公司 中国竟然占了3家 没有华为、BAT……\",\n" +
                "            \"articleId\": \"2016000000065463\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"mobileThumbnail\": \"http://www.pestreet.cn/c/freemarker//upload//img//20160719//2016071911274620167181721401041.jpg\",\n" +
                "            \"articleTitle\": \"买房遭遇史上最疯狂涨价潮，如何解救一个中产家庭的挣扎与救赎！\",\n" +
                "            \"articleId\": \"2016000000065462\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"mobileThumbnail\": \"http://www.pestreet.cn/c/freemarker//upload//img//20160718//20160718135549QQ图片20160718135536.png\",\n" +
                "            \"articleTitle\": \"80后调查报告：年收入超过30万算佼佼者\",\n" +
                "            \"articleId\": \"2016000000065459\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"mobileThumbnail\": \"http://www.pestreet.cn/c/freemarker//upload//img//20160718//2016071813494920167181057347971.jpg\",\n" +
                "            \"articleTitle\": \"来互相关爱啊！谷歌允许员工互相捐赠休假时间\",\n" +
                "            \"articleId\": \"2016000000065458\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"mobileThumbnail\": \"http://www.pestreet.cn/c/freemarker//upload//img//20160718//2016071813445828.jpg\",\n" +
                "            \"articleTitle\": \"都是脱欧惹的祸？伦敦房价大范围下跌\",\n" +
                "            \"articleId\": \"2016000000065457\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"mobileThumbnail\": \"http://www.pestreet.cn/c/freemarker//upload//img//20160718//2016071813440620160718112383138313.jpg\",\n" +
                "            \"articleTitle\": \"王思聪，首富之子玩创业，感觉自己像上帝，任何事情都能做\",\n" +
                "            \"articleId\": \"2016000000065456\"\n" +
                "        }],\n" +
                "        \"RAISE_END\": [{\n" +
                "            \"description\": \"股票天然折价，未来有较大上升空间\",\n" +
                "            \"capitalContribution\": \"500\",\n" +
                "            \"recommended\": \"优质资产装入\",\n" +
                "            \"url\": \"/c/freemarker/upload/img/20160517/20160517142801rjejrlr.jpg\",\n" +
                "            \"fundId\": \"b4c214c5-f18d-4235-b399-20cdca505542\",\n" +
                "            \"fundByname\": \"A股上市公司人民币定增基金\",\n" +
                "            \"rate\": \"100\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"description\": \"专注于技术和模式双创新的高成长性中小企业投资\",\n" +
                "            \"capitalContribution\": \"500\",\n" +
                "            \"recommended\": \"创新行业\",\n" +
                "            \"url\": \"/c/freemarker/upload/img/20150826/20150826142256互联网人民币.jpg\",\n" +
                "            \"fundId\": \"5c2fe513-14a1-4ce0-9184-cec339ea8b3c\",\n" +
                "            \"fundByname\": \"互联网+人民币基金\",\n" +
                "            \"rate\": \"100\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"description\": \"帮助上市公司及传统企业转型升级，推动企业间并购整合，为投资者提供超额回报\",\n" +
                "            \"capitalContribution\": \"1000\",\n" +
                "            \"recommended\": \"实操能力\",\n" +
                "            \"url\": \"/c/freemarker/upload/img/20150618/20150618142530产品4.jpg\",\n" +
                "            \"fundId\": \"60de8cc4-c327-433c-986b-32c259ccf2a5\",\n" +
                "            \"fundByname\": \"新经济产业并购投资基金\",\n" +
                "            \"rate\": \"100\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"description\": \"中国医疗健康领域优秀的股权投资团队，深厚的医疗健康领域股东背景与资源\",\n" +
                "            \"capitalContribution\": \"1000\",\n" +
                "            \"recommended\": \"过往业绩\",\n" +
                "            \"url\": \"/c/freemarker/upload/img/20150618/20150618141910产品2.jpg\",\n" +
                "            \"fundId\": \"6def6db3-c5dc-41a9-8fe8-e3e511385a35\",\n" +
                "            \"fundByname\": \"医疗健康股权投资基金\",\n" +
                "            \"rate\": \"100\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"description\": \"专注成长企业投资机会，实现“小而美”的投资，“迅速而多样”的退出\",\n" +
                "            \"capitalContribution\": \"3000\",\n" +
                "            \"recommended\": \"业绩优秀\",\n" +
                "            \"url\": \"/c/freemarker/upload/img/20151103/2015110314154320151030.jpg\",\n" +
                "            \"fundId\": \"ab5c3181-758b-47db-895f-a886e69b03d0\",\n" +
                "            \"fundByname\": \"新趋势增长基金\",\n" +
                "            \"rate\": \"100\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"description\": \"聚焦TMT、现代服务业、新材料等行业领域\",\n" +
                "            \"capitalContribution\": \"1000\",\n" +
                "            \"recommended\": \"投资稳健\",\n" +
                "            \"url\": \"/c/freemarker/upload/img/20150618/20150618142554产品6.jpg\",\n" +
                "            \"fundId\": \"949e3727-11fa-4082-a2b6-6ff6cad6ec47\",\n" +
                "            \"fundByname\": \"VC成长期投资基金\",\n" +
                "            \"rate\": \"100\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"description\": \"特别关注“轻资产，重服务”的优秀模式企业\",\n" +
                "            \"capitalContribution\": \"1000\",\n" +
                "            \"recommended\": \"优先收益\",\n" +
                "            \"url\": \"/c/freemarker/upload/img/20150826/20150826142543岭南园林.jpg\",\n" +
                "            \"fundId\": \"e6b4f20a-3e92-43ee-866b-709d459abe96\",\n" +
                "            \"fundByname\": \"旅游休闲专项并购基金\",\n" +
                "            \"rate\": \"100\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"description\": \" 以中概股及未上市企业VIE架构拆解为投资标的，顺势而为，捕捉市场机会\\r\\n\",\n" +
                "            \"capitalContribution\": \"500\",\n" +
                "            \"recommended\": \"捕捉机遇\",\n" +
                "            \"url\": \"/c/freemarker/upload/img/20150827/2015082710421020150811.jpg\",\n" +
                "            \"fundId\": \"48817065-ce2c-4a12-bc64-3a9356fb5aa5\",\n" +
                "            \"fundByname\": \"VIE回归专项投资基金\",\n" +
                "            \"rate\": \"100\"\n" +
                "        }]\n" +
                "    },\n" +
                "    \"code\": 0,\n" +
                "    \"msg\": \"\"\n" +
                "}";
        return myJsonData;
    }

    @ApiOperation(httpMethod = "GET", value = "基金详情(<font color='blue'>release</font>)",position = 2,notes = "接口地址:/api/fund/findById<br>请求参数:<br>" +
            "<table>" +
            "<th >参数</th><th>参数名称</th><th>是否为空</th><th>备注</th>" +
            "<tr><td >id</td><td>基金ID</td><td>否</td><td>基金ID</td></tr></table>" +
            "<br>返回说明:<br>" +
            "<table  >" +
            "<th >字段</th><th>备注</th>" +
            "<tr><td>currency</td><td>基金币种</td></tr>" +
            "<tr><td>duration</td><td>存续期</td></tr>" +
            "<tr><td>expectedReturn</td><td>预期收益率</td></tr>" +
            "<tr><td>managementFee</td><td>管理费</td></tr>" +
            "<tr><td>priorityYield</td><td>优先收益率</td></tr>" +
            "<tr><td>rateStartDate</td><td>募集开始日期</td></tr>" +
            "<tr><td>reateEndDate</td><td>募集结束日期</td></tr>" +
            "<tr><td>ratingMoney</td><td>剩余金额</td></tr>" +
            "<tr><td>fundTypeName</td><td>基金类型</td></tr>" +
            "<tr><td>fundSize</td><td>基金规模</td></tr>" +
            "<tr><td>fundMode</td><td>出资方式</td></tr>" +
            "<tr><td>toRaise</td><td>已募集金额</td></tr>" +
            "<tr><td>rateStatus</td><td>募集状态:0募集结束1正在募集中</td></tr>" +
            "<tr><td>desc</td><td>简介</td></tr>" +
            "<tr><td>fundByname</td><td>标题</td></tr>" +
            "<tr><td>rate</td><td>募集进度</td></tr>" +
            "<table>")
    @ResponseBody
    @RequestMapping(value = "/api/fund/findById", method = RequestMethod.GET)
    public String create(@RequestParam String id) {
      return "{\n" +
              "    \"message\":\"成功\",\n" +
              "    \"data\":{\n" +
              "        \"currency\":\"人民币\",\n" +
              "        \"duration\":\"3+4\",\n" +
              "        \"expectedReturn\":\"25%\",\n" +
              "        \"managementFee\":\"2%\",\n" +
              "        \"priorityYield\":\"第一步: 向LP及普通合伙人分配本金； 第二步: 向LP分配8%的优先收益； 第三步: 如仍有剩余，向GP回拨优先受益； 第四步: 将剩余收益中的20%分配给GP，80%分配给LP\",\n" +
              "        \"rateStartDate\":\"1467302400\",\n" +
              "        \"ratingMoney\":\"14000\",\n" +
              "        \"fundTypeName\":\"股权投资基金\",\n" +
              "        \"reateEndDate\":\"1501430400\",\n" +
              "        \"fundSize\":\"4亿\",\n" +
              "        \"fundMode\":\"非一次性出资\",\n" +
              "        \"fundType\":\"9901\",\n" +
              "        \"toRaise\":\"26000万\",\n" +
              "        \"rateStatus\":1,\n" +
              "        \"desc\":\"上市公司为基石投资人，行业内项目资源丰富，增加项目退出渠道\",\n" +
              "        \"url\":\"http://www.pestreet.cn/c/freemarker/upload/img/20160707/20160707102149dffd.jpg\",\n" +
              "        \"capitalContribution\":\"500万\",\n" +
              "        \"recommended\":\"资源整合\",\n" +
              "        \"fundId\":\"deeb77c9-fff1-4092-9de7-a4b2de04b00a\",\n" +
              "        \"fundByname\":\"TMT+大消费产业基金\",\n" +
              "        \"rate\":65\n" +
              "    },\n" +
              "    \"code\":0\n" +
              "}\n" ;
    }

}
