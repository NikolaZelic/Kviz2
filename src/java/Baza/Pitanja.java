/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Baza;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Grupa1
 */
@Entity
@Table(name = "pitanja")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pitanja.findAll", query = "SELECT p FROM Pitanja p")
    , @NamedQuery(name = "Pitanja.findByPitId", query = "SELECT p FROM Pitanja p WHERE p.pitId = :pitId")
    , @NamedQuery(name = "Pitanja.findByPitBodovi", query = "SELECT p FROM Pitanja p WHERE p.pitBodovi = :pitBodovi")})
public class Pitanja implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pit_id")
    private Integer pitId;
    @Lob
    @Column(name = "pit_text")
    private String pitText;
    @Column(name = "pit_bodovi")
    private Integer pitBodovi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pitanja")
    private Set<KorPit> korPitSet;
    @OneToMany(mappedBy = "pitId")
    private Set<Odgovori> odgovoriSet;

    public Pitanja() {
    }

    public Pitanja(Integer pitId) {
        this.pitId = pitId;
    }

    public Integer getPitId() {
        return pitId;
    }

    public void setPitId(Integer pitId) {
        this.pitId = pitId;
    }

    public String getPitText() {
        return pitText;
    }

    public void setPitText(String pitText) {
        this.pitText = pitText;
    }

    public Integer getPitBodovi() {
        return pitBodovi;
    }

    public void setPitBodovi(Integer pitBodovi) {
        this.pitBodovi = pitBodovi;
    }

    @XmlTransient
    public Set<KorPit> getKorPitSet() {
        return korPitSet;
    }

    public void setKorPitSet(Set<KorPit> korPitSet) {
        this.korPitSet = korPitSet;
    }

    @XmlTransient
    public Set<Odgovori> getOdgovoriSet() {
        return odgovoriSet;
    }

    public void setOdgovoriSet(Set<Odgovori> odgovoriSet) {
        this.odgovoriSet = odgovoriSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pitId != null ? pitId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pitanja)) {
            return false;
        }
        Pitanja other = (Pitanja) object;
        if ((this.pitId == null && other.pitId != null) || (this.pitId != null && !this.pitId.equals(other.pitId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Baza.Pitanja[ pitId=" + pitId + " ]";
    }
    
}
