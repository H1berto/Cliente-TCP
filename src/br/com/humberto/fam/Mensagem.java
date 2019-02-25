package br.com.humberto.fam;

import java.io.Serializable;

public class Mensagem implements Serializable{

  private final TipoDaPergunta tipoDaPergunta;
  private String resposta;

  public Mensagem(TipoDaPergunta tipoDaPergunta) {
    this.tipoDaPergunta = tipoDaPergunta;
  }

  public TipoDaPergunta getTipoDaPergunta() {
    return tipoDaPergunta;
  }

  public String getResposta() {
    return resposta;
  }

  public void setResposta(String resposta) {
    this.resposta = resposta;
  }

  @Override
  public String toString() {
    return resposta;
  }

}
