package tobyspring.config;

import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Conditional(MyOnClassCondition.class)
public @interface ConditionalMyOnClass {
    /**
     * <p> {@link Conditional}을 상속 받아
     * <p> {@link MyOnClassCondition#matches(ConditionContext, AnnotatedTypeMetadata)}에서
     * <p> 해당 조건을 설정하여 Bean 등록 여부 결정
     */
    String value();
}
