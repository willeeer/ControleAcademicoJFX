package com.willer.controleacademico.pessoa.repositorio;

import com.willer.controleacademico.pessoa.dto.Pessoa;

import java.util.ArrayList;

public interface IRepositorioPessoa
{

   boolean inserir(Pessoa p);

   Pessoa buscarPorCpf(String cpf);

   void excluir(String cpf);

   void alterar(String cpf);

   ArrayList<Pessoa> recuperaListaAlunos();

   ArrayList<Pessoa> recuperaListaProfessores();

}
