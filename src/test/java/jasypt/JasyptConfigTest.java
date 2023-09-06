package jasypt;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;

import org.jasypt.encryption.StringEncryptor;

@Configuration
@SpringBootTest(classes = JasyptConfig.class)
public class JasyptConfigTest {

    @Autowired
    private StringEncryptor stringEncryptor;

    @Value("${jasypt.encryptor.password}")
    String jasyptSetPassword;

    @Test
    public void 환경변수값_확인() {
        String my_local_jasypt_password_env = "password";
        assert my_local_jasypt_password_env.equals(jasyptSetPassword);
    }

    @Test
    public void 암호화_복호화_테스트() {
        String originalText = "테스트용 Text 입니다.";

        String encryptedText = stringEncryptor.encrypt(originalText); //암호화
        String decryptedText = stringEncryptor.decrypt(encryptedText); // 복호화

        assert originalText.equals(decryptedText);
    }

}
