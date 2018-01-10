package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

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
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        // Eric
        Author eric = new Author("Eric", "Evans");
        Publisher hc = new Publisher("Harper Collins", "NY");
        Book ddd = new Book("Domain Driven Design", "1234", hc);
        ddd.getAuthors().add(eric);
//        eric.getBooks().add(ddd);

        publisherRepository.save(hc);
        // mappedBy side of ManyToMany relationship save first
        authorRepository.save(eric);
        bookRepository.save(ddd);

        // Rod
        Author rod = new Author("Rod", "Johnson");
        Publisher wrox = new Publisher("Wrox", "LA");
        Book noEJB = new Book("J2EE Development without EJB", "23444", wrox);
        noEJB.getAuthors().add(rod);
//        rod.getBooks().add(noEJB);

        publisherRepository.save(wrox);
        // mappedBy side of ManyToMany relationship save first
        authorRepository.save(rod);
        bookRepository.save(noEJB);

    }

}
