package com.shuonai.gm.mapper;

import com.shuonai.gm.domain.TableParam;
import com.shuonai.gm.mapper.sqlProvide.TableParamSQLProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface TableParamMapper {

    @Insert("INSERT into table_param (table_id,table_name_cn,table_name,up_class_name,low_class_name,db_param_name,db_param_type,comment,up_case_param,low_case_param,param_type,if_main_key,if_related,status) values (#{tableId},#{tableNameCn},#{tableName},#{upClassName},#{lowClassName},#{dbParamName},#{dbParamType},#{comment},#{upCaseParam},#{lowCaseParam},#{paramType},#{ifMainKey},#{ifRelated},#{status})")
    @Options(useGeneratedKeys=true,keyProperty="id")
    public int insertTableParam(TableParam tableParam);

    @Update("UPDATE table_param SET table_id=#{tableId},table_name_cn=#{tableNameCn},table_name=#{tableName},up_class_name=#{upClassName},low_class_name=#{lowClassName},db_param_name=#{dbParamName},db_param_type=#{dbParamType},comment=#{comment},up_case_param=#{upCaseParam},low_case_param=#{lowCaseParam},param_type=#{paramType},if_main_key=#{ifMainKey},if_related=#{ifRelated},status=#{status} where id=#{id}")
    public int updateTableParam(TableParam tableParam);

    @Delete("delete from table_param where id=#{id}")
    public int deleteTableParam(int id);

    @Select("select * from table_param where id=#{id}")
    public TableParam getTableParam(int id);

    @Select("select DISTINCT(table_name) as tableName from table_param t")
    public List<String> getTableNameList();

    @Select("select * from table_param t where t.table_name = #{tableName}")
    public List<Map> getParamsByTN(String tableName);

    @Select("select case when max(table_id) is null then 1 else max(table_id)+1 end as maxTableId from table_param")
    public int getMaxTableId();

    @SelectProvider(type = TableParamSQLProvider.class,method = "getTableListByNames")
    public List<Map> getTableListByNames(String tables);

    @Select("select tt.id as tableId,tt.table_name_cn as tableNameCN,tt.table_name as tableName from table_table tt")
    public List<Map> getTableList();

    @Select("select * from table_param t where t.table_id = #{tableId}")
    public List<Map> getParamsByTId(int tableId);

}