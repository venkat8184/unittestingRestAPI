package mockingApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import mockingApi.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
public boolean dleteBookById(long id);
}
