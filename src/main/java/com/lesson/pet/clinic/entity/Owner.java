package com.lesson.pet.clinic.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by User on 10.04.2018.
 */
@Entity
@Table(name = "owners")
public class Owner implements Serializable{

    private static final long serialVersionUID = -5527566248002296042L;

    private int id;
    private String firstName;
    private String secondName;

    private List<Pet> pets;

    public Owner(){}

    public Owner(String firstName, String secondName){
        this.firstName= firstName;
        this.secondName= secondName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    @Basic
    @Column(name = "first_name", nullable = false, insertable = true, updatable = true, length = 45)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

//    @Basic
    @Column(name = "second_name", nullable = false, insertable = true, updatable = true, length = 45)
    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @OneToMany(fetch = FetchType.EAGER/*LAZY*/, mappedBy = "owner", cascade = CascadeType.ALL)
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
        String pet = "";
        if ((pets != null) && (pets.size() > 0)) {
            for (int i = 0; i < pets.size(); i++) {
                if (i > 0)
                    pet += ",";
                pet += pets.get(i).toString();
            }
        }

        return "Owner {" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}' + "', pets =[" + pet + "]}" + "\n";
    }
}
