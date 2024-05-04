public class Main {
    public static Employee[] employees = new Employee[10];

    public static void main(String[] args) {

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

        dataOutput();

        System.out.println("Сумма затрат на ЗП в месяц: " + amountOfSalaries());

        System.out.println("Сотрудник  с минимальной ЗП: " + minimumWage());

        System.out.println("Сотрудник с максимальной ЗП: " + maximumWage());

        System.out.println("Cреднее значение зарплат: " + averageValueOfSalaries());

        fullNameOfAllEmployees();

        //Повышенная сложность

        indexTheSalary();

        System.out.println("Сотрудник с минимальной ЗП по отделу: " + minimumSalaryDepartment(2));

        System.out.println("Сотрудник с максимальной ЗП по отделу: " + maximumSalaryDepartment(1));

        System.out.println("Сумма затрат на ЗП в месяц по отделу: " + amountOfSalariesDepartment(5));

        System.out.println("Cреднее значение зарплат по отделу: " + averageValueOfSalariesDepartment(3));

        indexTheSalary(4);

        allEmployeesOfTheDepartment(5);

        System.out.println();
        System.out.println("Все сотрудники с более низкой зарплатой:");

        allEmployeesWithLowerSalaries(40000000);

        System.out.println();
        System.out.println("Все сотрудники с более высокой зарплатой:");

        allEmployeesWithHigherSalaries(1);


    }

    public static void dataOutput() {
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }
    }

    public static void fullNameOfAllEmployees() {
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i].getFullName());
        }
    }

    public static double amountOfSalaries() {
        double sum = 0;
        for (int i = 0; i < employees.length; i++) {
            sum += employees[i].getSalary();
        }
        return sum;
    }

    public static Employee minimumWage() {
        double min = Integer.MAX_VALUE;
        Employee employeeMin = employees[0];
        for (int i = 0; i < employees.length; i++) {
            if (min > employees[i].getSalary()) {
                min = employees[i].getSalary();
                employeeMin = employees[i];
            }
        }
        return employeeMin;
    }

    public static Employee maximumWage() {
        double max = Integer.MIN_VALUE;
        Employee employeeMax = employees[0];
        for (int i = 0; i < employees.length; i++) {
            if (max < employees[i].getSalary()) {
                max = employees[i].getSalary();
                employeeMax = employees[i];
            }
        }
        return employeeMax;
    }

    public static double averageValueOfSalaries() {
        return amountOfSalaries() / employees.length;
    }

    //Повышенная сложность

    public static void indexTheSalary() {
        for (int i = 0; i < employees.length; i++) {
            employees[i].setSalary(employees[i].getSalary() + (3 * (employees[i].getSalary() / 100)));
            System.out.println(employees[i].getSalary());
        }
    }

    public static Employee minimumSalaryDepartment(int department) {
        double min = Integer.MAX_VALUE;
        Employee employeeMin = employees[0];
        for (int i = 0; i < employees.length; i++) {
            if (department == employees[i].getDepartment() && min > employees[i].getSalary()) {
                min = employees[i].getSalary();
                employeeMin = employees[i];
            } else if (department > 5 || department <= 0) {
                throw new IllegalArgumentException("такого отдела нет");
            }
        }
        return employeeMin;
    }

    public static Employee maximumSalaryDepartment(int department) {
        double max = Integer.MIN_VALUE;
        Employee employeeMax = employees[0];
        for (int i = 0; i < employees.length; i++) {
            if (department == employees[i].getDepartment() && max < employees[i].getSalary()) {
                max = employees[i].getSalary();
                employeeMax = employees[i];
            } else if (department > 5 || department <= 0) {
                throw new IllegalArgumentException("такого отдела нет");
            }
        }
        return employeeMax;
    }

    public static double amountOfSalariesDepartment(int department) {
        double sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (department == employees[i].getDepartment()) {
                sum += employees[i].getSalary();
            } else if (department > 5 || department <= 0) {
                throw new IllegalArgumentException("такого отдела нет");
            }
        }
        return sum;
    }

    public static double averageValueOfSalariesDepartment(int department) {
        int people = 0;
        double sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (department == employees[i].getDepartment()) {
                people++;
                sum += employees[i].getSalary();

            } else if (department > 5 || department <= 0) {
                throw new IllegalArgumentException("такого отдела нет");
            }
        }
        return sum / people;
    }

    public static void indexTheSalary(double percent) {
        for (int i = 0; i < employees.length; i++) {
            employees[i].setSalary(employees[i].getSalary() + (percent * (employees[i].getSalary() / 100)));
            System.out.println(employees[i].getSalary());
        }
    }

    public static void allEmployeesOfTheDepartment(int department) {
        for (int i = 0; i < employees.length; i++) {
            if (department == employees[i].getDepartment()) {
                System.out.println(employees[i].getFullName() + " / Зарплата: "
                        + employees[i].getSalary() + " / id: " + employees[i].getId());
            }
        }
    }

    public static void allEmployeesWithLowerSalaries(double number) {
        for (int i = 0; i < employees.length; i++) {
            if (number > employees[i].getSalary()) {
                System.out.println("id: " + employees[i].getId() + " / ФИО: "
                        + employees[i].getFullName() + " / Зарплата: " + employees[i].getSalary());
            }
        }
    }

    public static void allEmployeesWithHigherSalaries(double number) {
        for (int i = 0; i < employees.length; i++) {
            if (number < employees[i].getSalary()) {
                System.out.println("id: " + employees[i].getId() + " / ФИО: "
                        + employees[i].getFullName() + " / Зарплата: " + employees[i].getSalary());
            }
        }
    }


}
