import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyCalendarI {
    List<int[]> bookings;
    public MyCalendarI() {
        this.bookings = new LinkedList<>();
    }
    public boolean book(int start, int end) {

        boolean inserted = false;
        int i = 0;
        while (inserted == false && i < bookings.size()) {
            int[] currBooking = bookings.get(i);
            int min = Math.max(start, currBooking[0]);
            int max = Math.min(end, currBooking[1]);
            if (min < max) {
                return false;
            }
            if (currBooking[0] >= end) {
                bookings.add(i, new int[]{start, end});
                inserted = true;
            }
            i++;
        }
        if (!inserted) {
            if (bookings.size() == 0) {
                bookings.add(new int[]{start, end});
            } else if (bookings.get(0)[0] >= end) {
                bookings.add(0, new int[]{start , end});
            } else {
                bookings.add(new int[]{start, end});
            }
        }

        return true;
    }
    public boolean bookBinarySearch(int start, int end) {

        int left = 0;
        int right = bookings.size();
        while (left < right) {
            int mid = (left + right) / 2;
            int[] currBooking = bookings.get(mid);
            int min = Math.max(start, currBooking[0]);
            int max = Math.min(end, currBooking[1]);
            if (min < max) {
                return false;
            }
            if (currBooking[0] < start) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        bookings.add(left, new int[]{start, end});

        return true;
    }
    public static void main(String[] args) {
        MyCalendarI myCalendar = new MyCalendarI();
        System.out.println(myCalendar.bookBinarySearch(10, 20)); // return True
        System.out.println(myCalendar.bookBinarySearch(15, 25)); // return False, It can not be booked because time 15 is already booked by another event.
        System.out.println(myCalendar.bookBinarySearch(20, 30)); // return True, The event can be booked, as the first event takes every time less than 20, but not including 20.
    }
}
