import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserListComponent } from './user-list/user-list.component';
import {HttpClientModule} from "@angular/common/http";
import { StockauctionComponent } from './stockauction/stockauction.component';
import { StockformComponent } from './stockauctionform/stockform.component';
import {FormsModule} from "@angular/forms";
import {StockauctionService} from "./stockauction.service";
import { StockbasementComponent } from './stockbasement/stockbasement.component';
import { StockbasementformComponent } from './stockbasementform/stockbasementform.component';
import { StockgarageComponent } from './stockgarage/stockgarage.component';
import { StockgarageformComponent } from './stockgarageform/stockgarageform.component';

@NgModule({
  declarations: [
    AppComponent,
    UserListComponent,
    StockauctionComponent,
    StockformComponent,
    StockbasementComponent,
    StockbasementformComponent,
    StockgarageComponent,
    StockgarageformComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [StockauctionService],
  bootstrap: [AppComponent]
})
export class AppModule { }
