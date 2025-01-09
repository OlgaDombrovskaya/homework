package de.ait.homework27;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BusinessTest {
    private Business business;
    private Department department1;
    private Department department2;
    private Employee employee1;
    private Employee employee2;

    @BeforeEach
    public void setUp() {
        // Инициализация
        business = new Business("My Business");

        // Создаем сотрудников
        employee1 = new Employee("123", "Alice", "Manager", 5000);
        employee2 = new Employee("567", "Bob", "Developer", 3000);

        // создаем департаменты и добавляем сотрудников
        department1 = new Department("HR");
        department1.addEmployee(employee1);

        department2 = new Department("IT");
        department2.addEmployee(employee2);

        // добавляем департаменты
        business.addDepartment(department1);
        business.addDepartment(department2);
    }

    @Test
    public void testAddDepartmentShouldAddDepartmentSuccessfully() {
        // Arrange: создаем новый департамент
        Department newDepartment = new Department("Marketing");

        // Act: добавляем новый департамент
        business.addDepartment(newDepartment);

        // Assert: проверяем, что департамент был добавлен
        assertNotNull(business.getDepartment("Marketing"), "Department should be added successfully");
    }

    @Test
    public void testRemoveDepartmentShouldRemoveExistingDepartment() {
        // Act: удаляем существующий департамент
        business.removeDepartment("HR");

        // Assert: проверяем, что департамент был удален
        assertNull(business.getDepartment("HR"), "Department should be removed successfully");
    }

    @Test
    public void testRemoveDepartmentShouldNotRemoveNonExistingDepartment() {
        // Act: пытаемся удалить несуществующий департамент
        business.removeDepartment("Sales");

        // Assert: проверяем, что департамент не был удален, потому что его не существует
        assertNull(business.getDepartment("Sales"), "Non-existing department should not be removed");
    }

    @Test
    public void testGetDepartmentShouldReturnDepartment() {
        // Act: получаем департамент по имени
        Department department = business.getDepartment("IT");

        // Assert: проверяем, что департамент найден и его имя совпадает
        assertNotNull(department, "Department should be found by name");
        assertEquals("IT", department.getName(), "Department name should match");
    }

    @Test
    public void testGetAllPositionsShouldReturnAllPositions() {
        // Act: получаем все позиции сотрудников в бизнесе
        HashSet<String> positions = business.getAllPositions();

        // Assert: проверяем, что список содержит все должности
        assertTrue(positions.contains("Manager"), "Positions should contain 'Manager'");
        assertTrue(positions.contains("Developer"), "Positions should contain 'Developer'");
        assertEquals(2, positions.size(), "There should be 2 positions in total");
    }

    @Test
    public void testGetTotalCompanySalaryShouldReturnCorrectTotal() {
        // Act: вычисляем общую зарплату всех сотрудников
        double totalSalary = business.getTotalCompanySalary();

        // Assert: проверяем, что общая зарплата верна
        assertEquals(8000, totalSalary, "Total salary should be the sum of all employee salaries (5000 + 3000)");
    }

    @Test
    public void testAddDepartmentShouldNotAddNullDepartment() {
        // Act: пытаемся добавить null департамент
        business.addDepartment(null);

        // Assert: проверяем, что департамент не был добавлен
        assertEquals(2, business.getDepartments().size(), "Business should not add a null department");
    }

    @Test
    public void testRemoveDepartmentShouldNotRemoveWhenNameIsEmpty() {
        // Act: пытаемся удалить департамент с пустым именем
        business.removeDepartment("");

        // Assert: проверяем, что департамент не был удален
        assertEquals(2, business.getDepartments().size(), "Business should not remove department if name is empty");
    }

    @Test
    public void testGetDepartmentShouldReturnNullForNonExistentDepartment() {
        // Act: пытаемся получить департамент, которого нет
        Department department = business.getDepartment("NonExistent");

        // Assert: проверяем, что метод вернет null
        assertNull(department, "Non-existent department should return null");
    }
}