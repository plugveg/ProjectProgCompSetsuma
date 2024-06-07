package com.example.component_prog_setsuma.Component;

import com.example.component_prog_setsuma.Service.ContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ContratScheduler {

    @Autowired
    private ContratService contratService;

//    @Scheduled(cron = "*/15 * * * * ?") // Pour tester, veuillez décommenter cette ligne. Planifie la tâche toutes les 15 secondes à partir de la 0ᵉ seconde de chaque minute
    @Scheduled(cron = "0 0 13 * * ?") // Planifie la tâche à 13h00 tous les jours
    public void retrieveAndUpdateStatusContrat() {
        contratService.retrieveAndUpdateStatusContrat();
    }
}
