import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { MaterialModule } from '@angular/material';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { MdDialogModule } from '@angular/material';
import { HttpModule } from '@angular/http';
import { RefreshService } from './refresh.service';
import { DatePipe } from '@angular/common';
import 'hammerjs';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { routing } from './app.routing'
import { AuthenticationService } from './service/authentication.service';
import { ItemService } from './service/item.service';
import { UserService } from './service/user.service';
import { TransactionService } from './service/transaction.service';
import { ItemFormComponent } from './item/item-form/item-form.component';
// import { ItemFormDialog } from './item-list/item-list.component';
import { ItemListComponent } from './item/item-list/item-list.component';
import { UserListComponent } from './user/user-list/user-list.component';
import { UserFormComponent } from './user/user-form/user-form.component';
import { TransactionListComponent } from './transaction/transaction-list/transaction-list.component';
import { TransactionFormComponent } from './transaction/transaction-form/transaction-form.component';
import { HomeComponent } from './home/home.component';
import { DeleteComponent } from './delete/delete.component';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ItemFormComponent,
    ItemListComponent,
    UserListComponent,
    UserFormComponent,
    TransactionListComponent,
    TransactionFormComponent,
    HomeComponent,
    DeleteComponent
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
    UserService,
    DatePipe,
    TransactionService,
    RefreshService
  ],
  entryComponents: [
    ItemFormComponent,
    UserFormComponent,
    DeleteComponent,
    TransactionFormComponent
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
