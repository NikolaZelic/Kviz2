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
import javax.persistence.Id;
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
@Table(name = "korisnik")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Korisnik.findAll", query = "SELECT k FROM Korisnik k")
    , @NamedQuery(name = "Korisnik.findByKorUsername", query = "SELECT k FROM Korisnik k WHERE k.korUsername = :korUsername")
    , @NamedQuery(name = "Korisnik.findByKorPassword", query = "SELECT k FROM Korisnik k WHERE k.korPassword = :korPassword")})
public class Korisnik implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "kor_username")
    private String korUsername;
    @Column(name = "kor_password")
    private String korPassword;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "korisnik")
    private Set<KorPit> korPitSet;

    public Korisnik() {
    }

    public Korisnik(String korUsername) {
        this.korUsername = korUsername;
    }

    public String getKorUsername() {
        return korUsername;
    }

    public void setKorUsername(String korUsername) {
        this.korUsername = korUsername;
    }

    public String getKorPassword() {
        return korPassword;
    }

    public void setKorPassword(String korPassword) {
        this.korPassword = korPassword;
    }

    @XmlTransient
    public Set<KorPit> getKorPitSet() {
        return korPitSet;
    }

    public void setKorPitSet(Set<KorPit> korPitSet) {
        this.korPitSet = korPitSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (korUsername != null ? korUsername.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Korisnik)) {
            return false;
        }
        Korisnik other = (Korisnik) object;
        if ((this.korUsername == null && other.korUsername != null) || (this.korUsername != null && !this.korUsername.equals(other.korUsername))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Baza.Korisnik[ korUsername=" + korUsername + " ]";
    }
    
}
