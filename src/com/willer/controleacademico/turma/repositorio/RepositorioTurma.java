package com.willer.controleacademico.turma.repositorio;

import com.willer.controleacademico.disciplina.dto.Disciplina;
import com.willer.controleacademico.turma.dto.Turma;
import com.willer.controleacademico.utilitarios.ControleAcademicoUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;

public class RepositorioTurma implements IRepositorioTurma
{

   private LinkedList<Turma> listaTurmas;

   private static File arquivo = new File("ListaTurmas.obj");

   public RepositorioTurma()
   {
      this.listaTurmas = new LinkedList<>();
   }

   @Override
   public boolean inserir(Turma d)
   {
      boolean jaExiste = false;
      if (d != null)
      {

         for (Turma busca : this.listaTurmas)
         {
            if (d.getCodigo().compareTo(busca.getCodigo()) == 0 && d.getCodigoDisciplina().compareTo(busca.getCodigoDisciplina()) == 0)
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
         listaTurmas.add(d);
         salvarArquivo();
         return true;
      }

   }

   @Override
   public Turma buscarPorCodigo(String codigo)
   {
      for (Turma d : listaTurmas)
      {
         if (d.getCodigo().compareTo(codigo) == 0)
         {
            return d;
         }
      }

      return null;
   }

   @Override
   public void excluir(String codigo)
   {

      for (Turma d : listaTurmas)
      {
         if (d.getCodigo().compareTo(codigo) == 0)
         {
            listaTurmas.remove(d);
            salvarArquivo();
            break;
         }
      }

   }

   @Override
   public void alterar(Turma d)
   {

      for (int i = 0; i < listaTurmas.size(); i++)
      {
         if (d.getCodigo().compareTo(listaTurmas.get(i).getCodigo()) == 0)
         {
            listaTurmas.set(i, d);
            salvarArquivo();
            break;
         }
      }

   }

   @Override
   public ArrayList<Turma> recuperaTurmas()
   {
      return new ArrayList<>(this.listaTurmas);
   }

   public void carregarArquivo()
   {

      if (listaTurmas == null)
      {
         listaTurmas = new LinkedList<>();
      }

      LinkedList<Turma> listaCarregada = (LinkedList<Turma>) ControleAcademicoUtils.carregarArquivo(arquivo);

      if (listaCarregada != null)
      {
         listaTurmas.addAll(listaCarregada);
      }
   }

   public void salvarArquivo()
   {
      ControleAcademicoUtils.salvarArquivo(arquivo, listaTurmas);
   }
}
