package com.willer.controleacademico.disciplina.controller;

import com.willer.controleacademico.disciplina.dto.Disciplina;
import com.willer.controleacademico.disciplina.repositorio.IRepositorioDisciplinas;
import com.willer.controleacademico.turma.controller.TurmaController;
import com.willer.controleacademico.turma.repositorio.IRepositorioTurma;

import java.util.ArrayList;

public class DisciplinaController
{

   public static boolean cadastrar(Disciplina disciplina, IRepositorioDisciplinas repositorioDisciplinas)
   {
      //verifica se ja existe a disicplina
      if (buscarDisciplina(disciplina.getCodigo(), repositorioDisciplinas) == null)
      {
         return repositorioDisciplinas.inserir(disciplina);
      }
      else
      {
         return false;
      }
   }

   public static void alterar(Disciplina disciplina, IRepositorioDisciplinas repositorioDisciplinas)
   {
      repositorioDisciplinas.alterar(disciplina);
   }

   public static boolean removerDisciplina(String codigoDisciplina, IRepositorioDisciplinas repositorioDisciplinas,
            IRepositorioTurma repositorioTurma)
   {

      if (TurmaController.recuperaTurmasDisciplina(codigoDisciplina, repositorioTurma).isEmpty())
      {
         repositorioDisciplinas.excluir(codigoDisciplina);
         return true;
      }

      return false;

   }

   public static Disciplina buscarDisciplina(String codigo, IRepositorioDisciplinas repositorioDisciplinas)
   {
      return repositorioDisciplinas.buscarPorCodigo(codigo);
   }

   public static ArrayList<Disciplina> recuperaDisiplinas(IRepositorioDisciplinas repositorioDisciplinas)
   {
      return repositorioDisciplinas.recuperaDisciplinas();
   }
}
