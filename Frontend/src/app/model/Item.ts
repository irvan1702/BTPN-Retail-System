export class Item {
    public itemId: number
    public itemName: string
    public itemType: string
    public itemPrice: Date
    public itemCount: string

    constructor(
        itemName: string,
        itemType: string,
        itemPrice: Date,
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
