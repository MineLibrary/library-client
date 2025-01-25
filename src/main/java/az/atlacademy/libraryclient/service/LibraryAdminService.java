package az.atlacademy.libraryclient.service;

import org.springframework.stereotype.Service;

import az.atlacademy.libraryclient.client.LibraryAdpClient;

@Service(value = "libraryAdminService")
public class LibraryAdminService extends LibraryService
{
    public LibraryAdminService(LibraryAdpClient libraryAdpClient)
    {
        super(libraryAdpClient);
    }


    
}
