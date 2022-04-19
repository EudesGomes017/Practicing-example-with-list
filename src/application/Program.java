package application;

import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);


        List<Employee> list = new ArrayList<>();

        // PART 1 - READING DATA: //PARTE 1 - DADOS DE LEITURA:

        System.out.print("How many employees will be registered? ");
        //Quantos funcionários serão cadastrados?
        int n = sc.nextInt(); // craindo a variavel n

        for (int i=1; i<=n; i++) {
            System.out.println();
            System.out.println("Employee #" + i + ": ");

            System.out.print("Id: ");
            Integer id = sc.nextInt();

            while (hasId(list, id)) {
                System.out.print("Id already taken. Try again: ");
                //Eu já peguei. Tente novamente:
                id = sc.nextInt();
            }

            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Salary: ");
            Double salary = sc.nextDouble();

            Employee emp = new Employee(id, name, salary);
            list.add(emp);
        }

        // PART 2 - UPDATING SALARY OF GIVEN EMPLOYEE: //ATUALIZAÇÃO DO SALÁRIO DO EMPREGADO:

        System.out.println();
        System.out.print("Enter the employee id that will have salary increase: ");
        //Informe o CPF do funcionário que terá aumento salarial:
        int idsalary = sc.nextInt();

        Employee emp = list.stream().filter(x -> x.getId() == idsalary).findFirst().orElse(null);

        // if (pos == null) { forma manualmente
        if (emp == null) {
            System.out.println("This id does not exist!");
            //Esta identificação não existe!
        }
        else {
            System.out.print("Enter the percentage: ");
            //Digite o percentual
            double percentage = sc.nextDouble(); //ler porcentagem
            //list.get(pos).increaseSalary(percent); // aumentando a porcentagem forma manualmente
            emp.increaseSalary(percentage); // aumentando a porcentagem
        }

        // PART 3 - LISTING EMPLOYEES:


        System.out.println();
        System.out.println("List of employees:");
        for (Employee e : list) {
            System.out.println(e);
        }

        sc.close();
    }

           /* for (int i = 0; i++ < list.size();) {
                if (list.get(i).getId() == id) {
                    return i;
                }
            }
            // caso ele percorrar e não encontre nossa lista com id
            return null ;
        }
*/


    //----------------------------------------------------------
    /* criamos uma função auxiliar para buscar com expresão lamnbda igual em cima, ela vai retorna o fucionario diferente d enull*/
    public static boolean hasId(List<Employee> list, int id) {
        Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return emp != null;
    }
}
