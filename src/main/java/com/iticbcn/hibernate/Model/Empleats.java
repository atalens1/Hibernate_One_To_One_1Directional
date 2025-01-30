package com.iticbcn.hibernate.Model;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="empleats")
public class Empleats implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="emp_no")
    private int numeroEmpleat;

    @Column(name="emp_name")
    private String nomEmpleat;

    @OneToOne(cascade=CascadeType.ALL)   
    @JoinColumn(name="despatx",
    referencedColumnName="off_no",updatable=false)
    private Despatx despatx;

    public Empleats() {}

    public Empleats(String nomEmpleat, Despatx despatx) {
        this.nomEmpleat = nomEmpleat;
        this.despatx = despatx;
    }

    public int getNumeroEmpleat() {
        return numeroEmpleat;
    }

    public void setNumeroEmpleat(int numeroEmpleat) {
        this.numeroEmpleat = numeroEmpleat;
    }

    public String getNomEmpleat() {
        return nomEmpleat;
    }

    public void setNomEmpleat(String nomEmpleat) {
        this.nomEmpleat = nomEmpleat;
    }

    public Despatx getDespatx() {
        return despatx;
    }

    public void setDespatx(Despatx despatx) {
        this.despatx = despatx;
    }    
}
