package com.willer.controleacademico.facade;

import com.willer.controleacademico.disciplina.controller.DisciplinaController;
import com.willer.controleacademico.disciplina.dto.Disciplina;
import com.willer.controleacademico.disciplina.repositorio.RepositorioDisciplinas;
import com.willer.controleacademico.pessoa.controller.PessoaController;
import com.willer.controleacademico.pessoa.dto.Pessoa;
import com.willer.controleacademico.pessoa.repositorio.RepositorioPessoa;
import com.willer.controleacademico.turma.controller.TurmaController;
import com.willer.controleacademico.turma.dto.Turma;
import com.willer.controleacademico.turma.repositorio.RepositorioTurma;

import java.util.ArrayList;

public class ControleFacade
{

   private static ControleFacade instancia;

   private static RepositorioPessoa repositorioPessoa;

   private static RepositorioDisciplinas repositorioDisciplinas;

   private static RepositorioTurma repositorioTurma;

   public static ControleFacade getInstance()
   {

      if (instancia == null)
      {
         repositorioPessoa = new RepositorioPessoa();
         repositorioPessoa.carregarArquivo();

         repositorioDisciplinas = new RepositorioDisciplinas();
         repositorioDisciplinas.carregarArquivo();

         repositorioTurma = new RepositorioTurma();
         repositorioTurma.carregarArquivo();

         instancia = new ControleFacade();
      }
      return instancia;
   }

   //Metodos para Pessoa

   public boolean cadastrarPessoa(Pessoa p)
   {
      return PessoaController.cadastrarPessoa(p, repositorioPessoa);
   }

   public ArrayList<Pessoa> recuperaListaPessoas(boolean isProfessor)
   {
      if (isProfessor)
      {
         return PessoaController.recuperarListaProfessor(repositorioPessoa);

      }
      else
      {
         return PessoaController.recuperarListaAluno(repositorioPessoa);
      }
   }

   public Pessoa buscaPessoa(String cpf, boolean isProfessor)
   {

      Pessoa retornoPessoa = PessoaController.buscarPessoa(cpf, repositorioPessoa);

      if (retornoPessoa != null)
      {
         if (isProfessor == retornoPessoa.isProfessor())
         {
            return retornoPessoa;
         }
         else
         {
            return null;
         }
      }

      return retornoPessoa;
   }

   public void removerPessoa(String cpf)
   {
      PessoaController.removerPessoa(cpf, repositorioPessoa);
   }

   public void alterarPessoa(Pessoa p)
   {
      PessoaController.alterarPessoa(p, repositorioPessoa);
   }

   //Metodos para Disciplina

   public boolean cadastrarDisciplina(Disciplina d)
   {
      return DisciplinaController.cadastrar(d, repositorioDisciplinas);
   }

   public ArrayList<Disciplina> recuperaListaDisciplina()
   {
      return DisciplinaController.recuperaDisiplinas(repositorioDisciplinas);
   }

   public Disciplina buscaDisciplina(String codigo)
   {
      return DisciplinaController.buscarDisciplina(codigo, repositorioDisciplinas);
   }

   public boolean removerDisciplina(String codigo)
   {
      return DisciplinaController.removerDisciplina(codigo, repositorioDisciplinas, repositorioTurma);
   }

   public void alterarDisciplina(Disciplina d)
   {
      DisciplinaController.alterar(d, repositorioDisciplinas);
   }

   //Metodos para Turma

   public boolean cadastrarTurma(Turma t)
   {
      return TurmaController.cadastrarTurma(t, repositorioTurma);
   }

   public boolean removerTurma(String codigo)
   {
      return TurmaController.excluirTurma(codigo, repositorioTurma);
   }

   public void alterarTurma(Turma t)
   {
      TurmaController.alterarTurma(t, repositorioTurma);
   }

   public Turma buscaTurma(String codigo)
   {
      return TurmaController.recuperaTurma(codigo, repositorioTurma);
   }

   public ArrayList<Turma> recuperaTodasTurmas()
   {
      return TurmaController.recuperaTodasTurmas(repositorioTurma);
   }

   public ArrayList<Pessoa> recuperaAlunosTurma(String codigo)
   {
      return TurmaController.recuperaAlunosTurma(codigo, repositorioTurma, repositorioPessoa);
   }

      public ArrayList<Turma> recuperaTurmasProfessor(String cpfProfessor)
   {
      return TurmaController.recuperaTurmasProfessor(cpfProfessor, repositorioTurma);
   }

   public ArrayList<Turma> recuperaTurmasDisciplina(String codigoDisciplina)
   {
      return TurmaController.recuperaTurmasDisciplina(codigoDisciplina, repositorioTurma);
   }

   public ArrayList<Turma> recuperaTurmasAluno(String cpfAluno)
   {
      return TurmaController.recuperaTurmasAluno(cpfAluno, repositorioTurma);
   }

}
