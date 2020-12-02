package com.willer.controleacademico.turma.dto;

import java.io.Serializable;
import java.util.ArrayList;

public class Turma implements Serializable
{

   private String codigo;
   private String codigoDisciplina;
   private String horario;
   private String cpfProfessor;
   private Integer quantidadeMaxAlunos;
   private Integer periodo;
   private Integer quantidadeAunosMatriculados;
   private ArrayList<String> cpfAlunosMatriculados;

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
      if (cpfAlunosMatriculados != null)
      {
         return cpfAlunosMatriculados.size();
      }

      return 0;
   }

   public ArrayList<String> getCpfAlunosMatriculados()
   {
      return cpfAlunosMatriculados;
   }

   public void setCodigo(String codigo)
   {
      this.codigo = codigo;
   }

   public void setCodigoDisciplina(String codigoDisciplina)
   {
      this.codigoDisciplina = codigoDisciplina;
   }

   public void setHorario(String horario)
   {
      this.horario = horario;
   }

   public void setCpfProfessor(String cpfProfessor)
   {
      this.cpfProfessor = cpfProfessor;
   }

   public void setQuantidadeMaxAlunos(Integer quantidadeMaxAlunos)
   {
      this.quantidadeMaxAlunos = quantidadeMaxAlunos;
   }

   public void setPeriodo(Integer periodo)
   {
      this.periodo = periodo;
   }

   public void setCpfAlunosMatriculados(ArrayList<String> cpfAlunosMatriculados)
   {
      this.cpfAlunosMatriculados = cpfAlunosMatriculados;
   }

   public void setQuantidadeAunosMatriculados(Integer quantidadeAunosMatriculados)
   {
      this.quantidadeAunosMatriculados = quantidadeAunosMatriculados;
   }

   public boolean alunoPertenceTurma(String cpfAluno)
   {

      for (String cpf : cpfAlunosMatriculados)
      {
         if (cpfAluno.compareTo(cpf) == 0)
         {
            return true;
         }
      }
      return false;
   }
}
