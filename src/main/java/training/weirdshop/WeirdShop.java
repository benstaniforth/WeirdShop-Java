package training.weirdshop;


class WeirdShop {

    private Item[] items;


    public WeirdShop(Item[] items) {
        this.items = items;
    }

    void updateQuality() {

        for (Item item : items) {
            if (!isGoldCoin(item)) {
                item.sellIn--;
            }
            if (isBrie(item)) {
                newBrieValues(item);
            } else if (isBackstagePass(item)) {
                newBackstagePassValues(item);
            } else if (!isGoldCoin(item)) {
                if (item.sellIn >= 0 && item.quality > 0) {
                    item.quality--;
                } else if (!(item.sellIn >= 0) && item.quality > 0) {
                    item.quality = item.quality - 2;
                }
            }
        }
    }


    public static boolean isBrie(Item item) {

        return item.name.equals("Aged Brie");

    }

    public static boolean isBackstagePass(Item item) {

        return item.name.equals("Backstage Pass");

    }

    public static boolean isGoldCoin(Item item) {

        return item.name.equals("Gold Coin");

    }

    public static boolean isSomeOtherItem(Item item) {

        return item.name.equals("Some other item");

    }

    public void newBrieValues(Item item) {

        if (isBrie(item) && item.quality < 50) {
            item.quality++;
        }

    }

    public void newBackstagePassValues(Item item) {

        if (item.quality < 50) {
            if (item.sellIn > 10) {
                item.quality++;
            } else if (item.sellIn < 11 && item.sellIn > 5) {
                item.quality = item.quality + 2;
            } else if (item.sellIn < 6 && item.sellIn > -1) {
                item.quality = item.quality + 3;
            } else if (item.sellIn < 0) {
                item.quality = 0;
            }
        }
    }



}

