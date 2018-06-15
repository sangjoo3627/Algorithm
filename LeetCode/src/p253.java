import java.util.*;

/*
 * Problem #253
 * 
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
 * find the minimum number of conference rooms required.
 * Example 1:
 * Input: [[0, 30],[5, 10],[15, 20]] Output: 2
 * Example 2:
 * Input: [[7,10],[2,4]] Output: 1
 * 
 * 40%
 */

public class p253 {
	/*
	 * ���ٹ��:
	 * �� meeting time interval���� �ϳ��� ��������� �����ϸ�, ���� ��ġ�� �ʰ� ������ �� �ִ¸�ŭ �ִ��� �����Ѵ�
	 * �׸��� ������ ���������� heap�� offer�ϰ� ���̻� ������ �� �ִ� �������� ������ heap.size()�� ��ȯ�ϸ� �� ���� minimum number of rooms�̴�. 
	 * ���� ��� intervals���� start ������ �����ϰ� end�� min ���� �����ϴ� heap�� �����Ѵ�.
	 * �׸��� heap�� intervals�� ù element�� �ְ�, poll �ϸ鼭 �ٸ� elements ����� ���ϸ鼭 
	 * ������ �� �ִ� element�� ã���� end ���� ū������ ������ interval�� ���� ����� heap�� offer�Ѵ�.
	 *
	 */
	
	public static class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	public static int minMeetingRooms(Interval[] intervals) {
		if (intervals == null || intervals.length == 0)
			return 0;

		// Sort the intervals by start time
		Arrays.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval a, Interval b) {
				return a.start - b.start;
			}
		});

		// Use a min heap to track the minimum end time of merged intervals
		PriorityQueue<Interval> heap = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>() {
			public int compare(Interval a, Interval b) {
				return a.end - b.end;
			}
		});

		// start with the first meeting, put it to a meeting room
		heap.offer(intervals[0]);

		for (int i = 1; i < intervals.length; i++) {
			// get the meeting room that finishes earliest
			Interval interval = heap.poll();

			if (intervals[i].start >= interval.end) {
				// if the current meeting starts right after
				// there's no need for a new room, merge the interval
				interval.end = intervals[i].end;
			} else {
				// otherwise, this meeting needs a new room
				heap.offer(intervals[i]);
			}

			// don't forget to put the meeting room back
			heap.offer(interval);
		}

		return heap.size();
	}

	public static void main(String[] args) {
		Interval [] arr = new Interval[7];
		arr[0] = new Interval(0,30);
		arr[1] = new Interval(11,20);
		arr[2] = new Interval(6,20);
		arr[3] = new Interval(2,5);
		arr[4] = new Interval(9,13);
		arr[5] = new Interval(4,8);
		arr[6] = new Interval(15,25);
		System.out.println(minMeetingRooms(arr));
	}

}
