package tn.esprit.spring.tpcafe_maramboussalem.AOP;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
@Slf4j
public class AspectClasse {

    @Before("execution(* tn.esprit.spring.tpcafe_maramboussalem.services..*.*(..))")
    public void logMethodeEntry(JoinPoint jp) {
        log.info("Hello!" + jp.getSignature().getName());
    }

    @After("execution(* tn.esprit.spring.tpcafe_maramboussalem.services..*.*(..))")
    public void logMethodeEnd(JoinPoint jp) {
        log.info("Bye!" + jp.getSignature().getName());
    }

    @Around("execution(* tn.esprit.spring.tpcafe_maramboussalem.services.Client.ClientService.addClient( .. ))")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();

        Object obj = pjp.proceed();

        long elapsedTime = System.currentTimeMillis() - start;

        log.info("Method execution time: " + elapsedTime + " milliseconds.");
        return obj;
    }

    @Around("execution(* tn.esprit.spring.tpcafe_maramboussalem.services.Client.ClientService.*( .. ))")
    public Object validateInput(ProceedingJoinPoint pjp) throws Throwable {

        Object[] args = pjp.getArgs();

        if (args[0] == null) {
            log.warn("Impossible de mettre a jour : client null.");
            return null;
        }
            return pjp.proceed();
    }

    @Around("execution(* tn.esprit.spring.tpcafe_maramboussalem.services ..*.* ( .. ))")
    public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
        log.info("Début de la méthode : " + pjp.getSignature());
        Object result = pjp.proceed();
        log.info("Fin de la méthode : " + pjp.getSignature());
        return result;

    }

    @AfterThrowing(pointcut = "execution(* tn.esprit.spring.tpcafe_maramboussalem.services..*(..))", throwing = "ex")
    public void monitorErrors(JoinPoint jp, Throwable ex) {
        log.error("Exception dans : " + jp.getSignature().getName());
        log.error("Message : " + ex.getMessage());
    }

    @AfterThrowing(pointcut = "execution(* tn.esprit.spring.tpcafe_maramboussalem.services..*(..))", throwing = "ex")
    public void monitorNullPointer(JoinPoint jp, NullPointerException ex) {

        log.error("NullPointerException dans : " + jp.getSignature().getName());
        log.error("Message : " + ex.getMessage());
        log.error("Parametres : " + Arrays.toString(jp.getArgs()));
    }
}
