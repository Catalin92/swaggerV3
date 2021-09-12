package com.example.demo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController("/swagger")
public class TestController {

  @Operation(summary="Getting all the books in DB", operationId="GET_GetAllBooks")
  @Parameters({
      @Parameter(name = "organizationHeader", in = ParameterIn.QUERY, description = "Indicates the organization",
          schema = @Schema(defaultValue = "false",  example = "false", type = "boolean"))
  })
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Books Information Retrieved"),
      @ApiResponse(responseCode = "403", description = "Forbidden access"),
      @ApiResponse(responseCode = "500", description = "Internal Server Error")
  })
  @GetMapping(value = "/getList", produces = APPLICATION_JSON_VALUE)
  public Book getBooks(){
    return new Book();
  }

  @Operation(summary="Create a new book", operationId="POST_CreateBook")
  @Parameter(name = "organizationHeader", in = ParameterIn.QUERY, description = "Indicates the organization",
      schema = @Schema(example = "something", type = "string"))
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "Book was created"),
      @ApiResponse(responseCode = "403", description = "Forbidden access"),
      @ApiResponse(responseCode = "409", description = "Book already exists"),
      @ApiResponse(responseCode = "500", description = "Internal Server Error")
  })
  @PostMapping(value ="/create", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
  public String postBook(@RequestBody Book book){
    //save book
    return "Created";
  }


  @Operation(summary="Delete a book", operationId="DELETE_RemoveBook")
  @Parameter(name = "organizationHeader", in = ParameterIn.QUERY, description = "Indicates the organization",
      schema = @Schema(example = "something", type = "string"))
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Book was removed"),
      @ApiResponse(responseCode = "403", description = "Forbidden access"),
      @ApiResponse(responseCode = "404", description = "Book not found"),
      @ApiResponse(responseCode = "500", description = "Internal Server Error")
  })
  @DeleteMapping("/delete/{id}")
  public String deleteBook(@Parameter(name = "bookID") @PathVariable("id") String id){
    return "DELETE_LIST";
  }

}

