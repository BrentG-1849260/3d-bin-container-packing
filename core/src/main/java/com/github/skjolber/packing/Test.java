package com.github.skjolber.packing;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		ArrayList<Container> containers = new ArrayList<>();
		containers.add(new Container(200, 200, 200, Integer.MAX_VALUE));
		Packager packager = BruteForcePackager.newBuilder().withContainers(containers).build();
		ArrayList<BoxItem> items = new ArrayList<>();
		items.add(new BoxItem(new Box("1", 60, 18, 60, 1, true), 1));
		items.add(new BoxItem(new Box("2", 20, 20, 10, 1, true), 1));
		items.add(new BoxItem(new Box("3", 200, 200, 200, 1, true), 1));
		items.add(new BoxItem(new Box("4", 60, 18, 60, 1, true), 1));
		List<Container> packing = packager.packList(items, Integer.MAX_VALUE, Long.MAX_VALUE);
		int containerIdx = 0;
		for (Container container : packing) {
			System.out.print(containerIdx + ": ");
			for (Level level : container.getLevels()) {
				for (Placement placement : level) {
					System.out.print(placement.getBox().getName() + " ");
				}
			}
			++containerIdx;
			System.out.println();
		}
	}
}
