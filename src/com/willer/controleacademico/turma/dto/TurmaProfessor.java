package com.willer.controleacademico.turma.dto;

public class TurmaProfessor
{

   private String codigoDisciplina;
   private String nomeDisciplina;
   private String codigoTurma;
   private String horario;
   private String nomeProfessor;

   public String getCodigoDisciplina()
   {
      return codigoDisciplina;
   }

   public void setCodigoDisciplina(String codigoDisciplina)
   {
      this.codigoDisciplina = codigoDisciplina;
   }

   public String getNomeDisciplina()
   {
      return nomeDisciplina;
   }

   public void setNomeDisciplina(String nomeDisciplina)
   {
      this.nomeDisciplina = nomeDisciplina;
   }

   public String getCodigoTurma()
   {
      return codigoTurma;
   }

   public void setCodigoTurma(String codigoTurma)
   {
      this.codigoTurma = codigoTurma;
   }

   public String getHorario()
   {
      return horario;
   }

   public void setHorario(String horario)
   {
      this.horario = horario;
   }

   public String getNomeProfessor()
   {
      return nomeProfessor;
   }

   public void setNomeProfessor(String nomeProfessor)
   {
      this.nomeProfessor = nomeProfessor;
   }
}
