package com.esprit.microservice.client.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
@Entity
@Getter
@Setter
public class Avis {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue
    private Long id;
    private String commentaire;
    private int note;
    private Long utilisateurId;
    private Long voyageId;


    public Avis() {}

    public Avis(String commentaire, int note, Long utilisateurId, Long voyageId) {
        this.commentaire = commentaire;
        this.note = note;
        this.utilisateurId = utilisateurId;
        this.voyageId = voyageId;
    }

    @Override
    public String toString() {
        return "Avis{" +
                "id=" + id +
                ", commentaire='" + commentaire + '\'' +
                ", note=" + note +
                ", utilisateurId=" + utilisateurId +
                ", voyageId=" + voyageId +
                '}';
    }

}
