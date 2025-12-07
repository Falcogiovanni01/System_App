package com.example.app_ldap.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ordini")
public class Ordine {

    @Id
    private String id;
    private String username;
    private List<String> piattiId;
    private LocalDateTime dataOrdine;
    private String stato;

    public Ordine() {
    }

    public Ordine(String username, List<String> piattiId) {
        this.username = username;
        this.piattiId = piattiId;
        this.dataOrdine = LocalDateTime.now();
        this.stato = "Inviato";
    }

    // Costruttore completo
    public Ordine(String id, String username, List<String> piattiId, LocalDateTime dataOrdine, String stato) {
        this.id = id;
        this.username = username;
        this.piattiId = piattiId;
        this.dataOrdine = dataOrdine;
        this.stato = stato;
    }

    // GETTERS & SETTERS (Quelli che mancavano)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getPiattiId() {
        return piattiId;
    }

    public void setPiattiId(List<String> piattiId) {
        this.piattiId = piattiId;
    }

    public LocalDateTime getDataOrdine() {
        return dataOrdine;
    }

    public void setDataOrdine(LocalDateTime dataOrdine) {
        this.dataOrdine = dataOrdine;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }
}