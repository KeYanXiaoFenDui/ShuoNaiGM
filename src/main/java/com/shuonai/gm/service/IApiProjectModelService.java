package com.shuonai.gm.service;

import com.shuonai.gm.domain.ApiProjectModel;
import org.springframework.stereotype.Service;

@Service
public interface IApiProjectModelService {
    public int insertApiProjectModel(ApiProjectModel apiProjectModel);

    public int updateApiProjectModel(ApiProjectModel apiProjectModel);

    public int deleteApiProjectModel(int id);

    public ApiProjectModel getApiProjectModel(int id);
}