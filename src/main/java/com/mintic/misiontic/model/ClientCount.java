package com.mintic.misiontic.model;

import com.mintic.misiontic.entity.Client;

public class ClientCount {
    private Long total;
    private Client client;

    public ClientCount(Long total, Client client) {
        this.total = total;
        this.client = client;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}