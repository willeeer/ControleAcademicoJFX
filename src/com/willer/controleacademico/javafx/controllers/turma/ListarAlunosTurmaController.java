package com.willer.controleacademico.javafx.controllers.turma;

import com.willer.controleacademico.facade.ControleFacade;
import com.willer.controleacademico.javafx.DisplayManager;
import com.willer.controleacademico.javafx.controllers.IControllersInit;
import com.willer.controleacademico.pessoa.dto.Pessoa;
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

import javax.swing.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ListarAlunosTurmaController implements IControllersInit
{

   private static final ControleFacade facade = ControleFacade.getInstance();

   @FXML
   private Button voltarButton;

   @FXML
   private TableView<Pessoa> tableData;

   @FXML
   public TableColumn<Pessoa, String> nome;

   @FXML
   public TableColumn<Pessoa, String> cpf;

   private ObservableList<Pessoa> listaAlunos = FXCollections.observableArrayList();

   private void loadStudents()
   {
      nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
      cpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));

      tableData.setItems(listaAlunos);
   }

   @FXML
   public void initialize()
   {
      loadStudents();
   }

   @FXML
   private void acaoBotaoVoltar(ActionEvent event) throws IOException
   {
      DisplayManager.abrirMenuTurma();

      Stage stage = (Stage) voltarButton.getScene().getWindow();
      stage.close();
   }

   @Override public void initData(Object o)
   {

      Turma t = (Turma) o;

      listaAlunos.addAll(facade.recuperaAlunosTurma(t.getCodigo()));
      tableData.setItems(listaAlunos);

   }
}
