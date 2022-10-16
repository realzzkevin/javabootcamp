package com.example;

import org.testng.annotations.Test;
import org.mockito.Mockito;



import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
//import static org.mockito.ArgumentMatchers.anyString;


public class AccountManagerTest {

    @Test
    public void withoutMocks() {
        SimpleFormatChecker simpleFormatChecker = new SimpleFormatChecker();
        SimpleAccountRepository simpleAccountRepository = new SimpleAccountRepository();

        AccountManager accountManager = new AccountManager(simpleFormatChecker, simpleAccountRepository);

        assert(accountManager.CreateNew("username", "passw0rd"));

    }

    @Test
    public void withMockedObject() {
        FormatChecker formatChecker = mock(FormatChecker.class);
        doReturn(true).when(formatChecker).ValidateUsername("username");
        doReturn(true).when(formatChecker).ValidateUsername("danimalthemainal");
//        doReturn(true).when(formatChecker).ValidateUsername("username2");
        doReturn(true).when(formatChecker).ValidatePassword("passw0rd");
        doReturn(true).when(formatChecker).ValidatePassword("supsersecetshhhh1");

        AccountRepository accountRepository = mock(AccountRepository.class);
        doReturn(true).when(accountRepository).CreateAccount("username", "passw0rd");

        AccountManager accountManager = new AccountManager(formatChecker, accountRepository);
        assertTrue(accountManager.CreateNew("username", "passw0rd"));
//        assertTrue(accountManager.CreateNew("username2", "passw0rd2"));
    }

    @Test
    public void withSpied() {
        FormatChecker spyFormatCheck = spy(SimpleFormatChecker.class);
    }
}