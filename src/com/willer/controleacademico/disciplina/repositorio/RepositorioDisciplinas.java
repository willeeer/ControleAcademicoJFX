package com.willer.controleacademico.disciplina.repositorio;

import com.willer.controleacademico.disciplina.dto.Disciplina;
import com.willer.controleacademico.pessoa.dto.Pessoa;
import com.willer.controleacademico.utilitarios.ControleAcademicoUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;

public class RepositorioDisciplinas implements IRepositorioDisciplinas
{

   private LinkedList<Disciplina> listaDisciplinas;

   private static File arquivo = new File("ListaDisciplinas.obj");

   public RepositorioDisciplinas()
   {
      this.listaDisciplinas = new LinkedList<>();
   }

   @Override
   public boolean inserir(Disciplina d)
   {
      boolean jaExiste = false;
      if (d != null)
      {

         for (Disciplina busca : this.listaDisciplinas)
         {
            if (d.getCodigo().compareTo(busca.getCodigo()) == 0)
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
         listaDisciplinas.add(d);
         this.salvarArquivo();
         return true;
      }

   }

   @Override public Disciplina buscarPorCodigo(String codigo)
   {
      for (Disciplina d : listaDisciplinas)
      {
         if (d.getCodigo().compareTo(codigo) == 0)
         {
            return d;
         }
      }

      return null;
   }

   @Override public void excluir(String codigo)
   {

      for (Disciplina d : listaDisciplinas)
      {
         if (d.getCodigo().compareTo(codigo) == 0)
         {
            listaDisciplinas.remove(d);
            this.salvarArquivo();
            break;
         }
      }

   }

   @Override
   public void alterar(Disciplina d)
   {

      for (int i = 0; i < listaDisciplinas.size(); i++)
      {
         if (d.getCodigo().compareTo(listaDisciplinas.get(i).getCodigo()) == 0)
         {
            listaDisciplinas.set(i, d);
            this.salvarArquivo();
            break;
         }
      }

   }

   @Override public ArrayList<Disciplina> recuperaDisciplinas()
   {
      ArrayList<Disciplina> lista = new ArrayList<>();

      for (Disciplina d : this.listaDisciplinas)
      {
         lista.add(d);
      }

      return lista;
   }

   public void carregarArquivo()
   {

      if (listaDisciplinas == null)
      {
         listaDisciplinas = new LinkedList<>();
      }

      LinkedList<Disciplina> listaCarregada = (LinkedList<Disciplina>) ControleAcademicoUtils.carregarArquivo(arquivo);

      if (listaCarregada != null)
      {
         listaDisciplinas.addAll(listaCarregada);
      }
   }

   public void salvarArquivo()
   {
      ControleAcademicoUtils.salvarArquivo(arquivo, listaDisciplinas);
   }
}
