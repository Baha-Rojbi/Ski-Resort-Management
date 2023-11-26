package tn.etudedecas.stationdeski.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.etudedecas.stationdeski.Entities.Abonnement;
import tn.etudedecas.stationdeski.Respositories.AbonnementRepositories;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class RevenueCalculationService {
    public AbonnementRepositories abonnementRepositories;
    @Scheduled(cron = "0 0 0 1 * ?") // Cron expression to run on the 1st day of every month at midnight
    public void showMonthlyRecurringRevenue(){
        // Calculate Monthly Recurring Revenue logic
        List<Abonnement> subscriptions = abonnementRepositories.findAll(); // Recuperer les abonnements
        float totalRevenue = calculateTotalMonthlyRevenue(subscriptions);


        log.info("Monthly Recurring Revenue for the current month: " + totalRevenue);
    }
    private float calculateTotalMonthlyRevenue(List<Abonnement> subscriptions) {
        // Calculate the total revenue based on subscription prices or any relevant logic
        // For example, summing up the prices of all subscriptions
        float totalRevenue = 0;
        for (Abonnement subscription : subscriptions) {
            totalRevenue += subscription.getPrixAbon(); // Assuming PrixAbon is the subscription price
        }
        return totalRevenue;
    }
}
