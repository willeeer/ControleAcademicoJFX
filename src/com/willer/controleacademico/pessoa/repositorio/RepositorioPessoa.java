package com.willer.controleacademico.pessoa.repositorio;

import com.willer.controleacademico.pessoa.dto.Pessoa;
import com.willer.controleacademico.utilitarios.ControleAcademicoUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;

public class RepositorioPessoa implements IRepositorioPessoa
{

   private LinkedList<Pessoa> listaPessoas;

   private static File arquivo = new File("ListaPessoas.obj");

   public RepositorioPessoa()
   {
      this.listaPessoas = new LinkedList<>();
   }

   @Override
   public boolean inserir(Pessoa p)
   {
      boolean jaExiste = false;
      if (p != null)
      {

         for (Pessoa busca : this.listaPessoas)
         {
            if (p.getCpf().compareTo(busca.getCpf()) == 0)
            {
               jaExiste = true;
               break;
            }
         }
      }

      if (jaExiste)
      {
         return false;
      }
      else
      {
         listaPessoas.add(p);
         this.salvarArquivo();
         return true;
      }

   }

   @Override
   public Pessoa buscarPorCpf(String cpf)
   {
      for (Pessoa p : listaPessoas)
      {
         if (p.getCpf().compareTo(cpf) == 0)
         {
            return p;
         }
      }

      return null;
   }

   @Override
   public void excluir(String cpf)
   {
      for (Pessoa p : listaPessoas)
      {
         if (p.getCpf().compareTo(cpf) == 0)
         {
            listaPessoas.remove(p);
            this.salvarArquivo();
            break;
         }
      }

   }

   @Override
   public void alterar(Pessoa p)
   {

      for (int i = 0; i < listaPessoas.size(); i++)
      {
         if (p.getCpf().compareTo(listaPessoas.get(i).getCpf()) == 0)
         {
            listaPessoas.set(i, p);
            this.salvarArquivo();
            break;
         }
      }

   }

   @Override
   public ArrayList<Pessoa> recuperaListaAlunos()
   {
      ArrayList<Pessoa> listaAlunos = new ArrayList<>();

      for (Pessoa p : listaPessoas)
      {
         if (!p.isProfessor())
         {
            listaAlunos.add(p);

         }
      }

      return listaAlunos;
   }

   @Override
   public ArrayList<Pessoa> recuperaListaProfessores()
   {
      ArrayList<Pessoa> listaAlunos = new ArrayList<>();

      for (Pessoa p : listaPessoas)
      {
         if (p.isProfessor())
         {
            listaAlunos.add(p);
         }
      }

      return listaAlunos;
   }

   public void carregarArquivo()
   {

      if (listaPessoas == null)
      {
         this.listaPessoas = new LinkedList<>();
      }

      LinkedList<Pessoa> listaCarregada = (LinkedList<Pessoa>) ControleAcademicoUtils.carregarArquivo(arquivo);

      if (listaCarregada != null)
      {
         listaPessoas.addAll(listaCarregada);
      }
   }

   public void salvarArquivo()
   {
      ControleAcademicoUtils.salvarArquivo(arquivo, listaPessoas);
   }

}
