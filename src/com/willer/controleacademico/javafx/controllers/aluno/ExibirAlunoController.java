package com.willer.controleacademico.javafx.controllers.aluno;

import com.willer.controleacademico.facade.ControleFacade;
import com.willer.controleacademico.javafx.DisplayManager;
import com.willer.controleacademico.javafx.controllers.IControllersInit;
import com.willer.controleacademico.pessoa.dto.Pessoa;
import com.willer.controleacademico.utilitarios.ControleAcademicoUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class ExibirAlunoController implements IControllersInit
{

   private static final ControleFacade facade = ControleFacade.getInstance();

   private static final ObservableList<String> listaSexo = FXCollections.observableArrayList("M", "F", "Outros");

   @FXML
   private Button alterarButton;

   @FXML
   private Button voltarButton;

   @FXML
   private TextField nome;

   @FXML
   private TextField cpf;

   @FXML
   private TextField data;

   @FXML
   private ChoiceBox<String> sexo;

   @FXML
   private TextField telefone;

   @FXML
   private TextField email;

   @FXML
   private TextField endereco;

   @FXML
   private void initialize()
   {
      sexo.setValue("F");
      sexo.setItems(listaSexo);
   }

   public void initData(Object o)
   {
      Pessoa p = (Pessoa) o;

      nome.setText(p.getNome());
      cpf.setText(p.getCpf());
      sexo.setValue(p.getSexo());
      email.setText(p.getEmail());
      telefone.setText(p.getTelefone());
      endereco.setText(p.getEndereco());
      data.setText(p.getDataNascimento());
   }

   @FXML
   private void acaoAlterarButton(ActionEvent event) throws IOException
   {

      String mensagemErro = null;//validaDados();

      if (mensagemErro == null)
      {
         Pessoa aluno = new Pessoa();
         aluno.setNome(nome.getText());
         aluno.setCpf(cpf.getText());
         aluno.setSexo(sexo.getValue().toString());
         aluno.setDataNascimento(data.getText());
         aluno.setTelefone(telefone.getText());
         aluno.setEmail(email.getText());
         aluno.setEndereco(endereco.getText());
         aluno.setProfessor(false);

         facade.alterarPessoa(aluno);

         JOptionPane.showMessageDialog(null, "Alterado com sucesso!");

         DisplayManager.abrirMenuAluno();
         Stage stage = (Stage) alterarButton.getScene().getWindow();
         stage.close();
      }
      else
      {
         JOptionPane.showMessageDialog(null, mensagemErro, "ERRO", JOptionPane.ERROR_MESSAGE);
      }
   }

   private String validaDados()
   {
      if (!ControleAcademicoUtils.isNomeValido(nome.getText()))
      {
         return "Nome inválido, digite apenas letras";
      }

      if (!ControleAcademicoUtils.isCPF(cpf.getText()))
      {
         return "CPF Inválido";
      }

      if (!ControleAcademicoUtils.isTelefoneValido(telefone.getText()))
      {
         return "Telefone Inválido, necessário 11 dígitos.";
      }

      if (!ControleAcademicoUtils.isDataValida(data.getText()))
      {
         return "Data de nascimento inválida";
      }

      if (!ControleAcademicoUtils.isEmailValido(email.getText()))
      {
         return "E-mail inválido";
      }

      return null;
   }

   @FXML
   private void acaoBotaoVoltar(ActionEvent event) throws IOException
   {
      DisplayManager.abrirMenuAluno();

      Stage stage = (Stage) voltarButton.getScene().getWindow();
      stage.close();
   }

}
