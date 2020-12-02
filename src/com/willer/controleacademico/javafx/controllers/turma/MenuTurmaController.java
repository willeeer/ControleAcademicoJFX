package com.willer.controleacademico.javafx.controllers.turma;

import com.willer.controleacademico.disciplina.dto.Disciplina;
import com.willer.controleacademico.facade.ControleFacade;
import com.willer.controleacademico.javafx.DisplayManager;
import com.willer.controleacademico.pessoa.dto.Pessoa;
import com.willer.controleacademico.turma.dto.Turma;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class MenuTurmaController
{

   private ControleFacade facade = ControleFacade.getInstance();

   @FXML
   private Button cadastrarButton;

   @FXML
   private Button exibirButton;

   @FXML
   private Button removerButton;

   @FXML
   private Button listarButton;

   @FXML
   private Button listarAlunosButton;

   @FXML
   private Button listarProfessorButton;

   @FXML
   private Button listarTurmasDisciplinaButton;

   @FXML
   private Button listarTurmasAlunoButton;

   @FXML
   private Button voltarButton;

   @FXML
   private void cadastrar(ActionEvent event) throws IOException
   {
      DisplayManager.abrirCadastroTurma();

      Stage stage = (Stage) cadastrarButton.getScene().getWindow();
      stage.close();
   }

   @FXML
   private void exibir(ActionEvent event) throws IOException
   {
      String codigo = JOptionPane.showInputDialog("Digite o Código da Turma: ");

      if (codigo != null)
      {
         Turma t = facade.buscaTurma(codigo);

         if (t != null)
         {
            DisplayManager.abrirExibicaoTurma(t);
            Stage stage = (Stage) exibirButton.getScene().getWindow();
            stage.close();
         }
         else
         {
            JOptionPane.showMessageDialog(null, "Turma não encontrada para o código informado", "ERRO", JOptionPane.ERROR_MESSAGE);
         }
      }
   }

   @FXML
   private void remover(ActionEvent event) throws IOException
   {
      String codigo = JOptionPane.showInputDialog("Digite o Código da Turma: ");

      if (codigo != null)
      {
         Turma t = facade.buscaTurma(codigo);

         if (t != null)
         {
            boolean removido = facade.removerTurma(codigo);

            if (removido)
            {
               JOptionPane.showMessageDialog(null, "Turma Excluida com sucesso!", "Exclusão", JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
               JOptionPane.showMessageDialog(null, "Impossível remover Turma pois existem Alunos ou professor alocados.", "ERRO",
                        JOptionPane.ERROR_MESSAGE);
            }
         }
         else
         {
            JOptionPane.showMessageDialog(null, "Turma não encontrada para o código informado", "ERRO", JOptionPane.ERROR_MESSAGE);
         }
      }
   }

   @FXML
   private void listar(ActionEvent event) throws IOException
   {
      DisplayManager.abrirListarTurma();

      Stage stage = (Stage) listarButton.getScene().getWindow();
      stage.close();
   }

   @FXML
   private void listarAlunos(ActionEvent event) throws IOException
   {
      Turma t = buscarTurma();

      if (t != null)
      {
         DisplayManager.abrirListarAlunosTurma(t);

         Stage stage = (Stage) listarAlunosButton.getScene().getWindow();
         stage.close();
      }
   }

   @FXML
   private void listarTurmasProfessor(ActionEvent event) throws IOException
   {
      String cpf = JOptionPane.showInputDialog("Digite o CPF do Professor: ");

      if (cpf != null)
      {
         Pessoa p = facade.buscaPessoa(cpf, true);

         if (p != null)
         {
            DisplayManager.abrirListarTumasProfessor(p);
            Stage stage = (Stage) listarProfessorButton.getScene().getWindow();
            stage.close();
         }
         else
         {
            JOptionPane.showMessageDialog(null, "Professor não encontrado para o CPF informado", "ERRO", JOptionPane.ERROR_MESSAGE);
         }
      }
   }

   @FXML
   private void listarTurmasDisciplina(ActionEvent event) throws IOException
   {
      String codigo = JOptionPane.showInputDialog("Digite o Código da Disciplina: ");

      if (codigo != null)
      {
         Disciplina d = facade.buscaDisciplina(codigo);

         if (d != null)
         {
            DisplayManager.abrirListarTumasDisciplina(d);
            Stage stage = (Stage) listarTurmasDisciplinaButton.getScene().getWindow();
            stage.close();
         }
         else
         {
            JOptionPane.showMessageDialog(null, "Disciplina não encontrada para o Código informado", "ERRO", JOptionPane.ERROR_MESSAGE);
         }
      }
   }

   @FXML
   private void listarTurmasAluno(ActionEvent event) throws IOException
   {
      String cpf = JOptionPane.showInputDialog("Digite o CPF do Aluno: ");

      if (cpf != null)
      {
         Pessoa p = facade.buscaPessoa(cpf, false);

         if (p != null)
         {
            DisplayManager.abrirListarTumasAluno(p);
            Stage stage = (Stage) listarProfessorButton.getScene().getWindow();
            stage.close();
         }
         else
         {
            JOptionPane.showMessageDialog(null, "Aluno não encontrado para o CPF informado", "ERRO", JOptionPane.ERROR_MESSAGE);
         }
      }
   }

   @FXML
   private void acaoBotaoVoltar(ActionEvent event) throws IOException
   {
      DisplayManager.abrirMainPage();

      Stage stage = (Stage) voltarButton.getScene().getWindow();
      stage.close();
   }

   private Turma buscarTurma()
   {

      String codigo = JOptionPane.showInputDialog("Digite o Código da Turma: ");

      if (codigo != null)
      {
         return facade.buscaTurma(codigo);
      }

      return null;
   }

}
