package training.weirdshop;

import com.sun.tools.javac.jvm.Items;

class WeirdShop {

    private Item[] items;

    public Item[] getItems() {
        return items;
    }

    public WeirdShop(Item[] items) {
        this.items = items;
    }

    void updateQuality() {
        for (Item item : items) {
            if (!isBrie(item)
                    && !isBackstagePass(item)) {
                if (item.quality > 0) {
                    if (!isGoldCoin(item)) {
                        item.quality--;
                    }
                }
            } else {
                if (item.quality < 50) {
                    item.quality++;

                    if (isBackstagePass(item)) {
                        if (item.sellIn < 12) {
                            if (item.quality < 50) {
                                item.quality++;
                            }
                        }

                        if (item.sellIn < 7) {
                            if (item.quality < 50) {
                                item.quality++;
                            }
                        }
                    }
                }
            }

            if (!isGoldCoin(item)) {
                item.sellIn--;
            }

            if (item.sellIn < 0) {
                if (!isBrie(item)) {
                    if (!isBackstagePass(item)) {
                        if (item.quality > 0) {
                            if (!isGoldCoin(item)) {
                                item.quality--;
                            }
                        }
                    } else {
                        item.quality = 0;
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality++;
                    }
                }
            }
        }
    }


    public static boolean isBrie(Item items) {

        return items.name.equals("Aged Brie");

    }

    public static boolean isBackstagePass(Item items) {

        return items.name.equals("Backstage Pass");

    }

    public static boolean isGoldCoin(Item items) {

        return items.name.equals("Gold Coin");

    }

}