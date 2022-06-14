package cxx.code.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserProxy {

    @Before(value = "execution(* cxx.code.spring.aop.*.*(..))")
    public void before() {
        System.out.println("before...abc");
    }
}
