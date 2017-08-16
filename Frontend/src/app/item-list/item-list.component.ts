import { Component, OnInit, Input } from '@angular/core';
import { MdSnackBar, MdDialog, MdDialogRef, MdDialogConfig } from '@angular/material';
import { FormBuilder, Validators, FormGroup, FormControl } from "@angular/forms";
import { Router } from '@angular/router';
import { ItemService } from '../service/item.service'
import { Item } from '../model/Item';
import { ItemFormComponent } from '../item-form/item-form.component';
import { Subscription } from 'rxjs/Subscription';
import { RefreshService } from '../refresh.service';

@Component({
  selector: 'item-list',
  templateUrl: './item-list.component.html',
  styleUrls: ['./item-list.component.css']
})
export class ItemListComponent implements OnInit {

  title = `Item List`;
  description = `Below you'll find the list of our goods.`;
  headers = ['ID', 'Name', 'Category', 'Price'];
  items;
  item;
  itemId;
  private subscription: Subscription;

  constructor(
    private itemService: ItemService,
    private router: Router,
    private dialog: MdDialog,
    private snackBar: MdSnackBar,
    private refreshService: RefreshService
  ) { }

  ngOnInit() {
    this.itemService.getItems().subscribe(data => {
      this.items = data;
    });

    this.subscription = this.refreshService.notifyObservable$.subscribe((res) => {
      if (res.hasOwnProperty('option') && res.option === 'refresh') {
        this.items = res.value;
      }
      else if (res.hasOwnProperty('option') && res.option === 'edit') {
        this.itemService.getItems().subscribe(data => {
          this.items = data;
        });
      }

       else if (res.hasOwnProperty('option') && res.option === 'add') {
        this.itemService.getItems().subscribe(data => {
          this.items = data;
        });
      }

    })

  }


  addClick() {
    let dialogRef = this.dialog.open(ItemFormComponent);
    this.refreshService.notifyOther({ option: "addForm", value:""});
    dialogRef.afterClosed().subscribe(result => {
      // if (result) { }
      // this.deleteTransaction(item[0]);
      this.itemService.getItems().subscribe(data => {
          this.items = data;
        });
    });
  }

  editClick(itemId) {
    let dialogRef = this.dialog.open(ItemFormComponent);
    this.itemId = itemId;
    this.itemService.getItem(itemId)
      .subscribe(data => {
        this.item = data
        this.refreshService.notifyOther({ option: "editForm", value: this.item });
      });

    dialogRef.afterClosed().subscribe(result => {
      //if (result) {
        this.itemService.getItems().subscribe(data => {
          this.items = data;
        });
      //}

      // this.deleteTransaction(item[0]);
    });
  }
}



// @Component({
//   selector: 'item-form',
//   templateUrl: '../item-form/item-form.component.html',
// })
// export class ItemFormDialog {
//     itemForm: FormGroup;
//   constructor(public dialogRef: MdDialogRef<ItemFormDialog>) {
//     this.itemForm = new FormGroup({
//       // name: this.formBuilder.control('', [Validators.required]),
//       name: new FormControl('',Validators.required),
//       price: new FormControl('',Validators.required),
//     });
//    }
// }



