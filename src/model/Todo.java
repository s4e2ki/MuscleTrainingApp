package model;

import java.io.Serializable;

public class Todo implements Serializable {
	private String importance, content, deadline, errorMsg, userName;
	private int id;

	public Todo() {
	}

	public Todo(int id, String importance, String content, String deadline, String userName) {
		this.importance = importance;
		this.content = content;
		this.deadline = deadline;
		this.userName = userName;
		this.id = id;
	}

	public Todo(String importance, String content, String deadline, String userName) {
		this.importance = importance;
		this.content = content;
		this.deadline = deadline;
		this.userName = userName;
	}

	public Todo(int no, String importance, String content, String deadline) {
		this.importance = importance;
		this.content = content;
		this.deadline = deadline;
		this.id = no;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImportance() {
		return importance;
	}

	public void setImportance(String importance) {
		this.importance = importance;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
}
