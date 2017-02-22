package com.whatfix.codeeval1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CodeEval1 {

	public static void main(String[] args) {

		/*if (args.length != 1) {
			System.err.println("File not found !"+"\n" + "Syntax : java -jar codeeval1_package_problem.jar <input file Name>");
			System.exit(0);
		}*/
		
		try {
			int nodeSize;
			int maxWeight;
			//String file_name = args[0];
			BufferedReader br;
			br = new BufferedReader(new FileReader("input.txt"));
			//System.out.println(args[0]);
		//	br = new BufferedReader(new FileReader(file_name));
			String line = br.readLine();
			while (line != null) {
				if (line.length() == 0) {
					continue;
				}
				line = line.replaceAll("[)($]", "");

				String strip_input[] = line.split(" ");
				List<Node> Nodes = new ArrayList<Node>();
				maxWeight = Integer.parseInt(strip_input[0]);
				// System.out.println(tempMaxWeight);
				for (int i = 2; i < strip_input.length; i++) {

					String input[] = strip_input[i].split(",");

					for (int i1 = 2; i1 < input.length; i1++) {
						Node Node = new Node();

						Node.index = Integer.parseInt(input[0]);
						Node.weight = Float.parseFloat(input[1]);
						Node.cost = Integer.parseInt(input[2]);
						Nodes.add(Node);
					}
				}

				Collections.sort(Nodes);
				nodeSize = Nodes.size();
				int maxCost = 0;
				float tempMaxWeight = maxWeight;
				int[] cPack = new int[0];
				int packCounter = 0;
				for (int i = 0; i < nodeSize; i++) {
					for (int j = i; j < nodeSize; j++) {
						int currentCost = 0;
						float currentWeight = 0;
						int[] pack = new int[15];
						int packed = 0;
						Node tempNode = Nodes.get(j);
						if ((currentWeight + tempNode.weight) <= maxWeight) {
							pack[tempNode.index] = 1;
							currentCost += tempNode.cost;
							currentWeight += tempNode.weight;
							packed++;
						}
						for (int k = i; k < nodeSize; k++) {
							if (k != j) {
								Node kNode = Nodes.get(k);
								if ((currentWeight + kNode.weight) <= maxWeight) {
									pack[kNode.index] = 1;
									currentCost += kNode.cost;
									currentWeight += kNode.weight;
									packed++;
								}
							}
						}
						if (packed > 0 && (currentCost > maxCost
								|| (currentCost == maxCost && currentWeight < tempMaxWeight))) {
							maxCost = currentCost;
							tempMaxWeight = currentWeight;
							cPack = pack;
							packCounter = packed;
						}
					}
				}
				if (packCounter > 0) {
					StringBuilder sb = new StringBuilder(packCounter * 2);
					int j = 0;
					for (int i = 1; i < 15; i++) {
						if (cPack[i] == 1) {
							sb.append(i);
							j++;
							if (j < packCounter) {
								sb.append(",");
							} else {
								break;
							}
						}
					}
					System.out.println(sb.toString());
				} else {
					System.out.println("-");
				}
				line = br.readLine();
			}
			br.close();
		} catch (IOException ex) {
			System.err.println(ex);
		}

	}
}
