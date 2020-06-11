package javax.spring;

import org.assertj.core.api.AbstractIntegerAssert;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ua.ForHibernateTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ForHibernateTest.class)
public class TestList_Mockito {

    @BeforeClass
    public static void beforeClassInfp(){
        System.out.println("before class");
    }

    @AfterClass
    public static void afterClassInfo(){
        System.out.println("After class info");
    }

    @Before
    public void printInfo(){
        System.out.println("Before");
    }

    @After
    public void printInfoAfter(){
        System.out.println("after");
    }

    @Test
    public void someTest(){
        int x = 10;
        AbstractIntegerAssert<?> between = assertThat(x).isBetween(9, 20);
        System.out.println("IN test");
        int xx = 10;
    }
}
