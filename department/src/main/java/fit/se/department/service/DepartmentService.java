package fit.se.department.service;

import java.util.List;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import fit.se.department.entity.Department;

@Service
public class DepartmentService {
	private HashOperations hashOperations;
	private RedisTemplate redisTemplate;
	
	public DepartmentService( RedisTemplate redisTemplate) {
		super();
		this.hashOperations = redisTemplate.opsForHash();
		this.redisTemplate = redisTemplate;
	}
	
	public void save(Department d) {
		hashOperations.put("Department", d.getId(), d);
	}
	
	public List<Department> getAllDepartment(){
		return hashOperations.values("Department");
	}
	
	public void upadate(Department d) {
		save(d);
	}
	
	public void delete(int id) {
		hashOperations.delete("Department", id);
	}
	
}
