package dyz.bigproject.service;

import dyz.bigproject.daomain.Administrators;

/*用户管理的业务接口*/
public interface AdministratorsService {
    /**
     * 查询所有用户信息
     * @return
     */
    public Administrators findIt(Administrators loginUser);
}
