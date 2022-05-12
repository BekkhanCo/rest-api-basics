package com.epam.esm.service.gift_certificate;

import dto.BaseResponseDto;
import dto.GiftCertificateDto;
import org.springframework.stereotype.Service;
import com.epam.esm.service.BaseService;

import java.util.List;
import java.util.UUID;

@Service
public interface GiftCertificateService extends BaseService<GiftCertificateDto> {

    BaseResponseDto<List<GiftCertificateDto>> getAll(
            String searchWord, String tagName, boolean doNameSort, boolean doDateSort, boolean isDescending
    );

    BaseResponseDto update(GiftCertificateDto update, UUID certificateId);

//    BaseResponseDto<List<GiftCertificateDto>> getByTagName(String tagName);
//
//    BaseResponseDto<List<GiftCertificateDto>> searchByDescriptionOrName(String keyWord);
//
//    BaseResponseDto<List<GiftCertificateDto>> sortByName();
//
//    BaseResponseDto<List<GiftCertificateDto>> sortByDate();
}
