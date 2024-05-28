package org.abbtech.practice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Validated
public class BookController {

    @GetMapping()
    public String getBooksDetails(@RequestParam(value = "orderId", required = false) String orderId) {
        System.out.println("get book details for "+ orderId);
        return "book send success";
    }
}
