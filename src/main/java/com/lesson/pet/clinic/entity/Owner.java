package com.lesson.pet.clinic.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by User on 10.04.2018.
 */
@Entity
@Table(name = "owners")
public class Owner implements Serializable {

    private static final long serialVersionUID = -5527566248002296042L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    private int id;

    @Column(name = "first_name", nullable = false, insertable = true, updatable = true, length = 45)
    private String firstName;

    @Column(name = "second_name", nullable = false, insertable = true, updatable = true, length = 45)
    private String secondName;

    @OneToMany(fetch = FetchType.EAGER/*LAZY*/, mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Pet> pets;

    public Owner() {}

    public Owner(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Owner that = (Owner) o;

        if (id != that.id) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (secondName != null ? !secondName.equals(that.secondName) : that.secondName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Owner {" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}' + "\n";
    }
}
