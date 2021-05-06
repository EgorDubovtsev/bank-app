package bank.system.com.service;

import bank.system.com.exception.MoneyAccessDeniedException;

public interface CreditService {
    String giveMoney(String name) throws MoneyAccessDeniedException;
}
