import { Component, OnInit } from '@angular/core';
import {Stockgarage} from "../stockgarage";
import {ActivatedRoute, Router} from "@angular/router";
import {StockgarageService} from "../stockgarage.service";

@Component({
  selector: 'app-stockgarageform',
  templateUrl: './stockgarageform.component.html',
  styleUrls: ['./stockgarageform.component.css']
})
export class StockgarageformComponent implements OnInit {

  public stockgarage: Stockgarage = {
    productSymbol: "",
    productName: "",
    quantity: 0,
    locationName: "",
  }


  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private stockgarageService: StockgarageService) {
  }

  onSubmit() {
    this.stockgarageService.save(this.stockgarage)
      .subscribe(result => this.gotoStockGarageList());
  }

  gotoStockGarageList() {
    this.router.navigate(['/stockgarage']);
  }


  ngOnInit(): void {
  }

}
