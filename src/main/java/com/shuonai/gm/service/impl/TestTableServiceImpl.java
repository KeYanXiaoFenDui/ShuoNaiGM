package com.shuonai.gm.service.impl;

import com.shuonai.gm.domain.TestTable;
import com.shuonai.gm.mapper.TestTableMapper;
import com.shuonai.gm.service.ITestTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TestTableServiceImpl implements ITestTableService {
    @Autowired
    private TestTableMapper testTableMapper;

    @Override
    public int insertTestTable(TestTable testTable) {
        return testTableMapper.insertTestTable(testTable);
    }

    @Override
    public int updateTestTable(TestTable testTable) {
        return testTableMapper.updateTestTable(testTable);
    }

    @Override
    public int deleteTestTable(int id) {
        return testTableMapper.deleteTestTable(id);
    }

    @Override
    public TestTable getTestTable(int id) {
        return testTableMapper.getTestTable(id);
    }

    @Override
    public List<Map> getTestTableList() {
        return testTableMapper.getTestTableList();
    }
}