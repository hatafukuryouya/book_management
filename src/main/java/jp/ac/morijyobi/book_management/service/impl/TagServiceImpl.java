package jp.ac.morijyobi.book_management.service.impl;

import jp.ac.morijyobi.book_management.bean.entity.Tag;
import jp.ac.morijyobi.book_management.bean.form.TagForm;
import jp.ac.morijyobi.book_management.mapper.TagsMapper;
import jp.ac.morijyobi.book_management.service.TagService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    private final TagsMapper tagsMapper;

    public TagServiceImpl(TagsMapper tagsMapper) {
        this.tagsMapper = tagsMapper;
    }

    @Override
    public Tag registerTag(TagForm tagForm) {
        Tag tag = new Tag();
        tag.setTagName(tagForm.getTagName());

        tagsMapper.insertTag(tag);

        return null;
    }
    @Override
    public List<Tag> getAllTags(){
        return tagsMapper.selectAllTags();
    }
}