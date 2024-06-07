package com.fwave.fwave.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.fwave.fwave.Model.Vaga;
import com.fwave.fwave.Model.VagaService;

@Controller
public class indexController {

    @Autowired private ApplicationContext context;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/cadastrar")
    public String cadastrar(Model model){
        model.addAttribute("vaga", new Vaga());
        return "cadastro";
    }

    @PostMapping("/cadastrar")
    public String cadastrar(Model model, @ModelAttribute Vaga vgi){
        VagaService vg = context.getBean(VagaService.class);
		vg.inserirVaga(vgi);
        return "sucesso";

    }

    @GetMapping("/listar")
    public String listar(Model model){
        VagaService vg = context.getBean(VagaService.class);
        List<Map<String,Object>> lista = vg.listarVagas();
        model.addAttribute("lista", lista);
        return "lista";
    }

    @GetMapping("/recrutador")
    public String recrutador(){
        return "recrutador";
    }

    @GetMapping("/atualizar/{id}")
    public String atualizar(@PathVariable("id") int id, Model model){
        VagaService vg = context.getBean(VagaService.class);
        Map<String,Object> vaga = vg.obterVaga(id).get(0);
        String titulo = (String) vaga.get("titulo");
        String descricao = (String) vaga.get("descricao");
        LocalDate dataPublic = (LocalDate) vaga.get("dataPublic");
        model.addAttribute("vaga", new Vaga(titulo,descricao, dataPublic));
        model.addAttribute("titulo", titulo);
        model.addAttribute("descricao", descricao);
        model.addAttribute("dataPublic", dataPublic);
        return "atualiza";
    }

    @PostMapping("/atualizar/{id}")
    public String atualizar(@PathVariable("id") int id
        , Model model
        , @ModelAttribute Vaga vgi){
            VagaService vg = context.getBean(VagaService.class);
            vg.atualizarVaga(id, vgi);
            return "redirect:/listar";
        }
}
