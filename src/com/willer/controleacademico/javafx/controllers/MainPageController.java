package com.willer.controleacademico.javafx.controllers;

import com.willer.controleacademico.javafx.DisplayManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainPageController
{

   @FXML
   private Button alunoButton;

   @FXML
   private Button professorButton;

   @FXML
   private Button disciplinaButton;

   @FXML
   private Button turmaButton;

   @FXML
   private void abrirMenuAluno(ActionEvent event) throws IOException
   {
      DisplayManager.abrirMenuAluno();

      Stage stage = (Stage) alunoButton.getScene().getWindow();
      stage.close();
   }

   @FXML
   private void abrirMenuProfessor(ActionEvent event) throws IOException
   {
      DisplayManager.abrirMenuProfessor();

      Stage stage = (Stage) professorButton.getScene().getWindow();
      stage.close();
   }

   @FXML
   private void abrirMenuDisciplina(ActionEvent event) throws IOException
   {
      DisplayManager.abrirMenuDisciplina();

      Stage stage = (Stage) disciplinaButton.getScene().getWindow();
      stage.close();
   }

   @FXML
   private void abrirMenuTurma(ActionEvent event) throws IOException
   {
      DisplayManager.abrirMenuTurma();

      Stage stage = (Stage) turmaButton.getScene().getWindow();
      stage.close();
   }

}
