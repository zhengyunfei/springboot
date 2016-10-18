package demo.service;

/**
 * Created by Administrator on 2016/10/11.
 */

import demo.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
/**
 * Created by Administrator on 2016/9/2.
 */
@Mapper
public interface UserMapper {
    @Select("select * from users where username = #{name} and enabled=#{enabled}")
    User findUserByName(@Param("name")String name,@Param("enabled")String enabled);
    @Insert("insert into users(username,enabled,password) values(#{name},#{enabled},1)")
    boolean create(@Param("name")String name,@Param("enabled")String enabled);

}
