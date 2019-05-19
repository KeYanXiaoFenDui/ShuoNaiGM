package com.shuonai.gm.mapper;

import com.shuonai.gm.domain.ApiParam;
import com.shuonai.gm.domain.vo.ParamObjectVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ApiParamMapper {

    @Insert("INSERT into api_param (api_id,param_in_out_type,parent_id,param_title,param_name,param_type,if_must,param_comment,create_time,update_time,status) values (#{apiId},#{paramInOutType},#{parentId},#{paramTitle},#{paramName},#{paramType},#{ifMust},#{paramComment},#{createTime},#{updateTime},#{status})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public int insertApiParam(ApiParam apiParam);

    @Update("UPDATE api_param SET api_id=#{apiId},param_in_out_type=#{paramInOutType},parent_id=#{parentId},param_title=#{paramTitle},param_name=#{paramName},param_type=#{paramType},if_must=#{ifMust},param_comment=#{paramComment},create_time=#{createTime},update_time=#{updateTime},status=#{status} where id=#{id}")
    public int updateApiParam(ApiParam apiParam);

    @Delete("delete from api_param where id=#{id}")
    public int deleteApiParam(int id);

    @Select("select * from api_param where id=#{id}")
    public ApiParam getApiParam(int id);

    @Select("select param_title,param_name,param_type,if_must,param_comment from api_param where api_id = #{apiId} and param_in_out_type = 1")
    public List<ParamObjectVo> getApiParamIn(int apiId);

}