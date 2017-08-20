import { Component, OnInit } from '@angular/core';
import { ItemService } from "../../service/item.service";
import { FormBuilder, Validators, FormGroup, FormControl } from "@angular/forms";
import { ActivatedRoute, Router } from "@angular/router";
import { MdDialogRef, MdDialog, MdDialogConfig } from "@angular/material";
import { Item } from '../../model/Item';
import { RefreshService } from '../../refresh.service';
import { Subscription } from 'rxjs/Subscription';

@Component({
  selector: 'app-item-form',
  templateUrl: './item-form.component.html',
  styleUrls: ['./item-form.component.css']
})
export class ItemFormComponent implements OnInit {

  itemForm: FormGroup;
  selectedItem: Item;
  title;
  itemId;
  private subscription: Subscription

  constructor(
    private itemService: ItemService,
    private formBuilder: FormBuilder,
    private router: Router,
    private dialog: MdDialog,
    public dialogRef: MdDialogRef<ItemFormComponent>,
    private refreshService: RefreshService,
  ) {
  }

  ngOnInit() {
    this.itemForm = new FormGroup({
      itemId: new FormControl('', Validators.required),
      itemName: new FormControl('', Validators.required),
      itemPrice: new FormControl('', Validators.required),
      itemType: new FormControl('', Validators.required)
    });

    this.subscription = this.refreshService.notifyObservable$.subscribe((res) => {
      if (res.hasOwnProperty('option') && res.option === 'editForm') {
        this.selectedItem = res.value;
        this.itemId = this.selectedItem.itemId;
        this.title = "Edit Item"
        this.itemForm.controls['itemId'].setValue(this.selectedItem.itemId);
        this.itemForm.controls['itemName'].setValue(this.selectedItem.itemName);
        this.itemForm.controls['itemPrice'].setValue(this.selectedItem.itemPrice);
        this.itemForm.controls['itemType'].setValue(this.selectedItem.itemType);
      }
    })

  }

  onSubmit(data) {
    console.log(data);
    if (this.itemId != null) {
      this.itemService.modifyItem(data).subscribe(() => {
        this.refreshService.notifyOther({ option: 'edit', value: "" });
      });
    }

    else if (this.itemId == null) {
      console.log(data+"afadfafasdas");
      this.itemService.addItem(data).subscribe(() => {
        this.refreshService.notifyOther({ option: 'add', value: "" });
      });
    }


  }
}
