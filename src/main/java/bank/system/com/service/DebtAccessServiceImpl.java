package bank.system.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
@Service
public class DebtAccessServiceImpl implements DebtAccessService {
    @Autowired
    private Random random;

    @Override
    public boolean isPayable(String name) {
        return !name.equals("homeless") && random.nextBoolean();
    }
}
