package com.shuonai.gm.service.impl;

import com.shuonai.gm.domain.ApiParam;
import com.shuonai.gm.domain.vo.ParamObjectVo;
import com.shuonai.gm.mapper.ApiParamMapper;
import com.shuonai.gm.service.IApiParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiParamServiceImpl implements IApiParamService {
    @Autowired
    private ApiParamMapper apiParamMapper;

    @Override
    public int insertApiParam(ApiParam apiParam) {
        return apiParamMapper.insertApiParam(apiParam);
    }

    @Override
    public int updateApiParam(ApiParam apiParam) {
        return apiParamMapper.updateApiParam(apiParam);
    }

    @Override
    public int deleteApiParam(int id) {
        return apiParamMapper.deleteApiParam(id);
    }

    @Override
    public ApiParam getApiParam(int id) {
        return apiParamMapper.getApiParam(id);
    }

    @Override
    public List<ParamObjectVo> getApiParamIn(int apiId) {
        return apiParamMapper.getApiParamIn(apiId);
    }
}