package jp.ac.morijyobi.book_management.mapper;

import jp.ac.morijyobi.book_management.bean.entity.BookLoan;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookLoansMapper {

    @Insert("INSERT INTO book_loans VALUES(default, #{bookId}, #{userId}, CURRENT_TIMESTAMP, NULL)")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertBookLoan(BookLoan bookLoan);

    @Select("SELECT COUNT(*) = 0 FROM book_loans WHERE book_id = #{bookId} AND return_date IS NULL")
    boolean isBookAvailable(int bookId);
}