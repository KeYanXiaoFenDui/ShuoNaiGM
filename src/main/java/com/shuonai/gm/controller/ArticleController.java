package com.shuonai.gm.controller;

import com.github.pagehelper.PageHelper;
import com.shuonai.gm.domain.AdminArticle;
import com.shuonai.gm.service.IAdminArticleService;
import com.shuonai.gm.util.CommonUtil;
import com.shuonai.gm.util.PageBean;
import com.shuonai.gm.util.constant.MessageConstant;
import com.sun.istack.internal.Nullable;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private IAdminArticleService adminArticleService;

    @RequestMapping("/list")
    public String list(Model m, HttpServletRequest request,@Nullable Integer catalogId) {
        PageHelper.startPage(Integer.parseInt(CommonUtil.getStr(request.getParameter("pageNum"), "1")), Integer.parseInt(CommonUtil.getStr(request.getParameter("pageSize"), "10")));//第几页,,,每页多少条记录
        if(catalogId==null){
            catalogId = 0;
        }
        List<AdminArticle> articleList = adminArticleService.queryArticleByCatalogId(catalogId);

        m.addAttribute("articles",articleList);

        return  "admin/article/article_list";
    }

    @RequestMapping("/search")
    @ResponseBody
    public HashMap<String,Object> search(HttpServletRequest request, @NotBlank String searchStr){
        int status = -1;
        String message = "";
        HashMap<String,Object> data = new HashMap<>();
        try {
            PageHelper.startPage(Integer.parseInt(CommonUtil.getStr(request.getParameter("pageNum"), "1")), Integer.parseInt(CommonUtil.getStr(request.getParameter("pageSize"), "10")));//第几页,,,每页多少条记录
            List<AdminArticle> ts = adminArticleService.queryArticleLikeTitle(searchStr);

            if(ts == null){
                return CommonUtil.ToResultHashMap(status, MessageConstant.NOT_FIND_DATA,null);
            }
            PageBean<AdminArticle> page = new PageBean<AdminArticle>(ts);
            status = 0;
            data.put("result",page);
        } catch (Exception e){
            e.printStackTrace();
        }

        return CommonUtil.ToResultHashMap(status,message,data);
    }

}
