package bank.system.com.controller;

import bank.system.com.service.CreditService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @Autowired
    private CreditService creditService;
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @Value("${bank.customer}")
    private String customerName;

    @RequestMapping("/")
    public String index() {
        return "hello";
    }

    @RequestMapping("/credit")//pbbl add id in path
    public String credit() {
        LOGGER.info("Customer is {}", customerName);

        return creditService.giveMoney(customerName);
    }
}
