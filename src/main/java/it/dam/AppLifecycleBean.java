package it.dam;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import it.dam.entity.Book;
import it.dam.repository.BookRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.transaction.Transactional;
import org.jboss.logging.Logger;

@ApplicationScoped
public class AppLifecycleBean {
    private final BookRepository bookRepository;

    private static final Logger LOGGER = Logger.getLogger("ListenerBean");

    public AppLifecycleBean(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional
    void onStart(@Observes StartupEvent ev) {
        LOGGER.info("The application is starting...");
        bookRepository.persist(Book.builder()
                .name("Clean Code")
                .author("Robert C. Martin")
                .description("E' un manuale fondamentale che insegna ai programmatori come scrivere codice leggibile, manutenibile e di alta qualità attraverso principi, pratiche e studi di caso.")
                .urlImage("https://m.media-amazon.com/images/I/51E2055ZGUL._SL1000_.jpg")
                .build());

        bookRepository.persist(Book.builder()
                .name("Clean Craftsmanship")
                .author("Robert C. Martin")
                .description("E' un libro che esplora le pratiche e i principi essenziali per sviluppare software di alta qualità, enfatizzando l'importanza della disciplina, degli standard professionali e dell'etica nello sviluppo software.")
                .urlImage("https://m.media-amazon.com/images/I/61Pk6qD6stL._SL1360_.jpg")
                .build());

        bookRepository.persist(Book.builder()
                .name("The Pragmatic Programmer")
                .author("Andrew Hunt")
                .description("E' un libro guida essenziale per sviluppatori software, che offre consigli pratici, tecniche e best practice per migliorare le proprie abilità di programmazione e diventare programmatori più efficienti, adattabili e di successo.")
                .urlImage("https://m.media-amazon.com/images/I/71f1jieYHNL._SL1043_.jpg")
                .build());

        bookRepository.persist(Book.builder()
                .name("Refactoring")
                .author("Martin Fowler")
                .description("E' un libro che insegna come migliorare la struttura interna del codice esistente senza alterarne il comportamento esterno, attraverso tecniche sistematiche di refactoring per rendere il codice più leggibile, manutenibile e estensibile.")
                .urlImage("https://m.media-amazon.com/images/I/71e6ndHEwqL._SL1500_.jpg")
                .build());

        bookRepository.persist(Book.builder()
                .name("Design Patterns")
                .author("Erich Gamma")
                .description("E' un libro fondamentale che presenta 23 modelli di progettazione per creare soluzioni riutilizzabili e eleganti a problemi comuni nello sviluppo di software orientato agli oggetti.")
                .urlImage("https://m.media-amazon.com/images/I/71vHHHTWUUL._SL1498_.jpg")
                .build());
    }

    void onStop(@Observes ShutdownEvent ev) {
        LOGGER.info("The application is stopping...");
    }
}
