package com.willer.controleacademico.disciplina.repositorio;

import com.willer.controleacademico.disciplina.dto.Disciplina;

import java.util.ArrayList;

public interface IRepositorioDisciplinas
{

   boolean inserir(Disciplina p);

   Disciplina buscarPorCodigo(String codigo);

   void excluir(String codigo);

   void alterar(Disciplina p);

   ArrayList<Disciplina> recuperaListaAlunos();

   ArrayList<Disciplina> recuperaListaProfessores();

}
