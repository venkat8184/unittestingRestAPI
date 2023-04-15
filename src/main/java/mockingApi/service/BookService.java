package mockingApi.service;

import mockingApi.entities.Book;

public interface BookService {
  public boolean saveBook(Book book);
  public boolean deleteBook(long id);
}
