package bank.system.com.service;

import bank.system.com.exception.MoneyAccessDeniedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CreditServiceImpl implements CreditService {
    @Value("${bank.answer.success}")
    private String successText;
    @Value("${bank.answer.fail}")
    private String failText;
    @Autowired
    private DebtAccessService debtAccessService;

    @Override
    public String giveMoney(String name) {
        if (name.equals("Thief")) {
            throw new MoneyAccessDeniedException("Its a THIEF!");
        }

        return debtAccessService.isPayable(name) ? successText : failText;
    }
}
