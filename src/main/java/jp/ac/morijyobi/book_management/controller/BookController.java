package jp.ac.morijyobi.book_management.controller;

import jp.ac.morijyobi.book_management.bean.entity.Book;
import jp.ac.morijyobi.book_management.bean.entity.Tag;
import jp.ac.morijyobi.book_management.bean.form.BookForm;
import jp.ac.morijyobi.book_management.service.BookService;
import jp.ac.morijyobi.book_management.service.TagService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    private final TagService tagService;
    private final BookService bookService;

    public BookController(TagService tagService, BookService bookService) {
        this.tagService = tagService;
        this.bookService = bookService;
    }

    @GetMapping("/register")
    public String registerBook(Model model) {

        BookForm bookForm = new BookForm();
        model.addAttribute("bookForm", bookForm);

        List<Tag> tagList = tagService.getAllTags();
        model.addAttribute("tagList", tagList);

        return "book/register-book";
    }

    @PostMapping("/register")
    public String registerExe(@Validated BookForm bookForm,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes,
                              Model model) {
        if (bindingResult.hasErrors()) {
            List<Tag> tagList = tagService.getAllTags();
            model.addAttribute("tagList", tagList);

            return "book/register-book";
        }

        bookService.registerBook(bookForm);
        redirectAttributes.addFlashAttribute("message", "登録が完了しました。");

        return "redirect:/book/register";
    }

    @GetMapping("/list")
    public String bookList(@RequestParam(defaultValue = "") String keyword,
                           Model model) {
        List<Book> bookList = bookService.getBooksByKeyword(keyword);
        model.addAttribute("bookList", bookList);

        return "book/book-list";
    }

    @GetMapping("/loan")
    public String bookLoan(@RequestParam int bookId,
                           Model model) {
        Book book = bookService.getBookById(bookId);
        model.addAttribute("book", book);

        return "book/book-loan";
    }

    @PostMapping("/loan")
    public String bookLoanExe(@RequestParam int id,
                              @AuthenticationPrincipal UserDetails userDetails,
                              RedirectAttributes redirectAttributes,
                              Model model) {

        if (bookService.registerBookLoan(id, userDetails.getUsername())) {
            redirectAttributes.addFlashAttribute("message", "貸出が完了しました。");
        } else {
            redirectAttributes.addFlashAttribute("warning", "貸出に失敗しました。");
        }
        return "redirect:/book/list";
    }


}