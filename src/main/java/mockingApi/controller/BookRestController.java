package mockingApi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mockingApi.entities.Book;
import mockingApi.service.BookService;

@RestController
@RequestMapping("/api")
public class BookRestController {
	public BookRestController() {
		
	}
	public BookRestController(BookService bookService) {
		this.bookService = bookService;
	}
	private BookService bookService;
	@PostMapping("/savebook")
	public ResponseEntity<String> saveOneBook(@RequestBody Book book){
		System.out.println(book.getId());
		System.out.println(book.getBookName());
		System.out.println(book.getBookPrice());
		String msg=null;
		boolean saveBook = bookService.saveBook(book);
		if(saveBook) {
			msg="Book is Saved Successfully!";
			return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		}else {
			msg="Book is Not Saved!!";
			return new ResponseEntity<String>(msg,HttpStatus.BAD_REQUEST);
		}
		
	}
	@DeleteMapping("/{id}") 
	public ResponseEntity<?> deleteOneBook(@PathVariable long id){
		String msg=null;
		System.out.println("This is venkatrmana");
		boolean deleteBook = bookService.deleteBook(id);
		if(deleteBook) {
			msg="Deleted successfully";
			return new ResponseEntity<>(msg,HttpStatus.OK);
		}
		else {
			msg="not deleted!";
			return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
		}
				
	}

}
