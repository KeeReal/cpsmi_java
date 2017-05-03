package task_12_fio.impl;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class UserVO {


    private String id;
    private String fullname;
    private String birthdate;
    private String address;
    private String tel;


    public UserVO() {
    }


    public String getId() {
        return id;
    }


    public String getFullname() {
        return fullname;
    }


    public void setFullname(String fullname) {
        this.fullname = fullname;
    }


    public String getBirthdate() {
        return birthdate;
    }


    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }


    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }


    public String getTel() {
        return tel;
    }


    public void setTel(String tel) {
        this.tel = tel;
    }


    @Override
    public String toString() {
        return "UserVO{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}
