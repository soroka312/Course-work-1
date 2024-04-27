public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[10];
        employees[0] = new Employee("Кочетков Александр Вадимович", 5, 257532);
        employees[1] = new Employee("Пименова Нина Кирилловна", 2, 308235);
        employees[2] = new Employee("Родин Артемий Степанович", 3, 280932);
        employees[3] = new Employee("Колесова Ева Ильинична", 2, 207493);
        employees[4] = new Employee("Черепанова Алиса Михайловна", 4, 358742);
        employees[5] = new Employee("Елизарова Эмилия Игоревна", 2, 246432);
        employees[6] = new Employee("Иванова Алиса Германовна", 1, 269573);
        employees[7] = new Employee("Сергеева Марьяна Викторовна", 5, 329473);
        employees[8] = new Employee("Попов Даниил Сергеевич", 3, 350283);
        employees[9] = new Employee("Носова Екатерина Александровна", 1, 397562);

        for (Employee employee : employees) {
            System.out.println(employee);
        }

        double sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        System.out.println("Сумма затрат на ЗП в месяц: " + sum);


        int min = (int) employees[4].getSalary();
        Employee employeeMin = employees[6];
        for (int i = 1; i < employees.length; i++) {
            if (min >= employees[i].getSalary()) {
                min = (int) employees[i].getSalary();
                employeeMin = employees[i];
            }
        }
        System.out.println("Сотрудник  с минимальной ЗП: " + employeeMin);

        int max = (int) employees[9].getSalary();
        Employee employeeMax = employees[4];
        for (int i = 1; i < employees.length; i++) {
            if (max <= employees[i].getSalary()) {
                max = (int) employees[i].getSalary();
                employeeMax = employees[i];
            }
        }
        System.out.println("Сотрудник с максимальной ЗП: " + employeeMax);

        System.out.println("Cреднее значение зарплат: " + sum / employees.length);


        for (Employee employee : employees) {
            System.out.println(employee.getFullName());
        }


    }
}
