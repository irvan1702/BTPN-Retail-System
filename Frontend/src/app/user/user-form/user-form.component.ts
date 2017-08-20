import { Component, OnInit } from '@angular/core';
import {DatePipe } from '@angular/common';
import { UserService } from "../../service/user.service";
import { FormBuilder, Validators, FormGroup, FormControl } from "@angular/forms";
import { ActivatedRoute, Router } from "@angular/router";
import { MdDialogRef, MdDialog, MdDialogConfig } from "@angular/material";
import { User } from '../../model/User';
import { RefreshService } from '../../refresh.service';
import { Subscription } from 'rxjs/Subscription';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent implements OnInit {

  userForm: FormGroup;
  selectedUser: User;
  title;
  userId;
  private subscription: Subscription

  constructor(
    private userService: UserService,
    private formBuilder: FormBuilder,
    private router: Router,
    private dialog: MdDialog,
    private datepipe: DatePipe,
    public dialogRef: MdDialogRef<UserFormComponent>,
    private refreshService: RefreshService,
  ) {
  }

  ngOnInit() {
    this.userForm = new FormGroup({
      userId: new FormControl('', Validators.required),
      userName: new FormControl('', Validators.required),
      password: new FormControl('', Validators.required),
      userType: new FormControl('', Validators.required),
      name: new FormControl('', Validators.required),
      joinDate: new FormControl('', Validators.required)
      
    });

    this.subscription = this.refreshService.notifyObservable$.subscribe((res) => {
      if (res.hasOwnProperty('option') && res.option === 'editForm') {
        let tempDate="";
        this.selectedUser = res.value;
        this.userId = this.selectedUser.userId;
        this.title = "Edit User"
        this.userForm.controls['userId'].setValue(this.selectedUser.userId);
        this.userForm.controls['userName'].setValue(this.selectedUser.userName);
        this.userForm.controls['password'].setValue(this.selectedUser.password);
        this.userForm.controls['userType'].setValue(this.selectedUser.userType);
        this.userForm.controls['name'].setValue(this.selectedUser.name);
        var convertDate = new Date(this.selectedUser.joinDate);
        tempDate = this.datepipe.transform(convertDate, 'yyyy-MM-dd');
        this.userForm.controls['joinDate'].setValue(tempDate);
        //console.log(this.userForm.value);
      }
    })

  }

  onSubmit(data) {
    if (this.userId != null) {
      this.userService.modifyUser(data).subscribe(() => {
        this.refreshService.notifyOther({ option: 'edit', value: "" });
      });
    }

    else if (this.userId == null) {
      console.log(data+"afadfafasdas");
      this.userService.addUser(data).subscribe(() => {
        this.refreshService.notifyOther({ option: 'add', value: "" });
      });
    }


  }

}
