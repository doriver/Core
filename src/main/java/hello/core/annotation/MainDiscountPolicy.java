package hello.core.annotation;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented // Qualifier.class 위에 붙어있는 것들 다 복사한거
@Qualifier("mainDiscountPolicy")
public @interface MainDiscountPolicy {
}
