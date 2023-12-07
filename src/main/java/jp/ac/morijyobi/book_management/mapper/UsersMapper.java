package jp.ac.morijyobi.book_management.mapper;

import jp.ac.morijyobi.book_management.bean.dto.LoginUserDto;
import jp.ac.morijyobi.book_management.bean.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UsersMapper {

    @Select("SELECT u.id, u.username, u.password, u.name, a.authority " +
            "FROM bookusers AS u " +
            "INNER JOIN authorities AS a ON a.id = u.authority_id " +
            "WHERE u.username = #{username}")
    LoginUserDto selectUserByUsername(String username);

    @Insert("INSERT INTO bookusers VALUES (default, #{username}, #{password}," +
            " #{name}, #{authorityId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertUser(User user);
}