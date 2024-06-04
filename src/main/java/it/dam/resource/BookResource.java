package it.dam.resource;

import it.dam.entity.Book;
import it.dam.service.BookService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookResource {

    private final BookService bookService;

    public BookResource(BookService bookService) {
        this.bookService = bookService;
    }

    @GET
    public Response getAll() {
        return Response.ok(bookService.findAll()).build();
    }

    @POST
    public Response create(Book entity) {
        Book book = bookService.create(entity);
        return Response.ok(book).status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/{id}")
    public Response get(@PathParam("id") Long id) {
        return Response.ok(bookService.findById(id)).build();
    }


}
