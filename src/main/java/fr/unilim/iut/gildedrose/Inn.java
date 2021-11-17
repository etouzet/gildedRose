package fr.unilim.iut.gildedrose;

import java.util.ArrayList;
import java.util.List;

public class Inn {
	private List<Item> items;

	public Inn() {
		items = new ArrayList<Item>();
		items.add(new Item("+5 Dexterity Vest", 10, 20));
		items.add(new Item("Aged Brie", 2, 0));
		items.add(new Item("Elixir of the Mongoose", 5, 7));
		items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		items.add(new Item("Conjured Mana Cake", 3, 6));
	}

	public List<Item> getItems() {
		return items;
	}

	public void updateQuality() {
		for (int i = 0; i < items.size(); i++) {
			if (nameDifferentOfAgedBrieAndBackstage(i)) {
				if (qualityHigherToZero(i)) {
					if (nameDifferentOfSulfuras(i)) {
						items.get(i).setQuality(items.get(i).getQuality() - 1);
					}
				}
			} else {
				if (qualityLowerToFifty(i)) {
					items.get(i).setQuality(items.get(i).getQuality() + 1);

					if (nameIsBackstage(i)) {
						if (sellInLowerThanEleven(i)) {
							if (qualityLowerToFifty(i)) {
								items.get(i).setQuality(items.get(i).getQuality() + 1);
							}
						}

						if (items.get(i).getSellIn() < 6) {
							if (qualityLowerToFifty(i)) {
								items.get(i).setQuality(items.get(i).getQuality() + 1);
							}
						}
					}
				}
			}

			if (nameDifferentOfSulfuras(i)) {
				items.get(i).setSellIn(items.get(i).getSellIn() - 1);
			}

			if (items.get(i).getSellIn() < 0) {
				if (nameDifferentOfAgedBrie(i)) {
					if (nameDifferentOfBackstage(i)) {
						if (qualityHigherToZero(i)) {
							if (nameDifferentOfSulfuras(i)) {
								items.get(i).setQuality(items.get(i).getQuality() - 1);
							}
						}
					} else {
						items.get(i).setQuality(items.get(i).getQuality() - items.get(i).getQuality());
					}
				} else {
					if (qualityLowerToFifty(i)) {
						items.get(i).setQuality(items.get(i).getQuality() + 1);
					}
				}
			}
		}

	}

	private boolean sellInLowerThanEleven(int i) {
		return items.get(i).getSellIn() < 11;
	}

	private boolean nameIsBackstage(int i) {
		return items.get(i).getName().equals("Backstage passes to a TAFKAL80ETC concert");
	}

	private boolean nameDifferentOfSulfuras(int i) {
		return !items.get(i).getName().equals("Sulfuras, Hand of Ragnaros");
	}

	private boolean nameDifferentOfAgedBrieAndBackstage(int i) {
		return nameDifferentOfAgedBrie(i)
				&& nameDifferentOfBackstage(i);
	}

	private boolean nameDifferentOfBackstage(int i) {
		return !nameIsBackstage(i);
	}

	private boolean nameDifferentOfAgedBrie(int i) {
		return !items.get(i).getName().equals("Aged Brie");
	}

	private boolean qualityLowerToFifty(int i) {
		return items.get(i).getQuality() < 50;
	}

	private boolean qualityHigherToZero(int i) {
		return items.get(i).getQuality() > 0;
	}
}