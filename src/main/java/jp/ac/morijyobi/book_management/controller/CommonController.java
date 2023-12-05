package jp.ac.morijyobi.book_management.controller;

import jp.ac.morijyobi.book_management.bean.form.UserForm;
import jp.ac.morijyobi.book_management.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/common")
public class CommonController {
    private final UserService userService;

    public CommonController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register(Model model) {
        UserForm userForm = new UserForm();
        model.addAttribute("userForm", userForm);

        return "common/register-user";
    }

    @PostMapping("/register-exe")
    public String registerExe(@Validated UserForm userForm,
                              BindingResult bindingResult,
                              Model model,
                              RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "common/register-user";
        }

        userService.registerUser(userForm);

        redirectAttributes.addFlashAttribute("message", "ユーザ登録が完了しました。");

        return "redirect:/login";
    }
}