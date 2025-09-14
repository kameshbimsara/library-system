package lk.acpt.library.dto;

public class MemberDto {
    private int id;
    private String name;
    private String phone;
    private String nic;

    public MemberDto() {
    }

    public MemberDto(int id, String name, String phone, String nic) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.nic = nic;
    }

    public MemberDto(String name, String phone, String nic) {
        this.name = name;
        this.phone = phone;
        this.nic = nic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }
}