package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import guru.springframework.spring5webapp.repository.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {
	
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;

	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Author john = new Author("John", "Doe");
		Book cci = new Book("Cracking the coding interview", "1213242343");
		john.getBooks().add(cci);
		cci.getAuthors().add(john);
		
		authorRepository.save(john);
		bookRepository.save(cci);
		
		Author thomas = new Author("Thomas","Edision");
		Book pfa = new Book("Physics for all","1234332323");
		thomas.getBooks().add(pfa);
		pfa.getAuthors().add(thomas);
		authorRepository.save(thomas);
		bookRepository.save(pfa);

		Publisher pub = new Publisher("McDowel","Bangalore","Bangalore","Karnataka", "5600012");
		publisherRepository.save(pub);
		
		
		System.out.println("Number of Authors: "+this.authorRepository.count());
		System.out.println("Number of Books: "+this.bookRepository.count());
		System.out.println("Number of Publishers: "+this.publisherRepository.count());
	}

}
