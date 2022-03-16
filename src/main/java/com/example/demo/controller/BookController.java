package com.example.demo.controller;


import com.example.demo.model.Author;
import com.example.demo.model.Book;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Operation(summary="Get all books", operationId="list_books")
    @Parameters({
            @Parameter(name = "organizationHeader", schema = @Schema(implementation = String.class),description = "Indicates the organization")
    })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Books Information Retrieved"),
            @ApiResponse(responseCode = "403", description = "Forbidden access"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Book> getBooks(){
        Author author = Author.builder().firstName("Alin").lastName("Popescu").age(20).build();
        return List.of(
                Book.builder().title("Alba ca zapada").releaseDate(LocalDate.now()).author(author).build(),
                Book.builder().title("Scufita Rosie").releaseDate(LocalDate.now()).author(author).build()
        );
    }

    @Operation(summary="Create new book", operationId="create book")
    @Parameter(name = "organizationHeader", schema = @Schema(implementation = String.class),description = "Indicates the organization")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Book was created"),
            @ApiResponse(responseCode = "403", description = "Forbidden access"),
            @ApiResponse(responseCode = "409", description = "Book already exists"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @PostMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createBook(@RequestBody Book book){
        //save Book
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
