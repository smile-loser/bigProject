package dyz.bigproject.service.impl;

import dyz.bigproject.dao.AdministratorsDao;
import dyz.bigproject.dao.impl.AdministratorsDaoImpl;
import dyz.bigproject.daomain.Administrators;
import dyz.bigproject.service.AdministratorsService;

public class AdministratorsServiceImpl implements AdministratorsService {
    private AdministratorsDao adao=new AdministratorsDaoImpl();
    @Override
    public Administrators findIt(Administrators loginUser) {
        return adao.findIt(loginUser);
    }
}
