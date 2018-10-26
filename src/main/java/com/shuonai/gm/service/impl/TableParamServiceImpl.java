package com.shuonai.gm.service.impl;

import com.shuonai.gm.domain.TableParam;
import com.shuonai.gm.mapper.TableParamMapper;
import com.shuonai.gm.service.ITableParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TableParamServiceImpl implements ITableParamService {
    @Autowired
    private TableParamMapper tableParamMapper;

    @Override
    public int insertTableParam(TableParam tableParam) {
        return tableParamMapper.insertTableParam(tableParam);
    }

    @Override
    public int updateTableParam(TableParam tableParam) {
        return tableParamMapper.updateTableParam(tableParam);
    }

    @Override
    public int deleteTableParam(int id) {
        return tableParamMapper.deleteTableParam(id);
    }

    @Override
    public TableParam getTableParam(int id) {
        return tableParamMapper.getTableParam(id);
    }

    @Override
    public Map<String,List<Map>> getAllTableParam() {
        Map<String,List<Map>> allTableParam = new HashMap();
        List<String> tn = tableParamMapper.getTableNameList();
        for (String tableName : tn){
            List<Map> tp = tableParamMapper.getParamsByTN(tableName);
            allTableParam.put(tableName,tp);
        }
        return allTableParam;
    }

    @Override
    public int getMaxTableId() {
        return tableParamMapper.getMaxTableId();
    }

    @Override
    public List<Map> getTableList() {
        return tableParamMapper.getTableList();
    }

    @Override
    public List<Map> getTableListByNames(String tables) {
        return tableParamMapper.getTableListByNames(tables);
    }

    @Override
    public List<Map> getParamsByTId(int tableId) {
        return tableParamMapper.getParamsByTId(tableId);
    }
}