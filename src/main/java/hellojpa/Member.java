package hellojpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class Member {
	@Id
	private Long id;
	private String name;

	public Member() {}

	public Member(int id, String name) {}

	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
