package com.epam.esm.service.tag;

import DAO.tag.TagDAO;
import domain.tag.Tag;
import dto.BaseResponseDto;
import exception.NoDataFoundException;
import exception.UnknownDataBaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TagServiceImpl implements TagService{

    private final TagDAO tagDAO;

    @Autowired
    public TagServiceImpl(TagDAO tagDAO) {
        this.tagDAO = tagDAO;
    }

    @Override
    public BaseResponseDto<Tag> create(Tag tag) {
        tag.setId(UUID.randomUUID());
        tag = tagDAO.save(tag);

        if(tag != null )
            return new BaseResponseDto<>(200, "tag created", tag);
        throw new UnknownDataBaseException("Unknown problem occurred in the database");
    }

    @Override
    public BaseResponseDto<Tag> get(UUID tagId) {
        Tag tag = tagDAO.get(tagId);
        return new BaseResponseDto<>(200, "success", tag);
    }

    @Override
    public BaseResponseDto<List<Tag>> getAll() {
        return new BaseResponseDto<>(200, "list of tags", tagDAO.getAll());
    }

    @Override
    public BaseResponseDto delete(UUID tagId) {
        int delete = tagDAO.remove(tagId);
        if(delete == 1)
            return new BaseResponseDto(204, "certificate deleted");
        throw new NoDataFoundException("there is no tag with id: " + tagId + " to delete");
    }
}
