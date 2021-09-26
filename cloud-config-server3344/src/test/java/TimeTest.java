import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

import java.time.ZonedDateTime;

/**
 * @author huanli9
 * @description
 * @date 2021/3/17 22:00
 */
public class TimeTest {
    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);

        Digester md5 = new Digester(DigestAlgorithm.MD5);
        // b0379e4cbeaa6d5addcb5b734d2480ec
        String secret = md5.digestHex("test161613410100001testSecret");
        System.out.println(secret);

    }
}
