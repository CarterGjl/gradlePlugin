package cmd.test;

import cmd.test.ACBasicUserView;

/**
 * Created by wenqi on 2018/11/1
 */
public class ACUserView extends ACBasicUserView {
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Long lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    private String description;
    private String gender;
    private Long lastLogin;
    private String jobTitle;
    private String department;
    private String address;
    private Integer type;


    @Override
    public String toString() {
        return "ACUserView{" +
                "description='" + description + '\'' +
                ", gender='" + gender + '\'' +
                ", lastLogin=" + lastLogin +
                ", jobTitle='" + jobTitle + '\'' +
                ", department='" + department + '\'' +
                ", address='" + address + '\'' +
                ", type=" + type +
                '}';
    }
}
