package pattren.decorator.passport.upgrede;

import pattren.decorator.passport.old.ISigninService;
import pattren.decorator.passport.old.ResultMsg;

public interface ISigninForThirdService extends ISigninService{

    public ResultMsg loginForQQ(String openId);
    public ResultMsg loginForWechat(String openId);
    public ResultMsg loginForToken(String token);
    public ResultMsg loginForTelephone(String telephone, String code);
    public ResultMsg loginForRegist(String username, String password);
}
