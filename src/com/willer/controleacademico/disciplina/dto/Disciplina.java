package com.willer.controleacademico.disciplina.dto;

public class Disciplina
{

   private String codigo;
   private String nome;
   private Integer cargaHoraria;
   private Integer creditos;
   private Integer periodo;

   public Disciplina(String codigo, String nome, Integer cargaHoraria, Integer creditos, Integer periodo)
   {
      this.codigo = codigo;
      this.nome = nome;
      this.cargaHoraria = cargaHoraria;
      this.creditos = creditos;
      this.periodo = periodo;
   }

   public String getCodigo()
   {
      return codigo;
   }

   public void setCodigo(String codigo)
   {
      this.codigo = codigo;
   }

   public String getNome()
   {
      return nome;
   }

   public void setNome(String nome)
   {
      this.nome = nome;
   }

   public Integer getCargaHoraria()
   {
      return cargaHoraria;
   }

   public void setCargaHoraria(Integer cargaHoraria)
   {
      this.cargaHoraria = cargaHoraria;
   }

   public Integer getCreditos()
   {
      return creditos;
   }

   public void setCreditos(Integer creditos)
   {
      this.creditos = creditos;
   }

   public Integer getPeriodo()
   {
      return periodo;
   }

   public void setPeriodo(Integer periodo)
   {
      this.periodo = periodo;
   }
}
