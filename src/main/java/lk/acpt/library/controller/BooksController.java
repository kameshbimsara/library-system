package lk.acpt.library.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.acpt.library.dto.BookDto;
import lk.acpt.library.service.BookService;
import lk.acpt.library.service.MemberService;
import lk.acpt.library.service.impl.BookServiceImpl;
import lk.acpt.library.service.impl.MemberServiceImpl;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BooksController implements Initializable {

    @FXML
    private TableView<BookDto> tblBook;

    @FXML
    private TextField txtAuthor;

    @FXML
    private TextField txtBook;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtYear;

    public void initialize(URL location, ResourceBundle resources) {
        loadData(null);
    }

    @FXML
    void addBook(ActionEvent event) {

        String bookName = txtBook.getText();
        String author = txtAuthor.getText();
        int year = Integer.parseInt(txtYear.getText());

        BookDto bookDto = new BookDto( bookName , author , year);

        BookService service = new BookServiceImpl();
        int add = service.addBook(bookDto);

        if(add > 0){
            System.out.println("BookDto added successfully");
        }else {
            System.out.println("BookDto not added");
        }
        txtBook.clear();
        txtAuthor.clear();
        txtYear.clear();

        loadData(bookDto);
        System.out.println("table view success");
    }

    @FXML
    void deleteBook(ActionEvent event) {

        String deleteId = txtId.getText();

        BookService service = new BookServiceImpl();
        int delete = service.deleteBook(Integer.parseInt(deleteId));

        if(delete > 0){
            System.out.println("BookDto deleted successfully");
        }else {
            System.out.println("BookDto not deleted");
        }
        txtId.clear();

        loadData(null);
    }

    @FXML
    void searchBook(ActionEvent event) {

        String searchId = txtId.getText();

        BookService service = new BookServiceImpl();
        BookDto search = service.searchBook(Integer.parseInt(searchId));

            txtBook.setText(search.getName());
            txtAuthor.setText(search.getAuthor());
            txtYear.setText(String.valueOf(search.getYear()));

    }

    @FXML
    void updateBook(ActionEvent event) {

        int updateId = Integer.parseInt(txtId.getText());
        String bookName = txtBook.getText();
        String author = txtAuthor.getText();
        int year = Integer.parseInt(txtYear.getText());

        BookDto bookDto = new BookDto(updateId , bookName , author , year);

        BookService service = new BookServiceImpl();
        int update = service.updateBook(bookDto);

        if(update > 0){
            System.out.println("BookDto update successfully");
        }else {
            System.out.println("BookDto not update");
        }

        txtId.clear();
        txtBook.clear();
        txtAuthor.clear();
        txtYear.clear();

        loadData(bookDto);
    }

     void loadData(BookDto bookDto) {//problem ai dto pass kalla thinne.

        tblBook.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblBook.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblBook.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("author"));
        tblBook.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("year"));

        BookService service = new BookServiceImpl();
        ArrayList<BookDto> lord = service.loadData(bookDto);

        tblBook.setItems(FXCollections.observableArrayList(lord));
    }
}
