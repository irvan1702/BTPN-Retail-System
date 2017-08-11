import { Component, OnInit } from '@angular/core';
import { MdSnackBar, MdDialog, MdDialogRef, MdDialogConfig } from '@angular/material';
import { FormBuilder, Validators, FormGroup, FormControl } from "@angular/forms";
import { Router } from '@angular/router';
import { ItemService } from '../service/item.service'
import { Item } from '../model/Item';
import { ItemFormComponent } from '../item-form/item-form.component';

@Component({
  selector: 'item-list',
  templateUrl: './item-list.component.html',
  styleUrls: ['./item-list.component.css']
})
export class ItemListComponent implements OnInit {

  title = `Item List`;
  description = `Below you'll find the list of our goods.`;
  headers = ['ID', 'Name', 'Category', 'Price'];
  items: Item[];

  constructor(
    private itemService: ItemService,
    private router: Router,
    private dialog: MdDialog,
    private snackBar: MdSnackBar,
  ) { }

  ngOnInit() {
    this.getItems();
  }

  getItems() {
    this.items = [];
    this.itemService.getItems().subscribe(response => {
      console.log(response);
      this.items = response;
      // for (let a = 0; a < response.length; a++)
      // {
      //   //const item = response[a];

      //   const detail = [
      //       this.items[a].itemId,
      //       this.items[a].itemName,
      //       this.items[a].itemType,
      //       this.items[a].itemPrice
      //   ];
      //   this.items.push(detail);
      // }
    });
  }

  addClick() {
    let dialogRef = this.dialog.open(ItemFormComponent);

    dialogRef.afterClosed().subscribe(result => {
      if (result) { }
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



