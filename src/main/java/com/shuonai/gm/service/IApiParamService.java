package com.shuonai.gm.service;

import com.shuonai.gm.domain.ApiParam;
import org.springframework.stereotype.Service;

@Service
public interface IApiParamService {
    public int insertApiParam(ApiParam apiParam);

    public int updateApiParam(ApiParam apiParam);

    public int deleteApiParam(int id);

    public ApiParam getApiParam(int id);
}