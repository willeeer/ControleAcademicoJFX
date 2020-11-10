package com.willer.controleacademico.disciplina.repositorio;

import com.willer.controleacademico.disciplina.dto.Disciplina;
import com.willer.controleacademico.pessoa.dto.Pessoa;
import com.willer.controleacademico.utilitarios.ControleAcademicoUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RepositorioDisciplinas implements IRepositorioDisciplinas
{

   private static LinkedList<Disciplina> listaDisciplinas;

   private static File arquivo = new File("ListaDisciplinas.obj");

   public RepositorioDisciplinas()
   {
      this.listaDisciplinas = new LinkedList<>();
   }

   @Override public boolean inserir(Disciplina p)
   {
      return false;
   }

   @Override public Disciplina buscarPorCodigo(String codigo)
   {
      return null;
   }

   @Override public void excluir(String codigo)
   {

   }

   @Override
   public void alterar(Disciplina p)
   {

   }

   @Override public ArrayList<Disciplina> recuperaListaAlunos()
   {
      return null;
   }

   @Override public ArrayList<Disciplina> recuperaListaProfessores()
   {
      return null;
   }

   public void carregarArquivo()
   {

      listaDisciplinas = (LinkedList<Disciplina>) ControleAcademicoUtils.carregarArquivo(arquivo);
   }

   public static void salvarArquivo()
   {
      ControleAcademicoUtils.salvarArquivo(arquivo, listaDisciplinas);
   }
}
