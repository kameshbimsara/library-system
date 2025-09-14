package lk.acpt.library.service;

import lk.acpt.library.dto.BookDto;

import java.util.ArrayList;

public interface BookService {

    ArrayList<BookDto> loadData(BookDto bookDto);

    int addBook(BookDto bookDto);

    int deleteBook(int id);

    BookDto searchBook(int id);

    int updateBook(BookDto bookDto);

}
