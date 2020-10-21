package DAO;

import VO.UserVO;

import java.util.List;

public interface UserDAO {
    public List<UserVO> createUser (UserVO userVO);
}
