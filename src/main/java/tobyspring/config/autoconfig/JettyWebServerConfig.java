//package tobyspring.config.autoconfig;
//
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
//import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Condition;
//import org.springframework.context.annotation.ConditionContext;
//import org.springframework.context.annotation.Conditional;
//import org.springframework.core.type.AnnotatedTypeMetadata;
//import org.springframework.util.ClassUtils;
//import tobyspring.config.ConditionalMyOnClass;
//import tobyspring.config.MyAutoConfiguration;
//
//@MyAutoConfiguration
////@Conditional(JettyWebServerConfig.JettyCondition.class)
//@ConditionalMyOnClass("org.apache.catalina.Server")
//public class JettyWebServerConfig {
//    @Bean("jettyWebServerFactory")
//    @ConditionalOnMissingBean
//    public ServletWebServerFactory servletWebServerFactory() {
//        return new JettyServletWebServerFactory();
//    }
//
////    static class JettyCondition implements Condition {
////        @Override
////        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
////            return ClassUtils.isPresent("org.apache.catalina.Server",
////                    context.getClassLoader());
////        }
////    }
//}
