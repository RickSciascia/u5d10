package ricksciascia.u5d10.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ricksciascia.u5d10.entities.Dipendente;
import ricksciascia.u5d10.exceptions.ValException;
import ricksciascia.u5d10.payloads.DipendenteDTO;
import ricksciascia.u5d10.services.DipendenteService;

import java.util.List;

@RestController
@RequestMapping("/dipendenti")
public class DipendenteController {
    private final DipendenteService dipendenteService;

    @Autowired
    public DipendenteController(DipendenteService dipendenteService) {
        this.dipendenteService = dipendenteService;
    }

//    POST
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Dipendente creaDipendente(@RequestBody @Validated DipendenteDTO payload, BindingResult validationResult) {
//        validazione payload
        if(validationResult.hasErrors()) {
//        trasformo la Lista di FieldError che mi fornisce il validationResult in una Lista di Stringhe tramite i Java Stream con Map e toList
            List<String> listaErrori = validationResult.getFieldErrors()
                    .stream().map(fieldError -> fieldError.getDefaultMessage())
                    .toList();

            throw new ValException(listaErrori);
        } else {
            return this.dipendenteService.saveDipendente(payload);
        }
    }
}
