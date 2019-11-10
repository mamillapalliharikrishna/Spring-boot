package com.sathya;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class App 
{
    public static void main( String[] args )
    {
        RestTemplate      restTemplate=new  RestTemplate();
      /* ResponseEntity<List<UserDTO>>   re=restTemplate.exchange("http://localhost:4343/UserApi/users/all", HttpMethod.GET,null,new  ParameterizedTypeReference<List<UserDTO>>() {});
       List<UserDTO>    list = re.getBody();
       for(UserDTO     dto :  list) {
    	   System.out.println(dto.getUserId());
    	   System.out.println(dto.getUserName());
    	   System.out.println(dto.getPhoneNo());
    	   System.out.println("=================");
       }*/
       
        
       /* ResponseEntity<UserDTO>   re =restTemplate.exchange("http://localhost:4343/UserApi/users/102", HttpMethod.GET, null, new  ParameterizedTypeReference<UserDTO>() {});
        UserDTO    dto = re.getBody();
        System.out.println(dto.getUserId());
 	   System.out.println(dto.getUserName());
 	   System.out.println(dto.getPhoneNo());*/
 	   System.out.println("==================");
 	   
 	   //create  user
 	   /*UserDTO    userDto=new  UserDTO();
 	   userDto.setUserId(103);
 	   userDto.setUserName("C");
 	   userDto.setPhoneNo(89902431L);
 	   String     str =restTemplate.postForObject("http://localhost:4343/UserApi/create", userDto, String.class);
 	   System.out.println(str);*/
 	   
 	   System.out.println("==========================");
 	   System.out.println("delete  user");
 	   
 	   ResponseEntity<String>   re= restTemplate.exchange("http://localhost:4343/UserApi/delete?userid=103",HttpMethod.DELETE, null, new ParameterizedTypeReference<String>() { });
 	   String   message= re.getBody();
 	   System.out.println(message);
 	
    }
}








