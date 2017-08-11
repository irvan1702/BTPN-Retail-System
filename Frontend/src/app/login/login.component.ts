import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthenticationService } from '../service/authentication.service'
import { Router } from '@angular/router';
import { User } from '../model/User';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  form: FormGroup;
  invalid: Boolean = false;
  userName : string;
  password : string;

  constructor(
    private formBuilder: FormBuilder,
    private authenticationService: AuthenticationService,
    private router: Router
  ) { }

  ngOnInit() {    
    this.authenticationService.logout();

    this.form = this.formBuilder.group({
      userName  : this.formBuilder.control('', [Validators.required]),
      password  : this.formBuilder.control('', [Validators.required])
    });
  }

  onSubmit(formValues)
  {
    this.invalid = false;
    if (this.form.valid)
    {
      let userName = formValues.userName;
      let password = formValues.password;
      let user = new User(userName,password);
      this.authenticationService.login(user).subscribe(
        (result) => {
          if (result)
            this.router.navigate(['/home']);
          else
            this.invalid = true;
        },
        (error) => {
          console.log(error);
        }
      );
    }
  }
}
