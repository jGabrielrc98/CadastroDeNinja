package dev.javaProjeto.CadstroDeNinjas.Ninjas;


import dev.javaProjeto.CadstroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Ele tranforma uma classe em uma entidade do BD
//JPA = Java persiste API
@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private int idade;

    // @ManyToOne um ninja tem uma unica missão
    @ManyToOne
    @JoinColumn(name = "missoes_id") // foreing key ou chave estrageiras
    private MissoesModel missoes;


}
