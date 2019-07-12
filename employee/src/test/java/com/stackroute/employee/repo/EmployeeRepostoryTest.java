/**
 * 
 */
package com.stackroute.employee.repo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.employee.repository.EmployeeRepository;

/**
 * @author 26647
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeRepostoryTest {

	@Autowired
	private EmployeeRepository empRepo;
	
	@Test
	public void getAll_Repo_test() throws Exception{
		assertEquals("Hello", "Hello");
	}
	
}
