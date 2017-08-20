export class Item {
    public itemId: number
    public itemName: string
    public itemType: string
    public itemPrice: number
    public itemCount: string

    constructor(
        itemName: string,
        itemType: string,
        itemPrice: number,
        itemId?: number,
        itemCount?: string

    ) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemType = itemType;
        this.itemPrice = itemPrice;
        this.itemCount = itemCount;
    }
}
