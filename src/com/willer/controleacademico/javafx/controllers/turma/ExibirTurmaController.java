package com.willer.controleacademico.javafx.controllers.turma;

import com.willer.controleacademico.facade.ControleFacade;
import com.willer.controleacademico.javafx.DisplayManager;
import com.willer.controleacademico.javafx.controllers.IControllersInit;
import com.willer.controleacademico.pessoa.dto.Pessoa;
import com.willer.controleacademico.turma.dto.Turma;
import com.willer.controleacademico.utilitarios.ControleAcademicoUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class ExibirTurmaController implements IControllersInit
{

   private static final ControleFacade facade = ControleFacade.getInstance();

   @FXML
   private Button alterarButton;

   @FXML
   private Button voltarButton;

   @FXML
   private Button addAlunoButton;

   @FXML
   private TextField codigoTurma;

   @FXML
   private TextField codigoDisciplina;

   @FXML
   private TextField cpfProfessor;

   @FXML
   private TextField horario;

   @FXML
   private TextField periodo;

   @FXML
   private TextField maxAlunos;

   @FXML
   private TableView<Pessoa> tableData;

   @FXML
   public TableColumn<Pessoa, String> nomeAluno;

   @FXML
   public TableColumn<Pessoa, String> cpfAluno;

   private ObservableList<Pessoa> listaAlunos = FXCollections.observableArrayList();

   private void loadStudents()
   {
      nomeAluno.setCellValueFactory(new PropertyValueFactory<>("nome"));
      cpfAluno.setCellValueFactory(new PropertyValueFactory<>("cpf"));

      tableData.setItems(listaAlunos);
   }

   @FXML
   private void initialize()
   {
      loadStudents();
   }

   @FXML
   private void acaoBotaoAlterar(ActionEvent event) throws IOException
   {

      String mensagemErro = validaDados();

      if (mensagemErro == null)
      {
         Turma turma = new Turma();

         turma.setCodigo(codigoTurma.getText());
         turma.setCodigoDisciplina(codigoDisciplina.getText());
         turma.setHorario(horario.getText());
         turma.setQuantidadeMaxAlunos(Integer.parseInt(maxAlunos.getText()));
         turma.setPeriodo(Integer.parseInt(periodo.getText()));
         turma.setCpfProfessor(cpfProfessor.getText());

         ArrayList<String> cpfAlunos = new ArrayList<>();

         for (Pessoa p : listaAlunos)
         {
            cpfAlunos.add(p.getCpf());
         }

         turma.setCpfAlunosMatriculados(cpfAlunos);
         turma.setQuantidadeAunosMatriculados(turma.getCpfAlunosMatriculados().size());

         facade.alterarTurma(turma);

         JOptionPane.showMessageDialog(null, "Alterado com sucesso!");

         DisplayManager.abrirMenuTurma();
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

      if (!ControleAcademicoUtils.isTurmaValida(codigoTurma.getText()))
      {
         return "Código de turma no formato inválido";
      }

      return null;
   }

   @FXML
   private void acaoBotaoVoltar(ActionEvent event) throws IOException
   {
      DisplayManager.abrirMenuTurma();

      Stage stage = (Stage) voltarButton.getScene().getWindow();
      stage.close();
   }

   @FXML
   private void acaoAddAluno()
   {
      String cpf = JOptionPane.showInputDialog("Digite o CPF do Aluno: ");

      if (cpf != null)
      {
         Pessoa p = facade.buscaPessoa(cpf, false);

         if (p != null)
         {
            listaAlunos.add(p);
         }
         else
         {
            JOptionPane.showMessageDialog(null, "Aluno não encontrado para o CPF informado", "ERRO", JOptionPane.ERROR_MESSAGE);
         }
      }
   }

   @FXML
   private void acaoDeleteAluno()
   {
      tableData.getItems().removeAll(tableData.getSelectionModel().getSelectedItems());
   }

   @Override public void initData(Object o)
   {
      Turma t = (Turma) o;

      codigoTurma.setText(t.getCodigo());
      codigoDisciplina.setText(t.getCodigoDisciplina());
      cpfProfessor.setText(t.getCpfProfessor());
      maxAlunos.setText(t.getQuantidadeMaxAlunos().toString());
      periodo.setText(t.getPeriodo().toString());
      horario.setText(t.getHorario());

      ArrayList<Pessoa> arrayAlunos = new ArrayList<>();

      for (String cpfAluno : t.getCpfAlunosMatriculados())
      {
         arrayAlunos.add(facade.buscaPessoa(cpfAluno, false));
      }

      listaAlunos.addAll(arrayAlunos);
      tableData.setItems(listaAlunos);
   }
}
