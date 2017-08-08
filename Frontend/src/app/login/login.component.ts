import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthenticationService } from './authentication.service'
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  form: FormGroup;
  invalid: Boolean = false;

  constructor(
    private formBuilder: FormBuilder,
    private authenticationService: AuthenticationService,
    private router: Router
  ) { }

  ngOnInit() {    
    this.authenticationService.logout();

    this.form = this.formBuilder.group({
      username  : this.formBuilder.control('', [Validators.required]),
      password  : this.formBuilder.control('', [Validators.required])
    });
  }

  onSubmit(formValues)
  {
    this.invalid = false;
    if (this.form.valid)
    {
      this.authenticationService.login(formValues.username, formValues.password).subscribe(
        (result) => {
          if (result)
            this.router.navigate(['home']);
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
