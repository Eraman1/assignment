/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
public class EmployeeShift {
      private String name;
    private String position;
    private String startTime;
    private String endTime;

    public EmployeeShift(String name, String position, String startTime, String endTime) {
        this.name = name;
        this.position = position;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public boolean hasWorkedForSevenConsecutiveDays(EmployeeShift employeeShift) {

    // Check if the employee has worked for 7 consecutive days.
    int consecutiveWorkDays = 0;
        if (employeeShift != null) {
            consecutiveWorkDays++;
        } else {
            consecutiveWorkDays = 0;
        }

    return consecutiveWorkDays == 7;
    }

    public boolean hasLessThan10HoursOfTimeBetweenShiftsButGreaterThan1Hour() {
        // TODO: Implement this method to check if the employee has less than 10 hours of time between shifts but greater than 1 hour.
        return false;
    }

    public boolean hasWorkedForMoreThan14HoursInASingleShift() {
        // TODO: Implement this method to check if the employee has worked for more than 14 hours in a single shift.
        return false;
    }
}
