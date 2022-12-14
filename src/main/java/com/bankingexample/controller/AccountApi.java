package com.bankingexample.controller;

import com.bankingexample.dto.AccountDTO;
import com.bankingexample.error.BusinessException;
import com.bankingexample.error.ErrorResponse;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Api(tags = "account")
@Validated
public interface AccountApi {
    @Operation(summary = "Find Account By Id", description = "Find an account by its id", tags={ "account" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AccountDTO.class))),
        @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ErrorResponse.class)))),
        @ApiResponse(responseCode = "404", description = "Not found", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ErrorResponse.class)))) })
    @RequestMapping(value = "/account/{accountId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<AccountDTO> findAccountByID(@Parameter(in = ParameterIn.PATH, description = "Account unique id", required=true, schema=@Schema()) @PathVariable("accountId") Long accountId);

    @Operation(summary = "Create a new account", description = "Create a new account", tags={ "account" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AccountDTO.class))),

            @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ErrorResponse.class)))) })
    @RequestMapping(value = "/accounts",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<AccountDTO> createAccount(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody AccountDTO accountDTO) throws BusinessException;
}

