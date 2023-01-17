package br.app.mvictor.activities;

public class Dados
{
	private String nome;
	private String sobrenome;
	private int idade;
	private String sexo;
	private String profissao;
	private String DN;
	
	public Dados()
	{}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public String getNome()
	{
		return nome;
	}

	public void setSobrenome(String sobrenome)
	{
		this.sobrenome = sobrenome;
	}

	public String getSobrenome()
	{
		return sobrenome;
	}

	public void setIdade(int idade)
	{
		this.idade = idade;
	}

	public int getIdade()
	{
		return idade;
	}

	public void setSexo(String sexo)
	{
		this.sexo = sexo;
	}

	public String getSexo()
	{
		return sexo;
	}

	public void setProfissao(String profissao)
	{
		this.profissao = profissao;
	}

	public String getProfissao()
	{
		return profissao;
	}

	public void setDN(String dN)
	{
		DN = dN;
	}

	public String getDN()
	{
		return DN;
	}
	
}
