package pattren.adapter.passport;

import pattren.adapter.Member;
import pattren.adapter.ResultMsg;

public class SiginService {

    /**
     * 注册方法
     * @param username
     * @param password
     * @return
     */
    public ResultMsg regist(String username,String password){
        return new ResultMsg(200,"注册成功",new Member());
    }

    /**
     * 登录方法
     * @param username
     * @param password
     * @return
     */
    public ResultMsg login(String username,String password){
        return null;
    }
}
