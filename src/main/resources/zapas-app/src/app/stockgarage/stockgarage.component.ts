import { Component, OnInit } from '@angular/core';
import {Stockgarage} from "../stockgarage";
import {ActivatedRoute, Router} from "@angular/router";
import {StockgarageService} from "../stockgarage.service";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-stockgarage',
  templateUrl: './stockgarage.component.html',
  styleUrls: ['./stockgarage.component.css']
})
export class StockgarageComponent implements OnInit {

  stockgarages?: Stockgarage[] = [];
  private stockgarageSubscription?: Subscription;


  constructor(
    private stockgarageService: StockgarageService,
    private router: Router) {
  }

  ngOnInit() {
    this.stockgarageService.getAllStockGarage().subscribe(
      response => {
        this.stockgarages = response;
      })
  }


  public OnDelete(stockgarageId: Stockgarage): void {
    this.stockgarageService
      .deleteStockGarage(stockgarageId)
      .subscribe(result => this.stockgarages = this.stockgarages!!
        .filter((stockgarages) => stockgarages.id !== stockgarageId.id));
  }

  ngOnDestroy() {
    if (this.stockgarageSubscription) {
      this.stockgarageSubscription.unsubscribe();
    }
  }

}
