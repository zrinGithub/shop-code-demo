import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.*;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @author zhangr
 * 2020/9/16 11:00
 */
public class TestJWT {
    public static void main(String[] args) {
        Map<String, Object> header = new HashMap<>();
        header.put("type", "JWT");
        header.put("alg", "HS256");

        Map<String, Object> payload = new HashMap<>();
        payload.put("userId", "123");
        payload.put("exp", new Date().getTime() / 1000 + 1);

        //生成JWT token
        Key key = new SecretKeySpec("test-sec".getBytes(), SignatureAlgorithm.HS256.getJcaName());
        String compact = Jwts.builder().setHeader(header)
                .setPayload(JSONObject.toJSONString(payload))
                .signWith(SignatureAlgorithm.HS256, key)
                .compact();
        System.out.println(compact);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //解析token
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(key).parseClaimsJws(compact);
        JwsHeader header1 = claimsJws.getHeader();
        Claims body = claimsJws.getBody();
        System.out.println(JSONObject.toJSONString(header1));
        System.out.println(JSONObject.toJSONString(body));
    }
}
