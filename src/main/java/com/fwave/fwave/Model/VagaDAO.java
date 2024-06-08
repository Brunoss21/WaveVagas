package com.fwave.fwave.Model;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class VagaDAO {
    @Autowired DataSource dataSource;

    JdbcTemplate jdbc;

    @PostConstruct
    private void initialize() {
        jdbc = new JdbcTemplate(dataSource);

    }

    public void inserirVaga(Vaga vgi){
        String sql = "INSERT INTO vaga(titulo, descricao, dataPublic)" +
        " VALUEs (?,?,?)";
        Object[] obj = new Object[3];
        obj[0] = vgi.getTitulo();
        obj[1] = vgi.getDescricao();
        obj[2] = vgi.getDataPublic();
        jdbc.update(sql, obj);
    }

    public List<Map<String, Object>> listarVagas() {
    	String sql = "SELECT * FROM vaga";
    	return jdbc.queryForList(sql);
    }

    public List<Map<String,Object>> obterVaga(int id){
        String sql = "SELECT * FROM vaga where id = ?";
        Object[] obj = new Object[1];
        obj[0] = id;
        return jdbc.queryForList(sql, obj);

    }

    public void atualizarVaga(int id, Vaga vgi){
        String sql = "UPDATE vaga SET titulo = ?," + "descricao = ?," + "dataPublic = ? WHERE id = ?"; 
        Object[] obj = new Object[4];
        obj[0] = vgi.getTitulo();
        obj[1] = vgi.getDescricao();
        obj[2] = vgi.getDataPublic();
        obj[3] = id;
        jdbc.update(sql, obj);
    }

    public void apagarVaga(int id){
		String sql = "DELETE FROM vaga WHERE id = ?";
		Object[] obj = new Object[1];
		obj[0] = id;
		jdbc.update(sql, obj);
	}


    
}
