package tn.esprit.spring.tpcafe_maramboussalem.aspectes;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component  //pour defenir qu'il sagit  d'un been spring
@Aspect //pour definir que cette classe est un ascpect
@Slf4j //pour ecrire des message du logging
public class AspectClasse {




    @Before("execution(* tn.esprit.spring.tpcafe_maramboussalem.services..*.*(..))")
    public void logMethodeEntry(JoinPoint jp) {
        log.info("In Methode X" + jp.getSignature().getName());
    }



    @After("execution(* tn.esprit.spring.tpcafe_maramboussalem.services..*.*(..))")
    public void logMethodeEnd(JoinPoint jp) {
        log.info("In Methode X" + jp.getSignature().getName());
    }



}
