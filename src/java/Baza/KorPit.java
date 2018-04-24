/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Baza;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "kor_pit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KorPit.findAll", query = "SELECT k FROM KorPit k")
    , @NamedQuery(name = "KorPit.findByKorUsername", query = "SELECT k FROM KorPit k WHERE k.korPitPK.korUsername = :korUsername")
    , @NamedQuery(name = "KorPit.findByPitId", query = "SELECT k FROM KorPit k WHERE k.korPitPK.pitId = :pitId")
    , @NamedQuery(name = "KorPit.findByKorPitTacan", query = "SELECT k FROM KorPit k WHERE k.korPitTacan = :korPitTacan")})
public class KorPit implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected KorPitPK korPitPK;
    @Column(name = "kor_pit_tacan")
    private Short korPitTacan;
    @JoinColumn(name = "kor_username", referencedColumnName = "kor_username", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Korisnik korisnik;
    @JoinColumn(name = "pit_id", referencedColumnName = "pit_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pitanja pitanja;

    public KorPit() {
    }

    public KorPit(KorPitPK korPitPK) {
        this.korPitPK = korPitPK;
    }

    public KorPit(String korUsername, int pitId) {
        this.korPitPK = new KorPitPK(korUsername, pitId);
    }

    public KorPitPK getKorPitPK() {
        return korPitPK;
    }

    public void setKorPitPK(KorPitPK korPitPK) {
        this.korPitPK = korPitPK;
    }

    public Short getKorPitTacan() {
        return korPitTacan;
    }

    public void setKorPitTacan(Short korPitTacan) {
        this.korPitTacan = korPitTacan;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Pitanja getPitanja() {
        return pitanja;
    }

    public void setPitanja(Pitanja pitanja) {
        this.pitanja = pitanja;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (korPitPK != null ? korPitPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KorPit)) {
            return false;
        }
        KorPit other = (KorPit) object;
        if ((this.korPitPK == null && other.korPitPK != null) || (this.korPitPK != null && !this.korPitPK.equals(other.korPitPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Baza.KorPit[ korPitPK=" + korPitPK + " ]";
    }
    
}
