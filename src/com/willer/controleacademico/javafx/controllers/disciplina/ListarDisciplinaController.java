package com.willer.controleacademico.javafx.controllers.disciplina;

import com.willer.controleacademico.disciplina.dto.Disciplina;
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

public class ListarDisciplinaController implements Initializable
{

   @FXML
   private Button voltarButton;

   @FXML
   private TableView<Disciplina> tableData;

   @FXML
   public TableColumn<Disciplina, Integer> nome;

   @FXML
   public TableColumn<Disciplina, String> codigo;

   @FXML
   public TableColumn<Disciplina, String> credito;

   @FXML
   public TableColumn<Disciplina, String> carga;

   @FXML
   public TableColumn<Disciplina, String> periodo;

   private ObservableList<Disciplina> listaDisciplinas = FXCollections.observableArrayList();

   private void loadStudents()
   {
      nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
      codigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
      credito.setCellValueFactory(new PropertyValueFactory<>("cargaHoraria"));
      carga.setCellValueFactory(new PropertyValueFactory<>("creditos"));
      periodo.setCellValueFactory(new PropertyValueFactory<>("periodo"));

      tableData.setItems(listaDisciplinas);
   }

   @Override
   public void initialize(URL location, ResourceBundle resources)
   {
      ControleFacade facade = ControleFacade.getInstance();
      ArrayList<Disciplina> disciplinas = facade.recuperaListaDisciplina();

      if (listaDisciplinas != null)
      {
         listaDisciplinas.addAll(disciplinas);
      }

      loadStudents();
   }

   @FXML
   private void acaoBotaoVoltar(ActionEvent event) throws IOException
   {
      DisplayManager.abrirMenuDisciplina();

      Stage stage = (Stage) voltarButton.getScene().getWindow();
      stage.close();
   }
}
