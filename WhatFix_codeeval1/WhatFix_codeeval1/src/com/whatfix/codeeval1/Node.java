package com.whatfix.codeeval1;

public class Node implements Comparable<Node>{

	int index;
	float weight;
	int cost;

	@Override
	public String toString() {
		return "Item{" + "index=" + index + ", weight=" + weight + ", cost=" + cost + '}';
	}

	public int compareTo(Node node) {
		if (cost == node.cost) {
			if (node.weight < weight)
				return 1;
			else
				return -1;

		} else {
			if (cost < node.cost)
				return 1;
			else
				return -1;

		}
	}
}
