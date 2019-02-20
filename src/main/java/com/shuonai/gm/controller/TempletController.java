package com.shuonai.gm.controller;

import com.github.pagehelper.PageHelper;
import com.shuonai.gm.domain.Api;
import com.shuonai.gm.domain.ApiParam;
import com.shuonai.gm.domain.ApiProjectModel;
import com.shuonai.gm.domain.Project;
import com.shuonai.gm.domain.vo.ApiObjectVo;
import com.shuonai.gm.domain.vo.ParamObjectVo;
import com.shuonai.gm.domain.vo.ProjectModelVo;
import com.shuonai.gm.service.*;
import com.shuonai.gm.util.CommonUtil;
import com.shuonai.gm.util.JsonTool;
import com.shuonai.gm.util.PageBean;
import com.shuonai.gm.util.ShangXianUtil;
import com.shuonai.gm.util.constant.MessageConstant;
import jxl.Sheet;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

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
    @Autowired
    private IApiProjectModelService apiProjectModelService;
    @Autowired
    private IProjectService projectService;

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
    @ResponseBody
    @RequestMapping(value = "/newApi")
    public HashMap<String,Object> newApi(HttpServletRequest request,ApiObjectVo apiObjectVo) {
        int status = MessageConstant.ERROR_CODE;
        String message = MessageConstant.ERROR_INFO_DEMO;
        Map<String,Object> data = new HashMap<>();
        Map<String,Object> data2 = new HashMap<>();
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
            List<ParamObjectVo> paramso = apiObjectVo.getParamso();
            if(paramso != null && paramso.size() > 0){
                for (ParamObjectVo param : paramso){
                    String paramTitle = param.getParamTitle();
                    String paramName = param.getParamName();
                    String paramType = param.getParamType();
                    String ifMust = param.getIfMust();
                    String paramComment = param.getParamComment();

                    ApiParam apiParam = new ApiParam();
                    apiParam.setApiId(api.getId());
                    apiParam.setParamInOutType(2);
                    apiParam.setParentId(0);
                    apiParam.setParamTitle(paramTitle);
                    apiParam.setParamName(paramName);
                    apiParam.setParamType(paramType);
                    apiParam.setIfMust(ifMust);
                    apiParam.setParamComment(paramComment);
                    apiParam.setCreateTime(date);
                    apiParam.setUpdateTime(date);
                    apiParam.setStatus(1);
                    apiParamService.insertApiParam(apiParam);
                }
            }
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

            if(ifPages == 1){
                sb.append("\tPageHelper.startPage(Integer.parseInt(CommonUtil.getStr(request.getParameter(\"pageNum\"), \"1\")), Integer.parseInt(CommonUtil.getStr(request.getParameter(\"pageSize\"), \"10\")));//第几页,,,每页多少条记录\n");
            }
            if(params != null && params.size() > 0){
                for (ParamObjectVo param : params){
                    String paramTitle = param.getParamTitle();
                    String paramName = param.getParamName();
                    String paramType = param.getParamType();
                    String ifMust = param.getIfMust();
                    String paramComment = param.getParamComment();

                    ApiParam apiParam = new ApiParam();
                    apiParam.setApiId(api.getId());
                    apiParam.setParamInOutType(1);
                    apiParam.setParentId(0);
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
            }

            if(ifRollback != 0 && ifRollback == 1) {//回滚
                sb.append("\ttry {\n");
            }

            if(ifPages == 1){
                sb.append("\tPageBean<Map> list = new PageBean<Map>(resultList);\n");
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

//            ShangXianUtil.writeToTxt("api.txt","D:\\桌面文件",sb.toString());
            ShangXianUtil.fileChaseFW("D:\\桌面文件\\api.txt",sb.toString());

            JSONObject jsonInputParams = null;
            if (requestMethod.equals("post")){
                data2 = inputParamssJsonTree(apiObjectVo);
                jsonInputParams = JSONObject.fromObject(data2);
                System.out.println("jsonInput:"+jsonInputParams.toString());
            }

            data = outputParamssJsonTree(apiObjectVo);
            JSONObject json = JSONObject.fromObject(CommonUtil.ToResultHashMap(status,message,data));
            System.out.println("jsonOutput:"+json.toString());

            exportExcel(apiObjectVo,json,jsonInputParams);

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

    @ResponseBody
    @Transactional
    @RequestMapping(value = "/addProjectModel")
    public HashMap<String,Object> addProjectModel(HttpServletRequest request, ProjectModelVo projectModelVo){
        int status = MessageConstant.ERROR_CODE;
        String message = MessageConstant.ERROR_INFO_DEMO;
        Map<String,Object> data = new HashMap<>();
        try{
            ApiProjectModel apm = new ApiProjectModel();
            apm.setProjectName(projectModelVo.getProjectName());
            apm.setProjectTitle(projectModelVo.getProjectTitle());
            apm.setModelName(projectModelVo.getModelName());
            apm.setModelTitle(projectModelVo.getModelTitle());
            apm.setCreateTime(new Date());
            apm.setStatus(1);
            int result = apiProjectModelService.insertApiProjectModel(apm);
            if(result == 1){
                status = MessageConstant.SUCCESS_CODE;
                message = MessageConstant.SUCCESS_INFO;
            }
            data.put("status",status);
            data.put("message",message);
        } catch (Exception e){
            status = -1;
            message = MessageConstant.ERROR_INFO;
            e.printStackTrace();
            logger.error("添加项目模块异常,回滚:"+e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//出错回滚
        }
        return CommonUtil.ToResultHashMap(status,message,null);
    }

    @ResponseBody
    @Transactional
    @RequestMapping(value = "/newProject",method = {RequestMethod.POST})
    public HashMap<String,Object> newProject(HttpServletRequest request, ProjectModelVo projectModelVo){
        int status = MessageConstant.ERROR_CODE;
        String message = MessageConstant.ERROR_INFO_DEMO;
        Map<String,Object> data = new HashMap<>();
        try{
            String projectName = CommonUtil.getStr(request.getParameter("projectName"),"");
            String projectTitle = CommonUtil.getStr(request.getParameter("projectTitle"),"");
            if(!projectName.equals("") && !projectTitle.equals("")){
                Project p = new Project();
                p.setProjectName(projectName);
                p.setProjectTitle(projectTitle);
                projectService.insertProject(p);
            }
            System.out.println("newProject:"+projectName);
            System.out.println("newProject:"+projectTitle);
//            ApiProjectModel apm = new ApiProjectModel();
//            apm.setProjectName(projectModelVo.getProjectName());
//            apm.setProjectTitle(projectModelVo.getProjectTitle());
//            apm.setModelName(projectModelVo.getModelName());
//            apm.setModelTitle(projectModelVo.getModelTitle());
//            apm.setCreateTime(new Date());
//            apm.setStatus(1);
//            int result = apiProjectModelService.insertApiProjectModel(apm);
//            if(result == 1){
//                status = MessageConstant.SUCCESS_CODE;
//                message = MessageConstant.SUCCESS_INFO;
//            }
            data.put("status",status);
            data.put("message",message);
        } catch (Exception e){
            status = -1;
            message = MessageConstant.ERROR_INFO;
            e.printStackTrace();
            logger.error("添加项目模块异常,回滚:"+e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//出错回滚
        }
        return CommonUtil.ToResultHashMap(status,message,null);
    }

    public void exportExcel(ApiObjectVo apiObjectVo,JSONObject json,JSONObject jsonInput) {
//        WritableWorkbook book = null;
//            Workbook book = null;
        WritableWorkbook wbook = null;
        WritableSheet sh = null;
        try {
            File file = new File(OutputPath_uk);
            if(!file.exists()){
                //-----------新建start-----------------
                wbook = Workbook.createWorkbook(file);
                wbook.setProtected(true);
                // -- 第一个参数是Sheet名，第二个参数是Sheet下标
                // -- 下标是整数，只起标识作用，建立的时候会以create顺序建立，本例生成的EXCEL文件第一个Sheet是sheet1
                sh = wbook.createSheet("第一页", 1);
                //-----------新建end-----------------
            }else{
                //-----------追加start---------------
                Workbook book = Workbook.getWorkbook(file);
                Sheet sheet = book.getSheet(0);
                // 获取行
                int length = sheet.getRows();
                wbook = Workbook.createWorkbook(file, book); // 根据book创建一个操作对象
                sh = wbook.getSheet(0);// 得到一个工作对象
                //-----------追加end---------------
            }



            int row = apiService.getSeq();
            sh.addCell(new Label(0, row, "接口名称:"));
            sh.addCell(new Label(1, row, apiObjectVo.getApiName()));
            row++;

            sh.addCell(new Label(0, row, "接口地址:"));
            sh.addCell(new Label(1, row, apiObjectVo.getApiMethod()));
            row++;

            sh.addCell(new Label(0, row, "请求前缀:"));
            sh.addCell(new Label(1, row, "/api/business"+apiObjectVo.getApiBasePath()));
            row++;

            sh.addCell(new Label(0, row, "请求方法:"));
            sh.addCell(new Label(1, row, apiObjectVo.getRequestMethod()));
            row++;

            sh.addCell(new Label(0, row, "请求参数说明:"));
            //序号	字段	名称	必填	数据类型	说明
            sh.addCell(new Label(1, row, "序号"));
            sh.addCell(new Label(2, row, "字段"));
            sh.addCell(new Label(3, row, "名称"));
            sh.addCell(new Label(4, row, "必填"));
            sh.addCell(new Label(5, row, "数据类型"));
            sh.addCell(new Label(6, row, "说明"));
            row++;
            int num = 1;
            int ifPages = Integer.parseInt(CommonUtil.getStr(apiObjectVo.getIfPages(),"0"));
            if(ifPages == 1){
                sh.addCell(new Label(1, row, "1"));
                sh.addCell(new Label(2, row, "pageNum"));
                sh.addCell(new Label(3, row, "页码"));
                sh.addCell(new Label(4, row, "F"));
                sh.addCell(new Label(5, row, "int"));
                sh.addCell(new Label(6, row, "默认为1"));
                row++;num++;
                sh.addCell(new Label(1, row, "2"));
                sh.addCell(new Label(2, row, "pageSize"));
                sh.addCell(new Label(3, row, "每页长度"));
                sh.addCell(new Label(4, row, "F"));
                sh.addCell(new Label(5, row, "int"));
                sh.addCell(new Label(6, row, "默认为10"));
                row++;num++;
            }
            List<ParamObjectVo> params = apiObjectVo.getParams();
            if(params != null && params.size() > 0){
                for (ParamObjectVo param : params){
                    sh.addCell(new Label(1, row, CommonUtil.getStr(num,"0")));//序号
                    sh.addCell(new Label(2, row, param.getParamName()));//字段
                    sh.addCell(new Label(3, row, param.getParamTitle()));//名称
                    sh.addCell(new Label(4, row, param.getIfMust()));//必填
                    sh.addCell(new Label(5, row, param.getParamType()));//数据类型
                    sh.addCell(new Label(6, row, CommonUtil.getStr(param.getParamComment(),"")));//说明
                    row++;num++;
                }
                if(CommonUtil.getStr(apiObjectVo.getRequestMethod(),"").equals("post")){
                    sh.addCell(new Label(0, row, "请求参数示例："));
                    sh.addCell(new Label(1, row, jsonInput.toString()));
                    row++;
                }
            }

            sh.addCell(new Label(0, row, "输出参数说明:"));
            //序号	字段	名称	必填	数据类型	说明
            sh.addCell(new Label(1, row, "序号"));
            sh.addCell(new Label(2, row, "字段"));
            sh.addCell(new Label(3, row, "名称"));
            sh.addCell(new Label(4, row, "必填"));
            sh.addCell(new Label(5, row, "数据类型"));
            sh.addCell(new Label(6, row, "说明"));
            row++;
            sh.addCell(new Label(1, row, "1"));
            sh.addCell(new Label(2, row, "status"));
            sh.addCell(new Label(3, row, "状态码"));
            sh.addCell(new Label(4, row, "T"));
            sh.addCell(new Label(5, row, "int"));
            sh.addCell(new Label(6, row, "1为成功,其它为失败"));
            row++;
            sh.addCell(new Label(1, row, "2"));
            sh.addCell(new Label(2, row, "message"));
            sh.addCell(new Label(3, row, "返回信息"));
            sh.addCell(new Label(4, row, "T"));
            sh.addCell(new Label(5, row, "String"));
            sh.addCell(new Label(6, row, ""));
            row++;
            sh.addCell(new Label(1, row, "3"));
            sh.addCell(new Label(2, row, "data"));
            sh.addCell(new Label(3, row, "返回数据集"));
            sh.addCell(new Label(4, row, "T"));
            sh.addCell(new Label(5, row, "Map"));
            sh.addCell(new Label(6, row, ""));
            row++;
            int index = 4;
            if(ifPages == 1){
                sh.addCell(new Label(1, row, "4"));
                sh.addCell(new Label(2, row, "total"));
                sh.addCell(new Label(3, row, "数据总条数"));
                sh.addCell(new Label(4, row, "T"));
                sh.addCell(new Label(5, row, "int"));
                sh.addCell(new Label(6, row, ""));
                row++;
                sh.addCell(new Label(1, row, "5"));
                sh.addCell(new Label(2, row, "pageNum"));
                sh.addCell(new Label(3, row, "页码"));
                sh.addCell(new Label(4, row, "T"));
                sh.addCell(new Label(5, row, "int"));
                sh.addCell(new Label(6, row, ""));
                row++;
                sh.addCell(new Label(1, row, "6"));
                sh.addCell(new Label(2, row, "pageSize"));
                sh.addCell(new Label(3, row, "每页长度"));
                sh.addCell(new Label(4, row, "T"));
                sh.addCell(new Label(5, row, "int"));
                sh.addCell(new Label(6, row, ""));
                row++;
                sh.addCell(new Label(1, row, "7"));
                sh.addCell(new Label(2, row, "pages"));
                sh.addCell(new Label(3, row, "共几页"));
                sh.addCell(new Label(4, row, "T"));
                sh.addCell(new Label(5, row, "int"));
                sh.addCell(new Label(6, row, ""));
                row++;
                sh.addCell(new Label(1, row, "8"));
                sh.addCell(new Label(2, row, "size"));
                sh.addCell(new Label(3, row, "当页数据数"));
                sh.addCell(new Label(4, row, "T"));
                sh.addCell(new Label(5, row, "int"));
                sh.addCell(new Label(6, row, ""));
                row++;
                sh.addCell(new Label(1, row, "9"));
                sh.addCell(new Label(2, row, "list"));
                sh.addCell(new Label(3, row, "数据列表集合"));
                sh.addCell(new Label(4, row, "T"));
                sh.addCell(new Label(5, row, "list<Map>"));
                sh.addCell(new Label(6, row, ""));
                row++;
                index = 10;
            }
            List<ParamObjectVo> paramso = apiObjectVo.getParamso();
            if(paramso != null && paramso.size() > 0) {
                for (ParamObjectVo param : paramso) {
                    sh.addCell(new Label(1, row, CommonUtil.getStr(index, "0")));//序号
                    sh.addCell(new Label(2, row, param.getParamName()));//字段
                    sh.addCell(new Label(3, row, param.getParamTitle()));//名称
                    sh.addCell(new Label(4, row, param.getIfMust()));//必填
                    sh.addCell(new Label(5, row, param.getParamType()));//数据类型
                    sh.addCell(new Label(6, row, CommonUtil.getStr(param.getParamComment(), "")));//说明
                    row++;
                    index++;
                }
                sh.addCell(new Label(0, row, "返回参数示例："));
                sh.addCell(new Label(1, row, json.toString()));
                row++;
                index++;
            }
            apiService.updateSeq(++row);

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
//            book.write();
            wbook.write();
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            if(wbook!=null){
                try {
                    wbook.close();
//                    book.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public Map<String,Object> inputParamssJsonTree(ApiObjectVo apiObjectVo){
        List<ParamObjectVo> inputParams = apiObjectVo.getParams();
        Map<String,Object> data = new HashMap<String,Object>();
        int ifPages = apiObjectVo.getIfPages();
        if(ifPages == 1){
            data.put("pageNum",1);
            data.put("pageSize",10);
        }

        Map<String,String> fathersType = new HashMap<String,String>();
        Map<String,Object> fatherObjects = new HashMap<String,Object>();
//        fathersType.put("data","Map");
//        fatherObjects.put("data",new HashMap());
//        if(ifPages == 1){
//            fathersType.put("list","List<Map>");
//            fatherObjects.put("list",new ArrayList<Map>());
//        }

        //先创建所有父对象,,
        if(inputParams != null && inputParams.size() > 0){
            for (ParamObjectVo in : inputParams){
                String type = in.getParamType();
                if(type.equals("String")){fatherObjects.put(in.getParamName(),"");fathersType.put(in.getParamName(),in.getParamType());continue;}
                if(type.equals("int")){fatherObjects.put(in.getParamName(),0);fathersType.put(in.getParamName(),in.getParamType());continue;}
                if(type.equals("Map")){fatherObjects.put(in.getParamName(),new HashMap());fathersType.put(in.getParamName(),in.getParamType());continue;}
                if(type.equals("List<Map>")){fatherObjects.put(in.getParamName(),new ArrayList<Map>());fathersType.put(in.getParamName(),in.getParamType());continue;}
                if(type.equals("List<String>")){fatherObjects.put(in.getParamName(),new ArrayList<String>());fathersType.put(in.getParamName(),in.getParamType());continue;}
                if(type.equals("List<Integer>")){fatherObjects.put(in.getParamName(),new ArrayList<Integer>());fathersType.put(in.getParamName(),in.getParamType());}
            }
        }else{
            return null;
        }
        HashMap tempMap = new HashMap();
        ArrayList<Map> tempMapList = new ArrayList<Map>();
//        ArrayList<String> tempStringList = new ArrayList<String>();
        for (ParamObjectVo in : inputParams){
            String father = CommonUtil.getStr(in.getFatherName(),"");
            if(!father.equals("")){
                String type = fathersType.get(father);
                if(type.equals("Map")){
                    tempMap = (HashMap)fatherObjects.get(father);
                    tempMap.put(in.getParamName(),fatherObjects.get(in.getParamName()));
                    fatherObjects.put(father,tempMap);
                }
                if(type.equals("List<Map>")){
                    tempMapList = (ArrayList<Map>) fatherObjects.get(father);
                    if(tempMapList == null || tempMapList.size() == 0){tempMapList.add(new HashMap());}
                    tempMap = (HashMap) tempMapList.get(0);
                    tempMap.put(in.getParamName(),fatherObjects.get(in.getParamName()));
                    tempMapList.remove(0);
                    tempMapList.add(tempMap);
                    fatherObjects.put(father,tempMapList);
                }
            }else if(father.equals("")){
                data.put(in.getParamName(),fatherObjects.get(in.getParamName()));
            }
        }
        return data;
    }

    public Map<String,Object> outputParamssJsonTree(ApiObjectVo apiObjectVo){
//        List<ParamObjectVo> inputParams = apiObjectVo.getParams();
        List<ParamObjectVo> outputParams = apiObjectVo.getParamso();
        Map<String,Object> data = new HashMap<String,Object>();
        ArrayList<Map> list = new ArrayList<Map>();
        int ifPages = apiObjectVo.getIfPages();
//        Map resultMap = new HashMap();
//        Map data = new HashMap();
//        List<Map> list = new ArrayList();
//        resultMap.put("status",0);
//        resultMap.put("message","接口回调例子");
//        resultMap.put("data",data);
        if(ifPages == 1){
            data.put("total",20);
            data.put("pageNum",1);
            data.put("pageSize",10);
            data.put("pages",2);
            data.put("size",10);
//            data.put("list",list);
        }

        Map<String,String> fathersType = new HashMap<String,String>();
        Map<String,Object> fatherObjects = new HashMap<String,Object>();
        fathersType.put("data","Map");
        fatherObjects.put("data",new HashMap());
        if(ifPages == 1){
            fathersType.put("list","List<Map>");
            fatherObjects.put("list",new ArrayList<Map>());
        }

        //先创建所有父对象,,
        if(outputParams != null && outputParams.size() > 0){
            for (ParamObjectVo out : outputParams){
                String type = out.getParamType();
                if(type.equals("String")){fatherObjects.put(out.getParamName(),"");fathersType.put(out.getParamName(),out.getParamType());continue;}
                if(type.equals("int")){fatherObjects.put(out.getParamName(),0);fathersType.put(out.getParamName(),out.getParamType());continue;}
                if(type.equals("Map")){fatherObjects.put(out.getParamName(),new HashMap());fathersType.put(out.getParamName(),out.getParamType());continue;}
                if(type.equals("List<Map>")){fatherObjects.put(out.getParamName(),new ArrayList<Map>());fathersType.put(out.getParamName(),out.getParamType());continue;}
                if(type.equals("List<String>")){fatherObjects.put(out.getParamName(),new ArrayList<String>());fathersType.put(out.getParamName(),out.getParamType());continue;}
                if(type.equals("List<Integer>")){fatherObjects.put(out.getParamName(),new ArrayList<Integer>());fathersType.put(out.getParamName(),out.getParamType());}
            }
        }else{
            return null;
        }
        HashMap tempMap = new HashMap();
        ArrayList<Map> tempMapList = new ArrayList<Map>();
//        ArrayList<String> tempStringList = new ArrayList<String>();
        for (ParamObjectVo out : outputParams){
            String father = CommonUtil.getStr(out.getFatherName(),"");
            if(!father.equals("")){
                String type = fathersType.get(father);
                if(type.equals("Map")){
                    tempMap = (HashMap)fatherObjects.get(father);
                    tempMap.put(out.getParamName(),fatherObjects.get(out.getParamName()));
                    fatherObjects.put(father,tempMap);
                }
                if(type.equals("List<Map>")){
                    tempMapList = (ArrayList<Map>) fatherObjects.get(father);
                    if(tempMapList == null || tempMapList.size() == 0){tempMapList.add(new HashMap());}
                    tempMap = (HashMap) tempMapList.get(0);
                    tempMap.put(out.getParamName(),fatherObjects.get(out.getParamName()));
                    tempMapList.remove(0);
                    tempMapList.add(tempMap);
                    fatherObjects.put(father,tempMapList);
                }
                if(father.equals("data")){
                    data.put(out.getParamName(),fatherObjects.get(out.getParamName()));
                }
                if(father.equals("list")){
                    list = (ArrayList<Map>) fatherObjects.get(father);
                    if(list == null || list.size() == 0){list.add(new HashMap());}
                    tempMap = (HashMap) list.get(0);
                    tempMap.put(out.getParamName(),fatherObjects.get(out.getParamName()));
                    list.remove(0);
                    list.add(tempMap);
                    fatherObjects.put(father,list);
                }
            }
        }
        if(ifPages == 1){
            data.put("list",list);
        }
        System.out.println(data.toString());
        return data;
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
