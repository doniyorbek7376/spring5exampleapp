package uz.doniyorbek7376.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import uz.doniyorbek7376.spring5webapp.domain.Author;
import uz.doniyorbek7376.spring5webapp.domain.Book;
import uz.doniyorbek7376.spring5webapp.domain.Publisher;
import uz.doniyorbek7376.spring5webapp.repositories.AuthorRepository;
import uz.doniyorbek7376.spring5webapp.repositories.BookRepository;
import uz.doniyorbek7376.spring5webapp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
            PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {
        initData();
    }

    private void initData() {
        // Eric
        Author eric = new Author("Eric", "Evans");
        Publisher harper = new Publisher("Harpen Collins", "Some address");
        Book ddd = new Book("Domain Driven Design", "1234", harper);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        publisherRepository.save(harper);
        authorRepository.save(eric);
        bookRepository.save(ddd);

        // Rod
        Author rod = new Author("Rod", "Johnson");
        Publisher wrox = new Publisher("Wrox", "Another address");
        Book noEJB = new Book("J2EE Development without EJB", "23444", wrox);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        publisherRepository.save(wrox);
        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }

}
