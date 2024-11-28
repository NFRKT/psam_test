package com.MyPatient.Nurse;
import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.context.annotation.ComponentScan;

@Entity


public class Nurse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
    private String email;
    private String f_name;
    private String s_name;
    private Integer phone_number;
    private Integer pesel;
    private LocalDate b_date;
    public Nurse() {
    }
    public Nurse(Long id, String login, String password, String email, String f_name, String s_name, Integer phone_number, Integer pesel, LocalDate b_date) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.f_name = f_name;
        this.s_name = s_name;
        this.phone_number = phone_number;
        this.pesel = pesel;
        this.b_date = b_date;
    }

    public Nurse(String login, String password, String email, String f_name, String s_name, Integer phone_number, Integer pesel, LocalDate b_date) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.f_name = f_name;
        this.s_name = s_name;
        this.phone_number = phone_number;
        this.pesel = pesel;
        this.b_date = b_date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public Integer getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(Integer phone_number) {
        this.phone_number = phone_number;
    }

    public Integer getPesel() {
        return pesel;
    }

    public void setPesel(Integer pesel) {
        this.pesel = pesel;
    }

    public LocalDate getB_date() {
        return b_date;
    }

    public void setB_date(LocalDate b_date) {
        this.b_date = b_date;
    }

    @Override
    public String toString() {
        return "Nurse{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", f_name='" + f_name + '\'' +
                ", s_name='" + s_name + '\'' +
                ", phone_number=" + phone_number +
                ", pesel=" + pesel +
                ", b_date=" + b_date +
                '}';
    }
}
