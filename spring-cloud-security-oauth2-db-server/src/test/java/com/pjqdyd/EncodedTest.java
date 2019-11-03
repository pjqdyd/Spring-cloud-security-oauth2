package com.pjqdyd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EncodedTest {

    /**
     * 测试生成"secret"字符加密后的密文
     */
    @Test
    public void testEncoded(){
        String s = new BCryptPasswordEncoder().encode("secret");
        System.out.println(s);
    }
}
