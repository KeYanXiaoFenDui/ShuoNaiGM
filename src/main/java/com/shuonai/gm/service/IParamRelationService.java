package com.shuonai.gm.service;

import com.shuonai.gm.domain.ParamRelation;
import org.springframework.stereotype.Service;

@Service
public interface IParamRelationService {
    public int insertParamRelation(ParamRelation paramRelation);

    public int updateParamRelation(ParamRelation paramRelation);

    public int deleteParamRelation(int id);

    public ParamRelation getParamRelation(int id);
}