package com.shuonai.gm.controller;

import com.github.pagehelper.PageHelper;
import com.shuonai.gm.service.ITestTableService;
import com.shuonai.gm.util.CommonUtil;
import com.shuonai.gm.util.PageBean;
import com.shuonai.gm.util.constant.MessageConstant;
import com.shuonai.gm.util.myGame;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//@Controller
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

    //我就皮那么一下.
    @RequestMapping(value = "/helloWorld")
    public Map<String, Object> helloWorld(HttpServletRequest request, Model m) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        int status = 0;
        String message = "";
        resultMap.put("status",status);
        resultMap.put("message","HelloWorld!");

        String strX = "2,4/4,6/7,1/1,9/2,6,2/1,6/2,6,3/1,5/3,5,2/1,1,10/1,2,7,2/15,2/11/15,3/1,2,1,2,1/1,2,4/3,2/1,3/2,1/1,3";
        String strY = "2,1,1,1,1,1,1/5,1,1,4/4,4/1,1/3/7/6/3/1,3/2,4/3,8/13/12/12/15/6,2,1/6,1,2,1/2,1,1,2,3,1,1/2,2,1,4,1,2,1/5,1,2,1,2,1,2";
        char[][] result = myGame.mainMethod(20,myGame.dynamicArr(strX),myGame.dynamicArr(strY));
//        m.addAttribute("result",result);
        resultMap.put("result",result);
        return resultMap;

//        return resultMap;
    }
}
