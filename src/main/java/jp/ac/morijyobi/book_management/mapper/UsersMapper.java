package jp.ac.morijyobi.book_management.mapper;

import jp.ac.morijyobi.book_management.bean.dto.LoginUserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UsersMapper {
    @Select("SELECT u.id, u.username, u.password, u.name, a.authority " +
            "FROM users AS u " +
            "INNER JOIN authorities AS a ON a.id = u.authority_id " +
            "WHERE u.username = #{username}")
    LoginUserDto selectUserByUsername(String username);
}
