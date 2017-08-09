import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { MaterialModule } from '@angular/material';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { routing } from './app.routing'
import { HomeComponent } from './home/home.component';
import { AuthenticationService } from './login/authentication.service';
import { GoodService } from './home/good.service'


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent
],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    routing,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule
  ],
  providers: [
    AuthenticationService,
    GoodService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
