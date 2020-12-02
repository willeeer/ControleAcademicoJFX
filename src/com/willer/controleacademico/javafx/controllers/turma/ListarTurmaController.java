package com.willer.controleacademico.javafx.controllers.turma;

import com.willer.controleacademico.facade.ControleFacade;
import com.willer.controleacademico.javafx.DisplayManager;
import com.willer.controleacademico.turma.dto.Turma;
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

public class ListarTurmaController implements Initializable
{

   @FXML
   private Button voltarButton;

   @FXML
   private TableView<Turma> tableData;

   @FXML
   public TableColumn<Turma, String> codigoTurma;

   @FXML
   public TableColumn<Turma, String> codigoDisciplina;

   @FXML
   public TableColumn<Turma, String> horario;

   @FXML
   public TableColumn<Turma, String> qtdAlunos;

   @FXML
   public TableColumn<Turma, String> qtdMax;

   @FXML
   public TableColumn<Turma, String> periodo;

   @FXML
   public TableColumn<Turma, String> cpfProf;

   private ObservableList<Turma> listaTurmas = FXCollections.observableArrayList();

   private void loadStudents()
   {
      codigoTurma.setCellValueFactory(new PropertyValueFactory<>("codigo"));
      codigoDisciplina.setCellValueFactory(new PropertyValueFactory<>("codigoDisciplina"));
      horario.setCellValueFactory(new PropertyValueFactory<>("horario"));
      qtdAlunos.setCellValueFactory(new PropertyValueFactory<>("quantidadeAunosMatriculados"));
      qtdMax.setCellValueFactory(new PropertyValueFactory<>("quantidadeMaxAlunos"));
      periodo.setCellValueFactory(new PropertyValueFactory<>("periodo"));
      cpfProf.setCellValueFactory(new PropertyValueFactory<>("cpfProfessor"));

      tableData.setItems(listaTurmas);
   }

   @Override
   public void initialize(URL location, ResourceBundle resources)
   {
      ControleFacade facade = ControleFacade.getInstance();
      ArrayList<Turma> turmas = facade.recuperaTodasTurmas();

      if (listaTurmas != null)
      {
         listaTurmas.addAll(turmas);
      }

      loadStudents();
   }

   @FXML
   private void acaoBotaoVoltar(ActionEvent event) throws IOException
   {
      DisplayManager.abrirMenuTurma();

      Stage stage = (Stage) voltarButton.getScene().getWindow();
      stage.close();
   }
}
