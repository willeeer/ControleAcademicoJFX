package com.willer.controleacademico.javafx.controllers.professor;

import com.willer.controleacademico.facade.ControleFacade;
import com.willer.controleacademico.javafx.DisplayManager;
import com.willer.controleacademico.pessoa.dto.Pessoa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ListarProfessorController implements Initializable
{

   @FXML
   private Button voltarButton;

   @FXML
   private TableView<Pessoa> tableData;

   @FXML
   public TableColumn<Pessoa, Integer> nome;

   @FXML
   public TableColumn<Pessoa, String> cpf;

   @FXML
   public TableColumn<Pessoa, String> sexo;

   @FXML
   public TableColumn<Pessoa, String> telefone;

   @FXML
   public TableColumn<Pessoa, String> email;

   @FXML
   public TableColumn<Pessoa, String> endereco;

   @FXML
   public TableColumn<Pessoa, String> data;

   private ObservableList<Pessoa> listaAlunos = FXCollections.observableArrayList();

   private void loadStudents()
   {
      nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
      cpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
      sexo.setCellValueFactory(new PropertyValueFactory<>("sexo"));
      email.setCellValueFactory(new PropertyValueFactory<>("email"));
      telefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
      data.setCellValueFactory(new PropertyValueFactory<>("dataNascimento"));
      endereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));

      tableData.setItems(listaAlunos);
   }

   @Override
   public void initialize(URL location, ResourceBundle resources)
   {
      ControleFacade facade = ControleFacade.getInstance();
      ArrayList<Pessoa> professores = facade.recuperaListaPessoas(true);

      if (listaAlunos != null)
      {
         listaAlunos.addAll(professores);
      }

      loadStudents();
   }

   @FXML
   private void acaoBotaoVoltar(ActionEvent event) throws IOException
   {
      DisplayManager.abrirMenuProfessor();

      Stage stage = (Stage) voltarButton.getScene().getWindow();
      stage.close();
   }
}
