package az.atlacademy.libraryclient.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import az.atlacademy.libraryclient.service.LibraryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LibraryUserController 
{
    private static final String LOG_TEMPLATE = "{} request to {}";

    @Qualifier(value = "libraryService")
    private final LibraryService libraryService; 
}
