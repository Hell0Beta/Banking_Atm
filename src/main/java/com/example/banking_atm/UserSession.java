package com.example.banking_atm;

public final class UserSession {
    private static UserSession instance;

    private String username;
    private int pin;
    private String email;
    private String accountNo;

    private UserSession(String username, String s, int pin, String email) {
        this.accountNo = accountNo;
        this.username = username;
        this.pin = pin;
        this.email = email;
    }

    public static UserSession getInstance(String accountNo,String username, int pin, String email) {
        if (instance == null) {
            instance = new UserSession(accountNo, username, pin, email);
        }
        else {
            System.out.println("UserSession already exists");
        }
        return instance;
    }
    public static void initSession(String accountNo, String username, int pin, String email) {
        if (instance == null) {
            instance = new UserSession(accountNo, username, pin, email);
        }
    }

    public String getUsername() {
        return username;
    }
    public String getAccountNo() {
        return accountNo;
    }

    public int getPin() {
        return pin;
    }
    public String getEmail() {
        return email;
    }
    public void cleanUserSession() {
        username = null;
        pin = 0;
        email = null;
    }

    @Override
    public String toString() {
        return "UserSession{" + "username=" + username + ", pin=" + pin + ", email=" + email + '}';
    }
}
