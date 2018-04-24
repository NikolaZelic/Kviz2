/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Baza;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Grupa1
 */
@Entity
@Table(name = "odgovori")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Odgovori.findAll", query = "SELECT o FROM Odgovori o")
    , @NamedQuery(name = "Odgovori.findByOdgId", query = "SELECT o FROM Odgovori o WHERE o.odgId = :odgId")
    , @NamedQuery(name = "Odgovori.findByOdgText", query = "SELECT o FROM Odgovori o WHERE o.odgText = :odgText")
    , @NamedQuery(name = "Odgovori.findByOdgTacan", query = "SELECT o FROM Odgovori o WHERE o.odgTacan = :odgTacan")})
public class Odgovori implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "odg_id")
    private Integer odgId;
    @Column(name = "odg_text")
    private String odgText;
    @Column(name = "odg_tacan")
    private Short odgTacan;
    @JoinColumn(name = "pit_id", referencedColumnName = "pit_id")
    @ManyToOne
    private Pitanja pitId;

    public Odgovori() {
    }

    public Odgovori(Integer odgId) {
        this.odgId = odgId;
    }

    public Integer getOdgId() {
        return odgId;
    }

    public void setOdgId(Integer odgId) {
        this.odgId = odgId;
    }

    public String getOdgText() {
        return odgText;
    }

    public void setOdgText(String odgText) {
        this.odgText = odgText;
    }

    public Short getOdgTacan() {
        return odgTacan;
    }

    public void setOdgTacan(Short odgTacan) {
        this.odgTacan = odgTacan;
    }

    public Pitanja getPitId() {
        return pitId;
    }

    public void setPitId(Pitanja pitId) {
        this.pitId = pitId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (odgId != null ? odgId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Odgovori)) {
            return false;
        }
        Odgovori other = (Odgovori) object;
        if ((this.odgId == null && other.odgId != null) || (this.odgId != null && !this.odgId.equals(other.odgId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Baza.Odgovori[ odgId=" + odgId + " ]";
    }
    
}
