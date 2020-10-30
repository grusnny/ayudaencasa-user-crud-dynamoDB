package com.ayudaencasa.user.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.ayudaencasa.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {

    @Autowired
    private DynamoDBMapper mapper;

    public User addUser (User user){
        mapper.save(user);
        return user;
    }
    public User findUserByuId(String uId){
        return mapper.load(User.class,uId);
    }
    public String deleteUser (User user){
       mapper.delete(user);
       return "Usuario eliminado";
    }

    public String editUser(User user){
        mapper.save(user,buildExpression(user));
        return "Registro actualizado";
    }
    private DynamoDBSaveExpression buildExpression(User user){

        DynamoDBSaveExpression dynamoDBSaveExpression=new DynamoDBSaveExpression();
        Map<String, ExpectedAttributeValue> expectedMap=new HashMap<>();
        expectedMap.put("uId", new ExpectedAttributeValue(new AttributeValue().withS(user.getuId())));
        dynamoDBSaveExpression.setExpected(expectedMap);
        return dynamoDBSaveExpression;
    }
}
