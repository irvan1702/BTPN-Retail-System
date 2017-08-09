import { Component, OnInit } from '@angular/core';
import { MdSnackBar, MdDialog, MdDialogRef, MdDialogConfig } from '@angular/material';
import { Router } from '@angular/router';
import { GoodService } from './good.service'

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  title = `Item List`;
  description = `Below you'll find the list of our goods.`;
  headers = ['ID', 'Name', 'Category', 'Price'];
  items = [];

  constructor(
    private goodService : GoodService,
    private router: Router,
    private dialog: MdDialog,
    private snackBar: MdSnackBar
  ) { }

  ngOnInit() {
    this.getGoods();
  }

  getGoods()
  {
    this.items = [];
    this.goodService.getGoods().subscribe(response => {
      for (let a = 0; a < response.length; a++)
      {
        const item = response[a];
        const detail = [
            item.id,
            item.name,
            item.itemCategory.name,
            item.price,
        ];
        this.items.push(detail);
      }
    });
  }


}
