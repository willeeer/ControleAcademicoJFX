package com.willer.controleacademico.pessoa.dto;

import java.io.Serializable;
import java.util.Date;

public class Pessoa implements Serializable
{

   private String cpf;
   private String nome;
   private Date dataNascimento;
   private String sexo;
   private String telefone;
   private String email;
   private String endereco;
   private Boolean isProfessor;

   public String getCpf()
   {
      return cpf;
   }

   public void setCpf(String cpf)
   {
      this.cpf = cpf;
   }

   public String getNome()
   {
      return nome;
   }

   public void setNome(String nome)
   {
      this.nome = nome;
   }

   public Date getDataNascimento()
   {
      return dataNascimento;
   }

   public void setDataNascimento(Date dataNascimento)
   {
      this.dataNascimento = dataNascimento;
   }

   public String getSexo()
   {
      return sexo;
   }

   public void setSexo(String sexo)
   {
      this.sexo = sexo;
   }

   public String getTelefone()
   {
      return telefone;
   }

   public void setTelefone(String telefone)
   {
      this.telefone = telefone;
   }

   public String getEmail()
   {
      return email;
   }

   public void setEmail(String email)
   {
      this.email = email;
   }

   public String getEndereco()
   {
      return endereco;
   }

   public void setEndereco(String endereco)
   {
      this.endereco = endereco;
   }

   public Boolean isProfessor()
   {
      return isProfessor;
   }

   public void setProfessor(Boolean professor)
   {
      isProfessor = professor;
   }
}
