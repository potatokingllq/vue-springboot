package com.example.crazy.utils;

import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.crazy.domain.Member;
import com.auth0.jwt.JWT;

import java.util.Date;

public class TokenUtil {
    private static final long EXPIRE_TIME= 12*60*60*1000;//token到期时间
    private static final String TOKEN_SECRET="heijiushiwanerxiangbudaobahhhhh";  //密钥盐

    /**
     * @Description  ：生成token
     * @param        : [member]
     * @return       : java.lang.String
     * @exception    :
     */
    public static String sign(Member member){

        String token=null;
        try {
            Date expireAt=new Date(System.currentTimeMillis()+EXPIRE_TIME);
            token = JWT.create()
                    .withIssuer("auth0")//发行人
                    .withClaim("userName",member.getUserName())//存放数据
                    .withExpiresAt(expireAt)//过期时间
                    .sign(Algorithm.HMAC256(TOKEN_SECRET));
        } catch (IllegalArgumentException| JWTCreationException je) {
        }
        return token;
    }


    /**
     * @Description  ：token验证
     * @param        : [token]
     * @return       : java.lang.Boolean
     * @exception    :
     */
    public static Boolean verify(String token){

        try {
            JWTVerifier jwtVerifier=JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer("auth0").build();//创建token验证器
            DecodedJWT decodedJWT=jwtVerifier.verify(token);
            System.out.println("认证通过：");
            System.out.println("userName: " + decodedJWT.getClaim("userName").asString());
            System.out.println("过期时间：      " + decodedJWT.getExpiresAt());
        } catch (IllegalArgumentException | JWTVerificationException e) {
            //抛出错误即为验证不通过
            return false;
        }
        return true;
    }
}
