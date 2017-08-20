import { Component, OnInit } from '@angular/core';
import { RefreshService } from '../refresh.service';
import { ItemService } from '../service/item.service';
import { MdDialog, MdDialogRef } from '@angular/material';
import { Subscription } from 'rxjs/Subscription'

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})

export class DeleteComponent implements OnInit {
	name;
	private subscription: Subscription

	constructor(public dialogRef: MdDialogRef<DeleteComponent>, public dialog: MdDialog,
		private service: ItemService, private refreshService: RefreshService) {
		this.subscription = this.refreshService.notifyObservable$.subscribe((res) => {
			if (res.hasOwnProperty('option') && res.option === 'showItem') {
				this.name = res.value;
			}
		});
	}

	ngOnInit() {

	}

}
