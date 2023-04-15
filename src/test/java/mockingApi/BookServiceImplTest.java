package mockingApi;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import mockingApi.entities.Book;
import mockingApi.repositories.BookRepository;
import mockingApi.service.BookServiceImpl;

@SpringBootTest
class BookServiceImplTest {

    @MockBean
    private BookRepository bookRepository;

    @Test
    void testSaveBook() {
        // Create a book instance for testing
        Book book = new Book();
        book.setBookName("Test Book");
        book.setBooPrice(100);

        // Create a book service instance with mocked repository
        BookServiceImpl bookService = new BookServiceImpl(bookRepository);

        // Call the saveBook method and verify that it returns true
        assertTrue(bookService.saveBook(book));

    }

}
