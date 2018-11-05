package com.shuonai.gm.controller;

import com.github.pagehelper.PageHelper;
import com.shuonai.gm.util.CommonUtil;
import com.shuonai.gm.util.PageBean;
import com.shuonai.gm.util.constant.MessageConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Admininstrator on 2018/11/5.
 */
@RestController
@RequestMapping("/templet")
public class TempletController {
    private static Logger logger = LoggerFactory.getLogger(TempletController.class);

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
}
