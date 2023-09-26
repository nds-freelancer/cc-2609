package net.user.entity;

public class UserDto {

	private Long userid;
	private String username;
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public UserDto(Long userid, String username) {
		super();
		this.userid = userid;
		this.username = username;
	}
	
	
	
}
