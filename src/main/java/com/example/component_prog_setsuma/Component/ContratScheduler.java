package com.example.component_prog_setsuma.Component;

import com.example.component_prog_setsuma.Service.ContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ContratScheduler {

    @Autowired
    private ContratService contratService;

    @Scheduled(cron = "*/15 * * * * ?") // Planifie la tâche toutes les 15 secondes à partir de la 0ème seconde de chaque minute
    public void checkContratsValidity() {
        contratService.checkContratsValidity();
    }
}
