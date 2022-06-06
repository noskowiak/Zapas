import { Component, OnInit } from '@angular/core';
import {Stockauction} from "../stockauction";
import {Subscription} from "rxjs";
import {ActivatedRoute, Router} from "@angular/router";
import {StockauctionService} from "../stockauction.service";

@Component({
  selector: 'app-stockauction',
  templateUrl: './stockauction.component.html',
  styleUrls: ['./stockauction.component.css']
})
export class StockauctionComponent implements OnInit {

  stockauctions?: Stockauction[] = [];
  private stockauctionsSubscription?: Subscription;


  public Stockauction: Stockauction = {
    productSymbol: "",
    productName: "",
    quantity: 0,
    locationName: "",
  }


  constructor(
    private stockauctionService: StockauctionService,
    private router: Router) {
  }


  ngOnInit() {
    this.stockauctionService.getAllStockAuction().subscribe(
      response => {
        this.stockauctions = response;
      })

  }

  public OnDelete(stockauctionId: Stockauction): void {
    this.stockauctionService
      .deleteStockAuction(stockauctionId)
      .subscribe(result => this.stockauctions = this.stockauctions!!
        .filter((stockauction) => stockauction.id !== stockauctionId.id));
    console.log(stockauctionId);
  }

  ngOnDestroy() {
    if (this.stockauctionsSubscription) {
      this.stockauctionsSubscription.unsubscribe();
    }
  }


}



