package pattren.decorator.passport.old;

public interface ISigninService {

    public ResultMsg regist(String username,String password);

    public ResultMsg login(String username,String password);
}
