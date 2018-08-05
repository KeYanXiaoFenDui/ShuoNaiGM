package com.shuonai.gm.service;

import com.shuonai.gm.domain.TableParam;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface ITableParamService {
    public int insertTableParam(TableParam tableParam);

    public int updateTableParam(TableParam tableParam);

    public int deleteTableParam(int id);

    public TableParam getTableParam(int id);

    public Map<String,List<Map>> getAllTableParam();

    public int getMaxTableId();

    public List<Map> getTableList();

    public List<Map> getParamsByTId(int tableId);
}