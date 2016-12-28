package design.uranus.spring.shiro.domain.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @Author zhanghua.luo
 * @Description 权限（增删改查等）
 * @Date 2016/12/28 0028
 */
@Entity
@Data
@Table(name = "t_permission")
public class Permission {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String permissionname;

	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;// 一个权限对应一个角色

}
