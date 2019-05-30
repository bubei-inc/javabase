package JavaExtend;

import JavaExtend.service.CommandService;

/**
 * @author syp
 * @package_name JavaExtend
 * @date 2019-05-29 15:03
 * @description
 **/
public class LoginCommand implements CommandService {
    @Override
    public void commandTest(String name) {
        System.out.println(name);
    }
}
