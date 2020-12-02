package com.willer.controleacademico.pessoa.controller;

import com.willer.controleacademico.pessoa.dto.Pessoa;
import com.willer.controleacademico.pessoa.repositorio.IRepositorioPessoa;

import java.util.ArrayList;

public class PessoaController
{

   public static boolean cadastrarPessoa(Pessoa p, IRepositorioPessoa repositorioPessoa)
   {
      return repositorioPessoa.inserir(p);
   }

   public static void alterarPessoa(Pessoa p, IRepositorioPessoa repositorioPessoa)
   {
      if (p != null)
      {
         repositorioPessoa.alterar(p);
      }

   }

   public static ArrayList<Pessoa> recuperarListaAluno(IRepositorioPessoa repositorioPessoa)
   {
      return repositorioPessoa.recuperaListaAlunos();
   }

   public static ArrayList<Pessoa> recuperarListaProfessor(IRepositorioPessoa repositorioPessoa)
   {
      return repositorioPessoa.recuperaListaProfessores();
   }

   public static Pessoa buscarPessoa(String cpf, IRepositorioPessoa repositorioPessoa)
   {
      return repositorioPessoa.buscarPorCpf(cpf);
   }

   public static void removerPessoa(String cpf, IRepositorioPessoa repositorioPessoa)
   {
      repositorioPessoa.excluir(cpf);
   }


}
