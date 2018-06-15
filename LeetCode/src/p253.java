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
	 * 접근방법:
	 * 각 meeting time interval들을 하나의 파이프라고 생각하면, 서로 겹치지 않고 연결할 수 있는만큼 최대한 연결한다
	 * 그리고 연결한 파이프들을 heap에 offer하고 더이상 연결할 수 있는 파이프가 없을때 heap.size()를 반환하면 그 값이 minimum number of rooms이다. 
	 * 먼저 모든 intervals들의 start 값으로 정렬하고 end의 min 값을 추출하는 heap을 생성한다.
	 * 그리고 heap에 intervals의 첫 element를 넣고, poll 하면서 다른 elements 값들과 비교하면서 
	 * 연결할 수 있는 element를 찾으면 end 값을 큰값으로 설정한 interval을 새로 만들어 heap에 offer한다.
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
