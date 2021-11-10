package com.mintic.misiontic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mintic.misiontic.entity.Bike;
import com.mintic.misiontic.entity.Client;
import com.mintic.misiontic.repository.BikeRepository;
import com.mintic.misiontic.repository.ClienteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClienteRepository methodsCrud;

    public List<Client> getAll(){
        return methodsCrud.getAll();
    }

    public Optional<Client> getClient(int clientId) {
        return methodsCrud.get(clientId);
    }

    public Client save(Client client){
        if(client.getIdClient()==null){
            return methodsCrud.save(client);
        }else{
            Optional<Client> e= methodsCrud.get(client.getIdClient());
            if(e.isEmpty()){
                return methodsCrud.save(client);
            }else{
                return client;
            }
        }
    }

    public Client update(Client client){
        if(client.getIdClient()!=null){
            Optional<Client> e= methodsCrud.get(client.getIdClient());
            if(!e.isEmpty()){
                if(client.getName()!=null){
                    e.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    e.get().setAge(client.getAge());
                }
                if(client.getPassword()!=null){
                    e.get().setPassword(client.getPassword());
                }
                methodsCrud.save(e.get());
                return e.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }

    public boolean deleteClient(int clientId) {
        Boolean aBoolean = getClient(clientId).map(client -> {
            methodsCrud.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
