package kr.co.bit.vo;

public class EmailListVO {
    private int no;
    private String last_Name;
    private String first_Name;
    private String email;

    public EmailListVO() {
    }

    public EmailListVO(int no, String last_Name, String first_Name, String email) {
        this.no = no;
        this.last_Name = last_Name;
        this.first_Name = first_Name;
        this.email = email;
    }

    public EmailListVO(String last_Name, String first_Name, String email) {
        this.last_Name = last_Name;
        this.first_Name = first_Name;
        this.email = email;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public String getFirst_Name() {
        return first_Name;
    }

    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "EmailListVO{" +
                "no=" + no +
                ", last_Name='" + last_Name + '\'' +
                ", first_Name='" + first_Name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
