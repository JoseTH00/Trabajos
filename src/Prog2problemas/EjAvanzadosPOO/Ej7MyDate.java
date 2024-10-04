package Prog2problemas.EjAvanzadosPOO;

class MyDate {
    private int year, month, day;

    private static final String[] strMonths = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    private static final String[] strDays = {"Sunday", "Monday", "Tuesday", "Wednesday",
            "Thursday", "Friday", "Saturday"};

    private static final int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public MyDate(int year, int month, int day) {
        setDate(year, month, day);
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setDate(int year, int month, int day) {
        if (isValidDate(year, month, day)) {
            this.year = year;
            this.month = month;
            this.day = day;
        } else {
            throw new IllegalArgumentException("Fecha no válida.");
        }
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static boolean isValidDate(int year, int month, int day) {
        if (year < 1 || month < 1 || month > 12) return false;
        int maxDay = daysInMonths[month - 1];
        if (month == 2 && isLeapYear(year)) maxDay = 29;
        return day >= 1 && day <= maxDay;
    }

    public static int getDayOfWeek(int year, int month, int day) {
        if (month == 1 || month == 2) {
            month += 12;
            year--;
        }
        int k = year % 100;
        int j = year / 100;
        int h = (day + 13 * (month + 1) / 5 + k + k / 4 + j / 4 - 2 * j) % 7;
        return ((h + 5) % 7) + 1;
    }

    @Override
    public String toString() {
        return strDays[getDayOfWeek(year, month, day)] + " " + day + " " + strMonths[month - 1] + " " + year;
    }

    public MyDate nextDay() {
        int newDay = day, newMonth = month, newYear = year;
        if (isValidDate(year, month, day + 1)) {
            newDay++;
        } else if (month < 12) {
            newMonth++;
            newDay = 1;
        } else {
            newYear++;
            newMonth = 1;
            newDay = 1;
        }
        return new MyDate(newYear, newMonth, newDay);
    }

    public MyDate previousDay() {
        int newDay = day, newMonth = month, newYear = year;
        if (day > 1) {
            newDay--;
        } else if (month > 1) {
            newMonth--;
            newDay = daysInMonths[newMonth - 1];
            if (newMonth == 2 && isLeapYear(newYear)) {
                newDay = 29;
            }
        } else {
            newYear--;
            newMonth = 12;
            newDay = 31;
        }
        return new MyDate(newYear, newMonth, newDay);
    }

    public MyDate nextMonth() {
        int newMonth = month, newYear = year, newDay = day;
        if (month < 12) {
            newMonth++;
        } else {
            newYear++;
            newMonth = 1;
        }
        if (newDay > daysInMonths[newMonth - 1]) {
            newDay = daysInMonths[newMonth - 1];
        }
        if (newMonth == 2 && isLeapYear(newYear)) {
            newDay = 29;
        }
        return new MyDate(newYear, newMonth, newDay);
    }

    public MyDate previousMonth() {
        int newMonth = month, newYear = year, newDay = day;
        if (month > 1) {
            newMonth--;
        } else {
            newYear--;
            newMonth = 12;
        }
        if (newDay > daysInMonths[newMonth - 1]) {
            newDay = daysInMonths[newMonth - 1];
        }
        if (newMonth == 2 && isLeapYear(newYear)) {
            newDay = 29;
        }
        return new MyDate(newYear, newMonth, newDay);
    }

    public MyDate nextYear() {
        int newYear = year + 1;
        int newMonth = month;
        int newDay = day;
        if (newMonth == 2 && newDay == 29 && !isLeapYear(newYear)) {
            newDay = 28;
        }
        return new MyDate(newYear, newMonth, newDay);
    }

    public MyDate previousYear() {
        int newYear = year - 1;
        int newMonth = month;
        int newDay = day;
        if (newMonth == 2 && newDay == 29 && !isLeapYear(newYear)) {
            newDay = 28;
        }
        return new MyDate(newYear, newMonth, newDay);
    }

    public static void main(String[] args) {
        MyDate date = new MyDate(2024, 2, 28);
        System.out.println("Fecha original: " + date);

        MyDate newDate = date.nextDay();
        System.out.println("Siguiente día: " + newDate);

        MyDate nextMonth = date.nextMonth();
        System.out.println("Siguiente mes: " + nextMonth);

        MyDate prevYear = date.previousYear();
        System.out.println("Año anterior: " + prevYear);

        System.out.println("Fecha original no modificada: " + date);
    }
}


