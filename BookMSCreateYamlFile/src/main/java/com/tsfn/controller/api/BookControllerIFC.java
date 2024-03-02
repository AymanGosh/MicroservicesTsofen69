package com.tsfn.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.tsfn.model.Book;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface BookControllerIFC {
	
	@Operation(summary= "Create New Book" ,tags = {"Books", "POST"})
	@ApiResponses({
	      @ApiResponse(responseCode = "201", content = {
	          @Content(schema = @Schema(implementation = Book.class), mediaType = "application/json") }),
	      @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@PostMapping("/create")
	public ResponseEntity<Book> createBook(@RequestBody Book book) ;
}
