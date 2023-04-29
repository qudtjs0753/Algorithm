package swexpert.greedy;

import java.util.*;

class UserSolution {

	/**
	 * 물류허브 설치했을 때 총 운송비용의 계산.
	 * 허브의 운송 비용은 0
	 * 도로는 단방향이므로, 허브 도시까지 가는 최소비용과 돌아오는 비용은 다를 수 있다
	 * 도로 개수 N <= 1400
	 * 도시 최대 수는 600개 이하
	 * 모든 함수의 호출 횟수 총합 50 이하
	 * 점 구할 때 각 점별로 다익스트라 돌린다면?
	 */
	static int cityCount = 0;
	static ArrayList<Node>[] list;
	static ArrayList<Node>[] revList;
	static HashMap<Integer, Integer> city;
	static int[] dist;
	static int[] revDist;


	public int init(int N, int sCity[], int eCity[], int mCost[]) {
		city = new HashMap<>();
		int idx = 0;
		for(int i=0; i<N; i++) {
			if(!city.containsKey(sCity[i])) {
				city.put(sCity[i], idx++);
			}

			if(!city.containsKey(eCity[i])) {
				city.put(eCity[i], idx++);
			}
		}

		list = new ArrayList[city.size()];
		revList = new ArrayList[city.size()];
		for(int i=0; i<list.length; i++) {
			list[i] = new ArrayList<>();
			revList[i] = new ArrayList<>();
		}

		for(int i=0; i<N; i++) {
			list[city.get(sCity[i])].add(new Node(city.get(eCity[i]), mCost[i]));
			revList[city.get(eCity[i])].add(new Node(city.get(sCity[i]), mCost[i]));
		}
		cityCount = city.size();
		return city.size();
	}

	public void add(int sCity, int eCity, int mCost) {
		list[city.get(sCity)].add(new Node(city.get(eCity), mCost));
		list[city.get(eCity)].add(new Node(city.get(sCity), mCost));
	}

	public int cost(int mHub) {
		dist = dajikstra(mHub, list);
		revDist = dajikstra(mHub, revList);
		int ret = 0;
		for(int i=0; i<cityCount; i++) {
			ret += dist[i];
			ret += revDist[i];
		}

		return ret;
	}

	private int[] dajikstra(int mHub, ArrayList<Node>[] list) {
		int[] temp = new int[cityCount];
		PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
		Arrays.fill(temp, Integer.MAX_VALUE);
		temp[city.get(mHub)] = 0;
		pq.add(new Node(city.get(mHub), 0));

		while(!pq.isEmpty()) {
			Node current = pq.poll();
			System.out.println("cur" + current.end);
			for(Node next : list[city.get(current.end)]) {
				int tempDist = next.weight + current.weight;
				System.out.println(city.get(next.end));

				if(tempDist < temp[city.get(next.end)]) {
					pq.add(new Node(next.end, tempDist));
					temp[next.end] = tempDist;
				}
			}
		}
		return temp;
	}

	static class Node {
		int end, weight;

		public Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
	}
}

