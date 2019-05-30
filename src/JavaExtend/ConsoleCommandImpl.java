package JavaExtend;

import JavaExtend.service.CommandService;

/**
 * @author syp
 * @package_name JavaExtend
 * @date 2019-05-29 15:02
 * @description
 **/
public class ConsoleCommandImpl implements CommandService {
    private String name ;

    public String getName() {
        return name;
    }

    ConsoleCommandImpl(String name) {
        this.name = name;
    }
    @Override
    public void commandTest(String name) {
        System.out.println(age);
        System.out.println(name);
        System.out.println(this.name);
    }

    public void testXingCanIsImplementsName(CommandService commandService) {
        System.out.println(commandService);

    }

}
