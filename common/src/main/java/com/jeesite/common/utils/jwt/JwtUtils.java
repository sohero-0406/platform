package com.jeesite.common.utils.jwt;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtils {

    /**
     * 有效期限
     */
    private static final int expire = 6;
    /**
     * 存储 token
     */
    private static final String header = "Token";

    /**
     * 密码
     */
    private static final String secret = "61D73234C4F93E03074D74D74D1E39D9 ";

    /**
     * 生成jwt token
     *
     * @param commonUserId
     *            用户ID
     * @return token
     */
    public static  String generateToken(String commonUserId) {
        Date nowDate = new Date();
        return Jwts.builder().setHeaderParam("type", "JWT")
                .setSubject(commonUserId).setIssuedAt(nowDate)
                .setExpiration(DateUtils.addHours(nowDate, expire))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    /**
     * 解析 token， 利用 jjwt 提供的parser传入秘钥，
     *
     * @param token
     *            token
     * @return 数据声明 Map<String, Object>
     */

    public static Claims getClaimByToken(String token) {
        try {
            return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * token是否过期
     *
     * @return true：过期
     */

    public static boolean isTokenExpired(Date expiration) {
        return expiration.before(new Date());
    }

    public static int getExpire() {
        return expire;
    }

    public static String getHeader() {
        return header;
    }

    public static String getSecret() {
        return secret;
    }

}
