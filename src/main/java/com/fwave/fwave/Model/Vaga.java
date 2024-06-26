package com.fwave.fwave.Model;

import java.time.LocalDate;

public class Vaga {
    
    private int id;
    private String titulo, descricao; 
    private LocalDate dataPublic;

    public Vaga(){

    }

    public Vaga(String titulo, String descricao, LocalDate dataPublic){
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataPublic = dataPublic;
       
    }

    public Vaga(int id, String titulo, String descricao, LocalDate dataPublic){
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataPublic = dataPublic;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public void setdataPublic(LocalDate dataPublic){
        this.dataPublic = dataPublic;
    }

    public int getId(){
        return id;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getDescricao(){
        return descricao;
    }

    public LocalDate getDataPublic(){
        return dataPublic;
    }

}
