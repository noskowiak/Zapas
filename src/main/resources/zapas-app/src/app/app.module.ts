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

@NgModule({
  declarations: [
    AppComponent,
    UserListComponent,
    StockauctionComponent,
    StockformComponent
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
