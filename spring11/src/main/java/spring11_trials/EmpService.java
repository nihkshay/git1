package spring11_trials;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpService {

	HashMap<Integer,Employee> empData=new HashMap<Integer,Employee>();
	
	@RequestMapping(value="/get/{id}",method=RequestMethod.GET)
	public Employee getEmp(@PathVariable("id") int id){
		
		System.out.println("getting user data :" +empData.get(id));
		return empData.get(id);
	}
	
	@RequestMapping(value="/getAll",method=RequestMethod.GET)
	public List<Employee> getAllEmp(){
		
		List<Employee> emps = new ArrayList<Employee>();
		
		System.out.println("getting all users data :");
		for(Employee emp:empData.values())
			{System.out.println(emp);
			 emps.add(emp);
		 }
		 return emps;
	}
	
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public Employee createEmp(@RequestBody Employee employee){
		
		empData.put(employee.getId(), employee);
		System.out.println(" added user data : "+employee);
		return employee;
	}
	
	
	@RequestMapping(value="/createDummy",method=RequestMethod.GET)
	public Employee createDummy(){
		Employee employee =new Employee(9090, "xyz");
		empData.put(employee.getId(), employee);
		System.out.println(" added dummy user data : "+employee);
		return employee;
	}
	
}
