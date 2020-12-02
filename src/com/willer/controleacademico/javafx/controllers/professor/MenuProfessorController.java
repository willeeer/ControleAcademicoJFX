package com.willer.controleacademico.javafx.controllers.professor;

import com.willer.controleacademico.facade.ControleFacade;
import com.willer.controleacademico.javafx.DisplayManager;
import com.willer.controleacademico.pessoa.dto.Pessoa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class MenuProfessorController
{

   private ControleFacade facade = ControleFacade.getInstance();

   @FXML
   private Button cadastrarProfessorButton;

   @FXML
   private Button exibirProfessorButton;

   @FXML
   private Button removerProfessorButton;

   @FXML
   private Button listarProfessorButton;

   @FXML
   private Button voltarButton;

   @FXML
   private void cadastrar(ActionEvent event) throws IOException
   {
      DisplayManager.abrirCadastroProfessor();

      Stage stage = (Stage) cadastrarProfessorButton.getScene().getWindow();
      stage.close();
   }

   @FXML
   private void exibir(ActionEvent event) throws IOException
   {
      String cpf = JOptionPane.showInputDialog("Digite o CPF do Professor: ");

      if (cpf != null)
      {
         Pessoa p = facade.buscaPessoa(cpf, true);

         if (p != null)
         {
            DisplayManager.abrirExibicaoProfessor(p);
            Stage stage = (Stage) exibirProfessorButton.getScene().getWindow();
            stage.close();
         }
         else
         {
            JOptionPane.showMessageDialog(null, "Professor não encontrado para o CPF informado", "ERRO", JOptionPane.ERROR_MESSAGE);
         }
      }
   }

   @FXML
   private void remover(ActionEvent event) throws IOException
   {
      String cpf = JOptionPane.showInputDialog("Digite o CPF do Professor: ");

      if (cpf != null)
      {
         Pessoa p = facade.buscaPessoa(cpf, true);

         if (p != null)
         {
            facade.removerPessoa(cpf);
            JOptionPane.showMessageDialog(null, "Professor Excluido com sucesso!", "Exclusão", JOptionPane.INFORMATION_MESSAGE);

         }
         else
         {
            JOptionPane.showMessageDialog(null, "Professor não encontrado para o CPF informado", "ERRO", JOptionPane.ERROR_MESSAGE);
         }
      }
   }

   @FXML
   private void listar(ActionEvent event) throws IOException
   {
      DisplayManager.abrirListarProfessor();

      Stage stage = (Stage) listarProfessorButton.getScene().getWindow();
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
