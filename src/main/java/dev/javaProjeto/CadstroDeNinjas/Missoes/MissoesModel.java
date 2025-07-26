package dev.javaProjeto.CadstroDeNinjas.Missoes;


import dev.javaProjeto.CadstroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_missoes")
public class MissoesModel {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nomeMissao;

        private String dificuldadeMissão;
        // OneToMany uma missão pode ter varios ninja


        @OneToMany(mappedBy = "missoes")
        private List<NinjaModel> ninja;

    public MissoesModel() {}


    public MissoesModel(String nomeMissao, String dificuldadeMissão) {
        this.nomeMissao = nomeMissao;
        this.dificuldadeMissão = dificuldadeMissão;
    }

    public String getNomeMissao() {
        return nomeMissao;
    }

    public void setNomeMissao(String nomeMissao) {
        this.nomeMissao = nomeMissao;
    }

    public String getDificuldadeMissão() {
        return dificuldadeMissão;
    }

    public void setDificuldadeMissão(String dificuldadeMissão) {
        this.dificuldadeMissão = dificuldadeMissão;
    }


}

