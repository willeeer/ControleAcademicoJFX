package com.willer.controleacademico.disciplina.controller;

import com.willer.controleacademico.disciplina.dto.Disciplina;
import com.willer.controleacademico.disciplina.repositorio.IRepositorioDisciplinas;
import com.willer.controleacademico.pessoa.repositorio.IRepositorioPessoa;

public class DisciplinaController
{

   public void alterar(Disciplina disciplina, IRepositorioDisciplinas repositorioDisciplinas)
   {

      repositorioDisciplinas.alterar(disciplina);

   }

   public Disciplina buscar(String codigo, IRepositorioDisciplinas repositorioDisciplinas)
   {

      return repositorioDisciplinas.buscarPorCodigo(codigo);

   }
}
