package com.willer.controleacademico.turma.dto;

import java.util.ArrayList;

public class Turma
{

   private String codigo;
   private String codigoDisciplina;
   private String horario;
   private String cpfProfessor;
   private Integer quantidadeMaxAlunos;
   private Integer periodo;
   private Integer quantidadeAunosMatriculados;
   private ArrayList<String> cpfAlunosMatriculados;

   public boolean excluirAluno(String cpfAluno)
   {
      String cpfAlunoJaExistente = buscarAlunoNaTurma(cpfAluno);
      if (cpfAlunoJaExistente != null)
      {
         cpfAlunosMatriculados.remove(cpfAlunoJaExistente);
         return true;
      }
      return false;
   }

   public boolean adicionarAluno(String cpfAluno)
   {
      String cpfAlunoJaExistente = buscarAlunoNaTurma(cpfAluno);
      if (quantidadeAunosMatriculados.equals(quantidadeMaxAlunos) || cpfAlunoJaExistente != null)
      {
         return false;

      }
      else
      {
         cpfAlunosMatriculados.add(cpfAluno);
         return true;
      }
   }

   public boolean alocarProfessor(String cpfProfessor)
   {
      if (this.cpfProfessor != null)
      {
         return false;
      }
      else
      {
         this.cpfProfessor = cpfProfessor;
         return true;
      }
   }

   public String getCodigo()
   {
      return codigo;
   }

   public String getCodigoDisciplina()
   {
      return codigoDisciplina;
   }

   public String getHorario()
   {
      return horario;
   }

   public String getCpfProfessor()
   {
      return cpfProfessor;
   }

   public Integer getQuantidadeMaxAlunos()
   {
      return quantidadeMaxAlunos;
   }

   public Integer getPeriodo()
   {
      return periodo;
   }

   public Integer getQuantidadeAunosMatriculados()
   {
      return quantidadeAunosMatriculados;
   }

   public ArrayList<String> getCpfAlunosMatriculados()
   {
      return cpfAlunosMatriculados;
   }

   private String buscarAlunoNaTurma(String cpf)
   {
      for (String cpfAluno : this.cpfAlunosMatriculados)
      {
         if (cpfAluno.compareTo(cpf) == 0)
         {
            return cpfAluno;
         }
      }
      return null;
   }
}
