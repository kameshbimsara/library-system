package lk.acpt.library.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.acpt.library.dto.MemberDto;
import lk.acpt.library.service.MemberService;
import lk.acpt.library.service.impl.MemberServiceImpl;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MemberController implements Initializable {

    @FXML
    private TableView<MemberDto> tblMember;//problem

    @FXML
    private TextField txtMember;

    @FXML
    private TextField txtMemberId;

    @FXML
    private TextField txtNicNum;

    @FXML
    private TextField txtPhoneNum;

    public void initialize(URL location, ResourceBundle resources) {
        lordData(null);//problem
    }

    @FXML
    void addBtn(ActionEvent event) {

        String memberName = txtMember.getText();
        String memberPhone = txtPhoneNum.getText();
        String memberNicNum = txtNicNum.getText();

        MemberDto memberDto = new MemberDto(memberName, memberPhone, memberNicNum);

        MemberService service = new MemberServiceImpl();
        int add = service.addMember(memberDto);

        txtMember.clear();
        txtPhoneNum.clear();
        txtNicNum.clear();

        lordData(memberDto);//problem
    }

    @FXML
    void deleteBtn(ActionEvent event) {

        String memberId = txtMemberId.getText();

        MemberService service = new MemberServiceImpl();
        int delete = service.deleteMember(Integer.parseInt(memberId));

        txtMemberId.clear();

        lordData(null);//problem

    }

    @FXML
    void searchBtn(ActionEvent event) {

        String memberId = txtMemberId.getText();

        MemberService service = new MemberServiceImpl();
        MemberDto search = service.searchMember(Integer.parseInt(memberId));

        txtMember.setText(search.getName());
        txtPhoneNum.setText(search.getPhone());
        txtNicNum.setText(search.getNic());

    }

    @FXML
    void updateBtn(ActionEvent event) {

        String memberName = txtMember.getText();
        String memberPhone = txtPhoneNum.getText();
        String memberNicNum = txtNicNum.getText();
        String updateId = txtMemberId.getText();

        MemberDto memberDto = new MemberDto(Integer.parseInt(updateId),memberName, memberPhone, memberNicNum);

       MemberService service = new MemberServiceImpl();
       int update = service.updateMember(memberDto);

        txtMember.clear();
        txtPhoneNum.clear();
        txtNicNum.clear();
        txtMemberId.clear();

        lordData(memberDto);//problem

    }
    void lordData(MemberDto memberDto) {

        tblMember.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblMember.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblMember.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("phone"));
        tblMember.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("nic"));

        MemberService service = new MemberServiceImpl();
        ArrayList<MemberDto> lord = service.lordData(memberDto);

        tblMember.setItems(FXCollections.observableList(lord));

    }

}
