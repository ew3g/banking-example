package com.bankingexample.controller;

import com.bankingexample.dto.AccountDTO;
import com.bankingexample.model.Account;
import com.bankingexample.model.AccountStubs;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("FindAccount - Should find an existing account by its id")
    void shouldFindExistingAccount() throws Exception {
        mockMvc.perform(get("/account/{account_id}", "1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.document_number", CoreMatchers.is(AccountStubs.get().getDocumentNumber())))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("FindAccount - Should return 404 - Not Found for nonexistent account id")
    void shouldReturnNotFoundForNonExistentAccount() throws Exception {
        mockMvc.perform(get("/account/{account_id}", "99")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("SaveAccount - Should save a new account")
    void shouldSaveNewAccount() throws Exception{
        Account requestAccount = Account.builder()
                .documentNumber("12345678901")
                .build();
        mockMvc.perform(post("/accounts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestAccount)))
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("SaveAccount - Should return 500 - Account already exists")
    void shouldReturnErrorAccountAlreadyExists() throws Exception{
        AccountDTO requestAccount = AccountDTO.builder()
                .documentNumber("12345678900")
                .build();
        mockMvc.perform(post("/accounts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestAccount)))
                .andExpect(status().is5xxServerError())
                .andExpect(jsonPath("$.message", CoreMatchers.startsWith("This object already exists:")));
    }



}
