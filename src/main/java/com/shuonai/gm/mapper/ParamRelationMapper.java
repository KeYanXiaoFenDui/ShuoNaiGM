package com.shuonai.gm.mapper;

import com.shuonai.gm.domain.ParamRelation;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ParamRelationMapper {

    @Insert("INSERT into param_relation (table_a,a_id,param_a,table_b,b_id,param_b,a_to_b,status) values (#{tableA},#{aId},#{paramA},#{tableB},#{bId},#{paramB},#{aToB},#{status})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public int insertParamRelation(ParamRelation paramRelation);

    @Update("UPDATE param_relation SET table_a=#{tableA},a_id=#{aId},param_a=#{paramA},table_b=#{tableB},b_id=#{bId},param_b=#{paramB},a_to_b=#{aToB},status=#{status} where id=#{id}")
    public int updateParamRelation(ParamRelation paramRelation);

    @Delete("delete from param_relation where id=#{id}")
    public int deleteParamRelation(int id);

    @Select("select * from param_relation where id=#{id}")
    public ParamRelation getParamRelation(int id);

    @Select("select * from param_relation pr where pr.table_a = #{tableA} and pr.table_b = #{tableB}")
    public ParamRelation getTableRelation(@Param("tableA") String tableA,@Param("tableB") String tableB);

}