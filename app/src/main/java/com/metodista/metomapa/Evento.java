package com.metodista.metomapa;

/**
 * Created by rds_d on 01/11/2016.
 */

public class Evento {

    private String nome;
    private String local;
    private String data;
    private String hora;
    private String sala;



    public Evento(String nome, String local, String data, String hora, String sala) {
        this.nome=nome;
        this.local=local;
        this.data=data;
        this.hora=hora;
        this.sala=sala;

    }

    public Evento(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "nome='" + nome + '\'' +
                ", local='" + local + '\'' +
                ", data='" + data + '\'' +
                ", hora='" + hora + '\'' +
                '}';
    }
}
