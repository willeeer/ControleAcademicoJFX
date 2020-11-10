package com.willer.controleacademico.utilitarios;

import com.willer.controleacademico.disciplina.dto.Disciplina;

import java.io.*;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControleAcademicoUtils
{

   public static boolean isTelefoneValido(String telefone)
   {
      if (telefone.length() != 10)
      {
         return false;
      }

      for (int i = 0; i < telefone.length(); i++)
      {

         if (!Character.isDigit(telefone.charAt(i)))
         {
            return false;
         }
      }

      return true;
   }

   public static boolean isNomeValido(String nome)
   {

      for (int i = 0; i < nome.length(); i++)
      {

         if (!Character.isLetter(nome.charAt(i)))
         {
            return false;
         }
      }

      return true;
   }

   public static String limparEspacosEmBranco(String nome)
   {
      if (nome != null)
      {
         return nome.replaceAll("\\s+", " ").trim();
      }
      else
      {
         return "";
      }
   }

   public static boolean isCPF(String CPF)
   {

      CPF = removeCaracteresEspeciais(CPF);

      if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222") || CPF.equals("33333333333") || CPF
               .equals("44444444444") || CPF.equals("55555555555") || CPF.equals("66666666666") || CPF.equals("77777777777") || CPF
               .equals("88888888888") || CPF.equals("99999999999") || (CPF.length() != 11))
      {
         return false;
      }

      char dig10, dig11;
      int somatorio, i, resto, num, peso;

      // Calculo do 1o. Digito Verificador
      somatorio = 0;
      peso = 10;
      for (i = 0; i < 9; i++)
      {
         num = Character.getNumericValue(CPF.charAt(i));
         somatorio = somatorio + (num * peso);
         peso = peso - 1;
      }

      resto = 11 - (somatorio % 11);
      if ((resto == 10) || (resto == 11))
      {
         dig10 = '0';
      }
      else
      {
         dig10 = Character.forDigit(resto, 10);
      }

      // Calculo do 2o. Digito Verificador
      somatorio = 0;
      peso = 11;
      for (i = 0; i < 10; i++)
      {
         num = Character.getNumericValue(CPF.charAt(i));
         somatorio = somatorio + (num * peso);
         peso = peso - 1;
      }

      resto = 11 - (somatorio % 11);
      if ((resto == 10) || (resto == 11))
      {
         dig11 = '0';
      }
      else
      {
         dig11 = Character.forDigit(resto, 10);
      }

      // Verifica se os digitos calculados conferem com os digitos informados.
      if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
         return (true);
      else
         return (false);

   }

   private static String removeCaracteresEspeciais(String doc)
   {
      if (doc.contains("."))
      {
         doc = doc.replace(".", "");
      }
      if (doc.contains("-"))
      {
         doc = doc.replace("-", "");
      }
      if (doc.contains("/"))
      {
         doc = doc.replace("/", "");
      }
      return doc;
   }

   public static LinkedList carregarArquivo(File arquivo)
   {

      if (arquivo.exists())
      {
         try
         {
            FileInputStream fin = new FileInputStream(arquivo);
            ObjectInputStream ois = new ObjectInputStream(fin);
            LinkedList listaPessoas = (LinkedList) ois.readObject();
            ois.close();
            fin.close();

            return listaPessoas;
         }
         catch (Exception ex)
         {
            Logger.getLogger(Disciplina.class.getName()).log(Level.SEVERE, null, ex);
         }
      }

      return null;
   }

   public static void salvarArquivo(File arquivo, LinkedList lista)
   {
      try
      {
         FileOutputStream fout = new FileOutputStream(arquivo);
         ObjectOutputStream oos = new ObjectOutputStream(fout);
         oos.writeObject(lista);
         System.out.println("Arquivo salvo com sucesso.");
      }
      catch (FileNotFoundException ex)
      {
         Logger.getLogger(Disciplina.class.getName()).log(Level.SEVERE, null, ex);
      }
      catch (IOException ex)
      {
         Logger.getLogger(Disciplina.class.getName()).log(Level.SEVERE, null, ex);
      }
   }

}
