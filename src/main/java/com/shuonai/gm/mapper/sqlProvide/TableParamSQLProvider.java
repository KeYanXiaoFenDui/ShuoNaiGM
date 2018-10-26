package com.shuonai.gm.mapper.sqlProvide;

/**
 * Created by Administrator on 2017/11/2.
 * @author max_feng
 */
public class TableParamSQLProvider {
    public String getTableListByNames(String tables){
        StringBuffer sql = new StringBuffer();
        sql.append("select tt.id as tableId,tt.table_name_cn as tableNameCN,tt.table_name as tableName from param_relation pr,table_table tt where (pr.table_a = tt.table_name or pr.table_b = tt.table_name) and pr.table_a in (");
        sql.append(tables);
        sql.append(") group by tt.id");
        return sql.toString();
    }
}
