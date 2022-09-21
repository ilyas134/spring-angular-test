import { Component, OnInit } from '@angular/core';
import { ProductsApiService } from 'src/app/service/products-api.service';
@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {
  public productList : any ;
  constructor(private api : ProductsApiService) { }

  ngOnInit(): void {
    this.api.getProduct()
    .subscribe(res=>{
      this.productList = res;
       console.log(this.productList[0].images[0].url)
      console.log(this.productList)
    });
  }
}
