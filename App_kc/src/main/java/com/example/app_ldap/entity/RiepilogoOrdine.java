package com.example.app_ldap.entity;

import java.util.Map;

import lombok.Data;

/**
 * Data Transfer Object (DTO) per la visualizzazione aggregata degli ordini
 * nella pagina Admin.
 * Contiene i conteggi totali dei piatti da preparare.
 */
@Data
public class RiepilogoOrdine {

    // Mappa dove la chiave è il Nome del Piatto e il valore è la Quantità totale
    // ordinata.
    // Esempio: {"Carbonara": 20, "Cotoletta": 15}
    private Map<String, Long> piattiPerQuantita;

    // Conteggio totale degli ordini unici inviati.
    private long totaleOrdiniUnici;

    // Costruttore Vuoto
    public RiepilogoOrdine() {
    }

    // Costruttore Completo (quello che Lombok non stava generando)
    public RiepilogoOrdine(Map<String, Long> piattiPerQuantita, long totaleOrdiniUnici) {
        this.piattiPerQuantita = piattiPerQuantita;
        this.totaleOrdiniUnici = totaleOrdiniUnici;
    }

    // Getter
    public Map<String, Long> getPiattiPerQuantita() {
        return piattiPerQuantita;
    }

    public void setPiattiPerQuantita(Map<String, Long> piattiPerQuantita) {
        this.piattiPerQuantita = piattiPerQuantita;
    }

    public long getTotaleOrdiniUnici() {
        return totaleOrdiniUnici;
    }

    public void setTotaleOrdiniUnici(long totaleOrdiniUnici) {
        this.totaleOrdiniUnici = totaleOrdiniUnici;
    }
}
