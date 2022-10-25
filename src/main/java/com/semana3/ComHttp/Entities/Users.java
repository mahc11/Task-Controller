package com.semana3.ComHttp.Entities;

import javax.persistence.*;

@Entity
@Table(name="users")
public class Users {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column(name="email", unique = true)
    private String email;

    @Column(name="image")
    private String image;

    @Column(name="Auth0Id", unique = true)
    private String auth0id;

    @Column(name="name")
    private String name;

    public Users(){
    }

    public Users(String email, String image, String auth0id, String name){
        this.email=email;
        this.image=image;
        this.auth0id=auth0id;
        this.name=name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAuth0id() {
        return auth0id;
    }

    public void setAuth0id(String auth0id) {
        this.auth0id = auth0id;
    }
}
