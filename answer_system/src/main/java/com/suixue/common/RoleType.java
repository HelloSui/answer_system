package com.suixue.common;

public enum RoleType {
	ROLE_TEACHER("1","教师"),ROLE_STUDENT("2","学生"),ROLE_VISIT("3","游客");

    private String roleId;

    private String roleName;

    private RoleType(String roleId,String roleName){
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
