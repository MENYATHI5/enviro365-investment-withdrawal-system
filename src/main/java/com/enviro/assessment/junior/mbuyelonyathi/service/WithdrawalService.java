package com.enviro.assessment.junior.mbuyelonyathi.service;

import com.enviro.assessment.junior.mbuyelonyathi.dto.WithdrawalRequestDTO;
import com.enviro.assessment.junior.mbuyelonyathi.entity.Portfolio;
import com.enviro.assessment.junior.mbuyelonyathi.entity.Withdrawal;
import com.enviro.assessment.junior.mbuyelonyathi.exception.BusinessException;
import com.enviro.assessment.junior.mbuyelonyathi.repository.PortfolioRepository;
import com.enviro.assessment.junior.mbuyelonyathi.repository.WithdrawalRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class WithdrawalService {

    private final PortfolioRepository portfolioRepository;
    private final WithdrawalRepository withdrawalRepository;

    public WithdrawalService(
            PortfolioRepository portfolioRepository,
            WithdrawalRepository withdrawalRepository) {

        this.portfolioRepository = portfolioRepository;
        this.withdrawalRepository = withdrawalRepository;
    }

    public Withdrawal createWithdrawal(WithdrawalRequestDTO dto) {

        Portfolio portfolio = portfolioRepository
                .findById(dto.getPortfolioId())
                .orElseThrow(() ->
                        new BusinessException("Portfolio not found"));

        double amount = dto.getAmount();

        if (amount > portfolio.getBalance()) {
            throw new BusinessException(
                    "Withdrawal exceeds available balance");
        }

        if (amount > portfolio.getBalance() * 0.9) {
            throw new BusinessException(
                    "Withdrawal exceeds 90% of portfolio balance");
        }

        if (portfolio.getProductName()
                .equalsIgnoreCase("Retirement Fund")
                && portfolio.getInvestor().getAge() <= 65) {

            throw new BusinessException(
                    "Retirement withdrawals only allowed for investors older than 65");
        }

        portfolio.setBalance(
                portfolio.getBalance() - amount);

        portfolioRepository.save(portfolio);

        Withdrawal withdrawal = new Withdrawal();

        withdrawal.setAmount(amount);
        withdrawal.setWithdrawalDate(LocalDate.now());
        withdrawal.setPortfolio(portfolio);

        return withdrawalRepository.save(withdrawal);
    }
}