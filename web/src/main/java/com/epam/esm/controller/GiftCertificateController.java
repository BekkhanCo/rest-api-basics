package com.epam.esm.controller;

import dto.GiftCertificateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.epam.esm.service.gift_certificate.GiftCertificateService;

import java.util.UUID;

@RestController
@RequestMapping("/api/gift_certificate")
public class GiftCertificateController {


    private GiftCertificateService giftCertificateService;

    @Autowired
    @Qualifier(value = "giftCertificateService")
    public void setGiftCertificateService(GiftCertificateService giftCertificateService) {
        this.giftCertificateService = giftCertificateService;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<?> create(
            @RequestBody GiftCertificateDto giftCertificate
            ){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(giftCertificateService.create(giftCertificate));
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> get(
            @RequestParam UUID id
    ){
        return ResponseEntity.ok(giftCertificateService.get(id));
    }

    @RequestMapping(value = "/get/all", method = RequestMethod.GET)
    public ResponseEntity<?> getAll(
            @RequestParam(required = false) String searchWord,
            @RequestParam(required = false) String tagName,
            @RequestParam(required = false) boolean doNameSort,
            @RequestParam(required = false) boolean doDateSort,
            @RequestParam(required = false) boolean isDescending
    ){
        return ResponseEntity.ok(giftCertificateService.getAll(
               searchWord, tagName, doNameSort, doDateSort, isDescending
            ));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(
            @RequestParam UUID id
    ){
        return ResponseEntity.ok(giftCertificateService.delete(id));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public ResponseEntity<?> update(
            @RequestBody GiftCertificateDto update,
            @RequestParam UUID id
    ){
        return ResponseEntity.ok(giftCertificateService.update(update, id));
    }

}
