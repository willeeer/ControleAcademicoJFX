package com.willer.controleacademico.turma.controller;

import com.willer.controleacademico.pessoa.dto.Pessoa;
import com.willer.controleacademico.pessoa.repositorio.IRepositorioPessoa;
import com.willer.controleacademico.turma.dto.Turma;
import com.willer.controleacademico.turma.repositorio.IRepositorioTurma;

import java.util.ArrayList;

public class TurmaController
{

   public static boolean cadastrarTurma(Turma t, IRepositorioTurma repositorioTurma)
   {

      return repositorioTurma.inserir(t);
   }

   public static void alterarTurma(Turma t, IRepositorioTurma repositorioTurma)
   {

      repositorioTurma.alterar(t);

   }

   public static Turma recuperaTurma(String codigoTurma, IRepositorioTurma repositorioTurma)
   {
      return repositorioTurma.buscarPorCodigo(codigoTurma);
   }

   public static boolean excluirTurma(String codigoTurma, IRepositorioTurma repositorioTurma)
   {
      Turma t = repositorioTurma.buscarPorCodigo(codigoTurma);

      if (t.getCpfProfessor() != null || t.getCpfAlunosMatriculados() != null || !t.getCpfAlunosMatriculados().isEmpty())
      {
         //nao é possivel excluir
         return false;
      }
      if (t != null)
      {
         repositorioTurma.excluir(codigoTurma);
         return true;
      }
      else
      {
         return false;
      }

   }

   public static ArrayList<Turma> recuperaTodasTurmas(IRepositorioTurma repositorioTurma)
   {
      return repositorioTurma.recuperaTurmas();
   }

   public static ArrayList<Pessoa> recuperaAlunosTurma(String codigoTurma, IRepositorioTurma repositorioTurma,
            IRepositorioPessoa repositorioPessoa)
   {

      Turma t = repositorioTurma.buscarPorCodigo(codigoTurma);
      ArrayList<Pessoa> alunosDaTurma = new ArrayList<>();

      for (String cpfAluno : t.getCpfAlunosMatriculados())
      {
         alunosDaTurma.add(repositorioPessoa.buscarPorCpf(cpfAluno));
      }

      return alunosDaTurma;
   }

   public static ArrayList<Turma> recuperaTurmasProfessor(String cpfProfessor, IRepositorioTurma repositorioTurma)
   {

      ArrayList<Turma> turmasProfessor = new ArrayList<>();

      ArrayList<Turma> todasTurmas = recuperaTodasTurmas(repositorioTurma);

      for (Turma t : todasTurmas)
      {
         if (t.getCpfProfessor().compareTo(cpfProfessor) == 0)
         {
            turmasProfessor.add(t);
         }
      }

      return turmasProfessor;
   }

   public static ArrayList<Turma> recuperaTurmasAluno(String cpfAluno, IRepositorioTurma repositorioTurma)
   {

      ArrayList<Turma> turmasAluno = new ArrayList<>();

      ArrayList<Turma> todasTurmas = recuperaTodasTurmas(repositorioTurma);

      for (Turma t : todasTurmas)
      {
         if (t.alunoPertenceTurma(cpfAluno))
         {
            turmasAluno.add(t);
         }
      }

      return turmasAluno;
   }

   public static ArrayList<Turma> recuperaTurmasDisciplina(String codigoDisciplina, IRepositorioTurma repositorioTurma)
   {

      ArrayList<Turma> turmasDisciplina = new ArrayList<>();

      ArrayList<Turma> todasTurmas = recuperaTodasTurmas(repositorioTurma);

      for (Turma t : todasTurmas)
      {
         if (t.getCodigoDisciplina().compareTo(codigoDisciplina) == 0)
         {
            turmasDisciplina.add(t);
         }
      }

      return turmasDisciplina;
   }

   public boolean alocarProfessor(String cpfProfessor, Turma t, IRepositorioTurma repositorioTurma)
   {
      if (t.getCpfProfessor() != null)
      {
         return false;
      }
      else
      {
         t.setCpfProfessor(cpfProfessor);
         repositorioTurma.alterar(t);
         return true;
      }
   }

   public static boolean adicionarAlunoTurma(String cpfAluno, Turma t, IRepositorioTurma repositorioTurma)
   {
      String cpfAlunoJaExistente = buscarAlunoNaTurma(cpfAluno, t);

      if (t.getQuantidadeAunosMatriculados().equals(t.getQuantidadeMaxAlunos()) || cpfAlunoJaExistente != null)
      {
         return false;

      }
      else
      {
         t.getCpfAlunosMatriculados().add(cpfAluno);
         repositorioTurma.alterar(t);

         return true;
      }
   }

   public static boolean excluirAlunoTurma(String cpfAluno, Turma t, IRepositorioTurma repositorioTurma)
   {

      String cpfAlunoJaExistente = buscarAlunoNaTurma(cpfAluno, t);
      if (cpfAlunoJaExistente != null)
      {
         t.getCpfAlunosMatriculados().remove(cpfAlunoJaExistente);
         repositorioTurma.alterar(t);

         return true;
      }

      return false;
   }

   private static String buscarAlunoNaTurma(String cpf, Turma t)
   {
      for (String cpfAluno : t.getCpfAlunosMatriculados())
      {
         if (cpfAluno.compareTo(cpf) == 0)
         {
            return cpfAluno;
         }
      }
      return null;
   }

}
