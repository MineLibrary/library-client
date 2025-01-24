package az.atlacademy.libraryclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import az.atlacademy.libraryclient.config.interceptor.feign.LibraryAdpClientInterceptor;
import feign.RequestInterceptor;

@Configuration
public class LibraryAdpClientConfig 
{
    @Bean
    public RequestInterceptor libraryAdpClientInterceptor()
    {
        return new LibraryAdpClientInterceptor(); 
    }
}
