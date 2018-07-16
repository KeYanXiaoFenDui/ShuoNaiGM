package com.shuonai.gm.mapper;

import com.shuonai.gm.domain.AdminCatalog;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface AdminCatalogMapper {

    @Insert("INSERT into admin_catalog (catalog_pid,catalog_code,catalog_name,catalog_poster,catalog_summary,state,createtime,updatetime) values (#{catalogPid},#{catalogCode},#{catalogName},#{catalogPoster},#{catalogSummary},#{state},#{createtime},#{updatetime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public int insertAdminCatalog(AdminCatalog adminCatalog);

    @Update("UPDATE admin_catalog SET catalog_pid=#{catalogPid},catalog_code=#{catalogCode},catalog_name=#{catalogName},catalog_poster=#{catalogPoster},catalog_summary=#{catalogSummary},state=#{state},createtime=#{createtime},updatetime=#{updatetime} where id=#{id}")
    public int updateAdminCatalog(AdminCatalog adminCatalog);

    @Delete("delete from admin_catalog where id=#{id}")
    public int deleteAdminCatalog(int id);

    @Select("select * from admin_catalog where id=#{id}")
    public AdminCatalog getAdminCatalog(int id);

}