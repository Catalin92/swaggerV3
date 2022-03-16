package com.example.demo.controller;


import com.example.demo.model.Author;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {

  @Operation(summary="Getting all the authors", operationId="list_authors")
  @Parameters({
      @Parameter(name = "organizationHeader", schema = @Schema(implementation = String.class), description = "Indicates the organization")
  })
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Author Information Retrieved"),
      @ApiResponse(responseCode = "403", description = "Forbidden access"),
      @ApiResponse(responseCode = "500", description = "Internal Server Error")
  })
  @GetMapping(produces = APPLICATION_JSON_VALUE)
  public List<Author> getAuthors(){
    return List.of(
            Author.builder().firstName("Alin").lastName("Popescu").age(20).build(),
            Author.builder().firstName("Valentin").lastName("Andrei").age(33).build(),
            Author.builder().firstName("Ioana").lastName("Mircea").age(23).build()
    );
  }

  @Operation(summary="Get author by id", operationId="read_author")
  @Parameters({
          @Parameter(name = "organizationHeader", schema = @Schema(implementation = String.class), description = "Indicates the organization")
  })
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Author Information Retrieved"),
          @ApiResponse(responseCode = "403", description = "Forbidden access"),
          @ApiResponse(responseCode = "500", description = "Internal Server Error")
  })
  @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
  public List<Author> getAuthorById(@PathVariable("id") String id){
    return List.of(
            Author.builder().firstName("Alin").lastName("Popescu").age(20).build(),
            Author.builder().firstName("Valentin").lastName("Andrei").age(33).build(),
            Author.builder().firstName("Ioana").lastName("Mircea").age(23).build()
    );
  }

  @Operation(summary="Create a new author", operationId="create author")
  @Parameter(name = "organizationHeader", schema = @Schema(implementation = String.class), description = "Indicates the organization")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "Author was created"),
      @ApiResponse(responseCode = "403", description = "Forbidden access"),
      @ApiResponse(responseCode = "409", description = "Author already exists"),
      @ApiResponse(responseCode = "500", description = "Internal Server Error")
  })
  @PostMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
  public ResponseEntity<String> createAuthor(@RequestBody Author author){
    //save Author
    return new ResponseEntity<>(HttpStatus.CREATED);
  }


  @Operation(summary="Delete author", operationId="remove_author")
  @Parameter(name = "organizationHeader", schema = @Schema(implementation = String.class) ,description = "Indicates the organization")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Author was removed"),
      @ApiResponse(responseCode = "403", description = "Forbidden access"),
      @ApiResponse(responseCode = "404", description = "Author not found"),
      @ApiResponse(responseCode = "500", description = "Internal Server Error")
  })
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteAuthor(@Parameter(name = "AuthorID") @PathVariable("id") String id){
    return new ResponseEntity<>(HttpStatus.OK);
  }

}
