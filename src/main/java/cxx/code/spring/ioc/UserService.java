package cxx.code.spring.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    //不需要set方法
    //添加注入属性注解
    @Autowired   //根据类型进行注入
    @Qualifier(value = "userDaoImpl")
    private UserDao userDao;

    @Value(value = "1234abcad")
    private String name;

    public void add() {
        System.out.println("Server add...");
        userDao.add();
        System.out.println(name);
    }
}
