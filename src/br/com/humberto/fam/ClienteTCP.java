package br.com.humberto.fam;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;

public class ClienteTCP {

  public static void main(String[] args) {
    try {
      Mensagem mensagem;
      String resposta ="";
      //// Prova
      ObjectOutputStream oos;
      ObjectInputStream ois;
      ////
      Socket cliente = new Socket("127.0.0.1", 12345);
      oos = new ObjectOutputStream(
              cliente.getOutputStream());
      oos.flush();
      while(!resposta.equals("Hora")&&!resposta.equals("Data")){
        resposta=JOptionPane.showInputDialog("Qual informação deseja receber? (Hora / Data)");
        if(!resposta.equals("Hora")&&!resposta.equals("Data")){
             JOptionPane.showMessageDialog(null,"Erro","Escolha entre Hora ou Data para prosseguir.",JOptionPane.ERROR_MESSAGE);
        }  
      }
      
      mensagem = new Mensagem((resposta.equals("Hora"))?TipoDaPergunta.HORA:TipoDaPergunta.DATA);
      oos.writeObject(mensagem);
      /////
      ois = new ObjectInputStream(cliente.getInputStream());
        
      resposta = (String) ois.readObject();
      JOptionPane.showMessageDialog(null,resposta);
      ois.close();
      oos.close();
      System.exit(0);
      
    } catch (IOException | ClassNotFoundException e) {
      System.out.println(String.format("Erro: %s",
              e.getLocalizedMessage()));
    }
  }
}
