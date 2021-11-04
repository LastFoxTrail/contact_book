package com.lis.projects.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Contact {
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 32, message = "Name length must be more than 2 and less than 32 characters")
    private String name;

    @Size(min = 2, max = 32, message = "Surname length must be more than 2 and less than 32 characters")
    private String surname;

    private String adress;

    @NotBlank(message = "Phone is required")
    @Pattern(regexp = "^(8|\\+7)\\d{10}$", message = "The phone number must match the mask + 7xxxx")
    private String phone;

    public Contact() {}

    public Contact(Long id, String name, String surname, String adress, String phone) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", adress='" + adress + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
