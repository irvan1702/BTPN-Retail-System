import {Item } from '../model/Item';
import {User } from '../model/User';
export class Transaction {
    public transactionId: number
    public transactionDate: Date
    public totalPrice: number
    public discount: number
    public quantity: number
    public grandTotal: number
    public userId: User
    public itemId: Item
    //public itemName:string


    constructor(
        
        transactionDate: Date,
        totalPrice: number,
        discount: number,
        quantity: number,
        grandTotal: number,
        itemId: Item,
        userId: User,
        transactionId?: number
        //itemName:string

    ) {
        this.transactionId = transactionId;
        this.transactionDate = transactionDate;
        this.totalPrice = totalPrice;
        this.discount = discount;
        this.quantity = quantity;
        this.grandTotal = grandTotal;
        this.itemId = itemId;
        this.userId = userId;
       // this.itemName = itemName
    }
}
