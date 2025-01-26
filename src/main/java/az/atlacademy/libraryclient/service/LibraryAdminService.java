package az.atlacademy.libraryclient.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import az.atlacademy.libraryclient.client.LibraryAdpClient;
import az.atlacademy.libraryclient.model.dto.request.AuthorRequest;
import az.atlacademy.libraryclient.model.dto.request.BookRequest;
import az.atlacademy.libraryclient.model.dto.request.CategoryRequest;
import az.atlacademy.libraryclient.model.dto.request.OrderRequest;
import az.atlacademy.libraryclient.model.dto.request.StudentRequest;
import az.atlacademy.libraryclient.model.dto.response.BaseResponse;
import az.atlacademy.libraryclient.model.dto.response.StudentResponse;

@Service(value = "libraryAdminService")
public class LibraryAdminService extends LibraryService
{
    public LibraryAdminService(LibraryAdpClient libraryAdpClient)
    {
        super(libraryAdpClient);
    }

    public BaseResponse<Void> createAuthor(AuthorRequest authorRequest)
    {
        return libraryAdpClient.createAuthor(authorRequest);        
    }

    public BaseResponse<Void> updateAuthor(long authorId, AuthorRequest authorRequest)
    {
        return libraryAdpClient.updateAuthor(authorId, authorRequest);
    }

    public BaseResponse<Void> deleteAuthor(long authorId)
    {
        return libraryAdpClient.deleteAuthor(authorId); 
    }

    public BaseResponse<Void> createBook(BookRequest bookRequest)
    {
        return libraryAdpClient.createBook(bookRequest);
    }

    public BaseResponse<Void> updateBook(long bookId, BookRequest bookRequest)
    {
        return libraryAdpClient.updateBook(bookId, bookRequest);
    }

    public BaseResponse<Void> deleteBook(long bookId)
    {
        return libraryAdpClient.deleteBook(bookId);
    }

    public BaseResponse<Void> updateBookStock(long bookId, int stock)
    {
        return libraryAdpClient.updateBookStock(bookId, stock);
    }

    public BaseResponse<Void> uploadBookImage(long bookId, MultipartFile file)
    {
        return libraryAdpClient.uploadBookImage(bookId, file);
    }

    public BaseResponse<Void> createCategory(CategoryRequest categoryRequest)
    {
        return libraryAdpClient.createCategory(categoryRequest);
    }

    public BaseResponse<Void> updateCategory(long categoryId, CategoryRequest categoryRequest)
    {
        return libraryAdpClient.updateCategory(categoryId, categoryRequest);
    }

    public BaseResponse<Void> deleteCategory(long categoryId)
    {
        return libraryAdpClient.deleteCategory(categoryId);
    }

    public BaseResponse<Void> createOrder(OrderRequest orderRequest)
    {
        return libraryAdpClient.createOrder(orderRequest);
    }

    public BaseResponse<Void> updateOrder(long orderId, OrderRequest orderRequest)
    {
        return libraryAdpClient.updateOrder(orderId, orderRequest);
    }

    public BaseResponse<Void> deleteOrder(long orderId)
    {
        return libraryAdpClient.deleteOrder(orderId);
    }

    public BaseResponse<Void> returnOrderBook(long orderId)
    {
        return libraryAdpClient.returnOrderBook(orderId);
    }

    public BaseResponse<Void> createStudent(StudentRequest studentRequest)
    {
        return libraryAdpClient.createStudent(studentRequest);
    }

    public BaseResponse<StudentResponse> getStudentByFinCode(String finCode)
    {
        return libraryAdpClient.getStudentByFinCode(finCode);
    }

    public BaseResponse<StudentResponse> getStudentById(long studentId)
    {
        return libraryAdpClient.getStudentById(studentId);
    }

    public BaseResponse<List<StudentResponse>> getStudents(int pageNumber, int pageSize)
    {
        return libraryAdpClient.getStudents(pageNumber, pageSize);
    }

    public BaseResponse<Void> updateStudent(long studentId, StudentRequest studentRequest)
    {
        return libraryAdpClient.updateStudent(studentId, studentRequest);
    }

    public BaseResponse<Void> deleteStudent(long studentId)
    {
        return libraryAdpClient.deleteStudent(studentId);
    }

    public BaseResponse<Void> updateStudentTrustRate(long studentId, int trustRate)
    {
        return libraryAdpClient.updateStudentTrustRate(studentId, trustRate);
    }
}
