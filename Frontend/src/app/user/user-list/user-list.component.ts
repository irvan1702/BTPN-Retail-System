import { Component, OnInit } from '@angular/core';
import { MdSnackBar, MdDialog, MdDialogRef, MdDialogConfig } from '@angular/material';
import { FormBuilder, Validators, FormGroup, FormControl } from "@angular/forms";
import { DatePipe } from '@angular/common';
import { Router } from '@angular/router';
import { UserService } from '../../service/user.service'
import { User } from '../../model/User';
import { UserFormComponent } from '../user-form/user-form.component';
import { DeleteComponent } from '../../delete/delete.component';
import { Subscription } from 'rxjs/Subscription';
import { RefreshService } from '../../refresh.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {
  title = `User List`;
  description = `Below you'll find the list of our user.`;
  headers = ['ID', 'Name', 'User Role', 'Join Date'];
  users;
  user;
  userId;
  private subscription: Subscription;

  constructor(
    private userService: UserService,
    private router: Router,
    private dialog: MdDialog,
    private datepipe: DatePipe,
    private snackBar: MdSnackBar,

    private refreshService: RefreshService
  ) { }

  ngOnInit() {
    this.userService.getUsers().subscribe(data => {
      this.users = data;
    });

    this.subscription = this.refreshService.notifyObservable$.subscribe((res) => {
      if (res.hasOwnProperty('option') && res.option === 'refresh') {
        this.users = res.value;
      }
      else if (res.hasOwnProperty('option') && res.option === 'edit') {
        this.userService.getUsers().subscribe(data => {
          this.users = data;
        });
      }

      else if (res.hasOwnProperty('option') && res.option === 'add') {
        this.userService.getUsers().subscribe(data => {
          this.users = data;
        });
      }

    })

  }


  addClick() {
    let dialogRef = this.dialog.open(UserFormComponent);
    this.refreshService.notifyOther({ option: "addForm", value: "" });
    dialogRef.afterClosed().subscribe(result => {
      if (result == 'save') {
        this.userService.getUsers().subscribe(data => {
          this.users = data;
        });
      }

    });
  }

  editClick(userId) {
    let dialogRef = this.dialog.open(UserFormComponent);
    this.userId = userId;
    this.userService.getUser(userId)
      .subscribe(data => {
        this.user = data
        this.refreshService.notifyOther({ option: "editForm", value: this.user });
      });

    dialogRef.afterClosed().subscribe(result => {
      if (result == 'save') {
        this.userService.getUsers().subscribe(data => {
          this.users = data;
        });


      }
    });
  }

  deleteClick(userId) {
    let dialogRef = this.dialog.open(DeleteComponent);
    this.userService.getUser(userId)
      .subscribe(data => {
        this.user = data
      });
    dialogRef.afterClosed().subscribe(data => {
      if (data == 'delete') {
        this.userService.deleteUser(userId).subscribe(() => {
          this.userService.getUsers().subscribe(res => {
            this.users = res;
          });
        });
      }
    })
  }
}



