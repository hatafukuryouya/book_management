package jp.ac.morijyobi.book_management.service;

import jp.ac.morijyobi.book_management.bean.entity.User;
import jp.ac.morijyobi.book_management.bean.form.UserForm;

public interface UserService {
    User registerUser(UserForm userForm);
}