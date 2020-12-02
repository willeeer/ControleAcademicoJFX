package com.willer.controleacademico.javafx.controllers.turma;

import com.willer.controleacademico.facade.ControleFacade;
import com.willer.controleacademico.javafx.DisplayManager;
import com.willer.controleacademico.javafx.controllers.IControllersInit;
import com.willer.controleacademico.pessoa.dto.Pessoa;
import com.willer.controleacademico.turma.dto.Turma;
import com.willer.controleacademico.turma.dto.TurmaProfessor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ListarTurmasAlunoController implements IControllersInit
{

   private static final ControleFacade facade = ControleFacade.getInstance();

   @FXML
   private Button voltarButton;

   @FXML
   private TableView<TurmaProfessor> tableData;

   @FXML
   public TableColumn<TurmaProfessor, String> nomeDisciplina;

   @FXML
   public TableColumn<TurmaProfessor, String> codigoDisciplina;

   @FXML
   public TableColumn<TurmaProfessor, String> codigoTurma;

   @FXML
   public TableColumn<TurmaProfessor, String> horario;

   private ObservableList<TurmaProfessor> listaTurmas = FXCollections.observableArrayList();

   private void loadStudents()
   {
      codigoTurma.setCellValueFactory(new PropertyValueFactory<>("codigoTurma"));
      codigoDisciplina.setCellValueFactory(new PropertyValueFactory<>("codigoDisciplina"));
      horario.setCellValueFactory(new PropertyValueFactory<>("horario"));
      nomeDisciplina.setCellValueFactory(new PropertyValueFactory<>("nomeDisciplina"));

      tableData.setItems(listaTurmas);
   }

   @FXML
   public void initialize()
   {
      loadStudents();
   }

   @Override public void initData(Object o)
   {

      Pessoa p = (Pessoa) o;

      ArrayList<Turma> arrayTurmas = facade.recuperaTurmasAluno(p.getCpf());

      ArrayList<TurmaProfessor> arrayTumasProf = new ArrayList<>();

      for (Turma t : arrayTurmas)
      {
         TurmaProfessor turmaProf = new TurmaProfessor();
         turmaProf.setHorario(t.getHorario());
         turmaProf.setCodigoDisciplina(t.getCodigoDisciplina());
         turmaProf.setCodigoTurma(t.getCodigo());
         turmaProf.setNomeDisciplina(facade.buscaDisciplina(t.getCodigoDisciplina()).getNome());

         arrayTumasProf.add(turmaProf);
      }

      listaTurmas.addAll(arrayTumasProf);
      tableData.setItems(listaTurmas);

   }

   @FXML
   private void acaoBotaoVoltar(ActionEvent event) throws IOException
   {
      DisplayManager.abrirMenuTurma();

      Stage stage = (Stage) voltarButton.getScene().getWindow();
      stage.close();
   }

}
