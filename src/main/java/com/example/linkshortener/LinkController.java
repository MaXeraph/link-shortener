package com.example.linkshortener;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LinkController {

    private static final String templateShorten = "http://localhost:8080/expand?surl=%s";

    public static byte[] getSHA(String input) throws NoSuchAlgorithmException 
    {  
        // Static getInstance method is called with hashing SHA  
        MessageDigest md = MessageDigest.getInstance("SHA-256");  
  
        // digest() method called  
        // to calculate message digest of an input  
        // and return array of byte 
        return md.digest(input.getBytes(StandardCharsets.UTF_8));  
    } 
    
    public static String toHexString(byte[] hash) 
    { 
        // Convert byte array into signum representation  
        BigInteger number = new BigInteger(1, hash);  
  
        // Convert message digest into hex value  
        StringBuilder hexString = new StringBuilder(number.toString(16));  
  
        // Pad with leading zeros 
        while (hexString.length() < 32)  
        {  
            hexString.insert(0, '0');  
        }  
  
        return hexString.toString();  
    } 
  
    @GetMapping("/shorten") // for POST: @PostMapping or @RequestMapping(method=POST)
    public Link shorten(@RequestParam(value = "url", defaultValue = "maxpham.dev") String url) {
        // RequestParam binds value of query "name" into parameter name
        try 
        {
            String surl = toHexString(getSHA(url));
            return new Link(String.format(templateShorten, surl.substring(0, 6)));
        }
        catch (NoSuchAlgorithmException e){
            return new Link("NoSuchAlgorithm");
        }
    }
    //TODO: Implement POST
    //TODO: implement Data Structure to save links.
    //TODO: put the Hash stuff in its own class maybe.
    //TODO: reformat this.

    @GetMapping("/expand") // for POST: @PostMapping or @RequestMapping(method=POST)
    public Link expand(@RequestParam(value = "surl", defaultValue = "000000") String surl, HttpServletResponse response) throws IOException {
        // RequestParam binds value of query "name" into parameter name
        String link = "https://maxpham.dev";
        if (surl.equals("000000")){
            link = "https://maxpham.dev";
            
        }
        response.sendRedirect(link);
        return new Link(link);
    }
}
