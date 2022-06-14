package cxx.code.spring.ioc;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{

    @Override
    public void add() {
        System.out.println(" xdao add....");
    }
}
