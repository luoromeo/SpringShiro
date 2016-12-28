package design.uranus.spring.shiro.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhanghua.luo
 * @Description 角色（管理员，普通用户等）
 * @Date 2016/12/28 0028
 */
@Entity
@Data
@Table(name = "t_role")
public class Role implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String rolename;
	@OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
	private List<Permission> permissionList;// 一个角色对应多个权限
	@ManyToMany
	@JoinTable(name = "t_user_role", joinColumns = {@JoinColumn(name = "role_id")}, inverseJoinColumns = {
			@JoinColumn(name = "user_id")})
	private List<User> userList;// 一个角色对应多个用户

	@Transient
	public List<String> getPermissionsName() {
		List<String> list = new ArrayList<String>();
		List<Permission> perlist = getPermissionList();
		for (Permission per : perlist) {
			list.add(per.getPermissionname());
		}
		return list;
	}
}
