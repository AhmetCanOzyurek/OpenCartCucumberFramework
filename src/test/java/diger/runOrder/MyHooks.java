package diger.runOrder;

import io.cucumber.java.*;

public class MyHooks {
    @BeforeAll
    public static void beforeAll(){
        System.out.println("Cucumber @BeforeAll");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("Cucumber @AfterAll ");
    }
    @Before
    public void before(){
        System.out.println("Cucumber @Before");
    }

    @After
    public void after(){
        System.out.println("Cucumber @After ");
    }
    @BeforeStep
    public void beforeStep(){
        System.out.println("Cucumber @BeforeStep");
    }

    @AfterStep
    public void afterStep(){
        System.out.println("Cucumber @AfterStep ");
    }
}
