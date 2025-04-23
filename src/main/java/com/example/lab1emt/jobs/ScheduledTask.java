package com.example.lab1emt.jobs;

import com.example.lab1emt.service.application.MaterializedViewRefresherInterface;
import org.springframework.stereotype.Component;
import org.springframework.scheduling.annotation.Scheduled;

@Component
public class ScheduledTask {

    private final MaterializedViewRefresherInterface materializedViewRefresher;

    // Инјектирање на зависноста
    public ScheduledTask(MaterializedViewRefresherInterface materializedViewRefresher) {
        this.materializedViewRefresher = materializedViewRefresher;
    }

    // Оваа задача ќе се извршува на секој час
    @Scheduled(cron = "0 0 * * * *")  // Закажано да се извршува на секој час
    public void refreshMaterializedView() {
        // Повик на методот кој го освежува materialized view
        materializedViewRefresher.refreshBooksByAuthorView();
        System.out.println("Materialized view 'books_by_author' е успешно освежен.");
    }

    // Ако имате друга задача за секој ден
    @Scheduled(cron = "0 0 0 * * *")  // Оваа задача ќе се извршува на секој ден на полноќ
    public void anotherScheduledTask() {
        // Некои други операции
        System.out.println("Извршувам дневна задача.");
    }
}
