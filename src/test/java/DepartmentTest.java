import de.ait.homework27.Department;
import de.ait.homework27.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DepartmentTest {
    private Department departmentIT;

    @BeforeEach
    void setUp() {
        departmentIT = new Department("IT");
    }

    @Test
    void testAddEmployeeSuccesfull() {
        // Arrange: создаем
        Employee employee = new Employee("1","Doe","Junior developer", 35000);
        Employee employee2 = new Employee("2","John","Senior developer", 50000);
        Employee employee3 = new Employee("3","Tom","Junior developer", 25000);

        // Act: выполняем операцию
        departmentIT.addEmployee(employee);
        departmentIT.addEmployee(employee2);
        departmentIT.addEmployee(employee3);
        ArrayList<Employee> employeesResult = departmentIT.getEmployees();

        // Assert: проверяем
        assertEquals(3, employeesResult.size());
        assertEquals(employee, employeesResult.get(0));
        assertEquals(employee2, employeesResult.get(1));
        assertEquals(employee3, employeesResult.get(2));
    }


    @Test
    void testAddNullEmployee() {
        // Act:
        Employee employee = null;
        departmentIT.addEmployee(employee);

        ArrayList<Employee> employeesResult = departmentIT.getEmployees();
        // Assert:
        assertEquals(0, employeesResult.size());
    }

    @Test
    void testAddEmptyEmployee() {
        // Arrange (подготовка):
        Employee employee = new Employee(null,"Doe","Junior developer", 35000);
        // Act (действие):
        departmentIT.addEmployee(employee);

        ArrayList<Employee> employeesResult = departmentIT.getEmployees();
        // Assert:
        assertEquals(0, employeesResult.size());
    }

    @Test
    void testAddEmployeeWithInvalidSalary() {
        // Arrange:
        Employee employee = new Employee("4", "Jane", "Junior developer", -1000);
        // Act:
        departmentIT.addEmployee(employee);

        ArrayList<Employee> employeesResult = departmentIT.getEmployees();
        // Assert:
        assertEquals(0, employeesResult.size(), "No employee should be added with invalid salary.");
    }

    @Test
    void testRemoveEmployeeSuccessful() {
        // Arrange:
        Employee employee1 = new Employee("1", "Doe", "Junior developer", 35000);
        Employee employee2 = new Employee("2", "John", "Senior developer", 50000);
        // Act:
        departmentIT.addEmployee(employee1);
        departmentIT.addEmployee(employee2);

        departmentIT.removeEmployee("1");

        ArrayList<Employee> employeesResult = departmentIT.getEmployees();
        // Assert:
        assertEquals(1, employeesResult.size(), "One employee should be removed.");
        assertEquals(employee2, employeesResult.get(0), "Remaining employee should match.");
    }

    // Тест на  удаление несуществующего сотрудника
    @Test
    void testRemoveEmployeeNotFound() {
        // Arrange:
        Employee employee1 = new Employee("1", "Doe", "Junior developer", 35000);
        // Act:
        departmentIT.addEmployee(employee1);
        departmentIT.removeEmployee("2");

        ArrayList<Employee> employeesResult = departmentIT.getEmployees();
        // Assert:
        assertEquals(1, employeesResult.size(), "Employee list should not be altered.");
        assertEquals(employee1, employeesResult.get(0), "Employee ID 2 does not exist.");
    }

    // Тест на поиск существующего сотрудника по ID
    @Test
    void testFindEmployeeSuccessful() {
        Employee employee1 = new Employee("1", "Doe", "Junior developer", 35000);
        departmentIT.addEmployee(employee1);

        Employee foundEmployee = departmentIT.findEmployee("1");

        assertNotNull(foundEmployee, "Employee should be found.");
        assertEquals(employee1, foundEmployee, "Found employee should match the added employee.");
    }

    // Тест на поиск несуществующего сотрудника по ID
    @Test
    void testFindEmployeeNotFound() {
        Employee employee1 = new Employee("1", "Doe", "Junior developer", 35000);
        departmentIT.addEmployee(employee1);

        Employee foundEmployee = departmentIT.findEmployee("2");

        assertNull(foundEmployee, "Employee should not be found.");
    }

    // Тест на получения общей зарплаты всех сотрудников
    @Test
    void testGetTotalSalary() {
        Employee employee1 = new Employee("1", "Doe", "Junior developer", 35000);
        Employee employee2 = new Employee("2", "John", "Senior developer", 50000);
        departmentIT.addEmployee(employee1);
        departmentIT.addEmployee(employee2);

        double totalSalary = departmentIT.getTotalSalary();

        assertEquals(85000, totalSalary, "Total salary should be the sum of all employee salaries.");
    }

    // Тест на общую зарплату, когда сотрудников нет
    @Test
    void testGetTotalSalaryNoEmployees() {
        double totalSalary = departmentIT.getTotalSalary();
        assertEquals(0, totalSalary, "Total salary should be 0 when no employees are present.");
    }

    // Тест на получение общей зарплаты, когда у некоторых сотрудников в данных о зарплате ошибка
    @Test
    void testGetTotalSalaryWithInvalidEmployee() {
        Employee employee1 = new Employee("1", "Doe", "Junior developer", 35000);
        Employee employee2 = new Employee("2", "John", "Senior developer", -5000); // Invalid salary
        departmentIT.addEmployee(employee1);
        departmentIT.addEmployee(employee2);

        double totalSalary = departmentIT.getTotalSalary();

        assertEquals(35000, totalSalary, "Total salary should exclude invalid employee salary.");
    }
}

