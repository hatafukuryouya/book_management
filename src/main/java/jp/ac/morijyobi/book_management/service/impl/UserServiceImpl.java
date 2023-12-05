package jp.ac.morijyobi.book_management.service.impl;

import jp.ac.morijyobi.book_management.bean.entity.User;
import jp.ac.morijyobi.book_management.bean.form.UserForm;
import jp.ac.morijyobi.book_management.constants.AccountRoleConstants;
import jp.ac.morijyobi.book_management.mapper.UsersMapper;
import jp.ac.morijyobi.book_management.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UsersMapper usersMapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UsersMapper usersMapper, PasswordEncoder passwordEncoder) {
        this.usersMapper = usersMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User registerUser(UserForm userForm) {
        User user = new User();
        user.setUsername(userForm.getUsername());
        String hashedPassword = passwordEncoder.encode(userForm.getPassword());
        user.setPassword(hashedPassword);
        user.setName(userForm.getName());
        user.setAuthorityId(AccountRoleConstants.GENERAL);

        usersMapper.insertUser(user);

        return user;
    }
}