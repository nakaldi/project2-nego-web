package codes.dirty.nego.negoweb.common.config;

import codes.dirty.nego.negoweb.common.Interceptor.LoginInterceptor;
import codes.dirty.nego.negoweb.module.member.repository.MemberRepository;
import codes.dirty.nego.negoweb.module.member.repository.MemoryMemberRepository;
import codes.dirty.nego.negoweb.module.member.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringConfig implements WebMvcConfigurer {
    private final LoginInterceptor loginInterceptor;

    public SpringConfig(LoginInterceptor loginInterceptor) {
        this.loginInterceptor = loginInterceptor;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .excludePathPatterns("/health", "/", "/members/*");
    }
}
