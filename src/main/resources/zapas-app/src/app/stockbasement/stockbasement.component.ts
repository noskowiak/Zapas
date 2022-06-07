import { Component, OnInit } from '@angular/core';
import {Subscription} from "rxjs";
import {ActivatedRoute, Router} from "@angular/router";
import {Stockbasement} from "../stockbasement";
import {StockbasementService} from "../stockbasement.service";

@Component({
  selector: 'app-stockbasement',
  templateUrl: './stockbasement.component.html',
  styleUrls: ['./stockbasement.component.css']
})
export class StockbasementComponent implements OnInit {

  stockbasements?: Stockbasement[] = [];
  private stockbasementsSubscription?: Subscription;


  public Stockbasement: Stockbasement = {
    productSymbol: "",
    productName: "",
    quantity: 0,
    locationName: "",
  }

  constructor(
    private stockbasementService: StockbasementService,
    private router: Router) {
  }


  ngOnInit() {
    this.stockbasementService.getAllStockBasement().subscribe(
      response => {
        this.stockbasements = response;
      })
  }

  public OnDelete(stockbasementId: Stockbasement): void {
    this.stockbasementService
      .deleteStockBasement(stockbasementId)
      .subscribe(result => this.stockbasements = this.stockbasements!!
        .filter((stockbasement) => stockbasement.id !== stockbasementId.id));
  }

  ngOnDestroy() {
    if (this.stockbasementsSubscription) {
      this.stockbasementsSubscription.unsubscribe();
    }
  }
}
