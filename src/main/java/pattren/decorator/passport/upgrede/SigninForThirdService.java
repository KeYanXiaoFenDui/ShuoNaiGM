package pattren.decorator.passport.upgrede;

import pattren.decorator.passport.old.ISigninService;
import pattren.decorator.passport.old.ResultMsg;

public class SigninForThirdService implements ISigninForThirdService{

    private ISigninService service;
    public SigninForThirdService(ISigninService service){
        this.service = service;
    }

    @Override
    public ResultMsg regist(String username, String password) {
        return service.regist(username, password);
    }

    @Override
    public ResultMsg login(String username, String password) {
        return service.login(username, password);
    }

    public ResultMsg loginForQQ(String openId){
        //1.openId是全局唯一,我们可以把它当做是一个用户名(加长)
        //2.密码默认为   qq_empty
        //3.注册(在原有系统里面创建一个用户)

        //4.调用原来的登录方法
        return loginForRegist(openId,null);
    }
    public ResultMsg loginForWechat(String openId){
        return null;
    }
    public ResultMsg loginForToken(String token){
        //通过token拿到用户信息,然后重新登陆了一次
        return null;
    }
    public ResultMsg loginForTelephone(String telephone, String code){
        return null;
    }
    public ResultMsg loginForRegist(String username, String password){
        this.regist(username,null);
        //4.调用原来的登录方法
        return this.login(username,null);
    }


}
