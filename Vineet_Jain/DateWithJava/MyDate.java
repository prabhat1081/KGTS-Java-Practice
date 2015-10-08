/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vineet
 */
public class MyDate {
    private int year, month, day;
    private static String[] strMonths = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
						  "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    private static String[] strDays = {"Sunday", "Monday", "Tuesday", "Wednesday",
						"Thursday", "Friday", "Saturday"};
    private static int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static boolean isLeapYear(int year) {
	if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0)))
            return true;
	else
            return false;
    }

    public static boolean isValidDate(int year, int month, int day) {
	if (year > 9999 || year < 1)
            return false;
	else if (month > 12 || month < 1)
            return false;
	else if (month == 2 && isLeapYear(year))
            if (day < 1 || day > 29)
		return false;
        else if (day < 1 || day > daysInMonths[month-1])
            return false;
	return true;
    }

    public static int getDayOfWeek(int year, int month, int day) {
		int num, dayIndex;
		int[] monthNumber = {0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5};
		if (isLeapYear(year)) {
			monthNumber[0] = 6;
			monthNumber[1] = 2;
		}
		num = 2*(3-((int)(year/100) % 4));
		dayIndex = (day + monthNumber[month-1] + year%100 + (int)((year%100)/4) + num) % 7;
		return dayIndex;
	}

	public MyDate(int year, int month, int day) {
		setDate(year, month, day);
	}

	public void setDate(int year, int month, int day) {
		if (!isValidDate(year, month, day))
			throw new IllegalArgumentException("Invalid year, month or day!");

		this.year = year;
		this.month = month;
		this.day = day;
	}

	public void setYear(int year) {
		if (year > 9999 || year < 1)
			throw new IllegalArgumentException("Invalid year!");
		this.year = year;
	}

	public void setMonth(int month) {
		if (month > 12 || month < 1)
			throw new IllegalArgumentException("Invalid year!");
		this.month = month;
	}

	public void setDay(int day) {
		if (month == 2 && isLeapYear(this.year))
			if (day < 1 || day > 29)
				throw new IllegalArgumentException("Invalid day!");
		else if (day < 1 || day > daysInMonths[this.month-1])
			throw new IllegalArgumentException("Invalid day!");
		this.day = day;
	}

	public int getYear() {
		return this.year;
	}

	public int getMonth() {
		return this.month;
	}

	public int getDay() {
		return this.day;
	}

	public String toString() {
		return strDays[getDayOfWeek(this.year, this.month, this.day)]+" "+getDay()+" "+strMonths[getMonth()-1]+" "+getYear();
	}

	public MyDate nextDay() {
		if (this.day == 28 && isLeapYear(this.year))
			this.day++;
		else if (this.day >= daysInMonths[this.month-1]) {
			if (month == 12) {
				this.year++;
				this.month = 1;
				if (this.year > 9999)
					throw new IllegalArgumentException("Day out of range!");
			}
			else
				this.month++;
			this.day = 1;
		}
		else
			this.day++;
		return this;
	}

	public MyDate nextMonth() {
		if (this.month == 12) {
			this.month = 1;
			this.year++;
			if (this.year > 9999)
				throw new IllegalArgumentException("Month out of range!");
		}
		else
			this.month++;
		if (this.day == 31)
			this.day = daysInMonths[this.month-1];
		return this;
	}

	public MyDate nextYear() {
		if (this.year == 9999)
			throw new IllegalArgumentException("Year out of range!");
		if (this.day == 29 && this.month == 2)
			this.day = 28;
		this.year++;
		return this;
	}

	public MyDate previousDay() {
		if (this.day == 1 && this.month == 3 && isLeapYear(this.year)) {
			this.day = 29;
			this.month = 2;
		}
		else if (this.day == 1) {
			if (month == 1) {
				this.year--;
				if (this.year < 1)
					throw new IllegalArgumentException("Day out of range!");
				this.month = 12;
			}
			else
				this.month--;
			this.day = daysInMonths[this.month-1];
		}
		else
			this.day--;
		return this;
	}

	public MyDate previousMonth() {
		if (this.month == 1) {
			this.month = 12;
			this.year--;
			if (this.year < 1)
					throw new IllegalArgumentException("Day out of range!");
		}
		else
			this.month--;
		if (this.day == 31)
			this.day = daysInMonths[this.month-1];
		return this;
	}

	public MyDate previousYear() {
		if (this.year == 1)
			throw new IllegalArgumentException("Year out of range!");
		if (this.day == 29 && this.month == 2)
			this.day = 28;
		this.year--;
		return this;
	}
}