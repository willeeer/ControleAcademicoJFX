package com.willer.controleacademico.javafx.controllers.disciplina;

import com.willer.controleacademico.disciplina.dto.Disciplina;
import com.willer.controleacademico.facade.ControleFacade;
import com.willer.controleacademico.javafx.DisplayManager;
import com.willer.controleacademico.pessoa.dto.Pessoa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class MenuDisciplinaController
{

   private ControleFacade facade = ControleFacade.getInstance();

   @FXML
   private Button cadastrarDisciplinaButton;

   @FXML
   private Button exibirDisciplinaButton;

   @FXML
   private Button removerDisciplinaButton;

   @FXML
   private Button listarDisciplinaButton;

   @FXML
   private Button voltarButton;

   @FXML
   private void cadastrar(ActionEvent event) throws IOException
   {
      DisplayManager.abrirCadastroDisciplina();

      Stage stage = (Stage) cadastrarDisciplinaButton.getScene().getWindow();
      stage.close();
   }

   @FXML
   private void exibir(ActionEvent event) throws IOException
   {
      String codigo = JOptionPane.showInputDialog("Digite o Código da Disciplina: ");

      if (codigo != null)
      {
         Disciplina d = facade.buscaDisciplina(codigo);

         if (d != null)
         {
            DisplayManager.abrirExibicaoDisciplina(d);
            Stage stage = (Stage) exibirDisciplinaButton.getScene().getWindow();
            stage.close();
         }
         else
         {
            JOptionPane.showMessageDialog(null, "Disciplina não encontrada para o Código informado", "ERRO", JOptionPane.ERROR_MESSAGE);
         }
      }
   }

   @FXML
   private void remover(ActionEvent event) throws IOException
   {
      String codigo = JOptionPane.showInputDialog("Digite o Código da Disciplina: ");

      if (codigo != null)
      {
         Disciplina d = facade.buscaDisciplina(codigo);

         if (d != null)
         {
            boolean removido = facade.removerDisciplina(codigo);
            if (removido)
            {
               JOptionPane.showMessageDialog(null, "Disciplina Excluida com sucesso!", "Exclusão", JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
               JOptionPane.showMessageDialog(null, "Disciplina não pode ser excluída pois está vinculada a uma turma", "ERRO",
                        JOptionPane.ERROR_MESSAGE);
            }
         }
         else
         {
            JOptionPane.showMessageDialog(null, "Disciplina não encontrada para o Codigo informado", "ERRO", JOptionPane.ERROR_MESSAGE);
         }
      }
   }

   @FXML
   private void listar(ActionEvent event) throws IOException
   {
      DisplayManager.abrirListarDisciplina();

      Stage stage = (Stage) listarDisciplinaButton.getScene().getWindow();
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
