package com.willer.controleacademico.turma.repositorio;

import com.willer.controleacademico.turma.dto.Turma;

import java.util.ArrayList;

public interface IRepositorioTurma
{

   boolean inserir(Turma t);

   Turma buscarPorCodigo(String codigo);

   void excluir(String codigo);

   void alterar(Turma t);

   ArrayList<Turma> recuperaTurmas();

}
