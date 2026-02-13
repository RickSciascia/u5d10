package ricksciascia.u5d10.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ricksciascia.u5d10.repositories.ViaggioRepository;

@Service
public class ViaggioService {
    private final ViaggioRepository viaggioRepository;

    @Autowired
    public ViaggioService(ViaggioRepository viaggioRepository) {
        this.viaggioRepository = viaggioRepository;
    }
}
