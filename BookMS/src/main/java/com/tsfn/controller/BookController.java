package com.tsfn.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tsfn.controller.api.BookControllerIFC;
import com.tsfn.model.Book;
import com.tsfn.service.BookServices;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/books")
public class BookController implements BookControllerIFC {

	@Autowired
	BookServices bookServices;
	
	

	public ResponseEntity<Book> createBook(@RequestBody Book book) {
		try {
			Book newBook = bookServices.save(book);
			return new ResponseEntity<>(newBook, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@GetMapping("/get/{id}")
	@Operation(
		      summary = "Retrieve a Book by Id",
		      description = "Get a Book object by specifying its id. The response is Book object with id, title, description and published status.",
		      tags = { "Books", "get" })
		  @ApiResponses({
		      @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Book.class), mediaType = "application/json") }),
		      @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
		      @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	public ResponseEntity<Book> getBookById(@PathVariable("id") int id) {
		Optional<Book> book = bookServices.findByID(id);
		if(!book.isEmpty())
		{
			return new ResponseEntity<>(book.get(), HttpStatus.OK);
		}else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@Operation(summary = "Update a Book by Id", tags = { "Books", "put" })
	  @ApiResponses({
	      @ApiResponse(responseCode = "200", content = {
	          @Content(schema = @Schema(implementation = Book.class), mediaType = "application/json") }),
	      @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }),
	      @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }) })
	
	@PutMapping("/update/{id}")
	 public ResponseEntity<Book> updateBook(@PathVariable("id") int id, @RequestBody Book Book) {
		 Optional<com.tsfn.model.Book> book = bookServices.findByID(id);
		 if(book.isPresent())
		 {
			 book.get().setDescription("Hello Troy!!");
			 return new ResponseEntity<>( bookServices.save(book.get()),HttpStatus.OK);
			 
		 }else
		 {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
	 }
	
	@Operation(summary = "Delete a Book by Id", tags = { "Books", "delete" })
	  @ApiResponses({ @ApiResponse(responseCode = "204", content = { @Content(schema = @Schema()) }),
	      @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@DeleteMapping("/delete/{id}")
	 public ResponseEntity<HttpStatus> deleteBook(@PathVariable("id") int id) {
		try {
		      bookServices.deleteBook(id);
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    } catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	 }
	
	
	  @Operation(summary = "Delete all Books", tags = { "Books", "delete" })
	  @ApiResponses({ @ApiResponse(responseCode = "204", content = { @Content(schema = @Schema()) }),
	      @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@DeleteMapping("/delete")
	 public ResponseEntity<HttpStatus> deleteAllBooks() {
		    try {
		    	bookServices.deleteAll();
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    } catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		    }

		  }
}
