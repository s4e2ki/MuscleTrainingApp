package model;

import java.io.Serializable;
import java.util.Date;

public class Login implements Serializable {
	private String userName;
	private Date days;

	public Login (String userName, Date days) {
		this.userName = userName;
		this.days = days;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getDays() {
		return days;
	}

	public void setDays(Date days) {
		this.days = days;
	}

	public int getCon() {
		return con;
	}

	public void setCon(int con) {
		this.con = con;
	}

	private int con;

	public Login(String userName, int con, java.sql.Date days) {
	}

	public Login() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
}