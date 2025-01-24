package az.atlacademy.libraryclient.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import az.atlacademy.libraryclient.config.LibraryAdpClientConfig;
import az.atlacademy.libraryclient.model.dto.request.AuthorRequest;
import az.atlacademy.libraryclient.model.dto.request.BookRequest;
import az.atlacademy.libraryclient.model.dto.request.CategoryRequest;
import az.atlacademy.libraryclient.model.dto.request.LoginRequest;
import az.atlacademy.libraryclient.model.dto.request.OrderRequest;
import az.atlacademy.libraryclient.model.dto.request.StudentRequest;
import az.atlacademy.libraryclient.model.dto.response.AuthorResponse;
import az.atlacademy.libraryclient.model.dto.response.BaseResponse;
import az.atlacademy.libraryclient.model.dto.response.BookResponse;
import az.atlacademy.libraryclient.model.dto.response.CategoryResponse;
import az.atlacademy.libraryclient.model.dto.response.LoginResponse;
import az.atlacademy.libraryclient.model.dto.response.OrderResponse;
import az.atlacademy.libraryclient.model.dto.response.StudentResponse;


@FeignClient(
    name = "library-adp-client", 
    url = "${application.feign-client-url.libraryadp}",
    configuration = LibraryAdpClientConfig.class
)
public interface LibraryAdpClient 
{
    @PostMapping(value = "/auth/authenticate")
    public BaseResponse<LoginResponse> authenticateAdminUser(@RequestBody LoginRequest loginRequest);

    @GetMapping(value = "/auth/is-authenticated")
    public BaseResponse<Boolean> isAuthenticated();

    @PostMapping(value = "/api/v1/author")
    public BaseResponse<Void> createAuthor(@RequestBody AuthorRequest authorRequest);

    @GetMapping(value = "/api/v1/author")
    public BaseResponse<List<AuthorResponse>> getAuthors(
        @RequestParam(value = "pageNumber", required = false, defaultValue = "0") int pageNumber,
        @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize
    );

    @GetMapping(value = "/api/v1/author/search-by-full-name")
    public BaseResponse<List<AuthorResponse>> searchAuthorsByFullName(
        @RequestParam(value = "fullName") String fullName,
        @RequestParam(value = "pageNumber", required = false, defaultValue = "0") int pageNumber,
        @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize
    );

    @GetMapping(value = "/api/v1/author/{id}")
    public BaseResponse<AuthorResponse> getAuthorById(@PathVariable(value = "id") long authorId);

    @PutMapping(value = "/api/v1/author/{id}")
    public BaseResponse<Void> updateAuthor(
        @PathVariable(value = "id") long authorId, 
        @RequestBody AuthorRequest authorRequest
    );

    @DeleteMapping(value = "/api/v1/author/{id}")
    public BaseResponse<Void> deleteAuthor(@PathVariable(value = "id") long authorId);

    @PostMapping(value = "/api/v1/book")
    public BaseResponse<Void> createBook(@RequestBody BookRequest bookRequest);

    @GetMapping(value = "/api/v1/book/{id}")
    public BaseResponse<BookResponse> getBookById(@PathVariable(value = "id") long bookId);

    @GetMapping(value = "/api/v1/book")
    public BaseResponse<List<BookResponse>> getBooks(
        @RequestParam(value = "pageNumber", required = false, defaultValue = "0") int pageNumber,
        @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize
    );

    @GetMapping(value = "/api/v1/book/get-by-category-id")
    public BaseResponse<List<BookResponse>> getBooksByCategoryId(
        @RequestParam(value = "categoryId", required = true) long categoryId,
        @RequestParam(value = "pageNumber", required = false, defaultValue = "0") int pageNumber,
        @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize
    );

    @GetMapping(value = "/api/v1/book/get-by-author-id")
    public BaseResponse<List<BookResponse>> getBooksByAuthorId(
        @RequestParam(value = "authorId", required = true) long authorId,
        @RequestParam(value = "pageNumber", required = false, defaultValue = "0") int pageNumber,
        @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize
    );

    @GetMapping(value = "/api/v1/book/search-by-title")
    public BaseResponse<List<BookResponse>> searchBooksByTitle(
        @RequestParam(value = "title", required = true) String title,
        @RequestParam(value = "pageNumber", required = false, defaultValue = "0") int pageNumber,
        @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize
    );

    @PutMapping(value = "/api/v1/book/{id}")
    public BaseResponse<Void> updateBook(
        @PathVariable(value = "id") long bookId, 
        @RequestBody BookRequest bookRequest
    );

    @DeleteMapping(value = "/api/v1/book/{id}")
    public BaseResponse<Void> deleteBook(@PathVariable(value = "id") long bookId);

    @PatchMapping(value = "/api/v1/book/{id}/update-stock")
    public BaseResponse<Void> updateBookStock(
        @PathVariable(value = "id") long bookId,
        @RequestParam(value = "stock", required = true) int stock
    );

    @PostMapping(value = "/api/v1/book/{id}/upload-image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<BaseResponse<Void>> uploadBookImage(
        @PathVariable(value = "id") long bookId,
        @RequestParam(value = "file", required = true) MultipartFile file
    );

    @PostMapping(value = "/api/v1/category")
    public BaseResponse<Void> createCategory(@RequestBody CategoryRequest categoryRequest);

    @GetMapping(value = "/api/v1/category")
    public BaseResponse<List<CategoryResponse>> getAllCategories();

    @GetMapping(value = "/api/v1/category/{id}")
    public BaseResponse<CategoryResponse> getCategoryById(@PathVariable(value = "id") long categoryId);

    @PutMapping(value = "/api/v1/category/{id}")
    public BaseResponse<Void> updateCategory(
        @PathVariable(value = "id") long categoryId, 
        @RequestBody CategoryRequest categoryRequest
    );

    @DeleteMapping(value = "/api/v1/category/{id}")
    public BaseResponse<Void> deleteCategory(@PathVariable(value = "id") long categoryId);

    @PostMapping(value = "/api/v1/order")
    public BaseResponse<Void> createOrder(@RequestBody OrderRequest orderRequest);

    @GetMapping(value = "/api/v1/order")
    @ResponseStatus(value = HttpStatus.OK)
    public BaseResponse<List<OrderResponse>> getOrders(
        @RequestParam(value = "pageNumber", required = false, defaultValue = "0") int pageNumber,
        @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize
    );

    @GetMapping(value = "/api/v1/order/{id}")
    public BaseResponse<OrderResponse> getOrderById(@PathVariable(value = "id") long orderId);

    @GetMapping(value = "/api/v1/order/get-by-student-id")
    public BaseResponse<List<OrderResponse>> getOrdersByStudentId(
        @RequestParam(value = "studentId") long studentId, 
        @RequestParam(value = "pageNumber", required = false, defaultValue = "0") int pageNumber,
        @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize
    );

    @GetMapping(value = "/api/v1/order/get-by-book-id")
    public BaseResponse<List<OrderResponse>> getOrdersByBookId(
        @RequestParam(value = "bookId") long bookId,
        @RequestParam(value = "pageNumber", required = false, defaultValue = "0") int pageNumber,
        @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize
    );

    @PutMapping(value = "/api/v1/order/{id}")
    public BaseResponse<Void> updateOrder(
        @PathVariable(value = "id") long orderId,
        @RequestBody OrderRequest orderRequest
    );

    @DeleteMapping(value = "/api/v1/order/{id}")
    public BaseResponse<Void> deleteOrder(@PathVariable(value = "id") long orderId);

    @PostMapping(value = "/api/v1/order/{id}/return-order-book")
    public BaseResponse<Void> returnOrderBook(@PathVariable(value = "id") long orderId);

    @PostMapping(value = "/api/v1/student")
    public BaseResponse<Void> createStudent(@RequestBody StudentRequest studentRequest);

    @GetMapping(value = "/api/v1/student/get-by-fin-code")
    public BaseResponse<StudentResponse> getStudentByFinCode(
        @RequestParam(value = "finCode", required = true) String finCode
    );

    @GetMapping(value = "/api/v1/student/{id}")
    public BaseResponse<StudentResponse> getStudentById(@PathVariable(value = "id") long studentId);

    @GetMapping(value = "/api/v1/student")
    @ResponseStatus(value = HttpStatus.OK)
    public BaseResponse<List<StudentResponse>> getStudents(
        @RequestParam(value = "pageNumber", required = false, defaultValue = "0") int pageNumber,
        @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize
    );

    @PutMapping(value = "/api/v1/student/{id}")
    public BaseResponse<Void> updateStudent(
        @PathVariable(value = "id") long studentId, 
        @RequestBody StudentRequest studentRequest
    );

    @DeleteMapping(value = "/api/v1/student/{id}")
    public BaseResponse<Void> deleteStudent(@PathVariable(value = "id") long studentId);

    @PatchMapping(value = "/api/v1/student/{id}/update-trust-rate")
    public BaseResponse<Void> updateStudentTrustRate(
        @PathVariable(value = "id") long studentId,
        @RequestParam(value = "trustRate", required = true) int trustRate
    );

}
