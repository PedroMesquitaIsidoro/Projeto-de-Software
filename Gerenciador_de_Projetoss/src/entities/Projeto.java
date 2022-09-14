package entities;

import java.util.ArrayList;

public class Projeto {
	private String id;
	private String descricao;
	private String dataComeco;
	private String dataFim;
	private String horaComeco;
	private String horaFim;
	private Usuario coordenador;
	public ArrayList<Usuario> profissionaisDoProjeto;
	private double valorBolsa;
	private String periodoBolsa;
	private String status;
	public ArrayList<Atividades> atividade;
	
	public Projeto() {
		
	}
	
	public Projeto(String id, String descricao, String dataComeco, String dataFim, String horaComeco, String horaFim, double valorBolsa) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.dataComeco = dataComeco;
		this.dataFim = dataFim;
		this.horaComeco = horaComeco;
		this.horaFim = horaFim;
		this.valorBolsa = valorBolsa;
		profissionaisDoProjeto = new ArrayList<>();
		this.status = "Em processo de criacao";
		atividade = new ArrayList<>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDataComeco() {
		return dataComeco;
	}

	public void setDataComeco(String dataComeco) {
		this.dataComeco = dataComeco;
	}

	public String getDataFim() {
		return dataFim;
	}

	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}

	public String getHoraComeco() {
		return horaComeco;
	}

	public void setHoraComeco(String horaComeco) {
		this.horaComeco = horaComeco;
	}

	public String getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(String horaFim) {
		this.horaFim = horaFim;
	}

	public Usuario getCoordenador() {
		return coordenador;
	}

	public void adcCoordenador(Usuario coordenador){
        this.adcUsuario(coordenador);
        this.coordenador = coordenador;
        coordenador.setEhCoordenador(true);
    }
    
    public void adcUsuario(Usuario usuario){
    	profissionaisDoProjeto.add(usuario);
        usuario.projetoVinculado = this;
    }

	public ArrayList<Usuario> getProfissionaisDoProjeto() {
		return profissionaisDoProjeto;
	}

	public void setProfissionaisDoProjeto(ArrayList<Usuario> profissionaisDoProjeto) {
		this.profissionaisDoProjeto = profissionaisDoProjeto;
	}

	public double getValorBolsa() {
		return valorBolsa;
	}

	public void setValorBolsa(Double valorBolsa) {
		this.valorBolsa = valorBolsa;
	}

	public String getPeriodoBolsa() {
		return periodoBolsa;
	}

	public void setPeriodoBolsa(String periodoBolsa) {
		this.periodoBolsa = periodoBolsa;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void adcAtividade(Atividades atividade) {
		this.atividade.add(atividade);
	}
	
	public Usuario buscaUsuario(String email){
        for(Usuario usuario : profissionaisDoProjeto){
            if(usuario.getEmail().equalsIgnoreCase(email)){
                return usuario;
            }
        }
        return null;
    }
	
	
}
