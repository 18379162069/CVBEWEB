package com.cv.web.be.cvweb.shiro.realm;

import com.cv.web.be.cvweb.entity.Admin;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhou_wb on 2017/5/13.
 */
@Component
public class UserRealm extends AbstractUserRealm{

    @Override
    public UserRolesAndPermissions doGetGroupAuthorizationInfo(Admin admin) {
        Set<String> userRoles = new HashSet<>();
        Set<String> userPermissions = new HashSet<>();
        //TODO 获取当前用户下拥有的所有角色列表,及权限
        return new UserRolesAndPermissions(userRoles, userPermissions);
    }

    @Override
    public UserRolesAndPermissions doGetRoleAuthorizationInfo(Admin admin) {
        Set<String> userRoles = new HashSet<>();
        Set<String> userPermissions = new HashSet<>();
        //TODO 获取当前用户下拥有的所有角色列表,及权限
        return new UserRolesAndPermissions(userRoles, userPermissions);
    }

}
