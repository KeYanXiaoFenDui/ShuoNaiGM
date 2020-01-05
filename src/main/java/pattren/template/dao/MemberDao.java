package pattren.template.dao;

import org.apache.http.annotation.Obsolete;
import pattren.template.JdbcTemplate;
import pattren.template.entity.Member;
import pattren.template.entity.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

/**
 * 解耦
 */
public class MemberDao{

    private JdbcTemplate JdbcTemplate = new JdbcTemplate(null);

    public List<?> query(){
        String sql = "select * from t_member";
        return JdbcTemplate.executeQuery(sql, new RowMapper<Object>() {
            @Override
            public Member mapRow(ResultSet rs,int rowNum)throws Exception{
                Member member = new Member();
                member.setUsername(rs.getString("username"));
                member.setPassword(rs.getString("password"));
                member.setAge(rs.getInt("age"));
                member.setAddr(rs.getString("addr"));
                return member;
            }
        },null);
    }

}
