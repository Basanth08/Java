package unit09.inner;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Calendar {
    public enum DayOfWeek {
        SUNDAY (1, "Sun"),
        MONDAY (2, "Mon"),
        TUESDAY (3, "Tue"),
        WEDNESDAY (4, "Wed"),
        THURSDAY (5, "Thu"),
        FRIDAY (6, "Fri"),
        SATURDAY (7, "Sat");

        private final int number;
        private final String shortName;
        private static final Map <DayOfWeek, DayOfWeek> NEXT_DAYS = new HashMap<> ();

        static {
            DayOfWeek[] days = DayOfWeek.values ();
            for (int index = 0; index < days.length; index++) {
                NEXT_DAYS.put (days [index], days [(index + 1) % days.length]);
            }
        }

        private DayOfWeek (int number, String shortName) {
            this.number = number;
            this.shortName = shortName;
        }

        @Override
        public String toString() {
            return shortName;
        }

        public DayOfWeek tomorrow () {
            return NEXT_DAYS.get (this);
        }
    }

    public enum Month implements Iterable <DayOfWeek> {
        JANUARY (31), FERUARY (28), MARCH (31), APRIL (30), MAY (31), JUNE (30), JULY (31),
        AUGUST (31), SEPTEMBER (30), OCTOBER (31), NOVEMBER (30), DECEMBER (31);

        private final int daysInMonth;
        private DayOfWeek startDay;
        private static final Map <Month, Month> NEXT_MONTHS = new HashMap<> ();
        static {
            Month[] months = Month.values ();
            for (int index = 0; index < months.length; index++) {
                NEXT_MONTHS.put (months [index], months [(index + 1) % months.length]);
            }            
        }

        private Month (int daysInMonth) {
            this.daysInMonth = daysInMonth;
        }

        public void setStartDay (DayOfWeek day) {
            startDay = day;
        }

        public Month nextMonth () {
            return NEXT_MONTHS.get (this);
        }

        @Override
        public Iterator<DayOfWeek> iterator() {
            return new Iterator<Calendar.DayOfWeek>() {
                private int count = 0;
                private DayOfWeek next = startDay;
                @Override
                public boolean hasNext() {
                    return count < daysInMonth;
                }

                @Override
                public DayOfWeek next() {
                    count++;
                    DayOfWeek current = next;
                    next = next.tomorrow ();
                    return current;
                }
            };
        }
    }

    public static void main(String[] args) {
        System.out.println (DayOfWeek.MONDAY);
        System.out.println (DayOfWeek.SUNDAY.tomorrow ());
        System.out.println (DayOfWeek.SATURDAY.tomorrow ());

        System.out.println (Month.DECEMBER.nextMonth ());

        Month.MARCH.setStartDay (DayOfWeek.FRIDAY);
        for (DayOfWeek day : Month.MARCH) {
            System.out.print (day + " ");
        }
    }
}