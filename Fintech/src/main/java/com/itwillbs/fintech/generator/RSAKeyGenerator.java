package com.itwillbs.fintech.generator;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;

import org.springframework.stereotype.Component;

@Component
public class RSAKeyGenerator {
//	private KeyPairGenerator keyPairGenerator;
    private KeyPair keyPair;
    private KeyFactory keyFactory;
    
    private String algorithmName = "RSA";
    
    public RSAKeyGenerator() {
        try {
            // RSA 알고리즘을 사용하여 개인키와 공개키 생성
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(algorithmName);
            keyPairGenerator.initialize(2048);
            keyPair = keyPairGenerator.genKeyPair();
            keyFactory = KeyFactory.getInstance(algorithmName);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
    
    public PrivateKey getPrivateKey() {
    	PrivateKey privateKey = keyPair.getPrivate(); // 생성된 개인키 얻어오기
    	System.out.println("개인키 : " + privateKey.toString());
    	return privateKey;
    }
    
    public PublicKey getPublicKey() {
        PublicKey publicKey = keyPair.getPublic(); // 생성된 공개키 얻어오기
        System.out.println("공개키 : " + publicKey.toString());
        return publicKey;
    }
    
    public String getModulus(PublicKey publicKey) {
    	String publicModulus = "";
		try {
			RSAPublicKeySpec publicSpec = (RSAPublicKeySpec)keyFactory.getKeySpec(publicKey, RSAPublicKeySpec.class);
			publicModulus = publicSpec.getModulus().toString(16);
			System.out.println("publicModulus : " + publicModulus);
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
    	return publicModulus;
    }
    
    public String getPublicExponent(PublicKey publicKey) {
    	String publicExponent = "";
    	try {
    		RSAPublicKeySpec publicSpec = (RSAPublicKeySpec)keyFactory.getKeySpec(publicKey, RSAPublicKeySpec.class);
    		publicExponent = publicSpec.getPublicExponent().toString(16);
    		System.out.println("publicExponent : " + publicExponent);
    	} catch (InvalidKeySpecException e) {
    		e.printStackTrace();
    	}
    	
    	return publicExponent; 
    }
    
}

















