import { Component, OnInit, Input } from '@angular/core';
import { MdSnackBar, MdDialog, MdDialogRef, MdDialogConfig } from '@angular/material';
import { FormBuilder, Validators, FormGroup, FormControl } from "@angular/forms";
import { Router } from '@angular/router';
import { TransactionService } from '../../service/transaction.service'
import { Transaction } from '../../model/Transaction';
import { TransactionFormComponent } from '../transaction-form/transaction-form.component';
import { DeleteComponent } from '../../delete/delete.component';
import { Subscription } from 'rxjs/Subscription';
import { RefreshService } from '../../refresh.service';

@Component({
  selector: 'app-transaction-list',
  templateUrl: './transaction-list.component.html',
  styleUrls: ['./transaction-list.component.css']
})
export class TransactionListComponent implements OnInit {

  title = `Transaction List`;
  description = `Below you'll find the list of our transaction.`;
  headers = ['ID','Item Name','Quantity','Transaction Date', 'Total Price', 'Discount', 'Grand Total'];
  transactions;
  transaction;
  transactionId;
  private subscription: Subscription;

  constructor(
    private transactionService: TransactionService,
    private router: Router,
    private dialog: MdDialog,
    private snackBar: MdSnackBar,
    private refreshService: RefreshService
  ) { }

  ngOnInit() {
    this.transactionService.getTransactions().subscribe(data => {
      this.transactions = data;
    });

    this.subscription = this.refreshService.notifyObservable$.subscribe((res) => {
      if (res.hasOwnProperty('option') && res.option === 'refresh') {
        this.transactions = res.value;
      }
      else if (res.hasOwnProperty('option') && res.option === 'edit') {
        this.transactionService.getTransactions().subscribe(data => {
          this.transactions = data;
        });
      }

      else if (res.hasOwnProperty('option') && res.option === 'add') {
        this.transactionService.getTransactions().subscribe(data => {
          this.transactions = data;
        });
      }

    })

  }


  addClick() {
    let dialogRef = this.dialog.open(TransactionFormComponent);
    this.refreshService.notifyOther({ option: "addForm", value: "" });
    dialogRef.afterClosed().subscribe(result => {
      if (result == 'save') {
        this.transactionService.getTransactions().subscribe(data => {
          this.transactions = data;
        });
      }

    });
  }

  editClick(transactionId) {
    let dialogRef = this.dialog.open(TransactionFormComponent);
    this.transactionId = transactionId;
    this.transactionService.getTransaction(transactionId)
      .subscribe(data => {
        this.transaction = data
        this.refreshService.notifyOther({ option: "editForm", value: this.transaction });
      });

    dialogRef.afterClosed().subscribe(result => {
      if (result == 'save') {
        this.transactionService.getTransactions().subscribe(data => {
          this.transactions = data;
        });


      }
    });
  }

  deleteClick(transactionId) {
    let dialogRef = this.dialog.open(DeleteComponent);
    this.transactionService.getTransaction(transactionId)
      .subscribe(data => {
        this.transaction = data
      });
      
    dialogRef.afterClosed().subscribe(data => {
      if (data == 'delete') {
        this.transactionService.deleteTransaction(transactionId).subscribe(() => {
          this.transactionService.getTransactions().subscribe(res => {
            this.transactions = res;
          });
        });
      }
    })
  }
}




