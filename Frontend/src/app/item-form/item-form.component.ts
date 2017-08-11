import { Component, OnInit } from '@angular/core';
import { ItemService } from "../service/item.service";
import { FormBuilder, Validators, FormGroup, FormControl } from "@angular/forms";
import { ActivatedRoute, Router } from "@angular/router";
import { MdDialogRef, MdDialog, MdDialogConfig, MdSnackBar } from "@angular/material";
import { Item } from '../model/Item';

// @Component({
//    selector: 'item-form',
//    templateUrl: '../item-form/item-form.component.html',
//  })
//  export class ItemFormDialog {
//      itemForm: FormGroup;
//    constructor(public dialogRef: MdDialogRef<ItemFormDialog>) {
// //     this.itemForm = new FormGroup({
// //       // name: this.formBuilder.control('', [Validators.required]),
// //       name: new FormControl('',Validators.required),
// //       price: new FormControl('',Validators.required),
// //     });
// //    }
// // } 

@Component({
  selector: 'app-item-form',
  templateUrl: './item-form.component.html',
  styleUrls: ['./item-form.component.css']
})
export class ItemFormComponent implements OnInit {

  categories = [
    'food',
    'drink',
    'groceries'
  ];
  itemForm: FormGroup;
  selectedItem: Item;
  title;

  constructor(
    private itemService: ItemService,
    private formBuilder: FormBuilder,
    private activatedRoute: ActivatedRoute,
    private snackBar: MdSnackBar,
    private router: Router,
  ) {

    // this.activatedRoute.params.subscribe(param => {
    //   if (param['id'] && !isNaN(param['id'])) {
    //     this.itemService.getItem(param['id']).subscribe(selectedItem => {
    //       this.selectedItem = selectedItem;
    //       this.title = `Edit ${selectedItem.name}`;
    //     });
    //   }
    //   else
    //     this.title = 'Add New Item';
    // });
  }

  ngOnInit() {
    this.itemForm = new FormGroup({
      // name: this.formBuilder.control('', [Validators.required]),
      name: new FormControl('',Validators.required),
      price: new FormControl('',Validators.required),
    });
  }

  /* onSubmit(data) {
    let goodData: any = new FormData(document.querySelector('form'));
    goodData.append('categoryId', data.categoryId);

    if (this.selectedGood.id)
      goodData.append('itemId', this.selectedGood.id);

    this.goodService.modifyGood(goodData).subscribe(response => {
      if (this.selectedGood.id) {
        this.snackBar.open(`Successfully Modified ${response.name}`, 'OK', {
          duration: 1500
        });
      }
      else {
        this.router.navigate(['goods', response.id]);
        this.snackBar.open(`Successfully Added ${response.name}`, 'OK', {
          duration: 1500
        });
      }
    });
  } */
}

