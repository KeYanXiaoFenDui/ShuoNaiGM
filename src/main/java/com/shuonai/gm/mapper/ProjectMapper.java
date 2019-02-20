package com.shuonai.gm.mapper;

import com.shuonai.gm.domain.Project;
import com.shuonai.gm.domain.TableParam;
import com.shuonai.gm.mapper.sqlProvide.TableParamSQLProvider;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ProjectMapper {

    @Insert("INSERT into project (project_name,project_title,create_time,status) values (#{projectName},#{projectTitle},#{createTime},#{status})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public int insertProject(Project project);

    @Update("UPDATE project SET project_name=#{projectName},project_title=#{projectTitle},create_time=#{createTime},status=#{status} where id=#{id}")
    public int updateProject(Project project);

    @Delete("delete from project where id=#{id}")
    public int deleteProject(int id);

    @Select("select * from project where id=#{id}")
    public Project getProject(int id);

}