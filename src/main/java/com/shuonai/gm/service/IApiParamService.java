package com.shuonai.gm.service;

import com.shuonai.gm.domain.ApiParam;
import com.shuonai.gm.domain.vo.ParamObjectVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IApiParamService {
    public int insertApiParam(ApiParam apiParam);

    public int updateApiParam(ApiParam apiParam);

    public int deleteApiParam(int id);

    public ApiParam getApiParam(int id);

    public List<ParamObjectVo> getApiParamIn(int apiId);
}