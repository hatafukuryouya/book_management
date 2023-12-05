package jp.ac.morijyobi.book_management.service;

import jp.ac.morijyobi.book_management.bean.entity.Tag;
import jp.ac.morijyobi.book_management.bean.form.TagForm;

import java.util.List;


public interface TagService {

    Tag registerTag(TagForm tagForm);

    List<Tag> getAllTags();
}