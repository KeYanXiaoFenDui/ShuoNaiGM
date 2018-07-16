package com.shuonai.gm.mapper;

import com.shuonai.gm.domain.TestTable;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Mapper
public interface TestTableMapper {

    @Insert("INSERT into test_table (name,account,password,create_time,status) values (#{name},#{account},#{password},#{createTime},#{status})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public int insertTestTable(TestTable testTable);

    @Update("UPDATE test_table SET name=#{name},account=#{account},password=#{password},create_time=#{createTime},status=#{status} where id=#{id}")
    public int updateTestTable(TestTable testTable);

    @Delete("delete from test_table where id=#{id}")
    public int deleteTestTable(int id);

    @Select("select * from test_table where id=#{id}")
    public TestTable getTestTable(int id);

    @Select("select * from test_table")
    public List<Map> getTestTableList();
}