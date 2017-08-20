import { Component, OnInit } from '@angular/core';
import { ItemService } from "../../service/item.service";
import { UserService } from "../../service/user.service";
import { TransactionService } from "../../service/transaction.service";
import { FormBuilder, Validators, FormGroup, FormControl } from "@angular/forms";
import { ActivatedRoute, Router } from "@angular/router";
import { MdDialogRef, MdDialog, MdDialogConfig } from "@angular/material";
import { Item } from '../../model/Item';
import { User } from '../../model/User';
import { LoggedUser } from '../../model/loggedUser';
import { Transaction } from '../../model/Transaction';
import { RefreshService } from '../../refresh.service';
import { Subscription } from 'rxjs/Subscription';

@Component({
  selector: 'app-transaction-form',
  templateUrl: './transaction-form.component.html',
  styleUrls: ['./transaction-form.component.css']
})
export class TransactionFormComponent implements OnInit {
  transactionForm: FormGroup;
  selectedTransaction: Transaction;
  title;
  transactionId;
  items: Item[];
  item: Item;
  itemId;
  user: User;
  transaction: Transaction;
  loggedUser: LoggedUser;
  private subscription: Subscription

  constructor(
    private itemService: ItemService,
    private userService: UserService,
    private transactionService: TransactionService,
    private formBuilder: FormBuilder,
    private router: Router,
    private dialog: MdDialog,
    public dialogRef: MdDialogRef<TransactionFormComponent>,
    private refreshService: RefreshService,
  ) {
  }

  ngOnInit() {
    this.transactionForm = new FormGroup({
      item: new FormControl('', Validators.required),
      quantity: new FormControl('', Validators.required),
      
    });
    console.log(new Date());
    this.itemService.getItems().subscribe(res => {
      this.items = res;
    });

    this.subscription = this.refreshService.notifyObservable$.subscribe((res) => {
      if (res.hasOwnProperty('option') && res.option === 'editForm') {
        this.transaction = res.value;
        this.transactionId = this.transaction.transactionId;
        this.title = "Edit Transaction"
        this.transactionForm.controls['item'].setValue(this.transaction.itemId);
        this.transactionForm.controls['quantity'].setValue(this.transaction.quantity);
      }
    })

  }

  onItemChange($event) {
    this.itemService.getItem($event.value).subscribe(response => {
      //console.log(response);
      this.item = response;
      this.transactionForm.get('quantity').setValue(0);
    });
  }

  onSubmit() {
    // console.log(data);
    if (this.transactionId != null) {
      console.log(this.transactionId);
      let quantity = this.transactionForm.get('quantity').value;
      let totalPrice = this.item.itemPrice * quantity;
      let grandTotal;
      this.transactionService.calculatePrice(1, this.item.itemId, quantity).
        subscribe(res => {
          grandTotal = res;
          this.userService.getUser(1).subscribe(res => {
            this.transaction = new Transaction(new Date(),
              totalPrice, 0, quantity, grandTotal, this.item, this.user,this.transactionId);

            this.transactionService.modifyTransaction(this.transaction).subscribe(() => {
              this.refreshService.notifyOther({ option: 'edit', value: "" });
            })
          });
        });
    }

    else if (this.transactionId == null) {
      let quantity = this.transactionForm.get('quantity').value;
      let totalPrice = this.item.itemPrice * quantity;
      let grandTotal;
      this.transactionService.calculatePrice(1, this.item.itemId, quantity).
        subscribe(res => {
          grandTotal = res;
          this.userService.getUser(1).subscribe(res => {
            this.transaction = new Transaction(new Date(),
              totalPrice, 0, quantity, grandTotal, this.item, this.user);

            this.transactionService.addTransaction(this.transaction).subscribe(() => {
              this.refreshService.notifyOther({ option: 'add', value: "" });
            })
          });
        });


    }

  }
}
