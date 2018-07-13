package com.shuonai.gm.controller;

import com.github.pagehelper.PageHelper;
import com.shuonai.gm.service.ITestTableService;
import com.shuonai.gm.util.CommonUtil;
import com.shuonai.gm.util.PageBean;
import com.shuonai.gm.util.constant.MessageConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/test")
public class SampleController {

    @Autowired
    private ITestTableService testTableService;

    @RequestMapping(value = "/getAllTestTable")
    public HashMap<String,Object> getAllTestTable(HttpServletRequest request) {
        int status = 0;
        String message = "";
        HashMap<String,Object> data = new HashMap<>();
        try {
            PageHelper.startPage(Integer.parseInt(CommonUtil.getStr(request.getParameter("pageNum"), "1")), Integer.parseInt(CommonUtil.getStr(request.getParameter("pageSize"), "10")));//第几页,,,每页多少条记录
            List<Map> ts = testTableService.getTestTableList();
            PageBean<Map> page = new PageBean<Map>(ts);

            if(page == null){
                return CommonUtil.ToResultHashMap(status, MessageConstant.NOT_FIND_DATA,null);
            }
            status = 1;
            data.put("testTableList",page);
        } catch (Exception e){
            e.printStackTrace();
        }

        return CommonUtil.ToResultHashMap(status,message,data);
    }


    @RequestMapping(value = "/helloWorld")
    public Map helloWorld(HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        int status = 0;
        String message = "";
        resultMap.put("status",status);
        resultMap.put("message","HelloWorld!");
        return resultMap;
    }
}
