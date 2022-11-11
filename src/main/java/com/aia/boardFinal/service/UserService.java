package com.aia.boardFinal.service;

import com.aia.boardFinal.model.UserDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserService {
    @Autowired
    private SqlSession session;
    private final String NAMESPACE = "UserMapper";

    public UserDTO auth(UserDTO userDTO) {
        return session.selectOne(NAMESPACE + ".auth", userDTO);
    }

    public UserDTO validateUsername(UserDTO userDTO){
        return session.selectOne(NAMESPACE + ".validateUsername", userDTO);
    }

    public void register(UserDTO userDTO){
        session.insert(NAMESPACE+".register", userDTO);
    }

}
