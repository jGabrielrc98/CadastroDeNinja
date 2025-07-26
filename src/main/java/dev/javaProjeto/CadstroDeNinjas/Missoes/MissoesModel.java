package dev.javaProjeto.CadstroDeNinjas.Missoes;


import dev.javaProjeto.CadstroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MissoesModel {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nomeMissao;

        private String dificuldadeMissão;
        // OneToMany uma missão pode ter varios ninja


        @OneToMany(mappedBy = "missoes")
        private List<NinjaModel> ninja;


}

