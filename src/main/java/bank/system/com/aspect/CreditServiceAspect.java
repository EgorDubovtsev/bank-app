package bank.system.com.aspect;

import bank.system.com.exception.MoneyAccessDeniedException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CreditServiceAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(CreditServiceAspect.class);

    @Around(value = "execution(public * giveMoney(..))")
    public Object exceptionHandler(ProceedingJoinPoint joinPoint) {
        try {
            return joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return "404";
        }
    }

    @Around("within(bank.system.com.service..*)")
    public Object startAndStopNotifications(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        LOGGER.info("Method {} started with args {}", proceedingJoinPoint.getStaticPart(), proceedingJoinPoint.getArgs());
        return proceedingJoinPoint.proceed();
    }
}
