package com.zyz.api.apipassenger.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置
 *
 * @author zhang
 * @date 2022/10/11
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    /**
     * jwt拦截器
     *
     * @return {@link JwtInterceptor}
     */
    @Bean
    public JwtInterceptor jwtInterceptor() {
        return new JwtInterceptor();
    }

    /**
     * 添加拦截器
     *
     * @param registry 注册表
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor())

                //拦截的路径
                .addPathPatterns("/**")

                //不拦截的路径
                .excludePathPatterns("/noauthTest")
                .excludePathPatterns("/verification-code")
                .excludePathPatterns("/token-refresh")
                .excludePathPatterns("/users")
                .excludePathPatterns("/users/")
                .excludePathPatterns("/verification-code-check");
    }
}
