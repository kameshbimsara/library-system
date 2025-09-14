package lk.acpt.library.dto;

public class BarrowDto {
    private int id;
    private int book_Id;
    private int member_Id;
    private String date;

    public BarrowDto(int book_Id, int member_Id, String date) {
        this.book_Id = book_Id;
        this.member_Id = member_Id;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBook_Id() {
        return book_Id;
    }

    public void setBook_Id(int book_Id) {
        this.book_Id = book_Id;
    }

    public int getMember_Id() {
        return member_Id;
    }

    public void setMember_Id(int member_Id) {
        this.member_Id = member_Id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
