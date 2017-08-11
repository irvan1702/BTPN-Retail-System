import { Routes, RouterModule } from '@angular/router';

import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { ItemListComponent } from './item-list/item-list.component';
// import { ItemFormDialog } from './item-list/item-list.component';



const routes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'home', component: HomeComponent },
  { path: 'itemlist', component: ItemListComponent }
];

export const routing = RouterModule.forRoot(routes);
