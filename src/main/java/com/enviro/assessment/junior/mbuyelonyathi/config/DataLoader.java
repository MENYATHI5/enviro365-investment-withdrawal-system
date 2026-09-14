package com.enviro.assessment.junior.mbuyelonyathi.config;

import com.enviro.assessment.junior.mbuyelonyathi.entity.Investor;
import com.enviro.assessment.junior.mbuyelonyathi.entity.Portfolio;
import com.enviro.assessment.junior.mbuyelonyathi.repository.InvestorRepository;
import com.enviro.assessment.junior.mbuyelonyathi.repository.PortfolioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData(
            InvestorRepository investorRepository,
            PortfolioRepository portfolioRepository) {

        return args -> {

            Investor investor = new Investor(
                    null,
                    "Mbuyelo Nyathi",
                    68
            );

            investorRepository.save(investor);

            Portfolio retirementPortfolio =
                    new Portfolio(
                            null,
                            "Retirement Fund",
                            100000.0,
                            investor
                    );

            Portfolio savingsPortfolio =
                    new Portfolio(
                            null,
                            "Savings Account",
                            50000.0,
                            investor
                    );

            portfolioRepository.save(retirementPortfolio);
            portfolioRepository.save(savingsPortfolio);
        };
    }
}