package com.lislea.tdd.greetingkata;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class GreetingKataApplicationTests {

    @Test
    void greetReturnsHelloBob_whenPassedBob() {
        Greeting greeting = new Greeting();
        String aGreeting = greeting.greet("Bob");
        assertEquals("Hello, Bob.", aGreeting);
    }

    @Test
    void greetReturnsHelloJohn_whenPassedJohn() {
        Greeting greeting = new Greeting();
        String aGreeting = greeting.greet("John");
        assertEquals("Hello, John.", aGreeting);
    }

    @Test
    void greetReturnsHelloMyFriend_whenPassedNull() {
        Greeting greeting = new Greeting();
        String aGreeting = greeting.greet(null);
        assertEquals("Hello, my friend.", aGreeting);
    }

    @Test
    void greetReturnsHelloBobUppercase_whenPassedUppercaseBob() {
        Greeting greeting = new Greeting();
        String aGreeting = greeting.greet("BOB");
        assertEquals("HELLO BOB!", aGreeting);
    }

    @Test
    void greetReturnsHelloJillandJane_whenPassedVarArgsJillAndJane() {
        Greeting greeting = new Greeting();
        String aGreeting = greeting.greet("Jill", "Jane");
        assertEquals("Hello, Jill and Jane.", aGreeting);
    }

    @Test
    void greetReturnsHelloAllNamesWithOxfordCommanAnd_whenPassedArbitraryNumberOfNames() {
        Greeting greeting = new Greeting();
        String aGreeting = greeting.greet("Amy", "Brian", "Charlotte");
        assertEquals("Hello, Amy, Brian, and Charlotte.", aGreeting);
    }

    @Test
    void greetReturnsHelloShoutAndHelloStandard_whenPassedUpperAndLowerCase() {
        Greeting greeting = new Greeting();
        String aGreeting = greeting.greet("Amy", "BRIAN", "Charlotte");
        assertEquals("Hello, Amy and Charlotte. AND HELLO BRIAN!", aGreeting);
    }
}
