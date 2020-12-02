package com.willer.controleacademico.javafx;

import com.willer.controleacademico.disciplina.dto.Disciplina;
import com.willer.controleacademico.javafx.controllers.IControllersInit;
import com.willer.controleacademico.pessoa.dto.Pessoa;
import com.willer.controleacademico.turma.dto.Turma;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * DialogService manages views creation
 *
 * @author vareversat lturpinat
 */
public class DisplayManager
{

   private static final String NO_TITLE = "";
   //Views
   private static final String MAINPAGE_VIEW = "view/MainPage.fxml";
   private static final String MENU_ALUNO_VIEW = "view/MenuAluno.fxml";
   private static final String MENU_PROFESSOR_VIEW = "view/MenuProfessor.fxml";
   private static final String MENU_DISCIPLINA_VIEW = "view/MenuDisciplina.fxml";
   private static final String MENU_TURMA_VIEW = "view/MenuTurma.fxml";

   private static final String CADASTRO_ALUNO_VIEW = "view/CadastrarAluno.fxml";
   private static final String LISTAR_ALUNO_VIEW = "view/ListarAluno.fxml";
   private static final String EXIBIR_ALUNO_VIEW = "view/ExibirAluno.fxml";

   private static final String CADASTRO_PROFESSOR_VIEW = "view/CadastrarProfessor.fxml";
   private static final String LISTAR_PROFESSOR_VIEW = "view/ListarProfessor.fxml";
   private static final String EXIBIR_PROFESSOR_VIEW = "view/ExibirProfessor.fxml";

   private static final String CADASTRO_DISCIPLINA_VIEW = "view/CadastrarDisciplina.fxml";
   private static final String LISTAR_DISCIPLINA_VIEW = "view/ListarDisciplina.fxml";
   private static final String EXIBIR_DISCIPLINA_VIEW = "view/ExibirDisciplina.fxml";

   private static final String CADASTRO_TURMA_VIEW = "view/CadastrarTurma.fxml";
   private static final String LISTAR_TURMA_VIEW = "view/ListarTurma.fxml";
   private static final String EXIBIR_TURMA_VIEW = "view/ExibirTurma.fxml";

   private static final String LISTAR_ALUNOS_TURMA_VIEW = "view/ListarAlunosTurma.fxml";
   private static final String LISTAR_TURMAS_PROFESSOR_VIEW = "view/ListarTurmaProfessor.fxml";
   private static final String LISTAR_TURMAS_DISCIPLINA_VIEW = "view/ListarTurmaDisciplina.fxml";
   private static final String LISTAR_TURMAS_ALUNO_VIEW = "view/ListarTurmaAluno.fxml";

   //Titulos
   private static final String MAINPAGE_TITULO = "Página Principal";
   private static final String MENU_ALUNO_TITULO = "Aluno";
   private static final String MENU_PROFESSOR_TITULO = "Professor";
   private static final String MENU_DISCIPLINA_TITULO = "Disciplina";
   private static final String MENU_TURMA_TITULO = "Turma";

   private static final String CADASTRO_ALUNO_TITULO = "Cadastrar Aluno";
   private static final String LISTAR_ALUNO_TITULO = "Listar Aluno";
   private static final String EXIBIR_ALUNO_TITULO = "Exibir/Alterar Aluno";

   private static final String CADASTRO_PROFESSOR_TITULO = "Cadastrar Professor";
   private static final String LISTAR_PROFESSOR_TITULO = "Listar Professor";
   private static final String EXIBIR_PROFESSOR_TITULO = "Exibir/Alterar Professor";

   private static final String CADASTRO_DISCIPLINA_TITULO = "view/CadastrarAluno.fxml";
   private static final String LISTAR_DISCIPLINA_TITULO = "view/CadastrarAluno.fxml";
   private static final String EXIBIR_DISCIPLINA_TITULO = "view/CadastrarAluno.fxml";

   private static final String CADASTRO_TURMA_TITULO = "Cadastrar Disciplina";
   private static final String LISTAR_TURMA_TITULO = "Listar Disciplina";
   private static final String EXIBIR_TURMA_TITULO = "Exibir/Alterar Disciplina";

   private DisplayManager()
   {
   }

   public static void abrirMainPage()
   {
      loadWindow(MAINPAGE_TITULO, MAINPAGE_VIEW, null);
   }

   //Alunos
   public static void abrirMenuAluno()
   {
      loadWindow(MENU_ALUNO_TITULO, MENU_ALUNO_VIEW, null);
   }

   public static void abrirCadastroAluno()
   {
      loadWindow(CADASTRO_ALUNO_TITULO, CADASTRO_ALUNO_VIEW, null);
   }

   public static void abrirExibicaoAluno(Pessoa p)
   {
      loadWindow(EXIBIR_ALUNO_TITULO, EXIBIR_ALUNO_VIEW, p);
   }

   public static void abrirListarAluno()
   {
      loadWindow(LISTAR_ALUNO_TITULO, LISTAR_ALUNO_VIEW, null);
   }

   //Professor

   public static void abrirMenuProfessor()
   {
      loadWindow(MENU_PROFESSOR_TITULO, MENU_PROFESSOR_VIEW, null);
   }

   public static void abrirCadastroProfessor()
   {
      loadWindow(CADASTRO_PROFESSOR_TITULO, CADASTRO_PROFESSOR_VIEW, null);
   }

   public static void abrirExibicaoProfessor(Pessoa p)
   {
      loadWindow(EXIBIR_PROFESSOR_TITULO, EXIBIR_PROFESSOR_VIEW, p);
   }

   public static void abrirListarProfessor()
   {
      loadWindow(LISTAR_PROFESSOR_TITULO, LISTAR_PROFESSOR_VIEW, null);
   }

   //Disciplina

   public static void abrirMenuDisciplina()
   {
      loadWindow(MENU_DISCIPLINA_TITULO, MENU_DISCIPLINA_VIEW, null);
   }

   public static void abrirCadastroDisciplina()
   {
      loadWindow(CADASTRO_DISCIPLINA_TITULO, CADASTRO_DISCIPLINA_VIEW, null);
   }

   public static void abrirExibicaoDisciplina(Disciplina d)
   {
      loadWindow(EXIBIR_DISCIPLINA_TITULO, EXIBIR_DISCIPLINA_VIEW, d);
   }

   public static void abrirListarDisciplina()
   {
      loadWindow(LISTAR_DISCIPLINA_TITULO, LISTAR_DISCIPLINA_VIEW, null);
   }

   //Turma

   public static void abrirMenuTurma()
   {
      loadWindow(MENU_TURMA_TITULO, MENU_TURMA_VIEW, null);
   }

   public static void abrirCadastroTurma()
   {
      loadWindow(CADASTRO_TURMA_TITULO, CADASTRO_TURMA_VIEW, null);
   }

   public static void abrirExibicaoTurma(Turma t)
   {
      loadWindow(EXIBIR_TURMA_TITULO, EXIBIR_TURMA_VIEW, t);
   }

   public static void abrirListarTurma()
   {
      loadWindow(LISTAR_TURMA_TITULO, LISTAR_TURMA_VIEW, null);
   }

   public static void abrirListarAlunosTurma(Turma t)
   {
      loadWindow(NO_TITLE, LISTAR_ALUNOS_TURMA_VIEW, t);
   }

   public static void abrirListarTumasProfessor(Pessoa p)
   {
      loadWindow(NO_TITLE, LISTAR_TURMAS_PROFESSOR_VIEW, p);
   }

   public static void abrirListarTumasDisciplina(Disciplina d)
   {
      loadWindow(NO_TITLE, LISTAR_TURMAS_DISCIPLINA_VIEW, d);
   }

   public static void abrirListarTumasAluno(Pessoa p)
   {
      loadWindow(NO_TITLE, LISTAR_TURMAS_ALUNO_VIEW, p);
   }

   private static void loadWindow(String windowTitle, String windowPath, Object obj)
   {
      try
      {
         FXMLLoader fxmlLoader = new FXMLLoader();
         Stage stage = new Stage();

         fxmlLoader.setLocation(DisplayManager.class.getResource(windowPath));

         Parent parent = fxmlLoader.load();

         Scene sceneSetUpView = new Scene(parent);
         stage.setTitle(windowTitle);
         stage.setScene(sceneSetUpView);

         if (obj != null)
         {
            IControllersInit controller = fxmlLoader.getController();
            controller.initData(obj);
         }

         stage.show();
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
   }

}
