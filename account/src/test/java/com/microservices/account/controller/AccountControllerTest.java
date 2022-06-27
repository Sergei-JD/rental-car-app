package com.microservices.account.controller;

import com.microservices.account.IntegrationBaseTest;
import com.microservices.account.entity.Account;
import com.microservices.account.repository.AccountRepository;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@Transactional
@SpringBootTest
@AutoConfigureMockMvc
class AccountControllerTest extends IntegrationBaseTest {

    private static final ObjectMapper om = new ObjectMapper();

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DirtiesContext
    void givenAccounts_whenGetAllAccounts_thenReturnListOfAccounts() throws Exception {
        // given - setup or precondition
        List<Account> accounts =
                List.of(Account.builder().id(1L).nickName("Inav").password("1111").build(),
                        Account.builder().id(2L).nickName("Petr").password("2222").build());
        accountRepository.saveAll(accounts);

        // when - action
        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get("/v1/accounts"));

        // then - verify the output
        response.andExpect(MockMvcResultMatchers.status().isOk());
//        response.andExpect(MockMvcResultMatchers.jsonPath("$.size()", CoreMatchers.is(accountss.size())));
    }


    @Test
    @DirtiesContext
    void givenAccountById_whenGetAccountById_thenReturnAccountById() throws Exception {
        // given - setup or precondition
        Long accountId = 1L;
        List<Account> accounts =
                List.of(Account.builder().id(1L).nickName("Inav").password("1111").build(),
                        Account.builder().id(2L).nickName("Petr").password("2222").build());
        accountRepository.saveAll(accounts);

        // when - action
        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get("/v1/accounts/{id}", accountId));

        // then - verify the output
        response.andExpect(MockMvcResultMatchers.status().isOk());
//        response.andExpect(MockMvcResultMatchers.jsonPath("$.size()", CoreMatchers.is(1)));
    }

}
