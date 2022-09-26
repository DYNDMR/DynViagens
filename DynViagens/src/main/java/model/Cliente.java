package model;

public class Cliente {

  public int id;
  private String CPF;
  private String nome;
  private String Email;
  private String sexo;
  private String senha;

  public Cliente() {
  }

  public Cliente(int id, String nome, String CPF, String Email, String sexo, String senha) {
    this.id = id;
    this.CPF = CPF;
    this.nome = nome;
    this.Email = Email;
    this.sexo = sexo;
    this.senha = senha;

  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return this.Email;
  }

  public void setEmail(String Email) {
    this.Email = Email;
  }

  public String getCPF() {
    return this.CPF;
  }

  public void setCPF(String CPF) {
    this.CPF = CPF;
  }

  public String getSexo() {
    return this.sexo;
  }

  public void setSexo(String sexo) {
    this.sexo = sexo;
  }

  public String getSenha() {
    return this.senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }
}
