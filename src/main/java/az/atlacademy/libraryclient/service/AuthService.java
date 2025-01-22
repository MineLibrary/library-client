package az.atlacademy.libraryclient.service;

import org.springframework.stereotype.Service;

import az.atlacademy.libraryclient.client.LibraryAdpClient;
import az.atlacademy.libraryclient.model.dto.request.LoginRequest;
import az.atlacademy.libraryclient.model.dto.response.BaseResponse;
import az.atlacademy.libraryclient.model.dto.response.LoginResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService 
{
    private final LibraryAdpClient libraryAdpClient; 

    public String authenticate(String username, String password)
    {
        BaseResponse<LoginResponse> clientResponse = libraryAdpClient
            .authenticateAdminUser(
                LoginRequest.builder()
                    .username(username)
                    .password(password)
                    .build()
            );

        if (clientResponse.isSuccess()) 
        {
            log.info("User authenticated successfully");
            return clientResponse.getData().getToken(); 
        }
        
        log.info("User could not be authenticated");
        return null;
    }
}
