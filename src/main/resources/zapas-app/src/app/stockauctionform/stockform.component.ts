import { Component, OnInit } from '@angular/core';
import {Stockauction} from "../stockauction";
import {ActivatedRoute, Router} from "@angular/router";
import {StockauctionService} from "../stockauction.service";

@Component({
  selector: 'app-stockform',
  templateUrl: './stockform.component.html',
  styleUrls: ['./stockform.component.css']
})
export class StockformComponent implements OnInit {

  public stockauction: Stockauction = {
    productSymbol: "",
    productName: "",
    quantity: 0,
    locationName: "",
  }

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private stockauctionService: StockauctionService) {
  }

  onSubmit() {
    this.stockauctionService.save(this.stockauction)
      .subscribe(result => this.gotoStockAuctionList());
  }

  gotoStockAuctionList() {
    this.router.navigate(['/stockauction']);
  }

  ngOnInit(): void {
  }

}
