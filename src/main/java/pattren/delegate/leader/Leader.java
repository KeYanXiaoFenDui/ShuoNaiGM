package pattren.delegate.leader;

import java.util.HashMap;
import java.util.Map;

public class Leader implements ITarget{

    private Map<String,ITarget> targets = new HashMap<String,ITarget>();

    public Leader() {
        targets.put("加密",new TargetA());
        targets.put("登录",new TargetB());
    }

    @Override
    public void doing(String command) {
        targets.get(command).doing(command);
    }
}
