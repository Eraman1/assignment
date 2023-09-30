
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
public class EmployeeShiftData {
    public static void main(String[] args) throws IOException {
        // Get the file name from the user.
        try{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the file name: ");
        String fileName = sc.nextLine();

        // Create a BufferedReader to read the file.
        BufferedReader reader ;
        reader = new BufferedReader(new FileReader(fileName));
        
//System.out.println(reader.toString());
        // Create a list to store the employee shift data.
        List<EmployeeShift> employeeShiftData = new ArrayList<>();

        // Read the file and store the employee shift data in the list.
        String line;
        while ((line = reader.readLine()) != null) {
            String[] employeeShiftInfo = line.split(",");
            EmployeeShift employeeShift = new EmployeeShift(employeeShiftInfo[0], employeeShiftInfo[1], employeeShiftInfo[2], employeeShiftInfo[3]);
            employeeShiftData.add(employeeShift);
//            System.out.println(line);
        }

        // Close the BufferedReader.
        reader.close();

        // Print the name and position of employees who have worked for 7 consecutive days.
        System.out.println("Employees who have worked for 7 consecutive days: ");
        int consDays = 0;
        int k=0;
        List<String> list = new ArrayList<String>();
        EmployeeShift employeShift = null;
            for(int i=0;i<employeeShiftData.size();i++){
                employeShift= employeeShiftData.get(i);
                consDays=0;
                 for(int j=i+1;j<employeeShiftData.size();j++){
//                     System.out.println(employeShift.getName()+"----"+employeeShiftData.get(j).getName());
                     if(employeShift.getName()!=null && employeeShiftData.get(j).getName()!=null && employeShift.getName().equals(employeeShiftData.get(j).getName())){
//                          System.out.println("MATCHED");
                         consDays+=1;
            }
                     else{
                         continue;
                     }
                     if(consDays==7){
                         i+=7;
                         list.add(employeShift.getName());
//                         System.out.println(employeShift.getName() + " :: " + employeShift.getPosition());
                         break;
                     }
                
            }
        }
            List<String> newList = list.stream()
                                      .distinct()
                                      .collect(Collectors.toList());
             System.out.print(newList);

        // Print the name and position of employees who have less than 10 hours of time between shifts but greater than 1 hour.
        System.out.println("\nEmployees who have less than 10 hours of time between shifts but greater than 1 hour: ");
        for (EmployeeShift employeeShift : employeeShiftData) {
            if (employeeShift.hasLessThan10HoursOfTimeBetweenShiftsButGreaterThan1Hour()) {
                System.out.println(employeeShift.getName() + " - " + employeeShift.getPosition());
            }
        }

        // Print the name and position of employees who have worked for more than 14 hours in a single shift.
        System.out.println("\nEmployees who have worked for more than 14 hours in a single shift: ");
        for(EmployeeShift employeeShift : employeeShiftData) {
            if (employeeShift.hasWorkedForMoreThan14HoursInASingleShift()) {
                System.out.println(employeeShift.getName() + " - " + employeeShift.getPosition());
            }
        }
    }
        catch(Exception e){
System.out.println("Error while parsing the file: "+ e);
}
}}

