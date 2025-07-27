package dev.javaProjeto.CadstroDeNinjas.Ninjas;

import dev.javaProjeto.CadstroDeNinjas.Missoes.MissoesModel;
import dev.javaProjeto.CadstroDeNinjas.Missoes.MissoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    @Autowired
    private NinjaRepository ninjaRepository;

    @Autowired
    private MissoesRepository missoesRepository;

    // Criar um ninja
    @PostMapping
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja) {
        return ninjaRepository.save(ninja);
    }

    // Listar todos os ninjas
    @GetMapping
    public List<NinjaModel> listarNinjas() {
        return ninjaRepository.findAll();
    }

    // Atualizar dados do ninja
    @PutMapping("/{id}")
    public ResponseEntity<NinjaModel> atualizarNinja(@PathVariable Long id, @RequestBody NinjaModel dadosAtualizados) {
        Optional<NinjaModel> ninja = ninjaRepository.findById(id);
        if (ninja.isPresent()) {
            NinjaModel existente = ninja.get();
            existente.setNome(dadosAtualizados.getNome());
            existente.setEmail(dadosAtualizados.getEmail());
            existente.setIdade(dadosAtualizados.getIdade());
            return ResponseEntity.ok(ninjaRepository.save(existente));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Atribuir missão a um ninja
    @PutMapping("/{ninjaId}/missao/{missaoId}")
    public ResponseEntity<NinjaModel> atribuirMissao(@PathVariable Long ninjaId, @PathVariable Long missaoId) {
        Optional<NinjaModel> ninja = ninjaRepository.findById(ninjaId);
        Optional<MissoesModel> missao = missoesRepository.findById(missaoId);

        if (ninja.isPresent() && missao.isPresent()) {
            NinjaModel ninjaAtualizado = ninja.get();
            ninjaAtualizado.setMissoes(missao.get());
            return ResponseEntity.ok(ninjaRepository.save(ninjaAtualizado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
