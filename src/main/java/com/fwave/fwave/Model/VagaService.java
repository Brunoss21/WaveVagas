package com.fwave.fwave.Model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VagaService {

    @Autowired VagaDAO vdao;

    public void inserirVaga(Vaga vgi){
        vdao.inserirVaga(vgi);
    }

    public List<Map<String, Object>> listarVagas(){
        return vdao.listarVagas();
    }
    
}
