package com.willer.controleacademico.pessoa.controller;

import com.willer.controleacademico.pessoa.dto.Pessoa;
import com.willer.controleacademico.pessoa.repositorio.IRepositorioPessoa;
import com.willer.controleacademico.utilitarios.ControleAcademicoUtils;

public class PessoaController
{

   public static boolean cadastrarPessoa(Pessoa p, IRepositorioPessoa repositorioPessoa)
   {
      return repositorioPessoa.inserir(p);
   }

   public static void main(String[] args)
   {
      System.out.println(ControleAcademicoUtils.isNomeValido("Willer123"));
      System.out.println(ControleAcademicoUtils.limparEspacosEmBranco("     12312 sdadasdsa      asda sadasdsaadsdas"));
      System.out.println(ControleAcademicoUtils.isCPF("11144477735"));
   }

}
