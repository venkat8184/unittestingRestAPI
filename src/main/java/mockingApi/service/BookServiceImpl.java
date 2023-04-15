package mockingApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mockingApi.entities.Book;
import mockingApi.repositories.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	
	public BookServiceImpl(mockingApi.repositories.BookRepository bookRepository) {
		super();
		BookRepository = bookRepository;
	}

	private BookRepository BookRepository;

	@Override
	public boolean saveBook(Book book) {
		BookRepository.save(book);
		return true;
	}

	@Override
	public boolean deleteBook(long id) {
		BookRepository.deleteById(id);
		return true;
	}

}
