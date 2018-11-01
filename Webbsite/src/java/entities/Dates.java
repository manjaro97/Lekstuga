/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Manjaro
 */
@Entity
@Table(name = "DATES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dates.findAll", query = "SELECT d FROM Dates d")
    , @NamedQuery(name = "Dates.findByDay", query = "SELECT d FROM Dates d WHERE d.day = :day")
    , @NamedQuery(name = "Dates.findById", query = "SELECT d FROM Dates d WHERE d.id = :id")
    , @NamedQuery(name = "Dates.findByTime", query = "SELECT d FROM Dates d WHERE d.time = :time")})
public class Dates implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 20)
    @Column(name = "DAY")
    private String day;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ID")
    private String id;
    @Size(max = 20)
    @Column(name = "TIME")
    private String time;

    public Dates() {
    }

    public Dates(String id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dates)) {
            return false;
        }
        Dates other = (Dates) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Dates[ id=" + id + " ]";
    }
    
}
