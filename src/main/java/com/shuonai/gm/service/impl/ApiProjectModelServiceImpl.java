package com.shuonai.gm.service.impl;

import com.shuonai.gm.domain.ApiProjectModel;
import com.shuonai.gm.mapper.ApiProjectModelMapper;
import com.shuonai.gm.service.IApiProjectModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiProjectModelServiceImpl implements IApiProjectModelService {
    @Autowired
    private ApiProjectModelMapper apiProjectModelMapper;

    @Override
    public int insertApiProjectModel(ApiProjectModel apiProjectModel) {
        return apiProjectModelMapper.insertApiProjectModel(apiProjectModel);
    }

    @Override
    public int updateApiProjectModel(ApiProjectModel apiProjectModel) {
        return apiProjectModelMapper.updateApiProjectModel(apiProjectModel);
    }

    @Override
    public int deleteApiProjectModel(int id) {
        return apiProjectModelMapper.deleteApiProjectModel(id);
    }

    @Override
    public ApiProjectModel getApiProjectModel(int id) {
        return apiProjectModelMapper.getApiProjectModel(id);
    }
}