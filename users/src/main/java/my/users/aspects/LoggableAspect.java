package my.users.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class LoggableAspect {
    public static final Logger LOGGER = LoggerFactory.getLogger(LoggableAspect.class);

    @Around(value = "@annotation(my.users.aspects.Loggable)")
    public Object autoLoggableHandler(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = joinPoint.getTarget().getClass().getMethod(methodSignature.getMethod().getName(),
                methodSignature.getMethod().getParameterTypes());
        Loggable loggable = method.getAnnotation(Loggable.class);

        long start = System.currentTimeMillis();
        Object[] methodArguments = joinPoint.getArgs();

        logArgumentsIfNeed(methodSignature, loggable, methodArguments);

        Object proceed = joinPoint.proceed();

        logArgumentsIfNeed(methodSignature, loggable, methodArguments);

        long executionTime = System.currentTimeMillis() - start;

        if (Boolean.TRUE.equals(loggable.isLogExecutionTime())) {
            LOGGER.info("The method [{}] executed in [{}] ms", methodSignature, executionTime);
        }

        return joinPoint.proceed();
    }

    private void logArgumentsIfNeed(MethodSignature methodSignature, Loggable loggable, Object[] methodArguments) {
        if (loggable != null && loggable.isLogArgs()) {
            LOGGER.info("Start executing method [{}] with parameters [{}]", methodSignature.getMethod(),
                    methodArguments);
        } else {
            LOGGER.info("Start executing method [{}]", methodSignature.getMethod());
        }
    }
}
