package lk.acpt.library.service.impl;

import lk.acpt.library.db.DBConnection;
import lk.acpt.library.dto.BarrowDto;
import lk.acpt.library.service.BarrowService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BarrowServiceImpl implements BarrowService {
    @Override
    public int addBarrow(BarrowDto dto) {

        try {
            Connection connection = DBConnection.getDbConnection().getConnection();

            connection.setAutoCommit(false);

            PreparedStatement preparedStatement = connection.prepareStatement("insert into book_barrow_details(member_id , book_id , barrow_date) values(?,?,?)");

            preparedStatement.setInt(1, dto.getMember_Id());
            preparedStatement.setInt(2, dto.getBook_Id());
            preparedStatement.setString(3, dto.getDate());

            int barrow = preparedStatement.executeUpdate();

            if (barrow > 0) {
                System.out.println("Barrow book added");
//                connection.commit();//problem

                PreparedStatement preparedStatement1 = connection.prepareStatement("update books_detals set quantity = quantity-1 where id = ?");

                preparedStatement1.setInt(1, dto.getBook_Id());

                int quantity = preparedStatement1.executeUpdate();

                if (quantity > 0) {
                    System.out.println("Barrow book added");
                    connection.commit();
                }else {
                    connection.rollback();
                    System.out.println("Barrow book note add");
                }

            }
            else {
                connection.rollback();//problem
            }
            return barrow;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
