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
    
    public void atualizarVaga(int id, Vaga vgi){
        vdao.atualizarVaga(id, vgi);
    }

    public List<Map<String, Object>> obterVaga(int id){
        return vdao.obterVaga(id);
    }

    public void apagarVaga(int id){
		vdao.apagarVaga(id);
	}

}
