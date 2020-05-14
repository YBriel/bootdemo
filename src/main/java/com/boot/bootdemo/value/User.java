package com.boot.bootdemo.value;

import java.util.Date;

/**
 * <p>
 * Title:User
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author Li Enbo
 * @date 2017年11月22日上午9:12:03
 */
public class User {
	@Value("name")
	private String name;
	@Value("age")
	private int age;
	@Value("addr")
	private String addr;
	@Value("date")
	private Date date;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", addr=" + addr + ", date=" + date + "]";
	}
}