package lk.acpt.library.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import lk.acpt.library.dto.BarrowDto;
import lk.acpt.library.dto.BookDto;
import lk.acpt.library.dto.MemberDto;
import lk.acpt.library.service.BarrowService;
import lk.acpt.library.service.BookService;
import lk.acpt.library.service.MemberService;
import lk.acpt.library.service.impl.BarrowServiceImpl;
import lk.acpt.library.service.impl.BookServiceImpl;
import lk.acpt.library.service.impl.MemberServiceImpl;

import java.time.LocalDate;

public class BarrowController {

    @FXML
    private TextField txtAuthor;

    @FXML
    private TextField txtBook_Id;

    @FXML
    private TextField txtBook_Name;

    @FXML
    private TextField txtMember_Id;

    @FXML
    private TextField txtMember_Name;

    @FXML
    private TextField txtNic;

    @FXML
    private TextField txtPhoneNum;

    @FXML
    private TextField txtYear;

    @FXML
    void bookBarrow(ActionEvent event) {

        int book_Id = Integer.parseInt(txtBook_Id.getText());
        int member_Id = Integer.parseInt(txtMember_Id.getText());
        String date = LocalDate.now().toString();

        BarrowDto dto = new BarrowDto(book_Id , member_Id , date);

        BarrowService service = new BarrowServiceImpl();
        int add = service.addBarrow(dto);

        System.out.println("book barrow success");

    }

    @FXML
    void bookDetails(ActionEvent event) {

        String bookId = txtBook_Id.getText();

        BookService service = new BookServiceImpl();
        BookDto searchBook = service.searchBook(Integer.parseInt(bookId));

        txtBook_Name.setText(searchBook.getName());
        txtAuthor.setText(searchBook.getAuthor());
        txtYear.setText(String.valueOf(searchBook.getYear()));

        System.out.println("show to book details");

    }

    @FXML
    void memberDetails(ActionEvent event) {

        String memberId = txtMember_Id.getText();

        MemberService service = new MemberServiceImpl();
        MemberDto searchMember = service.searchMember(Integer.parseInt(memberId));

        txtMember_Name.setText(searchMember.getName());
        txtPhoneNum.setText(searchMember.getPhone());
        txtNic.setText(searchMember.getNic());


    }

}
