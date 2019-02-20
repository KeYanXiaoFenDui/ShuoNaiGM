package com.shuonai.gm.mapper;

import com.shuonai.gm.domain.ApiProjectModel;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ApiProjectModelMapper {

    @Insert("INSERT into api_project_model (project_name,project_title,model_name,model_title,create_time,status) values (#{projectName},#{projectTitle},#{modelName},#{modelTitle},#{createTime},#{status})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public int insertApiProjectModel(ApiProjectModel apiProjectModel);

    @Update("UPDATE api_project_model SET project_name=#{projectName},project_title=#{projectTitle},model_name=#{modelName},model_title=#{modelTitle},create_time=#{createTime},status=#{status} where id=#{id}")
    public int updateApiProjectModel(ApiProjectModel apiProjectModel);

    @Delete("delete from api_project_model where id=#{id}")
    public int deleteApiProjectModel(int id);

    @Select("select * from api_project_model where id=#{id}")
    public ApiProjectModel getApiProjectModel(int id);

}