import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { MaterialModule } from '@angular/material';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { MdDialogModule } from '@angular/material';
import { HttpModule } from '@angular/http';
import { RefreshService } from './refresh.service';
import 'hammerjs';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { routing } from './app.routing'
import { AuthenticationService } from './service/authentication.service';
import { ItemService } from './service/item.service'
import { ItemFormComponent } from './item-form/item-form.component';
// import { ItemFormDialog } from './item-list/item-list.component';
import { ItemListComponent } from './item-list/item-list.component';
import { HomeComponent } from './home/home.component';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ItemFormComponent,
    ItemListComponent,
    HomeComponent,
    // ItemFormDialog
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    routing,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule,
    MdDialogModule
  ],
  providers: [
    AuthenticationService,
    ItemService,
    RefreshService
  ],
  entryComponents: [
    // ItemFormDialog
    ItemFormComponent
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
