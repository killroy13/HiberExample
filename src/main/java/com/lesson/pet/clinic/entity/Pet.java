package com.lesson.pet.clinic.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by User on 11.04.2018.
 */
@Entity
@Table(name = "pets")
public class Pet implements Serializable {

    private static final long serialVersionUID = 5924361831551833717L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pets_id", nullable = false, insertable = true, updatable = true)
    private int petsId;

    @Column(name = "kind_of_pet", nullable = false, insertable = true, updatable = true, length = 45)
    private String kindOfPet;

    @Column(name = "pets_name", nullable = false, insertable = true, updatable = true, length = 45)
    private String petsName;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id", nullable = true)
    private Owner owner;

    public Pet() {
    }

    public Pet(String kindOfPet, String petsName/*, Owner owner*/) {
        this.kindOfPet = kindOfPet;
        this.petsName = petsName;
//        this.owner = owner;
    }

    public int getPetsId() {
        return petsId;
    }

    public void setPetsId(int id) {
        this.petsId = id;
    }

    public String getKindOfPet() {
        return kindOfPet;
    }

    public void setKindOfPet(String kindOfPet) {
        this.kindOfPet = kindOfPet;
    }

    public String getPetsName() {
        return petsName;
    }

    public void setPetsName(String petsName) {
        this.petsName = petsName;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pet pet = (Pet) o;

        if (petsId != pet.petsId) return false;
        if (kindOfPet != null ? !kindOfPet.equals(pet.kindOfPet) : pet.kindOfPet != null) return false;
        if (petsName != null ? !petsName.equals(pet.petsName) : pet.petsName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = petsId;
        result = 31 * result + (kindOfPet != null ? kindOfPet.hashCode() : 0);
        result = 31 * result + (petsName != null ? petsName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {

        return "Pet { " +
                "id=" + petsId +
                ", kindOfPet='" + kindOfPet + '\'' +
                ", petsName='" + petsName + '\'' +
                '}' + "\n";
    }
}
