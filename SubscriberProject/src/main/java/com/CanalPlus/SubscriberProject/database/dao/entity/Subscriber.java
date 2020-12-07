package com.CanalPlus.SubscriberProject.database.dao.entity;


import javax.persistence.*;


@Entity
public class Subscriber {

    @Id
    @GeneratedValue
    private long id;
    private String firstname;
    private String lastname;
    private String principaladress ;



    public Subscriber() {
    }

    public Subscriber(long id, String firstname, String lastname, String principaladress) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.principaladress = principaladress;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;

    }

    public String getPrincipaladress() {
        return principaladress;
    }

    public void setPrincipaladress(String principaladress) {
        this.principaladress = principaladress;
    }



    @Override
    public String toString() {
        return "Subscriber{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", principaladress='" + principaladress + '\'' +
                '}';
    }
}

