import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {UserListComponent} from "./user-list/user-list.component";
import {StockauctionComponent} from "./stockauction/stockauction.component";
import {StockformComponent} from "./stockauctionform/stockform.component";
import {StockbasementComponent} from "./stockbasement/stockbasement.component";
import {StockbasementformComponent} from "./stockbasementform/stockbasementform.component";
import {StockgarageComponent} from "./stockgarage/stockgarage.component";
import {StockgarageformComponent} from "./stockgarageform/stockgarageform.component";

const routes: Routes = [
  { path: 'user', component: UserListComponent },
  { path: 'stockauction', component: StockauctionComponent },
  { path: 'addStockAuctionItem', component: StockformComponent},
  { path: 'stockbasement', component: StockbasementComponent},
  { path: 'addStockBasementItem', component: StockbasementformComponent},
  { path: 'stockgarage', component: StockgarageComponent},
  { path: 'addStockGaragetItem', component: StockgarageformComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
