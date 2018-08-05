package com.shuonai.gm.service.impl;

import com.shuonai.gm.domain.ParamRelation;
import com.shuonai.gm.mapper.ParamRelationMapper;
import com.shuonai.gm.service.IParamRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParamRelationServiceImpl implements IParamRelationService {
    @Autowired
    private ParamRelationMapper paramRelationMapper;

    @Override
    public int insertParamRelation(ParamRelation paramRelation) {
        return paramRelationMapper.insertParamRelation(paramRelation);
    }

    @Override
    public int updateParamRelation(ParamRelation paramRelation) {
        return paramRelationMapper.updateParamRelation(paramRelation);
    }

    @Override
    public int deleteParamRelation(int id) {
        return paramRelationMapper.deleteParamRelation(id);
    }

    @Override
    public ParamRelation getParamRelation(int id) {
        return paramRelationMapper.getParamRelation(id);
    }
}