package com.enviro.assessment.junior.mbuyelonyathi.controller;

import com.enviro.assessment.junior.mbuyelonyathi.dto.WithdrawalRequestDTO;
import com.enviro.assessment.junior.mbuyelonyathi.entity.Portfolio;
import com.enviro.assessment.junior.mbuyelonyathi.entity.Withdrawal;
import com.enviro.assessment.junior.mbuyelonyathi.repository.PortfolioRepository;
import com.enviro.assessment.junior.mbuyelonyathi.repository.WithdrawalRepository;
import com.enviro.assessment.junior.mbuyelonyathi.service.WithdrawalService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class PortfolioController {

    private final PortfolioRepository portfolioRepository;
    private final WithdrawalRepository withdrawalRepository;
    private final WithdrawalService withdrawalService;

    public PortfolioController(
            PortfolioRepository portfolioRepository,
            WithdrawalRepository withdrawalRepository,
            WithdrawalService withdrawalService) {

        this.portfolioRepository = portfolioRepository;
        this.withdrawalRepository = withdrawalRepository;
        this.withdrawalService = withdrawalService;
    }

    @GetMapping("/portfolios")
    public List<Portfolio> getPortfolios() {
        return portfolioRepository.findAll();
    }

    @GetMapping("/withdrawals")
    public List<Withdrawal> getWithdrawals() {
        return withdrawalRepository.findAll();
    }

    @PostMapping("/withdrawals")
    public Withdrawal createWithdrawal(
            @Valid @RequestBody WithdrawalRequestDTO dto) {

        return withdrawalService.createWithdrawal(dto);
    }


    @GetMapping("/withdrawals/export")
    public ResponseEntity<String> exportWithdrawals() {

        List<Withdrawal> withdrawals =
                withdrawalRepository.findAll();

        StringBuilder csv = new StringBuilder();

        csv.append("Id,Amount,Date\n");

        for (Withdrawal withdrawal : withdrawals) {
            csv.append(withdrawal.getId())
                    .append(",")
                    .append(withdrawal.getAmount())
                    .append(",")
                    .append(withdrawal.getWithdrawalDate())
                    .append("\n");
        }

        return ResponseEntity.ok()
                .header(
                        HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=withdrawals.csv")
                .contentType(MediaType.TEXT_PLAIN)
                .body(csv.toString());
    }
}