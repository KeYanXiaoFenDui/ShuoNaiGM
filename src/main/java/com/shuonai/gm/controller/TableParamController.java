package com.shuonai.gm.controller;

import com.shuonai.gm.domain.TableParam;
import com.shuonai.gm.service.ITableParamService;
import com.shuonai.gm.util.ShangXianUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dekit on 2017/12/24.
 */
@Controller
@RequestMapping("/tableParam")
public class TableParamController {


    @Autowired
    private ITableParamService tableParamService;

    @ResponseBody
    @RequestMapping(value = "/createTableParam")
    public Map getUserMsgAction(HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        int status = 0;
        String message = "";
        Map<String,Object> object = ShangXianUtil.getTableMsg("C:/Users/冼世龙/Desktop/ssss.txt");
        String tableName = (String)object.get("tableName");
        String domainName = (String)object.get("domainName");
        String tableNameCN = (String)object.get("tableNameCN");
        int tableId = tableParamService.getMaxTableId();
        List<Map> params = (List<Map>)object.get("params");
        for (Map m : params) {
            TableParam tp = new TableParam();
            tp.setTableId(tableId);
            tp.setTableNameCn(tableNameCN);
            tp.setTableName(getStr(tableName, ""));
            tp.setUpClassName(getStr(ShangXianUtil.toUpperCaseFirstOne(domainName),""));
            tp.setLowClassName(getStr(domainName,""));
            tp.setDbParamName(getStr(m.get("sqlParam"), ""));
            tp.setDbParamType(getStr(m.get("sqlType"), ""));
            tp.setComment(getStr(m.get("comment"), ""));
            tp.setUpCaseParam(getStr(ShangXianUtil.toUpperCaseFirstOne(getStr(m.get("domainParam"), "")), ""));
            tp.setLowCaseParam(getStr(m.get("domainParam"), ""));
            tp.setParamType(getStr(m.get("domainType"), ""));
            tp.setIfMainKey(Integer.parseInt(getStr("", "0")));
            tp.setIfRelated(Integer.parseInt(getStr("", "0")));
            tp.setStatus(Integer.parseInt(getStr("1", "0")));
            tableParamService.insertTableParam(tp);
        }
        resultMap.put("msg","共生产"+params.size()+"个表参数数据");
        return resultMap;
    }

    @RequestMapping(value = "/getAllTableParam")
    public String getAllTableParam(Model m, HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        int status = 0;
        String message = "";
        Map<String,List<Map>> tp = new HashMap<>();
        tp = tableParamService.getAllTableParam();
        resultMap.put("data",tp);
        m.addAttribute("articles",tp);

        return  "tableParam/tableParam";
    }

    /**
     * 获取表列表
     * @param m
     * @param request
     * @return
     */
    @RequestMapping(value = "/getTableList")
    public String getTableList(Model m, HttpServletRequest request) {
        int status = 0;
        String message = "";
        List<Map> tableList = tableParamService.getTableList();
        m.addAttribute("tableList",tableList);
        return  "tableParam/tableList";
    }

    /**
     * 获取表详情
     * @param m
     * @param request
     * @return
     */
    @RequestMapping(value = "/getTableDetail")
    public String getTableDetail(Model m, HttpServletRequest request) {
        int status = 0;
        String message = "";
        int tableId = Integer.parseInt(getStr(request.getParameter("tableId"),"0"));
        List<Map> tableDetail = new ArrayList<>();
        if(tableId != 0){
            tableDetail = tableParamService.getParamsByTId(tableId);
        }
        m.addAttribute("tableDetail",tableDetail);
        return  "tableParam/tableDetail";
    }

    private Map requestToMap(HttpServletRequest request, String[] paramNames) {
        Map paramMap = new HashMap();
        int num = 0;
        if (paramNames != null && paramNames.length > 0) {
            for (int i = 0; i < paramNames.length; i++) {
                String paramName = paramNames[i];
                String[] paramValue = request.getParameterValues(paramName);
                if (paramValue != null && paramValue.length > 1) {
                    paramMap.put(paramName, paramValue);
                }else if (paramValue != null && paramValue.length == 1) {
                    String value = paramValue[0];
                    if (isEmptyStr(paramValue[0])) value = "";
                    paramMap.put(paramName, value.trim());
                } else {
                    paramMap.put(paramName, null);
                    num++;
                }
            }
        } else {
            //System.out.println("传入的参数数组为null或长度为0");
        }
        paramMap.put("nullParam",num);
        return paramMap;
    }
    private boolean isEmptyStr(String str) {
        String[] options = new String[]{"null"};
        if (str == null) return true;
        String target = str.trim();
        if (target.equals("")) return true;
        for (int i = 0; i < options.length; i++)
            if (target.equals(options[i])) return true;
        return false;
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
    private String getStr(Object str, String edefaultStrfaultStr){
        if(str==null || str.toString().trim().equals("")){
            return edefaultStrfaultStr;
        }
        return str.toString().trim();
    }
}