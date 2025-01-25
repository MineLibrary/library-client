package az.atlacademy.libraryclient.service;

import java.util.List;

import org.springframework.stereotype.Service;

import az.atlacademy.libraryclient.client.LibraryAdpClient;
import az.atlacademy.libraryclient.model.dto.response.AuthorResponse;
import az.atlacademy.libraryclient.model.dto.response.BaseResponse;
import az.atlacademy.libraryclient.model.dto.response.BookResponse;
import az.atlacademy.libraryclient.model.dto.response.CategoryResponse;
import az.atlacademy.libraryclient.model.dto.response.OrderResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service(value = "libraryService")
public class LibraryService 
{
    protected final LibraryAdpClient libraryAdpClient;
    
    public BaseResponse<List<AuthorResponse>> getAuthors(int pageNumber, int pageSize)
    {
        return libraryAdpClient.getAuthors(pageNumber, pageSize);
    }

    public BaseResponse<List<AuthorResponse>> searchAuthorsByFullName(
        String fullName, int pageNumber, int pageSize
    ){
        return libraryAdpClient.searchAuthorsByFullName(fullName, pageNumber, pageSize);
    }

    public BaseResponse<AuthorResponse> getAuthorById(long authorId)
    {
        return libraryAdpClient.getAuthorById(authorId);
    }

    public BaseResponse<BookResponse> getBookById(long bookId)
    {
        return libraryAdpClient.getBookById(bookId);
    }

    public BaseResponse<List<BookResponse>> getBooks(int pageNumber, int pageSize)
    {
        return libraryAdpClient.getBooks(pageNumber, pageSize);
    }

    public BaseResponse<List<BookResponse>> getBooksByCategoryId(
        long categoryId, int pageNumber, int pageSize
    ){
        return libraryAdpClient.getBooksByCategoryId(categoryId, pageNumber, pageSize);
    }

    public BaseResponse<List<BookResponse>> getBooksByAuthorId(
        long authorId, int pageNumber, int pageSize
    ){
        return libraryAdpClient.getBooksByAuthorId(authorId, pageNumber, pageSize);
    }

    public BaseResponse<List<BookResponse>> searchBooksByTitle(
        String title, int pageNumber, int pageSize
    ){
        return libraryAdpClient.searchBooksByTitle(title, pageNumber, pageSize);
    }

    public BaseResponse<List<CategoryResponse>> getAllCategories()
    {
        return libraryAdpClient.getAllCategories();
    }

    public BaseResponse<CategoryResponse> getCategoryById(long categoryId)
    {
        return libraryAdpClient.getCategoryById(categoryId);
    }

    public BaseResponse<List<OrderResponse>> getOrders(int pageNumber, int pageSize)
    {
        return libraryAdpClient.getOrders(pageNumber, pageSize);
    }

    public BaseResponse<OrderResponse> getOrderById(long orderId)
    {
        return libraryAdpClient.getOrderById(orderId);
    }

    public BaseResponse<List<OrderResponse>> getOrdersByStudentId(
        long studentId, int pageNumber, int pageSize
    ){
        return libraryAdpClient.getOrdersByStudentId(studentId, pageNumber, pageSize);
    }

    public BaseResponse<List<OrderResponse>> getOrdersByBookId(
        long bookId, int pageNumber, int pageSize
    ){
        return libraryAdpClient.getOrdersByBookId(bookId, pageNumber, pageSize);
    }
}
