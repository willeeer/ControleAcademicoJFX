package com.willer.controleacademico.javafx.controllers.aluno;

import com.willer.controleacademico.facade.ControleFacade;
import com.willer.controleacademico.javafx.DisplayManager;
import com.willer.controleacademico.pessoa.dto.Pessoa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class MenuAlunoController
{

   private ControleFacade facade = ControleFacade.getInstance();

   @FXML
   private Button cadastrarAlunoButton;

   @FXML
   private Button exibirAlunoButton;

   @FXML
   private Button removerAlunoButton;

   @FXML
   private Button listarAlunoButton;

   @FXML
   private Button voltarButton;

   @FXML
   private void cadastrar(ActionEvent event) throws IOException
   {
      DisplayManager.abrirCadastroAluno();

      Stage stage = (Stage) cadastrarAlunoButton.getScene().getWindow();
      stage.close();
   }

   @FXML
   private void exibir(ActionEvent event) throws IOException
   {
      String cpf = JOptionPane.showInputDialog("Digite o CPF do Aluno: ");

      if (cpf != null)
      {
         Pessoa p = facade.buscaPessoa(cpf, false);

         if (p != null)
         {
            DisplayManager.abrirExibicaoAluno(p);
            Stage stage = (Stage) exibirAlunoButton.getScene().getWindow();
            stage.close();
         }
         else
         {
            JOptionPane.showMessageDialog(null, "Aluno não encontrado para o CPF informado", "ERRO", JOptionPane.ERROR_MESSAGE);
         }
      }
   }

   @FXML
   private void remover(ActionEvent event) throws IOException
   {
      String cpf = JOptionPane.showInputDialog("Digite o CPF do Aluno: ");

      if (cpf != null)
      {
         Pessoa p = facade.buscaPessoa(cpf, false);

         if (p != null)
         {
            facade.removerPessoa(cpf);
            JOptionPane.showMessageDialog(null, "Aluno Excluido com sucesso!", "Exclusão", JOptionPane.INFORMATION_MESSAGE);

         }
         else
         {
            JOptionPane.showMessageDialog(null, "Aluno não encontrado para o CPF informado", "ERRO", JOptionPane.ERROR_MESSAGE);
         }
      }
   }

   @FXML
   private void listar(ActionEvent event) throws IOException
   {
      DisplayManager.abrirListarAluno();

      Stage stage = (Stage) listarAlunoButton.getScene().getWindow();
      stage.close();
   }

   @FXML
   private void acaoBotaoVoltar(ActionEvent event) throws IOException
   {
      DisplayManager.abrirMainPage();

      Stage stage = (Stage) voltarButton.getScene().getWindow();
      stage.close();
   }

}
