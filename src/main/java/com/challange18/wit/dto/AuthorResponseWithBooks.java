package com.challange18.wit.dto;

import java.util.List;

public record AuthorResponseWithBooks(List<BookResponse> bookResponseList) {
}
