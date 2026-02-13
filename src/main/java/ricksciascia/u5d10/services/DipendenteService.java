package ricksciascia.u5d10.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ricksciascia.u5d10.entities.Dipendente;
import ricksciascia.u5d10.exceptions.BadReqException;
import ricksciascia.u5d10.payloads.DipendenteDTO;
import ricksciascia.u5d10.repositories.DipendenteRepository;

@Service
public class DipendenteService {
    private final DipendenteRepository dipendenteRepository;

    @Autowired
    public DipendenteService(DipendenteRepository dipendenteRepository) {
        this.dipendenteRepository = dipendenteRepository;
    }

    public Dipendente saveDipendente(DipendenteDTO payload) {
//        validazione se email è già presente in DB tramite query
        this.dipendenteRepository.findByEmail(payload.email()).ifPresent(dipendente -> {
            throw new BadReqException("L'email " + dipendente.getEmail() + " è già registrata");
        });
//        creo dipendente
        Dipendente dipendenteDaSalvare = new Dipendente(payload.username(), payload.nome(), payload.cognome(), payload.email());
//        salvo e ritorno il dipendente
        Dipendente salvato = this.dipendenteRepository.save(dipendenteDaSalvare);
        return salvato;
    }
}
