package com.shuonai.gm.service;

import com.shuonai.gm.domain.TestTable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface ITestTableService {
    public int insertTestTable(TestTable testTable);

    public int updateTestTable(TestTable testTable);

    public int deleteTestTable(int id);

    public TestTable getTestTable(int id);

    public List<Map> getTestTableList();
}