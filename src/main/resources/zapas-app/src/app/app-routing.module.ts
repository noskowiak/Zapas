import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {UserListComponent} from "./user-list/user-list.component";
import {StockauctionComponent} from "./stockauction/stockauction.component";
import {StockformComponent} from "./stockauctionform/stockform.component";

const routes: Routes = [
  { path: 'user', component: UserListComponent },
  { path: 'stockauction', component: StockauctionComponent },
  { path: 'addStockAuctionItem', component: StockformComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
