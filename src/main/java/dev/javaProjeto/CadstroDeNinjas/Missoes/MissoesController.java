package dev.javaProjeto.CadstroDeNinjas.Missoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    @Autowired
    private MissoesRepository missoesRepository;

    // Criar uma missão
    @PostMapping
    public MissoesModel criarMissao(@RequestBody MissoesModel missao) {
        return missoesRepository.save(missao);
    }

    // Listar todas as missões
    @GetMapping
    public List<MissoesModel> listarMissoes() {
        return missoesRepository.findAll();
    }
}

