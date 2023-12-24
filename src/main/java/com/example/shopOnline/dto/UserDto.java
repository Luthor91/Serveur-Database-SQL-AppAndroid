package com.example.shopOnline.dto;

import com.example.shopOnline.entities.City;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link com.example.shopOnline.entities.User}
 */
public class UserDto implements Serializable {
    private final String id;
    private final String userName;
    private final String userEmail;
    private final String userPhone;
    private final String userFname;
    private final String useLname;
    private final String userPassword;
    private final String userAddress;
    private final Integer userLoginStatus;
    private final City userCity;


    public UserDto(String id, String userName, String userEmail, String userPhone, String userFname, String useLname, String userPassword, String userAdress, Integer userLoginStatus, City userCity) {
        this.id = id;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.userFname = userFname;
        this.useLname = useLname;
        this.userPassword = userPassword;
        this.userAddress = userAdress;
        this.userLoginStatus = userLoginStatus;
        this.userCity = userCity;
    }

    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public String getUserFname() {
        return userFname;
    }

    public String getUseLname() {
        return useLname;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public Integer getUserLoginStatus() {
        return userLoginStatus;
    }

    public City getUserCity() {
        return userCity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDto)) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(getId(), userDto.getId()) && Objects.equals(getUserName(), userDto.getUserName()) && Objects.equals(getUserEmail(), userDto.getUserEmail()) && Objects.equals(getUserPhone(), userDto.getUserPhone()) && Objects.equals(getUserFname(), userDto.getUserFname()) && Objects.equals(getUseLname(), userDto.getUseLname()) && Objects.equals(getUserPassword(), userDto.getUserPassword()) && Objects.equals(getUserAddress(), userDto.getUserAddress()) && Objects.equals(getUserLoginStatus(), userDto.getUserLoginStatus()) && Objects.equals(getUserCity(), userDto.getUserCity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserName(), getUserEmail(), getUserPhone(), getUserFname(), getUseLname(), getUserPassword(), getUserAddress(), getUserLoginStatus(), getUserCity());
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userFname='" + userFname + '\'' +
                ", useLname='" + useLname + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userAdress='" + userAddress + '\'' +
                ", userLoginStatus=" + userLoginStatus +
                ", userCity=" + userCity +
                '}';
    }
}