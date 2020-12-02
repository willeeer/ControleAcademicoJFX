package com.willer.controleacademico.javafx.controllers.disciplina;

import com.willer.controleacademico.disciplina.dto.Disciplina;
import com.willer.controleacademico.facade.ControleFacade;
import com.willer.controleacademico.javafx.DisplayManager;
import com.willer.controleacademico.javafx.controllers.IControllersInit;
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

public class ExibirDisciplinaController implements IControllersInit
{

   private static final ControleFacade facade = ControleFacade.getInstance();

   private static final ObservableList<String> listaCargaHoraria = FXCollections.observableArrayList("30", "60");
   private static final ObservableList<String> listaCargaCreditos = FXCollections.observableArrayList("2", "4");

   @FXML
   private Button cadastrarButton;

   @FXML
   private Button voltarButton;

   @FXML
   private TextField nome;

   @FXML
   private TextField codigo;

   @FXML
   private TextField periodo;

   @FXML
   private ChoiceBox<String> cargaHoraria;

   @FXML
   private ChoiceBox<String> creditos;

   @FXML
   private void initialize()
   {
      cargaHoraria.setValue("30");
      cargaHoraria.setItems(listaCargaHoraria);

      creditos.setValue("2");
      creditos.setItems(listaCargaCreditos);
   }

   @FXML
   private void acaoBotaoAlterar(ActionEvent event) throws IOException
   {

      String mensagemErro = validaDados();

      if (mensagemErro == null)
      {
         Disciplina disciplina = new Disciplina();
         disciplina.setNome(nome.getText());
         disciplina.setCodigo(codigo.getText());
         disciplina.setCargaHoraria(Integer.parseInt(cargaHoraria.getValue()));
         disciplina.setCreditos(Integer.parseInt(creditos.getValue()));
         disciplina.setPeriodo(Integer.parseInt(periodo.getText()));

         facade.alterarDisciplina(disciplina);

         JOptionPane.showMessageDialog(null, "Alterado com sucesso!");

         DisplayManager.abrirMenuDisciplina();
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

      if (!ControleAcademicoUtils.isNomeValido(nome.getText()))
      {
         return "Nome inválido, digite apenas letras";
      }

      return null;
   }

   @FXML
   private void acaoBotaoVoltar(ActionEvent event) throws IOException
   {
      DisplayManager.abrirMenuDisciplina();

      Stage stage = (Stage) voltarButton.getScene().getWindow();
      stage.close();
   }

   @Override public void initData(Object o)
   {
      Disciplina d = (Disciplina) o;

      nome.setText(d.getNome());
      codigo.setText(d.getCodigo());
      periodo.setText(d.getPeriodo().toString());
      creditos.setValue(d.getCreditos().toString());
      cargaHoraria.setValue(d.getCargaHoraria().toString());
   }
}
