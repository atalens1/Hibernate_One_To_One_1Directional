package com.iticbcn.hibernate.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.io.Serializable;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
@Table(name="despatxos")
public class Despatx implements Serializable{
    @Id
    @Column(name="off_no")
    private int idDespatx;
    
    @Column(name="location")
    private String lloc;

    public Despatx(){}

    public Despatx(int idDespatx, String lloc) {
        this.idDespatx = idDespatx;
        this.lloc = lloc;
    }

    public int getidDespatx() {
        return idDespatx;
    }
    public void setidDespatx(int idDespatx) {
        this.idDespatx = idDespatx;
    }
    public String getLloc() {
        return lloc;
    }
    public void setLloc(String lloc) {
        this.lloc = lloc;
    }
}