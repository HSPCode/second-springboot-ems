import com.hsp.AppInner;
import com.hsp.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppInner.class)
public class TestUser {
    @Autowired
    private UserService service;

    @Test
    public void test1() {
        System.out.println("123456");
        System.out.println("654321");
    }
}
