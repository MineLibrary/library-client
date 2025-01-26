package az.atlacademy.libraryclient.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import az.atlacademy.libraryclient.service.LibraryAdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/admin")
public class LibraryAdminController 
{
    private static final String LOG_TEMPLATE = "{} request to /admin{}";

    @Qualifier(value = "libraryAdminService")
    private final LibraryAdminService libraryAdminService; 

    

}
