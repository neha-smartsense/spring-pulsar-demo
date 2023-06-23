package com.baeldung.springpulsar;

public class User /*implements Serializable*/ {

    /*@Serial
    private static final long serialVersionUID = -2741191088921065864L;*/

    private String email;
    private String firstName;

    public User(String email, String firstName) {
        this.email = email;
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
