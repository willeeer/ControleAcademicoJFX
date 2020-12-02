package com.willer.controleacademico.javafx.controllers.aluno;

import com.willer.controleacademico.facade.ControleFacade;
import com.willer.controleacademico.javafx.DisplayManager;
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

import static com.willer.controleacademico.utilitarios.ControleAcademicoUtils.limparEspacosEmBranco;
import static com.willer.controleacademico.utilitarios.ControleAcademicoUtils.removeCaracteresEspeciais;

public class CadastrarAlunoController
{

   private static final ControleFacade facade = ControleFacade.getInstance();

   private static final ObservableList<String> listaSexo = FXCollections.observableArrayList("M", "F", "Outros");

   @FXML
   private Button cadastrarButton;

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

   @FXML
   private void acaoBotaoCadastrar(ActionEvent event) throws IOException
   {

      String mensagemErro = validaDados();

      if (mensagemErro == null)
      {
         Pessoa aluno = new Pessoa();
         aluno.setNome(limparEspacosEmBranco(nome.getText()));
         aluno.setCpf(removeCaracteresEspeciais(cpf.getText()));
         aluno.setSexo(sexo.getValue());
         aluno.setDataNascimento(data.getText());
         aluno.setTelefone(telefone.getText());
         aluno.setEmail(email.getText());
         aluno.setEndereco(endereco.getText());
         aluno.setProfessor(false);

         facade.cadastrarPessoa(aluno);

         JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");

         DisplayManager.abrirMenuAluno();
         Stage stage = (Stage) cadastrarButton.getScene().getWindow();
         stage.close();
      }
      else
      {
         JOptionPane.showMessageDialog(null, mensagemErro, "ERRO", JOptionPane.ERROR_MESSAGE);
      }
   }

   private String validaDados()
   {

      Pessoa p = facade.buscaPessoa(cpf.getText(), false);

      if (p != null)
      {
         return "Impossivel inserir duas pessoas com o mesmo CPF";
      }

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
