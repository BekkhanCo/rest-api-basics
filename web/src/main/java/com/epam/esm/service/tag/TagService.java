package com.epam.esm.service.tag;

import domain.tag.Tag;
import dto.BaseResponseDto;
import com.epam.esm.service.BaseService;

import java.util.List;

public interface TagService extends BaseService<Tag> {
    BaseResponseDto<List<Tag>> getAll();

}
