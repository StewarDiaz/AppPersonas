package com.jdhcreations.apppersonas;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Comp implements Serializable {

    String name;
    String nit;
    List<String> listWorkstation = new ArrayList<String>();
    List<Emple> listEmployees = new ArrayList<Emple>();

    public Comp(String name, String nit, List<String> listWorkstation, List<Emple> listEmployees) {
        this.name = name;
        this.nit = nit;
        this.listWorkstation = listWorkstation;
        this.listEmployees = listEmployees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public List<String> getListWorkstation() {
        return listWorkstation;
    }

    public void setListWorkstation(List<String> listWorkstation) {
        this.listWorkstation = listWorkstation;
    }

    public List<Emple> getListEmployees() {
        return listEmployees;
    }

    public void setListEmployees(List<Emple> listEmployees) {
        this.listEmployees = listEmployees;
    }

    public List<Emple> youngestEmployes() {
        List<Emple> emp = new ArrayList<>();

        Emple zero = listEmployees.get(0);
        int agemin = zero.age;
        for (Emple Listemp: listEmployees) {
            if (Listemp.age <= agemin){
                agemin = Listemp.age;
            }
        }
        emp = SearchEmp(agemin);
        return emp;
    }

    public List<Emple> OldestEmployes() {
        List<Emple> emp = new ArrayList<>();
        Emple emp1 = listEmployees.get(0);
        int agemax = emp1.age;
        for (Emple Listemp: listEmployees) {
            if (Listemp.age >= agemax){
                agemax = Listemp.age;
            }
        }
        emp = SearchEmp(agemax);
        return emp;
    }

    public List<Emple> salaryMin() {
        List<Emple> emp = new ArrayList<>();

        Emple zero = listEmployees.get(0);
        double agemin = zero.salary;
        for (Emple Listemp: listEmployees) {
            if (Listemp.salary <= agemin){
                agemin = Listemp.salary;
            }
        }
        emp = SearchEmp2(agemin);
        return emp;
    }

    public List<Emple> salaryMax() {
        List<Emple> emp = new ArrayList<>();
        Emple emp1 = listEmployees.get(0);
        double agemax = emp1.salary;
        for (Emple Listemp: listEmployees) {
            if (Listemp.salary >= agemax){
                agemax = Listemp.salary;
            }
        }
        emp = SearchEmp2(agemax);
        return emp;
    }



    public List<Emple> SearchEmp(int valueShearch) {
        List<Emple> empList = new ArrayList<>();
        for (Emple employee : listEmployees) {
            if (employee.age == valueShearch){
                empList.add(employee);
            }
        }
        return empList;
    }

    public List<Emple> SearchEmp2(Double valueShearch) {
        List<Emple> empList = new ArrayList<>();
        for (Emple employee : listEmployees) {
            if (employee.salary == valueShearch){
                empList.add(employee);
            }
        }
        return empList;
    }

    public Double SalaryProm(){
        int totalElements = listEmployees.size();
        Double sumSalary=0.0;
        Double result = 0.0;
        for (int i = 0; i <= listEmployees.size() - 1; i++) {
            sumSalary= (sumSalary) + (listEmployees.get(i).salary);
        }
        result = (sumSalary)/(totalElements);
        return result;
    }

    public String Count(){
        String resumen = "";
        int count = 0;
        double sumSalary = 0.0;
        DecimalFormat df = new DecimalFormat("###.##");

        double salaryPro;

        for (int i = 0; i <= listWorkstation.size() - 1; i++) {
            for (int j = 0; j <= listEmployees.size() - 1; j++) {
                if (listWorkstation.get(i).equals(listEmployees.get(j).workPosition)){//vigilante
                    count = count + 1;
                    sumSalary= sumSalary + listEmployees.get(j).salary;
                }else{
                    count =count + 0;
                    sumSalary = sumSalary + 0.0;
                }

            }
            if (count==0){
                salaryPro=0.0;
            }else{
                salaryPro = (sumSalary)/(count);
            }
            resumen= resumen + "\n" + "Cargo: " + listWorkstation.get(i) + " # personas en el cargo: " + count + "\n"
                    +"             Salario Promedio: " + "$"+ df.format(salaryPro)  ;
            count=0;
            sumSalary=0.0;
            //salaryPro = 0.0;
        }
        return resumen;
    }
}
