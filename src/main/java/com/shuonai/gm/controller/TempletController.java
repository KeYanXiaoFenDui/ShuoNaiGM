package com.shuonai.gm.controller;

import com.github.pagehelper.PageHelper;
import com.shuonai.gm.domain.Api;
import com.shuonai.gm.domain.ApiParam;
import com.shuonai.gm.domain.vo.ApiObjectVo;
import com.shuonai.gm.domain.vo.ParamObjectVo;
import com.shuonai.gm.service.IApiParamService;
import com.shuonai.gm.service.IApiService;
import com.shuonai.gm.service.ITableParamService;
import com.shuonai.gm.util.CommonUtil;
import com.shuonai.gm.util.JsonTool;
import com.shuonai.gm.util.PageBean;
import com.shuonai.gm.util.ShangXianUtil;
import com.shuonai.gm.util.constant.MessageConstant;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Admininstrator on 2018/11/5.
 */
@RestController
@RequestMapping("/templet")
public class TempletController {
    public static final String OutputPath_uk = "D:/桌面文件/测试.xls";
    private static Logger logger = LoggerFactory.getLogger(TempletController.class);

    @Autowired
    private IApiService apiService;
    @Autowired
    private IApiParamService apiParamService;

    @Transactional(rollbackFor = Exception.class)
    @RequestMapping(value = "/listStoreForC")
    public HashMap<String,Object> listStoreForC(HttpServletRequest request) {
        int status = MessageConstant.ERROR_CODE;
        String message = MessageConstant.ERROR_INFO_DEMO;
        HashMap<String,Object> data = new HashMap<>();
        try {
//            PageHelper.startPage(Integer.parseInt(CommonUtil.getStr(request.getParameter("pageNum"), "1")), Integer.parseInt(CommonUtil.getStr(request.getParameter("pageSize"), "10")));//第几页,,,每页多少条记录
//            List<Map> storeList = vipService.getListStoreForC(Integer.parseInt(CommonUtil.getStr(request.getParameter("id"),"0")),CommonUtil.getStr(request.getParameter("title"),""));
//            PageBean<Map> page = new PageBean<Map>(storeList);

//            if(storeList == null){
//                return CommonUtil.ToResultHashMap(status,MessageConstant.NOT_FIND_DATA,null);
//            }
            status = 1;
            message = MessageConstant.SUCCESS_INFO;
//            data.put("storeList",page);
        } catch (Exception e){
            e.printStackTrace();
            logger.error("申请会员/会员续费异常：" + e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return CommonUtil.ToResultHashMap(status,message,data);
    }

    @Transactional(rollbackFor = Exception.class)
    @RequestMapping(value = "/testPostInputParam")
    public HashMap<String,Object> testPostInputParam(HttpServletRequest request) {
        int status = MessageConstant.ERROR_CODE;
        String message = MessageConstant.ERROR_INFO_DEMO;
        HashMap<String,Object> data = new HashMap<>();

        String te = CommonUtil.getStr(request.getParameter("apiName"),"");
        System.out.println(te);
        String test = getStringFromStream(request);//从数据流获取数据request payload
        System.out.println("test:"+test);
        JSONObject json = JsonTool.getJSON(test);
        Map store = json;
        try {
//            PageHelper.startPage(Integer.parseInt(CommonUtil.getStr(request.getParameter("pageNum"), "1")), Integer.parseInt(CommonUtil.getStr(request.getParameter("pageSize"), "10")));//第几页,,,每页多少条记录
//            List<Map> storeList = vipService.getListStoreForC(Integer.parseInt(CommonUtil.getStr(request.getParameter("id"),"0")),CommonUtil.getStr(request.getParameter("title"),""));
//            PageBean<Map> page = new PageBean<Map>(storeList);

//            if(storeList == null){
//                return CommonUtil.ToResultHashMap(status,MessageConstant.NOT_FIND_DATA,null);
//            }
            status = 1;
            message = MessageConstant.SUCCESS_INFO;
//            data.put("storeList",page);
        } catch (Exception e){
            e.printStackTrace();
            logger.error("申请会员/会员续费异常：" + e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return CommonUtil.ToResultHashMap(status,message,data);
    }

    /**
     *
     */
    @RequestMapping(value = "/newApi")
    public HashMap<String,Object> newApi(HttpServletRequest request,ApiObjectVo apiObjectVo) {
        int status = MessageConstant.ERROR_CODE;
        String message = MessageConstant.ERROR_INFO_DEMO;
        HashMap<String,Object> data = new HashMap<>();
        try {
            StringBuffer sb = new StringBuffer();

            String apiName = apiObjectVo.getApiName();
            String apiBasePath = apiObjectVo.getApiBasePath();
            String apiMethod = apiObjectVo.getApiMethod();
            String apiComment = apiObjectVo.getApiComment();
            String requestMethod = apiObjectVo.getRequestMethod();
            String dataOperation = apiObjectVo.getDataOperation();
            int ifRollback = apiObjectVo.getIfRollback();
            int ifPages = apiObjectVo.getIfPages();

            Api api = new Api();
            api.setApiName(apiName);
            api.setBasePath("");
            api.setBasePath(apiBasePath);
            api.setApiMethod(apiMethod);
            api.setApiComment(apiComment);
            api.setRequestMethod(requestMethod);
            api.setDataOperation(dataOperation);
            api.setIfRollback(ifRollback);
            api.setIfPages(ifPages);
            Date date = new Date();
            api.setCreateTime(date);
            api.setUpdateTime(date);
            api.setStatus(1);
            apiService.insertApi(api);

            List<ParamObjectVo> params = apiObjectVo.getParams();
            sb.append("/**\n");
            sb.append("*"+apiName+"\n");
            if(apiComment != null && !apiComment.equals("")){
                sb.append("*"+apiComment+"\n");
            }
            sb.append("*/\n");
            if(ifRollback != 0 && ifRollback == 1) {//回滚
                sb.append("@Transactional(rollbackFor = Exception.class)\n");
            }
            sb.append("@RequestMapping(value = \"/"+apiMethod+"\")\n");
            sb.append("public HashMap<String,Object> "+apiMethod+"(HttpServletRequest request) {\n");
            sb.append("\tint status = MessageConstant.ERROR_CODE;\n");
            sb.append("\tString message = MessageConstant.ERROR_INFO_DEMO;\n");
            sb.append("\tHashMap<String,Object> data = new HashMap<>();\n");

            for (ParamObjectVo param : params){
                String paramTitle = param.getParamTitle();
                String paramName = param.getParamName();
                String paramType = param.getParamType();
                String ifMust = param.getIfMust();
                String paramComment = param.getParamComment();

                ApiParam apiParam = new ApiParam();
                apiParam.setApiId(api.getId());
                apiParam.setParamTitle(paramTitle);
                apiParam.setParamName(paramName);
                apiParam.setParamType(paramType);
                apiParam.setIfMust(ifMust);
                apiParam.setParamComment(paramComment);
                apiParam.setCreateTime(date);
                apiParam.setUpdateTime(date);
                apiParam.setStatus(1);
                apiParamService.insertApiParam(apiParam);

                if(paramComment != null && !paramComment.trim().equals("")){
                    sb.append("\t//"+paramTitle+"\t"+paramComment+"\n");
                }
                if(paramType != null && paramType.equals("String")){
                    //String 类型参数
                    sb.append("\tString "+paramName+" = CommonUtil.getStr(request.getParameter(\""+paramName+"\"),\"\");\n");
                    if(ifMust != null && ifMust.equals("T")){
                        sb.append("\tif("+paramName+" == null || "+paramName+".equals(\"\")){return CommonUtil.ToResultHashMap(status,\""+paramName+"为空!\",null);}\n");
                    }
                }else if(paramType != null && paramType.equals("int")){
                    //int 类型参数
                    sb.append("\tint "+paramName+" = Integer.parseInt(CommonUtil.getStr(request.getParameter(\""+paramName+"\"),\"-500\"));\n");
                    if(ifMust != null && ifMust.equals("T")){
                        sb.append("\tif("+paramName+" == -500){return CommonUtil.ToResultHashMap(status,\""+paramName+"为空!\",null);}\n");
                    }
                }else if(paramType != null && paramType.equals("Map")){
                    //Map 类型参数
                    sb.append("\tMap "+paramName+" = (Map)request.getParameter(\""+paramName+"\");\n");
                    if(ifMust != null && ifMust.equals("T")){
                        sb.append("\tif("+paramName+" == null){return CommonUtil.ToResultHashMap(status,\""+paramName+"为空!\",null);}\n");
                    }
                }else if(paramType != null && paramType.equals("List<Map>")){
                    //List<Map> 类型参数
                    sb.append("\tList<Map> "+paramName+" = (List<Map>)request.getParameter(\""+paramName+"\");\n");
                    if(ifMust != null && ifMust.equals("T")){
                        sb.append("\tif("+paramName+" == null){return CommonUtil.ToResultHashMap(status,\""+paramName+"为空!\",null);}\n");
                    }
                }else if(paramType != null && paramType.equals("List<String>")){
                    //List<String> 类型参数
                    sb.append("\tList<String> "+paramName+" = (List<String>)request.getParameter(\""+paramName+"\");\n");
                    if(ifMust != null && ifMust.equals("T")){
                        sb.append("\tif("+paramName+" == null){return CommonUtil.ToResultHashMap(status,\""+paramName+"为空!\",null);}\n");
                    }
                }else if(paramType != null && paramType.equals("List<Integer>")){
                    //List<Integer> 类型参数
                    sb.append("\tList<Integer> "+paramName+" = (List<Integer>)request.getParameter(\""+paramName+"\");\n");
                    if(ifMust != null && ifMust.equals("T")){
                        sb.append("\tif("+paramName+" == null){return CommonUtil.ToResultHashMap(status,\""+paramName+"为空!\",null);}\n");
                    }
                }
            }

            if(ifRollback != 0 && ifRollback == 1) {//回滚
                sb.append("\ttry {\n");
            }

            if(ifRollback != 0 && ifRollback == 1) {//回滚
                sb.append("\t} catch (Exception e){\n");
                sb.append("\t\te.printStackTrace();\n");
                sb.append("\t\tlogger.error(\""+apiName+"异常：\" + e.getMessage());\n");
                sb.append("\t\tTransactionAspectSupport.currentTransactionStatus().setRollbackOnly();\n");
                sb.append("\t}\n");
            }
            sb.append("\treturn CommonUtil.ToResultHashMap(status,message,data);\n");
            sb.append("}\n");
            System.out.println(sb.toString());

            ShangXianUtil.writeToTxt("api.txt","D:\\桌面文件",sb.toString());
            exportExcel(apiObjectVo);
//            String apiName = CommonUtil.getStr(request.getParameter("apiName"),"");
//            String apiUrl = CommonUtil.getStr(request.getParameter("apiUrl"),"");
//            String apiComment = CommonUtil.getStr(request.getParameter("apiComment"),"");
//            String requestMethod = CommonUtil.getStr(request.getParameter("requestMethod"),"");
//            String dataOperation = CommonUtil.getStr(request.getParameter("dataOperation"),"");
//            String ifRollback = CommonUtil.getStr(request.getParameter("ifRollback"),"");
//            String ifPages = CommonUtil.getStr(request.getParameter("ifPages"),"");
//            System.out.println(apiName);
//            System.out.println(apiUrl);
//            System.out.println(apiComment);
//            System.out.println(requestMethod);
//            System.out.println(dataOperation);
//            System.out.println(ifRollback);
//            System.out.println(ifPages);
//            PageHelper.startPage(Integer.parseInt(CommonUtil.getStr(request.getParameter("pageNum"), "1")), Integer.parseInt(CommonUtil.getStr(request.getParameter("pageSize"), "10")));//第几页,,,每页多少条记录
//            List<Map> storeList = vipService.getListStoreForC(Integer.parseInt(CommonUtil.getStr(request.getParameter("id"),"0")),CommonUtil.getStr(request.getParameter("title"),""));
//            PageBean<Map> page = new PageBean<Map>(storeList);

//            if(storeList == null){
//                return CommonUtil.ToResultHashMap(status,MessageConstant.NOT_FIND_DATA,null);
//            }
            status = 1;
            message = MessageConstant.SUCCESS_INFO;
//            data.put("storeList",page);
        } catch (Exception e){
            e.printStackTrace();
            logger.error("申请会员/会员续费异常：" + e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return CommonUtil.ToResultHashMap(status,message,data);
    }


    public static void exportExcel(ApiObjectVo apiObjectVo) {
        WritableWorkbook book = null;
        try {
            book = Workbook.createWorkbook(new File(OutputPath_uk));
            WritableSheet sheet = book.createSheet("Api", 0);
            // 指定单元格位置是第一列第一行(0, 0)

            sheet.addCell(new Label(0, 0, "接口名称:"));
            sheet.addCell(new Label(1, 0, apiObjectVo.getApiName()));

            sheet.addCell(new Label(0, 1, "接口地址:"));
            sheet.addCell(new Label(1, 1, apiObjectVo.getApiMethod()));

            sheet.addCell(new Label(0, 2, "请求方法:"));
            sheet.addCell(new Label(1, 2, apiObjectVo.getRequestMethod()));

            sheet.addCell(new Label(0, 3, "请求参数说明:"));
            //序号	字段	名称	必填	数据类型	说明
            sheet.addCell(new Label(1, 3, "序号"));
            sheet.addCell(new Label(2, 3, "字段"));
            sheet.addCell(new Label(3, 3, "名称"));
            sheet.addCell(new Label(4, 3, "必填"));
            sheet.addCell(new Label(5, 3, "数据类型"));
            sheet.addCell(new Label(6, 3, "说明"));
            List<ParamObjectVo> params = apiObjectVo.getParams();
            int num = 1;
            for (ParamObjectVo param : params){
                sheet.addCell(new Label(1, num+3, CommonUtil.getStr(num,"0")));//序号
                sheet.addCell(new Label(2, num+3, param.getParamName()));//字段
                sheet.addCell(new Label(3, num+3, param.getParamTitle()));//名称
                sheet.addCell(new Label(4, num+3, param.getIfMust()));//必填
                sheet.addCell(new Label(5, num+3, param.getParamType()));//数据类型
                sheet.addCell(new Label(6, num+3, CommonUtil.getStr(param.getParamComment(),"")));//说明
                num++;
            }


//            sheet.addCell(new Label(2, 0, "价格"));
//            sheet.addCell(new Label(3, 0, "库存"));
//            sheet.addCell(new Label(4, 0, "评论数"));
//            sheet.addCell(new Label(5, 0, "排名"));
//            sheet.addCell(new Label(6, 0, "分数"));
//            sheet.addCell(new Label(7, 0, "reqTime"));

//            for(int raw = 0;raw<voList.size();raw++){
//                ExportInfoVo vo = voList.get(raw);
//
//                sheet.addCell(new Label(0, raw+1, vo.getCode()));
//                sheet.addCell(new Label(1, raw+1, vo.getName()));
//                sheet.addCell(new Label(2, raw+1, vo.getPrice()));
//                sheet.addCell(new Label(3, raw+1, vo.getStore()));
//                sheet.addCell(new Label(4, raw+1, vo.getReviewCount()));
//                sheet.addCell(new Label(5, raw+1, vo.getRank()));
//                sheet.addCell(new Label(6, raw+1, vo.getGrade()));
//                sheet.addCell(new Label(7, raw+1, Integer.toString(vo.getReqTime())));
//
//            }

            // 写入数据并关闭文件
            book.write();
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            if(book!=null){
                try {
                    book.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    private String getStringFromStream(HttpServletRequest req) {
        ServletInputStream is;
        try {
            is = req.getInputStream();
            int nRead = 1;
            int nTotalRead = 0;
            byte[] bytes = new byte[10240];
            while (nRead > 0) {
                nRead = is.read(bytes, nTotalRead, bytes.length - nTotalRead);
                if (nRead > 0)
                    nTotalRead = nTotalRead + nRead;
            }
            String str = new String(bytes, 0, nTotalRead, "utf-8");
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
