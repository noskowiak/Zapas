import { Component, OnInit } from '@angular/core';
import {Stockbasement} from "../stockbasement";
import {StockbasementService} from "../stockbasement.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-stockbasementform',
  templateUrl: './stockbasementform.component.html',
  styleUrls: ['./stockbasementform.component.css']
})
export class StockbasementformComponent implements OnInit {

  public stockbasement: Stockbasement = {
    productSymbol: "",
    productName: "",
    quantity: 0,
    locationName: "",
  }


  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private stockbasementService: StockbasementService) {
  }

  onSubmit() {
    this.stockbasementService.save(this.stockbasement)
      .subscribe(result => this.gotoStockBasementList());
  }

  gotoStockBasementList() {
    this.router.navigate(['/stockbasement']);
  }

  ngOnInit(): void {
  }

}
