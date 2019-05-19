package com.shuonai.gm.mapper;

import com.shuonai.gm.domain.Api;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ApiMapper {

    @Insert("INSERT into api (api_name,base_path,api_method,api_comment,request_method,data_operation,if_rollback,if_pages,create_time,update_time,status) values (#{apiName},#{basePath},#{apiMethod},#{apiComment},#{requestMethod},#{dataOperation},#{ifRollback},#{ifPages},#{createTime},#{updateTime},#{status})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public int insertApi(Api api);

    @Update("UPDATE api SET api_name=#{apiName},base_path=#{basePath},api_method=#{apiMethod},api_comment=#{apiComment},request_method=#{requestMethod},data_operation=#{dataOperation},if_rollback=#{ifRollback},if_pages=#{ifPages},create_time=#{createTime},update_time=#{updateTime},status=#{status} where id=#{id}")
    public int updateApi(Api api);

    @Delete("delete from api where id=#{id}")
    public int deleteApi(int id);

    @Select("select * from api where id=#{id}")
    public Api getApi(int id);

    @Select("select seq from seq where id = 1")
    public int getSeq();

    @Update("update seq set seq = #{row}")
    public int updateSeq(int row);

    @Select("select * from api where id > 53")
    public List<Api> getApiList();

}