/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Baza;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Grupa1
 */
@Embeddable
public class KorPitPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "kor_username")
    private String korUsername;
    @Basic(optional = false)
    @Column(name = "pit_id")
    private int pitId;

    public KorPitPK() {
    }

    public KorPitPK(String korUsername, int pitId) {
        this.korUsername = korUsername;
        this.pitId = pitId;
    }

    public String getKorUsername() {
        return korUsername;
    }

    public void setKorUsername(String korUsername) {
        this.korUsername = korUsername;
    }

    public int getPitId() {
        return pitId;
    }

    public void setPitId(int pitId) {
        this.pitId = pitId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (korUsername != null ? korUsername.hashCode() : 0);
        hash += (int) pitId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KorPitPK)) {
            return false;
        }
        KorPitPK other = (KorPitPK) object;
        if ((this.korUsername == null && other.korUsername != null) || (this.korUsername != null && !this.korUsername.equals(other.korUsername))) {
            return false;
        }
        if (this.pitId != other.pitId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Baza.KorPitPK[ korUsername=" + korUsername + ", pitId=" + pitId + " ]";
    }
    
}
