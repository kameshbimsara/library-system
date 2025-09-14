package lk.acpt.library.service.impl;

import javafx.collections.FXCollections;
import lk.acpt.library.db.DBConnection;
import lk.acpt.library.dto.MemberDto;
import lk.acpt.library.service.MemberService;

import java.sql.*;
import java.util.ArrayList;

public class MemberServiceImpl implements MemberService {

    @Override
    public int addMember(MemberDto memberDto) {

        try {

            Connection connection = DBConnection.getDbConnection().getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("insert into member_details(name , phoneNum , NIC_num) values(?,?,?)");

            preparedStatement.setString(1, memberDto.getName());
            preparedStatement.setString(2, memberDto.getPhone());
            preparedStatement.setString(3, memberDto.getNic());

            int i = preparedStatement.executeUpdate();

            if (i>0){
                System.out.println("MemberDto Added Successfully");
                return i;
            }else {
                System.out.println("MemberDto Not Added");
                return 0;
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int deleteMember(int id) {

        try {
            Connection connection = DBConnection.getDbConnection().getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("delete from member_details where id=?");

            preparedStatement.setString(1, String.valueOf(id));//problem

            int i = preparedStatement.executeUpdate();

            if (i > 0) {
                System.out.println("MemberDto Deleted Successfully");
            }else {
                System.out.println("MemberDto Not Deleted Successfully");
            }


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return 0;
    }

    @Override
    public MemberDto searchMember(int id) {

        try {

            Connection connection = DBConnection.getDbConnection().getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("select * from member_details where id = ?");

            preparedStatement.setString(1, String.valueOf(id));//problem

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
               MemberDto memberDto = new MemberDto(resultSet.getString("name"), resultSet.getString("phoneNum"), resultSet.getString("NIC_num"));
                return memberDto;//problem
            }else {
                System.out.println("MemberDto Not Found");
                return null;
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public int updateMember(MemberDto memberDto) {

        try {

            Connection connection = DBConnection.getDbConnection().getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("update member_details set name = ? , phoneNum = ? , NIC_num = ? where id = ? ");

            preparedStatement.setString(1, memberDto.getName());
            preparedStatement.setString(2, memberDto.getPhone());
            preparedStatement.setString(3, memberDto.getNic());
            preparedStatement.setString(4, String.valueOf(memberDto.getId()));

            int i = preparedStatement.executeUpdate();

            if (i > 0) {
                System.out.println("MemberDto Updated Successfully");
            }else {
                System.out.println("MemberDto Not Updated Successfully");
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    public ArrayList<MemberDto> lordData (MemberDto memberDto) {

        ArrayList <MemberDto> memberDtos = new ArrayList<>();

        try {

            Connection connection = DBConnection.getDbConnection().getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("select * from member_details");

            ResultSet getAll = preparedStatement.executeQuery();

            while (getAll.next()) {
                memberDtos.add(new MemberDto(
                        getAll.getInt(1),
                        getAll.getString(2),
                        getAll.getString(3),
                        getAll.getString(4)
                ));
            }
            return memberDtos;

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
      }
    }

